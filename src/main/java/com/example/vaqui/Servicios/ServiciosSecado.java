package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.Engorde;
import com.example.vaqui.Entidad.General;
import com.example.vaqui.Entidad.Lechera;
import com.example.vaqui.Entidad.Secado;
import com.example.vaqui.Repositorio.GeneralRepository;
import com.example.vaqui.Repositorio.LecherasRepository;
import com.example.vaqui.Repositorio.SecadoRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ServiciosSecado {
    SecadoRepository repository;
    GeneralRepository genrepository;


    public ServiciosSecado(SecadoRepository repository, GeneralRepository genrepository){
        this.repository = repository;
        this.genrepository = genrepository;
    }

    public ArrayList<Secado> listarSecadoCodigo(){
        return (ArrayList<Secado>) repository.findAll();
    }


    public JSONArray listarSecado(){
        JSONArray jsonArray = new JSONArray();
        List<Secado> secados = repository.findAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (Secado secado : secados) {
            int id = secado.getId_secado().getId();
            Date fechaUltiParto = secado.getFecha_ultParto();
            Double peso = secado.getPeso_kilos();
            Date fechaRevi = secado.getFecha_revision();
            Date fechaUltiOrdeno = secado.getFecha_ultimoOrdeno();
            String categoria = secado.getCategoria();

            String fechaUltiPartoString = dateFormat.format(fechaUltiParto);
            String fechaReviString = dateFormat.format(fechaRevi);
            String fechaOrdenoString = dateFormat.format(fechaUltiOrdeno);


            JSONObject jsonObject = new JSONObject();

            try {
                jsonObject.put("id", id);
                jsonObject.put("fecha_ultParto", fechaUltiPartoString);
                jsonObject.put("peso_kilos", peso);
                jsonObject.put("fecha_revision", fechaReviString);
                jsonObject.put("fecha_ultimoOrdeno", fechaOrdenoString);
                jsonObject.put("categoria", categoria);

                jsonArray.put(jsonObject);

            } catch (JSONException e){System.out.println(e);}
        }
        return jsonArray;
    }

   public String agregarSecado(Secado secado, Integer id){

        String mensaje = "Bovino secado no ingresado";
        General general = genrepository.findById(id).get();

        if (genrepository.existsById(id) && general.getGenero().equals("femenino")){

            Date fechaUltiParto = secado.getFecha_ultParto();
            Double peso = secado.getPeso_kilos();
            Date fechaRevi = secado.getFecha_revision();
            Date fechaUltiOrdeno = secado.getFecha_ultimoOrdeno();
            String categoria = secado.getCategoria();

            Secado seca = new Secado(general,fechaUltiParto,peso,fechaRevi,fechaUltiOrdeno,categoria);
            repository.save(seca);

            mensaje = "Bovino en secado agregado con exito";

        }else {mensaje = "Error al ingresar bovino en secado";}

        return mensaje;
   }

    public Secado buscarSecadoId(Integer id){return repository.buscarPorIdSecado(id);}
    public String eliminarSecado(Integer id){
        String mensaje = "No se puede borrar el bovino Gestacion";

        Secado secado = repository.buscarPorIdSecado(id);
        Integer codigo= secado.getCodigo();

        if (repository.existsById(codigo)){
            repository.deleteById(codigo);
            mensaje = "Bovino gestacion borrado con exito";

        }else {mensaje = "Error al borrar el bovino gestacion";}

        return mensaje;
    }

    public String actualizarSecado(Secado secado, Integer id){
        String mensaje = "No se puede actualizar el bovino en secado";

        Secado seca = repository.buscarPorIdSecado(id);
        Integer codigo = seca.getCodigo();

        if (repository.existsById(codigo)){
            seca.setFecha_revision(secado.getFecha_revision());
            seca.setFecha_ultParto(secado.getFecha_ultParto());
            seca.setFecha_ultimoOrdeno(secado.getFecha_ultimoOrdeno());
            seca.setPeso_kilos(secado.getPeso_kilos());
            repository.save(seca);

            mensaje = "Informacion actualizada del bovino en secado con exito";

        }else {mensaje = "Error al actualizar informacion del bovino en secado";}

        return mensaje;
    }

}

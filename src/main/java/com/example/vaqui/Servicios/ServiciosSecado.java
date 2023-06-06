package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.Engorde;
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



    public String agregarSecado(Secado secado){
        repository.save(secado);
        return "Se ingreso esta vaquita con exito";
    }


    public String eliminarSecado(int id){
        String mensaje = "Error al eliminar";
        if (repository.existsById(id)){
            repository.deleteById(id);
            mensaje = "Eliminacion exitosa";
        }
        return mensaje;
    }


   public String actualizarSecado(Secado secado){
       String mensaje = "Error al actualizaar";
       if (repository.existsById(secado.getId_secado().getId())){
           repository.save(secado);
           mensaje = "Se actualizo exitosamente";
       }
       return mensaje;
   }

}

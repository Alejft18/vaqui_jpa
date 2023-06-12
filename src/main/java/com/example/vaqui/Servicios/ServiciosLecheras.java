package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.General;
import com.example.vaqui.Entidad.Gestacion;
import com.example.vaqui.Entidad.Lechera;
import com.example.vaqui.Repositorio.GeneralRepository;
import com.example.vaqui.Repositorio.LecherasRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ServiciosLecheras {

    LecherasRepository repository;
    GeneralRepository genrepository;



    public ServiciosLecheras(LecherasRepository repository, GeneralRepository genrepository){
        this.repository = repository;
        this.genrepository = genrepository;
    }

    public JSONArray listarLecharas(){
        JSONArray jsonArray = new JSONArray();
        List<Lechera> lecheras = repository.findAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (Lechera lechera : lecheras) {
            int id = lechera.getId_lecheras().getId();
            Double litro = lechera.getLitros_producidos();
            Date fechaOrdeno = lechera.getFecha_ordeno();
            Double peso = lechera.getPeso_kilos();
            Date fechaRevi = lechera.getFecha_revision();
            Date fechaParto = lechera.getFecha_parto();
            int partos = lechera.getCant_partos();
            String categoria = lechera.getCategoria();

            String fecha1String = dateFormat.format(fechaOrdeno);
            String fecha2String = dateFormat.format(fechaRevi);
            String fecha3String = dateFormat.format(fechaParto);


            JSONObject jsonObject = new JSONObject();

            try {
                jsonObject.put("id", id);
                jsonObject.put("litro_producidos", litro);
                jsonObject.put("fecha_ordeno", fecha1String);
                jsonObject.put("peso_kilos", peso);
                jsonObject.put("fecha_revision", fecha2String);
                jsonObject.put("fecha_parto", fecha3String);
                jsonObject.put("cant_partos", partos);
                jsonObject.put("categoria", categoria);

                jsonArray.put(jsonObject);

            } catch (JSONException e){System.out.println(e);}
        }
        return jsonArray;
    }

    public ArrayList<Lechera> listarLecherasCodigo(){
        return (ArrayList<Lechera>) repository.findAll();
    }

    public String agregarLechera(Lechera lechera, Integer id){
        String mensaje = "Vaca lechera no ingresada";
        General general = genrepository.findById(id).get();

        if (genrepository.existsById(id) && general.getGenero().equals("femenino")){

            Double litro = lechera.getLitros_producidos();
            Date fechaOrdeno = lechera.getFecha_ordeno();
            Double peso = lechera.getPeso_kilos();
            Date fechaRevi = lechera.getFecha_revision();
            Date fechaParto = lechera.getFecha_parto();
            int partos = lechera.getCant_partos();
            String categoria = lechera.getCategoria();

            Lechera leche = new Lechera(general,litro,fechaOrdeno,peso,fechaRevi,fechaParto,partos,categoria);
            repository.save(leche);

            mensaje = "Vaca lechera ingresada con exito";

        }else {mensaje = "Error al ingresar Vaca lechera";}

        return mensaje;
    }


    public Lechera buscarLecherasId(Integer id){return repository.buscarPorIdLecheras(id);}
    public String eliminarLechera(Integer id){
        String mensaje = "No se puede borrar el bovino Gestacion";

        Lechera lechera = repository.buscarPorIdLecheras(id);
        Integer codigo= lechera.getCodigo();

        if (repository.existsById(codigo)){
            repository.deleteById(codigo);
            mensaje = "Bovino gestacion borrado con exito";

        }else {mensaje = "Error al borrar el bovino gestacion";}

        return mensaje;
    }

    public String actualizarLecheras(Lechera lechera, Integer id){
        String mensaje = "No se puede actualizar el bovino egorde";

        Lechera leche = repository.buscarPorIdLecheras(id);
        Integer codigo = leche.getCodigo();

        if (repository.existsById(codigo)){
            leche.setCant_partos(lechera.getCant_partos());
            leche.setFecha_ordeno(lechera.getFecha_ordeno());
            leche.setFecha_parto(lechera.getFecha_parto());
            leche.setFecha_revision(lechera.getFecha_revision());
            leche.setLitros_producidos(lechera.getLitros_producidos());
            leche.setPeso_kilos(lechera.getPeso_kilos());
            repository.save(leche);

            mensaje = "Informacion actualizada del bovino engorde con exito";

        }else {mensaje = "Error al actualizar informacion del bovino engorde";}

        return mensaje;
    }


//    public String actualizarLecheras(Lechera lechera){
//        String mensaje = "Error al actualizar";
//        if (repository.existsById(lechera.getId())){
//            repository.save(lechera);
//            mensaje = "Se actualizo exitosamente";
//        }
//        return mensaje;
//    }


}

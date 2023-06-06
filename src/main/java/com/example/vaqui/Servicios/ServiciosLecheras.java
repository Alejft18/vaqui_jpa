package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.General;
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
            Double litro = lechera.getLitro_Producidos();
            Date fecha1 = lechera.getFecha_ordeno();
            Double peso = lechera.getPeso_kilos();
            Date fecha2 = lechera.getFecha_revision();
            Date fecha3 = lechera.getFecha_parto();
            int partos = lechera.getCant_partos();
            String categoria = lechera.getCategoria();

            String fecha1String = dateFormat.format(fecha1);
            String fecha2String = dateFormat.format(fecha2);
            String fecha3String = dateFormat.format(fecha3);


            JSONObject jsonObject = new JSONObject();

            try {
                jsonObject.put("id", id);
                jsonObject.put("litro", litro);
                jsonObject.put("fecha1", fecha1String);
                jsonObject.put("peso", peso);
                jsonObject.put("fecha2", fecha2String);
                jsonObject.put("fecha3", fecha3String);
                jsonObject.put("partos", partos);
                jsonObject.put("categoria", categoria);

                jsonArray.put(jsonObject);

            } catch (JSONException e){System.out.println(e);}
        }
        return jsonArray;
    }

    public ArrayList<Lechera> listarLecheras(){
        return (ArrayList<Lechera>) repository.findAll();
    }

    public String agregarLecheras(Lechera lechera){
        repository.save(lechera);
        return "Se ingreso esta vaquita lechera con exito";
    }


    public String eliminarLecheras(int id){
        String mensaje = "Error al eliminar";
        if (repository.existsById(id)){
            repository.deleteById(id);
            mensaje = "Eliminacion exitosa";
        }
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

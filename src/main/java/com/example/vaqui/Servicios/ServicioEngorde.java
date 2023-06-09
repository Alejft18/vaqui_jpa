package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.Engorde;

import com.example.vaqui.Entidad.General;
import com.example.vaqui.Repositorio.EngordeRepository;
import com.example.vaqui.Repositorio.GeneralRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ServicioEngorde {
    EngordeRepository repository;
    GeneralRepository genrepository;


    public ServicioEngorde(EngordeRepository repository, GeneralRepository genrepository) {
        this.repository = repository;
        this.genrepository = genrepository;
    }


    public ArrayList<Engorde> listarEngordeCodigo(){
        return (ArrayList<Engorde>) repository.findAll();
    }

    public JSONArray listarEngorde(){
        JSONArray jsonArray = new JSONArray();
        List<Engorde> engordes = repository.findAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (Engorde engorde : engordes) {
            int id = engorde.getId_engorde().getId();
            Double peso = engorde.getPeso_kilos();
            Date fechaRevi = engorde.getFecha_revision();
            String alimento = engorde.getAlimento();
            String categoria = engorde.getCategoria();

            String fechaReviString = dateFormat.format(fechaRevi);

            JSONObject jsonObject = new JSONObject();

            try {
                jsonObject.put("id", id);
                jsonObject.put("peso_kilos", peso);
                jsonObject.put("fecha_revision", fechaReviString);
                jsonObject.put("alimento",alimento);
                jsonObject.put("categoria", categoria);

                jsonArray.put(jsonObject);

            } catch (JSONException e){System.out.println(e);}
        }
        return jsonArray;
    }

    public String agregarEngorde(Engorde engorde, Integer id){
        String mensaje = "Bovino engorde no ingresado";
        General general = genrepository.findById(id).get();

        if(genrepository.existsById(id)){

            Double peso = engorde.getPeso_kilos();
            Date fechaRevi = engorde.getFecha_revision();
            String alimento = engorde.getAlimento();
            String categoria = engorde.getCategoria();

            Engorde engo= new Engorde(general,peso,fechaRevi,alimento,categoria);
            System.out.println(engo);
            repository.save(engo);

            mensaje = "Bovino engorde ingresado con exito";

        }else {mensaje = "Error al guardar el bovino de engorde";}

        return mensaje;
    }
}


    /*public String agregarEngorde(Engorde engorde, int id_Engorde){

        General Gen = genrepository.findById(id_Engorde).get();

        if (genrepository.findById(id_Engorde).isPresent()){
            engorde.setId_engorde(Gen);
            repository.save(engorde);
            return "Se ingreso esta vaquita con exito";
        }
        return "El bovino no existe";
    }

    public String eliminarEngorde(Integer id){
        String mensaje = "Error al eliminar";
        if (repository.existsById(id)) {
            repository.deleteById(id);
            mensaje = "Se elimino correctamente al administrador";
        }
        return mensaje;
    }*/

    /*public String actualizarEngorde(Engorde engorde){
        String mensaje = "Error al actualizar la informacion";
        if (repository.existsById(engorde.getTbl_general())){
            repository.save(engorde);
            mensaje ="Se actualizo correctamente la información";
        }
        return mensaje;
    }*/

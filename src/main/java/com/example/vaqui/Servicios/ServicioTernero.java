package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.Engorde;
import com.example.vaqui.Entidad.Ternero;
import com.example.vaqui.Repositorio.GeneralRepository;
import com.example.vaqui.Repositorio.TerneroRepository;
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
public class ServicioTernero {
    TerneroRepository repository;
    GeneralRepository genrepository;


    public ServicioTernero(TerneroRepository repository, GeneralRepository genrepository){
        this.repository = repository;
        this.genrepository = genrepository;
    }

    public ArrayList<Ternero> listarTerneroCodigo(){
        return (ArrayList<Ternero>) repository.findAll();
    }

    public JSONArray listarTernero(){
        JSONArray jsonArray = new JSONArray();
        List<Ternero> terneros = repository.findAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (Ternero ternero : terneros) {
            int id = ternero.getId_terneros().getId();
            int id_madre = ternero.getId_madre().getId();
            Double peso = ternero.getPeso_kilos();
            Date fechaRevi = ternero.getFecha_revision();
            String categoria = ternero.getCategoria();

            String fechaReviString = dateFormat.format(fechaRevi);

            JSONObject jsonObject = new JSONObject();

            try {
                jsonObject.put("id", id);
                jsonObject.put("id_madre",id_madre);
                jsonObject.put("peso_kilos", peso);
                jsonObject.put("fecha_revision", fechaReviString);
                jsonObject.put("categoria", categoria);

                jsonArray.put(jsonObject);

            } catch (JSONException e){System.out.println(e);}
        }
        return jsonArray;
    }

    public String agregarTernero(Ternero ternero){
        repository.save(ternero);
        return "Ingreso exitoso";
    }

    public String eliminarTernero (int id){
        String mensaje = "Error al eliminar";
        if (repository.existsById(id)) {
            repository.deleteById(id);
            mensaje = "Se elimino correctamente";
        }
        return mensaje;
    }

    /*public String actualizarTernero(Ternero ternero){
        String mensaje = "Error al actualizar";
        if (repository.existsById(ternero.getId())){
            repository.save(ternero);
            mensaje ="Se actualizo correctamente";
        }
        return mensaje;
    }*/
}

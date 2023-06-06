package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.Engorde;
import com.example.vaqui.Entidad.Ternero;
import com.example.vaqui.Entidad.Toro;
import com.example.vaqui.Repositorio.GeneralRepository;
import com.example.vaqui.Repositorio.TerneroRepository;
import com.example.vaqui.Repositorio.ToroRepository;
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
public class ServicioToro {
    ToroRepository repository;
    GeneralRepository genrepository;


    public ServicioToro(ToroRepository repository, GeneralRepository genrepository){
        this.repository = repository;
        this.genrepository = genrepository;
    }

    public ArrayList<Toro> listarTorosCodigo(){
        return (ArrayList<Toro>) repository.findAll();
    }

    public JSONArray listarToros(){
        JSONArray jsonArray = new JSONArray();
        List<Toro> toros = repository.findAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (Toro toro : toros) {
            int id = toro.getId_toros().getId();
            Double peso = toro.getPeso_kilos();
            Date fechaExtraccion = toro.getFecha_extraccion();
            int vacasMontadas = toro.getVacas_montadas();
            Date fechaRevi = toro.getFecha_Revision();
            String categoria = toro.getCategoria();

            String fechaReviString = dateFormat.format(fechaRevi);
            String fechaExtraString = dateFormat.format(fechaExtraccion);

            JSONObject jsonObject = new JSONObject();

            try {
                jsonObject.put("id", id);
                jsonObject.put("fecha_revision",fechaExtraString);
                jsonObject.put("vacas_montadas",vacasMontadas);
                jsonObject.put("peso_kilos", peso);
                jsonObject.put("fecha_revision", fechaReviString);
                jsonObject.put("categoria", categoria);

                jsonArray.put(jsonObject);

            } catch (JSONException e){System.out.println(e);}
        }
        return jsonArray;
    }


    public String agregarToro(Toro toro){
        String mensaje = "Error al ingresar el toro";

        try {
            repository.save(toro);
            mensaje = "Ingreso exitoso";
        } catch (Exception e) {
            mensaje = "Error al guardar el toro: " + e.getMessage();
        }

        return mensaje;
    }

    public String eliminarToro(int id){
        String mensaje = "Error al eliminar";
        if (repository.existsById(id)) {
            repository.deleteById(id);
            mensaje = "Se elimino correctamente";
        }
        return mensaje;
    }



    /*public String actualizarToro(Toro toro){
        String mensaje = "Error al actualizar";
        if (repository.existsById(toro.getId())){
            repository.save(toro);
            mensaje ="Se actualizo correctamente";
        }
        return mensaje;
    }*/
}

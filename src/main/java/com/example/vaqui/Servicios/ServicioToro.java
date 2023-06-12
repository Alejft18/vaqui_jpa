package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.Engorde;
import com.example.vaqui.Entidad.General;
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
            Date fechaRevi = toro.getFecha_revision();
            String categoria = toro.getCategoria();

            String fechaReviString = dateFormat.format(fechaRevi);
            String fechaExtraString = dateFormat.format(fechaExtraccion);

            JSONObject jsonObject = new JSONObject();

            try {
                jsonObject.put("id", id);
                jsonObject.put("fecha_extraccion",fechaExtraString);
                jsonObject.put("vacas_montadas",vacasMontadas);
                jsonObject.put("peso_kilos", peso);
                jsonObject.put("fecha_revision", fechaReviString);
                jsonObject.put("categoria", categoria);

                jsonArray.put(jsonObject);

            } catch (JSONException e){System.out.println(e);}
        }
        return jsonArray;
    }


    public String agregarToro(Toro toro, Integer id){
        String mensaje = "no se ingresó el toro";
        General general = genrepository.findById(id).get();

        if (genrepository.existsById(id) && general.getGenero().equals("masculino")){

            Double peso = toro.getPeso_kilos();
            Date fechaExtraccion = toro.getFecha_extraccion();
            int vacasMontadas = toro.getVacas_montadas();
            Date fechaRevi = toro.getFecha_revision();
            String categoria = toro.getCategoria();

            Toro tor = new Toro(general,peso,fechaExtraccion,vacasMontadas,fechaRevi,categoria);
            repository.save(tor);

            mensaje = "Toro ingresado con exito";
        }else {mensaje = "Error al ingresar al toro";}

        return mensaje;
    }

    public Toro buscarToroId(Integer id){return repository.buscarPorIdToro(id);}
    public String eliminarToro(Integer id){
        String mensaje = "No se puede borrar el bovino Gestacion";

        Toro toro = repository.buscarPorIdToro(id);
        Integer codigo= toro.getCodigo();

        if (repository.existsById(codigo)){
            repository.deleteById(codigo);
            mensaje = "Bovino gestacion borrado con exito";

        }else {mensaje = "Error al borrar el bovino gestacion";}

        return mensaje;
    }

    public String actualizarToro(Toro toro, Integer id){
        String mensaje = "No se puede actualizar el bovino egorde";

        Toro semental = repository.buscarPorIdToro(id);
        Integer codigo = semental.getCodigo();

        if (repository.existsById(codigo)){
            semental.setFecha_revision(toro.getFecha_revision());
            semental.setFecha_extraccion(toro.getFecha_extraccion());
            semental.setPeso_kilos(toro.getPeso_kilos());
            semental.setVacas_montadas(toro.getVacas_montadas());
            repository.save(semental);

            mensaje = "Informacion actualizada del bovino engorde con exito";

        }else {mensaje = "Error al actualizar informacion del bovino engorde";}

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

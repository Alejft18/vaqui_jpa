package com.example.vaqui.Servicios;

import com.example.vaqui.Entidad.Engorde;
import com.example.vaqui.Entidad.General;
import com.example.vaqui.Entidad.Gestacion;
import com.example.vaqui.Repositorio.EngordeRepository;
import com.example.vaqui.Repositorio.GeneralRepository;
import com.example.vaqui.Repositorio.GestacionRepository;
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
public class ServicioGestacion {
    GestacionRepository repository;
    GeneralRepository genrepository;

    public ServicioGestacion(GestacionRepository repository, GeneralRepository genrepository){
        this.repository = repository;
        this.genrepository = genrepository;
    }

    public ArrayList<Gestacion> listarGestacionCodigo(){
        return (ArrayList<Gestacion>) repository.findAll();
    }

    public JSONArray listarGestacion(){
        JSONArray jsonArray = new JSONArray();
        List<Gestacion>gestaciones = repository.findAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (Gestacion gestacion: gestaciones) {
            int id = gestacion.getId_gestacion().getId();
            Double peso = gestacion.getPeso_kilos();
            Date fechaInsemi = gestacion.getFecha_inseminacion();
            Date fechaAproxParto = gestacion.getFecha_aproxParto();
            Date fechaUltiParto = gestacion.getFecha_aproxParto();
            Date fechaRevi = gestacion.getFecha_revision();
            String categoria = gestacion.getCategoria();

            String fecha1= dateFormat.format(fechaInsemi);
            String fecha2= dateFormat.format(fechaAproxParto);
            String fecha3= dateFormat.format(fechaUltiParto);
            String fecha4= dateFormat.format(fechaRevi);



            JSONObject jsonObject = new JSONObject();
             try {
                 jsonObject.put("id",id);
                 jsonObject.put("peso_kilos",peso);
                 jsonObject.put("fecha_inseminacion", fecha1);
                 jsonObject.put("fecha_aproxParto",fecha2);
                 jsonObject.put("fecha_ultimoParto",fecha3);
                 jsonObject.put("fecha_revision",fecha4);
                 jsonObject.put("categoria",categoria);

                 jsonArray.put(jsonObject);

             }catch (JSONException e){System.out.println(e);}
        }

        return jsonArray;
    }

    public String agregarGestacion(Gestacion gestacion, Integer id){
        String mensaje = "Bovino en gestacion no ingresado";

        General general = genrepository.findById(id).get();

        if (genrepository.existsById(id) && general.getGenero().equals("femenino")){
            Double peso = gestacion.getPeso_kilos();
            Date fechaInsemi = gestacion.getFecha_inseminacion();
            Date fechaAproxParto = gestacion.getFecha_aproxParto();
            Date fechaUltiParto = gestacion.getFecha_aproxParto();
            Date fechaRevi = gestacion.getFecha_revision();
            String categoria = gestacion.getCategoria();

            Gestacion ges= new Gestacion(general,peso,fechaInsemi,fechaAproxParto,fechaUltiParto,fechaRevi,categoria);
            repository.save(ges);

            mensaje = "Bovino en gestacion ingresado con exito";

        }else {mensaje = "Error al ingresar Bovino en gestacion";}

        return mensaje;
    }


}

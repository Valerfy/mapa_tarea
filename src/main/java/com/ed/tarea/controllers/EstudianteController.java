package com.ed.tarea.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ed.tarea.model.Estudiante;

@Controller 
public class EstudianteController {
    private static Map<String,Estudiante> estudiantes = new HashMap<>();
    static {
        Estudiante estudiante1 = new Estudiante("Pepe", "Perales", 18, "1324", "Ingeniería de Sistemas");
        Estudiante estudiante2 = new Estudiante("Carlos", "Mamani", 19, "12345", "Ingeniería industrial");
        Estudiante estudiante3 = new Estudiante("Mat", "Val", 19, "123456", "Ingeniería Biomedica");
        estudiantes.put(estudiante1.getCodigo(), estudiante1);
        estudiantes.put(estudiante2.getCodigo(), estudiante2);
        estudiantes.put(estudiante3.getCodigo(), estudiante3);

    }
    @GetMapping("/estudiantes")
    public ResponseEntity<Object> getEstudiantes(){
        return new ResponseEntity<>(estudiantes.values(), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Object> registrarEstudiante(@RequestBody Estudiante est) {
    estudiantes.put(est.getCodigo(), est);
    return new ResponseEntity<>("Estudiante registrado correctamente"+est.getCodigo(), HttpStatus.CREATED);
}
}

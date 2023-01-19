package net.nndff.bautismospring.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

    @GetMapping("/holaMundo/{usuario}")
    public String saludo(@PathVariable String usuario) {
        return "Hola usuario " + usuario;
    }

    @GetMapping("/holaMundo/")
    public String saludoclasido(){
        return "Hola mundo sin parámetros por path...";
    }

    @GetMapping("/sumar/{numeroA}/{numeroB}")
    public String SUMAR(@PathVariable int numeroA, @PathVariable int numeroB) {
        int total = numeroA + numeroB;
        return "la suma de " + numeroA + " mas " + numeroB + " da como resultado " + total;
    }
}

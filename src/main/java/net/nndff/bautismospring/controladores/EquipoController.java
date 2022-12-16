package net.nndff.bautismospring.controladores;

import net.nndff.bautismospring.modelo.Equipo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EquipoController {
    ArrayList<Equipo> equipos = new ArrayList<>(
            // List.of ¡¡¡ buscar documentación... es la primera vez que la uso, o es que no me acuerdo?
            List.of(
                    new Equipo("Argentina", "Conmebol"),
                    new Equipo("España", "UEFA"),
                    new Equipo("Marruecos", "CAF"),
                    new Equipo("Uruguay", "Conmebol"),
                    new Equipo("Croacia", "UEFA")
            )
    );

    @GetMapping("/equipos")
    public ArrayList<Equipo> listarTodos() {
        return equipos;
    }

    @GetMapping("/equipos/{nombre}")
    public Equipo recuperarEquipoPorNombre(@PathVariable String nombre){
        for (Equipo equipo: equipos){
            if (equipo.getNombrePais().equalsIgnoreCase(nombre)){
                return equipo;
            }
        }
        return null;
    }

}


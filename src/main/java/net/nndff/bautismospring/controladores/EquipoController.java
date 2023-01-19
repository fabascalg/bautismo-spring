package net.nndff.bautismospring.controladores;

import net.nndff.bautismospring.modelo.Equipo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/equipos")
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

    @GetMapping
    public ArrayList<Equipo> listarTodos() {
        return equipos;
    }

    @GetMapping("/{nombre}")
    public Equipo recuperarEquipoPorNombre(@PathVariable String nombre) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombrePais().equalsIgnoreCase(nombre)) {
                return equipo;
            }
        }
        return null;
    }

    @PostMapping
    public void crearEquipo(@RequestBody Equipo equipo){
        equipos.add(equipo);
    }

    @DeleteMapping("/{nombre}")
    public void eliminarEquipo(@PathVariable String nombre) {
        /* así lo hizo la primera vez, pero no iba bien...
        for (Equipo equipo: equipos){
            if (equipo.getNombrePais().equalsIgnoreCase(nombre)){
                equipos.remove(equipo);
            }
        }
        * el que viene a continuación funciona perfectamente
         */
        Optional<Equipo> optEquipo = equipos.stream().filter(equipo -> equipo.getNombrePais().equalsIgnoreCase(nombre)).findFirst();
        if (optEquipo.isPresent()){
            equipos.remove(optEquipo.get());
        }
    }

    @PutMapping
    public String modificarEquipo(@RequestBody Equipo equipoModif){
        for (Equipo equipo: equipos){
            // encontro el mismo nombre pero si hay un cambio entre mayúsculas o minúsculas, lo va a guardar
            // en el nombre, me refiero
            if (equipo.getNombrePais().equalsIgnoreCase(equipoModif.getNombrePais())){
                equipo.setNombrePais(equipoModif.getNombrePais());
                equipo.setConf(equipoModif.getConf());
                equipo.setRankingFifa(equipoModif.getRankingFifa());
                return "el registro ha sido modificado";
            }
        }
        return "el registro no se ha encontrado";

    }

    @GetMapping("/jugar/{equipoA}/{equipoB}")
    public String jugar(@PathVariable String equipoA,@PathVariable String equipoB){
        Random random = new Random();
        int golesA = random.nextInt(10);
        int golesB = random.nextInt(4);
        return "Equipo " + equipoA + "(" + golesA + ") - EquipoB " +  equipoB + "(" + golesB + ")";
    }

}


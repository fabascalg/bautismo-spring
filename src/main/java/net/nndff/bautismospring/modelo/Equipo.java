package net.nndff.bautismospring.modelo;

import lombok.Data;
import lombok.NonNull;

@Data
/*
    @ ToString(exclude="rankingFifa")
 */
public class Equipo {

    @NonNull
    private String nombrePais;
    @NonNull
    private String conf;
    private int rankingFifa;

}

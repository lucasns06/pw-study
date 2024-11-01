package br.com.etechoracio.study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_REL_MONITOR_DISPONIBILIDADE")
public class Rel_Monitor_Disponibilidade {

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_MONITOR")
    Monitor monitor;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_DISPONIBILIDADE")
    Disponibilidade disponibilidade;


}

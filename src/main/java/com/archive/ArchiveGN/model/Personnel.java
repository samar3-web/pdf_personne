package com.archive.ArchiveGN.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "personnel")
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersonnel;

    private int matricule;
    private String nom;
    private String pnom;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate datenais;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate daterecrut;
    private String cin;
    private String cnrps;
    private String rib;
    private String etat;
    private String decisionRecrutement;
    private byte[] pdfPers;



    @OneToMany(mappedBy = "personnel", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnore
    private List<DemandeMutation> demandeMutationsliee;





}

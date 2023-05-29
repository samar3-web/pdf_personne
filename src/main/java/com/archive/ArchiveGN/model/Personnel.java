package com.archive.ArchiveGN.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "personnel")
public class Personnel {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String matricule ;

    private String prenom;

    private String pnom;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate datenaiss = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate daterecrute = LocalDate.now();
    private String decisionRecrutement;
    private String cin;
    private String cnrps;
    private String rib;
    private String etat;

    public Personnel() {
    }



    public List<DemandeMutation> getDemandeMutationsliee() {
        return demandeMutationsliee;
    }
    public void setDemandeMutationsliee(List<DemandeMutation> demandeMutationsliee) {
        this.demandeMutationsliee = demandeMutationsliee;
    }

    @OneToMany(mappedBy="personnel",fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnore
    private List<DemandeMutation>demandeMutationsliee;



    public String getId() {
        return id;
    }



    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPnom() {
        return pnom;
    }

    public void setPnom(String pnom) {
        this.pnom = pnom;
    }

    public LocalDate getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(LocalDate datenaiss) {
        this.datenaiss = datenaiss;
    }

    public LocalDate getDaterecrute() {
        return daterecrute;
    }

    public void setDaterecrute(LocalDate daterecrute) {
        this.daterecrute = daterecrute;
    }

    public String getDecisionRecrutement() {
        return decisionRecrutement;
    }

    public void setDecisionRecrutement(String decisionRecrutement) {
        this.decisionRecrutement = decisionRecrutement;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getCnrps() {
        return cnrps;
    }

    public void setCnrps(String cnrps) {
        this.cnrps = cnrps;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }


}
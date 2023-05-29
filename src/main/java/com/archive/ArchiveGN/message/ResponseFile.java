package com.archive.ArchiveGN.message;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ResponseFile {
    private String name;
    private String url;
    private String type;
    private long size;
    private String id;
    private String prenom;
    private String matricule;
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

    public ResponseFile(String name, String url, String type, long size, String id, String prenom, String pnom, LocalDate datenaiss, LocalDate daterecrute, String decisionRecrutement, String cin, String cnrps, String rib, String etat,String matricule) {
        this.name = name;
        this.url = url;
        this.type = type;
        this.size = size;
        this.id = id;
        this.prenom = prenom;
        this.pnom = pnom;
        this.datenaiss = datenaiss;
        this.daterecrute = daterecrute;
        this.decisionRecrutement = decisionRecrutement;
        this.cin = cin;
        this.cnrps = cnrps;
        this.rib = rib;
        this.etat = etat;
        this.matricule = matricule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPnom() {
        return pnom;
    }

    public void setPnom(String pnom) {
        this.pnom = pnom;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
}
package io.getarrays.fileuploadanddownload.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "personnel")
public class Personnel {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String matricule ;
    private String name;

    private String type;

    @Lob
    private byte[] data;

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


    public Personnel(String matricule, String name, String type, byte[] data, String prenom, String pnom, LocalDate datenaiss, LocalDate daterecrute, String decisionRecrutement, String cin, String cnrps, String rib, String etat) {
        this.matricule = matricule;
        this.name = name;
        this.type = type;
        this.data = data;
        this.prenom = prenom;
        this.pnom = pnom;
        this.datenaiss = datenaiss;
        this.daterecrute = daterecrute;
        this.decisionRecrutement = decisionRecrutement;
        this.cin = cin;
        this.cnrps = cnrps;
        this.rib = rib;
        this.etat = etat;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
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
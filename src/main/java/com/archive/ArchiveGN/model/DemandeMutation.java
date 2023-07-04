package com.archive.ArchiveGN.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "demandeMutation")
public class DemandeMutation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDemandeMutation;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateinsert = LocalDate.now();

    private String datedemande;

    private String cause;
    private String decision;

    private String Dname;
    private String Dtype;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="personnel")
    private Personnel personnel;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    public DemandeMutation() {
    }



    public DemandeMutation( String cause, String decision, String name, String type, byte[] data, String datedemande,Personnel personnel,String Dname,String Dtype) {

        this.cause = cause;
        this.decision = decision;
        this.datedemande=datedemande;
        this.name = name;
        this.type = type;
        this.data = data;
        this.personnel = personnel;
        this.Dname=Dname;
        this.Dtype=Dtype;
    }

    public int getIdDemandeMutation() {
        return idDemandeMutation;
    }

    public void setIdDemandeMutation(int idDemandeMutation) {
        this.idDemandeMutation = idDemandeMutation;
    }

    public void setDateinsert(LocalDate dateinsert) {
        this.dateinsert = dateinsert;
    }




    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public LocalDate getDateinsert() {
        return dateinsert;
    }

    public void setDateDemandemutation(LocalDate dateinsert) {
        this.dateinsert = dateinsert;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public String getDtype() {
        return Dtype;
    }

    public void setDtype(String dtype) {
        Dtype = dtype;
    }
}
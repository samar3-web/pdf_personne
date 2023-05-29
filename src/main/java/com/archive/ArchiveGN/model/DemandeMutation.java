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

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date datedemande;

    private String cause;
    private String decision;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="personnel")
    private Personnel personnel;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    public DemandeMutation() {
    }

    public DemandeMutation(LocalDate dateinsert, Date datedemande, String cause, String decision, Personnel personnel, String name, String type, byte[] data) {
        this.dateinsert = dateinsert;
        this.datedemande = datedemande;
        this.cause = cause;
        this.decision = decision;
        this.personnel = personnel;
        this.name = name;
        this.type = type;
        this.data = data;
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

    public Date getDatedemande() {
        return datedemande;
    }

    public void setDatedemande(Date datedemande) {
        this.datedemande = datedemande;
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
}
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
    private String type;
    private byte[] pdfDemandeMutation;
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="personnel")
    private Personnel personnel;
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
    public byte[] getPdfDemandeMutation() {
        return pdfDemandeMutation;
    }
    public void setPdfDemandeMutation(byte[] pdfDemandeMutation) {
        this.pdfDemandeMutation = pdfDemandeMutation;
    }
    public Personnel getPersonnel() {
        return personnel;
    }
    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }
    public DemandeMutation(Date datedemande,LocalDate dateinsert, String cause, String decision, byte[] pdfDemandeMutation,
                           Personnel personnel) {
        super();
        this.dateinsert = dateinsert;
        this.datedemande=datedemande;
        this.cause = cause;
        this.decision = decision;
        this.pdfDemandeMutation = pdfDemandeMutation;
        this.personnel = personnel;
    }
    public DemandeMutation() {
        super();
        // TODO Auto-generated constructor stub
    }




}
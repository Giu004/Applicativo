package model;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ToDo {
    private String titolo;
    private String descrizione;
    private LocalDate scadenza;
    private Color sfondo;
    private String immagine;
    private String link;
    private List<String> condivisione;
    private boolean completato;

    public ToDo(String titolo) {
        this.titolo = titolo;
        this.descrizione = "";
        this.scadenza = null;
        this.sfondo = Color.WHITE;
        this.immagine = null;
        this.link = null;
        this.condivisione = new ArrayList<>();
        this.completato = false;
    }

 /* private void creaChecklist(){
        checklist = new Checklist();
    } */


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }


    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    public Color getSfondo() {
        return sfondo;
    }

    public void setSfondo(Color sfondo) {
        this.sfondo = sfondo;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<String> getCondivisione() {
        return condivisione;
    }

    public void setCondivisione(List<String> condivisione) {
        this.condivisione = condivisione;
    }

    public boolean isCompletato() {
        return completato;
    }

    public void setCompletato(boolean completato) {
        this.completato = completato;
    }

}
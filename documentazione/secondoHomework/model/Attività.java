package model;

public class Attività {
    private String NomeAttività;
    public Attività(String name) {NomeAttività=name;}
    private boolean SetAttività=false;

    public boolean StatoAttività(boolean stato){
        SetAttività=stato;
        return true;
    }

    public String GetNome (){
        return NomeAttività;
    }
    public boolean GetStato(){
        return SetAttività;
    }
}
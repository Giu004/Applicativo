package model;
import java.util.ArrayList;

public class Checklist {
    private ArrayList<Attività> c =new ArrayList<Attività>();

    public void AggiungiAttività(String name){
        Attività a= new Attività(name);
        c.add(a);
    }

    public String StampaChecklist() {
        return c.getLast().GetNome();
    }
    public ArrayList<Attività> getChecklist() {
        return c;
    }
}
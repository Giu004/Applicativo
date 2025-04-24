package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Checklist {
    protected ArrayList<Attività> checklist=new ArrayList<Attività>();
    Scanner scanner=new Scanner(System.in);
    public void AggiungiAttività(){
        String nome= new String();
        System.out.println("Inserisci il nome dell'attività");
        nome= scanner.nextLine();
        Attività a= new Attività(nome);
        checklist.add(a);
        System.out.println("Attività Aggiunta con successo");
    }
    public void RimuoviAttività(){
        System.out.println("Quale attività rimuovere?");
        int index= scanner.nextInt();
        checklist.remove(index);
        System.out.println("Attività rimossa");
    }
    public void StampaChecklist()

    {
        int i;
        for (i = 0; i < checklist.size(); i++) {
            System.out.println(checklist.get(i).NomeAttività);
        }
    }
}


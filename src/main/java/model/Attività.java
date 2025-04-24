package org.example;

public class Attività {
     protected String NomeAttività;
     public Attività(String nome) {NomeAttività=nome;}
     private boolean SetAttività=false;

     private void CompletaAttività(){
          SetAttività=true;
          System.out.println("L'attività è stata completata");
     }
}

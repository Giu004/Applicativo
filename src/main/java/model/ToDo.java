
import java.util.Scanner;



public class ToDo {
    Scanner scanner=new Scanner(System.in);
    private boolean SetToDo =false;

    private void CompletaToDo(){
        SetToDo =true;
        System.out.println("Il ToDo è stato completato");
    }
    public void TitoloToDo(){
        String titolo= new String();
        System.out.println("Inserisci il titolo del ToDo");
        titolo= scanner.nextLine();

    }


    public void ColoreSfondo(){
        String sfondo= new String();
        System.out.println("Inserisci lo sfondo del ToDo");
        sfondo= scanner.nextLine();

    }
    public void Immagine() {

        System.out.println("Inserisci l'immagine del ToDo");

    }
    public void Descrizione() {
        String presentazione = new String();
        System.out.println("Inserisci la descrizione del ToDo");
        presentazione = scanner.nextLine();
    }
    public void Data_di_scadenza() {
        String scadenza= new String();
        System.out.println("Inserisci la scadenza del ToDo");
        scadenza= scanner.nextLine();
    }
    public void LinkToDo() {
        String link= new String();
        System.out.println("Inserisci il link ad un UML correlata all'attività");
        link= scanner.nextLine();
    }
    public void ListaCondivisione() {
        String condivisione= new String();
        System.out.println("Inserisci la lista di condivizione con gli altri utenti");
        condivisione= scanner.nextLine();
    }


}
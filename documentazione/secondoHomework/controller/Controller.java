package controller;
import model.Utente;
import model.Bacheca;
import model.ToDo;
import java.awt.Color;
import java.time.LocalDate;
import java.util.List;
import model.*;
import java.util.ArrayList;


   public class Controller {


        private ToDo todo;
        Utente utente = new Utente();
        Bacheca bach = new Bacheca();

        public String getPassword() {
            return utente.getPassword();
        }

        public String getLogin() {
            return utente.getLogin();
        }
        public String getTitolo(int index)  {
            return bach.getTitolo(index);

        }


        public Controller(ToDo todo) {
            this.todo = todo;
        }

        public String getTitle() {
            return todo.getTitolo();
        }

        public void setTitle(String title) {
            todo.setTitolo(title);
        }

        public String getDescription() {
            return todo.getDescrizione();
        }

        public void setDescription(String description) {
            todo.setDescrizione(description);
        }


        public LocalDate getDueDate() {
            return todo.getScadenza();
        }

        public void setDueDate(LocalDate dueDate) {
            todo.setScadenza(dueDate);
        }

        public Color getBackgroundColor() {
            return todo.getSfondo();
        }

        public void setBackgroundColor(Color color) {
            todo.setSfondo(color);
        }

        public String getImagePath() {
            return todo.getImmagine();
        }

        public void setImagePath(String path) {
            todo.setImmagine(path);
        }

        public String getLink() {
            return todo.getLink();
        }

        public void setLink(String link) {
            todo.setLink(link);
        }

        public List<String> getSharedUsers() {
            return todo.getCondivisione();
        }

        public void setSharedUsers(List<String> users) {
            todo.setCondivisione(users);
        }

        public boolean isCompleted() {
            return todo.isCompletato();
        }

        public void setCompleted(boolean completed) {
            todo.setCompletato(completed);
        }


        public ToDo T= new ToDo("");
        public ArrayList<String> ListaAttività=new ArrayList<>();
        public Controller(){
            T.creaChecklist();
        }
        public void passaToDo(ToDo t){
            T=t;
            ListaAttività.clear();
            for(Attività s: T.getChecklist().getlist()){
                ListaAttività.add(s.GetNome());
            }
        }
        public String AddAttività(String name){
            T.getChecklist().AggiungiAttività(name);
            return "Attività Aggiunta";
        }
        public String GetNome(){
            return T.getTitolo();
        }
   }





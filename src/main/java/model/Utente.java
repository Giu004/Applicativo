package Model;

public class Utente {

    // variabili
    protected String login;
    private String password;

    //costruttore
    protected Utente(String log, String pass) {
        this.login = log;
        this.password = pass;
    }

    //metodi
    public void setLogin(String log) {
        this.login = log;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    //signIn
    protected boolean singIn(String log, String pass) {
        if (login.equals(log) && password.equals(pass)) {
            System.out.println("Accesso eseguito : benvenuto! :)");
            return true;
        } else {
            System.out.println("Accesso fallito : nome utente o password errati");
            return false;
        }
    }

    //stampa
    public void stampa() {
        System.out.println("Sono l'utente " + login+ " " + password);
    }

}
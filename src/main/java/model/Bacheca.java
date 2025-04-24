package Model;

enum Titolo {
    UNIVERSITA,
    TITOLO,
    TEMPO_LIBERO,}

    public class Bacheca {

        // variabili
        private Titolo titolo;
        private String descrizione;

        //costruttore
        public Bacheca (Titolo titolo, String descrizione){
            this.titolo = titolo;
            this.descrizione = descrizione;
        }

        //metodi
        public Titolo getTitolo (){
            return titolo;
            }

        public void setTitolo (Titolo titolo){
            this.titolo = titolo;
        }

        public String getDescrizone (){
            return descrizione;
            }

        public void setDescrizione (String descrizione){
                this.descrizione = descrizione;}

        public String toString(){
            return titolo + ":" + descrizione;

        }


    }



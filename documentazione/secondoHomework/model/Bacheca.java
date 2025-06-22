package model;

import javax.swing.*;
import java.awt.*;

public class Bacheca {


        private String [] titolo ;
        private String descrizione;

        public Bacheca (){
            titolo = new String[3];
            titolo[0] = "Università";
            titolo[1] = "Lavoro";
            titolo[2] = "Tempo Libero";

        }

        public String getTitolo(int index) {
            if (index >= 0 && index < titolo.length){
                return titolo[index];
            }
            else{
                throw new IllegalArgumentException("Indice non valido: " + index);
            }

        }
        public String getDescrizone (){
            return descrizione;
            }
    }



package GUI;

import controller.Controller;
import model.ToDo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Guibacheca {
    public JFrame frameChiamato;
    private JPanel pannelloprincipale;
    private JButton bottonecrea;
    private JComboBox comboBox1;
    private JPanel pannellolavoro;
    private JPanel pannellotempo;
    private JTextArea textArea1;
    private JButton eliminaButton;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextPane textPane1;
    private JPanel pannellouni;
    private JButton creaTodoButton;
    private JButton creaTodoButton1;
    private JButton creaTodoButton2;
    private String selezione;



    public Guibacheca(JFrame frameChiamante) {
        frameChiamato = new JFrame("Bacheca");
        frameChiamato.setContentPane(pannelloprincipale);
        frameChiamato.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameChiamato.pack();
        frameChiamato.setVisible(false);
        frameChiamato.setSize(1100, 700);
        frameChiamato.setLocationRelativeTo(null);




        pannellouni.setVisible(false);
        pannellolavoro.setVisible(false);
        pannellotempo.setVisible(false);

        textArea1.setLineWrap(true);
        textArea2.setLineWrap(true);
        textArea3.setLineWrap(true);

        creaTodoButton.setVisible(false);
        creaTodoButton1.setVisible(false);
        creaTodoButton2.setVisible(false);



       comboBox1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               comboBox1.setVisible(true);
              selezione = (String) comboBox1.getSelectedItem();

           }
       });
        Controller contr = new Controller();


        bottonecrea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(bottonecrea.getText().equals("Crea")){
                    eliminaButton.setVisible(true);
                }


                if(selezione.equals(contr.getTitolo(0)) && bottonecrea.getText().equals("Crea")){

                   pannellouni.setVisible(true);
                   pannellouni.revalidate();
                   pannellouni.repaint();
                   creaTodoButton.setVisible(true);
                }
                if(selezione.equals(contr.getTitolo(1)) && bottonecrea.getText().equals("Crea")){
                    pannellolavoro.setVisible(true);
                    pannellolavoro.revalidate();
                    pannellolavoro.repaint();
                    creaTodoButton1.setVisible(true);
                }
                if(selezione.equals(contr.getTitolo(2)) && bottonecrea.getText().equals("Crea")){
                    pannellotempo.setVisible(true);
                    pannellotempo.revalidate();
                    pannellotempo.repaint();
                    creaTodoButton2.setVisible(true);
                }
            }

        });

        eliminaButton.setVisible(false);


        eliminaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(selezione.equals(contr.getTitolo(0)) && eliminaButton.getText().equals("Elimina")){
                    pannellouni.setVisible(false);

                    textArea1.setText("");
                }
                if(selezione.equals(contr.getTitolo(1)) && eliminaButton.getText().equals("Elimina")){
                    pannellolavoro.setVisible(false);

                    textArea2.setText("");
                }
                if(selezione.equals(contr.getTitolo(2)) && eliminaButton.getText().equals("Elimina")){
                    pannellotempo.setVisible(false);
                    textArea3.setText("");
                }


            }
        });

        creaTodoButton.addActionListener(new ActionListener() {
            ToDoGUI todo = new ToDoGUI(frameChiamato);
            @Override
            public void actionPerformed(ActionEvent e) {
                todo.frametodo.setVisible(true);
                frameChiamato.setVisible(false);
            }


        });
        creaTodoButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ToDoGUI todo1 = new ToDoGUI(frameChiamato);
                todo1.frametodo.setVisible(true);
                frameChiamato.setVisible(false);
            }
        });
        creaTodoButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ToDoGUI todo2 = new ToDoGUI(frameChiamato);
                todo2.frametodo.setVisible(true);
                frameChiamato.setVisible(false);

            }
        });
    }
}

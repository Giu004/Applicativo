package GUI;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Guiutente {
    private JButton Accedi;
    private JPanel panelLogin;
    private JLabel todotitolo;
    private JTextField campoutente;
    private JLabel utentetxt;
    private JLabel passwordtxt;
    private JPasswordField campopassword;
    private static JFrame frameChiamante;



    public static void main (String[] args){
        frameChiamante = new JFrame("Login");
        frameChiamante.setContentPane(new Guiutente().panelLogin);
        frameChiamante.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameChiamante.pack();
        frameChiamante.setVisible(true);
        frameChiamante.setSize(1100, 700);
        frameChiamante.setLocationRelativeTo(null);


    }

    public Guiutente() {
        Accedi.addActionListener(new ActionListener() {
            Controller contr = new Controller();
            @Override
            public void actionPerformed(ActionEvent e) {
                Guibacheca bach = new Guibacheca(frameChiamante);
                if(campopassword.getText().equals(contr.getPassword()) && campoutente.getText().equals(contr.getLogin())){
                    JOptionPane.showMessageDialog(null, "Accesso eseguito : benvenuto! :)");
                bach.frameChiamato.setVisible(true);
                frameChiamante.setVisible(false); 

            }
                else{
                    JOptionPane.showMessageDialog(null, "Accesso fallito : nome utente o password errati");
                    frameChiamante.setVisible(true);
                }
        };
    });
}
}


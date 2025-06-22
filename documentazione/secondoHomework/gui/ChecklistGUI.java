package GUI;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ChecklistGUI{

    private JPanel toDoPanel;

    private JPanel panel1;
    private JTextField Titolo;
    private JButton aggiungiAttività;
    private JTextArea textArea1;
    private JPanel panel2;
    private JPanel panel3;
    private JScrollPane JScrollPane;
    private JPanel panel4;

    public static void main(String[] args) {
        JFrame frameChecklist = new JFrame("Checklist");
        frameChecklist.setContentPane(new ChecklistGUI().panel1);
        frameChecklist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameChecklist.pack();
        frameChecklist.setVisible(true);

    }

    public ChecklistGUI() {
        Controller controller = new Controller();
        Titolo.setText("Checklist di "+controller.GetNome());
        textArea1.setEditable(false);
        Titolo.setEditable(false);
        aggiungiAttività.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name="";
                while (name.isEmpty() || controller.ListaAttività.contains(name)) {
                    name = JOptionPane.showInputDialog("Inserire il nome dell'Attività");
                }
                if (name==null) {
                    return;
                }
                    controller.checklist.AggiungiAttività(name);
                    textArea1.append(controller.checklist.StampaChecklist() + "\n");
                    controller.ListaAttività.add(name);
                    final JCheckBox newcheckbox =new JCheckBox();
                    newcheckbox.setName(name);
                    newcheckbox.setBackground(Color.BLACK);
                newcheckbox.addItemListener(new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                        controller.checklist.getChecklist().get(controller.ListaAttività.indexOf(newcheckbox.getName())).StatoAttività(newcheckbox.isSelected());
                    }
                });
                    final JButton newrimuoviAttività =new JButton("-");
                    newrimuoviAttività.setName(name);
                    newrimuoviAttività.setBackground(Color.GRAY);
                    newrimuoviAttività.setForeground(Color.BLACK);
                    newrimuoviAttività.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            controller.checklist.getChecklist().remove(controller.ListaAttività.indexOf(newrimuoviAttività.getName()));
                            controller.checklist.getChecklist().trimToSize();
                            controller.ListaAttività.remove(newrimuoviAttività.getName());
                            controller.ListaAttività.trimToSize();
                            textArea1.setText(null);
                            panel3.remove(newcheckbox);
                            panel3.revalidate();
                            panel4.remove(newrimuoviAttività);
                            panel4.revalidate();
                            for(String print : controller.ListaAttività){
                                textArea1.append(print + "\n");
                            }
                            panel3.revalidate();
                            panel3.repaint();
                            panel4.revalidate();
                            panel4.repaint();
                        }
                    });
                    panel3.add(newcheckbox);
                    panel4.add(newrimuoviAttività);
            }
        }
        );
    }

    public JPanel getToDoPanel() {
        return toDoPanel;
    }

}



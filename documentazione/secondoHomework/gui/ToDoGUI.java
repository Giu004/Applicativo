package GUI;

import controller.ToDoController;
import model.ToDo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ToDoGUI {
    public JPanel toDoPanel;
    public static JFrame frametodo;

    private JTextField titoloField;
    private JTextField scadenzaField;
    private JTextField linkField;
    private JTextField condivisioneField;

    private JTextArea descrizioneArea;

    private JButton aggiornaButton;
    private JButton coloreButton;
    private JButton immagineButton;
    private JButton completatoButton;
    private JButton ChecklistButton;

    private JLabel titoloLabel;
    private JLabel scadenzaLabel;
    private JLabel immagineLabel;
    private JLabel completatoLabel;
    private JLabel CondividiLabel;
    private JLabel LinkLabel;
    private JLabel DescrizioneLabel;

    private ToDoController controller;

    public ToDoGUI(JFrame frameChiamato){
        frametodo = new JFrame("Bacheca");
        frametodo.setContentPane(toDoPanel);
        frametodo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frametodo.pack();
        frametodo.setVisible(false);
        frametodo.setSize(1100, 700);
        frametodo.setLocationRelativeTo(null);


    }

    public ToDoGUI() {
        ToDo todo = new ToDo("Titolo");
        controller = new ToDoController(todo);


        titoloLabel.setText("Titolo attuale: " + controller.getTitle());
        scadenzaLabel.setText("Scadenza: nessuna");
        completatoLabel.setText("Stato: Non completato");
        titoloField.setText(controller.getTitle());

        immagineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(toDoPanel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();

                    controller.setImagePath(selectedFile.getAbsolutePath());
                    updateImageLabel(selectedFile.getAbsolutePath());
                }
            }
        });


        aggiornaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newTitle = titoloField.getText().trim();
                String newDescription = descrizioneArea.getText().trim();
                String dueDateText = scadenzaField.getText().trim();
                String linkText = linkField.getText().trim();
                String sharedUsersText = condivisioneField.getText().trim();

                if (newTitle.isEmpty()) {
                    JOptionPane.showMessageDialog(toDoPanel,
                            "Il titolo non può essere vuoto", "Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                controller.setTitle(newTitle);
                controller.setDescription(newDescription);
                titoloLabel.setText("Titolo attuale: " + controller.getTitle());

                if (!dueDateText.isEmpty()) {
                    try {
                        LocalDate parsedDate = LocalDate.parse(dueDateText);
                        controller.setDueDate(parsedDate);
                        scadenzaLabel.setText("Scadenza: " + controller.getDueDate().toString());
                    } catch (DateTimeParseException ex) {
                        JOptionPane.showMessageDialog(toDoPanel,
                                "Formato data non valido. Usa AAAA-MM-GG.", "Errore", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } else {
                    controller.setDueDate(null);
                    scadenzaLabel.setText("Scadenza: nessuna");
                }

                controller.setLink(linkText);

                if (!sharedUsersText.isEmpty()) {
                    String[] users = sharedUsersText.split(",");
                    List<String> userList = new ArrayList<>();
                    for (String u : users) userList.add(u.trim());
                    controller.setSharedUsers(userList);
                } else {
                    controller.setSharedUsers(new ArrayList<>());
                }

                JOptionPane.showMessageDialog(toDoPanel, "ToDo aggiornato con successo!");
            }
        });


        coloreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color initialColor = controller.getBackgroundColor();
                Color chosenColor = JColorChooser.showDialog(toDoPanel, "Scegli colore sfondo", initialColor);
                if (chosenColor != null) {
                    controller.setBackgroundColor(chosenColor);
                    toDoPanel.setBackground(chosenColor);
                }
            }
        });


        completatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setCompleted(!controller.isCompleted());
                updateCompletionButton();
            }
        });


 /* ChecklistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame ChecklistFrame = new JFrame("Checklist");
                ChecklistFrame.setContentPane(new ChecklistGUI().getToDoPanel());
                ChecklistFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ChecklistFrame.pack();
                ChecklistFrame.setLocationRelativeTo(null);
                ChecklistFrame.setVisible(true);

            }
        }); */


        updateCompletionButton();
    }


    private void updateImageLabel(String path) {
        if (path == null || path.isEmpty()) {
            immagineLabel.setIcon(null);
            return;
        }
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image resized = img.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        immagineLabel.setIcon(new ImageIcon(resized));
    }

    private void updateCompletionButton() {
        boolean completed = controller.isCompleted();
        completatoButton.setText(completed ? "Completato" : "Non completato");
        completatoLabel.setText("Stato: " + (completed ? "Completato" : "Non completato"));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ToDo");
        frame.setContentPane(new ToDoGUI().toDoPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
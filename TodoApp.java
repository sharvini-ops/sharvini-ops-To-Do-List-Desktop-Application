import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TodoApp extends JFrame {
    private DefaultListModel<String> model;
    private JList<String> list;
    private JTextField input;

    public TodoApp() {
        model = new DefaultListModel<>();
        list = new JList<>(model);
        input = new JTextField(20);
        JButton addBtn = new JButton("Add");
        JButton removeBtn = new JButton("Remove");

        addBtn.addActionListener(e -> {
            if (!input.getText().isEmpty()) {
                model.addElement(input.getText());
                input.setText("");
            }
        });

        removeBtn.addActionListener(e -> {
            int index = list.getSelectedIndex();
            if (index != -1) model.remove(index);
        });

        JPanel panel = new JPanel();
        panel.add(input);
        panel.add(addBtn);
        panel.add(removeBtn);

        add(new JScrollPane(list), BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        setTitle("To-Do List");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TodoApp();
    }
}

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentInformationSystem {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private JTextField idField, nameField, ageField;

    public StudentInformationSystem() {
        frame = new JFrame("Student Information System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[]{"ID", "Name", "Age"}, 0);
        table = new JTable(model);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> addStudent());
        panel.add(addButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> deleteStudent());
        panel.add(deleteButton);

        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void addStudent() {
        String id = idField.getText();
        String name = nameField.getText();
        String age = ageField.getText();
        if (!id.isEmpty() && !name.isEmpty() && !age.isEmpty()) {
            model.addRow(new Object[]{id, name, age});
            idField.setText("");
            nameField.setText("");
            ageField.setText("");
        } else {
            JOptionPane.showMessageDialog(frame, "Please fill all fields.");
        }
    }

    private void deleteStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a row to delete.");
        }
    }

    public static void main(String[] args) {
        new StudentInformationSystem();
    }
}
package com.phonebook;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class PhoneBookUI extends JFrame {
    private JTextField nameField, phoneField;
    private JTable contactTable;
    private DefaultTableModel tableModel;

    public PhoneBookUI() {
        setTitle("Phone Agenda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        // === Top Panel: Form ===
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 5, 5, 5);
        gc.anchor = GridBagConstraints.WEST;

        JLabel nameLabel = new JLabel("Name:");
        JLabel phoneLabel = new JLabel("Phone:");

        nameField = new JTextField(15);
        phoneField = new JTextField(15);

        JButton addBtn = new JButton("Add");
        JButton clearBtn = new JButton("Clear");
        JButton deleteBtn = new JButton("Delete");

        // Layout form
        gc.gridx = 0; gc.gridy = 0; formPanel.add(nameLabel, gc);
        gc.gridx = 1; formPanel.add(nameField, gc);

        gc.gridx = 0; gc.gridy = 1; formPanel.add(phoneLabel, gc);
        gc.gridx = 1; formPanel.add(phoneField, gc);

        gc.gridx = 0; gc.gridy = 2; formPanel.add(addBtn, gc);
        gc.gridx = 1; formPanel.add(clearBtn, gc);
        gc.gridx = 2; formPanel.add(deleteBtn, gc);

        // === Table ===
        String[] columns = {"Name", "Phone"};
        tableModel = new DefaultTableModel(columns, 0);
        contactTable = new JTable(tableModel);
        JScrollPane tableScroll = new JScrollPane(contactTable);

        // === Add components to frame ===
        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.NORTH);
        add(tableScroll, BorderLayout.CENTER);

        // === Button Actions ===
        addBtn.addActionListener(e -> addContact());
        clearBtn.addActionListener(e -> clearFields());
        deleteBtn.addActionListener(e -> deleteContact());

        setVisible(true);
    }

    private void addContact() {
        String name = nameField.getText().trim();
        String phone = phoneField.getText().trim();

        if (name.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please fill in both fields.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        tableModel.addRow(new Object[]{name, phone});
        clearFields();
    }

    private void clearFields() {
        nameField.setText("");
        phoneField.setText("");
    }

    private void deleteContact() {
        int selectedRow = contactTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Please select a contact to delete.",
                    "Selection Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}

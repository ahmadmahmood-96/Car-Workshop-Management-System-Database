package com.company;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class WorkersTable extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WorkersTable frame = new WorkersTable();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public WorkersTable() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 814, 334);
        contentPane.add(scrollPane);

        JButton button = new JButton("<Back");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminMenu field = new AdminMenu();
                field.setVisible(true);
                setVisible(false);
            }
        });
        button.setBounds(720, 375, 89, 23);
        contentPane.add(button);
        setResizable(false);

        JTable table = new JTable();
        scrollPane.setViewportView(table);
        try {
            String url = "jdbc:mysql://localhost:3306/workshop";
            String uname = "root";
            String pwd = "hailhydra";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, uname, pwd);

            String query = "SELECT worker_id, first_name, last_name, " +
                    "phone_number, address, branch_id, salary, work_hours, manager_id FROM Worker";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        }
    }

}

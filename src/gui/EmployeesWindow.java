package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class EmployeesWindow extends JFrame{

    JPanel contentPane;
    Connection connection = null;

    public EmployeesWindow(){

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 797, 312);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton displayBtn = new JButton("Display Data");
        displayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        displayBtn.setBounds(20, 61, 154, 23);
        contentPane.add(displayBtn);

        JButton addData = new JButton("Add Data");
        addData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddEmployeeWindow addEmp = new AddEmployeeWindow();
                addEmp.setVisible(true);
            }
        });
        addData.setBounds(20, 95, 154, 23);
        contentPane.add(addData);


        JButton deleteBtn = new JButton("Delete");
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteBtn.setBounds(57, 226, 89, 23);
        contentPane.add(deleteBtn);

        JLabel label1 = new JLabel("Employees");
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setBounds(448, 11, 80, 33);
        contentPane.add(label1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(184, 44, 587, 221);
        contentPane.add(scrollPane);

        JTable employeeTable = new JTable();
        employeeTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPane.setViewportView(employeeTable);

        JTextField textFieldTUID = new JTextField();
        textFieldTUID.setBounds(88, 195, 86, 20);
        contentPane.add(textFieldTUID);
        textFieldTUID.setColumns(18);

        JLabel deleteLabel = new JLabel("Delete Entry");
        deleteLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        deleteLabel.setBounds(60, 170, 86, 14);
        contentPane.add(deleteLabel);

        JLabel labelTUID = new JLabel("TUID");
        labelTUID.setBounds(35, 198, 32, 14);
        contentPane.add(labelTUID);
    }

    public static void main(String[] args) {

        EmployeesWindow frame = new EmployeesWindow();
        frame.setVisible(true);
    }


}

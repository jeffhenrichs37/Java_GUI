package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;


public class EmployeesWindow extends JFrame{

    JPanel contentPane;
    Connection connection = null;
    JLabel labelTUID;
    JLabel deleteLabel;
    JTextField textFieldTUID;
    JTable employeeTable;
    JScrollPane scrollPane;
    JLabel tutors_who_work_on_this_day;
    JLabel tutors_who_work_at_this_time;
    JTextField tutorDay;
    JTextField tutorTime;
    JButton tutorTimeBtn;
    JButton tutorDayBtn;
    JTable tutorTimeTable;

    public EmployeesWindow() throws ClassNotFoundException,InstantiationException, IllegalAccessException, SQLException {
        connection = MySQLConnection.connect();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton displayBtn = new JButton("Display Data");
        displayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = "SELECT * from "+MySQLConnection.username + "db.EMPLOYEE;";
                PreparedStatement pst;
                try{
                    pst = connection.prepareStatement(query);
                    try{
                        ResultSet resultSet = pst.executeQuery();
                        employeeTable.setModel(DbUtils.resultSetToTableModel(resultSet));

                    }catch(SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
        displayBtn.setBounds(20, 35, 154, 23);
        contentPane.add(displayBtn);

        JButton addData = new JButton("Add Data");
        addData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddEmployeeWindow addEmp = null;
                try {
                    addEmp = new AddEmployeeWindow();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
                addEmp.setVisible(true);
            }
        });
        addData.setBounds(20, 65, 154, 23);
        contentPane.add(addData);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String query="DELETE FROM "+MySQLConnection.username+"db.EMPLOYEE where TUID = "+textFieldTUID.getText()+";";
                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Data Delete Successfully");
                    pst.close();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
        deleteBtn.setBounds(57, 226, 89, 23);
        contentPane.add(deleteBtn);

        JLabel label1 = new JLabel("Employees");
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setBounds(448, 11, 80, 33);
        contentPane.add(label1);

        scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(184, 44, 587, 221);
        contentPane.add(scrollPane);

        employeeTable = new JTable();
        employeeTable.setSize(40, 14);
        employeeTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPane.setViewportView(employeeTable);

        tutorTimeTable = new JTable();
        tutorTimeTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPane.setViewportView(tutorTimeTable);

        textFieldTUID = new JTextField();
        textFieldTUID.setBounds(88, 195, 86, 20);
        contentPane.add(textFieldTUID);
        textFieldTUID.setColumns(18);

        deleteLabel = new JLabel("Delete Entry");
        deleteLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        deleteLabel.setBounds(60, 170, 86, 14);
        contentPane.add(deleteLabel);

        tutors_who_work_at_this_time = new JLabel("Find tutors who work at: ");
        tutors_who_work_at_this_time.setFont(new Font("Tahoma", Font.BOLD, 11));
        tutors_who_work_at_this_time.setBounds(15, 90, 160, 14);
        contentPane.add(tutors_who_work_at_this_time);

        tutorTime = new JTextField();
        tutorTime.setBounds(60, 105, 86, 20);
        contentPane.add(tutorTime);

        tutorTimeBtn = new JButton("Find Tutors");
        tutorTimeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query="select FNAME, LNAME, POSITION, SUN_START, SUN_END, M_START, M_END, TU_START, TU_END, W_START, W_END, TH_START, TH_END, FRI_START, FRI_END\n" +
                        "from "+MySQLConnection.username+"db.EMPLOYEE WHERE POSITION = 'Tutor'\n" +
                        "and SUN_START <= '"+tutorTime.getText()+"'and SUN_END > '"+tutorTime.getText()+"'\n" +
                        "or M_START <= '"+tutorTime.getText()+"' and M_END > '"+tutorTime.getText()+"'\n" +
                        "or TU_START <= '"+tutorTime.getText()+"' and TU_END > '"+tutorTime.getText()+"'\n" +
                        "or W_START <= '"+tutorTime.getText()+"' and W_END > '"+tutorTime.getText()+"'\n" +
                        "or TH_START <= '"+tutorTime.getText()+"' and TH_END > '"+tutorTime.getText()+"'\n" +
                        "or FRI_START <= '"+tutorTime.getText()+"' and FRI_END > '"+tutorTime.getText()+"';";
                PreparedStatement pst;
                try{
                    pst = connection.prepareStatement(query);
                    try{
                        ResultSet resultSet = pst.executeQuery();
                        tutorTimeTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
        tutorTimeBtn.setBounds(50, 130, 100, 23);
        contentPane.add(tutorTimeBtn);

        labelTUID = new JLabel("TUID");
        labelTUID.setBounds(35, 198, 32, 14);
        contentPane.add(labelTUID);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    EmployeesWindow frame = new EmployeesWindow();
                    frame.setVisible(true);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });

    }


}

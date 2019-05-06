package gui;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentWindow extends JFrame {

    JPanel contentPane;
    Connection connection = null;
    JLabel label_APT_ID;
    JLabel deleteLabel;
    JTextField tf_APT_ID;
    JTable appointmentTable;
    JScrollPane scrollPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    AppointmentWindow frame = new AppointmentWindow();
                    frame.setVisible(true);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
    }

    public AppointmentWindow() throws ClassNotFoundException,InstantiationException, IllegalAccessException, SQLException {
        connection = MySQLConnection.connect();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 797, 312);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton displayBtn = new JButton("Display Appointments");
        displayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = "SELECT * from "+MySQLConnection.username + "db.APPOINTMENT;";
                PreparedStatement pst;
                try{
                    pst = connection.prepareStatement(query);
                    try{
                        ResultSet resultSet = pst.executeQuery();
                        appointmentTable.setModel(DbUtils.resultSetToTableModel(resultSet));

                    }catch(SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
        displayBtn.setBounds(20, 61, 154, 23);
        contentPane.add(displayBtn);

        JButton addData = new JButton("Add Appointment");
        addData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddAppointmentWindow addApp = null;
                try {
                    addApp = new AddAppointmentWindow();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
                addApp.setVisible(true);
            }
        });
        addData.setBounds(20, 95, 154, 23);
        contentPane.add(addData);


        JButton deleteBtn = new JButton("Delete An Appointment");
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String query="DELETE FROM "+MySQLConnection.username+"db.APPOINTMENT where APT_ID = "+tf_APT_ID.getText()+";";
                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Appointment Deleted Successfully");
                    pst.close();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
        deleteBtn.setBounds(57, 226, 89, 23);
        contentPane.add(deleteBtn);

        JLabel label1 = new JLabel("Appointments");
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setBounds(448, 11, 80, 33);
        contentPane.add(label1);

        scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(184, 44, 587, 221);
        contentPane.add(scrollPane);

        appointmentTable = new JTable();
        appointmentTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPane.setViewportView(appointmentTable);

        tf_APT_ID = new JTextField();
        tf_APT_ID.setBounds(88, 195, 86, 20);
        contentPane.add(tf_APT_ID);
        tf_APT_ID.setColumns(19);

        deleteLabel = new JLabel("Delete Appointment");
        deleteLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        deleteLabel.setBounds(60, 170, 86, 14);
        contentPane.add(deleteLabel);

        label_APT_ID = new JLabel("APT ID");
        label_APT_ID.setBounds(35, 198, 32, 14);
        contentPane.add(label_APT_ID);
    }
}

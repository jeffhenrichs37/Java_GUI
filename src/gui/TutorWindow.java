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

public class TutorWindow extends JFrame {

    JPanel contentPane;
    Connection connection = null;
    JLabel labelTUID;
    JLabel deleteLabel;
    JTextField textFieldTUID;
    JTable majorTable;
    JScrollPane scrollPane;

    public TutorWindow() throws ClassNotFoundException,InstantiationException, IllegalAccessException, SQLException {
        connection = MySQLConnection.connect();

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
                String query = "SELECT * from "+MySQLConnection.username + "db.TUTOR;";
                PreparedStatement pst;
                try{
                    pst = connection.prepareStatement(query);
                    try{
                        ResultSet resultSet = pst.executeQuery();
                        majorTable.setModel(DbUtils.resultSetToTableModel(resultSet));

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

        JButton addData = new JButton("Add Data");
        addData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddTutorWindow addTutor = null;
                try {
                    addTutor = new AddTutorWindow();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
                addTutor.setVisible(true);
            }
        });
        addData.setBounds(20, 95, 154, 23);
        contentPane.add(addData);


        JButton deleteBtn = new JButton("Delete");
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String query="delete from "+MySQLConnection.username+"db.TUTOR where TUID = "+textFieldTUID.getText()+";";
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

        JLabel label1 = new JLabel("Tutors");
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setBounds(448, 11, 80, 33);
        contentPane.add(label1);

        scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(184, 44, 587, 221);
        contentPane.add(scrollPane);

        majorTable = new JTable();
        majorTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPane.setViewportView(majorTable);

        textFieldTUID = new JTextField();
        textFieldTUID.setBounds(88, 195, 86, 20);
        contentPane.add(textFieldTUID);
        textFieldTUID.setColumns(18);

        deleteLabel = new JLabel("Delete Entry");
        deleteLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        deleteLabel.setBounds(60, 170, 86, 14);
        contentPane.add(deleteLabel);

        labelTUID = new JLabel("TUID");
        labelTUID.setBounds(35, 198, 32, 14);
        contentPane.add(labelTUID);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    TutorWindow frame = new TutorWindow();
                    frame.setVisible(true);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });


    }


}

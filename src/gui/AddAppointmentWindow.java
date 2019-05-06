package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddAppointmentWindow extends JFrame{

    JPanel contentPane;
    JTextField tf_APT_ID;
    JTextField tf_APT_DATE;
    JTextField tf_APT_START;
    JTextField tf_APT_END;
    JTextField tf_LOC;
    JTextField tf_TUTOR;
    JTextField tf_CLIENT_FNAME;
    JTextField tf_CLIENT_LNAME;
    JTextField tf_CLIENT_TUID;
    JTextField tf_APT_STATUS;
    JTextField tf_CAREER;
    JTextField tf_SUBJECT_CODE;
    JTextField tf_SUBJECT_NUM;
    JTextField tf_PAGE_LENGTH;
    JTextField tf_REQUESTED;
    JTextField tf_IS_ONLINE;
    JTextField tf_PHONE;
    JTextField tf_SCHEDULER;
    JTextField tf_NOTES;

    Connection connection = null;

    public AddAppointmentWindow() throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {

        connection = MySQLConnection.connect();

        //set global time_zone = '+00:00';
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 285, 488);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel addLabel = new JLabel("Add Appointment");
        addLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        addLabel.setBounds(78, 11, 195, 41);
        contentPane.add(addLabel);

        JLabel addAPTIDLabel = new JLabel("APT ID");
        addAPTIDLabel.setBounds(22, 52, 131, 14);
        contentPane.add(addAPTIDLabel);

        JLabel addAPTDateLabel = new JLabel("APT DATE");
        addAPTDateLabel.setBounds(22, 72, 131, 14);
        contentPane.add(addAPTDateLabel);

        JLabel addAPTStartLabel = new JLabel("APT START");
        addAPTStartLabel.setBounds(22, 92, 131, 14);
        contentPane.add(addAPTStartLabel);

        JLabel addAPTEndLabel = new JLabel("APT END");
        addAPTEndLabel.setBounds(22, 112, 131, 14);
        contentPane.add(addAPTEndLabel);

        JLabel addLocLabel = new JLabel("LOCATION");
        addLocLabel.setBounds(22, 132, 131, 14);
        contentPane.add(addLocLabel);

        JLabel addTutorIDLabel = new JLabel("Tutor TUID");
        addTutorIDLabel.setBounds(22, 152, 131, 14);
        contentPane.add(addTutorIDLabel);


        JLabel addFNameLabel = new JLabel("Client First Name");
        addFNameLabel.setBounds(22, 172, 131, 14);
        contentPane.add(addFNameLabel);

        JLabel addLNameLabel = new JLabel("Client Last Name");
        addLNameLabel.setBounds(22, 192, 131, 14);
        contentPane.add(addLNameLabel);

        JLabel addCTUIDLabel = new JLabel("Client TUID");
        addCTUIDLabel.setBounds(22, 212, 131, 14);
        contentPane.add(addCTUIDLabel);

        JLabel addStatusLabel = new JLabel("APT Status");
        addStatusLabel.setBounds(22, 232, 131, 14);
        contentPane.add(addStatusLabel);

        JLabel addCareerLabel = new JLabel("Career Field");
        addCareerLabel.setBounds(22, 252, 131, 14);
        contentPane.add(addCareerLabel);

        JLabel addSubCodeLabel = new JLabel("Subject Code");
        addSubCodeLabel.setBounds(22, 272, 131, 14);
        contentPane.add(addSubCodeLabel);

        JLabel addSubNumLabel = new JLabel("Subject Number");
        addSubNumLabel.setBounds(22, 292, 131, 14);
        contentPane.add(addSubNumLabel);

        JLabel addPLengthLabel = new JLabel("Page Length");
        addPLengthLabel.setBounds(22, 312, 131, 14);
        contentPane.add(addPLengthLabel);

        JLabel addReqLabel = new JLabel("Requested?");
        addReqLabel.setBounds(22, 332, 131, 14);
        contentPane.add(addReqLabel);

        JLabel addOnlineLabel = new JLabel("Online?");
        addOnlineLabel.setBounds(22, 352, 131, 14);
        contentPane.add(addOnlineLabel);

        JLabel addPhoneLabel = new JLabel("Phone Number");
        addPhoneLabel.setBounds(22, 372, 131, 14);
        contentPane.add(addPhoneLabel);

        JLabel addSchedLabel = new JLabel("Scheduler");
        addSchedLabel.setBounds(22, 392, 131, 14);
        contentPane.add(addSchedLabel);

        JLabel addNotesLabel = new JLabel("Notes");
        addNotesLabel.setBounds(22, 412, 131, 14);
        contentPane.add(addNotesLabel);

        tf_APT_ID = new JTextField();
        tf_APT_ID.setColumns(19);
        tf_APT_ID.setBounds(158, 52, 86, 20);
        contentPane.add(tf_APT_ID);

        tf_APT_DATE = new JTextField();
        tf_APT_DATE.setColumns(19);
        tf_APT_DATE.setBounds(158, 72, 86, 20);
        contentPane.add(tf_APT_DATE);

        tf_APT_START = new JTextField();
        tf_APT_START.setColumns(19);
        tf_APT_START.setBounds(158, 92, 86, 20);
        contentPane.add(tf_APT_START);

        tf_APT_END = new JTextField();
        tf_APT_END.setColumns(19);
        tf_APT_END.setBounds(158, 112, 86, 20);
        contentPane.add(tf_APT_END);

        tf_LOC = new JTextField();
        tf_LOC.setColumns(19);
        tf_LOC.setBounds(158, 132, 86, 20);
        contentPane.add(tf_LOC);

        tf_TUTOR = new JTextField();
        tf_TUTOR.setColumns(19);
        tf_TUTOR.setBounds(158, 152, 86, 20);
        contentPane.add(tf_TUTOR);

        tf_CLIENT_FNAME = new JTextField();
        tf_CLIENT_FNAME.setColumns(19);
        tf_CLIENT_FNAME.setBounds(158, 172, 86, 20);
        contentPane.add(tf_CLIENT_FNAME);

        tf_CLIENT_LNAME = new JTextField();
        tf_CLIENT_LNAME.setColumns(19);
        tf_CLIENT_LNAME.setBounds(158, 192, 86, 20);
        contentPane.add(tf_CLIENT_LNAME);

        tf_CLIENT_TUID = new JTextField();
        tf_CLIENT_TUID.setColumns(10);
        tf_CLIENT_TUID.setBounds(158, 212, 86, 20);
        contentPane.add(tf_CLIENT_TUID);

        tf_APT_STATUS = new JTextField();
        tf_APT_STATUS.setColumns(19);
        tf_APT_STATUS.setBounds(158, 232, 86, 20);
        contentPane.add(tf_APT_STATUS);

        tf_CAREER = new JTextField();
        tf_CAREER.setColumns(19);
        tf_CAREER.setBounds(158, 252, 86, 20);
        contentPane.add(tf_CAREER);

        tf_SUBJECT_CODE = new JTextField();
        tf_SUBJECT_CODE.setColumns(19);
        tf_SUBJECT_CODE.setBounds(158, 272, 86, 20);
        contentPane.add(tf_SUBJECT_CODE);

        tf_SUBJECT_NUM = new JTextField();
        tf_SUBJECT_NUM.setColumns(19);
        tf_SUBJECT_NUM.setBounds(158, 292, 86, 20);
        contentPane.add(tf_SUBJECT_NUM);

        tf_PAGE_LENGTH = new JTextField();
        tf_PAGE_LENGTH.setColumns(19);
        tf_PAGE_LENGTH.setBounds(158, 312, 86, 20);
        contentPane.add(tf_PAGE_LENGTH);

        tf_REQUESTED = new JTextField();
        tf_REQUESTED.setColumns(19);
        tf_REQUESTED.setBounds(158, 332, 86, 20);
        contentPane.add(tf_REQUESTED);

        tf_IS_ONLINE = new JTextField();
        tf_IS_ONLINE.setColumns(19);
        tf_IS_ONLINE.setBounds(158, 352, 86, 20);
        contentPane.add(tf_IS_ONLINE);

        tf_PHONE = new JTextField();
        tf_PHONE.setColumns(19);
        tf_PHONE.setBounds(158, 372, 86, 20);
        contentPane.add(tf_PHONE);

        tf_SCHEDULER = new JTextField();
        tf_SCHEDULER.setColumns(19);
        tf_SCHEDULER.setBounds(158, 392, 86, 20);
        contentPane.add(tf_SCHEDULER);

        tf_NOTES = new JTextField();
        tf_NOTES.setColumns(19);
        tf_NOTES.setBounds(158, 412, 86, 20);
        contentPane.add(tf_NOTES);

        JButton submitBtn = new JButton("Submit");
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String query = "INSERT into "+MySQLConnection.username+"db.APPOINTMENT(APT_ID, APT_DATE, APT_START, APT_END, LOC, TUTOR_TUID, CLIENT_FNAME, CLIENT_LNAME, CLIENT_TUID, APT_STATUS, CAREER, SUBJECT_CODE, SUBJECT_NUM, PAGE_LENGTH, REQUESTED, IS_ONLINE, PHONE, SCHEDULER, NOTES) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setString(1, tf_APT_ID.getText());
                    pst.setString(2, tf_APT_DATE.getText());
                    pst.setString(3, tf_APT_START.getText());
                    pst.setString(4, tf_APT_END.getText());
                    pst.setString(5, tf_LOC.getText());
                    pst.setString(6, tf_TUTOR.getText());
                    pst.setString(7, tf_CLIENT_FNAME.getText());
                    pst.setString(8, tf_CLIENT_LNAME.getText());
                    pst.setString(9, tf_CLIENT_TUID.getText());
                    pst.setString(10, tf_APT_STATUS.getText());
                    pst.setString(11, tf_CAREER.getText());
                    pst.setString(12, tf_SUBJECT_CODE.getText());
                    pst.setString(13, tf_SUBJECT_NUM.getText());
                    pst.setString(14, tf_PAGE_LENGTH.getText());
                    pst.setString(15, tf_REQUESTED.getText());
                    pst.setString(16, tf_IS_ONLINE.getText());
                    pst.setString(17, tf_PHONE.getText());
                    pst.setString(18, tf_SCHEDULER.getText());
                    pst.setString(19, tf_NOTES.getText());
                    pst.execute();

                    JOptionPane.showMessageDialog(null, "Data Saved Successfully");
                    tf_APT_ID.setText("");
                    tf_APT_DATE.setText("");
                    tf_APT_START.setText("");
                    tf_APT_END.setText("");
                    tf_LOC.setText("");
                    tf_TUTOR.setText("");
                    tf_CLIENT_FNAME.setText("");
                    tf_CLIENT_LNAME.setText("");
                    tf_CLIENT_TUID.setText("");
                    tf_APT_STATUS.setText("");
                    tf_CAREER.setText("");
                    tf_SUBJECT_CODE.setText("");
                    tf_SUBJECT_NUM.setText("");
                    tf_PAGE_LENGTH.setText("");
                    tf_REQUESTED.setText("");
                    tf_IS_ONLINE.setText("");
                    tf_PHONE.setText("");
                    tf_SCHEDULER.setText("");
                    tf_NOTES.setText("");
                    pst.close();


                }catch(Exception ex){
                    ex.printStackTrace();;
                }
            }
        });
        submitBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
        submitBtn.setBounds(64, 432, 89, 23);
        contentPane.add(submitBtn);
    }

    public static void main(String[] args) {

    }

}

package gui;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddTutorWindow extends JFrame {

    JPanel contentPane;
    JTextField TUID;
    JTextField MAJOR;
    JTextField CAREER;
    JTextField FLAG_TRADITIONAL;
    JTextField FLAG_FELLOW;


    Connection connection = null;

    public AddTutorWindow() throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {

        connection = MySQLConnection.connect();

        //set global time_zone = '+00:00';
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 285, 488);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel addLabel = new JLabel("Add Tutor");
        addLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        addLabel.setBounds(78, 11, 175, 41);
        contentPane.add(addLabel);

        JLabel addTUIDLabel = new JLabel("TUID");
        addTUIDLabel.setBounds(22, 52, 131, 14);
        contentPane.add(addTUIDLabel);

        JLabel addFnameLabel = new JLabel("Major");
        addFnameLabel.setBounds(22, 72, 131, 14);
        contentPane.add(addFnameLabel);

        JLabel addLnameLabel = new JLabel("Carrear");
        addLnameLabel.setBounds(22, 92, 131, 14);
        contentPane.add(addLnameLabel);

        JLabel addEmailLabel = new JLabel("Traditional");
        addEmailLabel.setBounds(22, 112, 131, 14);
        contentPane.add(addEmailLabel);

        JLabel addPhoneLabel = new JLabel("Fellow");
        addPhoneLabel.setBounds(22, 132, 131, 14);
        contentPane.add(addPhoneLabel);


        TUID = new JTextField();
        TUID.setColumns(10);
        TUID.setBounds(158, 52, 86, 20);
        contentPane.add(TUID);

        MAJOR = new JTextField();
        MAJOR.setColumns(10);
        MAJOR.setBounds(158, 72, 86, 20);
        contentPane.add(MAJOR);

        CAREER = new JTextField();
        CAREER.setColumns(10);
        CAREER.setBounds(158, 92, 86, 20);
        contentPane.add(CAREER);

        FLAG_TRADITIONAL = new JTextField();
        FLAG_TRADITIONAL.setColumns(10);
        FLAG_TRADITIONAL.setBounds(158, 112, 86, 20);
        contentPane.add(FLAG_TRADITIONAL);

        FLAG_FELLOW = new JTextField();
        FLAG_FELLOW.setColumns(10);
        FLAG_FELLOW.setBounds(158, 132, 86, 20);
        contentPane.add(FLAG_FELLOW);



        JButton submitBtn = new JButton("Submit");
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String query = "INSERT into "+MySQLConnection.username+"db.TUTOR(TUID, MAJOR, CAREER, FLAG_TRADITIONAL, FLAG_FELLOW) VALUES (?,?,?,?,?)";

                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setString(1, TUID.getText());
                    pst.setString(2, MAJOR.getText());
                    pst.setString(3, CAREER.getText());
                    pst.setString(4, FLAG_TRADITIONAL.getText());
                    pst.setString(5, FLAG_FELLOW.getText());

                    pst.execute();

                    JOptionPane.showMessageDialog(null, "Data Saved Successfully");
                    TUID.setText("");
                    MAJOR.setText("");
                    CAREER.setText("");
                    FLAG_TRADITIONAL.setText("");
                    FLAG_FELLOW.setText("");

                    pst.close();


                }catch(Exception ex){
                    ex.printStackTrace();;
                }
            }
        });
        submitBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
        submitBtn.setBounds(64, 412, 89, 23);
        contentPane.add(submitBtn);
    }

    public static void main(String[] args) {

    }

}

package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddEmployeeWindow extends JFrame {

    JPanel contentPane;
    JTextField tfTUID;
    JTextField tfFNAME;
    JTextField tfLNAME;
    JTextField tfEMAIL;
    JTextField tfPHONE;
    JTextField tfPOSITION;
    JTextField tfSU_START;
    JTextField tfSU_END;
    JTextField tfM_START;
    JTextField tfM_END;
    JTextField tfTU_START;
    JTextField tfTU_END;
    JTextField tfW_START;
    JTextField tfW_END;
    JTextField tfTH_START;
    JTextField tfTH_END;
    JTextField tfF_START;
    JTextField tfF_END;


    public AddEmployeeWindow(){

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 285, 488);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel addLabel = new JLabel("Add Employee");
        addLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        addLabel.setBounds(78, 11, 175, 41);
        contentPane.add(addLabel);

        JLabel addTUIDLabel = new JLabel("TUID");
        addTUIDLabel.setBounds(22, 52, 131, 14);
        contentPane.add(addTUIDLabel);

        JLabel addFnameLabel = new JLabel("FNAME");
        addFnameLabel.setBounds(22, 72, 131, 14);
        contentPane.add(addFnameLabel);

        JLabel addLnameLabel = new JLabel("LNAME");
        addLnameLabel.setBounds(22, 92, 131, 14);
        contentPane.add(addLnameLabel);

        JLabel addEmailLabel = new JLabel("Email");
        addEmailLabel.setBounds(22, 112, 131, 14);
        contentPane.add(addEmailLabel);

        JLabel addPhoneLabel = new JLabel("Phone");
        addPhoneLabel.setBounds(22, 132, 131, 14);
        contentPane.add(addPhoneLabel);

        JLabel addPositionLabel = new JLabel("Position");
        addPositionLabel.setBounds(22, 152, 131, 14);
        contentPane.add(addPositionLabel);


        JLabel addSunStartLabel = new JLabel("Sunday Start Time");
        addSunStartLabel.setBounds(22, 172, 131, 14);
        contentPane.add(addSunStartLabel);

        JLabel addSunEndLabel = new JLabel("Sunday End Time");
        addSunEndLabel.setBounds(22, 192, 131, 14);
        contentPane.add(addSunEndLabel);

        JLabel addMonStartLabel = new JLabel("Monday Start Time");
        addMonStartLabel.setBounds(22, 212, 131, 14);
        contentPane.add(addMonStartLabel);

        JLabel addMonEndLabel = new JLabel("Monday End Time");
        addMonEndLabel.setBounds(22, 232, 131, 14);
        contentPane.add(addMonEndLabel);

        JLabel addTuStartLabel = new JLabel("Tues Start Time");
        addTuStartLabel.setBounds(22, 252, 131, 14);
        contentPane.add(addTuStartLabel);

        JLabel addTuEndLabel = new JLabel("Tues End Time");
        addTuEndLabel.setBounds(22, 272, 131, 14);
        contentPane.add(addTuEndLabel);

        JLabel addWStartLabel = new JLabel("Weds Start Time");
        addWStartLabel.setBounds(22, 292, 131, 14);
        contentPane.add(addWStartLabel);

        JLabel addWEndLabel = new JLabel("Weds End Time");
        addWEndLabel.setBounds(22, 312, 131, 14);
        contentPane.add(addWEndLabel);

        JLabel addThStartLabel = new JLabel("Thurs Start Time");
        addThStartLabel.setBounds(22, 332, 131, 14);
        contentPane.add(addThStartLabel);

        JLabel addThEndLabel = new JLabel("Thurs End Time");
        addThEndLabel.setBounds(22, 352, 131, 14);
        contentPane.add(addThEndLabel);

        JLabel addFriStartLabel = new JLabel("Friday Start Time");
        addFriStartLabel.setBounds(22, 372, 131, 14);
        contentPane.add(addFriStartLabel);

        JLabel addFriEndLabel = new JLabel("Friday End Time");
        addFriEndLabel.setBounds(22, 392, 131, 14);
        contentPane.add(addFriEndLabel);

        tfTUID = new JTextField();
        tfTUID.setColumns(10);
        tfTUID.setBounds(158, 52, 86, 20);
        contentPane.add(tfTUID);

        tfFNAME = new JTextField();
        tfFNAME.setColumns(10);
        tfFNAME.setBounds(158, 72, 86, 20);
        contentPane.add(tfFNAME);

        tfLNAME = new JTextField();
        tfLNAME.setColumns(10);
        tfLNAME.setBounds(158, 92, 86, 20);
        contentPane.add(tfLNAME);

        tfEMAIL = new JTextField();
        tfEMAIL.setColumns(10);
        tfEMAIL.setBounds(158, 112, 86, 20);
        contentPane.add(tfEMAIL);

        tfPHONE = new JTextField();
        tfPHONE.setColumns(10);
        tfPHONE.setBounds(158, 132, 86, 20);
        contentPane.add(tfPHONE);

        tfPOSITION = new JTextField();
        tfPOSITION.setColumns(10);
        tfPOSITION.setBounds(158, 152, 86, 20);
        contentPane.add(tfPOSITION);

        tfSU_START = new JTextField();
        tfSU_START.setColumns(10);
        tfSU_START.setBounds(158, 172, 86, 20);
        contentPane.add(tfSU_START);

        tfSU_END = new JTextField();
        tfSU_END.setColumns(10);
        tfSU_END.setBounds(158, 192, 86, 20);
        contentPane.add(tfSU_END);

        tfM_START = new JTextField();
        tfM_START.setColumns(10);
        tfM_START.setBounds(158, 212, 86, 20);
        contentPane.add(tfM_START);

        tfM_END = new JTextField();
        tfM_END.setColumns(10);
        tfM_END.setBounds(158, 232, 86, 20);
        contentPane.add(tfM_END);

        tfTU_START = new JTextField();
        tfTU_START.setColumns(10);
        tfTU_START.setBounds(158, 252, 86, 20);
        contentPane.add(tfTU_START);

        tfTU_END = new JTextField();
        tfTU_END.setColumns(10);
        tfTU_END.setBounds(158, 272, 86, 20);
        contentPane.add(tfTU_END);

        tfW_START = new JTextField();
        tfW_START.setColumns(10);
        tfW_START.setBounds(158, 292, 86, 20);
        contentPane.add(tfW_START);

        tfW_END = new JTextField();
        tfW_END.setColumns(10);
        tfW_END.setBounds(158, 312, 86, 20);
        contentPane.add(tfW_END);

        tfTH_START = new JTextField();
        tfTH_START.setColumns(10);
        tfTH_START.setBounds(158, 332, 86, 20);
        contentPane.add(tfTH_START);

        tfTH_END = new JTextField();
        tfTH_END.setColumns(10);
        tfTH_END.setBounds(158, 352, 86, 20);
        contentPane.add(tfTH_END);

        tfF_START = new JTextField();
        tfF_START.setColumns(10);
        tfF_START.setBounds(158, 372, 86, 20);
        contentPane.add(tfF_START);

        tfF_END = new JTextField();
        tfF_END.setColumns(10);
        tfF_END.setBounds(158, 392, 86, 20);
        contentPane.add(tfF_END);



    }

    public static void main(String[] args) {

    }

}

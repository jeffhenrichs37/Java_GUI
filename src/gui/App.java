package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class App {

    public App() throws SQLException {

    }

    public static void main(String[] args) {

        JButton appointemntBtn;
        JButton collegeBtn;
        JButton departmentBtn;
        JButton employeeBtn;
        JButton fellowTutorBtn;
        JButton frontDeskBtn;
        JButton majorBtn;
        JButton profBtn;
        JButton subjectEntryBtn;
        JButton traditTutorBtn;
        JButton tutorBtn;
        JLabel lb1Welcome;
        JLabel lb1Select;


        JFrame jframe = new JFrame("Welcome");
        jframe.setVisible(true);
        jframe.setSize(500, 500);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        jframe.add(panel);

        lb1Welcome = new JLabel("Welcome to the TU Writing Center");
        lb1Welcome.setFont(new Font("Tahoma", Font.BOLD, 16));
        lb1Welcome.setBounds(100, 11, 300,36);
        panel.add(lb1Welcome);

        lb1Select = new JLabel("Select a category");
        lb1Select.setBounds(175, 30, 225, 36);
        panel.add(lb1Select);

        appointemntBtn = new JButton("Appointments");
        appointemntBtn.setBounds(25, 75, 125, 35);
        panel.add(appointemntBtn);

        collegeBtn = new JButton("Colleges");
        collegeBtn.setBounds(25, 115, 125, 35);
        panel.add(collegeBtn);

        departmentBtn = new JButton("Department");
        departmentBtn.setBounds(25, 155, 125, 35);
        panel.add(departmentBtn);

        employeeBtn = new JButton("Employees");
        employeeBtn.setBounds(175, 75, 125, 35);
        panel.add(employeeBtn);
        employeeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeesWindow emp = new EmployeesWindow();
                emp.setVisible(true);
            }
        });

        frontDeskBtn = new JButton("Front Desk");
        frontDeskBtn.setBounds(175, 115, 125, 35);
        panel.add(frontDeskBtn);

        fellowTutorBtn = new JButton("Fellow Tutors");
        fellowTutorBtn.setBounds(95, 195,125, 35);
        panel.add(fellowTutorBtn);

        majorBtn = new JButton("Majors");
        majorBtn.setBounds(175, 155, 125, 35);
        panel.add(majorBtn);

        profBtn = new JButton("Professors");
        profBtn.setBounds(325, 75, 125, 35);
        panel.add(profBtn);

        subjectEntryBtn = new JButton("Subjects");
        subjectEntryBtn.setBounds(325, 115, 125, 35);
        panel.add(subjectEntryBtn);

        traditTutorBtn = new JButton("Traditional Tutors");
        traditTutorBtn.setBounds(250, 195, 135, 35);
        panel.add(traditTutorBtn);


        tutorBtn = new JButton("Tutor");
        tutorBtn.setBounds(325, 155, 125, 35);
        panel.add(tutorBtn);
        tutorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TutorsWindow tutors = new TutorsWindow();
                tutors.setVisible(true);
            }
        });

        JButton exitBtn = new JButton("Exit");
        exitBtn.setBounds(175, 235, 125, 35);
        exitBtn.setBackground(Color.RED);
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.dispose();
            }
        });
        panel.add(exitBtn);




    }
}

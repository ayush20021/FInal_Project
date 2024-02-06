package ui;



import operations.Implementor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class AddEmployee extends  JFrame {

    JLabel Name,id,Salary,address,status;
    JTextField NameInp,IdInp,SalInp;

    JTextArea Inpaddress;

    JButton savBtn,Home;

    AddEmployee(){
        setLayout(null);
        Name = new JLabel("Name");
        id = new JLabel("ID");
        Salary = new JLabel("Salary");
        address = new JLabel("Address");
        NameInp = new JTextField(10);
        IdInp = new JTextField(10);
        SalInp = new JTextField(10);
        Inpaddress = new JTextArea();
        savBtn = new JButton("ADD");
        status = new JLabel();
        Home = new JButton("Home");

        Home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main();
                dispose();
            }
        });

        savBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee emp = new Employee();
                emp.setId(Integer.parseInt(IdInp.getText()));
                emp.setName(NameInp.getText());
                emp.setSalary(Double.parseDouble(SalInp.getText()));

                Implementor imp = new Implementor();
                try {
                    imp.AddEmp(emp);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });


        Name.setBounds(50,50,60,30);
        NameInp.setBounds(100,60,100,20);
        id.setBounds(50,100,60,30);
        IdInp.setBounds(100,110,100,20);
        Salary.setBounds(50,150,60,30);
        SalInp.setBounds(100,160,100,20);
        address.setBounds(50,200,60,30);
        Inpaddress.setBounds(110,210,100,20);
        savBtn.setBounds(50,250,60,30);
        status.setBounds(50,280,200,30);
        Home.setBounds(120,310,120,30);



        add(Name);
        add(NameInp);
        add(id);
        add(IdInp);
        add(Salary);
        add(SalInp);
        add(address);
        add(Inpaddress);
        add(savBtn);
        add(status);
        add(Home);
        setSize(400,400);
        setVisible(true);

    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}

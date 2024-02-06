package ui;

import operations.Implementor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UpdateEmployee  extends JFrame {

    JLabel Id ,Name;
    JTextField Idimp,Nameinp;

    JButton btn;

    UpdateEmployee(){
        setLayout(null);
        Id = new JLabel("Enter id");
        Name = new JLabel("Enter Name");
        Idimp = new JTextField(10);
        Nameinp = new JTextField(10);
        btn = new JButton("Update");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee emp = new Employee();
                emp.setId(Integer.parseInt(Idimp.getText()));
                emp.setName(Nameinp.getText());
                Implementor imp  = new Implementor();
                try {
                    imp.UpdateEmp(emp);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        Id.setBounds(50,50,60,30);
        Idimp.setBounds(130,50,60,30);
        Name.setBounds(50,100,60,30);
        Nameinp.setBounds(130,100,60,30);
        btn.setBounds(50,130,100,30);
        add(Id);
        add(Idimp);
        add(Name);
        add(Nameinp);
        add(btn);
        setSize(400,400);
        setVisible(true);



    }


}

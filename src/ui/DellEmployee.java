package ui;

import operations.Implementor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DellEmployee extends JFrame {

    JLabel ID;
    JTextField Idinp;

    JButton btn;

    DellEmployee(){
        setLayout(null);
        ID = new JLabel("Enter Id");
        Idinp = new JTextField();
        btn = new JButton("DELETE");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee emp = new Employee();
                emp.setId(Integer.parseInt(Idinp.getText()));
                Implementor inp = new Implementor();
                try {
                    inp.DellEmp(emp);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        ID.setBounds(50,50,60,30);
        Idinp.setBounds(120,50,80,30);
        btn.setBounds(50,100,100,30);
        add(ID);
        add(Idinp);
        add(btn);
        setSize(400,400);
        setVisible(true);
    }
}

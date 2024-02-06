package ui;

import operations.Implementor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SearchEmployee extends JFrame {

    JLabel ID,msg;
    JTextField Idinp;

    JButton btn;

    SearchEmployee(){
        setLayout(null);
        ID= new JLabel("Enter ID");
        Idinp = new JTextField(10);
        msg = new JLabel("");
        btn = new JButton("Search");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee emp = new Employee();
                emp.setId(Integer.parseInt(Idinp.getText()));
                Implementor inp = new Implementor();
                try {
                    inp.SearchEmp(emp);
                    msg.setText("Name:"+emp.getName()+"Sal:"+emp.getSalary()+"ID"+emp.getId());
                    msg.setForeground(Color.GREEN);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        ID.setBounds(50,50,60,30);
        Idinp.setBounds(120,50,60,30);
        btn.setBounds(50,100,80,60);
        msg.setBounds(50,250,200,20);
        add(ID);
        add(Idinp);
        add(btn);
        add(msg);
        setSize(400,400);
        setVisible(true);

    }

}

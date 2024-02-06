package operations;


import connection.GetConnection;
import ui.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Implementor implements Methos {
    @Override
    public void AddEmp(Employee emp) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement;
        String sql = "INSERT INTO `emp` ( `ID`, `Name`, `Salary`) VALUES ( ?, ?, ?)";
        preparedStatement = GetConnection.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,emp.getId());
        preparedStatement.setString(2,emp.getName());
        preparedStatement.setDouble(3,emp.getSalary());

        int a = preparedStatement.executeUpdate();
        if(a>0){
            System.out.println("Data Inserted");
        }else {
            System.out.println("Data Insert Failed");
        }
    }

    @Override
    public void DellEmp(Employee emp) throws SQLException, ClassNotFoundException {

        PreparedStatement preparedStatement;
        String sql = "DELETE FROM `emp` WHERE `ID` = ?";
        preparedStatement = GetConnection.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,emp.getId());

        int a = preparedStatement.executeUpdate();
        if(a>0){
            System.out.println("Data Delete");
        }else {
            System.out.println("Data Delete Failed");
        }


    }

    @Override
    public void UpdateEmp(Employee emp) throws SQLException, ClassNotFoundException {

       PreparedStatement statement;
       String sql = "UPDATE `emp` SET `Name`=? WHERE `ID` = ?";
       statement = GetConnection.getConnection().prepareStatement(sql);
       statement.setString(1,emp.getName());
       statement.setInt(2,emp.getId());

       int a = statement.executeUpdate();
       if(a>0){
           System.out.println("Data Updated");
       }else {
           System.out.println("Data Not Updated");
       }


    }

    @Override
    public void SearchEmp(Employee emp) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement;
        String sql = "SELECT * FROM `emp` WHERE `ID` = ?";
        preparedStatement = GetConnection.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,emp.getId());

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("ID");
            String NAme = resultSet.getString("Name");
            int Sal = resultSet.getInt("Salary");
            emp.setId(id);
            emp.setName(NAme);
            emp.setSalary(Sal);

            System.out.println(id+NAme+Sal);
        }


    }

    @Override
    public void ShowEmp(Employee emp) {


    }



}

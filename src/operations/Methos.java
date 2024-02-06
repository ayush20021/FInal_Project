package operations;



import ui.Employee;

import java.sql.SQLException;

public interface Methos {

    void AddEmp(Employee emp) throws SQLException, ClassNotFoundException;
    void DellEmp(Employee emp) throws SQLException, ClassNotFoundException;
    void UpdateEmp(Employee emp) throws SQLException, ClassNotFoundException;
    void SearchEmp(Employee emp) throws SQLException, ClassNotFoundException;

    void ShowEmp(Employee emp);

}

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpImplement implements EmpInterface {
    Connection con;

    @Override
    public void createEmployee(Employee ep) {
        con = DbConnection.createDbConnetion();
        String query = "INSERT INTO employee VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, ep.getId());
            ps.setString(2, ep.getName());
            ps.setInt(3, ep.getAge());
            ps.setString(4, ep.getDepartment());
            ps.setString(5, ep.getDesignation());
            ps.setDouble(6, ep.getSalary());
            ps.setString(7, ep.getEmail());
            ps.setInt(8, ep.getPhone());
            ps.setString(9, ep.getAddress());

            int count = ps.executeUpdate();
            if (count != 0) {
                System.out.println("--*-- Employee Added Successfully ! --*--");
            } else {
                System.out.println("Something went to wrong, Please try again !");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void showAllEmployee() {
        con = DbConnection.createDbConnetion();
        String query = "SELECT * FROM employee";

        System.out.println("Employee Details : ");
        System.out.println("==================================================================================" +
                "======================================================================");
        System.out.printf("%-5s| %-15s | %-5s| %-15s| %-15s| %-10s| %-25s| %-15s| %-20s\n",
                "ID"  ,"Name", "Age", "Department", "Designations", "Salary", "Email", "Phone", "Address");
        System.out.println("==================================================================================" +
                "=======================================================================");
        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                System.out.printf("%-5s| %-15s | %-5s| %-15s| %-15s| %-10s| %-25s| %-15s| %-20s\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getString(4),
                        result.getString(5),
                        result.getDouble(6),
                        result.getString(7),
                        result.getString(8),
                        result.getString(9));
                System.out.println("------------------------------------------------------------------------------------" +
                        "------------------------------------------------------------------------");
            }

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void showEmployeeBasedOnID(int id) {
        con = DbConnection.createDbConnetion();
        String query = "SELECT * FROM employee WHERE id = ?";

        System.out.println("Employee Details : ");
        System.out.println("==================================================================================" +
                "======================================================================");
        System.out.printf("%-5s| %-15s | %-5s| %-15s| %-15s| %-10s| %-25s| %-15s| %-20s\n",
                "ID"  ,"Name", "Age", "Department", "Designations", "Salary", "Email", "Phone", "Address");
        System.out.println("==================================================================================" +
                "=======================================================================");

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            boolean found = false;

            while (result.next()) {
                System.out.printf("%-5s| %-15s | %-5s| %-15s| %-15s| %-10s| %-25s| %-15s| %-20s\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getString(4),
                        result.getString(5),
                        result.getDouble(6),
                        result.getString(7),
                        result.getString(8),
                        result.getString(9));
                found = true;
                System.out.println("------------------------------------------------------------------------------------" +
                        "------------------------------------------------------------------------");
            }

            if (!found) {
                System.out.println("No employee found with ID: " + id);
            }

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateEmployee(int id, String name) {
        con = DbConnection.createDbConnetion();
        String query = "UPDATE employee SET name=? WHERE id=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, id);
            int cnt = ps.executeUpdate();

            if (cnt != 0) {
                System.out.println("Employee Details updated successfully !!");
            }
            else {
                System.out.println("No Employee found with ID: " + id);
            }

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteEmployee(int id) {
        con = DbConnection.createDbConnetion();
        String query = "DELETE FROM employee WHERE id=?";

        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            int cnt = pstm.executeUpdate();

            if (cnt != 0) {
                System.out.println("Employee Deleted Successfully!!! " + id);
            } else {
                System.out.println("Employee with ID " + id + " not found !");
            }

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateSalary(int id, double newSalary) {
        con = DbConnection.createDbConnetion();
        String query = "UPDATE employee SET salary=? WHERE id=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1, newSalary);
            ps.setInt(2, id);

            int cnt = ps.executeUpdate();

            if (cnt != 0) {
                System.out.println("Salary updated successfully for employee ID: " + id);
            } else {
                System.out.println("No Employee found with ID: " + id);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void searchByDepartment(String department) {
        con = DbConnection.createDbConnetion();
        String query = "SELECT * FROM employee WHERE department=?";

        System.out.println("Employees in Department: " + department);
        System.out.println("==================================================================================" +
                "======================================================================");
        System.out.printf("%-5s| %-15s | %-5s| %-15s| %-15s| %-10s| %-25s| %-15s| %-20s\n",
                "ID"  ,"Name", "Age", "Department", "Designations", "Salary", "Email", "Phone", "Address");
        System.out.println("==================================================================================" +
                "=======================================================================");
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, department);
            ResultSet result = ps.executeQuery();

            boolean found = false;
            while (result.next()) {
                System.out.printf("%-5s| %-15s | %-5s| %-15s| %-15s| %-10s| %-25s| %-15s| %-20s\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getString(4),
                        result.getString(5),
                        result.getDouble(6),
                        result.getString(7),
                        result.getString(8),
                        result.getString(9));
                found = true;
                System.out.println("------------------------------------------------------------------------------------" +
                        "------------------------------------------------------------------------");
            }

            if (!found) {
                System.out.println("cannot found the employee in this department.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void searchByDesignation(String designation) {
        con = DbConnection.createDbConnetion();
        String query = "SELECT * FROM employee WHERE designation=?";

        System.out.println("Employees with Designation: " + designation);
        System.out.println(
                "=============================================================================================================================" +
                        "==============================================================");
        System.out.printf("%-5s| %-15s | %-5s| %-15s| %-15s| %-10s| %-25s| %-15s| %-20s\n",
                "ID", "Name", "Age", "Department", "Designations", "Salary", "Email", "Phone", "Address");
        System.out.println(
                "=============================================================================================================================" +
                        "==============================================================");

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, designation);
            ResultSet result = ps.executeQuery();

            boolean found = false;

            while (result.next()) {
                System.out.printf("%-5s| %-15s | %-5s| %-15s| %-15s| %-10.2f| %-25s| %-15s| %-20s\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getString(4),
                        result.getString(5),
                        result.getDouble(6),
                        result.getString(7),
                        result.getString(8),
                        result.getString(9));

                System.out.println(
                        "-----------------------------------------------------------------------------------------------------------------------------" +
                                "--------------------------------------------------------------");
                found = true;
            }

            if (!found) {
                System.out.println("employee didn't found with this designation.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

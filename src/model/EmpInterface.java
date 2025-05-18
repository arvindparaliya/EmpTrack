package model;

public interface EmpInterface {

    // create a new employee record
    public void createEmployee(Employee emp);

    // display all employees
    public void showAllEmployee();

    // display specific employee using ID
    public void showEmployeeBasedOnID(int id);

    // update employee's name by ID
    public void updateEmployee(int id, String name);

    // delete employee by ID
    public void deleteEmployee(int id);

    // update salary of employee by ID
    public void updateSalary(int id, double newSalary);

    // search employees by department
    public void searchByDepartment(String department);

    // search employees by designation
    public void searchByDesignation(String designation);
}

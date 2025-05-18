package model;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        int id;
        EmpInterface dao = new EmpImplement();
        System.out.println("==*== Welcome to Employee Management System ==*==");

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(
                        "\n  1. Add Employee \n" +
                            "2. Show All Employees \n" +
                            "3. Show Employee based on ID \n" +
                            "4. Update the Employee Name \n" +
                            "5. Delete the Employee \n" +
                            "6. Update Employee Salary \n" +
                            "7. Search Employees by Department \n" +
                            "8. Search Employees by Designation \n" +
                            "9. Exit \n");

            System.out.println("Enter Your Choice: ");
            int start = sc.nextInt();
            switch (start) {
                case 1:
                    Employee emp = new Employee();
                    System.out.println("Enter ID : ");
                    id = sc.nextInt();
                    System.out.println("Enter Name : ");
                    name = sc.next();
                    System.out.println("Enter Salary : ");
                    double salary = sc.nextDouble();
                    System.out.println("Enter Age : ");
                    int age = sc.nextInt();
                    System.out.println("Enter Department : ");
                    String dept = sc.next();
                    System.out.println("Enter Designation : ");
                    String desg = sc.next();
                    System.out.println("Enter Email : ");
                    String email = sc.next();
                    System.out.println("Enter Phone : ");
                    int phone = sc.nextInt();
                    System.out.println("Enter Address : ");
                    String address = sc.next();

                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    emp.setDepartment(dept);
                    emp.setDesignation(desg);
                    emp.setEmail(email);
                    emp.setPhone(phone);
                    emp.setAddress(address);

                    dao.createEmployee(emp);
                    break;

                case 2:
                    dao.showAllEmployee();
                    break;

                case 3:
                    System.out.println("Enter ID to show the details: ");
                    int empid = sc.nextInt();
                    dao.showEmployeeBasedOnID(empid);
                    break;

                case 4:
                    System.out.println("Enter ID to update the name: ");
                    int empid1 = sc.nextInt();
                    System.out.println("Enter the new name: ");
                    name = sc.next();
                    dao.updateEmployee(empid1, name);
                    break;

                case 5:
                    System.out.println("Enter ID to delete: ");
                    id = sc.nextInt();
                    dao.deleteEmployee(id);
                    break;

                case 6:
                    System.out.println("Enter Employee ID to update salary: ");
                    int sid = sc.nextInt();
                    System.out.println("Enter new salary: ");
                    double newSalary = sc.nextDouble();
                    dao.updateSalary(sid, newSalary);
                    break;

                case 7:
                    System.out.println("Enter Department name to search: ");
                    String department = sc.next();
                    dao.searchByDepartment(department);
                    break;

                case 8:
                    System.out.println("Enter Designation to search: ");
                    String designation = sc.next();
                    dao.searchByDesignation(designation);
                    break;

                case 9:
                    System.out.println("Thank you for using our Application !!!");
                    System.exit(0);

                default:
                    System.out.println("Enter valid choice !");
                    break;
            }

        } while (true);
    }
}

package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println(" ====TEST 1 FIND BY ID =====");

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Department department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println(" ====TEST 2 INSERT =====");

        Department newDepartment = new Department(null, "Games");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());

        System.out.println(" ====TEST 3 DELETE ID =====");

        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete Completed");

        System.out.println("====TEST 4 UPDATE====");
        department = departmentDao.findById(1);
        department.setName("Fruits");
        departmentDao.update(department);
        System.out.println("Update Complete");

        System.out.println("===TEST 5 FIND ALL====");

        List<Department> list = departmentDao.findAll();
        for (Department d : list) {
            System.out.println(d);
        }


    }
}

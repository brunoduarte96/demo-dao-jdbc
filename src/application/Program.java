package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerdao = DaoFactory.createSellerDao();
        System.out.println("=== TEST 1: seller findById ====");

        Seller seller = sellerdao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findById ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerdao.findByDepartment(department);
        for ( Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: seller findAll ====");

       list = sellerdao.findAll();
        for ( Seller obj : list){
            System.out.println(obj);
        }


        System.out.println("\n=== TEST 4: seller insert =====");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerdao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n=== TEST 5: seller update =====");
        seller = sellerdao.findById(1);
        seller.setName("Martha Waine");
        sellerdao.update(seller);
        System.out.println("Update Complete");

        System.out.println("\n=== TEST 6: seller delete =====");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerdao.deleteById(id);
        System.out.println("Delete completed");

    }


}

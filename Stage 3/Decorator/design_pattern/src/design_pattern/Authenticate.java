/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package design_pattern;

/**
 *
 * @author USER
 */
import java.util.ArrayList;
import java.util.Scanner;



public class Authenticate<T> {


  

 public T auth(ArrayList<? extends Person> persons) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your email: ");
        String emailAuth = sc.nextLine();
        System.out.print("Enter your password: ");
        String passwordAuth = sc.nextLine();

        for (Person person : persons) {
            if (person.getEmail().equals(emailAuth) && person.verifyPassword(passwordAuth)) {
                return (T) person;
            }
        }

        return null;
    }
}
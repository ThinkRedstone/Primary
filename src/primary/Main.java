/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primary;

import java.util.Scanner;

/**
 *
 * @author ThinkRedstone
 */
public class Main {

    static Scanner in = new Scanner(System.in);

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("Enter your fraction in this pattern: X/Y");
            Fraction fraction = new Fraction(in.next());
            System.out.println("The minimum fraction is: " + fraction.minimizeFraction());
        }

    }

}

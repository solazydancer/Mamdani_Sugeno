/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sugeno1;

import java.util.Scanner;

/**
 *
 * @author daria
 */
public class Sugeno1 {

    static public double a, b, result = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("age?");
        double n1 = sc.nextDouble();
        System.out.println("temp?");
        double n2 = sc.nextDouble();
        Condition c = new Condition();
        result = c.getAggr(n1, n2);
        System.out.println("result="+result);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mamdani1;

/**
 *
 * @author daria
 */
public class Function {

    public double m(double x, double a, double b, double c, double d) {
        double mu = 0;
        if (x <= a) {
            mu = 0;
        }
        if ((x >= a) && (x <= b)) {
            mu = (x - a) / (b - a);
        }
        if ((x >= b) && (x <= c)) {
            mu = 1;
        }
        if ((x >= c) && (x <= d)) {
            mu = (d - x) / (d - c);
        }
        if (x >= d) {
            mu = 0;
        }
        return mu;
    }

}

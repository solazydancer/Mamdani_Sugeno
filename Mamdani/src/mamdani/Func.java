/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mamdani;

import org.apache.commons.math3.analysis.UnivariateFunction;

/**
 *
 * @author daria
 */

public class Func implements UnivariateFunction {
    
    private double mu;
    private double x;
    
    public Func(double mu, double x) {
        this.mu = mu;
        this.x = x;
    }
    
     public double value(double x) {
         double y = x * mu;
         return y;
     }
 }

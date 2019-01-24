/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sugeno1;

/**
 *
 * @author daria
 */
public class RuleBase {

    static public double getRule(double mx, double my) {
        return (Math.min(mx, my));
    }
}

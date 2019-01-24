/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mamdani1;

import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;

/**
 *
 * @author daria
 */
public class Cond {

    static public double[][] a = new double[6][4];
    static public double[] truth_wea = new double[3];
    static public double[] truth_age = new double[3];
    static public double[] c = new double[3];
    static public double[][] agg = new double[3][3];
    static public double[][] act = new double[3][3];
    static public double[][] actfrom = new double[3][3];
    static public double[] res = new double[3];
    static public double[] b = new double[4];
    static public double min, l = 0;
    static public double weight = 1;
    static public double[] truth_acc = new double[3];
    static public double result = 0;

    public static double getAggr(double x, double temp) {
        b[0] = 0;
        b[1] = 0.4;
        b[2] = 0.6;
        b[3] = 1;
        res[0] = res[1] = res[2] = 0;
        a[0][0] = 0;
        a[0][1] = 20;
        a[0][2] = 30;
        a[0][3] = 40;
        a[1][0] = 25;
        a[1][1] = 30;
        a[1][2] = 40;
        a[1][3] = 50;
        a[2][0] = 45;
        a[2][1] = 50;
        a[2][2] = 60;
        a[2][3] = 75;
        a[3][0] = 15;
        a[3][1] = 30;
        a[3][2] = 35;
        a[3][3] = 40;
        a[4][0] = -5;
        a[4][1] = 15;
        a[4][2] = 20;
        a[4][3] = 30;
        a[5][0] = -15;
        a[5][1] = -5;
        a[5][2] = 0;
        a[5][3] = 5;
        Function f = new Function();
        RuleBase r = new RuleBase();
        //System.out.println("fuzz_age:");
        for (int i = 0; i < 3; i++) {
            truth_age[i] = f.m(x, a[i][0], a[i][1], a[i][2], a[i][3]); 
            //System.out.println(truth_age[i]);
        }
        //System.out.println("fuzz_weather:");
        for (int i = 0; i < 3; i++) {
            truth_wea[i] = f.m(temp, a[i + 3][0], a[i + 3][1], a[i + 3][2], a[i + 3][3]);
            //System.out.println(truth_wea[i]);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                agg[i][j] = Math.min(truth_age[i], truth_wea[j]);
            }
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                act[i][j] = weight * agg[i][j];
            }
        }
        //System.out.println("act_min:");
        for (int i = 0; i < 3; i++) { 
            //System.out.println(" ");
            for (int j = 0; j < 3; j++) {
                actfrom[i][j] = Math.min(act[i][j], truth_wea[j]);
                //System.out.println(actfrom[i][j]);
            }
        }
        //System.out.println("accum_max:");
        for (int i = 0; i < 3; i++) {
            //System.out.println(' ');
            for (int j = 0; j < 3; j++) {
                res[i] = Math.max(res[i], actfrom[i][j]);
                
            }
          //System.out.println(res[i]); 
        }
        SimpsonIntegrator in = new SimpsonIntegrator();
        for (int i = 0; i < 3; i++) {
            truth_acc[i] = f.m(res[i], b[0], b[1], b[2], b[3]);
            
        }
        result = 1;
        for (int k = 0; k < 3; k++) {
            if ((res[k] < result) && res[k] > 0) {
                result = res[k];
            }
        }
        return result;

    }
}

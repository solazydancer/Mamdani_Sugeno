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
public class Condition {

    static public double[][] a = new double[6][4];
    static public double truth_acc[][] = new double[3][3];
    static public double cons[][] = new double[3][3];
    static public double[] truth_wea = new double[3];
    static public double[] truth_age = new double[3];
    static public double y1, y2 = 0;
    static public double[][] agg = new double[3][3];
    static public double[][] act = new double[3][3];

    public static double getAggr(double x, double y) {
        cons[0][0] = 0.4;
        cons[0][1] = 0.2;
        cons[0][2] = 0.3;
        cons[1][0] = 0.2;
        cons[1][1] = 0.1;
        cons[1][2] = 0.2;
        cons[2][0] = 0.3;
        cons[2][1] = 0.2;
        cons[2][2] = 0.4;
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
        //System.out.println("weight:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                truth_acc[i][j] = cons[i][j] * i + j;
                //System.out.println(cons[i][j]);
            }
        }
        //System.out.println(" ");
        Function f = new Function();
        RuleBase r = new RuleBase();
        for (int i = 0; i < 3; i++) {
            truth_age[i] = f.m(x, a[i][0], a[i][1], a[i][2], a[i][3]);
        }
        for (int i = 0; i < 3; i++) {
            truth_wea[i] = f.m(x, a[i + 3][0], a[i + 3][1], a[i + 3][2], a[i + 3][3]);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                agg[i][j] = Math.min(truth_age[i], truth_wea[j]);
            }
        }
       // System.out.println("activ:");
        for (int i = 0; i < 3; i++) {
            //System.out.println(" ");
            for (int j = 0; j < 3; j++) {
                act[i][j] = truth_acc[i][j] * agg[i][j];
               // System.out.println(act[i][j]);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                y1 = y1 + act[i][j];
                y2 = y2 + agg[i][j];
            }
        }
        double y3 = y1/ y2;
        return y3;
    }

}

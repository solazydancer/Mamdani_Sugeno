package mamdani;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;

/**
 *
 * @author daria
 */
public class Mamdani {
static double x,y=0;
static double z,z1,z2,zz1,zz2,zz=0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RuleBase R = new RuleBase();
        x = 2;
        y = 1;
        z1 = R.getCondition1(x);
        z2 = R.getCondition2(y);
        //System.out.println(z1);
        //System.out.println(z2);
        zz1 = Math.min(x, z2);
        zz2 = Math.min(y, z2);
        //System.out.println(z);
        //zz1 = z1*z;
        //zz2 = z2*z;
        zz = Math.max (zz1, zz2);
        System.out.println(zz);
        SimpsonIntegrator i = new SimpsonIntegrator();
        Func f = new Func(zz, x);
        Func f1 = new Func(1.0, x);
        double po1 = i.integrate(100, f, 1, 3);
        double po2 = i.integrate (100, f1, 1, 3);
        double po = po1/po2;
        System.out.println(po);
        
    }
    
}

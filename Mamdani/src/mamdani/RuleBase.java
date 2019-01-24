/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mamdani;

/**
 *
 * @author daria
 */
public class RuleBase {
static double z1,z2=0;    


public static double getCondition1 (double x) {
if (x==1) {
    z1=1;    
}
if (x==2) {
    z1=0.5;   
}
if (x==3) { 
    z1=1;   
}
return z1;
}
public static double getCondition2 (double y) {
if (y==1) {  
    z2=1;  
}
if (y==2) {  
    z2=0.5;
}  
if (y==3) { 
    z2=1;   
}
return z2;
}
}
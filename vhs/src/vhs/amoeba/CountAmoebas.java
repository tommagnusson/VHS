package vhs.amoeba;

/*Count the Amoebas 
Count the number of amoebas that can dance on the head of a pin.
1) The user inputs are:
       The radius of the pinhead 
       The space occupied by an amoeba
       The allowed overlap between amoebas subject to the restriction
       that no space can simultaneously be occupied by more than two
2) The program computes:
       The area of the pinhead based on its radius
       The amount of nonoverlapping space required by an amoeba
       The number of amoebas based on the preceding two values
3) The program ends by printing the number of amoebas.
*/

import java.util.Scanner;

public class CountAmoebas{

   public static void main(String[] args){
      // "The main method only calls to methods"
      printResults(getNumberOfAmoebas(getSurfaceArea(getRadius()), getNonOverlapSpace(getAmoebaSpace(), getOverlapFactor())));
   }

   private static double getRadius() {
      System.out.print("Enter the radius in millimeters: ");
      Scanner reader = new Scanner(System.in);
      return reader.nextDouble();
   }
   
   private static double getOverlapFactor() {
      System.out.print("Enter the overlap factor: ");
      Scanner reader = new Scanner(System.in);
      return reader.nextDouble();
   }

   private static double getAmoebaSpace() {
      System.out.print("Enter the space occupied by an amoeba in square millimeters: ");
      Scanner reader = new Scanner(System.in);
      return reader.nextDouble();
   }

   private static double getSurfaceArea(double radius) {
      return 3.14 * radius * radius;
   }

   private static double getNonOverlapSpace(double amoebaSpace, double overlapFactor) {
      return amoebaSpace * (1.0 - overlapFactor);
   }

   private static double getNumberOfAmoebas(double area, double nonOverlapSpace) {
      return area / nonOverlapSpace;
   }

   private static void printResults(double numberOfAmoebas) {
      System.out.println("The number of amoebas is " + numberOfAmoebas);
   }
}

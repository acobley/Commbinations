/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combinations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author andy
 */
public class Combinations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Family> families = new ArrayList<Family>();
        ArrayList EitherChild = new ArrayList();
        ArrayList FirstChild = new ArrayList();
        int[] count = {0, 0, 0, 0};

        for (int i = 0; i < 100000; i++) {
            families.add(new Family());
        }

        //Do a count of families
        CountFamiles(families,count);
        System.out.println("Population");
        for (int i = 0; i <= 3; i++) {
            System.out.println("Count " + i + " Value " + count[i]);
            count[i] = 0;
        }
        Iterator<Family> family = families.iterator();
        //Make populations that fit the criteria, 
        while (family.hasNext()) {
            
            Family f = family.next();
            if (f.eitherChild() == true) {
                EitherChild.add(f);
            }
            if (f.Child1() == true) {
                FirstChild.add(f);
            }
        }
        float R1 = (float) (EitherChild.size() / 10000.0);
        float R2 = (float) (FirstChild.size() / 10000.0);
        System.out.println("Either Child " + EitherChild.size() + " Ratio " + R1);
        System.out.println("First Child " + FirstChild.size() + " Ratio " + R2);
        float Ratio = R2 / R1;
        System.out.println("Ratio " + Ratio);

        //Pick random families and count how many have two children thatare male.
        
        int iEitherChild=0;
        for (int i=0;i<9999;i++){ //Select 10,000 random families
            int Count=EitherChild.size();
            int iRandomFamily=(int)(Count*Math.random());
            Family   RandomFamily=(Family)EitherChild.get(iRandomFamily);
            EitherChild.remove(iRandomFamily);  //Don't select this one again
            if ((RandomFamily.Child2()==true) && (RandomFamily.Child1()==true))
                iEitherChild++;
        }
        
        int iFirstChild=0;
        for (int i=0;i<9999;i++){ //Select 10,000 random families
            int Count=FirstChild.size();
            int iRandomFamily=(int)(Count*Math.random());
            Family RandomFamily=(Family)FirstChild.get(iRandomFamily);
            FirstChild.remove(iRandomFamily);  //Don't select this one again
            if ((RandomFamily.Child2()==true) && (RandomFamily.Child1()==true))
                iFirstChild++;
        }
        
        System.out.println("NUmber correct for either Child "+iEitherChild +" Ratio "+(float)(iEitherChild /10000.0));
        System.out.println("NUmber correct for first Child "+iFirstChild+" Ratio "+(float)(iFirstChild /10000.0));
        System.out.println("Ratio "+ (float)((iEitherChild /10000.0))/(iFirstChild /10000.0));
        System.out.println("Done -----------------------");    
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        
        
        
        
    }

    static void CountFamiles(List<Family> families, int[] count){
         Iterator<Family> family = families.iterator();
        
        while (family.hasNext()) {
            
            Family f = family.next();
            boolean child1 = f.Child1();
            boolean child2 = f.Child2();

            if (child1 == false) {
                if (child2 == false) {
                    count[0]++;
                } else {
                    count[1]++;
                }
            } else //child1 is true;
            if (child2 == false) {
                count[2]++;
            } else {
                count[3]++;
            }
        }
        
    }
}

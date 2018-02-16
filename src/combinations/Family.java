/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combinations;

/**
 *
 * @author andy
 */
public class Family {
     
    int child1=0;
    int child2=0;
    Family(){
        //number range =0-9
        int child1=(int)(10.0*Math.random());
        int child2=(int)(10.0*Math.random());
       
        if (child1>=5)
            this.child1=1;
        if (child2<5)
            this.child2=1;
    }
    
    boolean eitherChild(){
        if ((child1==1) || (child2==1)){
            return true;
    }
        return false;
    }
    
    boolean Child1(){
        if (child1==1){
            return true;
        }
        return false;
    }
    
    boolean Child2(){
        if (child2==1){
            return true;
        }
        return false;
    }
    
}


package calculator;


import java.util.Scanner;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.lang.*;
public class Driver {

    public static void main(String[] args) throws ScriptException {

        System.out.println("Put Expression");  
        
        Scanner s = new Scanner(System.in);
        
        StringBuilder str = new StringBuilder(s.nextLine());
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engin = mgr.getEngineByName("JavaScript");

        try{
            engin.eval(str.toString());
            System.out.println("No error");
            
       
            if(str.indexOf("^")==-1){
            System.out.println( engin.eval(str.toString()));
            }

            //(4^5)^2//4^5^2
            else{ 
                str.insert(0,"S");
                str.append("S");
          
                while(str.indexOf("^")!=-1){
                
                    
                if(str.substring(0, 1).equals("S")==false){
                     str.insert(0,"S");
                }
                if(str.substring(str.length()-1).equals("S")==false){
                str.append("S");
               
                }    
                    
                    
                int a =str.indexOf("^");
                String x="";
                
                String y="";
                
                int start=0;
                
                int end =0;
                
                for( int i =a;i>0;i--){
                    if(str.substring(i-1, i).equals("+")==true||
                            str.substring(i-1, i).equals("-")==true||
                            str.substring(i-1, i).equals("/")==true||
                            str.substring(i-1, i).equals("*")==true||
                            str.substring(i-1, i).equals("(")==true||
                            str.substring(i-1, i).equals(")")==true||
                            str.substring(i-1, i).equals("^")==true||
                            str.substring(i-1,i).equals("S")==true){
                       x = str.substring(i,a);
                        System.out.println(x);
                        start =i;
                        System.out.println(start+"      &&&");
                        i=0;
                    }
                }
                for(int i =a;i<str.length()-1;i++){
                        if(str.substring(i+1, i+2).equals("+")==true||
                                str.substring(i+1, i+2).equals("-")==true||
                                str.substring(i+1, i+2).equals("/")==true||
                                str.substring(i+1, i+2).equals("*")==true||
                                str.substring(i+1, i+2).equals("(")==true||
                                str.substring(i+1, i+2).equals(")")==true||            
                                str.substring(i+1, i+2).equals("^")==true||
                                str.substring(i+1, i+2).equals("S")==true)
                        {
                            y= str.substring(a+1,i+1);
                            System.out.println(y);
                            end =i;
                            System.out.println(end+"     &&&");
                            i=str.length();
                           }
                            }

                
                System.out.println(str+"      ****");
                System.out.println(x+"    x and y value    "+y);
                 
                double result = Math.pow(Double.valueOf(x),Double.valueOf(y));
                   
                System.out.println(result+"      &&&7");
                
                str.delete(start, end+1);
                
                System.out.println(str+"     &&&&&    Test1");
                
                str.insert(start, Double.toString(result));
                
                System.out.println(str+"    &&&&&    Test2");
                }
                
                System.out.println(str);
                
                if(str.substring(0, 1).equals("S")){
                     str.deleteCharAt(0);
                }
                
                if(str.substring(str.length()-1).equals("S")){
                str.deleteCharAt(str.length()-1);
               }
                
                
                  System.out.println( "Answer: "+engin.eval(str.toString()));
                }

        }
     
     catch(ScriptException e){
         System.out.println("ERROR: Wrong expression");//+e.toString());
     }
    }

    
}

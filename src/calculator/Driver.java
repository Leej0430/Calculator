
package calculator;


import java.awt.event.*; 
import javax.swing.*; 
import java.awt.*; 
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

class Driver extends JFrame implements ActionListener { 
    // create a frame 
    static JFrame f; 
  
    // create a textfield 
    static JTextField l; 
    
    // store oprerator and operands 
    String s0, s1, s2; 
  
    // default constrcutor 
    Driver() 
    { 
        s0 = s1 = s2 = ""; 
    } 
  
    // main function 
    public static void main(String args[]) 
    { 
        // create a frame 
        f = new JFrame("calculator"); 
  

  
        // create a object of class 
        Driver c = new Driver(); 
  
        // create a textfield 
        l = new JTextField(16); 
  
        // set the textfield to non editable 
        l.setEditable(false); 
  
        // create number buttons and some operators 
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1,beq2,beq3,beq4; 
  
        // create number buttons 
        b0 = new JButton("0"); 
        b1 = new JButton("1"); 
        b2 = new JButton("2"); 
        b3 = new JButton("3"); 
        b4 = new JButton("4"); 
        b5 = new JButton("5"); 
        b6 = new JButton("6"); 
        b7 = new JButton("7"); 
        b8 = new JButton("8"); 
        b9 = new JButton("9"); 
  
        // equals button 
        beq1 = new JButton("="); 
  
        // create operator buttons 
        ba = new JButton("+"); 
        bs = new JButton("-"); 
        bd = new JButton("/"); 
        bm = new JButton("*"); 
        beq = new JButton("C"); 
        beq2 = new JButton("(");
        beq3 = new JButton(")");
        beq4 = new JButton("^");
        // create . button 
        be = new JButton("."); 
  
        // create a panel 
        JPanel p = new JPanel(); 
  
        // add action listeners 
        bm.addActionListener(c); 
        bd.addActionListener(c); 
        bs.addActionListener(c); 
        ba.addActionListener(c); 
        b9.addActionListener(c); 
        b8.addActionListener(c); 
        b7.addActionListener(c); 
        b6.addActionListener(c); 
        b5.addActionListener(c); 
        b4.addActionListener(c); 
        b3.addActionListener(c); 
        b2.addActionListener(c); 
        b1.addActionListener(c); 
        b0.addActionListener(c); 
        be.addActionListener(c); 
        beq.addActionListener(c); 
        beq1.addActionListener(c); 
        beq2.addActionListener(c);
        beq3.addActionListener(c);
        beq4.addActionListener(c);
        // add elements to panel 
        p.add(l); 
        p.add(ba); 
        p.add(b1); 
        p.add(b2); 
        p.add(b3); 
        p.add(bs); 
        p.add(b4); 
        p.add(b5); 
        p.add(b6); 
        p.add(bm); 
        p.add(b7); 
        p.add(b8); 
        p.add(b9); 
        p.add(bd); 
        p.add(be); 
        p.add(b0); 
        p.add(beq); 
        p.add(beq4); 
        p.add(beq2); 
        p.add(beq3); 
        p.add(beq1); 
  
        // set Background of panel 
        p.setBackground(Color.red); 
  
        // add panel to frame 
        f.add(p); 
  
        f.setSize(220, 300); 
        f.show(); 
    } 
    public void actionPerformed(ActionEvent e) 
    { 
        
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engin = mgr.getEngineByName("JavaScript");
        
    String s = e.getActionCommand(); 
  
        // if the value is a number 
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') ||
                s.charAt(0) == '.'||
                s.charAt(0) == '+'||
                s.charAt(0) == '-'||
                s.charAt(0) == '^'||
                s.charAt(0) == '/'||
                s.charAt(0) == '*'||
                s.charAt(0) == '('||
                s.charAt(0) == ')')
            
                 { 

                s0 = s0 + s; 
            // set the value of text 
            l.setText(s0); 
        } 
        else if (s.charAt(0) == 'C') { 
            // clear the one letter 
            s0 = "";  
           l.setText(s0 ); 
        } 
        else if (s.charAt(0) == '=') { 
            StringBuilder str = new StringBuilder(s0);
            try{
            engin.eval(str.toString());
            
       
            if(str.indexOf("^")==-1){
            l.setText( engin.eval(str.toString()).toString());
            }


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

                        start =i;

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

                            end =i;
 
                            i=str.length();
                           }
                            }

                

                 
                double result = Math.pow(Double.valueOf(x),Double.valueOf(y));
                   

                
                str.delete(start, end+1);
                

                
                str.insert(start, Double.toString(result));
                

                }
                

                
                if(str.substring(0, 1).equals("S")){
                     str.deleteCharAt(0);
                }
                
                if(str.substring(str.length()-1).equals("S")){
                str.deleteCharAt(str.length()-1);
               }
                
                
                  l.setText("Result: "+engin.eval(str.toString()));
                }

        }
     
     catch(ScriptException x){
        l.setText("ERROR: Wrong expression");
    }
    } 
}
}

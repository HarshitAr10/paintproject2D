
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;



public class maindraw extends JFrame 
{
    JPanel p1;
    JPanel p2;
    JPanel p3;
    JPanel p4;
    JButton undo;
    JButton clr;
    JButton fstbutton;
    JButton scdbutton;
    JLabel jl1;
    JLabel jl2;
    JLabel jl3;
    JComboBox shapelist;
    Stroke str2 ;
    JCheckBox cb1; 
    JCheckBox cb2;
    JCheckBox cb3;
    JTextField tf1 ;
    JTextField tf2 ;
    DrawPanel d1;
    int lw2, dsl2;
    private Color color1 = Color.WHITE, color2 = Color.WHITE;

    
    public maindraw()
    {
        super("2D Drawing Application");
        setLayout(new BorderLayout());
        
        
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        d1 = new DrawPanel(this);
        undo = new JButton("Undo");
        clr = new JButton("Clear");
        jl1 = new JLabel("Shape:");
        
        
        shapelist = new JComboBox<>();
        shapelist.addItem("Line");
        shapelist.addItem("Rectangle");
        shapelist.addItem("Oval");
        cb1 = new JCheckBox("Filled");
        cb2 = new JCheckBox("Use Gradient");
        fstbutton = new JButton("1st Color");
        scdbutton = new JButton("2nd Color");
        jl2 = new JLabel("Line Width:");
        tf1 = new JTextField(2);
        jl3 = new JLabel("Dash Length:");
        tf2 = new JTextField(2);
        cb3 = new JCheckBox("Dashed");
        str2 = new BasicStroke(0, BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
        
    
        p1.add(undo);
        p1.add(clr);
        p1.add(jl1);
        p1.add(shapelist);
        p1.add(cb1);
        
        p2.add(cb2);
        p2.add(fstbutton);
        p2.add(scdbutton);
        p2.add(jl2);
        p2.add(tf1);
        p2.add(jl3);
        p2.add(tf2);
        p2.add(cb3);
        
        p3.setLayout(new BorderLayout());
        p3.add(p1,BorderLayout.NORTH);
        p3.add(p2,BorderLayout.SOUTH);
        
        add(p3,BorderLayout.NORTH);
       add(d1,BorderLayout.CENTER);
        
        Actionh1 action1 = new Actionh1();
        fstbutton.addActionListener(action1);
        scdbutton.addActionListener(action1);
        undo.addActionListener(action1);
        clr.addActionListener(action1);
        shapelist.addActionListener(action1);
        cb1.addActionListener(action1);
        cb2.addActionListener(action1);
        tf1.addActionListener(action1);
        tf2.addActionListener(action1);
    }
    
    private class Actionh1 implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
        
            if ( e.getSource() == undo)
            {
                d1.undoaction();
            }
            else if (e.getSource() == clr)
            {
                d1.clearpanel();
            }
            else if (e.getSource() == shapelist)
            {
                if(shapelist.getSelectedItem() == "Line")
                {
                    d1.cshapetype(0);
                }
                else if(shapelist.getSelectedItem() == "Rectangle")
                {
                    d1.cshapetype(1);
                }
                else if(shapelist.getSelectedItem() == "Oval")
                {
                    d1.cshapetype(2);
                }
                
            }
            /*
            else if (e.getSource() == cb1)
            {
                if (cb1.isSelected())
                {
                    f = true;
                    d1.setfilled(true);
                }
                
                else  
                {
                    f = false;
                    d1.setfilled(false);
                }
                
            }*/
            /*
            else if (e.getSource() == cb2)
            {
                 if (cb2.isSelected())
                {
                    g = true;
                    d1.gradientchk(true);
                }
                
                else  
                {
                    g = false;
                    d1.gradientchk(false);
                }
            }
            */
            else if (e.getSource() == fstbutton)
            {
                
                color1 = JColorChooser.showDialog(maindraw.this,"Choose a color",color1);
                if (color1 == null)
                {
                    color1 = Color.WHITE;
                }
                /*else{
                    
                    d1.ccolor(color1);
                }*/
                }
                
            else if (e.getSource() == scdbutton)
            {
                color2 = JColorChooser.showDialog(maindraw.this,"Choose a color",color2);
                
               if (color2 == null)
                {
                    color2 = Color.WHITE;
                }
               /*else {
                   d1.ccolor2(color2);
               }*/
                    
                }
            /*
            else if (e.getSource() == tf1)
            {
                int lw;
                lw = parseInt(tf1.getText());
                str2 = new BasicStroke(lw, BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
                d1.curstrk(str2);
            }
            */
            /*
            else if (e.getSource() == cb3 )
            {
                if (cb3.isSelected())
                {
                    
                }
               
            }
            */
            /*
            else if( e.getSource() == tf2)
            {
                lw2 = parseInt(tf1.getText());
                dsl2 = parseInt(tf2.getText());
                dash[0] = dsl2;
                str2 = new BasicStroke(lw2, BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,10,dash,0);
                d1.curstrk(str2);
            }
            */
            
                
            }
        
  
            
    }
        public boolean gf(){
            if (cb1.isSelected()){
                d1.setfilled(true);
                return true;
            }
            else{
                 d1.setfilled(false);
                return false;
            }
        }
        
        public boolean gg(){
            if (cb2.isSelected())
            {
                
                return true;
            }
            else{
               
                return false;
            }
        }
        
        public boolean gd(){
            if (cb3.isSelected()){
                return true;
            }
            else{
                
                return false;
            }
        }
        
        public int gw(){
            try{
                int i = Integer.parseInt(tf1.getText());
                return i;
            }
            catch(Exception e){
            return 1;
            }
        }
        
        public float gd2(){
            try{
                float i = Float.parseFloat(tf2.getText());
                return i;
            }
            catch(Exception e){
            return 1;
            }
        }
        
        public Color c1(){
        return color1;
    }
        public Color c2(){
            if (color2 == null)
            {
           d1.setfilled(true);
        }
             return color2;
        }


}


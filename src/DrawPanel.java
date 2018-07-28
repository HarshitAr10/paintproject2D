
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawPanel extends JPanel{
    
    ArrayList<shape1> shapes1 = new ArrayList();
    private int shapetype;
    private shape1 currentshape;
    private Color currentcolor1;
    private Color currentcolor2;
    private Paint currentcolor3;
    private Stroke currentstrk ;
    private boolean filledshape;
    private boolean gradient = false;
    private JLabel statusl;
    private maindraw md;
    private float[] d = new float[1];
  
    
    
    public DrawPanel(maindraw md)
    {
        super();
        statusl = new JLabel("(0,0)");
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        add(statusl, BorderLayout.SOUTH);
        mouseMotionHandler h1 = new mouseMotionHandler();
        addMouseListener(h1);
        addMouseMotionListener(h1);
        this.md = md;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        for ( shape1 s1: shapes1)
        {s1.draw(g2d);}}
    
    public void cshapetype(int t)
    {
         this.shapetype = t;   
    }
    
    public void ccolor(Color c)
    {
         this.currentcolor1 = c;   
    }
    public void ccolor2(Color c2)
    {
         this.currentcolor2 = c2;   
    }
    public void curstrk(Stroke s)
    {
       this.currentstrk = s; 
    }
    
    public void setfilled(boolean f)
    {
        this.filledshape = f;
    }
    
    
    public void gradientchk(boolean g)
    {
        this.gradient = g;
    }
   
    public void clearpanel()
    {
        shapes1.clear();
        repaint();
        
    }
    public  void undoaction()
    {
        if(!shapes1.isEmpty())
        {
        shapes1.remove(shapes1.size()-1);
        repaint();
        }
    }
    
    
    private class mouseMotionHandler extends MouseAdapter implements MouseMotionListener{

        @Override
        public void mousePressed(MouseEvent e) 
        {
            
            
            currentcolor3 = new GradientPaint(0,0,md.c2(),50,50,md.c1(),md.gg());
            
            if (!md.gd()){
                currentstrk = new BasicStroke(md.gw(), BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
            }
            else{
                d[0] = md.gd2();
                currentstrk = new BasicStroke(md.gw(), BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,10,d,0);
            }
            if (shapetype == 0)
            {
             currentshape = new line(e.getX(),e.getY(),currentstrk,currentcolor3);   
             shapes1.add(currentshape);
            }
            
            if (shapetype == 1)
            {
                currentshape = new rectangle(e.getX(),e.getY(),currentstrk,currentcolor3, md.gf());
                shapes1.add(currentshape);
            }
            
            if (shapetype == 2)
            {
                currentshape = new oval(e.getX(),e.getY(),currentstrk,currentcolor3,md.gf());
                shapes1.add(currentshape);
            }
        }
        
        
        @Override
        public void mouseMoved(MouseEvent e) 
        {
           statusl.setText(String.format("(%d,%d)", e.getX(), e.getY()));
        }
        @Override
        public void mouseDragged(MouseEvent e)
        {
            
            if (currentshape != null)
            {
            currentshape.setendxy(e.getX(),e.getY());  
            
            repaint();
            }
        }
    }
        
        
    
    
}

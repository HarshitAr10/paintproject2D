
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;


public class rectangle extends boundedshapes {

    public rectangle(int x, int y, Stroke str, Paint pnt, boolean f) 
    {
        super(x, y, str, pnt, f);
    }
        
   
   @Override
    public void draw(Graphics2D g2d)
    {
        g2d.setPaint(getpnt());
        g2d.setStroke(getstrk());
        
        if (getfilled() == true)
        {
            
            
            g2d.fillRect(gettopX(),gettopy() , getheight(), getwidth());
        }
        else
            
        {
        
            g2d.drawRect(gettopX(),gettopy() ,getheight(),getwidth());
        }
}}

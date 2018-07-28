
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;


public class oval extends boundedshapes
{
    private boolean filled;
    public oval(int x, int y, Stroke str, Paint pnt,boolean d) {
        super(x, y, str, pnt, d);
    }
    @Override
    public void draw(Graphics2D g2d)
    {
        g2d.setPaint(getpnt());
            g2d.setStroke(getstrk());
        if (getfilled())
        {
            
         
            g2d.fillOval(gettopX(),gettopy(),getheight(),getwidth());
        }
        else
            
        {
            
            g2d.drawOval(gettopX(),gettopy(),getheight(),getwidth());
        }
}}

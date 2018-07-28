
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;


public class line extends shape1 
{
public line(int x, int y, Stroke str, Paint pnt)
{
    super(x,y,str,pnt);
}
    @Override
public void draw(Graphics2D g2d){
    g2d.setPaint(getpnt());
    g2d.setStroke(getstrk());
    g2d.drawLine(getx1(),gety1() ,getx2(), gety2());
    
    
}
}

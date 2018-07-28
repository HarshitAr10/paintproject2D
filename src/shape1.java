
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;


public abstract class shape1 {
    
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Stroke str;
    private Paint paint;
    
    public shape1(int x, int y, Stroke s1, Paint p1)
    {
        x1 = x;
        x2 = x;
        y1= y;
        y2= y;
        str = s1;
        paint = p1;
       
    }
    
    public void setendxy(int x, int y)
    {
        x2 = x;
        y2 = y;
    }
    
    public int getx1()
    {
        return x1;
    }
    
    public int gety1()
    {
        return y1;
    }
    
    public int getx2()
    {
        return x2;
    }
    
    public int gety2()
    {
        return y2;
    }
    
    public void setStroke(Stroke s)
    {
        this.str = s;
    }
    public void setPaint(Paint p)
    {
        this.paint = p;
    }
   
    public Stroke getstrk()
    {
        return str;
    }
    
    public Paint getpnt()
    {
        return paint;
    }
    
    
    public abstract void draw(Graphics2D g2d);
}

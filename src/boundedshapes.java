
import java.awt.Paint;
import java.awt.Stroke;


public abstract class boundedshapes extends shape1
{
    private boolean filled;
    
    public boundedshapes(int x, int y, Stroke str, Paint pnt, boolean f) {
        super(x, y, str, pnt);
        this.filled = f;
    }
    
    private void setfilled(boolean f)
    {
        filled = f;
    }
    
    public boolean getfilled()
    {
        return filled;
    }
    
    
    public int gettopX()
    {
        int t;
        t = Math.min(getx1(), getx2());
        return t; 
    }
    
    public int gettopy()
    {
        int y;
        y = Math.min(gety1(), gety2());
        return y; 
    }
    
    public int getheight()
    {
        //int h ;
        //h = 
        return Math.abs(getx2()-getx1());
    }
    
    public int getwidth()
    {
        //int w ;
        //w = 
        return Math.abs(gety2()-gety1());
    }
    
}
    


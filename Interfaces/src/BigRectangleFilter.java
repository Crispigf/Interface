import java.awt.Rectangle;

public class BigRectangleFilter implements Filter{
    @Override
    public boolean accept(Object x) {
        if(x instanceof Rectangle){
            Rectangle r = (Rectangle) x;
            return((r.width + r.height)*2) > 10;
        }
        return false;
    }
}

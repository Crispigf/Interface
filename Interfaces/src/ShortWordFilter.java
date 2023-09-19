
import java.lang.String;
import java.util.*;
public class ShortWordFilter implements Filter{
    @Override
    public boolean accept(Object x) {
        if(x instanceof String){
            String r = (String) x;
            return r.length() <5;
        }
        return false;
    }
}

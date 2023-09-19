import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class BigRectLister {


    public static void main(String[] args) {
        BigRectangleFilter rMeasure = new BigRectangleFilter();
        ArrayList<Object> rects = new ArrayList<>();


        rects.add(new Rectangle(1,2));
        rects.add(new Rectangle(1,1));
        rects.add(new Rectangle(1,3));
        rects.add(new Rectangle(2,2));
        rects.add(new Rectangle(2,4));
        rects.add(new Rectangle(2,6));
        rects.add(new Rectangle(3,3));
        rects.add(new Rectangle(3,4));
        rects.add(new Rectangle(3,5));
        rects.add(new Rectangle(16,20));


        System.out.println("Unfiltered rectangles:");
        for (Object re : rects) {
            Rectangle rect = (Rectangle) re;
            System.out.println("Rectangle perimeter: " + (2 * (rect.width + rect.height)));
        }

        rects = collectAll(rects, new BigRectangleFilter());

        // displaying filtered rectangles
        System.out.println("\nFiltered rectangles:");
        for (Object re : rects) {
            Rectangle rect = (Rectangle) re;
            System.out.println("Rectangle perimeter: " + (2 * (rect.width + rect.height)));
        }

    }
    public static ArrayList<Object> collectAll(ArrayList<Object> objects, Filter f)
    {
        ArrayList<Object> ans = new ArrayList<>();
        for (Object x: objects)
        {
            if(f.accept(x))
            {
                ans.add(x);
            }
        }
        return ans;
    }

}

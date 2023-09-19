import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoterLister {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Object> words = new ArrayList<>();

        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        // set the chooser to the project src directory
        chooser.setCurrentDirectory(target.toFile());

        try  // Code that might trigger the exception goes here
        {

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();  // this is a File object not a String filename

                inFile = new Scanner(target);
                while(inFile.hasNextLine())
                {
                    line = inFile.nextLine();
                    words.add(line);
                }

                inFile.close();
                words = collectAll(words, new ShortWordFilter());
                System.out.println("Filtered words: ");
                for (Object wrd : words){
                    System.out.println(wrd);
                }
            }
            else   // User did not pick a file, closed the chooser
            {
                System.out.println("Sorry, you must select a file! Termininating!");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        }
        catch (IOException e) // code to handle this exception
        {
            System.out.println("IOException Error");
            e.printStackTrace();
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



    //public static ArrayList<Object> collectAll(ArrayList<Object> )
}



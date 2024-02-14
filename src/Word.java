import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Word {
    private static List<String> words = new ArrayList<>();

    public static Word fillList(){
        try{
            Scanner sc = new Scanner(new File("words.txt"));
            String data = "";
            while (sc.hasNextLine()) {
                data = sc.nextLine();
                words.add(data);
            }
            sc.close();
        }catch(IOException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String getWord(){
        Random ran = new Random();
        return words.get(ran.nextInt(words.size()));
    }
}
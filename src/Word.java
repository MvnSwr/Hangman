import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class Word {
    private static List<String> words;

    private static Word fillList(String str){
        try{
            words = new ArrayList<>();
            Scanner sc = new Scanner(new File(str));
            String data = "";
            while (sc.hasNextLine()) {
                data = sc.nextLine().toLowerCase();
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
        Word.fillList("words.txt");
        Random ran = new Random();
        return words.get(ran.nextInt(words.size()));
    }

    public static List<String> getAlphabet(){
        Word.fillList("alphabet.txt");
        return words;
    }
}
import java.util.List;
import java.util.Scanner;
public class Game {
    private static char[] word;
    private static char[] guess;
    private static List<String> alphabet;
    private static Playingfield field;
    private static Scanner sc;

    public static void main(String[] args){
        //initialize
        word = Word.getWord().toCharArray();
        guess = new char[word.length];
        alphabet = Word.getAlphabet();
        field = new Playingfield();
        sc = new Scanner(System.in);

        //handling of blanks
        for(int i = 0; i < guess.length; i++){ //Bessere Handhabung ToDo!!
            if(word[i] == ' '){
                guess[i] = ' ';
            }
        }

        //game loop
        while(field.getPointer() < field.length()){
            char c;
            Boolean win = true;
            Boolean hit = false;

            //clear Console
            System.out.print("\033[H\033[2J");  
            System.out.flush();   //Doesnt work right yet ToDo!!

            //get playfield
            field.getField();

            //create the visual from the guess
            for(char str : guess){
                if(str == '\u0000'){ //the unicode NULL-value of a char
                    System.out.print("_");
                }else if(str == ' '){
                    System.out.print(" ");
                }else{
                    System.out.print(str);
                }
            }

            //check if won
            for(int i = 0; i < guess.length; i++){
                if(guess[i] != word[i]){
                    win = false;
                }
            }

            //WON
            if(win){
                System.out.println("\nWINNER!!");
                System.exit(0);
            }


            //scan and check the input
            while(true){
                System.out.print("\nGuess: ");
                String s = sc.next().toLowerCase();
                
                if (s.length() <= 0) {
                    System.out.println("No character entered!");
                } else if(!alphabet.contains(s.subSequence(0, 1))){
                    System.out.println("Character already entered!");
                }else{
                    c = s.charAt(0);
                    break;
                }
            }

            //check if the input was right
            for(int i = 0; i < guess.length; i++){
                if(word[i] == c){
                    guess[i] = c;
                    hit = true;
                }
            }
            if(hit){
                field.decreasePointer();
            }
            alphabet.remove(c + "");
        }

        //Game Over
        field.getField();
        sc.close();
        System.out.println("The word was: " + new String(word));
        System.exit(0);
    }
}
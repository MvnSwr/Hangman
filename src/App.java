public class App {
    public static void main(String[] args){
        String str = "";
        try{
            str = Word.fillList().getWord();
        }catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        
    }
}

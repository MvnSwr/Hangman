public class App {
    public static void main(String[] args){
        String str = "";
        try{
            str = Word.getWord();
            System.out.println(str);
        }catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}

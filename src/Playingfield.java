public class Playingfield {
    private String[] field;
    private int pointer;

    public Playingfield(){
        this.pointer = 0;
        this.field = new String[10];
        field[0] = "\n\n\n\n\n\n=========\n";
        field[1] = "\n       +\n       |\n       |\n       |\n       |\n       |\n=========\n";
        field[2] = "\n   +---+\n       |\n       |\n       |\n       |\n       |\n=========\n";
        field[3] = "\n   +---+\n   |   |\n       |\n       |\n       |\n       |\n=========\n";
        field[4] = "\n   +---+\n   |   |\n   O   |\n       |\n       |\n       |\n=========\n";
        field[5] = "\n   +---+\n   |   |\n   O   |\n   |   |\n       |\n       |\n=========\n";
        field[6] = "\n   +---+\n   |   |\n   O   |\n  /|   |\n       |\n       |\n=========\n";
        field[7] = "\n   +---+\n   |   |\n   O   |\n  /|\\  |\n       |\n       |\n=========\n";
        field[8] = "\n   +---+\n   |   |\n   O   |\n  /|\\  |\n  /    |\n       |\n=========\n";
        field[9] = "\n   +---+\n   |   |\n   O   |\n  /|\\  |\n  / \\  |\n       |\n=========\n\nGame Over!!";
    }

    public void getField(){
        if(pointer <= 9){
            System.out.println(field[pointer++]);
            return;
        }
        throw new gameOverError("The game has ended");
    }

    public int getPointer(){
        return pointer;
    }

    public void decreasePointer(){
        this.pointer--;
    }

    public int length(){
        return field.length-1;
    }
}
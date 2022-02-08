import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class TestPuzzleJava {
    public static void main(String[] args){
        PuzzleJava generator = new PuzzleJava();
        ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println(randomRolls);

        System.out.println(generator.getRandomLetter());
        System.out.println(generator.getRandomPassword());
        System.out.println(generator.getNewPasswordSet(8));
        String[] newArry = generator.getNewPasswordSet(8);
        System.out.println(Arrays.toString(newArry));
        System.out.println(Arrays.toString(generator.shuffleArray(newArry)));
    }

    

}
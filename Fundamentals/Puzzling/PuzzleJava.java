import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class PuzzleJava {

    public ArrayList<Integer> getTenRolls() {

        ArrayList<Integer> random10 = new ArrayList<Integer>();
        Random rand = new Random();

        for (int i = 1; i <=10; i++) {
            random10.add(rand.nextInt(20) + 1);
        }

        return random10;
    }

    public String getRandomLetter() {
        Random rand = new Random();
        String[] alphabets = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        

        return alphabets[rand.nextInt(26)];
    }

    public String getRandomPassword() {
        String password = new String();
        for(int i = 0; i < 8; i++) {
            password += getRandomLetter();
        }
        return password;
    }

    public String[] getNewPasswordSet(int length) {

        String[] passwordSet = new String[length];
        for(int i = 0; i < length; i++) {
            passwordSet[i] = getRandomPassword();
        }
        return passwordSet;

    }

    public String[] shuffleArray(String[] Array){
        
        Random rand = new Random();
        for(int i = 0; i < Array.length; i++){
            int randomIndex = rand.nextInt(Array.length);
            String temp = Array[i];
            Array[i] =  Array[randomIndex];
            Array[randomIndex] = temp;
        }
        return Array;
    }

}
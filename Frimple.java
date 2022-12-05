import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class Frimple {

    // Checks the word list to see if the word is legal
    public static boolean contains(String[] search, String question, int length){
        for(int i = 0; i < length; i++){
            if(search[i].equals(question)){
                return true;
            }
        }
        return false;
    }

    public static boolean allContains(ArrayList<String> search, String[] question, int length){
        int present = 0;

        for(int i = 0; i < length; i++){
            if(search.contains(question[i])){
                present++;
            }
        }

        if(present == length){
            return true;
        }
        return false;
    }

    //Needed to input a timer here as well as a score system?
    public static void main(String[] args) {
        // Initialize the neccessary structures before the game begins
        String[] wordList = new String[15000];
        ArrayList<String> guess = new ArrayList<String>(1);
        Scanner fileScan = null;
        int length = 0;
        File inputFile = new File("C:/Users/Liam/Desktop/FrimbleWordList.txt");

        // This will read the file and then make an array list of legal words for the
        // game
        try {
            fileScan = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.exit(1);
        }

        while (fileScan.hasNext()) {
            String word = fileScan.next();
            wordList[length] = word;
            length = length + 1;
        }

        // Start the game with player scanners
        Scanner ansOne = new Scanner(System.in);
        Scanner ansTwo = new Scanner(System.in);
        int turnCount = 1;
        String key;

        while(turnCount <= 3){
        System.out.println("Word number " + turnCount);
        String ans = ansOne.nextLine();
        key = "ade";
        String[] keyBreak = key.split("");

        String[] split = ans.split("");
        
        for(int i = 0; i < split.length; i++){
            guess.add(split[i]);
        }

            if(contains(wordList, ans, length) == true && allContains(guess, keyBreak, keyBreak.length)){

                System.out.println(ans);
                turnCount++;
            }
            else{
                System.out.println("Please pick another word!");
            }

            guess.clear();
        }

    }
}

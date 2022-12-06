import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Advent1 {



    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        ArrayList<String> elves = new ArrayList<String>();
        int currentElf = 0;
        int highScore = 0;


       while (scan.hasNextLine()){
           elves.add(scan.nextLine());
        }

        int[] elfStats = new int[elves.size()];

       for(int i=0; i<elves.size(); i++){
           if(elves.get(i).length() > 0){
               elfStats[i] = Integer.parseInt(elves.get(i));
               currentElf += elfStats[i];
           }
           else {
               highScore = Math.max(currentElf, highScore);
               currentElf = 0;
           }
       }


        System.out.println("Highest combined caloric intake: " + highScore);








    }
}

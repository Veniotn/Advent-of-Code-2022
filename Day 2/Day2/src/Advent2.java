import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Advent2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        String currentRound = "";
        int score = 0;

        while (scan.hasNextLine()){
            currentRound = scan.nextLine();
            score += combatScore(currentRound);
        }


        System.out.println(score);
    }


    public static int combatScore(String currentRound){
        char enemyMove;
        char playerMove = '\0';
        for (int i=0; i<currentRound.length(); i++){
            enemyMove = currentRound.charAt(i);
            playerMove = currentRound.charAt(i+2);
            if(enemyMove == 'A' && playerMove == 'X'){
                return draw(playerMove);
            } else if (enemyMove == 'A' && playerMove == 'Y'){
                return win(playerMove);
            } else if (enemyMove == 'B' && playerMove == 'Y') {
                return draw(playerMove);
            } else if (enemyMove == 'B' && playerMove == 'Z') {         //A little brute force but it works
                return win(playerMove);
            } else if (enemyMove =='C' && playerMove == 'X') {
                return win(playerMove);
            } else if (enemyMove == 'C' && playerMove == 'Z') {
                return draw(playerMove);
            }else {
                return shapeValue(playerMove);
            }
        }
        return shapeValue(playerMove);
    }

    public static int win(char playerMove){
        return shapeValue(playerMove) + 6;
    }

    public static int draw(char playerMove){
        return shapeValue(playerMove) + 3;
    }

    public static int shapeValue(char shape){
        switch (shape){
            case 'X':
                    return 1;
            case 'Y':
                    return 2;
            case 'Z':
                    return 3;
            default:
                return 0;
        }
    }
}
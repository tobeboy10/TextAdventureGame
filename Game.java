import java.io.*;
import java.util.Scanner;

public class Game {
    Scanner reader = new Scanner(System.in);
    Player player;

    public Game() {
        System.out.println("Welcome to the world's first VRMMORPG...");
        System.out.println("");
        System.out.println("        Earth Online"); //come up with a better fake VRMMORPG name
        System.out.println("");
        File saveGame = new File("SaveGame.txt");
        Boolean exists = saveGame.exists();
        if (exists == true) {
            System.out.println("Would you like to continue from where you left off? y/n");
            if (reader.nextLine().equals("y")) {
                loadSave();
            } else {
                startGame();
            }
        } else {
            System.out.println("Would you like to begin? y/n");
        }
        if (reader.nextLine().equals("y")) {
            startGame();
        } else {
            System.out.println("Come again!");
        } 
    }

    private void startGame() {
        System.out.println("What is your name?");
        String name = reader.nextLine();
        player = new Player(name);
    }

    private void loadSave() {
        //will eventually load a save file
    }

}
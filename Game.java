import java.io.*;
import java.util.Scanner;

public class Game {
    Scanner reader = new Scanner(System.in);
    Player player;

    public Game() { //Essentially the main menu
        System.out.println("Welcome to the world's first VRMMORPG...");
        System.out.println("");
        System.out.println("        Ulibis Online");
        System.out.println("");
        File saveGame = new File("SaveGame.txt");
        Boolean exists = saveGame.exists();
        if (exists == true) {
            System.out.println("Would you like to continue from where you left off? y/n");
            if (reader.nextLine().equals("y")) {
                loadSave();
            } else {
                newGame();
            }
        } else {
            newGame();
        } 
    }

    private void newGame() { //Begins a new game, starting with character creation.
        System.out.println("");
        System.out.println("// Character Creation \\\\");
        System.out.println("What is your name?");
        String name = reader.nextLine();
        player = new Player(name, 10, 0, 10, 1, 0); 
        System.out.println("");
        System.out.println("Welcome " + player.getName() + ".");
        System.out.println("You are level " + player.getLevel() + " with " + player.getGold() + " gold and " + player.getRations() + " rations.");
        System.out.println("You are well.");
        System.out.println("");
        saveGame();
    }
    
    private void saveGame() { //Overwrites save file "SaveGame.txt" using player data.
        try {
            FileWriter writer = new FileWriter("SaveGame.txt", false);
            writer.write(player.getName());
            writer.write("\r\n");
            writer.write(Integer.toString(player.getLevel()));
            writer.write("\r\n");
            writer.write(Integer.toString(player.getExperience()));
            writer.write("\r\n");
            writer.write(Integer.toString(player.getGold()));
            writer.write("\r\n");
            writer.write(Integer.toString(player.getRations()));
            writer.write("\r\n");
            writer.write(Integer.toString(player.getHealth()));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void loadSave() { //Loads save file "SaveGame.txt" and sets player data based on the save file.
        try {
            FileReader reader = new FileReader("SaveGame.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            player = new Player();
            String line;
            if ((line = bufferedReader.readLine()) != null) {
                player.setName(line);
            } if ((line = bufferedReader.readLine()) != null) {
                player.setLevel(Integer.parseInt(line));
            } if ((line = bufferedReader.readLine()) != null) {
                player.setExperience(Integer.parseInt(line));
            } if ((line = bufferedReader.readLine()) != null) {
                player.setGold(Integer.parseInt(line));
            } if ((line = bufferedReader.readLine()) != null) {
                player.setRations(Integer.parseInt(line));
            } if ((line = bufferedReader.readLine()) != null) {
                player.setHealth(Integer.parseInt(line));
            }
            reader.close();

            System.out.println("Welcome " + player.getName() + ".");
            System.out.println("You are level " + player.getLevel() + " with " + player.getGold() + " gold and " + player.getRations() + " rations.");
            System.out.println("You are " + player.checkWounds());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //TODO Game progression

    
}
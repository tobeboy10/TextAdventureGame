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
        playOuterGate();
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
            System.out.println("Game saved.");
            System.out.println("");
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

    private void playOuterGate() { //Begins the actual game.
        System.out.println("// Outer Gate to Ulibis \\\\");
        System.out.println("Your journey begins at the Outer Gate to Ulibis. A gaurd stops you.");
        System.out.println("\"Nobody enters the realm of Ulibis without a pass.\"");
        System.out.println("Your Options:");
        System.out.println("a) Show pass b) Draw weapon");
        String input = reader.nextLine();
        if (input.equals("a")) {
            System.out.println("");
            System.out.println("You show the gaurd your pass. He looks it over with a nod.");
            System.out.println("\"Everything seems to be in order here. You may enter Ulibis, but don\'t cause any trouble.\"");
        } else if (input.equals("b")) {
            System.out.println("");
            System.out.println("You draw your sword, the gaurd seems displeased.");
            System.out.println("\"Not again. What you don\'t have a pass? Think you can take on the gaurd to get through? As if. Archers!\"");
            System.out.println("Unknown to you, there were archers stationed in the upper levels of the Outer Gate to Ulibis.");
            System.out.println("They begin to waves of fire arrows upon you.");
            System.out.println("");
            System.out.println("You have died. Reload to continue from where you left off.");
        } else {
            System.out.println("Invalid option. You have broke the game. Reload to continue from where you left off.");
        }
    }

}
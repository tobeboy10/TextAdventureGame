public class Player {
    private String name;
    private int gold;
    private int rations;
    private int health;
    private int maxHealth;
    private int level;
    private int experience;

    //Constructors
    public Player(){

    }
    public Player(String n, int g, int r, int h, int l, int e){
        name = n;
        gold = g;
        rations = r;
        health = h;
        level = l;
        maxHealth = 8 + (level*2);
        experience = e;
    }

    //Name commands
    public String getName() {
        return name;
    }
    public void setName(String n) {
        name = n;
    }
    
    //Gold commands
    public int getGold(){
        return gold;
    }
    public void setGold(int g) {
        gold = g;
    }
    public void changeGold(int g) {
        gold += g;
    }
    
    //Ration commands
    public int getRations() {
        return rations;
    }
    public void setRations(int r) {
        rations = r;
    }
    public void changeRations(int r) {
        rations += r;
    }
    
    //Health commands
    public int getHealth() {
        return health;
    }
    public void setHealth(int h) {
        health = h;
    }
    public void changeHealth(int h) {
        health += h;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }
    
    //MaxHealth commands
    public int getMaxHealth() {
        return maxHealth;
    }
    public void setMaxHealth() {
        maxHealth = 8 + (level*2);
    }
    
    //Level commands
    public int getLevel() {
        return level;
    }
    public void setLevel(int l) {
        level = l;
    }
    
    //Experience commands
    public int getExperience() { 
        return experience;
    }
    public void setExperience(int e) {
        experience = e;
        checkLevelUp();
    }
    public void changeExperience(int e) {
        experience += e;
        checkLevelUp();
    }
    
    //LevelUp command
    public void checkLevelUp() { 
        if (experience >= 15 + (level*5)) {
            level += 1;
            experience -= (15+(level*5));
            setMaxHealth();
            setHealth(maxHealth);
            System.out.println("");
            System.out.println("!!! Your level has increased. You are now level " + level + ". !!!");
            System.out.println("You feel well.");
            System.out.println("");
        }
    }
    
    //CheckWounds command
    public String checkWounds() { 
        if (health >= maxHealth * 0.9) {
            return "well.";
        } else if (health >= maxHealth * 0.75) {
            return "slightly wounded.";
        } else if (health >= maxHealth * 0.5) {
            return "moderately wounded.";
        } else if (health >= maxHealth * 0.25) {
            return "heavily wounded.";
        } else if (health >= 1) {
            return "mortally wounded.";
        } else {
            return "dead."; //TODO Death
        }
    }
}
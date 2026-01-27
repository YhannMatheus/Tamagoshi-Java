package Models;
import Services.StateMachine.StateMachine;


public class Pet {

    public enum PetType { SKY, EARTH, FIRE, WATER}

    // general attributes 
    private String name;
    private int happiness;
    private int hungry;
    private int cleaning;

    public StateMachine stateMachine;

    // Combat attributes
    private int life;
    private int attack;
    private int defense;
    private int speed;
    private PetType type;

    public Pet(String name) {
        this.name = name;
        this.life = 100;
        this.hungry = 0;
        this.cleaning = 100;
        this.happiness = 100;
        this.stateMachine = new StateMachine();
    }

    public void update(){
        if(stateMachine != null && stateMachine.currentState != null){
            stateMachine.currentState.update();
        }
    }

    public String getName() { return name; }
    public int getLife() { return life; }
    public int getHungry() { return hungry; }
    public int gethapiness() { return happiness; }
    public int getCleaning() { return cleaning; }
    public PetType getType() { return type; }
}

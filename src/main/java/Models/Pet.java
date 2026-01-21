package Models;

public class Pet {
    private String name;
    private int life;
    private int hungry;
    private int cleaning;

    public Pet(String name) {
        this.name = name;
        this.life = 100;
        this.hungry = 0;
        this.cleaning = 0;
    }
}

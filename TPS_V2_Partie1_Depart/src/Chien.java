// Classe dérivée
// TODO 1.1
class Chien extends Animal {
    private String race;

    public Chien(String nom, int age, String race) {
        super(nom, age);
        this.race = race;
    }

    public void faireDuBruit() {
        System.out.println("Woof Woof !");
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "Chien{" +
                "race='" + race + '\'' +
                '}';
    }
}
// Classe abstraite Joueur
abstract class Joueur {
    private String nom;
    private int age;

    // Constructeur
    public Joueur(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Méthode abstraite pour afficher les détails spécifiques du joueur
    public abstract void afficherDetails();
}
// Classe de base Pays
class Pays {
    private String nom;
    private int population;

    // Constructeur
    public Pays(String nom, int population) {
        this.nom = nom;
        this.population = population;
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    // Méthode pour afficher les détails du pays
    public void afficherDetails() {
        System.out.println("Pays: " + nom);
        System.out.println("Population: " + population);
    }
}
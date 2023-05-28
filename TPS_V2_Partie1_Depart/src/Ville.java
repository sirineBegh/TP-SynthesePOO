// Classe dérivée Ville
class Ville extends Pays {
    private String nomVille;

    // Constructeur
    public Ville(String nom, int population, String nomVille) {
        super(nom, population);
        this.nomVille = nomVille;
    }
    // Getter et setter

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    //TODO 3
    public void afficherDetails(){
        System.out.println("Nom: " + getNom());
        System.out.println("Âge: " + getPopulation());
        System.out.println("Équipe: " + nomVille);
    }
}
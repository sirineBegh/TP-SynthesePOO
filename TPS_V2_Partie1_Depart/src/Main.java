
// github : https://github.com/sirineBegh/TP-Finall.git

// Classe principale
public class Main {
    public static void main(String[] args) {
        // TODO 1

        try {
            Chien monChien = new Chien("Max", 3, "Labrador");
            System.out.println(monChien); // affiche "Chien [race=Labrador, Animal [nom=Max, age=3]]"
            monChien.faireDuBruit(); // affiche "Wouf wouf."
            Chat monChat = new Chat("Mimi", 5, true);
            System.out.println(monChat); // affiche "Chat [estInterieur=true, Animal [nom=Mimi, age=5]]"
            monChat.faireDuBruit(); // affiche "Miaouw."
            monChat.setAge(-8); // affiche "Une exception s'est produite : L'âge doit être positive."
        } catch (Exception e) {
            System.out.println("Une exception s'est produite : " + e.getMessage());
        }
        // TODO 2
        Footballeur footballeur = new Footballeur("David Beckham", 45, "Real Madrid");
        footballeur.afficherDetails(); // affiche "Nom: David Beckham<cr>Âge: 45<cr>Équipe: Real Madrid"
        // TODO 3
        Pays pays = new Pays("France", 67000000);
        pays.afficherDetails(); // affiche "Pays: France<cr>Population: 67000000"

        System.out.println();

        Ville ville = new Ville("France", 150000, "Paris");
        ville.afficherDetails(); // affiche "Pays: France<cr>Population: 150000"
        // TODO 4
        Impot impot = new Impot("Magnus Carlsen", 50000, 0.25);
        impot.afficher(); // affiche "Nom du contribuable: John Doe<cr>Revenu annuel: 50000.0<cr>Taux d'imposition: 0.25<cr>Impôt à payer: 12500.0"
        // TODO 5
        Vehicule vehicule = new Voiture("Toyota", "Corolla", 2023, 4);
        System.out.println(vehicule.toString()); // affiche "Voiture : Marque=Toyota, Modèle=Corolla, Année=2023, Nombre de portes=4"
        // TODO 6
        Structure liste = new Structure();
        liste.ajouter(10);
        liste.ajouter(20);
        liste.ajouter(30);
        liste.afficherDebutVersFin();  // affiche "Liste de gauche à droite : 10 20 30"
        liste.afficherFinVersDebut();  // affiche: "Liste de droite à gauche : 30 20 10"
        // TODO 7
        ExempleExceptionsPersonnalisees exemple = new ExempleExceptionsPersonnalisees();
        // TODO 8
        try {
            exemple.setValeur(120); // Lève une ValeurHorsLimiteException
        } catch (ValeurHorsLimiteException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        // TODO 9
        try {
            exemple.effectuerOperation(); // Lève une OperationNonAutoriseeException
        } catch (OperationNonAutoriseeException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        // TODO 10 Était fournie, donc rien à faire.
    }
}

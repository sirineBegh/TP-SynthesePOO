class Structure {
    private Noeud tete;
    private Noeud queue;

    //TODO 6
    // Constructeur
    public Structure() {
        this.tete = null;
        this.queue = null;
    }

    private class Noeud {
        Noeud suivant;
        Noeud precedent;
        int valeur;

        public Noeud(int valeur) {
            this.valeur = valeur;
        }
    }

    // Méthode pour vérifier si la liste est vide
    public boolean estVide() {
        return tete == null;
    }

    // Méthode pour ajouter un élément à la fin de la liste
    public void ajouter(int valeur) {
        Noeud nouveauNoeud = new Noeud(valeur);

        if (estVide()) {
            tete = nouveauNoeud;
            queue = nouveauNoeud;
        } else {
            nouveauNoeud.precedent = queue;
            queue.suivant = nouveauNoeud;
            queue = nouveauNoeud;
        }
    }

    // Méthode pour afficher les éléments de la liste de gauche à droite
    public void afficherDebutVersFin() {
        Noeud courant = tete;
        System.out.print("Liste de gauche à droite : ");
        while (courant != null) {
            System.out.print(courant.valeur + " ");
            courant = courant.suivant;
        }
        System.out.println();
    }

    // Méthode pour afficher les éléments de la liste de droite à gauche
    public void afficherFinVersDebut() {
        Noeud courant = queue;
        System.out.print("Liste de droite à gauche : ");
        while (courant != null) {
            System.out.print(courant.valeur + " ");
            courant = courant.precedent;
        }
        System.out.println();
    }
}

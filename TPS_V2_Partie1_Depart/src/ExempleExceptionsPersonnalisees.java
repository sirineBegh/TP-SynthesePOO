// Classe utilisant les exceptions personnalisées
class ExempleExceptionsPersonnalisees {
    private int valeur;

    // Méthode pour définir la valeur. N'acepte que des valeurs entre 1 et 100 inclusivement.
    //TODO 7


    // Méthode pour effectuer une opération
    public void effectuerOperation() throws OperationNonAutoriseeException {
        // Condition de vérification pour l'opération
        boolean condition = true;

        if (!condition) {
            throw new OperationNonAutoriseeException("L'opération n'est pas autorisée.");
        }

        // Logique de l'opération
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}

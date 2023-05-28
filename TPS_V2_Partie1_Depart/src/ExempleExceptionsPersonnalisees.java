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

    public void setValeur(int valeur) throws ValeurHorsLimiteException {
        if (valeur > 100 || valeur < 1) {
            throw new ValeurHorsLimiteException("La valeur dépasse la limite maximale.");
        }
    }
}


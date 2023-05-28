package messages;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Historique {
    private ArrayList<Message> messages = new ArrayList<>();

    public static void main(String[] args) {
        String fichierLecture = args.length > 0 ? args[0] : "historique.test.in";
        String fichierEcriture = args.length > 1 ? args[1] : "historique.test.out";

        System.out.println("\n=> TEST Écrire le contenu de l'historique dans le fichier " + fichierEcriture);
        Historique historique = new Historique();
        historique.ajouter(new MessageEntrant("Admin: Bienvenue sur le serveur"));
        historique.ajouter(new MessageSortant("Allo tout le monde!"));
        historique.ajouter(new MessageEntrant("Alice: Salut Bob!"));
        historique.ajouter(new MessageEntrantPrive("@Bob Charlie: Yo, tu as fini le TP?"));
        historique.ajouter(new MessageSortantPrive("@Charlie Pas encore mais presque, toi?"));
        historique.ecrire(fichierEcriture);

        System.out.println("\n=> TEST Lire le contenu de l'historique depuis le fichier " + fichierLecture);
        historique.vider();
        historique.lire(fichierLecture);
        for (Message m : historique.getMessages())
            System.out.println(m);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void ajouter(Message m) {
        messages.add(m);
    }

    public void vider() {
        messages.clear();
    }

    public int lire(String cheminFichier) {
        int nbMessagesLus = 0;
        /* TODO 15: Ajoutez le code nécessaire pour permettre de lire chaque message (un par ligne)
            depuis le fichier passé en paramètre, et de remplir le tableau 'messages' avec les objets
            'Message' créés.
        */

        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                if (ligne.startsWith("Admin:")) {
                    messages.add(new MessageEntrant(ligne.substring(7)));
                }else if (ligne.startsWith("@")) {
                    int indexDeuxPoints = ligne.indexOf(":");
                    if (indexDeuxPoints != -1 ) {
                        String destinataire = ligne.substring(1, indexDeuxPoints);
                        String contenu = ligne.substring(indexDeuxPoints + 1);
                        messages.add(new MessageEntrantPrive(destinataire, contenu));
                    }
                } else {
                    messages.add(new MessageSortant(ligne));
                }
                nbMessagesLus++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("Lecture de l'historique depuis %s (%d lignes)\n", cheminFichier, nbMessagesLus);
        return nbMessagesLus;
    }

    public int ecrire(String cheminFichier) {
        int nbMessagesEcrits = 0;
        /* TODO 14: Ajoutez le code nécessaire pour permettre d'écrire chaque message (un par ligne)
            dans le fichier passé en paramètre à partir des messages contenus dans le tableau 'messages'.
        */
        try (FileWriter writer = new FileWriter(cheminFichier)) {
            for (int i = 0; i < nbMessagesEcrits; i++) {
                Message message = messages.get(i);
                writer.write(message.toString());
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("Écriture de l'historique terminée dans %s (%d lignes)\n", cheminFichier, nbMessagesEcrits);
        return nbMessagesEcrits;
    }
}

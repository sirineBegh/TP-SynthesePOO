import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIClient extends ChatClient {
    JFrame frame;
    JTextArea chatBox;
    JTextField sendBox;
    GUIClient.ConnexionDialog connexion;

    public static void main(String[] args) {
        String nom = args.length > 0 ? args[0] : "guest";
        GUIClient client = new GUIClient(nom);
        client.connecter();
    }

    /**
     * Construit un client de clavardage graphique.
     * @param userName Le nom d'utilisateur souhaité.
     */
    public GUIClient(String userName) {
        super(userName);

        frame = new JFrame("JavaChat");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(creerMenu());

        chatBox = new JTextArea();
        chatBox.setLineWrap(true);
        chatBox.setEditable(false);
        chatBox.append("Vous devez d'abord vous connecter!");
        JScrollPane chatPane = new JScrollPane(chatBox);
        frame.add(chatPane, BorderLayout.CENTER);

        /* TODO 12: Ajoutez le code nécessaire pour reproduire le bas de l'interface
             (une boite de texte pour entrer un message (sendBox) et un bouton "Envoyer").
           Fiez-vous aux captures d'écran pour voir le résultat attendu.
         */

        /* TODO 13: Ajoutez une action au bouton "Envoyer" qui va lui permettre
             a) d'envoyer le message au serveur (appelez la méthode send(String message)),
             b) d'ajouter le texte du message au textArea 'chatBox' (créé ci-dessus),
             c) de vider le contenu du textField 'sendBox' (que vous avez créé au TODO précédent).
        */

        frame.setVisible(true);
    }

    private JMenuBar creerMenu() {
        JMenuBar menuBar = new JMenuBar();

        /* TODO 11: Ajoutez le code qui permettra de créer le menu suivant:
            Fichier
                Se connecter -> Ouvre le dialogue de connexion: connecter();
                Quitter -> Quitte l'application: System.exit(0);
            Historique
                Importer -> Lit l'historique: chargerHistorique();
                Exporter -> Écrit l'historique: sauvegarderHistorique();
          Fiez-vous aux captures d'écran pour voir le résultat attendu.
        */

        JMenu fichierMenu = new JMenu("Fichier");

        // Option Se connecter
        JMenuItem seConnecterItem = new JMenuItem("Se connecter");
        seConnecterItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connecter();
            }
        });
        fichierMenu.add(seConnecterItem);

        JMenuItem quitterItem = new JMenuItem("Quitter");
        quitterItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fichierMenu.add(quitterItem);

        JMenu historiqueMenu = new JMenu("Historique");

        JMenuItem importerItem = new JMenuItem("Importer");
        importerItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chargerHistorique(); // Appeler la méthode pour charger l'historique
            }
        });
        historiqueMenu.add(importerItem);

        JMenuItem exporterItem = new JMenuItem("Exporter");
        exporterItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sauvegarderHistorique(); // Appeler la méthode pour sauvegarder l'historique
            }
        });
        historiqueMenu.add(exporterItem);

        menuBar.add(fichierMenu);
        menuBar.add(historiqueMenu);

        return menuBar;
    }

    @Override
    public String sauvegarderHistorique() {
        String cheminFichier = super.sauvegarderHistorique();
        JOptionPane.showMessageDialog(frame, "Historique sauvegardé dans " + cheminFichier);
        return cheminFichier;
    }

    public void connecter() {
        if (connexion == null)
            connexion = new ConnexionDialog(frame);
        connexion.setVisible(true);
        chatBox.setText("");
        //sendBox.setEnabled(true);
    }

    private class ConnexionDialog extends JDialog {
        public ConnexionDialog(JFrame parent) {
            super(parent, "Connexion", ModalityType.DOCUMENT_MODAL);
            this.setSize(300, 200);

            /* TODO 10: Ajoutez les composants manquants pour demander l'information nécessaire
                 à la connexion (nom d'utilisateur, adresse du serveur, port de l'application).
               Fiez-vous aux captures d'écran pour voir le résultat attendu.
            */
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel userLabel = new JLabel("USERNAME :");
            JTextField userTextField = new JTextField(15);
            userLabel.setHorizontalAlignment(JTextField.CENTER);
            userPanel.add(userLabel);
            userPanel.add(userTextField);
            panel.add(userPanel);

            // Serveur
            JPanel serverPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel serverLabel = new JLabel("SERVER:");
            JTextField serverTextField = new JTextField(15);
            serverTextField.setHorizontalAlignment(JTextField.CENTER);
            serverPanel.add(serverLabel);
            serverPanel.add(serverTextField);
            panel.add(serverPanel);

            // Port
            JPanel portPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel portLabel = new JLabel("PORT:");
            JTextField portTextField = new JTextField(15);
            serverTextField.setHorizontalAlignment(JTextField.CENTER);
            portPanel.add(portLabel);
            portPanel.add(portTextField);
            panel.add(portPanel);

            JButton connectButton = new JButton("Rejoindre");
            connectButton.addActionListener(e -> {
                this.setVisible(false);
                // Décommentez les lignes suivantes une fois le TODO 10 complété:
                userName = userTextField.getText();
                 connecter(serverTextField.getText(), Integer.parseInt(portTextField.getText()));
            });

            this.add(connectButton, BorderLayout.SOUTH);
            this.add(panel);
            this.getRootPane().setDefaultButton(connectButton);
        }
    }

    @Override
    protected void display(String str) {
        chatBox.append(str + "\n");
        chatBox.setCaretPosition(chatBox.getDocument().getLength());
    }
}
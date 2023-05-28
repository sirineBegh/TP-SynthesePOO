package messages;

public class MessageEntrantPrive extends MessageEntrant implements MessagePrive {
    private final String destinataire;

    public MessageEntrantPrive(String source, String contenu) {
        super(contenu.substring(contenu.indexOf(' ') + 1), source);
        destinataire = contenu.substring(0, contenu.indexOf(' '));
    }

    public MessageEntrantPrive(String contenu) {
        super(contenu.substring(contenu.indexOf(' ') + 1));
        destinataire = contenu.substring(0, contenu.indexOf(' '));
    }

    @Override
    public String getDestinataire() {
        return destinataire;
    }

    @Override
    public String toString() {
        return String.format("%c%s %s", PREFIX, getDestinataire(), super.toString());
    }
}

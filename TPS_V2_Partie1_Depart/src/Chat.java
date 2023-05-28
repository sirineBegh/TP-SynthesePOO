// Classe dérivée
// TODO 1.2
class Chat extends Animal{
    private boolean estInterieur;

    public Chat(String nom, int age, boolean estInterieur){
        super(nom, age);
        this.estInterieur=estInterieur;
    }
    public void faireDuBruit(){
        System.out.println("Miaouuu !");
    }

    public boolean isEstInterieur() {
        return estInterieur;
    }

    public void setEstInterieur(boolean estInterieur) {
        this.estInterieur = estInterieur;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Chat{" +
                "estInterieur=" + estInterieur +
                '}';
    }
}
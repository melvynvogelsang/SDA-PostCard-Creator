package ch.hegarc.ig.sda.business;

public class Bot extends Participant{
    /** Constructeur */
    public Bot(String p_prenom) {
        super(p_prenom);
    }
    /** Getters et setters */
    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String p_prenom) {
        super.prenom = p_prenom;
    }
}

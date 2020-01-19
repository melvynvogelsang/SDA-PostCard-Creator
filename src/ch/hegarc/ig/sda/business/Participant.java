package ch.hegarc.ig.sda.business;

public abstract class Participant {

    private String prenom;

    public Participant(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
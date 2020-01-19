package ch.hegarc.ig.sda.business;

import java.util.Objects;

public class Utilisateur extends Participant {

    private String id;
    private String nom;
    private String email;
    private Conversation conversation;

    public Utilisateur(String p_id,String p_prenom, String p_nom, String p_email) {
        super(p_prenom);
        this.id = p_id;
        this.nom = p_nom;
        this.email = p_email;
        this.conversation = new Conversation();
    }

    public Conversation getConversation() {
        return conversation; // O(1)
    }

    public void setConversation(Conversation p_conversation) {
        conversation = p_conversation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utilisateur)) return false;
        Utilisateur that = (Utilisateur) o;
        return getId().equals(that.getId()) &&
                getNom().equals(that.getNom()) &&
                getEmail().equals(that.getEmail()) &&
                        getPrenom().equals(that.getPrenom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNom(), getEmail(),getPrenom());
    }
}

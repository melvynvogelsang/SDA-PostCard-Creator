package ch.hegarc.ig.sda.business;

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
        return conversation;
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

}

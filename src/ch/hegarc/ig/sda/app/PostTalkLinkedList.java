package ch.hegarc.ig.sda.app;

import ch.hegarc.ig.sda.business.Bot;
import ch.hegarc.ig.sda.loader.AbstractLoader;
import ch.hegarc.ig.sda.loader.LoaderLinkedList;
import ch.hegarc.ig.sda.business.Utilisateur;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class PostTalkLinkedList extends AbstractPostTalk {

    private List<Utilisateur> utilisateurs = null;
    private AbstractLoader loader = new LoaderLinkedList();

    public PostTalkLinkedList() {
    }

    public Utilisateur get(String id){
        Utilisateur tmpUtilisateur = null; // O(1) car affectation
        for (Utilisateur user : utilisateurs){ // O(n) car itérations sur n objets
            if(user.getId().equals(id)){ // O(n-1) car comparaison de n-1 objets
                tmpUtilisateur = user; // O(1) car affectation
            }
        }
        return tmpUtilisateur; // O(1)
    }

    @Override
    public void createUtilisateurs() {
        this.utilisateurs = new LinkedList<>();
    }

    @Override
    public void loadUtilisateurs() {
        loader.loadUsers(utilisateurs);
    }

    @Override
    public void testTailleListeUtilisateur(Utilisateur utilisateurAAjouter) {
        int indexUtilisateur = utilisateurs.indexOf(utilisateurAAjouter);
        System.out.println("Taille de la liste de message de " + utilisateurs.get(indexUtilisateur).getPrenom() + " après les opérations : " + utilisateurs.get(indexUtilisateur).getConversation().getMessages().size());

    }

    @Override
    public void testTempsGetUser() {
        // Temps de récupération d'un utilisateur
        long startTimeGetUtilisateur = System.currentTimeMillis();
        utilisateurs.get(150000);
        long endTimeGetUtilisateur = System.currentTimeMillis();
        long elapsedTimeGetUtilisateur = endTimeGetUtilisateur - startTimeGetUtilisateur;
        System.out.println("Temps de récupération d'un utilisateur : " + elapsedTimeGetUtilisateur + "ms");
    }

    @Override
    public void testempsAjoutNMessages(Utilisateur utilisateurAAjouter, long elapsedTimeAjoutNMessages) {
        int indexUtilisateur = utilisateurs.indexOf(utilisateurAAjouter);
        System.out.println("Temps d'ajout de " + (utilisateurs.get(indexUtilisateur).getConversation().getMessages().size() - NB_MESSAGES_AJOUTES )+ " messages : " + elapsedTimeAjoutNMessages + "ms"); // - 21 car 21 messages ont été chargés dans le programme

    }

    @Override
    public void addUtilisateur(Utilisateur utilisateurAAjouter) {
        utilisateurs.add(utilisateurAAjouter); // O(1)
    }

    @Override
    public void removeUtilisateur(Utilisateur utilisateur) {
        utilisateurs.remove(utilisateur); // O(1)
    }

    @Override
    public void testTempsRemoveUtilisateur(long elapsedTimeRemove) {
        System.out.println("Temps de suppression d'un seul utilisateur : " + elapsedTimeRemove + "ms");
    }

    @Override
    public void loadMessages(Bot bot) {
        loader.loadMessages(utilisateurs,bot);
    }

    @Override
    public void addMessage(Utilisateur utilisateurAAjouter, LocalDateTime dateAAjouter) {
        int indexUtilisateur = utilisateurs.indexOf(utilisateurAAjouter);
        utilisateurs.get(indexUtilisateur).getConversation().addMessage("Message ajouté par le programme.",dateAAjouter,utilisateurAAjouter);
    }

    @Override
    public void loadMessagesSingleUser(Utilisateur utilisateurAAjouter,Bot bot) {
        int indexUtilisateur = utilisateurs.indexOf(utilisateurAAjouter);
        loader.loadMessagesSingleUser(utilisateurs, utilisateurs.get(indexUtilisateur),bot,350000);

    }

    @Override
    public void testTempsChargementUsersCSV(long elapsedTimeUsers) {
        System.out.println("Temps de chargement depuis CSV : " + (utilisateurs.size() - NB_UTILISATEUR_AJOUTES) + " utilisateurs : " + elapsedTimeUsers + "ms");
    }

    @Override
    public void affichageNbUtilisateursFinaux() {
        System.out.println("Nombre d'utilisateurs final : " + utilisateurs.size());
    }

    @Override
    public void afficherConversation(String id) {
        get(id).getConversation().afficherConversation();
    }

    @Override
    public void testTempsAfficherConversation(long elapsedTimeAffichageConversation) {
        System.out.println("Temps d'affichage de la conversation: " + elapsedTimeAffichageConversation + "ms");
    }
}

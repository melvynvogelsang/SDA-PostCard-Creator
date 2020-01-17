package ch.hegarc.ig.sda.app;

import ch.hegarc.ig.sda.business.*;
import ch.hegarc.ig.sda.loader.AbstractLoader;
import ch.hegarc.ig.sda.loader.LoaderHashSet;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class PostTalkHashSet extends AbstractPostTalk {

    private Set<Utilisateur> utilisateurs = null;
    private AbstractLoader loader = new LoaderHashSet();

    public PostTalkHashSet() {

    }

    // On crée nos propres méthodes get
    public Utilisateur get(Utilisateur utilisateur){
    Utilisateur tmpUtilisateur = null;
    for (Utilisateur user : utilisateurs){
        if (user.equals(utilisateur)){
        tmpUtilisateur = user;
        break;
        }
    }
        return tmpUtilisateur;
    }

    public Utilisateur get(String id){
        Utilisateur tmpUtilisateur = null;
        for (Utilisateur user : utilisateurs){
            if (user.getId().equals(id)){
                tmpUtilisateur = user;
                break;
            }
        }
        return tmpUtilisateur;
        }

    @Override
    public void createUtilisateurs() {
        this.utilisateurs = new HashSet<>();
    }

    @Override
    public void loadUtilisateurs() {
        loader.loadUsers(utilisateurs);
    }

    @Override
    public void addUtilisateur(Utilisateur utilisateurAAjouter) {
        utilisateurs.add(utilisateurAAjouter);
    }

    @Override
    public void removeUtilisateur(Utilisateur utilisateur) {
        utilisateurs.remove(utilisateur);
    }

    @Override
    public void testTempsGetUser() {
        // Temps de récupération d'un utilisateur
        long startTimeGetUtilisateur = System.currentTimeMillis();
        get("150000");
        long endTimeGetUtilisateur = System.currentTimeMillis();
        long elapsedTimeGetUtilisateur = endTimeGetUtilisateur - startTimeGetUtilisateur;
        System.out.println("Temps de récupération d'un utilisateur : " + elapsedTimeGetUtilisateur + "ms");
    }

    @Override
    public void testTempsRemoveUtilisateur(long elapsedTimeRemove) {
        System.out.println("Temps de suppression d'un seul utilisateur : " + elapsedTimeRemove + "ms");
    }

    @Override
    public void loadMessages(Bot bot) {
        loader.loadMessages(utilisateurs, bot);
    }

    @Override
    public void addMessage(Utilisateur utilisateur, LocalDateTime dateAAjouter) {
        get(utilisateur).getConversation().addMessage("Message ajouté par le programme.", dateAAjouter, utilisateur);
    }

    @Override
    public void loadMessagesSingleUser(Utilisateur utilisateur, Bot bot) {
        loader.loadMessagesSingleUser(utilisateurs,utilisateur, bot,350000);
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
    public void testempsAjoutNMessages(Utilisateur utilisateur, long elapsedTimeAjoutNMessages) {
        System.out.println("Temps d'ajout de " + (get(utilisateur).getConversation().getMessages().size() - NB_MESSAGES_AJOUTES ) + " messages : " + elapsedTimeAjoutNMessages + "ms");
    }

    @Override
    public void testTempsAfficherConversation(long elapsedTimeAffichageConversation) {
        System.out.println("Temps d'affichage de la conversation: " + elapsedTimeAffichageConversation + "ms");
    }

    @Override
    public void afficherConversation(String id) {
        get(id).getConversation().afficherConversation();
    }

    @Override
    public void testTailleListeUtilisateur (Utilisateur utilisateur) {
        System.out.println("Taille de la liste de message de " + get(utilisateur).getPrenom() + " après les opérations : " + get(utilisateur).getConversation().getMessages().size());
    }
}

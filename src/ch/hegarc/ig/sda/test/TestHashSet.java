package ch.hegarc.ig.sda.test;

import ch.hegarc.ig.sda.business.*;
import ch.hegarc.ig.sda.loader.AbstractLoader;
import ch.hegarc.ig.sda.loader.LoaderHashSet;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


public class TestHashSet extends AbstractTest {

    private Set<Utilisateur> utilisateurs = null;
    private AbstractLoader loader = new LoaderHashSet();

    public TestHashSet() {

    }

    @Override
    void doCreateUtilisateurs() {
        this.utilisateurs = new HashSet<>();
    }

    @Override
    void doLoadUtilisateurs() {
        loader.loadUsers(utilisateurs);
    }

    @Override
    void doAddUtilisateur(Utilisateur utilisateurAAjouter) {
        utilisateurs.add((Utilisateur) utilisateurAAjouter);
    }

    @Override
    void doLoadMessages(Bot bot) {
        loader.loadMessages(utilisateurs, bot);
    }

    @Override
    void doAddMessage(Utilisateur utilisateurAAjouter, LocalDateTime dateAAjouter) {
        for (Utilisateur user : utilisateurs){
            if (user.equals(utilisateurAAjouter)){
                user.getConversation().addMessage("Message ajouté par le programme.", dateAAjouter, utilisateurAAjouter);
            }
        }
    }

    @Override
    void doLoadMessagesSingleUser(Utilisateur utilisateurAAjouter, Bot bot) {
        loader.loadMessagesSingleUser((HashSet<Utilisateur>) utilisateurs,(Utilisateur) utilisateurAAjouter, bot,350000);
    }

    @Override
    void doTestTempsChargementUsersCSV(long elapsedTimeUsers) {
        System.out.println("Temps de chargement depuis CSV : " + (utilisateurs.size() - NB_UTILISATEUR_AJOUTES) + " utilisateurs : " + elapsedTimeUsers + "ms");

    }

    @Override
    void doAffichageNbUtilisateursFinaux() {
        System.out.println("Nombre d'utilisateurs final : " + utilisateurs.size());
    }

    @Override
    void doTestempsAjoutNMessages(Utilisateur utilisateurAAjouter, long elapsedTimeAjoutNMessages) {
        for (Utilisateur user : utilisateurs){
            if (utilisateurAAjouter.equals(user)){
                System.out.println("Temps d'ajout de " + (user.getConversation().getMessages().size() - NB_MESSAGES_AJOUTES ) + " messages : " + elapsedTimeAjoutNMessages + "ms");
            }
        }
    }

    @Override
    void doTestTempsAfficherConversation(long elapsedTimeAffichageConversation) {
        System.out.println("Temps d'affichage de la conversation: " + elapsedTimeAffichageConversation + "ms");

    }

    @Override
    void doAfficherConversation() {
        for (Utilisateur user : utilisateurs){
            if(user.getId().equals("150000")){
                user.getConversation().afficherConversation();
            }
        }
    }

    @Override
    void doTestTailleListeUtilisateur (Utilisateur utilisateurAAjouter) {
        for (Utilisateur user : utilisateurs){
            if (utilisateurAAjouter.equals(user)){
                System.out.println("Taille de la liste de message de " + user.getPrenom() + " après les opérations : " + user.getConversation().getMessages().size());
            }
        }
    }
}

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

    public Utilisateur get(Utilisateur utilisateur){
    Utilisateur tmpUtilisateur = null;
    for (Utilisateur user : utilisateurs){
        if (user.equals(utilisateur)){
        tmpUtilisateur = user;
        }
    }
        return tmpUtilisateur;
    }

    public Utilisateur get(String id){
        Utilisateur tmpUtilisateur = null;
        for (Utilisateur user : utilisateurs){
            if (user.getId().equals(id)){
                tmpUtilisateur = user;
            }
        }
        return tmpUtilisateur;
        }

    @Override
    protected void doCreateUtilisateurs() {
        this.utilisateurs = new HashSet<>();
    }

    @Override
    protected void doLoadUtilisateurs() {
        loader.loadUsers(utilisateurs);
    }

    @Override
    protected void doAddUtilisateur(Utilisateur utilisateurAAjouter) {
        utilisateurs.add(utilisateurAAjouter);
    }

    @Override
    protected void doLoadMessages(Bot bot) {
        loader.loadMessages(utilisateurs, bot);
    }

    @Override
    protected void doAddMessage(Utilisateur utilisateur, LocalDateTime dateAAjouter) {
        get(utilisateur).getConversation().addMessage("Message ajouté par le programme.", dateAAjouter, utilisateur);
    }

    @Override
    protected void doLoadMessagesSingleUser(Utilisateur utilisateur, Bot bot) {
        loader.loadMessagesSingleUser(utilisateurs,utilisateur, bot,350000);
    }

    @Override
    protected void doTestTempsChargementUsersCSV(long elapsedTimeUsers) {
        System.out.println("Temps de chargement depuis CSV : " + (utilisateurs.size() - NB_UTILISATEUR_AJOUTES) + " utilisateurs : " + elapsedTimeUsers + "ms");
    }

    @Override
    protected void doAffichageNbUtilisateursFinaux() {
        System.out.println("Nombre d'utilisateurs final : " + utilisateurs.size());
    }

    @Override
    protected void doTestempsAjoutNMessages(Utilisateur utilisateur, long elapsedTimeAjoutNMessages) {
        System.out.println("Temps d'ajout de " + (get(utilisateur).getConversation().getMessages().size() - NB_MESSAGES_AJOUTES ) + " messages : " + elapsedTimeAjoutNMessages + "ms");
    }

    @Override
    protected void doTestTempsAfficherConversation(long elapsedTimeAffichageConversation) {
        System.out.println("Temps d'affichage de la conversation: " + elapsedTimeAffichageConversation + "ms");
    }

    @Override
    protected void doAfficherConversation(String id) {
        get(id).getConversation().afficherConversation();
    }

    @Override
    protected void doTestTailleListeUtilisateur (Utilisateur utilisateur) {
        System.out.println("Taille de la liste de message de " + get(utilisateur).getPrenom() + " après les opérations : " + get(utilisateur).getConversation().getMessages().size());
    }
}

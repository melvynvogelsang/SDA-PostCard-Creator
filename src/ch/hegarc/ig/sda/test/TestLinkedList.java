package ch.hegarc.ig.sda.test;

import ch.hegarc.ig.sda.business.Bot;
import ch.hegarc.ig.sda.loader.AbstractLoader;
import ch.hegarc.ig.sda.loader.LoaderLinkedList;
import ch.hegarc.ig.sda.business.Utilisateur;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class TestLinkedList extends AbstractTest {

    private List<Utilisateur> utilisateurs = null;
    private AbstractLoader loader = new LoaderLinkedList();

    public TestLinkedList() {

    }

    public Utilisateur get(String id){
        Utilisateur tmpUtilisateur = null;
        for (Utilisateur user : utilisateurs){
            if(user.getId().equals(id)){
                tmpUtilisateur = user;
            }
        }
        return tmpUtilisateur;
    }

    @Override
    protected void doCreateUtilisateurs() {
        this.utilisateurs = new LinkedList<>();
    }

    @Override
    protected void doLoadUtilisateurs() {
        loader.loadUsers(utilisateurs);
    }

    @Override
    protected void doTestTailleListeUtilisateur(Utilisateur utilisateurAAjouter) {
        int indexUtilisateur = utilisateurs.indexOf(utilisateurAAjouter);
        System.out.println("Taille de la liste de message de " + utilisateurs.get(indexUtilisateur).getPrenom() + " après les opérations : " + utilisateurs.get(indexUtilisateur).getConversation().getMessages().size());

    }

    @Override
    protected void doTestempsAjoutNMessages(Utilisateur utilisateurAAjouter, long elapsedTimeAjoutNMessages) {
        int indexUtilisateur = utilisateurs.indexOf(utilisateurAAjouter);
        System.out.println("Temps d'ajout de " + (utilisateurs.get(indexUtilisateur).getConversation().getMessages().size() - NB_MESSAGES_AJOUTES )+ " messages : " + elapsedTimeAjoutNMessages + "ms"); // - 21 car 21 messages ont été chargés dans le programme

    }

    @Override
    protected void doAddUtilisateur(Utilisateur utilisateurAAjouter) {
        utilisateurs.add(utilisateurAAjouter);
    }

    @Override
    protected void doLoadMessages(Bot bot) {
        loader.loadMessages(utilisateurs,bot);
    }

    @Override
    protected void doAddMessage(Utilisateur utilisateurAAjouter, LocalDateTime dateAAjouter) {
        int indexUtilisateur = utilisateurs.indexOf(utilisateurAAjouter);
        utilisateurs.get(indexUtilisateur).getConversation().addMessage("Message ajouté par le programme.",dateAAjouter,utilisateurAAjouter);
    }

    @Override
    protected void doLoadMessagesSingleUser(Utilisateur utilisateurAAjouter,Bot bot) {
        int indexUtilisateur = utilisateurs.indexOf(utilisateurAAjouter);
        loader.loadMessagesSingleUser(utilisateurs, utilisateurs.get(indexUtilisateur),bot,350000);

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
    protected void doAfficherConversation(String id) {
        get(id).getConversation().afficherConversation();
    }

    @Override
    protected void doTestTempsAfficherConversation(long elapsedTimeAffichageConversation) {
        System.out.println("Temps d'affichage de la conversation: " + elapsedTimeAffichageConversation + "ms");
    }
}

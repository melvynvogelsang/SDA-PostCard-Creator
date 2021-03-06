package ch.hegarc.ig.sda.app;

import ch.hegarc.ig.sda.business.Bot;
import ch.hegarc.ig.sda.business.Participant;
import ch.hegarc.ig.sda.business.Utilisateur;

import java.time.LocalDateTime;

public abstract class AbstractPostTalk implements PostTalk {

    static final int NB_MESSAGES_AJOUTES = 21;
    static final int NB_UTILISATEUR_AJOUTES = 1;

    @Override
    public void run() {
        // Création d'un utilisateur que l'on utilisera durant le programme
        Participant utilisateur = new Utilisateur("300001","Melvyn","Vogelsang","melvyn.vogelsang@he-arc.ch");

        // Création du bot
        Bot bot = new Bot("Pascal le Bot");

        // Création d'une date pour l'utiliser lors d'ajout de messages
        LocalDateTime newDate = LocalDateTime.now();

        createUtilisateurs();

        // Temps de chargement des utilisateurs
        long startTimeUsers = System.currentTimeMillis();
        loadUtilisateurs();
        long endTimeUsers = System.currentTimeMillis();
        long elapsedTimeUsers = endTimeUsers - startTimeUsers;

        // Temps d'ajout d'un seul utilisateur
        long startTimeAjoutUser = System.currentTimeMillis();
        addUtilisateur((Utilisateur) utilisateur);
        long endTimeAjoutUser = System.currentTimeMillis();
        long elapsedTimeAjoutUser = endTimeAjoutUser - startTimeAjoutUser;

        // Temps de chargement des messages
        long startTimeMessages = System.currentTimeMillis();
        loadMessages(bot);
        long endTimeMessages = System.currentTimeMillis();
        long elapsedTimeMessages = endTimeMessages - startTimeMessages;

        // Temps d'ajout d'un seul message
        long startTimeAjoutMessage = System.currentTimeMillis();
        addMessage((Utilisateur) utilisateur,newDate);
        long endTimeAjoutMessage = System.currentTimeMillis();
        long elapsedTimeAjoutMessage = endTimeAjoutMessage - startTimeAjoutMessage;

        // Temps d'ajout de n messages à un utilisatuer
        long startTimeAjoutNMessages = System.currentTimeMillis();
        loadMessagesSingleUser((Utilisateur) utilisateur,bot);
        long endTimeAjoutNMessages = System.currentTimeMillis();
        long elapsedTimeAjoutNMessages = endTimeAjoutNMessages - startTimeAjoutNMessages;

        // Affichage des temps
        testTempsGetUser();
        testTempsChargementUsersCSV(elapsedTimeUsers);
        System.out.println("Temps de chargement de 600000 messages depuis CSV : " + elapsedTimeMessages + "ms");
        System.out.println("Temps total du chargement des données depuis CSV : " + (elapsedTimeMessages + elapsedTimeUsers) + "ms");
        System.out.println();
        System.out.println("Temps d'ajout d'un seul utilisateur : " + elapsedTimeAjoutUser + "ms");
        System.out.println("Temps d'ajout d'un seul message : " + elapsedTimeAjoutMessage + "ms");
        testempsAjoutNMessages((Utilisateur) utilisateur, elapsedTimeAjoutNMessages);
        affichageNbUtilisateursFinaux();
        testTailleListeUtilisateur((Utilisateur) utilisateur);

        // Temps d'affichage d'une conversation
        long startTimeAfficherConversation = System.currentTimeMillis();
        afficherConversation("150000");
        long endTimeAfficherConversation = System.currentTimeMillis();
        long elapsedTimeAfficherConversation = endTimeAfficherConversation - startTimeAfficherConversation;
        testTempsAfficherConversation(elapsedTimeAfficherConversation);

        // Temps de suppression d'un utilisateur
        long startTimeSupprimerUtilisateur = System.currentTimeMillis();
        removeUtilisateur((Utilisateur) utilisateur);
        long endTimeSupprimerUtilisateur = System.currentTimeMillis();
        long elapsedTimeSupprimerUtilisateur = endTimeSupprimerUtilisateur - startTimeSupprimerUtilisateur;
        testTempsRemoveUtilisateur (elapsedTimeSupprimerUtilisateur);
        affichageNbUtilisateursFinaux();
    }

    // Méthodes abstraites, les enfants doivent les redéfinir
    public abstract Utilisateur get(String id);
    public abstract void createUtilisateurs();
    public abstract void loadUtilisateurs();
    public abstract void addUtilisateur(Utilisateur utilisateur);
    public abstract void removeUtilisateur(Utilisateur utilisateur);
    public abstract void testTempsRemoveUtilisateur(long elapsedTimeRemove);
    public abstract void loadMessages(Bot bot);
    public abstract void addMessage(Utilisateur utilisateur, LocalDateTime date);
    public abstract void loadMessagesSingleUser(Utilisateur utilisateur,Bot bot);
    public abstract void testTempsChargementUsersCSV(long elapsedTimeUsers);
    public abstract void affichageNbUtilisateursFinaux();
    public abstract void testTailleListeUtilisateur(Utilisateur utilisateur);
    public abstract void testempsAjoutNMessages(Utilisateur utilisateur, long elapsedTimeAjoutNMessages);
    public abstract void afficherConversation(String id);
    public abstract void testTempsAfficherConversation(long elapsedTimeAffichageConversation);
}

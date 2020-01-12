package ch.hegarc.ig.sda.test;

import ch.hegarc.ig.sda.business.Bot;
import ch.hegarc.ig.sda.business.Participant;
import ch.hegarc.ig.sda.business.Utilisateur;

import java.time.LocalDateTime;


public abstract class AbstractTest implements Test{

    static final int NB_MESSAGES_AJOUTES = 21;
    static final int NB_UTILISATEUR_AJOUTES = 1;


    @Override
    public void run() {
        Participant utilisateurAAjouter = new Utilisateur("300001","Melvyn","Vogelsang","melvyn.vogelsang@he-arc.ch");
        Bot bot = new Bot("Pascal le Bot");
        LocalDateTime newDate = LocalDateTime.now();

        doCreateUtilisateurs();

        // Temps de chargement des users
        long startTimeUsers = System.currentTimeMillis();
        doLoadUtilisateurs();
        long endTimeUsers = System.currentTimeMillis();
        long elapsedTimeUsers = endTimeUsers - startTimeUsers;

        // Temps de chargement d'un ajout d'un user
        long startTimeAjoutUser = System.currentTimeMillis();
        doAddUtilisateur((Utilisateur) utilisateurAAjouter);
        long endTimeAjoutUser = System.currentTimeMillis();
        long elapsedTimeAjoutUser = endTimeAjoutUser - startTimeAjoutUser;

        // Temps de chargement des messages
        long startTimeMessages = System.currentTimeMillis();
        doLoadMessages(bot);
        long endTimeMessages = System.currentTimeMillis();
        long elapsedTimeMessages = endTimeMessages - startTimeMessages;

        // Temps de chargement d'un ajout de message
        long startTimeAjoutMessage = System.currentTimeMillis();
        doAddMessage((Utilisateur) utilisateurAAjouter,newDate);
        long endTimeAjoutMessage = System.currentTimeMillis();
        long elapsedTimeAjoutMessage = endTimeAjoutMessage - startTimeAjoutMessage;


        // Temps d'ajout de n messages
        long startTimeAjoutNMessages = System.currentTimeMillis();
        doLoadMessagesSingleUser((Utilisateur) utilisateurAAjouter,bot);
        long endTimeAjoutNMessages = System.currentTimeMillis();
        long elapsedTimeAjoutNMessages = endTimeAjoutNMessages - startTimeAjoutNMessages;


        doTestTempsChargementUsersCSV(elapsedTimeUsers);
        System.out.println("Temps de chargement de 600000 messages depuis CSV : " + elapsedTimeMessages + "ms");
        System.out.println("Temps total du chargement des données depuis CSV : " + (elapsedTimeMessages + elapsedTimeUsers) + "ms");
        System.out.println();
        System.out.println("Temps d'ajout d'un seul utilisateur : " + elapsedTimeAjoutUser + "ms");
        System.out.println("Temps d'ajout d'un seul message : " + elapsedTimeAjoutMessage + "ms");
        doTestempsAjoutNMessages((Utilisateur) utilisateurAAjouter, elapsedTimeAjoutNMessages);
        doAffichageNbUtilisateursFinaux();
        doTestTailleListeUtilisateur((Utilisateur) utilisateurAAjouter);
        // Temps d'ajout de n messages
        long startTimeAfficherConversation = System.currentTimeMillis();
        doAfficherConversation();
        long endTimeAfficherConversation = System.currentTimeMillis();
        long elapsedTimeAfficherConversation = endTimeAfficherConversation - startTimeAfficherConversation;
        doTestTempsAfficherConversation(elapsedTimeAfficherConversation);

    }

    abstract void doCreateUtilisateurs();
    abstract void doLoadUtilisateurs();
    abstract void doAddUtilisateur(Utilisateur utilisateurAAjouter);
    abstract void doLoadMessages(Bot bot);
    abstract void doAddMessage(Utilisateur utilisateur, LocalDateTime dateAAjouter);
    abstract void doLoadMessagesSingleUser(Utilisateur utilisateur,Bot bot);
    abstract void doTestTempsChargementUsersCSV(long elapsedTimeUsers);
    abstract void doAffichageNbUtilisateursFinaux();
    abstract void doTestTailleListeUtilisateur(Utilisateur utilisateur);
    abstract void doTestempsAjoutNMessages(Utilisateur utilisateur, long elapsedTimeAjoutNMessages);
    abstract void doAfficherConversation();
    abstract void doTestTempsAfficherConversation(long elapsedTimeAffichageConversation);
}

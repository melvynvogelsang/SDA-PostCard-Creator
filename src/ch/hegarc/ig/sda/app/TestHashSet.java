package ch.hegarc.ig.sda.app;

import ch.hegarc.ig.sda.business.*;

import java.time.LocalDateTime;
import ch.hegarc.ig.sda.datastructure.HashSet;
import ch.hegarc.ig.sda.datastructure.Set;

public class TestHashSet {
    public TestHashSet() {

    }

    public void run() {
        // On crée le set des utilisateurs
        Set<Utilisateur> utilisateurs = new HashSet<>();

        Participant utilisateur = new Utilisateur("000001","Melvyn","Vogelsang","melvyn.test@gmail.com")
        Bot bot = new Bot("Pascal le Bot");
        LocalDateTime dateAAjouter = LocalDateTime.now();
        LoaderHashSet loader = new LoaderHashSet();

        // Temps de chargement des users
        long startTimeUsers = System.currentTimeMillis();
        loader.loadUsers(utilisateurs);
        long endTimeUsers = System.currentTimeMillis();
        long elapsedTimeUsers = endTimeUsers - startTimeUsers;

        // Temps de chargement des messages
        long startTimeMessages = System.currentTimeMillis();
        loader.loadMessages(utilisateurs, bot);
        long endTimeMessages = System.currentTimeMillis();
        long elapsedTimeMessages = endTimeMessages - startTimeMessages;

        // Temps de chargement du get
        long startTimeGet = System.currentTimeMillis();
        utilisateurs.get((Utilisateur) utilisateur).getConversation().afficherConversation();
        long endTimeGet = System.currentTimeMillis();
        long elapsedTimeGet = endTimeGet - startTimeGet;

        // Temps de chargement d'un ajout d'un user
        long startTimeAjoutUser = System.currentTimeMillis();
        Participant utilisateurAAjouter = new Utilisateur("300001", "Melvyn", "Vogelsang", "melvyn.vogelsang@he-arc.ch");
        utilisateurs.add((Utilisateur) utilisateurAAjouter);
        long endTimeAjoutUser = System.currentTimeMillis();
        long elapsedTimeAjoutUser = endTimeAjoutUser - startTimeAjoutUser;

        // Temps de chargement d'un ajout de message
        long startTimeAjoutMessage = System.currentTimeMillis();
        utilisateurs.get((Utilisateur) utilisateur).getConversation().addMessage("Message ajouté par le programme.", dateAAjouter, utilisateurAAjouter);
        long endTimeAjoutMessage = System.currentTimeMillis();
        long elapsedTimeAjoutMessage = endTimeAjoutMessage - startTimeAjoutMessage;


        // Temps d'ajout de 10k messages
        long startTimeAjout10kMessages = System.currentTimeMillis();
        loader.loadMessagesSingleUser((Utilisateur) utilisateurs.get((Utilisateur) utilisateur), bot);
        long endTimeAjout10kMessages = System.currentTimeMillis();
        long elapsedTimeAjout10kMessages = endTimeAjout10kMessages - startTimeAjout10kMessages;

        // Temps d'accès à la conversation d'un seul user
        long startTimeAffichageConversation = System.currentTimeMillis();
        utilisateurs.get((Utilisateur) utilisateur).getConversation().afficherConversation();
        long endTimeAffichageConversation = System.currentTimeMillis();
        long elapsedTimeAffichageConversation = endTimeAffichageConversation - startTimeAffichageConversation;

        System.out.println();
        System.out.println("Temps de chargement depuis CSV : " + (utilisateurs.size() - 1) + " utilisateurs : " + elapsedTimeUsers + "ms");
        System.out.println("Temps de chargement de 600000 messages depuis CSV : " + elapsedTimeMessages + "ms");
        System.out.println("Temps total du chargement des données depuis CSV : " + (elapsedTimeMessages + elapsedTimeUsers) + "ms");
        System.out.println();
        System.out.println("Temps de récupération d'une conversation : " + elapsedTimeGet + "ms");
        System.out.println();
        System.out.println("Temps d'ajout d'un seul utilisateur : " + elapsedTimeAjoutUser + "ms");
        System.out.println("Temps d'ajout d'un seul message : " + elapsedTimeAjoutMessage + "ms");
        System.out.println("Temps d'ajout de " + (utilisateurs.get((Utilisateur) utilisateur).getConversation().getMessages().size() - 20) + " messages : " + elapsedTimeAjout10kMessages + "ms");
        System.out.println("Temps d'affichage de la discussion d'un user : " + elapsedTimeAffichageConversation + "ms");
    }
}

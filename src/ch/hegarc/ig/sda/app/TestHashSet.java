package ch.hegarc.ig.sda.app;

import ch.hegarc.ig.sda.business.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class TestHashSet {
    public TestHashSet() {

    }

    public void run() {
        // On crée le set des utilisateurs
        Set<Utilisateur> utilisateurs = new HashSet<>();

        Bot bot = new Bot("Pascal le Bot");
        LocalDateTime dateAAjouter = LocalDateTime.now();
        LoaderHashSet loader = new LoaderHashSet();

        // Temps de chargement des users
        long startTimeUsers = System.currentTimeMillis();
        loader.loadUsers(utilisateurs);
        long endTimeUsers = System.currentTimeMillis();
        long elapsedTimeUsers = endTimeUsers - startTimeUsers;

        // Temps de chargement d'un ajout d'un user
        long startTimeAjoutUser = System.currentTimeMillis();;
        Participant utilisateurAAjouter = new Utilisateur("300001","Melvyn","Vogelsang","melvyn.vogelsang@he-arc.ch");
        utilisateurs.add((Utilisateur) utilisateurAAjouter);
        long endTimeAjoutUser = System.currentTimeMillis();
        long elapsedTimeAjoutUser = endTimeAjoutUser - startTimeAjoutUser;

        // Temps de chargement des messages
        long startTimeMessages = System.currentTimeMillis();
        loader.loadMessages(utilisateurs, bot);
        long endTimeMessages = System.currentTimeMillis();
        long elapsedTimeMessages = endTimeMessages - startTimeMessages;



        // Temps de chargement d'un ajout de message
        long startTimeAjoutMessage = System.currentTimeMillis();

        for (Utilisateur user : utilisateurs){
            if (user.equals(utilisateurAAjouter)){
                user.getConversation().addMessage("Message ajouté par le programme.", dateAAjouter, utilisateurAAjouter);
            }
        }

        long endTimeAjoutMessage = System.currentTimeMillis();
        long elapsedTimeAjoutMessage = endTimeAjoutMessage - startTimeAjoutMessage;


        // Temps d'ajout de n messages
        long startTimeAjout10kMessages = System.currentTimeMillis();

        loader.loadMessagesSingleUser((HashSet<Utilisateur>) utilisateurs,(Utilisateur) utilisateurAAjouter, bot,350000);
        long endTimeAjout10kMessages = System.currentTimeMillis();
        long elapsedTimeAjout10kMessages = endTimeAjout10kMessages - startTimeAjout10kMessages;

        //Temps d'accès à la conversation d'un seul user
        long startTimeAffichageConversation = System.currentTimeMillis();

       /** for (Utilisateur user : utilisateurs){
            if (utilisateur.equals(user)){
                user.getConversation().afficherConversation();
            }
        }
        */
        long endTimeAffichageConversation = System.currentTimeMillis();
        long elapsedTimeAffichageConversation = endTimeAffichageConversation - startTimeAffichageConversation;

        System.out.println();
        System.out.println("----------------------------");
        System.out.println("--- Données dans HashSet ---");
        System.out.println("----------------------------");
        System.out.println();
        System.out.println("Temps de chargement depuis CSV : " + (utilisateurs.size() - 1) + " utilisateurs : " + elapsedTimeUsers + "ms");
        System.out.println("Temps de chargement de 600000 messages depuis CSV : " + elapsedTimeMessages + "ms");
        System.out.println("Temps total du chargement des données depuis CSV : " + (elapsedTimeMessages + elapsedTimeUsers) + "ms");
        System.out.println();
        System.out.println("Temps d'ajout d'un seul utilisateur : " + elapsedTimeAjoutUser + "ms");
        System.out.println("Temps d'ajout d'un seul message : " + elapsedTimeAjoutMessage + "ms");
        System.out.println("Nombre d'utilisateurs final : " + utilisateurs.size());
        for (Utilisateur user : utilisateurs){
            if (utilisateurAAjouter.equals(user)){
                System.out.println("Temps d'ajout de " + (user.getConversation().getMessages().size() - 21 ) + " messages : " + elapsedTimeAjout10kMessages + "ms"); // - 21 car 21 messages ont été chargés dans le programme
                ;
            }
        }
       // System.out.println("Temps d'affichage de la discussion d'un user : " + elapsedTimeAffichageConversation + "ms");
    }
}

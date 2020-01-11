package ch.hegarc.ig.sda.app;

import ch.hegarc.ig.sda.business.Bot;
import ch.hegarc.ig.sda.business.LoaderLinkedList;
import ch.hegarc.ig.sda.business.Participant;
import ch.hegarc.ig.sda.business.Utilisateur;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class TestLinkedList {


    public TestLinkedList() {

    }

    public void run(){
        // On crée le set des utilisateurs
        List<Utilisateur> utilisateurs = new LinkedList<Utilisateur>();

        Bot bot = new Bot("Pascal le Bot");
        LocalDateTime dateAAjouter = LocalDateTime.now();
        LoaderLinkedList loader = new LoaderLinkedList();

        // Temps de chargement des users
        long startTimeUsers = System.currentTimeMillis();
        loader.loadUsers(utilisateurs);
        long endTimeUsers = System.currentTimeMillis();
        long elapsedTimeUsers = endTimeUsers - startTimeUsers;

        // Temps de chargement des messages
        long startTimeMessages = System.currentTimeMillis();
        loader.loadMessages(utilisateurs,bot);
        long endTimeMessages = System.currentTimeMillis();
        long elapsedTimeMessages = endTimeMessages - startTimeMessages;


        // Temps de chargement d'un ajout d'un user
        long startTimeAjoutUser = System.currentTimeMillis();
        Participant utilisateurAAjouter = new Utilisateur("300001","Melvyn","Vogelsang","melvyn.vogelsang@he-arc.ch");
        utilisateurs.add((Utilisateur) utilisateurAAjouter);
        long endTimeAjoutUser = System.currentTimeMillis();
        long elapsedTimeAjoutUser = endTimeAjoutUser - startTimeAjoutUser;

        // Temps de chargement d'un ajout de message
        long startTimeAjoutMessage = System.currentTimeMillis();
        utilisateurs.get(12345).getConversation().addMessage("Message ajouté par le programme.",dateAAjouter,utilisateurAAjouter);
        long endTimeAjoutMessage = System.currentTimeMillis();
        long elapsedTimeAjoutMessage = endTimeAjoutMessage - startTimeAjoutMessage;


        // Temps d'ajout de n messages
        long startTimeAjout10kMessages = System.currentTimeMillis();
        loader.loadMessagesSingleUser(utilisateurs.get(12345),bot,350000);
        long endTimeAjout10kMessages = System.currentTimeMillis();
        long elapsedTimeAjout10kMessages = endTimeAjout10kMessages - startTimeAjout10kMessages;

        // Temps d'accès à la conversation d'un seul user
        /**
        long startTimeAffichageConversation = System.currentTimeMillis();
        utilisateurs.get(12345).getConversation().afficherConversation();
        long endTimeAffichageConversation = System.currentTimeMillis();
        long elapsedTimeAffichageConversation = endTimeAffichageConversation - startTimeAffichageConversation;
        */
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("--- Données dans LinkedList ---");
        System.out.println("-------------------------------");
        System.out.println();
        System.out.println("Temps de chargement depuis CSV : " + (utilisateurs.size() -1) + " utilisateurs : " + elapsedTimeUsers + "ms");
        System.out.println("Temps de chargement de 600000 messages depuis CSV : " + elapsedTimeMessages + "ms");
        System.out.println("Temps total du chargement des données depuis CSV : " + (elapsedTimeMessages + elapsedTimeUsers) + "ms");
        System.out.println();
        System.out.println("Temps d'ajout d'un seul utilisateur : " + elapsedTimeAjoutUser + "ms");
        System.out.println("Temps d'ajout d'un seul message : " + elapsedTimeAjoutMessage + "ms");
        System.out.println("Nombre d'utilisateurs final : " + utilisateurs.size());
        System.out.println("Temps d'ajout de " + (utilisateurs.get(12345).getConversation().getMessages().size() - 21 )+ " messages : " + elapsedTimeAjout10kMessages + "ms"); // - 21 car 21 messages ont été chargés dans le programme
    }

}

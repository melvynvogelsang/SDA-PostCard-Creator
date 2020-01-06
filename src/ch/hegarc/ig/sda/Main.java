package ch.hegarc.ig.sda;

import ch.hegarc.ig.sda.business.Adresse;
import ch.hegarc.ig.sda.business.Bot;
import ch.hegarc.ig.sda.business.Conversation;
import ch.hegarc.ig.sda.business.Utilisateur;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // On crée le bot, l'utilisateur et son adresse
        Adresse adresse = new Adresse("Rue de la Côte 23", "2013","Colombier");
        Utilisateur utilisateur = new Utilisateur("Melvyn","Vogelsang","melvyn.vogelsang@he-arc.ch",adresse);
        Bot bot = new Bot("Pascal le Bot");

        // On crée la conversation
        Conversation conversation = new Conversation(utilisateur,bot);

        // On définit la date actuelle pour créer le message
        LocalDateTime date = LocalDateTime.now();

        // On crée le scanner pour lire le clavier de l'utilisateur
        Scanner sc = new Scanner(System.in);

        System.out.println("Utilisateur: " + utilisateur.getPrenom() + " " + utilisateur.getNom()+ ", " + utilisateur.getEmail()+", "  +utilisateur.getAdresse().getRue()+", "+utilisateur.getAdresse().getNpa()+" "+utilisateur.getAdresse().getLocalite());
        System.out.println("Début de la conversation ...");

        // L'utilisateur entre un message
        System.out.println("Entrez un message ...");
        String message = sc.nextLine();
        conversation.addMessage(message,date,utilisateur);

        // On affiche les messages
        System.out.println(conversation.getMessages());




    }
}

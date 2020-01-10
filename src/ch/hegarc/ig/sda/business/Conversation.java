package ch.hegarc.ig.sda.business;

import jdk.jshell.execution.Util;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class Conversation {
    private Deque<Message> messages;
    private Participant utilisateur;
    private Participant bot;

    public Conversation() {
        // On crée la liste de messages
        this.messages = new LinkedList<>();
    }

    public void addMessage(String texte, LocalDateTime date, Participant envoyeur){
        // On crée le nouveau message
        Message newMessage = new Message(texte,date,envoyeur);
        // On ajoute le message à la liste des messages
        messages.addLast(newMessage);
        // Retourne le message
        // newMessage.afficherMessage();
    }



    public void afficherConversation(){
        Iterator<Message> iterateur = messages.iterator();
        System.out.println();
        System.out.println("Début de la conversation ...");
        System.out.println();
        for (Message msg : messages){
            if (msg.getEnvoyeur() instanceof Bot){
                System.out.println();
                System.out.println(msg.getTexte());
                System.out.println(msg.getDate());
            }else{
                System.out.println();
                System.out.println("\t\t\t"+msg.getTexte());
                System.out.println("\t\t\t"+msg.getDate());
            }
        }
        System.out.println();
        System.out.println("Fin de la conversation ...");
        System.out.println();
    }



    public Deque<Message> getMessages(){
        return this.messages;
    }

        private class Message {
            private String texte;
            private LocalDateTime date;
            private Participant envoyeur;

            /** Constructeur */
            public Message(String texte, LocalDateTime date, Participant envoyeur) {
                this.texte = texte;
                this.date = date;
                this.envoyeur = envoyeur;
            }

            public void afficherMessage(){
                if(envoyeur instanceof Utilisateur){
                    System.out.println("\t\t\t" + texte);
                } else if (envoyeur instanceof Bot){
                    System.out.println(texte);
                }
            }

            public String getTexte() {
                return texte;
            }

            public void setTexte(String texte) {
                this.texte = texte;
            }

            public LocalDateTime getDate() {
                return date;
            }

            public void setDate(LocalDateTime date) {
                this.date = date;
            }

            public Participant getEnvoyeur() {
                return envoyeur;
            }

            public void setEnvoyeur(Participant envoyeur) {
                this.envoyeur = envoyeur;
            }


        @Override
        public String toString() {
            return "Message{" +
                    "texte='" + texte + '\'' +
                    ", date=" + date +
                    ", envoyeur=" + envoyeur +
                    '}';
        }
    }
}

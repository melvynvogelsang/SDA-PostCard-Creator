package ch.hegarc.ig.sda.business;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Conversation {

    private static final String DATE_FORMATTER= "dd MMMM yyyy à HH:mm";
    private Deque<Message> messages;
    private Participant utilisateur;
    private Participant bot;

    public Conversation() {
        this.messages = new LinkedList<>();
    }

    public void addMessage(String texte, LocalDateTime date, Participant envoyeur){
        Message newMessage = new Message(texte,date,envoyeur);
        messages.addLast(newMessage);
    }

    public void afficherConversation(){
        System.out.println();
        System.out.println("Début de la conversation ...");
        for (Message msg : messages){
            if (msg.getEnvoyeur() instanceof Bot){
                System.out.println();
                System.out.println(msg.getTexte());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
                String dateFormattee = msg.getDate().format(formatter);
                System.out.println("Envoyé le " + dateFormattee);
            }else{
                System.out.println();
                System.out.println("\t\t\t"+msg.getTexte());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
                String dateFormattee = msg.getDate().format(formatter);
                System.out.println("\t\t\tEnvoyé le " + dateFormattee);
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

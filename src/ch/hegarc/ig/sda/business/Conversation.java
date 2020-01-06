package ch.hegarc.ig.sda.business;

import java.time.LocalDateTime;
import java.util.Deque;
import java.util.LinkedList;

public class Conversation {
    private Deque<Message> messages;
    private Utilisateur utilisateur;
    private Bot bot;

    public Conversation(Utilisateur utilisateur, Bot bot) {
        // On crée la liste de messages
        this.messages = new LinkedList<Message>();
        this.utilisateur = utilisateur;
        this.bot = bot;
    }

    public void addMessage(String message, LocalDateTime date, Utilisateur envoyeur){
        // On crée le nouveau message
        Message newMessage = new Message(message,date,envoyeur);
        // On ajoute le message à la liste des messages
        messages.addFirst(newMessage);
        System.out.println("Message ajouté dans la liste des messages");
    }

    public Deque<Message> getMessages(){
        return this.messages;
    }

    /** Class message interne */
        private class Message {
            private String texte;
            private LocalDateTime date;
            private Utilisateur envoyeur;

            /** Constructeur */
            public Message(String texte, LocalDateTime date, Utilisateur envoyeur) {
                this.texte = texte;
                this.date = date;
                this.envoyeur = envoyeur;
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

            public Utilisateur getEnvoyeur() {
                return envoyeur;
            }

            public void setEnvoyeur(Utilisateur envoyeur) {
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

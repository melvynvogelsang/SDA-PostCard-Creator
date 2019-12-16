package ch.hegarc.ig.sda.business;

import java.util.Date;
import java.util.Deque;

public class Conversation {
    private Deque<Message> messages;
    private Utilisateur utilisateur;
    private Bot bot;

        /** Class message interne */
        public class Message {
            private String texte;
            private Date date;
            private Utilisateur envoyeur;

            /** Constructeur */
            public Message(String texte, Date date, Utilisateur envoyeur) {
                this.texte = texte;
                this.date = date;
                this.envoyeur = envoyeur;
            }
        }
}

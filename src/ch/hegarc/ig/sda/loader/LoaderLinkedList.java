package ch.hegarc.ig.sda.loader;

import ch.hegarc.ig.sda.business.Bot;
import ch.hegarc.ig.sda.business.Utilisateur;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class LoaderLinkedList extends AbstractLoader {

    public LoaderLinkedList() {
    }

    @Override
    protected void doLoadUsers(Collection<Utilisateur> utilisateurs,Utilisateur utilisateur) {
         utilisateurs.add(utilisateur);
    }

    @Override
    protected void doLoadMessagesSingleUser(Collection<Utilisateur> utilisateurs, Utilisateur user, Bot bot, int nbMessages) {
        LocalDateTime dateAAjouter = LocalDateTime.now();

        for(int i = 0; i < nbMessages; i++){
            user.getConversation().addMessage("Quelles sont vos heures d'ouverture ?", dateAAjouter, user);
            user.getConversation().addMessage("Nous sommes ouvert de 8h00 à 12h00 et de 13h00 à 18h00", dateAAjouter, bot);
        }
    }

    @Override
    protected void doLoadMessages(Collection<Utilisateur> utilisateurs, Bot bot,String[] splittedLines) {
        // On remplit la conversation de chaque utilisateur
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime newDate = LocalDateTime.parse(splittedLines[1], formatter);
        for (Utilisateur user : utilisateurs){
            user.getConversation().addMessage(splittedLines[0],newDate,user);
            user.getConversation().addMessage("Réponse du bot", newDate,bot);
        }
    }
    }


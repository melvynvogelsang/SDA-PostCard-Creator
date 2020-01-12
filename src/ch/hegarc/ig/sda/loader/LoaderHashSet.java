package ch.hegarc.ig.sda.loader;

import ch.hegarc.ig.sda.business.Bot;
import ch.hegarc.ig.sda.business.Utilisateur;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class LoaderHashSet extends AbstractLoader {

    public LoaderHashSet() {

    }

    @Override
    protected void doLoadUsers(Collection<Utilisateur> utilisateurs, Utilisateur utilisateur) {
        utilisateurs.add(utilisateur);
    }

    @Override
    protected void doLoadMessagesSingleUser(Collection<Utilisateur> utilisateurs, Utilisateur user, Bot bot, int nbMessages) {
        LocalDateTime date = LocalDateTime.now();
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getId() == user.getId()) {
                for (int i = 0; i < nbMessages; i++) {
                    user.getConversation().addMessage("Quelles sont vos heures d'ouverture ?", date, utilisateur);
                    user.getConversation().addMessage("Nous sommes ouvert de 8h00 à 12h00 et de 13h00 à 18h00", date, bot);
                }
            }
        }
    }

    @Override
    protected void doLoadMessages(Collection<Utilisateur> utilisateurs, Bot bot, String[] splittedLines) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime newDate = LocalDateTime.parse(splittedLines[1], formatter);
        for (Utilisateur utilisateur : utilisateurs) {
            utilisateur.getConversation().addMessage(splittedLines[0], newDate, utilisateur);
            utilisateur.getConversation().addMessage("Réponse du bot", newDate, bot);
        }
    }
}
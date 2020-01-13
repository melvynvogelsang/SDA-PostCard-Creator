package ch.hegarc.ig.sda.app;

import ch.hegarc.ig.sda.business.Bot;
import ch.hegarc.ig.sda.business.Utilisateur;

import java.time.LocalDateTime;

public interface PostTalk {

    void run();

    void createUtilisateurs();
    void loadUtilisateurs();
    void addUtilisateur(Utilisateur utilisateurAAjouter);
    void removeUtilisateur(Utilisateur utilisateur);
    void testTempsRemoveUtilisateur(long elapsedTimeRemove);
    void loadMessages(Bot bot);
    void addMessage(Utilisateur utilisateur, LocalDateTime dateAAjouter);
    void loadMessagesSingleUser(Utilisateur utilisateur,Bot bot);
    void testTempsChargementUsersCSV(long elapsedTimeUsers);
    void affichageNbUtilisateursFinaux();
    void testTailleListeUtilisateur(Utilisateur utilisateur);
    void testempsAjoutNMessages(Utilisateur utilisateur, long elapsedTimeAjoutNMessages);
    void afficherConversation(String id);
    void testTempsAfficherConversation(long elapsedTimeAffichageConversation);
}

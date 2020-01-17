package ch.hegarc.ig.sda.app;

import ch.hegarc.ig.sda.business.Bot;
import ch.hegarc.ig.sda.business.Utilisateur;

import java.time.LocalDateTime;

public interface PostTalk {

    void run();

    void createUtilisateurs();
    void loadUtilisateurs();
    void addUtilisateur(Utilisateur utilisateurAAjouter);
    void testTempsGetUser();
    void removeUtilisateur(Utilisateur utilisateur);
    void testTempsRemoveUtilisateur(long elapsedTime);
    void loadMessages(Bot bot);
    void addMessage(Utilisateur utilisateur, LocalDateTime dateAAjouter);
    void loadMessagesSingleUser(Utilisateur utilisateur,Bot bot);
    void testTempsChargementUsersCSV(long elapsedTime);
    void affichageNbUtilisateursFinaux();
    void testTailleListeUtilisateur(Utilisateur utilisateur);
    void testempsAjoutNMessages(Utilisateur utilisateur, long elapsedTime);
    void afficherConversation(String id);
    void testTempsAfficherConversation(long elapsedTime);
}

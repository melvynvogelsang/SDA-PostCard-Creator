package ch.hegarc.ig.sda;

import ch.hegarc.ig.sda.business.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // On crée le set des utilisateurs
        List<Utilisateur> utilisateurs = new LinkedList<>();
        Bot bot = new Bot("Pascal le Bot");

        Data data = new Data();

        data.loadUsers(utilisateurs);
        data.loadMessages(utilisateurs,bot);

        utilisateurs.get(982).getConversation().afficherConversation();
    }
}
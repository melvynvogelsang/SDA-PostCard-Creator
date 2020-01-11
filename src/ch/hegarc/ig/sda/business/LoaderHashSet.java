package ch.hegarc.ig.sda.business;

import ch.hegarc.ig.sda.datastructure.Set;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LoaderHashSet {
    public LoaderHashSet() {

    }

    public void loadUsers(Set<Utilisateur> utilisateurs){
        String csvFile = "data/data_users.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), "UTF-8"));

            int i= 0;
            while ((line = br.readLine()) != null) {

                if(i>0) {
                    String[] splittedLine = line.split(cvsSplitBy);
                    Participant utilisateur = new Utilisateur(splittedLine[0],splittedLine[1],splittedLine[2],splittedLine[3]);
                    utilisateurs.add((Utilisateur) utilisateur);
                }

                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(utilisateurs.size() + " utilisateurs ajoutés.");

    }

    public void loadMessagesSingleUser(Utilisateur user,Bot bot){
        LocalDateTime dateAAjouter = LocalDateTime.now();

        for(int i = 0; i < 10000; i++){
            user.getConversation().addMessage("Quelles sont vos heures d'ouverture ?", dateAAjouter, user);
            user.getConversation().addMessage("Nous sommes ouvert de 8h00 à 12h00 et de 13h00 à 18h00", dateAAjouter, bot);

        }
    }

    public void loadMessages(Set<Utilisateur>  utilisateurs, Bot bot){
        String csvFile = "data/data_messages.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), "UTF-8"));

            int i= 0;
            while ((line = br.readLine()) != null) {

                if(i>0) {
                    String[] splittedLine = line.split(cvsSplitBy);

                    // On remplit la conversation de chaque utilisateur
                    for (Utilisateur user : utilisateurs){
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        LocalDateTime newDate = LocalDateTime.parse(splittedLine[1], formatter);
                        user.getConversation().addMessage(splittedLine[0],newDate,user);
                        user.getConversation().addMessage("Réponse du bot", newDate,bot);
                    }
                }
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("20000 messages ajoutés.");

    }
}

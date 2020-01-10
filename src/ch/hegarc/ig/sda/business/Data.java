package ch.hegarc.ig.sda.business;

import jdk.jshell.execution.Util;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Data {

    public Data() {
    }

    public void loadUsers(List<Utilisateur> utilisateurs){
        String csvFile = "C:/Users/melvyn.vogelsan/Desktop/data/data_users.csv";
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
                    if(i==1000)
                        break;
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
    public void loadMessages(List<Utilisateur> utilisateurs, Bot bot){
        String csvFile = "C:/Users/melvyn.vogelsan/Desktop/data/data_messages.csv";
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
                        user.getConversation().addMessage("Votre colis se trouve à Colombier", newDate,bot);
                    }

                    if(i==1000)
                        break;
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

        System.out.println("Messages ajoutés dans les conversations.");

    }
}

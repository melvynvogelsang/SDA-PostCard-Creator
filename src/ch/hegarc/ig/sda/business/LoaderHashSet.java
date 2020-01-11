package ch.hegarc.ig.sda.business;




import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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


    }

    public void loadMessagesSingleUser(HashSet<Utilisateur> utilisateurs, Utilisateur user,Bot bot,int nbMessages){
        LocalDateTime dateAAjouter = LocalDateTime.now();
        for (Utilisateur utilisateur : utilisateurs){
            if (utilisateur.getId() == user.getId()) {
                for(int i = 0; i < nbMessages; i++){
                    user.getConversation().addMessage("Quelles sont vos heures d'ouverture ?", dateAAjouter, utilisateur);
                    user.getConversation().addMessage("Nous sommes ouvert de 8h00 à 12h00 et de 13h00 à 18h00", dateAAjouter, bot);
                }
            }
        }

    }

    public void loadMessages(Set<Utilisateur> utilisateurs, Bot bot){
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

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        LocalDateTime newDate = LocalDateTime.parse(splittedLine[1], formatter);
                        for (Utilisateur utilisateur : utilisateurs ){
                            utilisateur.getConversation().addMessage(splittedLine[0],newDate,utilisateur);
                            utilisateur.getConversation().addMessage("Réponse du bot", newDate,bot);
                    }
                    if(i==10)
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

    }
}

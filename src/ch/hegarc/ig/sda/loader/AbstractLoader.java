package ch.hegarc.ig.sda.loader;

import ch.hegarc.ig.sda.business.Bot;
import ch.hegarc.ig.sda.business.Participant;
import ch.hegarc.ig.sda.business.Utilisateur;

import java.io.*;

import java.util.Collection;

public abstract class AbstractLoader {


    public void loadUsers(Collection<Utilisateur> utilisateurs){
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
                    doLoadUsers(utilisateurs,(Utilisateur) utilisateur);
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
    };
    public void loadMessagesSingleUser(Collection<Utilisateur> utilisateurs, Utilisateur user, Bot bot, int nbMessages){
        doLoadMessagesSingleUser(utilisateurs,user,bot,nbMessages);
    }
    public void loadMessages(Collection<Utilisateur> utilisateurs, Bot bot){
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
                        doLoadMessages(utilisateurs,bot,splittedLine);
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

    protected abstract void doLoadUsers(Collection<Utilisateur> utilisateurs,Utilisateur utilisateur);
    protected abstract void doLoadMessagesSingleUser(Collection<Utilisateur> utilisateurs, Utilisateur user, Bot bot, int nbMessages);
    protected abstract void doLoadMessages(Collection<Utilisateur> utilisateurs, Bot bot,String[] splittedLines);
}

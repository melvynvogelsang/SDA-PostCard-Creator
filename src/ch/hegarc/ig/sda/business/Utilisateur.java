package ch.hegarc.ig.sda.business;

import java.rmi.server.UID;

public class Utilisateur {
    private String prenom;
    private String nom;
    private String email;
    private Adresse adresse;

    /** Constructeur */
    public Utilisateur(String prenom, String nom, String email, Adresse adresse) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
    }
    /** Getters et setters */
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}

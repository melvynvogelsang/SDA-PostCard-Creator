package ch.hegarc.ig.sda.business;

public class Carte {

    private String message;
    private String photo;
    private Adresse adresseDestinataire;
    private String email;

    public Carte(String message, String photo, Adresse adresseDestinataire, String email) {
        this.message = message;
        this.photo = photo;
        this.adresseDestinataire = adresseDestinataire;
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Adresse getAdresseDestinataire() {
        return adresseDestinataire;
    }

    public void setAdresseDestinataire(Adresse adresseDestinataire) {
        this.adresseDestinataire = adresseDestinataire;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

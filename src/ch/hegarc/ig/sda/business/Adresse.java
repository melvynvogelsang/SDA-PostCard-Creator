package ch.hegarc.ig.sda.business;

public class Adresse {
    private String rue;
    private String npa;
    private String localite;

    public Adresse(String rue, String npa, String localite) {
        this.rue = rue;
        this.npa = npa;
        this.localite = localite;
    }

    // Getter et Setter

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNpa() {
        return npa;
    }

    public void setNpa(String npa) {
        this.npa = npa;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }
}

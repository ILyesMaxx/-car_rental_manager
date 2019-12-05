package Classes;

public class Address {
    private String Rue;
    private String codePostal;
    private String ville;

    public void setRue(String rue) {
        Rue = rue;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return Rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    public Address(String rue, String codePostal, String ville) {
        Rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }
}

package fi.academy.ravintolaappback;

public class Ravintola {

    private int id;
    private String nimi;
    private String paikkakunta;
    private String osoite;
    private String tyyppi;

    public Ravintola() {}

    public Ravintola(int id, String nimi, String paikkakunta, String osoite, String tyyppi) {
        this.id = id;
        this.nimi = nimi;
        this.paikkakunta = paikkakunta;
        this.osoite = osoite;
        this.tyyppi = tyyppi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getPaikkakunta() {
        return paikkakunta;
    }

    public void setPaikkakunta(String paikkakunta) {
        this.paikkakunta = paikkakunta;
    }

    public String getOsoite() {
        return osoite;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    public String getTyyppi() {
        return tyyppi;
    }

    public void setTyyppi(String tyyppi) {
        this.tyyppi = tyyppi;
    }
}

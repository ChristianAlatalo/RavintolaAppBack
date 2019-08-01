package fi.academy.ravintolaappback;

public class Arvostelu {

    private int id;
    private int ravintola;
    private int arvosana;
    private String arvio;

    public Arvostelu() {}

    public Arvostelu(int ravintola, int arvosana, String arvio) {
        this.ravintola = ravintola;
        this.arvosana = arvosana;
        this.arvio = arvio;
    }

    public Arvostelu(int id, int ravintola, int arvosana, String arvio) {
        this.id = id;
        this.ravintola = ravintola;
        this.arvosana = arvosana;
        this.arvio = arvio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRavintola() {
        return ravintola;
    }

    public void setRavintola(int ravintola) {
        this.ravintola = ravintola;
    }

    public int getArvosana() {
        return arvosana;
    }

    public void setArvosana(int arvosana) {
        this.arvosana = arvosana;
    }

    public String getArvio() {
        return arvio;
    }

    public void setArvio(String arvio) {
        this.arvio = arvio;
    }
}

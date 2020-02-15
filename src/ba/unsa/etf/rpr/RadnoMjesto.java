package ba.unsa.etf.rpr;

import java.io.Serializable;

public class RadnoMjesto implements Serializable {
    private String naziv;
    private double koeficijent;
    private Radnik radnik;

    public RadnoMjesto() {
    }

    public RadnoMjesto(String naziv, int koeficijent, Radnik radnik) {
        this.naziv = naziv;
        this.koeficijent = koeficijent;
        this.radnik = radnik;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getKoeficijent() {
        return koeficijent;
    }

    public void setKoeficijent(int koeficijent) {
        this.koeficijent = koeficijent;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof RadnoMjesto) {
            RadnoMjesto rm = (RadnoMjesto) obj;
            return (naziv.equals(rm.getNaziv()) && koeficijent==rm.getKoeficijent());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int)(naziv.hashCode() * koeficijent);
    }
}

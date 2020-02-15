package ba.unsa.etf.rpr;

import java.util.*;
import java.util.function.Function;

public class Preduzece {
    private int osnovica;
    private List<RadnoMjesto> radnaMjesta=new ArrayList<>();

    public int dajOsnovicu() {
        return osnovica;
    }

    public void postaviOsnovicu(int osnovica) throws NeispravnaOsnovica {
        if(osnovica<=0){
            throw new NeispravnaOsnovica("Neipsravna osnovica "+ osnovica);
        }
        this.osnovica = osnovica;
    }

    public Preduzece(int osnovica) throws NeispravnaOsnovica {
        if(osnovica<=0){
            throw new NeispravnaOsnovica("Neipsravna osnovica "+ osnovica);
        }
        this.osnovica = osnovica;
    }


    public void novoRadnoMjesto(RadnoMjesto radnoMjesto) {
        radnaMjesta.add(radnoMjesto);
    }

    public void zaposli(Radnik radnik, String naziv) {
        boolean zaposlen=false;
        for(int i=0; i<radnaMjesta.size(); i++){
            if(radnaMjesta.get(i).getNaziv()==naziv && radnaMjesta.get(i).getRadnik()==null){
                radnaMjesta.get(i).setRadnik(radnik);
                zaposlen=true;
                break;
            }
        }
        if(zaposlen==false){
            throw new IllegalStateException("Nijedno radno mjesto tog tipa nije slobodno.");
        }
    }

    public void obracunajPlatu() {
        for(int i=0; i<radnaMjesta.size(); i++){
            if(radnaMjesta.get(i).getRadnik()!=null){
                radnaMjesta.get(i).getRadnik().dodajPlatu(osnovica*radnaMjesta.get(i).getKoeficijent());
            }
        }
    }

    public double iznosPlate() {
        double plata=0;
        for(int i=0; i<radnaMjesta.size(); i++){
            if(radnaMjesta.get(i).getRadnik()!=null){
                plata+=osnovica*radnaMjesta.get(i).getKoeficijent();
            }
        }
        return plata;
    }

    public Set<Radnik> radnici() {
        Set<Radnik> radnici=new TreeSet<>();
        for(int i=0; i<radnaMjesta.size(); i++){
            if(radnaMjesta.get(i).getRadnik()!=null){
                radnici.add(radnaMjesta.get(i).getRadnik());
            }
        }
        return radnici;
    }


    public Map<RadnoMjesto, Integer> sistematizacija() {
        Map<RadnoMjesto, Integer> mapa=new HashMap<>();
        for(int i=0; i<radnaMjesta.size(); i++){
            Integer vrijednost = mapa.get(radnaMjesta.get(i));
            if(vrijednost==null){
                mapa.put(radnaMjesta.get(i), 1);
            }
            else{
                mapa.put(radnaMjesta.get(i), vrijednost+1);
            }
        }
        return mapa;
    }

    public List<Radnik> filterRadnici(Function<Radnik, Boolean> funkcija) {
        List<Radnik> radnici = new ArrayList<>();
        for(int i=0; i<radnaMjesta.size(); i++){
            if(radnaMjesta.get(i).getRadnik()!=null && funkcija.apply(radnaMjesta.get(i).getRadnik())) {
                radnici.add(radnaMjesta.get(i).getRadnik());
            }
        }
        return radnici;
    }


    public List<Radnik> vecaProsjecnaPlata(double plata) {
        List<Radnik> radnici = filterRadnici((Radnik r) -> { return r.prosjecnaPlata()>plata; });
        return radnici;
    }

}

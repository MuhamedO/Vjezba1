package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.Radnik;
import ba.unsa.etf.rpr.RadnoMjesto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadnoMjestoTest {
    @Test
    public void radnoMjestoTest() {
        RadnoMjesto rm = new RadnoMjesto("Direktor", 10, new Radnik("Selma Selmić", "98989"));
        assertEquals("Direktor", rm.getNaziv());
        assertEquals(10, rm.getKoeficijent());
        assertEquals("Selma Selmić", rm.getRadnik().getImePrezime());

        // Drugi test?
        rm = new RadnoMjesto();
        rm.setNaziv("Portir");
        rm.setKoeficijent(5);
        assertEquals("Portir", rm.getNaziv());
        assertEquals(5, rm.getKoeficijent());
        assertNull(rm.getRadnik());
    }
}
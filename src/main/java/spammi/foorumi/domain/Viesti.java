
package spammi.foorumi.domain;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author mari
 */
public class Viesti {
    private int id;
    private String nimimerkki;
    private Viestiketju viestiketju;
<<<<<<< HEAD
    private Timestamp lahetysaika;
=======
    private Date lahetysaika;
>>>>>>> b2a987cd35a6c74cb6bcaefda6ae51db1569755e
    private String sisalto;

    public Viesti(int id, String nimimerkki, Viestiketju viestiketju, Date lahetysaika, String sisalto) {
        this.id = id;
        this.nimimerkki = nimimerkki;
        this.viestiketju = viestiketju;
        this.lahetysaika = lahetysaika;
        this.sisalto = sisalto;
    }

    public Viesti(String nimimerkki, Viestiketju viestiketju, String sisalto) {
        this.nimimerkki = nimimerkki;
        this.viestiketju = viestiketju;
        this.sisalto = sisalto;
    }

    public int getId() {
        return id;
    }

<<<<<<< HEAD
    public Timestamp getLahetysaika() {
=======
    public Date getLahetysaika() {
>>>>>>> b2a987cd35a6c74cb6bcaefda6ae51db1569755e
        return lahetysaika;
    }

    public String getNimimerkki() {
        return nimimerkki;
    }

    public String getSisalto() {
        return sisalto;
    }

    public Viestiketju getViestiketju() {
        return viestiketju;
    }
    
    public String toString() {
        return this.nimimerkki +" kirjoitti: \n" + this.sisalto +"\n"+ this.lahetysaika;
    }
    
    
    
}

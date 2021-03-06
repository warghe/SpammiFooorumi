package spammi.foorumi;

import java.sql.SQLException;
import java.util.Scanner;
import spammi.foorumi.database.*;
import spammi.foorumi.domain.*;

/**
 * @author mari, ninna, pinni
 */
public class TestiKayttis {

    private Database database;
    private AlueDao alueDao;
    private ViestiketjuDao vkDao;
    private ViestiDao viestiDao;
    private Scanner lukija;

    public TestiKayttis(Database database) {
        this.alueDao = new AlueDao(database);
        this.vkDao = new ViestiketjuDao(database);
        this.viestiDao = new ViestiDao(database);
        this.lukija = new Scanner(System.in);
        vkDao.setAlueDao(alueDao);
        vkDao.setViestiDao(viestiDao);
        viestiDao.setVkDao(vkDao);
        alueDao.setVkDao(vkDao);
    }

    public void testaa() throws SQLException {

//        naytaAlueet();
//        naytaViestiketjut();
//        viestiketjutAlueittain();
//        lisaaAlueViestiketjuJaViesti();
//        naytaViestit();
        naytaViestitKetjuittainJaAlueittain();
        naytaViimeisinLahetysaika();

    }

    //tulostaa kaikki alueet
    public void naytaAlueet() throws SQLException {
        for (Alue alue : alueDao.findAll()) {
            System.out.println(alue.toString());
        }
    }

    //tulostaa kaikki viestiketjut
    public void naytaViestiketjut() throws SQLException {
        for (Viestiketju ketju : vkDao.findAll()) {
            System.out.println(ketju.toString());
        }
    }

    //tulostaa viestiketjut alueittain
    public void viestiketjutAlueittain() throws SQLException {
        for (Alue alue : alueDao.findAll()) {
            System.out.println(alue.toString() + "\n- - - - - - - -");
            for (Viestiketju ketju : vkDao.findByAlue(alue)) {
                System.out.println(ketju.toString());
            }
            System.out.println("* * * * * * * *\n");
        }
    }

    //tulostaa kaikki viestit
    public void naytaViestit() throws SQLException {
        for (Viesti viesti : viestiDao.findAll()) {
            System.out.println(viesti.toString() + "\n");
        }
    }

    //hae kaikki viestit ketjuittain
    public void naytaViestitKetjuittain() throws SQLException {
        for (Viestiketju ketju : vkDao.findAll()) {
            System.out.println(ketju.toString() + "\n- - - - - - - -");
            for (Viesti viesti : viestiDao.findByViestiketju(ketju)) {
                System.out.println(viesti.toString());
            }
            System.out.println("* * * * * * * *\n");
        }
    }

    //hae kaikki viestit alueittain ja ketjuittain
    public void naytaViestitKetjuittainJaAlueittain() throws SQLException {
        for (Alue alue : alueDao.findAll()) {
            System.out.println(alue.toString() + "\n- - - - - - - -");
            for (Viestiketju ketju : vkDao.findByAlue(alue)) {
                System.out.println(ketju.toString() + "\n~ ~ ~ ~ ~ ~ ~ ~");
                for (Viesti viesti : viestiDao.findByViestiketju(ketju)) {
                    System.out.println(viesti.toString() + "\n~ ~ ~ ~ ~ ~ ~ ~");
                }
                System.out.println("");
            }
            System.out.println("* * * * * * * *\n");
        }
    }

    public void naytaViimeisinLahetysaika() throws SQLException {
        System.out.println(vkDao.findLatestLahetysaika(alueDao.findOne(1)));
    }

//    public void lisaaAlueViestiketjuJaViesti() throws SQLException {
//        luoAlue();
//        luoViestiketju();
//        luoViesti();
//    }
//    //lisää alueen
//    public void luoAlue() throws SQLException {
//        System.out.print("Alueen otsikko: ");
//        String otsikko = lukija.nextLine();
//
//        Alue alue = alueDao.create(new Alue(otsikko));
//        System.out.println(alue.toString());
//    }
//
//    //lisää viestiketju
//    public void luoViestiketju() throws SQLException {
//        Alue alue = alueDao.findOne(1);
//        System.out.print("Viestiketjun aihe: ");
//        String aihe = lukija.nextLine();
//
//        Viestiketju vk = vkDao.create(new Viestiketju(aihe, alue));
//        System.out.println(vk.toString());
//    }
//
//    //lisää viesti
//    public void luoViesti() throws SQLException {
//        Viestiketju vk = vkDao.findOne(1);
//        System.out.print("Nimimerkki");
//        String nimimerkki = lukija.nextLine();
//        System.out.print("Viesti: ");
//        String sisalto = lukija.nextLine();
//
//        Viesti viesti = viestiDao.create(new Viesti(nimimerkki, vk, sisalto));
//        System.out.println(viesti.toString());
//    }
}

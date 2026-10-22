
package com.mycompany.lp_lab_1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GijaTest {

    @Test
    void gijaAtliekaDarba() throws InterruptedException {
        ByteArrayOutputStream isvestis =
                new ByteArrayOutputStream();

        PrintStream pradineIsvestis = System.out;

        try {
            System.setOut(new PrintStream(isvestis));

            Gija gija = new Gija("Testo-gija");
            gija.start();
            gija.join(3000);

            assertFalse(gija.isAlive(),
                    "Gija turi baigti darbą");

            String tekstas = isvestis.toString();

            assertTrue(tekstas.contains(
                    "Testo-gija: Sveiki! Pradedu darba."));

            assertTrue(tekstas.contains(
                    "Testo-gija: Baigiau darba."));
        } finally {
            System.setOut(pradineIsvestis);
        }
    }
}

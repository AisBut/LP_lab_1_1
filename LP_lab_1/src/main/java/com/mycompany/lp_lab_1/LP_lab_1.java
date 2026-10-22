/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lp_lab_1;

// Gija.java
class Gija extends Thread {

    private String vardas;

    public Gija(String vardas) {
        this.vardas = vardas;
    }

    @Override
    public void run() {
        System.out.println(vardas + ": Sveiki! Pradedu darba.");

        try {
            // Simuliuojame darbą
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(vardas + ": Darbas buvo nutrauktas.");
        }

        System.out.println(vardas + ": Baigiau darba.");
    }
}

// PagrindinePrograma.java
public class LP_lab_1 {

    public static void main(String[] args) {

        // Sukuriame kelias gijas
        Gija g1 = new Gija("Gija-1");
        Gija g2 = new Gija("Gija-2");
        Gija g3 = new Gija("Gija-3");

        // Paleidžiame gijas
        g1.start();
        g2.start();
        g3.start();

        System.out.println("Pagrindine programa baige paleisti gijas.");
    }
}

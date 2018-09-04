package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Bankrekening> bank = new ArrayList<>();
        int teller = 0;
        while (teller < 4) {
            System.out.print("Geef rekeningnummer: ");
            String reknummer = scanner.nextLine();
            System.out.print("Geef bedrag: ");
            int bedrag = Integer.parseInt(scanner.nextLine());
            bank.add(new Bankrekening(reknummer, bedrag));
            teller++;
        }
        System.out.println("Rekeningen van meer dan 1000 EUR: ");
        bank.stream()
                .filter(r -> r.getSaldo() > 1000)
                .sorted((r1, r2) -> Integer.compare(r1.getSaldo(),r2.getSaldo()))
                .forEach(r -> System.out.printf("%s: %d%n",r.getRekeningnummer(),r.getSaldo()));
    }
}

class Bankrekening {
    private String rekeningnummer;
    private int saldo;

    public Bankrekening(String rekeningnummer, int saldo) {
        this.rekeningnummer = rekeningnummer;
        this.saldo = saldo;
    }

    public String getRekeningnummer() {
        return rekeningnummer;
    }

    public int getSaldo() {
        return saldo;
    }
}

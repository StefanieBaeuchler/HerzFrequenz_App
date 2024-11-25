package main;

import main.exceptions.InvalidInputException;
import main.exceptions.InvalidZoneException;
import main.exceptions.InvalidHeartRateException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HeartRateCalculator heartRateCalculator = new HeartRateCalculator();

        try {
            System.out.println("Bitte maximale Herzfrequenz [BPM]: ");
            String inputMaxHF = scanner.nextLine();
            int maxHF = heartRateCalculator.stringToInteger(inputMaxHF);

            System.out.println("Bitte gewünschte Laufzone (1-5): ");
            String inputZone = scanner.nextLine();
            int zone = heartRateCalculator.stringToInteger(inputZone);

            int targetHF = heartRateCalculator.calcTargetHeartRate(maxHF, zone);
            System.out.println("Die Ziel-Herzfrequenz für Zone " + zone + " beträgt: " + targetHF + " BPM");

        } catch (IllegalArgumentException e) {
            System.out.println("Fehler: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ein unerwarteter Fehler ist aufgetreten: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
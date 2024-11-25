package main;

import main.exceptions.InvalidInputException;
import main.exceptions.InvalidHeartRateException;
import main.exceptions.InvalidZoneException;


public class HeartRateCalculator {

    /**
     * Wandelt einen String in eine Ganzzahl um.
     * Äquivalenzklassen:
     * - Gültig: Ein String, der eine ganze Zahl repräsentiert (z.B. "42").
     * - Ungültig: Ein String, der keine Zahl ist (z.B. "abc"), ein leerer String oder `null`.
     *
     * @param input Der Eingabestring
     * @return Die konvertierte Ganzzahl
     * @throws InvalidInputException Wenn die Eingabe ungültig ist
     */
    public int stringToInteger(String input) throws InvalidInputException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Ungültige Eingabe: '" + input + "' ist keine Zahl.");
        }
    }

    /**
     * Berechnet die Zielherzfrequenz basierend auf der maximalen Herzfrequenz und der Zone.
     * Äquivalenzklassen:
     * - `maxHF`:
     *   - Gültig: > 0 (z.B. 180, 200)
     *   - Ungültig: ≤ 0 (z.B. -1, 0)
     * - `zone`:
     *   - Gültig: 1-5
     *   - Ungültig: < 1 oder > 5 (z.B. 0, 6)
     *
     * @param maxHF Maximale Herzfrequenz
     * @param zone Zielzone (1-5)
     * @return Die berechnete Zielherzfrequenz
     * @throws InvalidZoneException Wenn die Zone ungültig ist
     * @throws InvalidHeartRateException Wenn die maximale Herzfrequenz ungültig ist
     */
    public int calcTargetHeartRate(int maxHF, int zone)
            throws InvalidZoneException, InvalidHeartRateException {
        if (maxHF <= 0) {
            throw new InvalidHeartRateException("Die maximale Herzfrequenz muss größer als Null sein.");
        }

        if (zone < 1 || zone > 5) {
            throw new InvalidZoneException("Die Laufzone muss zwischen 1 und 5 liegen.");
        }

        double factor = 0.5 + 0.1 * zone;
        return (int) (maxHF * factor);
    }
}

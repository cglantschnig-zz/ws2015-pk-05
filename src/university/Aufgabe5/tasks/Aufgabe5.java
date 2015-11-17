/*
    Aufgabe5) Vervollständigung von Methoden

    Vervollständigen Sie die Methoden, sodass sie sich den Kommentaren entsprechend verhalten. Verändern Sie dabei nur
    Ausdrücke, die in einem Kommentar mit TODO: gekennzeichnet sind; genauer: die innersten runden Klammern mit dem
    TODO-Kommentar.
    Lassen Sie andere Teile der Klasse unverändert. Von dieser Einschränkung ausgenommen ist nur die Methode main, die
    Sie beliebig zum Testen verwenden können.

    Zusatzfragen:
    1. Warum sind Überprüfungen auf den Java-Wert null im Zusammenhang mit Arrays wichtig?
       weil zugriff auf nicht vorhandene indexe und length null pointer exceptions werfen würden
    2. Welchen Zweck erfüllt der Parameter x in sum bzw. n in primes?
       diese Variablen beschreiben den Index auf den gearbeitet wird.
       Lassen sich rekursive Methoden auf Arrays wie sum und primes auch ohne solche Parameter leicht implementieren?
       nein ohne index weiß man nicht wohin
    3. In welchen Fällen sind for-each-Schleifen auf Arrays wie in span vorteilhaft, in welchen nicht?
       bei lesendem zugriff ist alles supi, schreibend oder wenn wir die indexe brauchen nicht so gut
    4. Welchen Zweck erfüllen Arrays in Methoden wie div?
       um mehrere Rückgabewerte zu liefern
    5. Wie funktioniert primes?
       die erste primzahl wird mit 2 initilisiert
       daraufhin wird immer die nächste primzahl gesucht, solange bis der index gleich der größe es arrays ist
*/
public class Aufgabe5 {

    // Returns the sum of all elements with an index smaller than or equal to x in the array;
    // 0 is returned if the reference to the array equals null or x is not within the index range of the array.
    private static int sum(int[] array, int x) {
        if (array == null || array.length <= x || x <= 0) {
            return (0 /* TODO: modify expression */);
        }
        return sum(array, x - 1) + array[x];
    }

    // Returns the non-negative difference between the largest and smallest element in the two-dimensional array;
    // -1 is returned if the array or any part of it equals null or the array contains no element.
    private static int span(int[][] array) {
        boolean empty = true;
        int min = 0, max = 0;
        if (array == null || array.length == 1) {
            return -1;
        }
        for (int[] subarray : array) {
            if (subarray == null) {
                return -1;
            }
            for (int elem : subarray) {
                if (empty) {
                    min = max = elem;
                    empty = false;
                } else if (elem < min) {
                    min = elem;
                } else if (elem > max) {
                    max = elem;
                }
            }
        }
        return max - min;
    }

    // Fills the array with the first array.length prime numbers;
    // assumes that each array entry at an index below n is already correctly set.
    private static void primes(int[] array, int n) {
        if (array != null && n < array.length) {
            if (n == 0) {
                array[0] = 2;
                primes(array, n + 1);
            } else {
                int check = array[n - 1];
                boolean isPrime;
                do {
                    check++;
                    isPrime = true;
                    for (int i = 0; i < n; i++) {
                        isPrime = isPrime && (check % array[i] != 0);
                    }
                } while (! isPrime);
                array[n] = check;
                primes(array, n + 1);
            }
        }
    }

    // Returns an array containing the result of the division of x by y at index 0 and the remainder at index 1.
    private static int[] div(int x, int y) {
        return (new int[]{ x / y, x % y });
    }

    // Prints the contents of array; just for testing, nothing to do.
    private static void printArray(int[] array) {
        if (array == null) {
            System.out.println("null");
        } else {
            String s = "";
            for (int v : array) {
                if (s.length() == 0) {
                    s += v;
                } else {
                    s += "," + v;
                }
            }
            System.out.println("[" + s + "]");
        }
    }

    // Just for testing ...
    public static void main(String[] args) {
        // Den Rumpf dieser Methode können Sie beliebig verändern.
    }
}

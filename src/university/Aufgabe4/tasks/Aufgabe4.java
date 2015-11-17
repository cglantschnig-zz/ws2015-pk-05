/*
    Aufgabe4) Zweidimensionales Array

    Implementieren Sie folgende statische Methoden:

      - 'fillArray' hat ein zweidimensionales int-Array als Parameter und gibt die Gesamtzahl aller Einträge im Array
        zurück. Außerdem werden alle Einträge im Array mit fortlaufenden Zahlen (beginnend mit 0) befüllt. Für jeden
        Index in der ersten Dimension können die Array-Längen in der zweiten Dimension unterschiedlich sein.

      - 'printArray' gibt das als Argument übergebene zweidimensionale int-Array aus und liefert die Anzahl der Zeilen
        (= Länge des Arrays in der ersten Dimension) zurück. Nach jeder ausgegebenen Zahl steht ein Beistrich.
        Beispiel für ein durch 'fillArray' befülltes Array:

            0,1,2,3,
            4,5,6,
            7,8,
            9,

        Wie 'fillArray' muss auch 'printArray' mit allen dem Typ entsprechenden Arrays umgehen können, unabhängig von
        Größe und Form (Anzahl der Elemente pro Zeile).

      - 'transpose' hat als Parameter ein dreiecksförmiges zweidimensionales int-Array und vertauscht Werte im Array,
        sodass danach in einer durch 'printArray' erzeugten Ausgabe Zeilen und Spalten vertauscht sind. Nach Anwendung
        von 'transpose' auf das Array in obigem Beispiel gibt 'printArray' folgendes aus:

            0,4,7,9,
            1,5,8,
            2,6,
            3,

    In den Implementierungen dieser drei Methoden darf kein neues Array erzeugt werden.

    Zusatzfragen:
    1. Woran erkennt man an einem Variablenzugriff, ob auf das gesamte Array, einen Teil des Arrays oder einen einzelnen
       Wert im Array zugegriffen wird?
       Um bei n-dimensionalen arrays auf einen Wert zuzugreifen muss man n indexe angeben:
       int test[][][] = new int[a][b][c] --> test[0][0][0]
       bei jeder geringeren indexangabe wird auf ein array zugegriffen
    2. In keiner der zu implementierenden Methoden darf ein Array erzeugt werden. Woher kommen die benötigten Arrays?
       die kommen vom aufrufenden Programm
    3. Wie kann man Arrays mit mehreren Dimensionen (zwei, drei oder mehr) erzeugen? Geben Sie Beispiele dafür.
       int test[][][] = new int[45][23][4];
*/
public class Aufgabe4 {

    private static int fillArray(int[][] array) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = counter++;
            }
        }
        return counter;
    }

    private static int printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + ", ");
            }
            System.out.println();
        }
        return array.length;
    }

    private static void transpose(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int tmp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = tmp;
            }
        }
    }

    // Just for testing ...
    public static void main(String[] args) {
        // Den Rumpf dieser Methode können Sie beliebig verändern.
    }
}

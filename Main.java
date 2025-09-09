import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ArbolBinarioBusqueda arbol = null;
        try {
            arbol = new ArbolBinarioBusqueda("arbol.log");
            Random rnd = new Random();

            // Insertar 20 números únicos
            Set<Integer> insertados = new HashSet<>();
            while (insertados.size() < 20) {
                int v = rnd.nextInt(100) + 1;
                if (insertados.add(v)) arbol.insertar(v);
            }
            System.out.println("Insertados: " + insertados);

            // Buscar hasta encontrar uno
            int fallidas = 0;
            while (true) {
                int q = rnd.nextInt(100) + 1;
                boolean ok = arbol.buscar(q);
                if (ok) {
                    System.out.println("Encontrado " + q + " tras " + fallidas + " búsquedas fallidas.");
                    break;
                } else {
                    fallidas++;
                }
            }

        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        } finally {
            if (arbol != null) arbol.cerrarLog();
        }
    }
}

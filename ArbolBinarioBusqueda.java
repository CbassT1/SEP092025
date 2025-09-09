import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArbolBinarioBusqueda {
    Nodo raiz;
    private final PrintWriter logWriter;

    public ArbolBinarioBusqueda(String logFile) throws IOException {
        raiz = null;
        logWriter = new PrintWriter(new FileWriter(logFile, true));
    }

    public void insertar(int valor) {
        Nodo[] nuevo = new Nodo[1]; // referencia para capturar nodo creado
        raiz = insertarRec(raiz, valor, nuevo);
        if (nuevo[0] != null) {
            log("Insertado valor: " + valor + " en " + nuevo[0].daytime);
        } else {
            log("Duplicado ignorado: " + valor);
        }
    }

    private Nodo insertarRec(Nodo raiz, int valor, Nodo[] nuevo) {
        if (raiz == null) {
            Nodo n = new Nodo(valor);
            nuevo[0] = n;
            return n;
        }
        if (valor < raiz.valor) raiz.izquierda = insertarRec(raiz.izquierda, valor, nuevo);
        else if (valor > raiz.valor) raiz.derecha = insertarRec(raiz.derecha, valor, nuevo);
        return raiz;
    }

    public boolean buscar(int valor) {
        boolean ok = buscarRec(raiz, valor);
        log("Búsqueda de " + valor + ": " + (ok ? "ENCONTRADO" : "NO ENCONTRADO"));
        return ok;
    }

    private boolean buscarRec(Nodo raiz, int valor) {
        if (raiz == null) return false;
        if (raiz.valor == valor) return true;
        return valor < raiz.valor ? buscarRec(raiz.izquierda, valor) : buscarRec(raiz.derecha, valor);
    }

    private void log(String mensaje) {
        logWriter.println(mensaje);
        logWriter.flush();
    }

    public void cerrarLog() { if (logWriter != null) logWriter.close(); }
}

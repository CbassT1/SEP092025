import java.time.LocalDateTime;

public class Nodo {
    int valor;
    Nodo izquierda, derecha;
    LocalDateTime daytime;
    public Nodo(int valor) { this.valor = valor;
    this.daytime = LocalDateTime.now();}
}

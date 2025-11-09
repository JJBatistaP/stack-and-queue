package pila;

public class pila<T> {
    private Nodo<T> cima;
    private int tamaño;

    public pila() {
        cima = null;
        tamaño = 0;
    }

    public void push(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
        tamaño++;
    }

    public T pop() {
        if (isEmpty()) return null;
        T dato = cima.dato;
        cima = cima.siguiente;
        tamaño--;
        return dato;
    }

    public T peek() {
        return isEmpty() ? null : cima.dato;
    }

    public boolean isEmpty() {
        return tamaño == 0;
    }

    public int size() {
        return tamaño;
    }
}

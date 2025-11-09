package cola;

public class cola <T>{
    nodo <T> inicio;
    nodo <T> fin;
    int length;
    public cola() {
        inicio = null;
        fin = null;
        length = 0;
    }
    public void enqueue(T dato){
        nodo<T> nuevo = new nodo(dato);
        if(length==0){
            inicio = nuevo;
        }
        else{
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        length++;
    }
    public T dequeue(){
        if(length ==0){
            return null;
        }else{
            T dato = inicio.dato;
            inicio = inicio.siguiente;
            length--;
            if(inicio== null) fin=null;
            return dato;
        }
    }
    public void invertir(){
        nodo<T> anterior=null;
        nodo<T> actual = inicio;
        fin = inicio;
        while(actual != null){
            nodo<T>siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }
        inicio = fin;
    }
}

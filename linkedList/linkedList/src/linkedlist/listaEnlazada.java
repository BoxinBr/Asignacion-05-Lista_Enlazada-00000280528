package linkedlist;

import java.util.Iterator;

public class listaEnlazada<T> implements iList<T>, Iterable<T> {
    
    protected nodoSimple<T> inicio;
    protected int nElementos;
    
    public listaEnlazada() {
        inicio = null;
        nElementos = 0;
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private class nodoSimple<T> {
        private T dato;
        private nodoSimple<T> sig;
        
        public nodoSimple (T dato) {
            this.dato = dato;
        }
    }

    @Override
    public void append(T elemento) throws ListException {
        nodoSimple<T> nodoNuevo = new nodoSimple<>(elemento);
        nodoSimple<T> nodo = inicio;
        
        if(nodo == null) {
            inicio = nodoNuevo;
                    
        } else {
            
            while(nodo.sig != null) {
                nodo = nodo.sig;
            }
            
            nodo.sig = nodoNuevo;
            
        }
        
        nElementos ++;
    }

    @Override
    public void insert(T elemento, int index) throws ListException {
        nodoSimple<T> nodoNuevo = new nodoSimple<>(elemento);
        nodoSimple<T> nodo = inicio;


        if (index < 0 || index > nElementos) {
            throw new ListException("El indice esta fuera del limite");
        }

        if(index == 0) {

            nodoNuevo.sig = inicio;
            inicio = nodoNuevo;
        } else {
            nodoSimple<T> actual = inicio;

            for (int i = 0; i < index - 1; i++) {
                actual = actual.sig;
            }
        }

        nElementos++;
    }

    @Override
    public T get(int index) throws ListException {
        
        if (index < 0 || index > nElementos) {
            throw new ListException("El indice esta fuera del limite");
        }
        
        nodoSimple<T> actual = inicio;
        
        for (int i = 0; i < index - 1; i++) {
                actual = actual.sig;
        }
        
        return actual.dato;
    }

    @Override
    public T remove(int index) throws ListException {
        if (index < 0 || index > nElementos) {
            throw new ListException("El indice esta fuera del limite");
        }
        
        T elemRemovido;
        if (index == 0) {
            elemRemovido = inicio.dato;
            inicio = inicio. sig;
        } else {
            nodoSimple<T> actual = inicio;
            
            for (int i = 0; i < index - 1; i++) {
                actual = actual.sig;
            }
            
            elemRemovido = actual.sig.dato;
            actual.sig = actual.sig.sig;
        }
        
        nElementos--;
        return elemRemovido;
    }

    @Override
    public int empty() {
        return nElementos = 0;
    }

    @Override
    public int size() {
        return nElementos;
    }

    @Override
    public void clear() {
        inicio = null;
        nElementos = 0;
    }
    
    @Override
    public void reverse() {
        nodoSimple<T> previo = null;
        nodoSimple<T> actual = inicio;
        nodoSimple<T> siguiente = null;
        
        while (actual != null) {
            siguiente = actual.sig;
            actual.sig = previo;
            previo = actual;
            actual = siguiente;
        }
        inicio = previo;
    }
    
    @Override
    public void concatenar(listaEnlazada<T> otraLista) {
        if (otraLista == null || otraLista.size() == 0) {
            return;
        }
        
        if (this.inicio == null) {
            this.inicio = otraLista.inicio;
        } else {

            nodoSimple<T> actual = inicio;
            while (actual.sig != null) {
                actual = actual.sig;
            }

            actual.sig = otraLista.inicio;
        }

        this.nElementos += otraLista.size();
    }
    
    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder(); 
        sb.append("[ ");

        nodoSimple<T> actual = inicio;

        for(int i = 0; i < nElementos; i++){
            sb.append(actual.dato); 
            sb.append(", "); 
            actual = actual.sig; 
        }
        sb.append(" ]");
        return sb.toString();
    }
}

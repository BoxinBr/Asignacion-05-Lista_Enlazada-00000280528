package linkedlist;

import java.util.Iterator;

public interface iList<T> {
    
    public void append(T elemento) throws ListException;
    public void insert(T elemento, int index) throws ListException;
    public T get(int index) throws ListException;
    public T remove(int index) throws ListException;
    public int empty();
    public int size();
    public void clear();
    public void reverse();
    public void concatenar(listaEnlazada<T> otraLista);
}

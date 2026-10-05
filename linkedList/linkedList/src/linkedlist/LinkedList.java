package linkedlist;

public class LinkedList {

    public static void main(String[] args) {
        listaEnlazada listaCosas = new listaEnlazada<>();
        
        listaCosas.append("Poster");
        listaCosas.insert("Pelota", 0);
        listaCosas.append("Gorra");
        listaCosas.append("Lentes");
        
        System.out.println("Elementos en la lista: " + listaCosas.nElementos);
        System.out.println(listaCosas.toString());
        
        System.out.println("Elemento en la posicion 0: ");
        System.out.println(listaCosas.get(0));
        
        System.out.println("Elemento removido: ");
        System.out.println(listaCosas.remove(0));
        
        System.out.println("Tamaño de la lista: ");
        System.out.println(listaCosas.size());
        
        System.out.println("Lista al reverso: ");
        listaCosas.reverse();
        System.out.println(listaCosas.toString());
    }
    
}

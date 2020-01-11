package ch.hegarc.ig.sda.datastructure;

import java.util.HashMap;

public class HashSet<E> implements Set<E> {

    private HashMap<E, Object> map;

    // Dummy value: Un Objet commun et unique (static et final) permet de remplir la valeur requise par la HashMap en optimisant l'espace mémoire
    private static final Object PRESENT = new Object();

    public HashSet(){
        map = new HashMap<>();
    }

    public boolean contains(E element) {
        return map.containsKey(element);
    }

    @Override
    public boolean add(E element) {
        System.out.println("HashSet add: " + element + "(" + element.hashCode() + ")");
        return map.put(element, PRESENT)==null;
    }

    @Override
    public boolean remove(E element) {
        return map.remove(element)==PRESENT;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public E get(E element) {
        return (E) map.get(element);
    }
}

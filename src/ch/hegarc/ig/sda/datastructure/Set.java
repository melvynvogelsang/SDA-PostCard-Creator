package ch.hegarc.ig.sda.datastructure;

public interface Set<E> {
    int size( );

    boolean isEmpty( );

    /**
     * Ajoute un élément dans le Set.
     * Retourne true si l'élément a été ajouté et false sinon (élément déjà présent dans le Set).
     * @param element
     * @return
     */
    boolean add(E element);

    /**
     * Retourne l'élément d'un set.
     * @param element
     * @return
     */
    E get(E element);

    /**
     * Supprime l'élément du Set et retourne true, retourne false si l'élément n'est pas dans le Set.
     * @param element
     * @return
     */
    boolean remove(E element);

    /**
     * Retourne true si l'élément est dans le Set et false sinon.
     * @param element
     * @return
     */
    boolean contains(E element);
}

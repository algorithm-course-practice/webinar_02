package org.example.stage2;

public interface MySet<E> {

    boolean add(E element);

    boolean contains(E element);

    boolean remove(E element);

    int size();

    Iterable<E> entrySet();
}

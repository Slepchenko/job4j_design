package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList<E> implements List<E> {
    private int size = 0;
    private int modCount = 0;
    private Node<E> first;
    private Node<E> last;

    public SimpleLinkedList() {
        last = new Node<E>(first, null, null);
        first = new Node<E>(null, null, last);
    }

    @Override
    public void add(E value) {
        Node<E> node = last;
        node.item = value;
        last = new Node<E>(node, null, null);
        node.next = last;
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Node<E> point = first.next;
        if (!checkIndex(index, size)) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < index; i++) {
            point = next(point);
        }
        return point.item;
    }

    private Node<E> next(Node<E> item) {
        return item.next;
    }

    private boolean checkIndex(int index, int size) {
        return index >= 0 && index < size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            int point = 0;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return get(point++);
            }
        };
    }

    private class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> prev;

        private Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}

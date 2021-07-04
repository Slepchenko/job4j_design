package ru.job4j.collection.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {

        if (count >= (int) (table.length * LOAD_FACTOR)) {
            expand();
        }

        int index = indexFor(hash(key.hashCode()));

        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            return true;
        }
        return false;
    }

    private int hash(int hashCode) {
        if (hashCode != 0) {
            int h = hashCode ^ (hashCode >>> 16);
            return h;
        }
        return hashCode;
    }

    private int indexFor(int hash) {
        return hash % table.length;
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] expendedTable = new MapEntry[capacity];
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                int index = hash(table[i].key.hashCode());
                expendedTable[indexFor(index)] = table[i];
            }
        }
        table = expendedTable;
    }

    @Override
    public V get(K key) {

        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null && table[index].key.equals(key)) {
            return table[index].value;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {

        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null && table[index].key.equals(key)) {
            table[index] = null;
            count--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int point = 0;
            int index = 0;
            private int expectedModCount = modCount;
            private MapEntry<K, V>[] iteratorTable = table;

            @Override
            public boolean hasNext() {
                return point < count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                K res = null;

                for (int i = index; i < iteratorTable.length; i++) {
                    index++;
                    if (iteratorTable[i] != null) {
                        res = iteratorTable[i].key;
                        point++;
                        break;
                    }
                }
                return res;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }
}
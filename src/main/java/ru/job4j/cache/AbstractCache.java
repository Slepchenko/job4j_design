package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, new SoftReference<V>(value));
    }

    public V get(K key) {
        V strongRef = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (strongRef == null) {
            strongRef = load(key);
            put(key, load(key));
        }
        return strongRef;
    }

    protected abstract V load(K key);
}

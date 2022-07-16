package com.learn;

import java.util.Objects;

public class MyHashMap<K, V> {
    static class Node<K, V> {
        int hashCode;
        K key;
        V value;
        Node<K, V> next;

        public Node(final int hashCode, final K key, final V value) {
            this.hashCode = hashCode;
            this.key = key;
            this.value = value;
        }
    }

    private static float DEFAULT_LOAD = 0.75f;
    private static int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    private int size = 0;
    private int capacity;

    private float loadFactor;

    private Node<K, V>[] table;

    public MyHashMap() {
        this.capacity = DEFAULT_INITIAL_CAPACITY;
        this.loadFactor = DEFAULT_LOAD;
        this.table = new Node[this.capacity];
    }

    public void put(K key, V value) {
        resize();

        Node<K, V> node = getNode(key);
        if (node != null) {     // overwrite
            node.value = value;
            return;
        }

        int hash = getHashCode(key);
        int index = getHashIndex(hash);

        node = new Node(hash, key, value);
        Node<K, V> bucketNode = this.table[index];
        node.next = bucketNode;

        this.table[index] = node;
        this.size++;
    }

    public V get(K key) {
        printMap();
        Node<K, V> node = getNode(key);
        return node != null ? node.value : null;
    }

    public void remove(K key) {
        int hash = getHashCode(key);
        int index = getHashIndex(hash);

        Node<K, V> node = this.table[index];
        if (node == null) {
            return;
        }

        Node<K, V> prev = null;
        while (node != null) {
            if (isSameKey(node.key, key)) {
                if (prev != null) {
                    prev.next = node.next;
                } else {
                    this.table[index] = node.next;
                }
                return;
            }

            prev = node;
            node = node.next;
        }
    }

    private Node<K, V> getNode(K key) {
        int hash = getHashCode(key);
        int index = getHashIndex(hash);

        Node<K, V> node = this.table[index];
        if (node == null) {
            return null;
        }

        while (node != null) {
            if (isSameKey(node.key, key))
                return node;

            node = node.next;
        }

        return null;
    }

    private boolean isSameKey(K key1, K key2) {
        if (key1 == key2) {
            return true;
        }

        if (key1 == null || key2 == null) {
            return false;
        }

        return getHashCode(key1) == getHashCode(key2) && key1.equals(key2);
    }

    private void resize() {
        if (this.size < this.capacity * this.loadFactor)
            return;

        this.capacity = this.capacity << 1;
        Node<K, V>[] newTable = new Node[this.capacity];

        for (int i = 0; i < this.table.length; i++) {
            Node<K, V> node = this.table[i];
            while (node != null) {
                int newIndex = getHashIndex(node.hashCode);
                this.table[i] = this.table[i].next;

                node.next = newTable[newIndex];
                newTable[newIndex] = node;

                node = this.table[i];
            }
        }

        this.table = newTable;
    }

    private void printMap() {
        System.out.println("===================");
        for (int i = 0; i < this.table.length; i++) {
            System.out.print("[" + i + "]: ");

            Node<K, V> node = this.table[i];
            while (node != null) {
                System.out.print(" -> [" + node.key + "," + node.value + "]");
                node = node.next;
            }

            System.out.println();
        }
    }

    private int getHashIndex(int hash) {
        return hash & (this.capacity - 1);
    }

    private int getHashCode(K key) {
        return Objects.hashCode(key);
    }
}

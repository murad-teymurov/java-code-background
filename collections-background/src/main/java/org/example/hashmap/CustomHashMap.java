package org.example.hashmap;

public class CustomHashMap<K, V> {

    private int size;
    private int capacity;
    private Node<K, V>[] buckets;

    private float loadFactor;
    private int threshold;

    public CustomHashMap() {
        this.capacity = 16;
        this.buckets = new Node[capacity];
        this.loadFactor = 0.75f;
        this.threshold = (int) (capacity * loadFactor);
    }

    public int getSize() {
        return this.size;
    }

    public void put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value, null);

        if (size == threshold) {
            increaseCapacity();
            resizeBuckets();
        }

        int index = getIndex(key);

        Node<K, V> currentNode = buckets[index];

        if (currentNode == null) {
            buckets[index] = newNode;
            size++;
        } else {
            while (currentNode.next != null) {
                if (currentNode.key.equals(key)) {
                    currentNode.value = value;
                    return;
                }
                currentNode = currentNode.next;
            }
            if (currentNode.key.equals(key)) {
                currentNode.value = value;
            } else {
                currentNode.next = newNode;
                size++;
            }
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> currentNode = buckets[index];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode & (capacity - 1)); // hashcode maybe negative
        return index;
    }

    private void increaseCapacity() {
        capacity *= 2;
        threshold *= 2;
    }

    private void resizeBuckets() {
        Node<K, V>[] newBuckets = new Node[capacity];
        for (int i = 0; i < buckets.length; i++) {
//            newBuckets[i] = buckets[i]; not enough!!!
            Node<K, V> node = buckets[i];
            if (node != null) {
                int index = getIndex(node.key);
                Node<K, V> current = buckets[index];
                if (current == null) {
                    newBuckets[index] = node;
                } else {
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = node;
                }
            }
        }
        this.buckets = newBuckets;
    }


    private class Node<K, V> {
        private int hashCode;
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hashCode = key.hashCode();
        }

        @Override
        public String toString() {
            return "Node{" +
                    "hashCode=" + hashCode +
                    ", key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}

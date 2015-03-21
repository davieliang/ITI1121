package me.matt.luka.wrappers;

import java.util.Arrays;
import java.util.NoSuchElementException;

import me.matt.luka.interfaces.Map;

public class Dictionary implements Map<String, Token> {

    public Dictionary() {
        pairs = new Pair[10];
        head = 0;
    }

    private static class Pair {
        private String key;
        private Token value;

        private Pair(String key, Token value) {
            this.key = key;
            this.value = value;
        }

    }

    private Pair[] pairs;
    int head;

    @Override
    public Token get(String key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }
        for (int i = head - 1; i >= 0; i--) {
            Pair p = pairs[i];
            if (p != null) {
                if (p.key.equals(key)) {
                    return p.value;
                }
            }
        }
        throw new NoSuchElementException("The map does not contain the key: "
                + key);
    }

    @Override
    public void put(String key, Token value) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        } else if (value == null) {
            throw new NullPointerException("Value cannot be null");
        }
        if (head == pairs.length) {
            pairs = Arrays.copyOf(pairs, pairs.length + 5);
        }
        pairs[head++] = new Pair(key, value);
    }

    @Override
    public void replace(String key, Token value) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        } else if (value == null) {
            throw new NullPointerException("Value cannot be null");
        }
        for (int i = head - 1; i >= 0; i--) {
            Pair p = pairs[i];
            if (p != null) {
                if (p.key != null) {
                    if (p.key.equals(key)) {
                        p.value = value;
                        return;
                    }
                }
            }
        }
        throw new NoSuchElementException("The map does not contain the key: "
                + key);
    }

    @Override
    public Token remove(String key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }
        Token remove = null;
        for (int i = head - 1; i >= 0; i--) {
            if (pairs[i] != null) {
                if (pairs[i].key.equals(key)) {
                    remove = pairs[i].value;
                    pairs[i] = null;
                    break;
                }
            }
        }
        if (remove != null) {
            return remove;
        }
        throw new NoSuchElementException("The map does not contain the key: "
                + key);
    }

    @Override
    public boolean contains(String key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }
        for (Pair pair : pairs) {
            if (pair != null) {
                if (pair.key.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

}

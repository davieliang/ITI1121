package me.matt.luka.wrappers;

import java.util.Arrays;
import java.util.NoSuchElementException;

import me.matt.luka.interfaces.Map;

public class Dictionary implements Map<String, Token> {

    public Dictionary() {
        pairs = new Pair[INITIAL_CAPACITY];
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
    private int head;

    public static final int INCREMENT = 5;
    public static final int INITIAL_CAPACITY = 10;

    @Override
    public Token get(String key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }
        return pairs[getIndex(key)].value;
    }

    private int getIndex(String key) {
        for (int i = head - 1; i >= 0; i--) {
            Pair p = pairs[i];
            if (p.key.equals(key)) {
                return i;
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
            pairs = Arrays.copyOf(pairs, pairs.length + INCREMENT);
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
        pairs[getIndex(key)].value = value;
    }

    @Override
    public Token remove(String key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }
        int index = getIndex(key);
        Token remove = pairs[index].value;
        pairs[index] = null;
        pairs = shiftArray(pairs, index);
        if (remove != null) {
            head--;
            return remove;
        }
        throw new NoSuchElementException("The map does not contain the key: "
                + key);
    }

    private Pair[] shiftArray(Pair[] pairs, int index) {
        Pair[] result = new Pair[pairs.length];
        System.arraycopy(pairs, 0, result, 0, index);
        System.arraycopy(pairs, index + 1, result, index, pairs.length - index
                - 1);
        return result;
    }

    @Override
    public boolean contains(String key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }
        try {
            return getIndex(key) > -1;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        String elems = "Dictionary: {elems = [";
        for (int i = head - 1; i >= 0; i--) {
            Pair p = pairs[i];
            if (pairs[i] != null) {
                elems += "{key=" + p.key + ",value=" + p.value + "},";
            }
        }
        elems = (head > 0 ? elems.substring(0, elems.length() - 1) : elems)
                + "]}";
        return elems;
    }
}

package me.matt.luka.wrappers;

import java.util.Arrays;
import java.util.NoSuchElementException;

import me.matt.luka.interfaces.Map;

public class Dictionary implements Map<String, Token> {

    public Dictionary() {
        pairs = new Pair[10];
    }

    private static class Pair {
        private String string;
        private Token token;

        private Pair(String string, Token token) {
            this.string = string;
            this.token = token;
        }

    }

    private Pair[] pairs;
    int top = 0;

    @Override
    public Token get(String key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        } else if (!contains(Key)) {
            throw new NoSuchElementException(
                    "The map does not contain the key specified");
        }
        return null;
    }

    @Override
    public void put(String key, Token value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void replace(String key, Token value) {
        // TODO Auto-generated method stub

    }

    @Override
    public Token remove(String key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean contains(String key) {
        for (Pair pair : pairs) {
            if (pair.equals(key)) {
                return true;
            }
        }
        return false;
    }

}

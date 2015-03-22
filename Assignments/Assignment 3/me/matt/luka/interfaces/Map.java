package me.matt.luka.interfaces;

/**
 * Interface for a class of type map which stores key-value associations.
 * Note: for the Luka Virtual Machine project, a map can contain duplicate keys.
 * 
 * <ul>
 * <li>Classname: Map.java
 * <li>22-03-2015
 * <li>Assignment 3
 * <li>Course: IT1 1121 A
 * <li>Langlois, Matt
 * <li>Student number: 7731813
 * <li>Faubert, Joel
 * <li>Student number: 2560106 
 * </ul>
 * 
 * @author Matt Langlois
 * @author Joel Faubert
 * @version 1
 * 
 * */

public interface Map<K, V> {
  
  /**
   * Returns the lefmost (most recently added) value associated with this specified key.
   * @param K key to find in dictionary
   * @return value associated to specified key
   * @throws NoSuchElementException if specified key is not found in dictionary
   * @throws NullPointerException if specified key is null
   */
  public abstract V get(K key);
  
  /**
   * Returns true if the specified key is found in the dictionary 
   * @param K key to find in dictionary
   * @return true if key is found in the dictionary 
   * @throws NullPointerException if specified key is null
   */
  public abstract boolean contains(K key);
  
  /**
   * Adds a new definition to the dictionary
   * @param K key to define in the dictionary
   * @param V value to associate to the key
   * @throws NullPointerException if specified key or value is null
   */
  public abstract void put(K key, V value);
  
  /**
   * Replaces the value of the leftmost (most recently added) occurrence of the association for the specified key.
   * @param K key to redefine in the dictionary
   * @param V new value to associate to the existing key
   * @throws NoSuchElementException if specified key is not found in dictionary
   * @throws NullPointerException if specified key or value is null
   */
  public abstract void replace(K key, V value);
  
   /**
   * Removes the leftmost (most recently added) occurrence of the specified key.
   * @param K key to remove from the dictionary
   * @return returns value of key removed from dictionary
   * @throws NoSuchElementException if specified key is not found in dictionary
   * @throws NullPointerException if specified key or value is null
   */
  public V remove(K key);
  
}

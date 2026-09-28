package com.accenture.ltt.nine;

import java.util.Map;

public class Tester1002 {
	public static void main(String[] args) {
		Map<Object,Object> multipleEnteryMap1  = Map.of(1, "1", 2, 1,3,"three",4, "1", 5, 1,6,"three");
		Map<Object,Object> multipleEnteryMap2 =  Map.ofEntries(
													Map.entry(1, "One"),
													Map.entry(2, "Two"),
													Map.entry(3, "Three"),
													Map.entry(4, "Four")
												);
		multipleEnteryMap2.forEach((x,y)->System.out.println(x+","+y));
		
		
		//case2: un even  set of keys and values
        // Map.of("Key1", 1, "Key2", 2, "Key3"); // Won't compile as key and value are not there.
											     // there should be even set of values 
		
		//case3: duplicate keys
        //Map.of("a", 1, "a", 2); // IllegalArgumentException

	}

}
/*
 * 
 * 
 * Map.of(K key, V value)
Map.of(K key1, V value1, K key2, V value2)
... Up to 10 key/values
Map.ofEntries(Map.Entry<K, V>... entries)
 * Iteration order not guaranteed
 * **/

/**
 *
 * 
 * if you try to perform any of the below then you will get an error
 * 
 * 
 * static UnsupportedOperationException uoe() { return new UnsupportedOperationException(); }
 *      @Override public void clear() { throw uoe(); }
        @Override public V compute(K key, BiFunction<? super K,? super V,? extends V> rf) { throw uoe(); }
        @Override public V computeIfAbsent(K key, Function<? super K,? extends V> mf) { throw uoe(); }
        @Override public V computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> rf) { throw uoe(); }
        @Override public V merge(K key, V value, BiFunction<? super V,? super V,? extends V> rf) { throw uoe(); }
        @Override public V put(K key, V value) { throw uoe(); }
        @Override public void putAll(Map<? extends K,? extends V> m) { throw uoe(); }
        @Override public V putIfAbsent(K key, V value) { throw uoe(); }
        @Override public V remove(Object key) { throw uoe(); }
        @Override public boolean remove(Object key, Object value) { throw uoe(); }
        @Override public V replace(K key, V value) { throw uoe(); }
        @Override public boolean replace(K key, V oldValue, V newValue) { throw uoe(); }
        @Override public void replaceAll(BiFunction<? super K,? super V,? extends V> f) { throw uoe(); }
 * */

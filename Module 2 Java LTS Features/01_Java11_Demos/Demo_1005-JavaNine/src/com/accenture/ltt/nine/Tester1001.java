package com.accenture.ltt.nine;

import java.util.List;

public class Tester1001 {

	public static void main(String[] args) {
			List<Integer> list = List.of(1,2,3,4,5,6,7,8);
			list.forEach(x->System.out.println(x));
		}
	
		
}

//Collection Factory method for immutable collections

/**
 * 
 * List.of()
List.of(E e1)
List.of(E... elements)
List.of(E e1, E e2)
List.of(E e1, E e2, E e3)
List.of(E e1, E e2, E e3, E e4)
List.of(E e1, E e2, E e3, E e4, E e5)
List.of(E e1, E e2, E e3, E e4, E e5, E e6)
List.of(E e1, E e2, E e3, E e4, E e5, E e6, E e7)
List.of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8)
List.of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9)
List.of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10)
Intermediate array allocation
	
 * 
 * 
 * */



/**
 * 
 * 
 * if you try to perform any of the below then you will get an error
 * 
 *    // all mutating methods throw UnsupportedOperationException
        @Override public boolean add(E e) { throw uoe(); }
        @Override public boolean addAll(Collection<? extends E> c) { throw uoe(); }
        @Override public void    clear() { throw uoe(); }
        @Override public boolean remove(Object o) { throw uoe(); }
        @Override public boolean removeAll(Collection<?> c) { throw uoe(); }
        @Override public boolean removeIf(Predicate<? super E> filter) { throw uoe(); }
        @Override public boolean retainAll(Collection<?> c) { throw uoe(); }
        @Override public E       remove(int index) { throw uoe(); }
        @Override public void    replaceAll(UnaryOperator<E> operator) { throw uoe(); }
        @Override public E       set(int index, E element) { throw uoe(); }
        @Override public void    sort(Comparator<? super E> c) { throw uoe(); }

 * 
 * */

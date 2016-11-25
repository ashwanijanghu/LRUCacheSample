package com.jango;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LRUCache cache = new LRUCache(5);
		cache.set(99, 18);
		cache.set(98, 17);
		cache.set(97, 16);
		cache.set(96, 15);
		cache.set(95, 14);
		cache.set(94, 13);
		
		//cache.printCache();
		
		//System.out.println("=============");
		//System.out.println(cache.get(99));
		
		//cache.printCache();

		//System.out.println("=============");
		//System.out.println(cache.get(95));
		
		//cache.printCache();
		
		System.out.println("Chain :"+
				cache.head.key+"-->"+cache.head.value+" \n "
				+cache.head.next.key+"-->"+cache.head.next.value+" \n "
				+cache.head.next.next.key+"-->"+cache.head.next.next.value+" \n "
				+cache.head.next.next.next.key+"-->"+cache.head.next.next.next.value);
		cache.get(97);
		cache.get(95);
		cache.get(98);
		
		System.out.println("Chain :"+
				cache.head.key+"-->"+cache.head.value+" \n "
				+cache.head.next.key+"-->"+cache.head.next.value+" \n "
				+cache.head.next.next.key+"-->"+cache.head.next.next.value+" \n "
				+cache.head.next.next.next.key+"-->"+cache.head.next.next.next.value);

	}

}

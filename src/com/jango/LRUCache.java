package com.jango;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class LRUCache {

	int capacity;
	HashMap<Integer, Node> map = new HashMap<>();
	Node head = null;
	Node end = null;
	
	
	public LRUCache(int capacity){
		this.capacity = capacity;
	}
	
	public void set(int key, int value){
		if(map.containsKey(key)){
			Node n = map.get(key);
			n.value = value;
			//remove
			remove(n);
			//Make head
			setHead(n);
		}else{
			Node n = new Node(key,value);
			if(map.size() >= capacity){
				map.remove(end.key);
				//remove end
				remove(end);
				//make new head
				setHead(n);
			}else{
				//make head
				setHead(n);
			}
			map.put(key, n);
		}
	}
	
	public int get(int key){
		if(map.containsKey(key)){
			Node n = map.get(key);
			
			//remove
			remove(n);
			//make it head
			setHead(n);
			
			return n.value;
		}else{
			return -1;
		}
	}
	
	public void remove(Node n){
		if(n.prev != null){
			n.prev.next = n.next;
		}else{
			head = n.next;
		}
		
		if(n.next != null){
			n.next.prev = n.prev;
		}else{
			end = n.prev;
		}
	}
	
	public void setHead(Node n){
		n.next = head;
		n.prev = null;
		
		if(head != null)
		head.prev = n;
		
		head = n;
		
		if(end == null){
			end = head;
		}
		
	}
	
	public void printCache(){
		Iterator itr = map.entrySet().iterator();
		while(itr.hasNext()){
			Entry entry = (Entry) itr.next();
			System.out.println(entry.getKey()+" --> "+((Node)entry.getValue()).value);
		}
		
		System.out.println("HEAD : "+head.key+" --> "+head.value);
	}
}

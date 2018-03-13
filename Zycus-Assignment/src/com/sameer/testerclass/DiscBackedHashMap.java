package com.sameer.testerclass;

import com.sameer.collection.MyHashMap;

/**
 * 
 * @author Sameer A. Gaware
 * 
 *Tester class for MyHashMap
 */
public class DiscBackedHashMap {
	
	public static void main(String args[])
	{
		MyHashMap<String, String> out = new MyHashMap<>();
	
		out.putElement("Key1", "This entry will go in Map"); 
		out.putElement("Key2", "This entry will go in Map"); 
		out.putElement("Key3", "This entry will go in Map"); 
		out.putElement("Key4", "This entry will go in Map"); 
		out.putElement("Key5", "This entry will go in Map"); 
		out.putElement("Key6", "This entry will go in Map"); 
		out.putElement("Key7", "This entry will go in Map"); 
		out.putElement("Key8", "This entry will go in Map");
		out.putElement("Key9", "This entry will go in Map"); 
		out.putElement("Key10", "This entry will go in Map"); 
		out.putElement("Key11", "This entry will go in Map"); 
		out.putElement("Key12", "This entry will go in file"); 
		out.putElement("Key13", "This entry will go in file"); 
		out.putElement("Key14", "This entry will go in file"); 
		
		
		out.closeMap();
		System.out.println("object "+out.getElement("Key14"));   
		
	}
	

}


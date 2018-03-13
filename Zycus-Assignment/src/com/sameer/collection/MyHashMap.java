package com.sameer.collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;
/**
 * 
 * @author Sameer A. Gaware
 *
 * 
 * HashMap that Spills on disk when the size of HashMap exceeds 10
 * Currently it works for only String key & values.
 * I may need some more time to make it work for other object.'s
 * 
 * @param <K>
 * @param <V>
 * 
 */
public class MyHashMap<K,V> extends HashMap { 

	private BufferedWriter bw;
	private FileWriter fw;
	private BufferedReader br;
	private FileReader fr;
	private String  FILE_PATH = "E:/MyHash.txt";

	public MyHashMap()
	{
		try {
			fw = new FileWriter(FILE_PATH);
			bw = new BufferedWriter(fw);

			fr = new FileReader(FILE_PATH);
			br = new BufferedReader(fr);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method will try to get the object from map. if it does not find it the it will try to 
	 * get it form file
	 * @param key
	 * @return val Or null
	 */
	public V getElement(K key)
	{
		V val = (V)super.get(key);

		if(val == null)
		{
			val = getElementFromFile(key);
		}
		return val; 
	}

	/**
	 * This method will get the V object from file
	 * @param key
	 * @return
	 */
	private V getElementFromFile(K key) {

		try {

			String line = "";
			V val = null;
			while((line = br.readLine()) != null)
			{
				if(line.startsWith(key.toString())) 
				{

					int seperatorIndex = line.indexOf("`"); 
					val = (V)line.substring(seperatorIndex+1);

					break;
				}
			}
			System.out.println("Object1 : "+val); 
			return val;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * If the size of map exceeds 10 records then it will spills on discs
	 * @param key
	 * @param val
	 * @return
	 */
	public V putElement(K key, V val)
	{
		if(size() > 10)
		{
			System.out.println("Inserting record into text file");
			insertIntoFile(key,val);
			return null;
		}
		else

			return (V)put(key, val); 
	}

	/**
	 * Write the object key & value into file
	 * @param key
	 * @param val
	 */
	private void insertIntoFile(K key, V val) 
	{
		try {
			synchronized (this) {
				bw.write(key+"`"+val);
				bw.newLine();
			}
		} catch (IOException e) { 
			e.printStackTrace();
		} 

	}

	/**
	 * It will close all Readers & writers object and will flush the data in file
	 */
	public void closeMap()
	{
		try {
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}


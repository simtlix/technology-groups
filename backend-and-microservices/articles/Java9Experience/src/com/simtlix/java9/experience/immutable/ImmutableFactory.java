package com.simtlix.java9.experience.immutable;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableFactory {
	
	/**
	 * This method shows how to create new Immutable lists, maps and sets in Java9
	 */
	public static void checkImmutability() {
		
		List<String> immutableList = List.of("First", "Second");
		System.out.println("List: " + immutableList);
		
		/*
		 * If you uncomment the next line, it will throws a
		 * java.lang.UnsupportedOperationException due the list is immutable so, 
		 * it cannot be changed after creating.
		 */
		//immutableList.add("Not valid");
		System.out.println("List: " + immutableList);
		
		/*
		 * Map
		 */
		Map<String, String> immutableMap = Map.of("Key1", "Value1", "Key2", "Value2");
		System.out.println("Map: " + immutableMap);
		
		/*
		 * Set
		 */
		Set<String> immutableSet = Set.of("First", "Second", "Third");
		System.out.println("Set: " + immutableSet);

	}	
	
}

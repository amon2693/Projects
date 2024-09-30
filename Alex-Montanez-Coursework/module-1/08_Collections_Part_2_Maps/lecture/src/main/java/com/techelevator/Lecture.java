package com.techelevator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {


		System.out.println("####################");
		System.out.println("        SETS");
		System.out.println("####################");
		System.out.println();
		Set<String> characters = new HashSet<>();
		characters.add("Tish");
		System.out.println("Number of characters: " + characters.size());
		if(characters.contains("Bernie")) {
			System.out.println("Bernie is in there");
		} else {
			System.out.println("Bernie isn't there yet");
		}

		characters.add("Bernie");
		System.out.println("Number of characters: " + characters.size());

		if(characters.contains("Bernie")) {
			System.out.println("Bernie is in there");
		} else {
			System.out.println("Bernie isn't there yet");
		}

		characters.remove("Tish");
		System.out.println("Number of characters: " + characters.size());

		if(characters.contains("Bernie")) {
			System.out.println("Bernie is in there");
		} else {
			System.out.println("Bernie isn't there yet");
		}


		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		Map<Integer, String> roster = new HashMap<>();
		roster.put(1, "Natalie");
		roster.put(2, "Shae");
		roster.put(3, "Al");
		roster.put(3, "Tyrone");
		roster.put(4, "Al");
		System.out.println(roster);
		System.out.println(roster.get(1));

		Map<String, Integer> orders = createOrder();
		orders = addToOrder(orders, "Small Cheese",1);
		System.out.println("Large cheese pizzas: " + orders.get("Large Cheese"));
	}

	public static Map<String, Integer> createOrder() {
		Map<String, Integer> newOrders = new HashMap<>();
		newOrders.put("Large Cheese", 2);
		newOrders.put("Medium Cheese", 1);

		return newOrders;

	}

	public static Map<String, Integer> addToOrder(Map<String, Integer> orders, String item, Integer qty) {
		if(orders.containsKey(item)) {
			orders.put(item, orders.get(item) + qty);
		}
		return orders;
	}

	public static Integer getItemQuantity(Map<String, Integer

}

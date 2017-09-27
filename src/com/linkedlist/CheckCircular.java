package com.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CheckCircular {

	public static void main(String[] args) {
		Node rootMain = Node.createList();
		Map<Integer, Boolean> map = new HashMap<>();
		while (rootMain != null) {
			if (map.get((int) rootMain.data) != null) {
				//Linked List is circular. First Node whe  cycle is formed is
				System.out.println(rootMain.data);
				break;
			}
			map.put((int) rootMain.data, true);
			rootMain = rootMain.next;
		}
	}
}

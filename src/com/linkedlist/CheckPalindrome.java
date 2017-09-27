package com.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class CheckPalindrome {

	public static void main(String[] args) {
		Node rootMain = Node.createList();
		List<Integer> list = new ArrayList<>();
		while (rootMain != null) {
			list.add((int) rootMain.data);
			rootMain = rootMain.next;
		}
		boolean flag = true;
		for (int i = 0; i < list.size()/2; i++) {
			if (list.get(i) != list.get(list.size() - i - 1)) {
				flag = false;
				break;
			}
		}
		System.out.println(flag);
	}

}

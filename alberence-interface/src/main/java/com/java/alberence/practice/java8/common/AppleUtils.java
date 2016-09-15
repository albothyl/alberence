package com.java.alberence.practice.java8.common;

import java.util.ArrayList;
import java.util.List;

public class AppleUtils {

	private AppleUtils() {}

	public static List<Apple> generateAppleList() {
		List appleList = new ArrayList<Apple>();
		appleList.add(new Apple(1L, "green", 140));
		appleList.add(new Apple(2L, "red", 150));
		appleList.add(new Apple(3L, "yellow", 160));
		appleList.add(new Apple(4L, "green", 120));

		return appleList;
	}
}

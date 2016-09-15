package com.java.alberence.practice.java8.common;

import java.util.ArrayList;
import java.util.List;

public class AppleUtils {
	public static List<Apple> generateAppleList() {
		List appleList = new ArrayList<Apple>();
		appleList.add(new Apple(1l, "green", 140));
		appleList.add(new Apple(2l, "red", 150));
		appleList.add(new Apple(3l, "yellow", 160));
		appleList.add(new Apple(4l, "green", 120));

		return appleList;
	}
}

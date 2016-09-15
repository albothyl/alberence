package com.java.alberence.practice.java8.function;

import com.java.alberence.practice.java8.common.Apple;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntBiFunction;
import java.util.stream.Collectors;

import static com.java.alberence.practice.java8.common.AppleUtils.generateAppleList;

public class FunctionExample {

	public static void main(String[] args) {
		List<Apple> appleList = generateAppleList();

		List<Integer> appleWeightList1 = appleList.stream()
			.map(new Function<Apple, Integer>() {
				@Override
				public Integer apply(Apple apple) {
					return apple.getWeight();
				}
			})
			.collect(Collectors.toList());

		List<Integer> appleWeightList2 = appleList.stream()
			.map(Apple::getWeight)
			.collect(Collectors.toList());

		List<Integer> appleWeightList3 = appleList.stream()
			.map((Apple apple) -> apple.getWeight())
			.collect(Collectors.toList());
	}

	//BiFunction 은 2개의 인자를 받아서 1개의 결과를 반환한다. ToIntBiFunction는 이름에 int 형으로 반환한다고 명시되어 있기 때문에 generic 이 2개다.
	private static class ToBiFuntionImpl implements ToIntBiFunction<Apple, Apple> {
		@Override
		public int applyAsInt(Apple apple, Apple apple2) {
			return apple.getColor().compareToIgnoreCase(apple2.getColor());
		}
	}
}

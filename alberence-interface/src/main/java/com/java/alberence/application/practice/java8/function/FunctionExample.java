package com.java.alberence.application.practice.java8.function;

import com.java.alberence.application.practice.java8.common.Apple;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntBiFunction;
import java.util.stream.Collectors;

import static com.java.alberence.application.practice.java8.common.AppleUtils.generateAppleList;

@Slf4j
@SuppressWarnings("PMD.UnusedLocalVariable")
public class FunctionExample {

	private FunctionExample() {
	}

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
		log.info(appleWeightList1.toString());

		List<Integer> appleWeightList2 = appleList.stream()
			.map(Apple::getWeight)
			.collect(Collectors.toList());
		log.info(appleWeightList2.toString());

		List<Integer> appleWeightList3 = appleList.stream()
			.map((Apple apple) -> apple.getWeight())
			.collect(Collectors.toList());
		log.info(appleWeightList3.toString());

		List<Integer> appleWeightList4 = appleList.stream()
			.map(apple -> apple.getWeight())
			.collect(Collectors.toList());
		log.info(appleWeightList4.toString());
	}

	//BiFunction 은 2개의 인자를 받아서 1개의 결과를 반환한다. ToIntBiFunction는 이름에 int 형으로 반환한다고 명시되어 있기 때문에 generic 이 2개다.
	private static class ToBiFuntionImpl implements ToIntBiFunction<Apple, Apple> {
		@Override
		public int applyAsInt(Apple apple, Apple apple2) {
			return apple.getColor().compareToIgnoreCase(apple2.getColor());
		}
	}
}

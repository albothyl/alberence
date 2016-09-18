package com.java.alberence.application.practice.java8.predicate;

import com.java.alberence.application.practice.java8.common.AppleUtils;
import com.java.alberence.application.practice.java8.common.Apple;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
@SuppressWarnings("PMD.UnusedLocalVariable")
public class PredicateExample {

	private PredicateExample() {}

	public static void main(String[] args) {
		List<Apple> greenAppleList = AppleUtils.generateAppleList().stream()
			.filter(new GreenApplePredicate())
			.sorted()
			.collect(Collectors.toList());
		log.info("greenAppleList : " + greenAppleList.toString());

		//class 방식
		List<Apple> weight150UpperAppleList1 = AppleUtils.generateAppleList().stream()
			.filter(new Weight150Predicate())
			.collect(Collectors.toList());
		log.info("weight150UpperAppleList : " + weight150UpperAppleList1.toString());

		//익명 class 방식
		List<Apple> weight150UpperAppleList2 = AppleUtils.generateAppleList().stream()
			.filter(new Predicate<Apple>() {
				@Override
				public boolean test(Apple apple) {
					return 150 < apple.getWeight();
				}
			})
			.collect(Collectors.toList());
		log.info("weight150UpperAppleList : " + weight150UpperAppleList2.toString());

		//lambda 방식
		List<Apple> weight150UpperAppleList3 = AppleUtils.generateAppleList().stream()
			.filter(apple -> 150 < apple.getWeight())
			.collect(Collectors.toList());
		log.info("weight150UpperAppleList : " + weight150UpperAppleList3.toString());

		//Lambda 로 Predicate 생성할 수 있음
		Predicate<Integer> nonEmptyPredicate = (Integer a) -> 150 < a;
		log.info(nonEmptyPredicate.toString());
	}



	public static class GreenApplePredicate implements Predicate<Apple> {
		private static final String GREEN = "green";

		@Override
		public boolean test(Apple apple) {
			return GREEN.equals(apple.getColor());
		}
	}

	public static class Weight150Predicate implements Predicate<Apple> {
		private static final int WEIGHT_150 = 150;

		@Override
		public boolean test(Apple apple) {
			return WEIGHT_150 < apple.getWeight();
		}
	}
}

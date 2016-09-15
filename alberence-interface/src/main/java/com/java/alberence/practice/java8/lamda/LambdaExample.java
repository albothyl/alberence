package com.java.alberence.practice.java8.lamda;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import com.java.alberence.practice.java8.common.Apple;
import com.java.alberence.practice.java8.common.AppleUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class LambdaExample {

	/*
	TODO 질문 : Lambda는 익명 클래스를 단순화한것이라고 볼 수 있는데, 익명클래스처럼 객체를 생성하거나 메모리 영역을 사용하는가?
	 */
	public static void main(String[] args) {
		List<Apple> appleList = AppleUtils.generateAppleList();
		log.info("appleList : " + appleList.toString());

		appleList.stream()
			.sorted(Apple::compareTo);

		//오름차순은 left 가 앞으로
		List<Apple> sortedWeightAppleList = appleList.stream()
			.sorted((Apple left, Apple right) -> left.getWeight().compareTo(right.getWeight()))
			.collect(Collectors.toList());
		log.info("sortedWeightAppleList : " + sortedWeightAppleList.toString());
		//내림차순은 right 가 앞으로
		List<Apple> reverseSortedWeightAppleList = appleList.stream()
			.sorted((Apple left, Apple right) -> right.getWeight().compareTo(left.getWeight()))
			.collect(Collectors.toList());
		log.info("reverseSortedWeightAppleList : " + reverseSortedWeightAppleList.toString());

		//오름차순
		appleList.stream()
			.sorted(new AppleComparator());
		//내림차순
		appleList.stream()
			.sorted(new AppleComparator().reversed());

		//Lambda 로 Predicate 생성
		Predicate<String> nonEmptyPredicate = (String s) -> StringUtils.isEmpty(s);
	}

	//java util
	private static class AppleComparator implements Comparator<Apple> {
		@Override
		public int compare(Apple left, Apple right) {
			return left.getWeight().compareTo(right.getWeight());
		}
	}

	//guava
	private static class AppleOrdering extends Ordering<Apple> {
		@Override
		public int compare(Apple left, Apple right) {
			return Ints.compare(left.getWeight(), right.getWeight());
		}
	}
}

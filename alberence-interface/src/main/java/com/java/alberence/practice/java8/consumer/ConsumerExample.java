package com.java.alberence.practice.java8.consumer;

import com.java.alberence.practice.java8.common.Apple;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.java.alberence.practice.java8.common.AppleUtils.generateAppleList;

@Slf4j
public class ConsumerExample {

	public static void main(String[] args) {
		List<Apple> appleList = generateAppleList();
		log.info("consumer before : " + appleList.toString());

		appleList.forEach(new OnePlusConsumer());
		log.info("consumer after 1 : " + appleList.toString());

		appleList.forEach(apple -> apple.setWeight(apple.getWeight() + 1));
		log.info("consumer after 2 : " + appleList.toString());

		//TODO : stream 에서 Consumer 이렇게 사용하는게 아닌것 같다. List<Apple>로 받을 수 없음..
		appleList.stream()
			.map(Apple::getWeight)
			.collect(Collectors.toList())
			.forEach(weight -> weight += 1);
		log.info("consumer after : " + appleList.toString());
	}

	private static class OnePlusConsumer implements Consumer<Apple> {
		@Override
		public void accept(Apple apple) {
			apple.setWeight(apple.getWeight() + 1);
		}
	}
}

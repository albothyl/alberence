package com.java.alberence.application.practice.java8.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Apple implements Comparable<Apple> {
	private long id;
	private String color;
	@Setter
	private Integer weight;

	@Override
	public int compareTo(Apple apple) {
		return this.weight.compareTo(apple.getWeight());
	}
}

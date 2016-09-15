package com.java.alberence.domain.practice.java8;

import com.java.alberence.domain.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
@Table(name = "apple")
public class Apple extends AbstractEntity {
	private String name;
	private String color;
	private int weight;
	private String area;
	private long price;
}

package com.food.saver.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "food")
public class Food {
	@Id
	private String foodWastedDate;
	public static final double singlePersonConsumption = 1.2;
	private double foodWasted;
	private int numberOfPeopleCanFed;
}

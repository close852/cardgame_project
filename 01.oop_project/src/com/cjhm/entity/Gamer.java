package com.cjhm.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Gamer implements User {

	private String name;
	private List<Card> cards;
	private boolean turn;

	public Gamer() {
		this.cards = new ArrayList<>();
	}

	public void receiveCard(Card card) {

		this.cards.add(card);
		turnOn();
	}

	public List<Card> openCard() {
		return cards;
	}

	public int getSumScore() {
		return cards.stream().collect(Collectors.summingInt(Card::getScore));
	}

	@Override
	public void turnOn() {
		turn = true;
	}

	@Override
	public void turnOff() {
		turn = false;
	}

	@Override
	public boolean isTurn() {
		return turn;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}

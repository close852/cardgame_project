package com.cjhm.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cjhm.blackjack.constants.BlackjackConstants;

public class Dealer implements User {

	private String name;
	private List<Card> cards;

	private boolean turn;

	public Dealer() {
		this.cards = new ArrayList<>();
	}

	public void receiveCard(Card card) {
		if (isPossible()) {
			this.cards.add(card);
			turnOn();
		} else {
			turnOff();
		}
	}

	public List<Card> openCard() {
		return cards;
	}

	public int getSumScore() {
		return cards.stream().collect(Collectors.summingInt(Card::getScore));
	}

	private boolean isPossible() {
		return getSumScore() < BlackjackConstants.DEALER_RECEIVE_MAX;
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
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}

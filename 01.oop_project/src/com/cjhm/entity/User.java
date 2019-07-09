package com.cjhm.entity;

import java.util.List;

public interface User extends Comparable<User> {

	public String getName();

	public void setName(String name);

	public void receiveCard(Card card);

	public List<Card> openCard();

	public int getSumScore();

	public default int compareTo(User o) {
		return this.getSumScore() > o.getSumScore() ? -1 : 1;
	}

	public void turnOn();

	public void turnOff();

	public boolean isTurn();

}

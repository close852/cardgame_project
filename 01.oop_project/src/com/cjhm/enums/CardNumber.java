package com.cjhm.enums;

public enum CardNumber {
	ACE("1", 1), TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5), SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8),
	NINE("9", 9), TEN("10", 10), J("J", 10), Q("Q", 10), K("K", 10);

	private String mark;
	private int point;

	private CardNumber(String mark, int point) {
		this.mark = mark;
		this.point = point;
	}

	public String getMark() {
		return mark;
	}

	public int getPoint() {
		return point;
	}
}

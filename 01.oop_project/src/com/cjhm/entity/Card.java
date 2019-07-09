package com.cjhm.entity;

import com.cjhm.enums.CardNumber;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card implements Comparable<Card> {

	private String shape; // ♠♣◇♡
	private CardNumber number;// A,2,3,4,5,6,7,8,9,10,J,Q,K

	public String getCard() {
		return shape + number;
	}

	public int getScore() {
		return number.getValue();
	}

	@Override
	public int compareTo(Card o) {
		return 0;
	}

}

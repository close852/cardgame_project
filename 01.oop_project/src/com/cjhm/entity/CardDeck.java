package com.cjhm.entity;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.cjhm.enums.CardNumber;

public class CardDeck {

	private Stack<Card> cards;

	private static final Shape[] SHAPES = Shape.values();
	private static final CardNumber[] NUMBERS = CardNumber.values();

	// MAP(card, score)
	public CardDeck() {
		this.cards = generateCards();
		Collections.shuffle(cards);
	}

	private Stack<Card> generateCards() {
		Stack<Card> cards = new Stack<Card>();
		for (Shape shape : SHAPES) {
			for (CardNumber number : NUMBERS) {
				cards.add(makeCard(shape, number));
			}
		}

		return cards;
	}

	private Card makeCard(Shape shape, CardNumber number) {
		return Card.builder().shape(shape).number(number).build();
	}

	// TODO 카드 다떨어졌을때.. .상황 필요 - IndexOutOfBoundsException에 대한 처리
	public Card draw() {
		return this.cards.pop();
	}

	public List<Card> getCards() {
		return this.cards;
	}

	@Override
	public String toString() {
		return "CardDeck[" + cards.size() + "] [cards=" + cards + "]";
	}

	public enum Shape {
		SPADE("♠"), HEART("♡"), DIAMOND("◇"), CLUB("♣");

		private String value;

		Shape(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

}

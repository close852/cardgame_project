package com.cjhm.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.cjhm.enums.CardNumber;

public class CardDeck {

	private List<Card> cards;

	private static final List<String> SHAPES = Arrays.asList("♠", "♡", "◇", "♣");
	private static final CardNumber[] NUMBERS = CardNumber.values();

	// MAP(card, score)
	public CardDeck() {
		this.cards = generateCards();
	}

	private List<Card> generateCards() {
		List<Card> cards = new LinkedList<Card>();
		for (String shape : SHAPES) {
			for (CardNumber number : NUMBERS) {
				cards.add(makeCard(shape, number));
			}
		}

		return shuffle(cards);
	}

	private List<Card> shuffle(List<Card> cards) {
		Collections.shuffle(cards);
		return cards;
	}

	private Card makeCard(String shape, CardNumber number) {
		return Card.builder().shape(shape).number(number).build();
	}

	// TODO 카드 다떨어졌을때.. .상황 필요 - IndexOutOfBoundsException에 대한 처리
	public Card draw() {
		Card card = cards.stream().findFirst().orElse(new Card());
		cards.remove(card);
		return card;
	}

	@Override
	public String toString() {
		return "CardDeck[" + cards.size() + "] [cards=" + cards + "]";
	}

}

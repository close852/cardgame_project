package com.cjhm.controller;

import java.util.ArrayList;
import java.util.List;

import com.cjhm.entity.CardDeck;
import com.cjhm.entity.Dealer;
import com.cjhm.entity.Gamer;
import com.cjhm.entity.User;
import com.cjhm.rule.Rule;

public class Game {

	private Rule rule;

	public Game(Rule rule) {
		this.rule = rule;
	}

	public void play() {
		System.out.println("게임 시작\n");
		/* [START_OF_INIT] gamer, dealer, deck */
		User gamer = new Gamer();
		User dealer = new Dealer();
		CardDeck deck = new CardDeck();
		List<User> users = new ArrayList<>();
		users.add(gamer);
		users.add(dealer);
		/* [END_OF_INIT] gamer, dealer, deck */

		rule.initPhase(deck, users);
		
		rule.palyingPhase(deck, users);

//		users.forEach(User::showCards);
//		System.out.println(deck.toString());
	}

}

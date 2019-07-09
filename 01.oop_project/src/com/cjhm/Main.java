package com.cjhm;

import com.cjhm.blackjack.rule.BlackjackRule;
import com.cjhm.controller.Game;

public class Main {

	public static void main(String[] args) {
		Game game = new Game(new BlackjackRule());

		game.play();
	}

}

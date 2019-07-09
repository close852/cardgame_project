package com.cjhm.blackjack.rule;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.cjhm.blackjack.constants.BlackjackConstants;
import com.cjhm.entity.CardDeck;
import com.cjhm.entity.User;
import com.cjhm.rule.Rule;

public class BlackjackRule implements Rule {

	@Override
	public void initPhase(CardDeck deck, List<User> users) {

		for (int i = 0; i < BlackjackConstants.INIT_RECEIVE_CARD_COUNT; i++) {
			receiveCardByAllUsers(users, deck);
		}
	}

	private List<User> receiveCardByAllUsers(List<User> users, CardDeck deck) {
		for (User u : users) {
			u.receiveCard(deck.draw());
			print(u);
		}
		return users;
	}

	@Override
	public void palyingPhase(CardDeck deck, List<User> users) {
		Scanner scanner = new Scanner(System.in);
		do {
			if (isOverScore(users)) {
				break;
			}
			System.out.println("카드 뽑으실? 종료는 0");
			String result = scanner.nextLine();
			if (BlackjackConstants.EXIT.equals(result)) {
				break;
			}

			receiveCardByAllUsers(users, deck);
		} while (true);

		getWinner(users);
		scanner.close();
	}

	private boolean isOverScore(List<User> users) {
		return users.stream().filter(u -> u.getSumScore() > BlackjackConstants.BLACKJAK).count() > 0;
	}

	@Override
	public void getWinner(List<User> users) {
		User winner = users.stream().filter(u -> u.getSumScore() < BlackjackConstants.BLACKJAK).sorted().findFirst().orElse(users.get(0));

		System.out.println("winner : " + winner.getSumScore());
	}

	public void print(User u) {
		StringBuffer sb = new StringBuffer("Gamer 카드목록\n");
		sb.append("[" + u.getSumScore() + "]");
		sb.append(u.openCard().stream().map(c -> c.getShape() + "/" + c.getNumber()).collect(Collectors.joining(" , ", "[", "]")));
		sb.append("\n");
		System.out.println(sb);
	}
}

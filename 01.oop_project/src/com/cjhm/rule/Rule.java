package com.cjhm.rule;

import java.util.List;

import com.cjhm.entity.CardDeck;
import com.cjhm.entity.User;

public interface Rule {

	public void initPhase(CardDeck deck, List<User> users);

	public void palyingPhase(CardDeck deck, List<User> users);

	public void getWinner(List<User> users);

}

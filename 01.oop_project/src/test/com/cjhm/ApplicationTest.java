package test.com.cjhm;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.cjhm.entity.Card;
import com.cjhm.entity.CardDeck;

public class ApplicationTest {

	@Test
	public void contextLoad() {
		CardDeck deck = new CardDeck();
		List<Card> cards = deck.getCards();
//		cards.forEach(System.out::println);

		assertThat(cards.size(), is(52));
		deck.draw();
		assertThat(cards.size(), is(51));
	}

}

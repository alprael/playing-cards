package edu.cnm.deepdive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BlackJackHand implements Comparable<BlackJackHand> {

  private List<Card> cards = new LinkedList<>();
  private int rawValue = 0;
  private int aces = 0;
  // private List<Card> hand1;
  // private List<Card> hand2;
  // private boolean busted = false;

  public void add(Card card) {
    cards.add(card);
    rawValue += Math.min(10, card.getRank().getValue());
    if (card.getRank() == Rank.ACE) {
      aces++;
    }

   /** hand1 = new ArrayList<Card>();
    hand2 = new ArrayList<Card>();
    hand1.add();
    hand2.add(2);*/
    // TODO What else?
  }

  private int getValue() {
    int value = rawValue;
    if (rawValue > 21) {
      value = 0;
    } else if (rawValue <= 11 && aces > 0) {
      value += 10;
    }
    if (value == 21 && cards.size() == 2){
      value++;
    }
    return value;
  }

  @Override
  public int compareTo(BlackJackHand other) {
    /**int comparison = getValue() - other.getValue();
    if (comparison == 0 && getValue() == 21) {
      if (cards.size() == 2 || other.cards.size() == 2) {
        comparison = other.cards.size() - cards.size();
      }
    }*/
    return getValue() - other.getValue();
  }
}
/** compare list of cards to list of cards of another hand
 face cards got a value of 10, ace can either be 1 or 11 (if rank.getValue() >= 10, then card get value of 10.)
 Add up the values of each hand, if value is > 21, it's a bust.
 if hand = 21 and if length of hand is 2, that's blackjack (which is a definitive win.)
 however, if hand = 21 but length is over 2, not blackjack.
 if hand is > 21 and contains an ace, ace has value of 1, otherwise it's 11.
 Assuming hands aren't 21, if added value of hand1 is > the value of hand2 without busting, hand1 wins.*/
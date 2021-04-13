package uno.model;

import java.util.ArrayList;

public class Player {
    //Fields
    private final String name;
    private int wins;
    private ArrayList<Cards> hand;

    // Constructor
    public Player(String name) {
        hand = new ArrayList<Cards>();
        this.name = name;
        wins = 0;
    }

    // Accessor Methods
    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public Cards[] getHand() {
        Cards[] handA = new Cards[hand.size()];
        for (int i = 0; i < hand.size(); i++) {
            handA[i] = hand.get(i);
        }
        return handA;
    }

    // Mutator Methods

    public void resetHand() {
        hand = new ArrayList<Cards>();
    }

    // Game Play Methods
    public void addCard(Cards card) {
        hand.add(card);
    }

    public Cards removeCard(Cards card) {
        for(Cards c: hand) {
            if(c.equals(card)) {
                hand.remove(c);
                break;
            }
        }
        return card;
    }
}

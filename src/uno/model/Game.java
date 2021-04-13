package uno.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    // Fields
    private Player[] players;
    private int curr;
    private Player currP;
    private ListQueue<Cards> deck;
    private Cards top;
    private String skipT;
    private String draw2;

    //Constructor
    public Game() {
        players = new Player[2];
        players[0] = new Player("Player");
        players[1] = new Player("Comp");
        curr = 0;
        currP = players[0];
        skipT = "RS RR RD BS BR BD YS YR YD GS GR GD WD";
        draw2 = "RD BD YD GD";
        reset();
    }

    // Accessor Methods
    public Player getCurr() {
        return currP;
    }

    public Player getP() {
        return players[0];
    }

    public Player getC() {
        return players[1];
    }

    public Cards getTop() {
        return top;
    }

    // Status Methods

    public boolean over() {
        return (players[0].getHand().length == 0 || players[1].getHand().length == 0);
    }

    public boolean isPlayable(Cards card) {
        if (card == Cards.WILD || card == Cards.WILD_DRAW) {
            return true;
        } else {
            String tc = top.value().substring(0, 1);
            String tt = top.value().substring(1);
            String cc = card.value().substring(0, 1);
            String ct = card.value().substring(1);
            return (tc.equals(cc) || tt.equals(ct));
        }
    }

    // Game Play Methods

    public void switchPlayer() {
            if(curr == 1) {
                curr = 0;
            } else {
                curr ++;
            }
            currP = players[curr];
    }

    public Cards draw() {
        if(deck.isEmpty()) {
            // Create deck
            ArrayList<Cards> dec = new ArrayList<Cards>();
            Cards[] cards = Cards.values();
            dec.addAll(Arrays.asList(cards).subList(0, cards.length - 4));
            dec.addAll(Arrays.asList(cards).subList(0, cards.length - 8));
            dec.addAll(Arrays.asList(cards).subList(0, 2));
            dec.addAll(Arrays.asList(cards).subList(0, 2));

            for (Cards c : dec) {
                int i = (int) (Math.random() * dec.size());
                deck.add(dec.get(i));
            }
        }
        return deck.remove();
    }

    public boolean play(Cards selected) {
        if(isPlayable(selected)) {
            top = currP.removeCard(selected);
            if(!skipT.contains(selected.value())){
                switchPlayer();
            }
            if(draw2.contains(selected.value())) {
                if (currP == players[0]) {
                    players[1].addCard(draw());
                    players[1].addCard(draw());
                } else {
                    players[0].addCard(draw());
                    players[0].addCard(draw());
                }
            } else if(selected == Cards.WILD_DRAW) {
                if (currP == players[0]) {
                    players[1].addCard(draw());
                    players[1].addCard(draw());
                    players[1].addCard(draw());
                    players[1].addCard(draw());
                } else {
                    players[0].addCard(draw());
                    players[0].addCard(draw());
                    players[0].addCard(draw());
                    players[0].addCard(draw());
                }
            }
            return true;
        }
        return false;
    }

    public void setTop(Cards card) {
        top = card;
    }

    public void reset() {
        ArrayList<Cards> dec = new ArrayList<Cards>();
        deck = new ListQueue<Cards>();
        Cards[] cards = Cards.values();
        // Create deck
        dec.addAll(Arrays.asList(cards).subList(0, cards.length - 4));
        dec.addAll(Arrays.asList(cards).subList(0, cards.length - 8));
        dec.addAll(Arrays.asList(cards).subList(0, 2));
        dec.addAll(Arrays.asList(cards).subList(0, 2));

        for (Cards c : dec) {
            int i = (int) (Math.random() * dec.size());
            deck.add(dec.get(i));
        }

        // Reset hands
        for(Player p : players) {
            p.resetHand();
        }
            for (int i = 1; i <= 7; i++) {
                for(Player p : players) {
                    p.addCard(draw());
                }
            }
        top = draw();
    }
}
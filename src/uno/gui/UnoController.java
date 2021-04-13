package uno.gui;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import uno.model.Cards;
import uno.model.Game;

import java.io.File;

public class UnoController {


    // Data Fields
    Game ono;
    Cards[] pHand;
    Cards[] cHand;
    Cards top;
    int tb;
    int childSize;
    ImageView moveableBack;

    // FXML Connections
    @FXML
    Pane pane;

    // Animation
    private Wait clock;

    private class Wait extends AnimationTimer {

        private long FRAMES_PER_SEC = 40L;
        private long INTERVAL = 100000000L / FRAMES_PER_SEC;
        private int MAX = 10;

        private long last = 0;
        private int count = 0;

        @Override
        public void handle(long now) {
            if(now - last > INTERVAL) {
                pane.getChildren().remove(moveableBack);
                pane.getChildren().add(moveableBack);
                childSize = pane.getChildren().size();
                moveableBack.setX((500+(count*((int)(Math.random()*22))))%20+490);
                moveableBack.setY((250+(count*((int)(Math.random()*22))))%20+240);
                pane.getChildren().set(childSize-1, moveableBack);

                last = now;
                count ++;
                if(count > MAX) {
                    clock.stop();
                    count = 0;
                    updateViews();
                }
            }
        }
    }

    //Initialization
    @FXML
    public void initialize() {
        moveableBack = new ImageView();
        File t = new File("src/uno/resources/Card_Back.png");
        moveableBack.setImage(new Image(t.toURI().toString()));
        moveableBack.setFitWidth(90);
        moveableBack.setFitHeight(150);
        EventHandler<MouseEvent> draw = e -> draw();
        moveableBack.setOnMouseReleased(draw);
        resetGame();
    }

    // Game Play Methods
    public void play(Cards[] hand, int card) {
        if(ono.play(hand[card])) {
            updateViews();
        }
        if(top == Cards.WILD || top == Cards.WILD_DRAW) {
            chooseColor();
        }
    }

    public void draw() {
        ono.getP().addCard(ono.draw());
        waitAnimation();
        ono.switchPlayer();
    }

    public void compTurn() {
        waitAnimation();
        for(int i = 0; i < cHand.length; i++) {
            Cards card = cHand[i];
            if(ono.isPlayable(card)) {
                play(cHand, i);
                return;
            }
        }
        ono.getC().addCard(ono.draw());
        waitAnimation();
        ono.switchPlayer();
    }

    public void chooseColor() {
        waitAnimation();
        int num = (int)(Math.random()*4);
        if(num == 0) {
            ono.setTop(Cards.RED_WILD);
        } else if(num == 1) {
            ono.setTop(Cards.BLUE_WILD);
        } else if(num == 2) {
            ono.setTop(Cards.YELLOW_WILD);
        } else {
            ono.setTop(Cards.GREEN_WILD);
        }
        waitAnimation();
    }

    public void resetGame() {
        clock = new Wait();
        ono = new Game();
        tb = (int)(Math.random()*5);
        updateViews();
    }

    // Visual Methods
    public void waitAnimation() {
        clock.start();
    }

    public void updateViews() {
        pane.getChildren().clear();

        ImageView tableImage = new ImageView();
        File t = new File("src/uno/resources/Table_" + tb + ".png");
        tableImage.setImage(new Image(t.toURI().toString()));
        pane.getChildren().add(tableImage);

        if(!ono.over()) {
            pane.getChildren().add(moveableBack);
            moveableBack.setX(500);
            moveableBack.setY(250);

            pHand = ono.getP().getHand();
            cHand = ono.getC().getHand();
            for (int i = 0; i < pHand.length; i++) {
                ImageView card = new ImageView();
                t = new File("src/uno/resources/" + pHand[i].value() + ".png");
                card.setImage(new Image(t.toURI().toString()));
                card.setX(100 + (i * 50));
                card.setY(500);
                card.setFitWidth(90);
                card.setFitHeight(150);
                int finalI = i;
                EventHandler<MouseEvent> play = e -> play(pHand, finalI);
                card.setOnMouseReleased(play);
                pane.getChildren().add(card);
            }
            for (int i = 0; i < cHand.length; i++) {
                ImageView card = new ImageView();
                t = new File("src/uno/resources/Card_Back.png");
                card.setImage(new Image(t.toURI().toString()));
                card.setX(1100 - (i * 50));
                card.setY(100);
                card.setRotate(180);
                card.setFitWidth(90);
                card.setFitHeight(150);
                pane.getChildren().add(card);
            }

            top = ono.getTop();
            ImageView card = new ImageView();
            t = new File("src/uno/resources/" + top.value() + ".png");
            card.setImage(new Image(t.toURI().toString()));
            card.setX(600);
            card.setY(250);
            card.setFitWidth(90);
            card.setFitHeight(150);
            pane.getChildren().add(card);

            if (ono.getCurr() == ono.getC()) {
                waitAnimation();
                compTurn();
            }
        } else {
            if(ono.getP().getHand().length == 0) {
                ImageView message = new ImageView();
                t = new File("src/uno/resources/Win.png");
                message.setImage(new Image(t.toURI().toString()));
                pane.getChildren().add(message);
            } else {
                ImageView message = new ImageView();
                t = new File("src/uno/resources/Lose.png");
                message.setImage(new Image(t.toURI().toString()));
                pane.getChildren().add(message);
            }
            ImageView button = new ImageView();
            t = new File("src/uno/resources/Again.png");
            button.setImage(new Image(t.toURI().toString()));
            button.setX(500);
            button.setY(500);
            button.setFitWidth(300);
            button.setFitHeight(180);
            EventHandler<MouseEvent> reset = e -> resetGame();
            button.setOnMouseReleased(reset);
            pane.getChildren().add(button);
        }
    }
}

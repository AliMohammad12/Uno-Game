package UnoGameDriver.Game;

import UnoGameDriver.Game.Card.Card;
import UnoGameDriver.Game.GameComponents.DrawPile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private List<Card> playerHand;
    private int handSize;
    private int score;

    public Player(String name) {
        this.name = name;
        playerHand = new ArrayList<>();
        handSize = 0;
    }
    public void addCardToHand(Card card) {
        playerHand.add(card);
        handSize++;
    }
    public void drawCard(DrawPile drawPile) {
        Card drawnCard = drawPile.getTopCard();
        System.out.println(name + " is drawing " + drawnCard + " from the Draw Pile");
        addCardToHand(drawnCard);
    }
    public Card chooseCard (Card topCard) {
        List<Card> playableCards = this.getPlayableCards(topCard);
        if (!hasPlayableCard(playableCards)) return null;
        printPlayableCards(playableCards);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the id of the playable card: ");
        int selectedCardIndex = scanner.nextInt();
        while (!validSelection(selectedCardIndex, playableCards)) {
            System.out.print("Please enter valid Id: ");
            selectedCardIndex = scanner.nextInt();
        }

        removeCard(playableCards.get(selectedCardIndex));
        return playableCards.get(selectedCardIndex);
    }
    public void removeCard(Card card) {
        playerHand.remove(card);
        handSize--;
    }
    public boolean canPlayAbove(Card topCard) {
        return hasPlayableCard(getPlayableCards(topCard));
    }
    public boolean hasPlayableCard(List<Card> playableCards) {
        return playableCards.size() > 0;
    }
    public boolean validSelection(int selectedCardIndex, List<Card> playableCards) {
        return selectedCardIndex >= 0 && selectedCardIndex < playableCards.size();
    }
    public List<Card> getPlayableCards(Card discardPileTopCard) {
        List<Card> playableCards = new ArrayList<>();
        for (Card card : playerHand) {
            if (card.canThrowAbove(discardPileTopCard)) {
                playableCards.add(card);
            }
        }
        return playableCards;
    }
    public void printPlayableCards(List<Card> playableCard) {
        System.out.println(this.name + "'s playable cards: ");
        System.out.println(playableCard);
    }
    public void addScore(int value) {
        score += value;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHandSize() {
        return handSize;
    }

    public void setHandSize(int handSize) {
        this.handSize = handSize;
    }

    public boolean shoutUno() {
        return Math.random() > 0.5;
    }

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

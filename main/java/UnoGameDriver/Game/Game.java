package UnoGameDriver.Game;

import UnoGameDriver.Game.Card.Card;
import UnoGameDriver.Game.Card.CardColor;
import UnoGameDriver.Game.CardDeck.CardDeck;
import UnoGameDriver.Game.DealingStrategy.DealingStrategy;
import UnoGameDriver.Game.GameConfiguration.GameConfiguration;
import UnoGameDriver.Game.ShufflingStrategy.ShufflingStrategy;
import UnoGameDriver.Game.GameConfiguration.GameDirection;
import UnoGameDriver.Game.GameComponents.DiscardPile;
import UnoGameDriver.Game.GameComponents.DrawPile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Game {
    GameConfiguration gameConfiguration;
    List<Player> players;
    CardDeck cardDeck;
    DiscardPile discardPile;
    DrawPile drawPile;
    DealingStrategy dealingStrategy;
    ShufflingStrategy shufflingStrategy;
    GameDirection currentGameDirection;
    Player gameWinner;
    CardColor currentColor;
    int numberOfPlayers;
    int currentPlayerIndex;
    int currentMaxScore;

    public Game() {
        gameSetup();
    }
    public void play() {
        initializePlayers();
        while (!gameOver()) {
            initiateRound();
            processRound();
            displayRoundWinner();
            registerNewScoreForRoundWinner();
            displayNewScore();
            updateGameWinner(getCurrentPlayer());
            displayHighestScore();
            cleanUp();
        }
        displayGameWinner();
    }
    public void gameSetup() {
        setGameConfiguration();
        setDealingStrategy();
        setShufflingStrategy();
        createDeck();
        initializeRules();
    }
    public abstract void setGameConfiguration();
    public abstract void setShufflingStrategy();
    public abstract void setDealingStrategy();
    public abstract void createDeck();
    public abstract void initializeRules();
    public abstract void processRound();
    public abstract void processTurn(Player currentPlayer);
    public abstract void makePlayerDraw (Player player);
    public abstract void refillDrawPile();
    public abstract void registerNewScoreForRoundWinner();

    public void initiateRound() {
        shuffleDeck();
        dealCards();
        placeDiscardPile();
        placeDrawPile();
        setGameDirection();
        currentPlayerIndex = 0;
    }
    public Card topCard() {
        return discardPile.peekTheTopCard();
    }
    public void dealCards()  {
        dealingStrategy.dealCards(players, cardDeck);
    }
    public void shuffleDeck() {
        cardDeck.shuffleDeck(shufflingStrategy);
    }
    public void placeDiscardPile() {
        discardPile = new DiscardPile(cardDeck.drawCard());
    }
    public void placeDrawPile() {
        drawPile = new DrawPile(cardDeck.getCards());
    }
    public void setGameDirection() {
        currentGameDirection = gameConfiguration.getGameDirectionStart();
    }
    public void printCurrentStatus() {
        System.out.println("Current Top Card: " + discardPile.peekTheTopCard());
        System.out.println("Current Game Direction: " + currentGameDirection);
        System.out.println(getCurrentPlayer().getName() + " is playing");
        System.out.println("Player Cards: " + getCurrentPlayer().getPlayerHand() + "\n");
    }
    public void activateAction(Card topCard) {
        topCard.getCardAction().activateAction(this);
    }
    public void selectNextPlayerIndex() {
        if (currentGameDirection == GameDirection.CLOCKWISE) {
            currentPlayerIndex = (currentPlayerIndex + gameConfiguration.getNextTurnCount()) % numberOfPlayers;
        } else {
            currentPlayerIndex = ((currentPlayerIndex - gameConfiguration.getNextTurnCount()) %
                    numberOfPlayers + numberOfPlayers) % numberOfPlayers;
        }
    }
    public void initializePlayers() {
        askUserToSetTheNumOfPlayers();
        players = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < this.numberOfPlayers; i++) {
            System.out.println("Please enter " + (i + 1) + "'s player name: ");
            String playerName = scan.next();
            players.add(new Player(playerName));
        }
    }
    public void askUserToSetTheNumOfPlayers() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the number of players [" + gameConfiguration.getMinNumOfPlayers() +
                ", " + gameConfiguration.getMaxNumOfPlayers() + "]: ");

        numberOfPlayers = scan.nextInt();
        while (!isNumberOfPlayersValid()) {
            System.out.println("please re-enter a number between ["  + gameConfiguration.getMinNumOfPlayers() +
                    ", " + gameConfiguration.getMaxNumOfPlayers() + "]: ");
            numberOfPlayers = scan.nextInt();
        }
    }
    public boolean isNumberOfPlayersValid() {
        return numberOfPlayers >= gameConfiguration.getMinNumOfPlayers() &&
                numberOfPlayers <= gameConfiguration.getMaxNumOfPlayers();
    }
    public void updateGameWinner(Player player) {
        if (player.getScore() > currentMaxScore) {
            gameWinner = player;
            currentMaxScore = player.getScore();
        }
    }
    public boolean canPlay() {
        return getCurrentPlayer().canPlayAbove(discardPile.peekTheTopCard());
    }
    public boolean gameOver() {
        return currentMaxScore >= gameConfiguration.getWinningScore();
    }
    public boolean roundOver() {
        return players.get(currentPlayerIndex).getHandSize() == gameConfiguration.getRemainingCardsToWin();
    }
    public void displayRoundWinner() {
        System.out.println(getCurrentPlayer().getName() + " has won the round!");
    }
    public void displayHighestScore() {
        System.out.println("Highest score for now is " + gameWinner.getScore() + " is scored for " + gameWinner.getName() + "\n");
    }
    public void displayGameWinner() {
        System.out.println("Game Winner is " + gameWinner.getName() + " with score = " + gameWinner.getScore());
    }
    public void displayNewScore() {
        System.out.println(getCurrentPlayer().getName() + " new score is " + getCurrentPlayer().getScore() + "!!");
    }
    public void cleanUp() {
        for (int i = 0; i < numberOfPlayers; i++) {
            players.get(i).getPlayerHand().clear();
        }
        discardPile.getCards().clear();
        drawPile.getCards().clear();
    }
    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }
    public DrawPile getDrawPile() {
        return drawPile;
    }
    public GameConfiguration getGameConfiguration() {
        return gameConfiguration;
    }
    public void setGameConfiguration(GameConfiguration gameConfiguration) {
        this.gameConfiguration = gameConfiguration;
    }
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public CardDeck getCardDeck() {
        return cardDeck;
    }

    public void setCardDeck(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
    }

    public DiscardPile getDiscardPile() {
        return discardPile;
    }

    public void setDiscardPile(DiscardPile discardPile) {
        this.discardPile = discardPile;
    }

    public void setDrawPile(DrawPile drawPile) {
        this.drawPile = drawPile;
    }

    public DealingStrategy getDealingStrategy() {
        return dealingStrategy;
    }

    public ShufflingStrategy getShufflingStrategy() {
        return shufflingStrategy;
    }

    public GameDirection getCurrentGameDirection() {
        return currentGameDirection;
    }

    public void setCurrentGameDirection(GameDirection currentGameDirection) {
        this.currentGameDirection = currentGameDirection;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public CardColor getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(CardColor currentColor) {
        this.currentColor = currentColor;
    }
}

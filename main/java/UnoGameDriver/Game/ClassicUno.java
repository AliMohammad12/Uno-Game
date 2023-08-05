package UnoGameDriver.Game;

import UnoGameDriver.Game.Card.Card;
import UnoGameDriver.Game.CardDeck.DeckFactory;
import UnoGameDriver.Game.CardDeck.StandardDeckFactory;
import UnoGameDriver.Game.DealingStrategy.StandardDealing;
import UnoGameDriver.Game.GameConfiguration.GameConfigurator;
import UnoGameDriver.Game.GameConfiguration.GameDirection;
import UnoGameDriver.Game.GameRules.GameRule;
import UnoGameDriver.Game.GameRules.SayUnoRule;
import UnoGameDriver.Game.ShufflingStrategy.RandomShuffling;

import java.util.EmptyStackException;
import java.util.List;

public class ClassicUno extends Game {
    private GameRule sayUnoRule;
    @Override
    public void processRound() {
        activateAction(topCard());
        while (!roundOver()) {
            printCurrentStatus();
            Player currentPlayer = getCurrentPlayer();
            int playCount = gameConfiguration.getPlayCountPerTurn();
            while (playCount > 0) {
                if (canPlay()) {
                    processTurn(currentPlayer);
                } else {
                    makePlayerDraw(currentPlayer);
                    if (canPlay()) processTurn(currentPlayer);
                }
                sayUnoRule.applyRule(this);
                playCount--;
            }
            if (!roundOver()) selectNextPlayerIndex();
        }
    }
    @Override
    public void setGameConfiguration() {
        GameConfigurator gameConfigurator = new GameConfigurator();
        gameConfiguration = gameConfigurator
                .setGameDirectionStart(GameDirection.CLOCKWISE)
                .setMaxNumOfPlayers(7)
                .setMinNumOfPlayers(2)
                .setWinningScore(100)
                .setRemainingCardsToWin(0)
                .setNextTurnCount(1)
                .setDrawCount(1)
                .setPlayCountPerTurn(1)
                .build();
    }

    @Override
    public void setShufflingStrategy() {
        shufflingStrategy = new RandomShuffling();
    }

    @Override
    public void setDealingStrategy() {
        dealingStrategy = new StandardDealing();
    }

    @Override
    public void createDeck() {
        DeckFactory deckFactory = new StandardDeckFactory();
        cardDeck = deckFactory.createDeck();
    }

    @Override
    public void initializeRules() {
        sayUnoRule = new SayUnoRule();
    }

    @Override
    public void processTurn(Player currentPlayer) {
        Card topCard = topCard();
        Card selectedCard = currentPlayer.chooseCard(topCard);
        activateAction(selectedCard);
        discardPile.addCard(selectedCard);
        currentColor = discardPile.peekTheTopCard().getCardColor();
    }

    @Override
    public void makePlayerDraw(Player player) {
        int drawCount = gameConfiguration.getDrawCount();
        while (drawCount > 0) {
            try {
                player.drawCard(drawPile);
            } catch (EmptyStackException e) {
                refillDrawPile();
                player.drawCard(drawPile);
            }
            drawCount--;
        }
    }

    @Override
    public void refillDrawPile() {
        List<Card> discardPilesCards = discardPile.getCards();
        Card topCard = topCard();
        drawPile.addAll(discardPilesCards);
        drawPile.getTopCard();
        discardPilesCards.clear();
        discardPilesCards.add(topCard);
        System.out.println("DrawPile is now refilled");
    }

    @Override
    public void registerNewScoreForRoundWinner() {
        Player roundWinner = getCurrentPlayer();
        int score = 0;
        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = players.get(i);
            List<Card> playerCards = player.getPlayerHand();
            for (Card card : playerCards) {
                score += card.getCardScore();
            }
            playerCards.clear();
            player.setHandSize(0);
        }
        roundWinner.addScore(score);
    }


}

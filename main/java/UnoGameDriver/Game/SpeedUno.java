package UnoGameDriver.Game;

import UnoGameDriver.Game.Card.Card;
import UnoGameDriver.Game.CardDeck.DeckFactory;
import UnoGameDriver.Game.CardDeck.LuckyDeckFactory;
import UnoGameDriver.Game.DealingStrategy.FewCardsDealing;
import UnoGameDriver.Game.GameConfiguration.GameConfigurator;
import UnoGameDriver.Game.GameConfiguration.GameDirection;
import UnoGameDriver.Game.GameRules.GameRule;
import UnoGameDriver.Game.GameRules.HaveRedCard;
import UnoGameDriver.Game.GameRules.SayUnoRule;
import UnoGameDriver.Game.ShufflingStrategy.FaroShuffling;
import UnoGameDriver.Game.ShufflingStrategy.RandomShuffling;

import java.util.EmptyStackException;
import java.util.List;

public class SpeedUno extends Game {
    private GameRule sayUnoRule, redCardRule;
    @Override
    public void setGameConfiguration() {
        GameConfigurator gameConfigurator = new GameConfigurator();
        gameConfiguration = gameConfigurator
                .setMinNumOfPlayers(2)
                .setMaxNumOfPlayers(4)
                .setWinningScore(50)
                .setRemainingCardsToWin(0)
                .setDrawCount(1)
                .setGameDirectionStart(GameDirection.CLOCKWISE)
                .setNextTurnCount(1)
                .setPlayCountPerTurn(2)
                .build();
    }

    @Override
    public void setShufflingStrategy() {
        shufflingStrategy = new RandomShuffling();
    }

    @Override
    public void setDealingStrategy() {
        dealingStrategy = new FewCardsDealing();
    }

    @Override
    public void createDeck() {
        DeckFactory deckFactory = new LuckyDeckFactory();
        cardDeck = deckFactory.createDeck();
    }

    @Override
    public void initializeRules() {
        sayUnoRule = new SayUnoRule();
        redCardRule = new HaveRedCard();
    }

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
                redCardRule.applyRule(this);
                playCount--;
                if (!roundOver()) break;
            }
            if (!roundOver()) selectNextPlayerIndex();
        }
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

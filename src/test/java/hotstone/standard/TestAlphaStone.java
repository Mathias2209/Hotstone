/*
 * Copyright (C) 2022 - 2026. Henrik Bærbak Christensen, Aarhus University.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package hotstone.standard;

/**
 * Skeleton class for AlphaStone test cases
 *
 *    This source code is from the book
 *      "Flexible, Reliable Software:
 *        Using Patterns and Agile Development"
 *      2nd Edition
 *    Author:
 *      Henrik Bærbak Christensen
 *      Department of Computer Science
 *      Aarhus University
 */

import hotstone.framework.Card;
import hotstone.framework.Player;
import hotstone.utility.TestHelper;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import hotstone.framework.Game;

/** Template for your own ongoing TDD process.
 * Fill it out until you have covered all
 * requirements for the alpha stone game.
 */
public class TestAlphaStone {
  private Game game;

  /** Fixture for AlphaStone testing. */
  @BeforeEach
  public void setUp() {
    game = new StandardHotStoneGame();
  }

  // Example of an early, simple test case:
  // Turn handling
  @Test
  public void shouldHaveFindusAsFirstPlayer() {
    // Given a game
    // When I ask for the player in turn
    Player player = game.getPlayerInTurn();
    // Then it should be Findus
    assertThat(player, is(Player.FINDUS));
  }

  // Example of a later, more complex, test case:
  // Card handling

  // The HotStone specs are quite insisting on how
  // the cards, drawn from the deck, are organized
  // in the hand. So when drawing the top three cards
  // from the deck (uno, dos, tres) they have to
  // be organized in the hand as
  // index 0 = tres; index 1 = dos; index 2 = uno
  // That is, a newly drawn card is 'at the top'
  // of the hand - always entered at position 0
  // and pushing the rest of the cards 1 position
  // 'down'

  @Test
  public void whenFindusEndsItIsPeddersenTurn() {
    // Given findus ended turn
    game.endTurn();

    // When I ask for the player in turn
    Player player = game.getPlayerInTurn();
    // Then it should be Peddersen
    assertThat(player, is(Player.PEDDERSEN));
  }

  @Test
  public void whenPeddersenEndsItIsFindusTurn() {
    // Given findus ended turn and then Peddersen ended turn
    game.endTurn();
    game.endTurn();

    // When I ask for the player in turn
    Player player = game.getPlayerInTurn();
    // Then it should be Findus
    assertThat(player, is(Player.FINDUS));
  }

  @Test
  public void whenGameStartsFindusShouldHaveThreeCards() {
    // Given a new game, Findus' hand size should be3
    int handsize = game.getHandSize(Player.FINDUS);
    assertThat(handsize, is(3));
  }

  @Test
  public void findusShouldHaveUnoDosTresCardsInitially() {
    // And these are ordered Tres, Dos, Uno in slot 0,1,2

    // When I pick cards
    Card card = game.getCardInHand(Player.FINDUS, 0);
    Card card2 = game.getCardInHand(Player.FINDUS, 1);
    Card card3 = game.getCardInHand(Player.FINDUS, 2);
    // Then is it Tres
    assertThat(card.getName(), is(GameConstants.TRES_CARD));
    assertThat(card2.getName(), is(GameConstants.DOS_CARD));
    assertThat(card3.getName(), is(GameConstants.UNO_CARD));
  }

  @Test
  public void whenGameStartsPeddersenShouldHaveThreeCards() {
    // Given a new game, Peddersen's hand size should be 3
    int handsize = game.getHandSize(Player.PEDDERSEN);
    assertThat(handsize, is(3));
  }

  @Test
  public void peddersenshouldHaveUnoDosTresCardsInitially() {
    // And these are ordered Tres, Dos, Uno in slot 0,1,2

    // When I pick cards
    Card card = game.getCardInHand(Player.PEDDERSEN, 0);
    Card card2 = game.getCardInHand(Player.PEDDERSEN, 1);
    Card card3 = game.getCardInHand(Player.PEDDERSEN, 2);

    // Then is it Tres
    assertThat(card.getName(), is(GameConstants.TRES_CARD));
    assertThat(card2.getName(), is(GameConstants.DOS_CARD));
    assertThat(card3.getName(), is(GameConstants.UNO_CARD));
  }

  @Test
  public void dosShouldHaveAttr222() {
    // Given card Dos
    Card card = game.getCardInHand(Player.FINDUS, 1);
    // Then the attr should be (2, 2, 2)
    assertThat(card.getHealth(), is(2));
    assertThat(card.getAttack(), is(2));
    assertThat(card.getManaCost(), is(2));
    assertThat(card.getName(), is("Dos"));
  }

  @Test
  public void unoShouldHaveAttr111() {
    // Given card Uno
    Card card = game.getCardInHand(Player.FINDUS, 2);
    // Then the attr should be (1, 1, 1)
    assertThat(card.getHealth(), is(1));
    assertThat(card.getAttack(), is(1));
    assertThat(card.getManaCost(), is(1));
    assertThat(card.getName(), is("Uno"));
  }

  @Test
  public void tresShouldHaveAttr333() {
    // Given card Tres
    Card card = game.getCardInHand(Player.FINDUS, 0);
    // Then the attr should be (3, 3, 3)
    assertThat(card.getHealth(), is(3));
    assertThat(card.getAttack(), is(3));
    assertThat(card.getManaCost(), is(3));
    assertThat(card.getName(), is("Tres"));
  }
  @Test
  public void cuatroShouldHaveAttr231() {
    // Given card cuatro
    Card card = game.getCardInDeck(Player.FINDUS, 0);
    // Then the attr should be (4, 4, 4)
    assertThat(card.getManaCost(), is(2));
    assertThat(card.getAttack(), is(3));
    assertThat(card.getHealth(), is(1));
    assertThat(card.getName(), is("Cuatro"));
  }
  @Test
  public void cincoShouldHaveAttr351() {
    // Given card cinco
    Card card = game.getCardInDeck(Player.FINDUS, 1);
    // Then the attr should be (3, 5, 1)
    assertThat(card.getManaCost(), is(3));
    assertThat(card.getAttack(), is(5));
    assertThat(card.getHealth(), is(1));
    assertThat(card.getName(), is("Cinco"));
  }
  @Test
  public void seisShouldHaveAttr213() {
    // Given card seis
    Card card = game.getCardInDeck(Player.FINDUS, 2);
    // Then the attr should be (2, 1, 3)
    assertThat(card.getManaCost(), is(2));
    assertThat(card.getAttack(), is(1));
    assertThat(card.getHealth(), is(3));
    assertThat(card.getName(), is("Seis"));
  }
  @Test
  public void sieteShouldHaveAttr324() {
    // Given card siete
    Card card = game.getCardInDeck(Player.FINDUS, 3);
    // Then the attr should be (3, 2, 4)
    assertThat(card.getManaCost(), is(3));
    assertThat(card.getAttack(), is(2));
    assertThat(card.getHealth(), is(4));
    assertThat(card.getName(), is("Siete"));
  }
  @Test
  public void findusShouldHaveFourCardsInDeckAtStart() {
    // Given game starts
    int decksize = game.getDeckSize(Player.FINDUS);
    // then Findus should have 4 cards in deck
    assertThat(decksize, is(4));
  }

  @Test
  public void findusShouldHaveCuatroCincoSeisSieteInDeckAtStart(){
    //Given game starts
      Card deckcardcuatro = game.getCardInDeck(Player.FINDUS, 0);
      Card deckcardcinco = game.getCardInDeck(Player.FINDUS, 1);
      Card deckcardseis = game.getCardInDeck(Player.FINDUS, 2);
      Card deckcardsiete = game.getCardInDeck(Player.FINDUS, 3);

      //then Findus' deck contains cuatro, cinco, seis, seite
      assertThat(deckcardcuatro.getName(), is("Cuatro"));
      assertThat(deckcardcinco.getName(), is("Cinco"));
      assertThat(deckcardseis.getName(), is("Seis"));
      assertThat(deckcardsiete.getName(), is("Siete"));
  }
  @Test
  public void peddersenShouldHaveFourCardsInDeckAtStart() {
    // Given game starts
    int decksize = game.getDeckSize(Player.PEDDERSEN);
    // then Peddersen should have 4 cards in deck
    assertThat(decksize, is(4));
  }

  @Test
  public void peddersenShouldHaveCuatroCincoSeisSieteInDeckAtStart() {
    //Given game starts
    Card deckcardcuatro = game.getCardInDeck(Player.PEDDERSEN, 0);
    Card deckcardcinco = game.getCardInDeck(Player.PEDDERSEN, 1);
    Card deckcardseis = game.getCardInDeck(Player.PEDDERSEN, 2);
    Card deckcardsiete = game.getCardInDeck(Player.PEDDERSEN, 3);

    //then Peddersen's deck contains cuatro, cinco, seis, seite
    assertThat(deckcardcuatro.getName(), is("Cuatro"));
    assertThat(deckcardcinco.getName(), is("Cinco"));
    assertThat(deckcardseis.getName(), is("Seis"));
    assertThat(deckcardsiete.getName(), is("Siete"));
  }
  @Test
  public void findusWinsAtRoundEight(){
    //When turn is 8
    for (int i=0; i < 8; i++) {
      game.endTurn();
    }
    //Then the winner is Findus
    assertThat(game.getWinner(), is(Player.FINDUS));

    }
}

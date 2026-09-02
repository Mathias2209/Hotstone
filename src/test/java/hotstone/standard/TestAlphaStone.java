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
  public void whenFindusEndsItIsPeddersTurn() {
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
    // Given a new game, Findus' deck size should be3
    int decksize = game.getHandSize(Player.FINDUS);
    assertThat(decksize, is(3));
  }

  @Test
  public void shouldHaveUnoDosTresCardsInitially() {
    // And these are ordered Tres, Dos, Uno in slot 0,1,2

    // When I pick card 0
    Card card = game.getCardInHand(Player.FINDUS, 0);
    // Then is it Tres
    assertThat(card.getName(), is(GameConstants.TRES_CARD));
  }

  @Test
  public void dosShouldHaveAttr222() {
    // Given card Dos
    Card card = game.getCardInHand(Player.FINDUS, 1);
    // Then the attr should be (2, 2, 2)
    assertThat(card.getHealth(), is(2));
    assertThat(card.getAttack(), is(2));
    assertThat(card.getManaCost(), is(2));
  }



}

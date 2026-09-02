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

import hotstone.framework.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** This is the 'temporary test stub' in TDD
 * terms: the initial empty but compilable implementation
 * of the game interface.
 *
 * It already includes a bit of FAKE-IT code for the first
 * test case about hand management and player in turn.
 *
 * Start solving the AlphaStone exercise by
 * following the TDD rhythm: pick a one-step-test
 * from your test list, quickly add a test,
 * run it to see it fail, and then modify this
 * implementing class (and supporting classes)
 * to make your test case run. Refactor and repeat.
 *
 * While this is the implementation of Game for
 * the AlphaStone game, you will constantly
 * refactor it over the course of the exercises
 * to become the 'core implementation' which will
 * enable a lot of game variants. This is also
 * why it is not called 'AlphaGame'.
 */

public class StandardHotStoneGame implements Game {
  private Player playerInTurn = Player.FINDUS;
  Card UNO_Card = new StandardCard(GameConstants.UNO_CARD, 1, 1, 1);
  Card DOS_Card = new StandardCard(GameConstants.DOS_CARD, 2, 2, 2);
  Card TRES_Card = new StandardCard(GameConstants.TRES_CARD, 3, 3, 3);
  Card CUATRO_Card = new StandardCard(GameConstants.CUATRO_CARD, 2, 3, 1);
  Card CINCO_Card = new StandardCard(GameConstants.CINCO_CARD, 3, 5, 1);
  Card SEIS_Card = new StandardCard(GameConstants.SEIS_CARD, 2, 1, 3);
  Card SIETE_Card = new StandardCard(GameConstants.SIETE_CARD, 3, 2, 4);

  private List<Card> handFindus = new ArrayList<>(List.of(TRES_Card, DOS_Card, UNO_Card));
  private List<Card> deckFindus = new ArrayList<>(List.of(CUATRO_Card, CINCO_Card, SEIS_Card, SIETE_Card));

  private List<Card> handPeddersen = new ArrayList<>(List.of(TRES_Card, DOS_Card, UNO_Card));
  private List<Card> deckPeddersen = new ArrayList<>(List.of(CUATRO_Card, CINCO_Card, SEIS_Card, SIETE_Card));


  private int turnnumber = 0;


  @Override
  public Player getPlayerInTurn() {
    return playerInTurn;
  }

  @Override
  public Hero getHero(Player who) {
    return null;
  }

  @Override
  public Player getWinner() {
    if (turnnumber == 8) {

      return  Player.FINDUS;
    }

    else {

      return  null;
    }
  }

  @Override
  public int getTurnNumber() {
    return turnnumber;
  }

  @Override
  public int getDeckSize(Player who) {
    return 4;
  }

  @Override
  public Card getCardInHand(Player who, int indexInHand) {

     if (who == Player.FINDUS) {

       return handFindus.get(indexInHand);
     }

     else {

       return handPeddersen.get(indexInHand);

     }
  }
  @Override
  public Card getCardInDeck(Player who, int indexInDeck) {

    if (who == Player.FINDUS) {

      return deckFindus.get(indexInDeck);
    }

    else {

      return deckPeddersen.get(indexInDeck);

    }
  }

  @Override
  public Iterable<? extends Card> getHand(Player who) {
    return null;
  }

  @Override
  public int getHandSize(Player who) {
    return 3;
  } // FAKE-IT

  @Override
  public Card getCardInField(Player who, int indexInField) {
    return null;
  }

  @Override
  public Iterable<? extends Card> getField(Player who) {
    return null;
  }

  @Override
  public int getFieldSize(Player who) {
    return 0;
  }

  @Override
  public void endTurn() {
        if (playerInTurn == Player.FINDUS) {
            playerInTurn = Player.PEDDERSEN;
        } else {
            playerInTurn = Player.FINDUS;
        }
    // Turn number increases by 1
    turnnumber += 1;
  }

  @Override
  public Status playCard(Player who, Card card, int atIndex) {
    return null;
  }

  @Override
  public Status attackCard(Player playerAttacking, Card attackingCard, Card defendingCard) {
    return null;
  }

  @Override
  public Status attackHero(Player playerAttacking, Card attackingCard) {
    return null;
  }

  @Override
  public Status usePower(Player who) {
    return null;
  }
}

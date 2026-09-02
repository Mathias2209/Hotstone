## Game Logic — Acceptance Criteria

---

### Turn
- [X] **Given** an initialized game, **Then** Findus is player in turn
- [X] **When** Findus ends its turn, **Then** it is Peddersen in turn
- [X] **When** Peddersen ends its turn **Then** it is Findus in turn

---
### Hand
- [X] **When** game starts, **Then** Findus should have three cards in hand.
- [X] **When** game starts, **Then** Findus should have: Tres at index 0, Dos at index 1, and Uno at index 2
- [X] **When** game starts, **Then** Pedersen should have three cards in hand.
- [X] **When** game starts, **Then** Pedersen should have: Tres at index 0, Dos at index 1, and Uno at index 2

### Cards
- [X] **Given** Card Dos, **Then** it has attributes (2,2,2)
- [X] **Given** Card Uno, **Then** it has attributes (1,1,1)
- [X] **Given** Card Tres, **Then** it has attributes (3,3,3)
- [X] **Given** Card Cuatro, **Then** it has attributes (2,3,1)
- [X] **Given** Card Cinco, **Then** it has attributes (3,5,1)
- [X] **Given** Card Seis, **Then** it has attributes (2,1,3)
- [X] **Given** Card Cuatro, **Then** it has attributes (3,2,4)

### Deck
- [X] **When** game starts, **Then** Findus should have four cards in deck.
- [X] **When** game starts, **Then** Findus' deck should have: Cuatro, Cinco, seis, siete
- [X] **When** game starts, **Then** Pedersen should have four cards in deck.
- [X] **When** game starts, **Then** Pedersen's deck should have: Cuatro, Cinco, seis, siete

### End of Game
- [X] **When** game reaches round 8, **Then** Findus wins



### Playing cards
- [ ] **When** Peddersen plays Dos, **Then** the mana available is two less
- [ ] **When** Findus plays a card, **Then** Peddersen still has 3 cards in his hand
- [ ] **Given** a game, **When** Findus plays Uno at index 0, **Then** it is allowed (Status.OK), and **Then** minion Uno appears at index 0 on the player's own field

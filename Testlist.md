## Game Logic — Acceptance Criteria

---

### Turn
- [X] **Given** an initialized game, **Then** Findus is player in turn
- [X] **When** Findus ends its turn, **Then** it is Peddersen in turn
- [X] **When** Peddersen ends its turn **Then** it is Findus in turn
- [ ] **When** Turn 9 starts **Then** Findus wins
- [ ] **When** Turn starts **Then** Findus mana is 3

---
### Hand
- [X] **When** game starts, **Then** Findus should have three cards in hand.
- [ ] **When** an intialized game, **Then** Findus has 4 cards in deck
- [X] **When** game starts, **Then** Findus should have: Tres at index 0, Dos at index 1, and Uno at index 2
- [ ] **When** Turn 3 starts, **Then** Findus has three card in hand, **Then** Findus has 3 cards in deck

### Card
- [X] **Given** Card Dos, **Then** it has attributes (2,2,2)

### Playing cards
- [ ] **When** Peddersen plays Dos, **Then** the mana available is two less
- [ ] **When** Findus plays a card, **Then** Peddersen still has 3 cards in his hand
- [ ] **Given** a game, **When** Findus plays Uno at index 0, **Then** it is allowed (Status.OK), and **Then** minion Uno appears at index 0 on the player's own field
- [ ] **When** Card Dos is played, **Then** remove Card Dos from Findus hand and place at index 0 on Findus field

### Hero
- [ ] **When** game starts Hero has 21 health
- [ ] **Given** Baby, **Then** it has hero power "Cute" which cost 2 mana **Then** it has description "Just Cute"
- [ ] **When** Start of turn and Findus Deck is empty, **Then** Hero health is 19

### Attacking
- [ ] **When** Findus Card Dos attacks Card Tres, **Then** Card Tres health is 1

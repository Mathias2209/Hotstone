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

### Card
- [X] **Given** Card Dos, **Then** it has attributes (2,2,2)

### Playing cards
- [ ] **When** Peddersen plays Dos, **Then** the mana available is two less
- [ ] **When** Findus plays a card, **Then** Peddersen still has 3 cards in his hand
- [ ] **Given** a game, **When** Findus plays Uno at index 0, **Then** it is allowed (Status.OK), and **Then** minion Uno appears at index 0 on the player's own field

# Java Console BlackJack Game

A simple console-based implementation of BlackJack where multiple players compete against a dealer. The game automatically deals cards and determines winners based on standard BlackJack rules with some custom winning conditions.

## Game Overview

This BlackJack implementation features:
- Multiple players (3 players + dealer)
- Automated card dealing
- Custom winning conditions including 5-card rule
- No duplicate cards in play
- Random card distribution between 2-5 cards per player

## Project Structure

```
src/
├── Main.java        # Game logic and driver class
├── Player.java      # Player management and scoring
└── Card.java        # Card representation and deck management
```

## Game Rules

1. **Basic Rules:**
   - Each player (including dealer) receives between 2-5 cards randomly
   - Cards are unique - no duplicates allowed in play
   - Goal is to get closest to 21 without going over

2. **Winning Conditions:**
   - Player automatically wins if they have 5 cards without exceeding 21
   - Player wins if they have more or equal cards than dealer while staying under 21
   - Player wins if they have 21 and dealer doesn't
   - Player closer to 21 than dealer wins
   - In case both are over 21, the lower score wins
   - Ties are possible and explicitly declared

## Game Flow

1. Program starts and creates a deck of cards
2. Deals random number of cards (2-5) to:
   - Dealer
   - Billy
   - Lemmy
   - Andrew
   - Carla
3. Displays each player's:
   - Name
   - Cards in hand
   - Total score
4. Compares each player against the dealer to determine winners

## Sample Output

```
Welcome to BlackJack 21  

Dealer
King of Hearts
Two of Clubs
Total: 12

Billy
Jack of Diamonds
Queen of Hearts
Three of Spades
Total: 23

Lemmy
Nine of Hearts
Eight of Clubs
Total: 17

Andrew
Ace of Spades
King of Diamonds
Total: 21

Carla
Five of Hearts
Six of Diamonds
Seven of Clubs
Total: 18

The Dealer(12) has won against Billy(23)
Lemmy(17) has won against the dealer(12)
Andrew(21) has won against the dealer(12)
Carla(18) has won against the dealer(12)
```

## Technical Implementation Details

### Card Dealing System
- Uses HashSet to ensure no duplicate cards are dealt
- Random number generator for card count and selection
- Cards are dealt from a complete deck of 52 cards

### Scoring System
- Automatically calculates optimal Ace values (1 or 11)
- Tracks number of cards in hand for 5-card rule
- Implements complex winning logic with multiple conditions

### Player Management
- Each player maintains their own hand of cards
- Supports automatic score calculation
- Stores player name and card information

## Requirements

- Java Development Kit (JDK) 8 or higher
- Console/Terminal to run the application

## Running the Game

1. Compile the source files:
```bash
javac Main.java Player.java Card.java
```

2. Run the program:
```bash
java Main
```

## Future Improvements

1. Add interactive player decisions (hit/stand)
2. Implement betting system
3. Add multiple rounds support
4. Include card splitting functionality
5. Add graphical user interface
6. Implement save/load game state

## Author
Tebogo 
Email: tphiri.firi@gmail.com 
GitHub: https://github.com/TebogoP/ 
LinkedIn: https://www.linkedin.com/in/tebogo-phiri-b5a96796/

## License
This project is licensed under the MIT License - see the LICENSE file for details.

# Chomp Game Implementation

A Java-based implementation of the classic Chomp board game featuring multiple AI opponents and an interactive graphical interface. This project demonstrates object-oriented programming principles and various AI strategy implementations.

## Game Overview

Chomp is a two-player strategy game played on a rectangular grid of chips (by default 10x10). Players take turns choosing chips, and when a chip is selected, all chips above and to the right of the selected chip are removed. The player forced to take the bottom-left chip (colored blue) loses the game.

![Game Start](https://user-images.githubusercontent.com/77413460/216822137-1724f375-d74e-437b-a5b9-43c7433608b3.png)
![Game Progress](https://user-images.githubusercontent.com/77413460/216822140-d62231ff-7492-4366-92bc-edf18d38f869.png)

## Technical Implementation

### Architecture
- Built using Java Applet technology
- Implements Model-View-Controller (MVC) pattern
- Event-driven gameplay using ActionListener for user interactions

### Key Components
- `Chomp.java`: Main game logic and UI implementation
- `Player.java`: Base class for all player implementations
- Multiple AI implementations:
  - `SmartPlayer.java`: Advanced AI using strategic algorithms
  - `RandomPlayer.java`: Random move generation
  - `NotSmartPlayer.java`: Basic AI implementation
  - `MyPlayer.java`: Custom player implementation

### Technical Challenges & Solutions

1. **Game State Management**
   - Implemented using a Chip array system
   - Efficient board state tracking using boolean flags
   - Real-time move validation system

2. **AI Implementation**
   - Multiple difficulty levels through different AI classes
   - Smart player implementation using strategic position analysis
   - Random player for unpredictable gameplay

3. **User Interface**
   - Interactive click-based gameplay
   - Real-time board updates
   - Visual feedback for legal/illegal moves

## How to Play

1. Run the Java applet
2. Click "NewGame" to start a fresh game
3. Choose your opponent type using the available buttons
4. Click on any chip to make your move
5. Game ends when a player is forced to take the blue chip (bottom-left)

## Development Setup

### Prerequisites
- Java Development Kit (JDK)
- Java-compatible IDE (Eclipse, IntelliJ, etc.)

### Running the Game
1. Clone the repository
2. Compile the Java files
3. Run `Chomp.java` as a Java applet



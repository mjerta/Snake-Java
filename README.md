# Snake-Java

Snake-Java is a classic snake game implemented in Java using the Swing framework for the graphical user interface. The game features a simple yet engaging gameplay where the player controls a snake to eat food, grow in size, and avoid collisions.
It features an infinite number of levels, with each level being significantly larger than the previous one.

## Features

- **Gameplay**: Control the snake using keyboard inputs. The snake grows when it eats food, and the game ends if it collides with itself or the grid boundaries.
- **Scoring System**: Earn points for each food item consumed. The score is displayed on the screen.
- **Food Logic**: Food appears randomly on the grid and respawns after being eaten.
- **Grid Behavior**: The grid serves as a visual background, with the snake and food aligning perfectly with grid cells.

## Technical Details

- **UI Framework**: Java Swing is used for GUI components (`JPanel`, `JFrame`).
- **Game Logic**: A game loop with a `Timer` updates the game state at regular intervals. Collision detection is implemented for the snake and food.
- **Design Patterns**:
  - Singleton: `GameManager` is a single instance managing the game state.
  - Factory: Produces game objects like `Snake`, `Food`, and `Scoreboard`.
  - State Pattern: Manages different game states (e.g., `Playing`, `Paused`, `GameOver`).
- **Performance**: Ensures smooth rendering using `paintComponent` and optimized drawing logic. Handles real-time keyboard input without lag.
- **Extensibility**: Designed to easily add new features like obstacles, levels, or power-ups.

## Requirements

- Java Development Kit (JDK) 21 or higher
- Maven for project management and build

## Getting Started

1. **Clone the repository**:

   ```bash
   git clone https://github.com/mjerta/Snake-Java

   ```

2. **Build the project**:

   ```bash
   mvn clean package
   ```

3. **Run the game**:
   ```bash
   java -jar $(find target/*.jar)


   ```

## Future Improvements

- **Unit Testing**: Implement unit tests to ensure the reliability and correctness of the game logic. This will involve testing individual components such as the snake movement, collision detection, and scoring system to catch bugs early and maintain code quality.

- **Multiplayer Mode**: Introduce a multiplayer mode allowing two players to play on the same keyboard. This will involve adding controls for a second snake and implementing logic to handle interactions between the two snakes, such as collisions and competitive scoring.

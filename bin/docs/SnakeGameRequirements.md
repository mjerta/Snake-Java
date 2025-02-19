## 2. Functional Requirements

### Gameplay Features:
- The player can control the snake’s direction using keyboard inputs.
- The snake grows in size when it eats food.
- The game ends when the snake collides with itself or the grid boundaries.

### Scoring System:
- The player earns points for each food eaten.
- The score is displayed on the screen.

### Food Logic:
- Food appears randomly on the grid.
- New food respawns after being eaten.

### Grid Behavior:
- The grid is a visual background drawn on the screen.
- The snake and food align perfectly with grid cells.

---

## 3. Technical Requirements

### UI Framework:
- Use Java Swing for GUI components (`JPanel`, `JFrame`).

### Game Logic:
- Use a game loop with a `Timer` to update the game state at regular intervals.
- Implement collision detection for snake and food.

### Design Patterns:
- **Singleton**: Ensure `GameManager` is a single instance managing the game state.
- **Factory**: Create a factory for producing game objects like `Snake`, `Food`, and `Scoreboard`.
- **State Pattern**: Manage different game states (e.g., `Playing`, `Paused`, `GameOver`).

### Performance:
- Ensure smooth rendering using `paintComponent` and optimized drawing logic.
- Handle real-time keyboard input without lag.

### Extensibility:
- Make it easy to add new features like obstacles, levels, or power-ups in the future.
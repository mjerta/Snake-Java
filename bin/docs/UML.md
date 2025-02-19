```mermaid
classDiagram
class GameManager {
- Snake snake
- Grid grid
- Food food
- Scoreboard scoreboard
- Timer timer
+ startGame()
+ updateGame()
    + checkCollisions()
      }

      class Grid {
      + paintComponent(Graphics g)
      }

      class Snake {
      - LinkedList~Segment~ body
      + move()
      + grow()
      + draw(Graphics g, int gridSize)
      }

      class Segment {
      - int x
      - int y
      + getX()
      + getY()
      }

      class Food {
      - int x
      - int y
      + respawn()
      + draw(Graphics g, int gridSize)
      }

      class Scoreboard {
      - int score
      + increaseScore()
      + draw(Graphics g)
      }

      GameManager --> Grid : uses
      GameManager --> Snake : manages
      GameManager --> Food : manages
      GameManager --> Scoreboard : updates
      Snake --> Segment : consists of
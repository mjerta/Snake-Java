package nl.mpdev.enums;

public enum Instruction {

  W("w", "Move up"),
  S("s", "Move down"),
  A("a", "Move left"),
  D("d", "Move right"),
  ARROW_UP("Arrow up", "Move up"),
  ARROW_DOWN("Arrow down", "Move down"),
  ARROW_LEFT("Arrow left", "Move left"),
  ARROW_RIGHT("Arrow right", "Move right"),
  SPACE("Space", "Speed boost"),
  G("g", "Grow snake"),
  I("i", "Toggle instruction menu"),
  ENTER("Enter", "Enter to restart/continue the game"),
  PAUSE("p", "Pause the game"),
  ESC("Esc", "Exit game");

  private final String key;
  private final String description;

  Instruction(String key, String description) {
    this.key = key;
    this.description = description;
  }

  public String getKey() {
    return key;
  }

  public String getDescription() {
    return description;
  }
}

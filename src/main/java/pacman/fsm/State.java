package pacman.fsm;

import pacman.game.Constants;
import pacman.game.Game;

public abstract class State {

    // Constructor
    public State() {}

    // Perform the action of this state
    public abstract Constants.MOVE Act(Game game);

    // Check for transition from this state
    public abstract States Transition(Game game);

}

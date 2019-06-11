package pacman.fsm;

import pacman.game.Constants;
import pacman.game.Game;
import pacman.helper.Helper;

public class Wander extends State {

    public Wander() {
    }

    @Override
    public Constants.MOVE Act(Game game) {
        // There is nothing observable around (ghost, pill), move in random
        return Helper.getInstance().randomMove();
    }

    @Override
    public States Transition(Game game) {
        // Check if a power pill was eaten
        if (game.wasPowerPillEaten()) {
            return States.CHASE_GHOST;
        }

        // Check for ghosts then pills according to safety
        // Check for ghost first
        if (Helper.getInstance().pacmanInDanger(game)) {
            // Ghost is visible
            // Change active state to avoid ghost
            return States.AVOID_GHOST;
        }
        // Check for pill secondly
        else if (game.getActivePillsIndices().length > 0){
            // Pac man sees pills
            // Change active state to get the pills
            return States.EAT_PILL;
        }

        // Do not change state
        return States.WANDER;
    }
}

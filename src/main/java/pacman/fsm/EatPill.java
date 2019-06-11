package pacman.fsm;

import pacman.game.Constants;
import pacman.game.Game;
import pacman.helper.Helper;

public class EatPill extends State {
    private int pill;

    public EatPill() {
        // Target pill
        pill = Integer.MIN_VALUE;
    }

    public Constants.MOVE Act(Game game) {
        // Check if there is a target pill
        // Otherwise set the first pill from the list
        if (pill == Integer.MIN_VALUE) {
            if(game.getActivePillsIndices().length > 0){
                pill = game.getActivePillsIndices()[0];
            }
            else {
                return Constants.MOVE.NEUTRAL;
            }
        }

        return game.getApproximateNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(), pill, game.getPacmanLastMoveMade(), Constants.DM.PATH);
    }

    @Override
    public States Transition(Game game) {
        // Check if a power pill was eaten
        if (game.wasPowerPillEaten()) {
            return States.CHASE_GHOST;
        }

        // Check for ghost
        if (Helper.getInstance().pacmanInDanger(game)) {
            // Ghost is visible
            // Change active state to avoid ghost
            pill = Integer.MIN_VALUE;
            return States.AVOID_GHOST;
        }

        if (pill != Integer.MIN_VALUE) {
            try {
                if (game.isPillStillAvailable(game.getPillIndex(pill))) {
                    return States.EAT_PILL;
                }
            } catch (NullPointerException e) {

            }
        }

        // Target pill was eaten or lost from sight, reset target
        pill = Integer.MIN_VALUE;

        // Check if there are more pills available
        if (game.getActivePillsIndices().length > 0){
            // Pac man sees pills
            return States.EAT_PILL;
        }

        // No visible ghosts and no more visible pills
        // Return to wander
        return States.WANDER;
    }
}

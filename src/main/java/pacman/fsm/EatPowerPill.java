package pacman.fsm;

import pacman.game.Constants;
import pacman.game.Game;
import pacman.helper.Helper;

public class EatPowerPill extends State {
    private int pill;

    public EatPowerPill() {
        // Target pill
        pill = Integer.MIN_VALUE;
    }

    public Constants.MOVE Act(Game game) {
        // Check if there is a target pill
        // Otherwise set the first pill from the list
        if (pill == Integer.MIN_VALUE) {
            if (game.getActivePowerPillsIndices().length > 0) {
                pill = game.getActivePowerPillsIndices()[0];
            }
            else {
                return game.getPacmanLastMoveMade();
            }
        }

        return game.getApproximateNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(), pill, game.getPacmanLastMoveMade(), Constants.DM.PATH);
    }

    @Override
    public States Transition(Game game) {
        // Check for ghost
        if (!Helper.getInstance().pacmanInDanger(game)) {
            // Ghost is not visible anymore
            // Change active state to wander
            pill = Integer.MIN_VALUE;
            return States.WANDER;
        }

        // Power pill was eaten, start chasing the ghost
        if (game.wasPowerPillEaten()) {
            pill = Integer.MIN_VALUE;
            return States.CHASE_GHOST;
        }

        try {
            if (game.isPowerPillStillAvailable(game.getPillIndex(pill))) {
                return States.EAT_POWER_PIL;
            }
        } catch (NullPointerException e) {

        }
        // Target pill was eaten or lost from sight, reset target
        pill = Integer.MIN_VALUE;

        // Check if there are more pills available
        if (game.getActivePowerPillsIndices().length > 0){
            // Pac man sees a power pill
            return States.EAT_POWER_PIL;
        }

        // No visible power pills and still visible ghost
        // Go to avoid ghost
        return States.AVOID_GHOST;
    }
}

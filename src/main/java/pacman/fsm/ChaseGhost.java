package pacman.fsm;

import pacman.game.Constants;
import pacman.game.Game;
import pacman.helper.Helper;

import java.util.ArrayList;

public class ChaseGhost extends State {

    public ChaseGhost() {
    }

    @Override
    public Constants.MOVE Act(Game game) {
        // Move towards the ghost
        ArrayList<Constants.GHOST> ghosts = Helper.getInstance().VisibleEdibleGhost(game);
        if (ghosts.size() > 0) {
            return game.getApproximateNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(ghosts.get(0)), game.getPacmanLastMoveMade(), Constants.DM.PATH);
        }

        return Helper.getInstance().randomMove();
    }

    @Override
    public States Transition(Game game) {
        // Check if power pill is still active
        if (Helper.getInstance().isPowerPillActive(game)) {
            return States.CHASE_GHOST;
        }


        // Check for visible ghost
        if (Helper.getInstance().pacmanInDanger(game)) {
            // Ghost is visible
            // Chase ghost
            return States.CHASE_GHOST;
        }

        // No visible ghost, return to wander
        return States.WANDER;
    }
}

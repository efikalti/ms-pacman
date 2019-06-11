package pacman.fsm;

import pacman.game.Constants;
import pacman.game.Game;
import pacman.game.info.GameInfo;
import pacman.helper.Helper;

import java.util.ArrayList;

public class AvoidGhost extends State {

    public AvoidGhost() {

    }

    @Override
    public Constants.MOVE Act(Game game) {
        // Move away from the ghost
        ArrayList<Constants.GHOST> ghosts = Helper.getInstance().VisibleGhosts(game);
        if (ghosts.size() > 0) {
            int ghost = game.getGhostCurrentNodeIndex(ghosts.get(0));
            return game.getApproximateNextMoveAwayFromTarget(game.getPacmanCurrentNodeIndex(), ghost, game.getPacmanLastMoveMade(), Constants.DM.PATH);
        }

        return game.getPacmanLastMoveMade();
    }

    @Override
    public States Transition(Game game) {
        // Check for power pill
        if (game.getActivePowerPillsIndices().length > 0){
            // Pac man sees a power pill
            // Change active state to get to the power pill
            return States.EAT_POWER_PIL;
        }
        // Check for ghost
        else if (!Helper.getInstance().pacmanInDanger(game)) {
            // No ghost is visible
            // Change active state to wander
            return States.WANDER;
        }

        // Do not change state
        return States.AVOID_GHOST;
    }
}

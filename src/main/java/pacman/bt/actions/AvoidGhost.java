package pacman.bt.actions;

import pacman.bt.Action;
import pacman.bt.Blackboard;
import pacman.game.Constants;
import pacman.game.Game;
import pacman.helper.Helper;

import java.util.ArrayList;

public class AvoidGhost extends Action {

    public AvoidGhost() {
        this.name = "AvoidGhost";
    }

    @Override
    public boolean Act(Game game) {
        System.out.print(this.toString() + " . \n");
        // Get visible ghosts
        ArrayList<Constants.GHOST> ghosts = Helper.getInstance().VisibleGhosts(game);

        if (ghosts.size() > 0) {
            int ghost = game.getGhostCurrentNodeIndex(ghosts.get(0));
            // Move away from the ghost
            move = game.getApproximateNextMoveAwayFromTarget(game.getPacmanCurrentNodeIndex(), ghost, game.getPacmanLastMoveMade(), Constants.DM.PATH);
            Blackboard.getInstance().setMove(move);
            return true;
        }

        return false;
    }
}

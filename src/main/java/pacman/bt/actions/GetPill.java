package pacman.bt.actions;

import pacman.bt.Action;
import pacman.bt.Blackboard;
import pacman.game.Constants;
import pacman.game.Game;

public class GetPill extends Action {

    public GetPill() {
        this.name = "GetPill";
    }

    @Override
    public boolean Act(Game game) {
        System.out.print(this.toString() + " . \n");
        // Get visible pill
        int pill = game.getActivePillsIndices()[0];
        // Get move towards pill
        move = game.getApproximateNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(), pill, game.getPacmanLastMoveMade(), Constants.DM.PATH);
        Blackboard.getInstance().setMove(move);
        return true;
    }
}

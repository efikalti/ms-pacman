package pacman.bt.actions;

import pacman.bt.Action;
import pacman.bt.Blackboard;
import pacman.game.Game;
import pacman.helper.Helper;


public class Wander extends Action {

    public Wander() {
        this.name = "Wander";
    }

    @Override
    public boolean Act(Game game) {
        System.out.print(this.toString() + " . \n");
        Blackboard.getInstance().setMove(Helper.getInstance().randomMove());
        return true;
    }
}

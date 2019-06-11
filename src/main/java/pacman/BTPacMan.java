package pacman;

import pacman.bt.selectors.MainSelector;
import pacman.controllers.PacmanController;
import pacman.bt.*;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import pacman.helper.Helper;

/*
 * Efi Kaltirimidou BT Pac Man
 */
public class BTPacMan extends PacmanController {

    private Task mainTask;

    public BTPacMan() {
        mainTask = new MainSelector();
    }

    public MOVE getMove(Game game, long timeDue) {
        if (mainTask.Act(game)) {
            return Blackboard.getInstance().getMove();
        }
        else {
            System.out.println("Could not complete any action successfully from the Behavior Tree");
            return Helper.getInstance().randomMove();
        }
    }
}
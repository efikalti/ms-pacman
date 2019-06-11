package pacman.bt.sequences;

import pacman.bt.Sequence;
import pacman.bt.actions.ChaseGhost;
import pacman.helper.Helper;

public class ActivePowerPillSequence extends Sequence {

    public ActivePowerPillSequence() {
        super();
        this.name = "ActivePowerPillSequence";

        // Initialize and add actions for this sequence
        actions.add(new ChaseGhost());
    }

    @Override
    public boolean Condition() {
        // Check for active power pill
        if (game.wasPowerPillEaten()) {
            return true;
        }
        if (Helper.getInstance().isPowerPillActive(game)) {
            return true;
        }

        // No power pill active
        return false;
    }
}
package pacman.bt;

import pacman.game.Game;
import java.util.ArrayList;

public abstract class Sequence extends Task {

    protected ArrayList<Task> actions;
    protected Game game;

    protected Sequence() {
        actions = new ArrayList<>();
    }

    public abstract boolean Condition();

    @Override
    public boolean Act(Game game) {
        this.game = game;
        // Check sequence condition
        if (Condition()) {
            // Return result of the sequence actions
            return ExecuteActions();
        }
        // Sequence condition not satisfied, return false
        return false;
    }


    @Override
    public boolean ExecuteActions() {
        System.out.print(this.toString() + " -> ");
        // Start executing actions, if one returns false
        // Terminate function and return false
        for (Task action : actions) {
            if (!action.Act(game)) {
                return false;
            }
        }
        // All actions ran successfully
        return true;
    }
}

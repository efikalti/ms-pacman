package pacman.bt;

import pacman.game.Game;

import java.util.ArrayList;

public abstract class Selector extends Task {

    protected ArrayList<Task> actions;
    protected Game game;

    public Selector(){
        actions = new ArrayList<>();
    }

    @Override
    public boolean Act(Game game) {
        this.game = game;
        return ExecuteActions();
    }

    @Override
    public boolean ExecuteActions() {
        System.out.print(this.toString() + " -> ");
        // Start executing actions, if one returns true
        // Terminate function and return true
        for (Task action : actions) {
            if (action.Act(game)) {
                return true;
            }
        }
        // No action ran successfully
        return false;
    }
}

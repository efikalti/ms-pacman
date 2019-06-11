package pacman.bt;

import pacman.game.Game;

public abstract class Task {

    protected String name;

    public abstract boolean Act(Game game);

    public boolean ExecuteActions() {
        return false;
    }

    public String toString(){
        return this.name;
    }
}

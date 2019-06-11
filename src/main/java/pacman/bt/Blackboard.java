package pacman.bt;

import pacman.game.Constants;

public class Blackboard {
    private static Blackboard ourInstance = new Blackboard();

    public static Blackboard getInstance() {
        return ourInstance;
    }

    private Constants.MOVE move;

    private Blackboard() {
        this.move = null;
    }

    public void setMove(Constants.MOVE move){
        this.move = move;
    }

    public Constants.MOVE getMove(){
        Constants.MOVE move = this.move;
        this.move = null;
        return move;
    }

}

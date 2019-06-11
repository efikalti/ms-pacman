package pacman.helper;

import pacman.game.Constants;
import pacman.game.Game;

import java.util.ArrayList;
import java.util.Random;

public class Helper {
    private static Helper ourInstance = new Helper();

    public static Helper getInstance() {
        return ourInstance;
    }

    private Random rand;

    private Helper() {
        rand = new Random();
    }

    // Returns a random move
    public Constants.MOVE randomMove() {
        int index = rand.nextInt() % 5;

        switch (index){
            case 0:
                return Constants.MOVE.UP;
            case 1:
                return Constants.MOVE.RIGHT;
            case 2:
                return Constants.MOVE.DOWN;
            case 3:
                return Constants.MOVE.LEFT;
            case 4:
                return Constants.MOVE.NEUTRAL;
        }

        return null;
    }

    public boolean pacmanInDanger(Game game) {

        // Iterate through ghosts
        for (Constants.GHOST ghost : Constants.GHOST.values()) {
            if (game.getGhostCurrentNodeIndex(ghost) != -1) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Constants.GHOST> VisibleGhosts(Game game) {
        ArrayList<Constants.GHOST> ghosts = new ArrayList<>();

        // Iterate through ghosts
        for (Constants.GHOST ghost : Constants.GHOST.values()) {
            if (game.getGhostCurrentNodeIndex(ghost) != -1) {
                // ghost is visible
                ghosts.add(ghost);
            }
        }

        return ghosts;
    }

    public boolean isPowerPillActive(Game game) {
        // Iterate through ghosts
        for (Constants.GHOST ghost : Constants.GHOST.values()) {
            if (game.getGhostEdibleTime(ghost) > 0) {
                // At least one ghost is still edible
                return true;
            }
        }
        return false;
    }

    public ArrayList<Constants.GHOST> VisibleEdibleGhost(Game game) {
        ArrayList<Constants.GHOST> ghosts = new ArrayList<>();

        // Iterate through ghosts
        for (Constants.GHOST ghost : Constants.GHOST.values()) {
            if (game.getGhostCurrentNodeIndex(ghost) != -1 && game.isGhostEdible(ghost)) {
                // ghost is visible and edible
                ghosts.add(ghost);
            }
        }

        return ghosts;
    }

    public Constants.GHOST closestGhost(Game game) {
        // Iterate through ghosts
        int distance = Integer.MAX_VALUE;
        Constants.GHOST min_ghost = null;
        for (Constants.GHOST ghost : Constants.GHOST.values()) {
            if (game.getGhostCurrentNodeIndex(ghost) != -1) {
                int dist = game.getShortestPathDistance(game.getPacmanCurrentNodeIndex(), game.getGhostCurrentNodeIndex(ghost));
                if (dist < distance) {
                    distance = dist;
                    min_ghost = ghost;
                }
            }
        }
        return min_ghost;
    }
}

package pacman.bt.sequences;

        import pacman.bt.Sequence;
        import pacman.bt.selectors.PowerPillSelector;
        import pacman.game.Constants;
        import pacman.helper.Helper;

        import java.util.ArrayList;

public class GhostSequence extends Sequence {

    public GhostSequence() {
        super();
        this.name = "GhostSequence";

        // Initialize and add actions for this sequence
        actions.add(new PowerPillSelector());
    }

    @Override
    public boolean Condition() {
        // Check for visible ghosts
        ArrayList<Constants.GHOST> ghosts = Helper.getInstance().VisibleGhosts(game);

        return ghosts.size() > 0;
    }
}
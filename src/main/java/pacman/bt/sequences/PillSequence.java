package pacman.bt.sequences;

import pacman.bt.Sequence;
import pacman.bt.actions.GetPill;

public class PillSequence extends Sequence {

    public PillSequence() {
        super();
        this.name = "PillSequence";

        // Initialize and add actions for this sequence
        actions.add(new GetPill());
    }

    @Override
    public boolean Condition() {
        // Check for visible pills
        return game.getActivePillsIndices().length > 0;
    }
}
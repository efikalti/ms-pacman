package pacman.bt.sequences;

import pacman.bt.Sequence;
import pacman.bt.actions.GetPowerPill;

public class PowerPillSequence extends Sequence {

    public PowerPillSequence() {
        super();
        this.name = "PowerPillSequence";

        // Initialize and add actions for this sequence
        actions.add(new GetPowerPill());
    }

    @Override
    public boolean Condition() {
        // Check for visible power pills
        return game.getActivePowerPillsIndices().length > 0;
    }
}
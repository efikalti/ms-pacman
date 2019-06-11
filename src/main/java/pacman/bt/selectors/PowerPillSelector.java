package pacman.bt.selectors;

import pacman.bt.actions.AvoidGhost;
import pacman.bt.Selector;
import pacman.bt.sequences.ActivePowerPillSequence;
import pacman.bt.sequences.PowerPillSequence;

public class PowerPillSelector extends Selector {

    public PowerPillSelector() {
        this.name = "PowerPillSelector";
        // Initialize and add actions for this sequence
        // Check for active power pill
        actions.add(new ActivePowerPillSequence());
        // Check for power pill
        actions.add(new PowerPillSequence());
        // No power pill found, avoid ghost
        actions.add(new AvoidGhost());
    }
}

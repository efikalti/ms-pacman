package pacman.bt.selectors;

import pacman.bt.Selector;
import pacman.bt.actions.Wander;
import pacman.bt.sequences.GhostSequence;
import pacman.bt.sequences.PillSequence;

public class MainSelector extends Selector {

    public MainSelector() {
        this.name = "MainSelector";
        // Initialize and add actions for this selector
        // Check for visible ghosts
        actions.add(new GhostSequence());
        // Check for visible pill
        actions.add(new PillSequence());
        // Wander
        actions.add(new Wander());
    }
}

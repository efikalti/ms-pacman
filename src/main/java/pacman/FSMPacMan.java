package pacman;

import pacman.controllers.PacmanController;
import pacman.fsm.*;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

import java.util.ArrayList;

/*
 * Efi Kaltirimidou FSM Pac Man
 */
public class FSMPacMan extends PacmanController {
    private ArrayList<State> states;
    private int activeState;
    private States newState;

    public FSMPacMan() {
        states = new ArrayList<>();

        // Create states
        Wander wander_state = new Wander();
        AvoidGhost avoid_ghost = new AvoidGhost();
        EatPill eat_pill_state = new EatPill();
        EatPowerPill eat_power_pill_state = new EatPowerPill();
        ChaseGhost chase_ghost = new ChaseGhost();

        // Add states to list
        states.add(wander_state);
        states.add(avoid_ghost);
        states.add(eat_pill_state);
        states.add(eat_power_pill_state);
        states.add(chase_ghost);

        // Set active state to wander
        activeState = 0;
        // Print starting state
        System.out.println(states.get(activeState));
    }

    public MOVE getMove(Game game, long timeDue) {
        // Apply active state move
        MOVE move = states.get(activeState).Act(game);

        // Check for state transition
        newState = states.get(activeState).Transition(game);

        if (newState.ordinal() != activeState) {
            System.out.println(States.values()[activeState] + " -> " + newState);
        }
        activeState = newState.ordinal();

        return move;

    }
}
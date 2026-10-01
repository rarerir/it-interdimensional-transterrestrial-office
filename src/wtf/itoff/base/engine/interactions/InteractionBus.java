package wtf.itoff.base.engine.interactions;

import java.util.Queue;

public class InteractionBus {

    private Queue<Interaction> interactions;

    public boolean queue(Interaction inter) {
        if (inter.getObj1().parentScene != inter.getObj2().parentScene) {
            return false;
        }
        interactions.add(inter);
        return true;
    }

    public void poll() {
        Interaction current = interactions.poll();
        if (current == null) return;
        Interactable obj1 = current.getObj1();
        obj1.onInteraction(current);
    }

}

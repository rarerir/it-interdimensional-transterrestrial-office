package wtf.itoff.base.engine;

import wtf.itoff.base.engine.interactions.Interactable;

import java.util.ArrayList;

public abstract class Scene {

    public ArrayList<Interactable> objects;

    public abstract void onKeyboardKey(int key);

    public abstract void onMouseKey(int key);

    public abstract void updateScene();

}

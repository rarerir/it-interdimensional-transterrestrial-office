package wtf.itoff.base.engine;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.*;
import org.lwjgl.system.*;
import wtf.itoff.base.engine.value.Value;

import java.awt.geom.Point2D;
import java.nio.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;
import java.util.ArrayList;
import java.util.Objects;

public class Game {

    private long window;
    private final int TPS = 60;
    private ArrayList<Value<?>> options;
    public ArrayList<Scene> currentScenes;

    public Point2D getCursorPos() {
        DoubleBuffer xBuf = BufferUtils.createDoubleBuffer(1);
        DoubleBuffer yBuf = BufferUtils.createDoubleBuffer(1);
        glfwGetCursorPos(window, xBuf, yBuf);
        return new Point2D.Double(xBuf.get(), yBuf.get());
    }

    private void initGLFW() {
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if ( !glfwInit() )
            throw new IllegalStateException("Unable to initialize GLFW");

        // Configure GLFW
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

        // Create the window
        window = glfwCreateWindow(1280, 720, "I.T. Office (Engine)", NULL, NULL);
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");

        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            for (Scene scene : currentScenes) {
                if (action == GLFW_RELEASE) {
                    scene.onKeyboardKey(key);// We will detect this in the rendering loop
                }
            }
        });

        // Get the thread stack and push a new frame
        try ( MemoryStack stack = stackPush() ) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(window, pWidth, pHeight);

            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // Center the window
            glfwSetWindowPos(
                    window,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        } // the stack frame is popped automatically

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(window);
    }

    private void initOptions() {
        this.options.add(new Value<>(true, "VSync"));
        this.options.add(new Value<Point2D>(new Point2D.Double(1280, 720), "Resolution"));
    }

    public Value<?> findOption(String name) {
        return this.options.stream().filter((option) -> { return Objects.equals(option.name, name); }).toList().get(0);
    }

    public void init() {
        initOptions();
        initGLFW();
    }

    public void update() {
        while (true) {

        }
    }
}

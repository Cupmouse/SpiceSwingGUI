package net.spicesoftware.swinggui;

import net.spicesoftware.api.gui.window.Window;

import javax.swing.*;
import java.awt.*;

import static net.spicesoftware.api.util.Validate.nullNot;

/**
 * @since 2015/11/25
 */
public class SwingWindow extends JFrame implements Window<SwingWindowSystem> {

    private final SwingWindowSystem windowSystem;

    public SwingWindow(SwingWindowSystem windowSystem) throws HeadlessException {
        this.windowSystem = windowSystem;
    }

    public SwingWindow(GraphicsConfiguration gc, SwingWindowSystem windowSystem) {
        super(gc);
        this.windowSystem = windowSystem;
    }

    public SwingWindow(String title, SwingWindowSystem windowSystem) throws HeadlessException {
        super(title);
        this.windowSystem = windowSystem;
    }

    public SwingWindow(String title, GraphicsConfiguration gc, SwingWindowSystem windowSystem) {
        super(title, gc);
        this.windowSystem = windowSystem;
    }

    @Override
    public void dispose() {

        super.dispose();
    }
}

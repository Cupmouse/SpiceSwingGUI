package net.spicesoftware.swinggui;

import net.spicesoftware.api.gui.window.WindowState;
import net.spicesoftware.api.gui.window.WindowStateImmutable;
import net.spicesoftware.api.gui.window.WindowStateMutable;
import net.spicesoftware.api.gui.window.location.WindowLocation;
import net.spicesoftware.api.gui.window.location.WindowLocationAbsolute;
import net.spicesoftware.api.gui.window.title.WindowTitle;
import net.spicesoftware.api.util.Validate;
import net.spicesoftware.api.util.vector.Vector2i;

import java.awt.*;

import static net.spicesoftware.api.gui.window.location.WindowLocationAbsolute.absolute;
import static net.spicesoftware.api.util.Validate.nullNot;
import static net.spicesoftware.api.util.vector.Vector2i.v2i;

/**
 * @since 2015/12/22
 */
public final class SwingWindowStateMutableBinder<W extends SwingWindow> implements WindowStateMutable {

    private WindowTitle title;
    private final W window;

    public SwingWindowStateMutableBinder(W window) {
        nullNot(window);
        this.window = window;
    }

    @Override
    public void setTitle(WindowTitle title) {
        nullNot(title);
        this.title = title;
    }

    @Override
    public void setLocation(WindowLocation windowLocation) {
        nullNot(windowLocation);

    }

    @Override
    public void setMaximumSize(Vector2i maximumSize) {
        nullNot(maximumSize);
        window.setMinimumSize(new Dimension(maximumSize.x, maximumSize.y));
    }

    @Override
    public void setMinimumSize(Vector2i minimumSize) {
        nullNot(minimumSize);
        window.setMinimumSize(new Dimension(minimumSize.x, minimumSize.y));
    }

    @Override
    public void setSize(Vector2i size) {
        nullNot(size);
        window.setSize(size.x, size.y);
    }

    @Override
    public void setSizeFixed(boolean sizeFixed) {
        window.setResizable(sizeFixed);
    }

    @Override
    public void setVisible(boolean visible) {
        window.setVisible(visible);
    }

    @Override
    public WindowTitle getTitle() {
        return title;
    }

    @Override
    public WindowLocation getLocation() {
        Point location = window.getLocation();
        return absolute(v2i(location.x, location.y));
    }

    @Override
    public Vector2i getMaximumSize() {
        Dimension size = window.getMaximumSize();
        return v2i(size.width, size.height);
    }

    @Override
    public Vector2i getMinimumSize() {
        Dimension size = window.getMinimumSize();
        return v2i(size.width, size.height);
    }

    @Override
    public Vector2i getSize() {
        Dimension size = window.getSize();
        return v2i(size.width, size.height);
    }

    @Override
    public boolean isSizeFixed() {
        return window.isResizable();
    }

    @Override
    public boolean isVisible() {
        return window.isVisible();
    }
}

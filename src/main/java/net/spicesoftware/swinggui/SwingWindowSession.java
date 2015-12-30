package net.spicesoftware.swinggui;

import net.spicesoftware.api.gui.window.WindowSession;
import net.spicesoftware.api.gui.window.WindowState;
import net.spicesoftware.api.gui.window.WindowStateImmutable;
import net.spicesoftware.api.gui.window.WindowStateMutable;
import net.spicesoftware.api.util.Validate;

import java.util.Optional;

import static net.spicesoftware.api.util.Validate.nullNot;

/**
 * @since 2015/12/22
 */
public final class SwingWindowSession<W extends SwingWindow> implements WindowSession<SwingWindowSystem, W> {

    private final SwingWindowDispatcher dispatcher;
    private W window;
    private SwingWindowStateMutableBinder<W> stateMutableBinder;

    public SwingWindowSession(SwingWindowDispatcher dispatcher, W window, WindowState state) {
        nullNot(dispatcher, window, state);
        this.dispatcher = dispatcher;
        this.window = window;
        this.stateMutableBinder = new SwingWindowStateMutableBinder<>(window);
        this.stateMutableBinder.copyFrom(state);
    }

    @Override
    public synchronized Optional<W> getWindow() {
        return Optional.ofNullable(window);
    }

    @Override
    public synchronized Optional<WindowStateMutable> getWindowState() {
        return Optional.ofNullable((WindowStateMutable) stateMutableBinder);
    }

    @Override
    public synchronized void close() throws IllegalStateException {
        if (window == null) {
            throw new IllegalStateException();
        }

        synchronized (window) {
            window.dispose();
            window = null;
            stateMutableBinder = null;
            dispatcher.close(this);
        }
    }
}

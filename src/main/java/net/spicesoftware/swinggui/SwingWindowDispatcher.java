package net.spicesoftware.swinggui;

import net.spicesoftware.api.gui.window.*;
import net.spicesoftware.api.util.AlreadyRegisteredException;
import net.spicesoftware.api.util.Pair;
import net.spicesoftware.api.util.Validate;

import java.awt.*;
import java.util.*;
import java.util.function.Supplier;

/**
 * @since 2015/12/22
 */
public final class SwingWindowDispatcher implements WindowDispatcher<SwingWindowSystem, SwingWindow> {

    private Map<String, Pair<Supplier<? extends SwingWindow>, WindowStateImmutable>> windowSuppliers = new HashMap<>();
    private Set<SwingWindowSession<? extends SwingWindow>> dispensed = new HashSet<>();

    @Override
    public <W extends SwingWindow> Pair<W, WindowStateImmutable> createNewWindow(Class<W> clazz) {
        Pair<Supplier<? extends SwingWindow>, WindowStateImmutable> pair = this.windowSuppliers.get(clazz);
        return Pair.of((W) pair.a.get(), pair.b);
    }

    @Override
    public void registerWindowSupplier(String id, Supplier<? extends SwingWindow> windowSupplier, WindowStateImmutable defaultState) throws AlreadyRegisteredException {
        Validate.nullNot(id, windowSupplier, defaultState);
        this.windowSuppliers.put(id, Pair.of(windowSupplier, defaultState));
    }

    @Override
    public synchronized Set<SwingWindowSession<? extends SwingWindow>> getDispensed() {
        return Collections.unmodifiableSet(dispensed);
    }

    @Override
    public synchronized <W extends SwingWindow> Set<SwingWindowSession<W>> getDispensed(Class<W> clazz) {
        Set<SwingWindowSession<W>> dispensedClass = new HashSet<>();

        for (SwingWindowSession<? extends SwingWindow> swingWindowSession : getDispensed()) {
            if (clazz.isInstance(swingWindowSession.getWindow().get())) {
                dispensedClass.add((SwingWindowSession<W>) swingWindowSession);
            }
        }

        return Collections.unmodifiableSet(dispensedClass);
    }

    @Override
    public synchronized <W extends SwingWindow> SwingWindowSession<W> dispense(W window) {
        return dispense(window, windowSuppliers.get(window.getClass()).b);
    }

    @Override
    public <W extends SwingWindow> SwingWindowSession<W> dispense(W window, WindowState windowState) {
        SwingWindowSession<W> windowSession = new SwingWindowSession<>(this, window, windowState);
        dispensed.add(windowSession);
        return windowSession;
    }

    synchronized boolean close(SwingWindowSession sessionSwing) {
        return dispensed.remove(sessionSwing);
    }
}

package net.spicesoftware.swinggui;

import net.spicesoftware.api.gui.window.Window;

import javax.swing.*;
import java.awt.*;

/**
 * @since 2015/11/25
 */
public class SwingDialogWindow extends JDialog implements Window<SwingWindowSystem> {

    public SwingDialogWindow() {
    }

    public SwingDialogWindow(Frame owner) {
        super(owner);
    }

    public SwingDialogWindow(Frame owner, boolean modal) {
        super(owner, modal);
    }

    public SwingDialogWindow(Frame owner, String title) {
        super(owner, title);
    }

    public SwingDialogWindow(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
    }

    public SwingDialogWindow(Frame owner, String title, boolean modal, GraphicsConfiguration gc) {
        super(owner, title, modal, gc);
    }

    public SwingDialogWindow(Dialog owner) {
        super(owner);
    }

    public SwingDialogWindow(Dialog owner, boolean modal) {
        super(owner, modal);
    }

    public SwingDialogWindow(Dialog owner, String title) {
        super(owner, title);
    }

    public SwingDialogWindow(Dialog owner, String title, boolean modal) {
        super(owner, title, modal);
    }

    public SwingDialogWindow(Dialog owner, String title, boolean modal, GraphicsConfiguration gc) {
        super(owner, title, modal, gc);
    }

    public SwingDialogWindow(java.awt.Window owner) {
        super(owner);
    }

    public SwingDialogWindow(java.awt.Window owner, ModalityType modalityType) {
        super(owner, modalityType);
    }

    public SwingDialogWindow(java.awt.Window owner, String title) {
        super(owner, title);
    }

    public SwingDialogWindow(java.awt.Window owner, String title, ModalityType modalityType) {
        super(owner, title, modalityType);
    }

    public SwingDialogWindow(java.awt.Window owner, String title, ModalityType modalityType, GraphicsConfiguration gc) {
        super(owner, title, modalityType, gc);
    }
}

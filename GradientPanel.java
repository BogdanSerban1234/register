package Ore.register;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Clasa <code>GradientPanel</code> ce este un tip de JPanel care are un
 * gradient albastru
 * spre alb
 */
class GradientPanel extends JPanel {
    @Override
    /**
     * Cream un paintComponent pentru a putea adauga gradient panelul la un frame
     * sau la un panel
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        /**
         * Cream un gradientPaint cu scopul de a face 2 punce de culori diferite iar
         * programul sa determine culorile dintre
         */
        GradientPaint gradient = new GradientPaint(
                new Point2D.Float(0, 0), Color.CYAN,
                new Point2D.Float(getWidth(), getHeight()), new Color(213, 255, 255));
        Graphics2D g2d = (Graphics2D) g;
        /**
         * Punem culorile iar apoi cream un dreptunghi cu ele
         */
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}

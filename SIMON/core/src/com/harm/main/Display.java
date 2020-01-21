package com.harm.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Display
{

    @SuppressWarnings("serial")
    public class display extends JPanel
    {

        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            if (Game.simon != null)
            {
                Game.simon.paint((Graphics2D) g);
            }
        }

    }
}

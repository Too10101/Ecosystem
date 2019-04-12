/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eco;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author 629469
 */
public class Buffalo extends Creature {
    private int size;
    private int f;
    private int l = 5000;
    
    public Buffalo(int size) {
        super();
        this.size = size;
    }
    
    public Buffalo() {
        this(15);
    }
    
    @Override
    public void lifeSpan() {
        f++;
        if (f % l == 0) {
            x = -100000;
        }
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillOval(x, y, 30, 30);
    }
}

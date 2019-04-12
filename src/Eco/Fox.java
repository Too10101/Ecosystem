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
public class Fox extends Creature {
    private int size;
    private int f;
    private int l = 1700;
    
    public Fox(int size) {
        super();
        this.size = size;
    }
    
    public Fox() {
        this(15);
    }
    
    @Override
    public void lifeSpan() {
        f++;
        if (f % l == 0) {
            x = -1000000;
        }
    }
    
    @Override
    public void move() {
        x += vx;
        y += vy;
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, 20, size);
    }
}

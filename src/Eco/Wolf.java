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
public class Wolf extends Creature {
    private int size;
    private int f;
    private int l = 2700;
    
    private Color color = new Color(88, 59, 51);
    
    public Wolf(int size) {
        super();
        this.size = size;
    }
    
    public Wolf() {
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
    public void move() {
        x += vx;
        y += vy;
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 20, 30);
    }
}

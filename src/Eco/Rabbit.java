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
public class Rabbit extends Creature {
    private int size;
    private int r;
    
    public Rabbit(int size) {
        super();
        this.size = size;
    }
    
    public Rabbit() {
        this(15);
    }
    
    public void lifeSpan(int life) {
        life = 1500;
        r++;
        if (r % life == 0) {
            x = -100000;
        }
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillOval(x, y, size, size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

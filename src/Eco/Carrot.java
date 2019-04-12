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
public class Carrot {
    
    private int x;
    private int y;
    private int size = 10;
    private int d;
    private Color color = new Color(230, 115, 0);
    
    public Carrot() {
        this.x = (int) (Math.random() * 1000 + 20);
        this.y = (int) (Math.random() * 750 + 20);
    }
    
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }
    
    public void Decay() {
        d++;
        if (d % 1000 == 0) {
            x = -100000;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

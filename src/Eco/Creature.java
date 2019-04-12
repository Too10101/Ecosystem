/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eco;

import java.awt.Graphics;

/**
 *
 * @author jword
 */
public abstract class Creature {
    
    //Fields
    protected int x;
    protected int y;
    protected double vx;
    protected double vy;
    protected double control = 2.94;

    //Constructor
    public Creature(int x, int y) {
        this.x = x;
        this.y = y;
        this.vx = 0;
        this.vy = 0;
    }

    public Creature() {
        this((int) (Math.random() * 1000 + 20), (int) (Math.random() * 750 + 20));
    }
    
    public abstract void draw(Graphics g);
    
    public void update() {
        move();
        lifeSpan();
    }
    
    public void lifeSpan() {
        
    }

    public void move() {
        vx = (Math.random() * 7) - control;
        vy = (Math.random() * 7) - control;
        x += vx;
        y += vy;
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

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }
}

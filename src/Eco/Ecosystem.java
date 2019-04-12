/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eco;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author jword
 */
public class Ecosystem extends JPanel {

    private Timer timer;
    private ArrayList<Wolf> wolves;
    private ArrayList<Rabbit> rabbits;
    private ArrayList<Buffalo> buffalos;
    private ArrayList<Fox> foxes;
    private ArrayList<Carrot> carrots;
        
    private int r,f,w,b,c;
    private int e,i;
    private int seasons = 800;
    
    private Color summer = new Color(3, 102, 3);
    private Color fall = new Color(138, 92, 2);
    private Color winter = new Color(88, 83, 73);
    private Color spring = new Color(88, 176, 0);
    
    public Ecosystem() {
        super();
        wolves = new ArrayList<>();
        rabbits = new ArrayList<>();
        buffalos = new ArrayList<>();
        foxes = new ArrayList<>();
        
        carrots = new ArrayList<>();
        
        setSize(1200, 960);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/60);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial Black", Font.BOLD, 20));
        
        
        //Determines Season
        if (seasons > 800 && seasons < 1950) {
            this.setBackground(summer);
            g.drawString("Summer", 1075, 20);
            rS = 3;
            fS = 1;
            bS = 2;
            wS = 1;
        }
        
        if (seasons > 1950 && seasons < 2760) {
            this.setBackground(fall);
            g.drawString("Fall", 1125, 20);
        }
        
        if (seasons > 2760 && seasons < 3800) {
            this.setBackground(winter);
            g.drawString("Winter", 1100, 20);
            rS = 1;
            fS = 0;
            bS = 1;
            wS = 0;
        }
        
        if (seasons > 3800) {
            this.setBackground(spring);
            seasons = 0;
        }   
        
        if (seasons > 0 && seasons < 800) {
            g.drawString("Spring", 1100, 20);
            rS = 6;
            fS = 1;
            bS = 4;
            wS = 1;
        }   
        
        //Draws Animals
        for (Wolf c : wolves)
                c.draw(g);
        
        for (Rabbit c : rabbits) 
                c.draw(g);

        for (Buffalo c : buffalos)
                c.draw(g);
        
        for (Fox c : foxes)
                c.draw(g);
        
        for (Carrot c : carrots)
            if (c != null)
                c.draw(g);
        
        //Key for Animals and Food
        g.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        g.setColor(Color.BLACK);
        g.fillRect(10, 5, 70, 100);
        
        g.setColor(Color.RED);
        g.drawString("Fox", 20, 20);
        g.fillOval(45, 11, 10, 10);
        
        g.setColor(Color.GRAY);
        g.drawString("Rabbit", 20, 40);
        g.fillOval(60, 31, 10, 10);
        
        Color colorWolf = new Color(88, 59, 51);
        g.setColor(colorWolf);
        g.drawString("Wolf", 20, 60);
        g.fillOval(48, 51, 10, 10);
        
        g.setColor(Color.ORANGE);
        g.drawString("Buffalo", 20, 80);
        g.fillOval(61, 71, 10, 10);
        
        Color colorCarrot = new Color(230, 115, 0);
        g.setColor(colorCarrot);
        g.drawString("Carrot", 20, 100);
        g.fillOval(59, 91, 10, 10);
        
    }
    
    //Spawn Rate
    int rS = 3;
    int fS = 1;
    int wS = 1;
    int bS = 2;
    int cS = 3;
    
    private class ScheduleTask extends TimerTask {
    
        @Override
        public void run() {
            
            //Spawns Animals and Food
                if (r % 200 == 0)
                    for (int i = 0; i < rS; i++)
                        rabbits.add(new Rabbit());

                if (f % 800 == 0)
                    for (int i = 0; i < fS; i++)
                        foxes.add(new Fox());

                if (w % 2300 == 0)
                    for (int i = 0; i < wS; i++)
                        wolves.add(new Wolf());

                if (b % 400 == 0)
                    for (int i = 0; i < bS; i++)
                        buffalos.add(new Buffalo());

                if (c % 450 == 0)
                    for (int i = 0; i < cS; i++)
                        carrots.add(new Carrot());
            
            //Updates all objects
            for (Rabbit c : rabbits)
                c.update();
            for (Fox c : foxes)
                c.update();  
            for (Wolf c : wolves) 
                c.update();
            for (Buffalo c : buffalos) 
                c.update();
            for (Carrot c : carrots) 
                c.Decay();
                      
            DistanceToBuffalo();
            DistanceToRabbit();
            EatRabbit();
            EatBuffalo();
            RabbitVsCarrot();
            
            //Timers for Objects
            c++;
            b++;
            w++;
            f++;
            r++;
            
            //Season Timer
            seasons++;

            //Timer for Immigration Event
            i++;
            
            //Immigration Event
            Immigration();
            
            //Timer for Extinction Event
            e++;
            
            //Extinction Event
            if (e % 2000 == 0) {
                int chance = (int) (Math.random() * 10);
                System.out.println("Extinction:   "+chance);
                
                if (chance == 2) {
                    for (Rabbit r : rabbits) {
                        r.setX(-10000000);
                    }
                }
                if (chance == 4) {
                    for (Fox f : foxes) {
                        f.setX(-1000000);
                    }
                }
                if (chance == 6) {
                    for (Buffalo b : buffalos) {
                        b.setX(-100000);
                    }
                }
            }
            
            repaint();
        }
    }
    
    public void Immigration() {
        if (i % 1475 == 0) {
            int chance = (int) (Math.random() * 4);
            System.out.println("Immigration:  "+chance);
            if (chance == 3) {
                for (int i = 0; i < 10; i++) {
                    rabbits.add(new Rabbit());
                }
            }
        }
    }
    
    Rabbit cR;
    public void DistanceToRabbit() {
        double d;
        double sD = 1000000000;
        
        for (Fox f : foxes) {
            for (Rabbit r : rabbits) {
                d = Math.sqrt(Math.pow(f.getX() - r.getX(), 2) + Math.pow(f.getY() - r.getY(), 2));
                if (sD > d) {
                    sD = d;
                    cR = r;
                }
            }
            if (f.getX() > -100) {
                if (f.getX() >= cR.getX())
                    f.setVx(-1.75);
                if (f.getX() <= cR.getX())
                    f.setVx(2);
                if (f.getY() >= cR.getY())
                    f.setVy(-1.75);
                if (f.getY() <= cR.getY())
                    f.setVy(2);
            }
        }
    }
    
    Buffalo cB;
    public void DistanceToBuffalo() {
        double d;
        double sD = 10000000;
        
        for (Wolf w : wolves) {
            for (Buffalo b : buffalos) {
                d = Math.sqrt(Math.pow(w.getX() - b.getX(), 2) + Math.pow(w.getY() - b.getY(), 2));
                if (sD > d) {
                    sD = d;
                    cB = b;
                }
            }
            if (w.getX() > -100) {
                if (w.getX() >= cB.getX())
                    w.setVx(-2);
                if (w.getX() <= cB.getX())
                    w.setVx(2.25);
                if (w.getY() >= cB.getY())
                    w.setVy(-2);
                if (w.getY() <= cB.getY())
                    w.setVy(2.25);
            }
        }
    }
    
    public void EatRabbit() {
        for (Fox f : foxes) {
            for (Rabbit r : rabbits) {
                if (f.getX() <= cR.getX() + 30 && f.getY() <= cR.getY() + 30) {
                    if (f.getX() + 20 >= cR.getX() && f.getY() + 15 >= cR.getY()) {
                        cR.setX(-10000000);
                    }
                }
            }
        }
    }
    
    public void EatBuffalo() {
        for (Wolf w : wolves) {
            for (Buffalo b : buffalos) {
                if (w.getX() <= cB.getX() + 15 && w.getY() <= cB.getY() + 15) {
                    if (w.getX() + 20 >= cB.getX() && w.getY() + 30 >= cB.getY()) {
                        cB.setX(-10000000);
                    }
                }
            }
        }
    }
    
    public void RabbitVsCarrot() {
        for (Rabbit r : rabbits) {
            for (Carrot c : carrots) {
                if (r.getX() <= c.getX() + c.getSize() && r.getY() <= c.getY() + c.getSize()) {
                    if (r.getX() + r.getSize() >= c.getX() && r.getY() + r.getSize() >= c.getY()) {
                        c.setX(-100000);
                        r.lifeSpan(2000);
                    }
                }
            }
        }
    }
}
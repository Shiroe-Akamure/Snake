package com.company;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
        private int zz=1;
        private int [] snakexlenght = new int [750];
        private int [] snakeylenght = new int [750];
        private boolean left  = false;
        private boolean right =false;
        private boolean up = false;
        private boolean down =false;
        private ImageIcon Snakemouthright;
        private ImageIcon Snakemouthleft;
        private ImageIcon Snakemouthdown;
        private ImageIcon Snakemouthup;
        private ImageIcon snakeimage;
        private int lenghtofsnake = 3;
        private Timer timer;
        private int delay=100;
        private int moves = 0;
        private int[] enemyxpos={25,50,75,100,125,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825};
        private int[] enemyypos={75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575};
        private ImageIcon enemyimage;
        private Random random= new Random();
        private int xpos = random.nextInt(34);
        private int ypos= random.nextInt(23);
        private int score =0;


        private ImageIcon titleImage;
        public Gameplay(){
            addKeyListener(this);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);
            timer= new Timer(delay, this);
            timer.start();
}

        public void paint(Graphics g) {

            if(moves ==0) {
                snakexlenght[2]=50;
                snakexlenght[1]=75;
                snakexlenght[0]=100;

                snakeylenght[2]=100;
                snakeylenght[1]=100;
                snakeylenght[0]=100;
            }

g.setColor(Color.white);
g.drawRect(22, 7, 902, 57);
titleImage= new ImageIcon("snaketitleimage.png");
titleImage.paintIcon(this, g, 23, 8);
g.setColor(Color.WHITE);
g.drawRect(24, 74, 940, 528);
g.setColor(Color.black);
g.fillRect(25, 75, 939, 526);
g.setColor(Color.black);
g.setFont(new Font("arial", Font.PLAIN, 16));
g.drawString(" Score: " +score, 780, 30);

            g.setColor(Color.black);
            g.setFont(new Font("arial", Font.PLAIN, 16));
            g.drawString(" Länge: " +lenghtofsnake, 780, 50);

Snakemouthright = new ImageIcon("Snakemouthright.png");
Snakemouthright.paintIcon(this, g, snakexlenght[0], snakeylenght[0]);

for(int a=0; a< lenghtofsnake; a++) {

    if(a==0 && right){
        Snakemouthright = new ImageIcon("Snakemouthright.png");
        Snakemouthright.paintIcon(this, g, snakexlenght[a], snakeylenght[a]);

    }
    if(a==0 && left){
        Snakemouthleft = new ImageIcon("Snakemouthleft.png");
        Snakemouthleft.paintIcon(this, g, snakexlenght[a], snakeylenght[a]);

    }
    if(a==0 && down){
        Snakemouthdown = new ImageIcon("Snakemouthdown.png");
        Snakemouthdown.paintIcon(this, g, snakexlenght[a], snakeylenght[a]);

    }
    if(a==0 && up){
        Snakemouthup = new ImageIcon("Snakemouthup.png");
        Snakemouthup.paintIcon(this, g, snakexlenght[a], snakeylenght[a]);

    }
    if(a!=0){
       snakeimage = new ImageIcon("snakeimage.png");
        snakeimage.paintIcon(this, g, snakexlenght[a], snakeylenght[a]);
    }
            }


            enemyimage = new ImageIcon("enemy.png");
            if((enemyxpos[xpos] == snakexlenght[0]) && enemyypos[ypos] == snakeylenght[0]){
                score++;
                lenghtofsnake++;
                xpos = random.nextInt(34);
                ypos = random.nextInt(23);

            }
            enemyimage.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);

            for( zz< lenghtofsnake; zz++ ) {
                if(snakexlenght[zz] == snakexlenght[0] && snakeylenght[zz] == snakeylenght[0]){
                    right=false;
                    left=false;
                    up=false;
                    down=false;

                    g.setColor(Color.white);
                    g.setFont(new Font("arial", Font.BOLD, 50));
                    g.drawString("GAME OVER", 300, 300);

                    g.setFont(new Font("arial", Font.BOLD, 20));
                    g.drawString("LEERTASTE UM NEU ZU STARTEN", 350, 340);

                }

            }


            g.dispose();


    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
timer.start();
if(right){
    for(int r=lenghtofsnake-1; r>=0; r--){
        snakeylenght[r+1] = snakeylenght[r];
    }
    for(int r = lenghtofsnake; r>=0; r--){
        if(r==0){
            snakexlenght[r] = snakexlenght[r]+25;
        } else {
            snakexlenght[r]= snakexlenght[r-1];
        }if(snakexlenght[r] > 944){
            snakexlenght[r] = 25;
        }
    }

    repaint();

}

        if(left){
            for(int r=lenghtofsnake-1; r>=0; r--){
                snakeylenght[r+1] = snakeylenght[r];
            }
            for(int r = lenghtofsnake; r>=0; r--){
                if(r==0){
                    snakexlenght[r] = snakexlenght[r]-25;
                } else {
                    snakexlenght[r]= snakexlenght[r-1];
                }if(snakexlenght[r] < 25){
                    snakexlenght[r] = 944;
                }
            }

            repaint();

        }
        if(up){
            for(int r=lenghtofsnake-1; r>=0; r--){
                snakexlenght[r+1] = snakexlenght[r];
            }
            for(int r = lenghtofsnake; r>=0; r--){
                if(r==0){
                    snakeylenght[r] = snakeylenght[r]-25;
                } else {
                    snakeylenght[r]= snakeylenght[r-1];
                }if(snakeylenght[r] < 75){
                    snakeylenght[r] = 625;
                }
            }

            repaint();

        }
        if(down){
            for(int r=lenghtofsnake-1; r>=0; r--){
                snakexlenght[r+1] = snakexlenght[r];
            }
            for(int r = lenghtofsnake; r>=0; r--){
                if(r==0){
                    snakeylenght[r] = snakeylenght[r] + 25;
                } else {
                    snakeylenght[r] = snakeylenght[r-1];
                }if(snakeylenght[r] < 25){
                    snakeylenght[r] = 850;
                }
            }

            repaint();

        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
            if(keyEvent.getKeyCode() == keyEvent.VK_SPACE){
                moves=0;
                score=0;
                lenghtofsnake=3;
                repaint();
            }
if(keyEvent.getKeyCode()== KeyEvent.VK_RIGHT){
    moves++;
    right=true;
    if(!left){
        right=true;

    }
    else {
        right=false;
        left=true;
    }

    up=false;
    down=false;
}
        if(keyEvent.getKeyCode()== KeyEvent.VK_LEFT){
            moves++;
            left=true;
            if(!right){
                left=true;

            }
            else {
                left=false;
                right=true;
            }

            up=false;
            down=false;
        }
        if(keyEvent.getKeyCode()== KeyEvent.VK_UP){
            moves++;
            up =true;
            if(!down){
                up=true;

            }
            else {
                up=false;
                down=true;
            }

            left=false;
            right=false;
        }
        if(keyEvent.getKeyCode()== KeyEvent.VK_DOWN){
            moves++;
            down =true;
            if( ! up){
                down = true;

            }
            else {
                up = true;
                down = false;
            }

            left=false;
            right=false;
        }
    }


    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}

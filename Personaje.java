package game2;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Personaje {

    static  final int ANCHO = 100;
    static  final int ALTO = 100;
    int x = 550;
    int y = 250;
    int y1 = 0;
    Juego jueguito;

    boolean saltando = false;
    boolean sube = false;
    boolean baja = false;

    public Personaje(Juego jueguito){
        this.jueguito = jueguito;
    }

    public void mover(){
        if(saltando){

            if (y==250) {
                sube = true;
                y1 = -5;
                baja = false;
            }

            if (y==50){
                baja = true;
                y1 = 5;
                sube = false;
            }

            if (sube){
                y += y1;
            }

            if (baja){
                y += y1;
                if (y==250){
                    saltando = false;
                }
            }
        }
    }

    public void paint(Graphics2D g){
        g.fillRect(x, y, ANCHO, ALTO);
    }

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            saltando = true;
        }
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, ANCHO, ALTO);
    }
}

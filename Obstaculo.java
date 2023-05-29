package game2;

import java.awt.*;

public class Obstaculo {

    public final int ANCHO = 50;
    public final int ALTO = 100;
    static int inc_x = -5;
    static int x1 = 1200;
    static int x2 = -50;
    int y = 250;

    Juego jueguito;

    public Obstaculo(Juego jueguito) {
        this.jueguito = jueguito;
    }

    public void mover() {
        if (x1 < -50 && x2 > 1200) {
            jueguito.puntos++;
            x1 = 1200;
            x2 = -50;

            if (jueguito.puntos == 3 || jueguito.puntos == 6 || jueguito.puntos == 9 || jueguito.puntos == 12) {
                inc_x -= 2;
                jueguito.nivel++;
            }
        } else {
            if (colision(x1) || colision(x2)) {
                if (jueguito.vidas == 0) {
                    jueguito.finJuego();
                } else {
                    jueguito.pierdeVida();
                }
            }
            x1 += inc_x;
            x2 -= inc_x;
        }
    }

    public boolean colision(int x) {
        return jueguito.personaje1.getBounds().intersects(getBounds(x));
    }

    public void paint(Graphics2D g) {
        g.fillRect(x1, y, ANCHO, ALTO);
        g.fillRect(x2, y, ANCHO, ALTO);
    }

    public Rectangle getBounds(int x) {
        return new Rectangle(x - 5, y, ANCHO, ALTO);
    }
}


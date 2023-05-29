package game2;

import java.beans.IntrospectionException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Main extends Juego{
    public static int reiniciaJuego = -1;


    public static void main(String[] args) throws InterruptedException, IntrospectionException {
        JOptionPane.showMessageDialog(null, "Iniciando Juego");
        JFrame ventana = new JFrame("Juego Grafico");
        Main jueguito = new Main();
        ventana.add(jueguito);
        ventana.setSize(1200, 400);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            if (jueguito.juegoFinalizado) {
                reiniciaJuego = JOptionPane.showConfirmDialog(null, "Haz perdido, ¿Quieres jugr otra vez?", "Haz Perdido", JOptionPane.YES_OPTION);
                if (reiniciaJuego == 0) {
                    jueguito.juegoFinalizado = false;
                    Obstaculo.inc_x = -5;
                    Obstaculo.x1 = 100;
                    Obstaculo.x2 = 1200;
                    jueguito.puntos = 0;
                    jueguito.nivel = 1;
                    jueguito.vidas = 3;
                    reiniciaJuego = -1;
                } else if (reiniciaJuego == 1) {
                    System.exit(0);
                }
            } else{
                jueguito.repaint();
                Thread.sleep((10));
                if (jueguito.pierdeVida) {
                    JOptionPane.showMessageDialog(null, "Cuidado Pierdes vidas");
                    jueguito.pierdeVida = false;
                    jueguito.vidas --;
                    Obstaculo.x1 = 100;
                    Obstaculo.x2 = 1200;
                }
            }
        }
    }
}
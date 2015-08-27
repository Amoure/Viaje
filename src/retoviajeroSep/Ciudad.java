
package retoviajeroSep;
import java.awt.*;

public class Ciudad {
    RetoViajero app;
    int cx, cy;
    Color c;
    int tamaño;
    
    Ciudad(int cx, int cy, Color c, int tamaño){
        this.cx=cx;
        this.cy=cy;
        this.app=app;
        this.tamaño=tamaño;
        this.c=c;
    }
    
    void pintarCiudad(Graphics g){
        g.fillOval(cx, cy, tamaño, tamaño);
    }
}

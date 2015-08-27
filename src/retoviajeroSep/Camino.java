package retoviajeroSep;
import java.awt.*;

public class Camino {
    Ciudad ciudadO;
    Ciudad ciudadD;
    int distancia;
    
    
    Camino(Ciudad o,Ciudad d, int distancia){
        ciudadO=o;
        ciudadD=d;
        this.distancia=distancia;
        //System.out.println("Nuevo camino");
    }
    
    void pintarCamino(Graphics g){
        g.drawLine(ciudadO.cx, ciudadO.cy, ciudadD.cx, ciudadD.cy);
    }
}

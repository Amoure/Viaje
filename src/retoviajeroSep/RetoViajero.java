/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package retoviajeroSep;

import java.applet.Applet;
import java.awt.*;

/**
 *
 * @author Vespertino
 */
public class RetoViajero extends Applet {
    Mapa m;
    int tamaño=5;
    int tamañoID=10;
    
    public void init() {
        setBackground(Color.orange);
        m= new Mapa(this);
    }
    public void paint(Graphics g){
        m.pintarMapa(g);
    }
}


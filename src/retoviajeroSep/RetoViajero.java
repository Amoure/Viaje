/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package retoviajeroSep;

import java.applet.Applet;
import java.awt.*;
import java.util.*;

/**
 *
 * @author Vespertino
 */
public class RetoViajero extends Applet implements Runnable{
    Mapa m;
    int tamaño=5;
    int tamañoID=10;
    Thread hilo;
    ArrayList cRecorridas=new ArrayList(); 
    
    public void init() {
        setBackground(Color.orange);
        m= new Mapa(this);
    }
    
    public void start(){
        //System.out.println("Metodo start");
        if(hilo==null){
            hilo= new Thread(this);
            hilo.start();
        }
    }
    public void stop(){
        //System.out.println("Metodo stop");
        if(hilo!=null)
            hilo=null;
    }
    public void run(){
        //System.out.println("Metodo run");
        Thread hiloActual=Thread.currentThread();
        while(hilo==hiloActual){
            try{
                Thread.sleep(40);
                cRecorridas=m.cRecorridas;
                System.out.print("Camino recorrido: ");
                for(int i=0;i<cRecorridas.size();i++){
                    //while((int)cRecorridas.elementAt(i)!=1051){
                        System.out.print(cRecorridas.get(i)+"--");
                    //m.recorridoOut();
                    //}
                }  
                stop();
            }catch(InterruptedException e){}
            
        }
        
    }
    public void paint(Graphics g){
        //System.out.println("Metodo paint");
        m.pintarMapa(g);
        
        //m.recorridoOut();
        
    }
}


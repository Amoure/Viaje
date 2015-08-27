/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retoviajeroSep;
import java.awt.*;
/**
 *
 * @author Mago
 */
public class Recorrido {
    Camino caminos[];
    Ciudad origen;
    Ciudad destino;
    Camino caminor[];
    public Recorrido(Ciudad origen, Ciudad destino,Camino caminos[]){
        this.origen=origen;
        this.destino=destino;
        this.caminos= caminos;
        //System.out.println("Nuevo recorrido"+origen+destino+",");
    }
    void calcularDistancia(){
        
    }
    void calcularRecorrido(){
        
        
    }
    Camino elegirCamino(Ciudad c){
        Camino caminosP[]=caminosPosibles(c);
        Camino elegido=caminosP[0];/*
        for(int i=0; caminosP[i].ciudadD!=null; i++){
            if(caminosP[i].distancia<elegido.distancia){
                elegido.distancia=caminosP[i].distancia;
            }
        }*/
        return elegido;
        
    }
    
    Camino[] caminosPosibles(Ciudad c){
        
        int numeroP=0;
        for(int i=0;i<=caminos.length;i++){
            if(caminos[i].ciudadO==c){
                numeroP++;
                //System.out.println("Posible");
            }
        }
        //System.out.println("Numero posibles"+numeroP);
        Camino caminosP[]=new Camino[numeroP];
        /*
        int contador=0;
        for(int i=0;i<caminos.length;i++){
            if(caminos[i].ciudadO==c){
                caminosP[contador]=caminos[i];
                contador++;
                System.out.println("Nuevo camino añadido");
            }
        }*/
        return caminosP;
        
        
        /*Camino c=new Camino(null,null,0);
        
        for(int i=0; caminos[i].ciudadD!=destino;i++){
            if(caminos[i].ciudadO==origen){
                //System.out.print("Camino encontrado");
                if(c.ciudadO==null||c.distancia<caminos[i].distancia)
                    c=caminos[i];
            }
            
        }*/
    }
        
    void calcularMenorX(){
        if(origen.cx<=destino.cx){
            System.out.println("Origen menor");
        }
        else
            System.out.println("Origen mayor");
    }
    void calcularMenorY(){
        if(origen.cx<=destino.cx){
            System.out.println("Origen menor");
        }
        else
            System.out.println("Origen mayor");
    }
    void pintarRecorrido(Graphics g){
        Camino pintar=elegirCamino(origen);
        g.setColor(Color.WHITE);
        pintar.pintarCamino(g);
        
    }
    
}

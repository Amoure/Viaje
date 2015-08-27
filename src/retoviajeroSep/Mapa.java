package retoviajeroSep;
import java.io.*;
import java.util.*;
import java.awt.*;

public class Mapa {
    
    RetoViajero app;
    int ciudades[][];
    int caminos[][];
    int tamañoCi;
    Color cCiudades;
    ArrayList<StringTokenizer> coordenadas;
    int numeroCi;
    int numeroCa;
    int tamañoCiID;
    int cOrigen;
    int cDestino;
    Recorrido re;
    Vector cRecorridas=new Vector(); 
    int distanciaR;
    
    public Mapa(RetoViajero app){
        this.app=app;
        tamañoCi=app.tamaño;
        numeroCi=obtenerNumeroCiudades();
        tamañoCiID=app.tamañoID;
        coordenadas=obtenerPosicion();
        numeroCa=Integer.parseInt(coordenadas.get(2).nextToken());
        distanciaR=0;
        
        System.out.println("Numero Caminos: "+numeroCa);
        
        ciudades=new int[numeroCi+1][2];   
        caminos=new int[numeroCi+1][numeroCi+1];
        
        
        
        crearCiudades();
        //getCoordenadas();
        crearCaminos();
        obtenerOrigenDestino();
        System.out.println("Ciudades O y D: "+cOrigen+"|"+cDestino); 
        //System.out.print(caminos[0]);
        //System.out.println(ciudades[20].cx);
        //calcularDistancia(cOrigen, cDestino);
        
        
    }
    
    public void crearCiudades(){
        int contador=1;
        
            for(int i=6; i<(numeroCi+3)*2; i++){
                int x=0;
                int y=0;

                if(i%2==0){
                    x=(Integer.parseInt((coordenadas.get(i)).nextToken()));
                    y=(Integer.parseInt((coordenadas.get(i)).nextToken()));
                    
                    
                    ciudades[contador][0]=x; 
                    ciudades[contador][1]=y;
                    //System.out.println("ciudad:"+ciudades[contador][0]);
                    contador++;
                }   


            }
           
        
        System.out.println("Ciudades contadas:"+contador);
        //System.out.println(ciudades[contador-1].cx);
    } 
    
    public void crearCaminos(){
        
        int contador=1;
        //caminos[0]=new Camino(ciudades[1],ciudades[1]);
        /*for(int i=0; i==numeroCi;i++){
          for(int j=0;j==numeroCi;j++){   
        */
            for(int i=(numeroCi+3)*2; i<coordenadas.size(); i++){
                int origen=0;
                int destino=0;
                int distancia;
                //contador ++;
                //System.out.println("Caminos contados:"+contador);
                  
                if(i%2==0){
                    origen=(Integer.parseInt((coordenadas.get(i)).nextToken()));
                    destino=(Integer.parseInt((coordenadas.get(i)).nextToken()));                    
                    distancia=(Integer.parseInt((coordenadas.get(i)).nextToken()));
                    
                    //System.out.println("C: "+contador);
                    caminos[origen][destino]=distancia; 
                    //caminos[destino][origen]=distancia;
                    contador++;
                    
                    //System.out.println(origen+"+"+destino+","+distancia);
                    //(((numeroCi+3)*2)+numeroCa*2)-1
                }   

            
            }
          
            
           System.out.println("Caminos contados:"+contador);
           //System.out.println("Camino"+caminos[1][84]);
        /*
        for(int i=0; i==numeroCi; i++){
            for(int j=0; j==numeroCi; j++){
                
            }
        }*/
        
    } 
    
    
    public static ArrayList obtenerPosicion(){
            String rutaFichero = "entrada.txt";
            ArrayList<StringTokenizer> ar = new ArrayList<>();
                try {
                        FileReader fr = new FileReader(rutaFichero);
                        BufferedReader br = new BufferedReader(fr);
                        String linea;
                        
			while((linea=br.readLine())!=null){
                            ar.add(new StringTokenizer(linea));
                        }
                        br.close();
                } catch (IOException e) {
                        System.out.println("Error---" + e.toString());
                }
            /*    
            System.out.println(Integer.parseInt(ar.get(0).nextToken()));
            System.out.println(Integer.parseInt(ar.get(2).nextToken()));
            System.out.println(Integer.parseInt(ar.get(4).nextToken()));
            System.out.println(Integer.parseInt(ar.get(6).nextToken()));
            System.out.println(Integer.parseInt(ar.get(8).nextToken()));
            System.out.println(Integer.parseInt(ar.get(10).nextToken()));*/
            return ar;    
    }
    void pintarMapa(Graphics g){
        
        for(int i=0; i<numeroCi; i++){
            this.pintarCiudades(g,i);
            //System.out.println(i);
            
        }
        pintarCaminos(g);
        pintarCiudadesI(g);
        pintarRecorrido(g);
        pintarDistancia(g);
        /*
        for(int i=0;i<cRecorridas.size();i++){
            System.out.print(cRecorridas.elementAt(i)+"--");
        }*/
        //System.out.println("Distancia recorrida: "+distanciaR);
    }/*
    void pintarRecorrido(Graphics g){
        re=new Recorrido(ciudades[cOrigen], ciudades[cDestino], caminos);
        
        re.pintarRecorrido(g);
    }*/
    void pintarCiudades(Graphics g, int i){
        g.fillOval(ciudades[i][0], ciudades[i][1], app.tamaño, app.tamaño);
    }
    void pintarCaminos(Graphics g){
        for(int i=0; i<= 1053; i++){
            for(int j=0; j<=1053; j++){
                if(caminos[i][j]!=0){
                    //System.out.println(i+" "+caminos[i][j]+" "+ciudades[i][0]+" "+ciudades[i][1]+" "+ciudades[j][0]+" "+ciudades[j][1]);
                    g.drawLine(ciudades[i][0], ciudades[i][1], ciudades[j][0], ciudades[j][1]);
                }
            }    
        }
    }
    
    void obtenerOrigenDestino(){      
        
            cOrigen=Integer.parseInt(coordenadas.get(4).nextToken());
            cDestino=Integer.parseInt(coordenadas.get(4).nextToken());              
    
    }
   
    public void pintarCiudadesI(Graphics g){
        
        g.setColor(Color.GREEN);
        g.fillOval(ciudades[cOrigen][0], ciudades[cOrigen][1], tamañoCiID, tamañoCiID);
        g.setColor(Color.RED);
        g.fillOval(ciudades[cDestino][0], ciudades[cDestino][1], tamañoCiID, tamañoCiID);
    }
    
    public int obtenerNumeroCiudades(){
        String ruta="entrada.txt";
        int numero=0;
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);     

            numero=Integer.parseInt(br.readLine());
            System.out.println("Numero Ciudades:"+numero);
            br.close();
            
         } catch (IOException e) {
            System.out.println("Error---" + e.toString());
         }
        return numero;
    }
    
    public int calcularPosibles(int cActual){
        int ciudadSig=0;        
        //int ciudadAnt=cActual;
        
        for(int i=0; i<= 1053; i++){
            
            
            
            if(caminos[cActual][i]!=0||caminos[i][cActual]!=0&&cRecorridas.contains(i)==false){
                
                
                if(ciudadSig==0){
                    ciudadSig=i;
                    //ciudadAnt=i;
                    //System.out.println("Elegida1: "+ciudadSig+"-");                    
                }                
                else{
                    if(calcularDistancia(ciudadSig, cDestino)>calcularDistancia(i, cDestino)){
                        ciudadSig=i;
                        //System.out.println("Elegida2: "+ciudadSig+"-");  
                    }/*
                    else{
                        ciudadSig=calcularPosibles(ciudadAnt);
                    }
                       */ 
                }
                
                /*int disPos=calcularDistancia(caminos[cActual][i], cDestino);
                {
                    distanciaA=disPos;
                    ciudadSig=caminos[cActual][i];
                }*/
                
                
            }
            
                
        }
        return ciudadSig;
    }
    
    public void pintarRecorrido(Graphics g){
        int ciudadActual=cOrigen;
        //System.out.println("Salida: "+ciudadActual);
        
        g.setColor(Color.white);
        
        while(ciudadActual!=cDestino){
            int ciudadSig=calcularPosibles(ciudadActual);
            //System.out.println("Voy a ir a: "+ciudadSig);
            g.drawLine(ciudades[ciudadActual][0], ciudades[ciudadActual][1], ciudades[ciudadSig][0], ciudades[ciudadSig][1]);  
            distanciaR+=caminos[ciudadActual][ciudadSig];
            //System.out.println("Distancia recorrida: "+distanciaR);
            ciudadActual=ciudadSig;
            //System.out.print(ciudadActual);
            cRecorridas.addElement(ciudadActual);       
        }
        
    }
    
    public int calcularDistancia(int cO,int cD){    
        int xO= ciudades[cO][0];
        int yO= ciudades[cO][1];
        int xD= ciudades[cD][0];
        int yD= ciudades[cD][1];
        int distancia=0;
        if(xO>=xD){
            if(yD>=yO){
                int cateto1=xO-xD;
                int cateto2=yD-yO;
                distancia= (int)Math.sqrt(cateto1*cateto1+cateto2*cateto2);
                //System.out.println("Distancia1: "+distancia);
                //System.out.println(Math.sqrt(2*2+2*2));
               
            } 
            if(yO>yD){
                int cateto1=xO-xD;
                int cateto2=yO-yD;
                distancia= (int)Math.sqrt(cateto1*cateto1+cateto2*cateto2);
                //System.out.println("Distancia2: "+distancia);
                
            }
        }
        
        if(xO<xD){
            if(yO<=yD){
                int cateto1=xD-xO;
                int cateto2=yD-yO;
                distancia= (int)Math.sqrt(cateto1*cateto1+cateto2*cateto2);
                //System.out.println("Distancia3: "+distancia);
                //System.out.println(Math.sqrt(2*2+2*2));
                
            }
            if(yD<yO){
                int cateto1=xD-xO;
                int cateto2=yO-yD;
                distancia= (int)Math.sqrt(cateto1*cateto1+cateto2*cateto2);
                //System.out.println("Distancia4: "+distancia);
                //System.out.println(Math.sqrt(2*2+2*2));
                
            }
        }
        
        
        return distancia;
    }
    
    public void recorridoOut(){
        for(int i=0;i<cRecorridas.size();i++){
            System.out.print(cRecorridas.elementAt(i)+"--");
        }
    }
    void pintarDistancia(Graphics g){
        String dis="Distancia recorrida: "+Integer.toString(distanciaR);
        g.setColor(Color.BLACK);
        g.setFont(null);
        g.drawString(dis, app.getWidth()-400, app.getHeight()-50);
    }
}

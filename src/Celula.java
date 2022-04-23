import java.util.Stack;

public class Celula {
    private char caracter;

    private int abssisa;
    private int ordenada;
    public boolean obstaculo = false; 

    private Stack<Celula> vizinhos;



    public Celula(char caracter, int abssisa, int ordenada){
        this.caracter = caracter;
        this.abssisa = abssisa;
        this.ordenada = ordenada;


    }

    public int getAbssisa(){
        return this.abssisa;
    }

    public int getOrdenada(){
        return this.ordenada; 
    }


    public char getCaracter(){
        return this.caracter;
    }

    public void setCaracter(char caracter){
        this.caracter = caracter;
    }


    public Stack<Celula> getVizinhos(){
        return this.vizinhos;
    }

    public void setVizinhos(){
        
    }
}

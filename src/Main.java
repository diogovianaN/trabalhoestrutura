import java.util.Stack;

public class Main{
    public static void main(String args[]){
    int coluna = 20;
    int linha = 20;
    Stack<Stack<Celula>> matriz = new Stack<Stack<Celula>>();


    Celula inicio = new Celula('S', 1, 1);
    inicio.obstaculo = false; 
    

    Celula fim = new Celula('F', 1, coluna-2);
    fim.obstaculo = false; 

    for(int i = 0; i < coluna; i++){
        matriz.push(new Stack<Celula>());
    }

    for(int i = 0; i < coluna; i++){
        for(int j = 0; j < linha; j++){
            if(i == 1 && j == 1){
                matriz.get(i).push(inicio);
            }
            else if(i == 1 && j == coluna - 2){
               matriz.get(i).push(fim);
            } 
            else {
                matriz.get(i).push(new Celula(' ', i, j));
            }
            
        }
       
    }

    

    setObstaculos(matriz, linha, coluna);
    //inicio do loop
    int i = 2;
    int j = 1;
    Stack<Celula> pilhaFinal = new Stack<>();
    Stack<Integer> direcao = new Stack<>();
    direcao.push(2);
    direcao.push(3);
    direcao.push(4);

    while(true){

    
            char celula = matriz.get(i).get(j).getCaracter();  //inicio  matriz[i][j]
            if (celula != 'S'){
                //if(!matriz.get(i).get(j).obstaculo){

                while(matriz.get(i + 1).get(j).getCaracter() != '#' && matriz.get(i + 1).get(j).getCaracter() != 'F'){
                    System.out.println("Baixo");
                    i++;
                    pilhaFinal.push(matriz.get(i).get(j));
                    esvaziaPilha(direcao);

                }

                direcao.push(1);

                while(matriz.get(i).get(j + 1).getCaracter() != '#' && matriz.get(i + 1).get(j).getCaracter() != 'F') {
                    System.out.println("Direita");
                    j++;
                    pilhaFinal.push(matriz.get(i).get(j));
                    esvaziaPilha(direcao);

                }

                direcao.push(2);
                

                while(matriz.get(i - 1).get(j).getCaracter() != '#' && matriz.get(i + 1).get(j).getCaracter() != 'F'){
                    System.out.println("Cima");
                    i--;
                    pilhaFinal.push(matriz.get(i).get(j));
                    esvaziaPilha(direcao);


                }
                direcao.push(3);

                while(matriz.get(i).get(j - 1).getCaracter() != '#' && matriz.get(i + 1).get(j).getCaracter() != 'F'){
                    System.out.println("Esquerda");
                   j--;
                   pilhaFinal.push(matriz.get(i).get(j));
                   esvaziaPilha(direcao);
                }

                direcao.push(4);

                celula = matriz.get(i).get(j).getCaracter();

                    

         }

         if(finalDoLabirinto(celula)){

            for(int l = 0; l < pilhaFinal.size(); l++){
                matriz.get(pilhaFinal.get(l).getAbssisa()).get(pilhaFinal.get(l).getOrdenada()).setCaracter('.');
            }
             break;
         }

        //i++;
        if(breakLoop(i, j, linha, coluna)){
            System.out.println("Sem saida");
            break;
        }

    } //fim do loop
    

    
    printaMatriz(matriz, linha, coluna);
    }


    public static void setObstaculos(Stack<Stack<Celula>> matriz, int linha, int coluna){

        for(int i = 0; i < coluna; i++){
            for(int j = 0; j < linha; j++) {

                //inicio grade
                matriz.get(0).get(j).setCaracter('#');
                matriz.get(0).get(j).obstaculo = true;

                matriz.get(i).get(0).setCaracter('#');
                matriz.get(i).get(0).obstaculo = true;

               matriz.get(linha-1).get(j).setCaracter('#');
               matriz.get(linha-1).get(j).obstaculo = true;

               matriz.get(i).get(coluna-1).setCaracter('#');
               matriz.get(i).get(coluna-1).obstaculo = true;

               //fim grade

               //inicio obstaculos
               matriz.get(i % 18).get(2).setCaracter('#');
               matriz.get(i % 18).get(2).obstaculo = true;

               for(int k = 2; k < coluna - 3; k++){
                 matriz.get(17).get(k).setCaracter('#');
                 matriz.get(17).get(k).obstaculo = true;
               }

               matriz.get(i % 18).get(coluna - 3).setCaracter('#');
               matriz.get(i % 18).get(coluna - 3).obstaculo = true;
               

            //    matriz.get(linha-1).get(j).setCaracter('#');
            //    matriz.get(linha-1).get(j).obstaculo = true;

            //    matriz.get(i).get(coluna-1).setCaracter('#');
            //    matriz.get(i).get(coluna-1).obstaculo = true;


               //fim obstaculos
    
            }
        }

    }


    public static void printaMatriz(Stack<Stack<Celula>> matriz, int linha, int coluna) {
        for(int i = 0; i < coluna; i++){
            for(int j = 0; j < linha; j++) {
                System.out.print(matriz.get(i).get(j).getCaracter());
    
            }
           System.out.println();
        }
    }

    public static boolean breakLoop(int i, int j, int coluna, int linha){
        
        if(i > linha - 2 || j > coluna - 2) {
            System.out.println("I ou J maximo");
            return true;
        } 
        else if(i < 1 || j < 1){
            System.out.println("I ou J minimo");
            return true;
        }

        return false;
    }

    public static boolean finalDoLabirinto(char celula){
        //final
        if (celula == 'F'){
            System.out.println("Final ");
            return true;
        }

        return false;
    }

                    
    public static void esvaziaPilha(Stack<Integer> direcao){
        if(direcao.size() > 0) {
            for(int i = 0; i < direcao.size(); i++){
                direcao.pop();
            }
        }
    } 
}
package loteria;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Loteria {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int[] valores = new int[] {0, 0, 0, 0, 0, 0};
        //int[] valores2 = new int[6];
        
        imprimeVetor(valores);

        System.out.println("Digite 6 números");
        for (int i = 0; i < 6; i++) {
            int num = -1;
            while (num == -1){
                num = capNum(in, i);
                for (int j = 0; j < i; j++) {
                    if (valores[j] == num) {
                        num = -1;
                        break;
                    }
                }
            }   
            valores[i] = num; 
        }
        
        System.out.println("Seus números são:");
        imprimeVetor(valores);
        
        int[] bolas = sortear();
        
        System.out.println("Os números sorteados são:");
        imprimeVetor(bolas);
        
        verificarSorteio(valores, bolas);
        
    }
    
    public static int capNum(Scanner in, int i) {
        
        System.out.println("Digite o " + (i + 1) + "º Número");
        int num = in.nextInt();
        
        if (num >=1 && num <= 60)
            return num;
        else
            return -1;
       
    }
    
    public static void imprimeVetor(int[] vet){
        for (int i = 0; i < vet.length; i++) {
            System.out.print(vet[i] + " ");
        }
        System.out.println();
    }
    
    public static int[] sortear(){
        Random r = new Random();
        int[] bolas = new int[] {0, 0, 0, 0, 0, 0};        
        for (int i = 0; i < 6; i++) {           
            int bola = r.nextInt(60) + 1;            
            for (int j = 0; j <= i; j++) {
                if (bolas[j] == bola) {
                    i -= 1;
                    break;
                } else {
                    bolas[i] = bola;
                    break;
                }
            }    
        }
        return bolas;
    }
    
    public static void verificarSorteio(int[] valores, int[] bolas){
        int quantAcertos = 0;
        boolean[] acertos = new boolean[] {false, false, false, false, false, false};
        
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (valores[i] == bolas[j]){
                    acertos[j] = true;
                    quantAcertos++;
                    break;
                }
            }
        }
        
        if (quantAcertos > 0){
            if (quantAcertos == 1){
                System.out.println("Você acertou um número");
                for (int i = 0; i < 6; i++) {
                    if (acertos[i] == true)
                        System.out.println("Você acertou a bola " + (i + 1));
                }
            }   
            else{
                System.out.println("Você acertou " + quantAcertos + " números");
                System.out.print("Você acertou as bolas ");
                for (int i = 0; i < 6; i++) {
                    if (acertos[i] == true)
                        System.out.print((i + 1) + " ");
                }
            }  
        }
        else
            System.out.println("Você errou todos os números.");
        
    }
    
}

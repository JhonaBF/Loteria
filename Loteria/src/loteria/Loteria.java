package loteria;

import java.util.Scanner;

public class Loteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Digite 6 números");
        for (int i = 0; i < 6; i++) {
            capNum(in, i);
        }
        
    }
    
    public static int capNum(Scanner in, int i) {
        System.out.println("Digite o " + (i + 1) + "º Número");
        return 0;
    }
    
}

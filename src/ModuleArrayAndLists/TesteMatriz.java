package ModuleArrayAndLists;

import java.util.Scanner;

public class TesteMatriz {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [][] mat = new int[n][n];

        for (int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[i].length; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Main diagonal:");
        for (int i = 0; i<n; i++){
            System.out.println(mat[i][i] + " ");
        }
        System.out.println();

        int cont = 0;

        for (int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[i].length; j++) {
                if(mat[i][j] < 0){
                    cont++;
                }
            }
        }
        System.out.println("Negative numbers = " + cont);

        // para ver a quantidade de colunas é mat[i].lenght


        sc.close();

    }
}

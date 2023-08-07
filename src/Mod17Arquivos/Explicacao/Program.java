package Mod17Arquivos.Explicacao;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        File file = new File("c:\\temp\\in.txt"); // o \ normal é indicativo de caracteres especiais, para indicar que é uma barra mesmo, coloca \\

        Scanner sc = null;

        try {
            sc = new Scanner(file);
            while(sc.hasNextLine()){ // se existir uma proxima linha no arquivo
                System.out.println(sc.nextLine()); // manda imprimir a proxima linha
            }

        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            if(sc != null) { // aqui está sendo fechado o scanner, caso dê algum erro e pule para o catch, ele é fechado no final, mas precisa colocar o if para saber se o scanner foi
                //aberto no começo, caso tenha acontecido algum erro e o scanner nao foi aberto, aqui poderia dar uma NullPointerException sem o If.
                sc.close();
            }
        }
    }
}

package Mod17Arquivos.Explicacao;

import java.io.File;
import java.util.Scanner;

public class Program5 {
    public static void main(String[] args) {

        // como obter informações do caminho do arquivo

        Scanner sc = new Scanner(System.in);

        System.out.println("Entre o caminho do arquivo: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        System.out.println("getName: " + path.getName()); //só o nome do arquivo
        System.out.println("getParent: " + path.getParent()); // só o caminho
        System.out.println("getPath: " + path.getPath()); // caminho inteiro

        sc.close();

    }
}

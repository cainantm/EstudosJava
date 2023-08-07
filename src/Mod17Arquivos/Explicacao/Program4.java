package Mod17Arquivos.Explicacao;

import java.io.File;
import java.util.Scanner;

public class Program4 {
    public static void main(String[] args) {

        // manipulação de pastas

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite uma pasta: ");
        String strPath = sc.nextLine();

        File path = new File(strPath); // variável tipo File pode ser tanto o caminho de um arquivo, como o caminho de uma pasta

        File[] folders = path.listFiles(File::isDirectory); // função para criar um vetor do que somente é pasta no path

        System.out.println("Pastas");
        for (File folder : folders){
            System.out.println(folder);
        }

        File[] files = path.listFiles(File::isFile);
        System.out.println();
        System.out.println("Arquivos");
        for (File file : files){
            System.out.println(file);
        }

        boolean sucesso = new File(strPath + "\\subdir").mkdir(); // esse comando vai criar essa subpastas subdir a partir do caminho do path

        System.out.println("Diretorio criado com sucesso: " + sucesso);


        sc.close();

    }
}

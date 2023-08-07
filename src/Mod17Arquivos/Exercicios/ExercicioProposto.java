package Mod17Arquivos.Exercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ExercicioProposto {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.println("Enter file path: ");
        String sourceFilestr = sc.nextLine();

        File sourceFile = new File(sourceFilestr);
        String sourceFolderStr = sourceFile.getParent(); // pegar o caminho de pastas, desprezando o nome do arquivo

        boolean success = new File(sourceFolderStr + "\\out").mkdir(); // criando a pasta out que é necessária para o output

        String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFilestr))) { // arquivo de leitura

            String itemCsv = br.readLine(); // lendo a primeira linha do arquivo
            while(itemCsv != null){ // fazendo loop para ler todas as linhas

                String[] fields = itemCsv.split(","); // criando vetor com os itens da linha, quebrando a partir da virgula
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                list.add(new Product(name, price, quantity));

                itemCsv = br.readLine(); // depois passa para proxima linha
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) { //arquivo de escrita
                for (Product item : list){
                    bw.write(item.getName() + ", " + String.format("%.2f", item.total())); // escrevendo o que vai aparecer no arquivo de saída
                    bw.newLine();
                }
                System.out.println(targetFileStr + " Created " + success);
            }catch (IOException e){
                System.out.println("Error writing file: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }


        sc.close();

    }
}

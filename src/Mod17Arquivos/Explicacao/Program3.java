package Mod17Arquivos.Explicacao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program3 {

    public static void main(String[] args) {

        String[] lines = new String[] {"Good Morning", "Good afternoon", "Good night"};

        String path = "c:\\temp\\out.txt";

        //aqui cria um arquivo com os textos do vetor

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))) { // deixando sem o true no FileWriter, ele vai recriar o arquivo toda vez que rodar,
            // com o true, ele só vai escrever novamente no arquivo ja criado
            for (String line : lines){
                bw.write(line); // para escrever o texto
                bw.newLine(); // quebra de linha
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}

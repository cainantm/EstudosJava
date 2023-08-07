package Mod17Arquivos.Explicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program2 {

    public static void main(String[] args) {

        // tudo que está comentado foi tirado, pois foi feito agora com try with resources

        String path = "c:\\temp\\in.txt";
//        FileReader fr = null;
//        BufferedReader br = null;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
//            fr = new FileReader(path);
//            br = new BufferedReader(fr); // é instanciado a partir da stream basica

            String line = br.readLine(); // fazendo a leitura da linha

            while(line != null){ // enquanto não foi a última linha, ele vai continuar lendo
                System.out.println(line);
                line = br.readLine();
            }

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
//        finally { // aqui pode ocorrer uma exceção na hora de fechar as streams, então precisa de outro bloco try
//            try {
//                if (br != null) {
//                    br.close();
//                }
//                if (fr != null) {
//                    fr.close();
//                }
//            } catch (IOException e){
//                e.printStackTrace();
//            } // comentado para usar o try with resources
        }

    }

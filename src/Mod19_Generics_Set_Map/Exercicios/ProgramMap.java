package Mod19_Generics_Set_Map.Exercicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ProgramMap {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> voto = new LinkedHashMap<>();

        System.out.println("Informe o local do arquivo: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();
            while (line != null){

                String[] fields = line.split(",");
                String name = fields[0];
                int count = Integer.parseInt(fields[1]);

                if (voto.containsKey(name)){
                    int votosAtual = voto.get(name);
                    voto.put(name, count + votosAtual);
                } else {
                    voto.put(name, count);
                }

                line = br.readLine();
            }

            for (String key : voto.keySet()){
                System.out.println(key + ": " + voto.get(key));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sc.close();
    }
}

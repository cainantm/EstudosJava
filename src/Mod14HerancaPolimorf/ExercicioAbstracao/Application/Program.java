package Mod14HerancaPolimorf.ExercicioAbstracao.Application;

import Mod14HerancaPolimorf.ExercicioAbstracao.Entities.Circle;
import Mod14HerancaPolimorf.ExercicioAbstracao.Entities.Enums.Colors;
import Mod14HerancaPolimorf.ExercicioAbstracao.Entities.Rectangle;
import Mod14HerancaPolimorf.ExercicioAbstracao.Entities.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Shape> list = new ArrayList<>();

        System.out.print("Enter the number of shapes: ");
        int n = sc.nextInt();

        for (int i = 1; i<=n; i++){
            System.out.println("Shape #" + i + " data: ");
            System.out.print("Rectangle or Circle (r/c): ");
            char c = sc.next().charAt(0);
            System.out.println("Color (BLACK, BLUE, RED): ");
            Colors color = Colors.valueOf(sc.next());

            if (c == 'r'){
                System.out.print("Width: ");
                double width = sc.nextDouble();
                System.out.print("Height: ");
                double height = sc.nextDouble();
                list.add(new Rectangle(color, width, height));
            } else {
                System.out.print("Radius: ");
                double radius = sc.nextDouble();
                list.add(new Circle(color, radius));
            }

        }

        System.out.println();
        System.out.println("Shape Areas:");
        for(Shape shape : list){
            System.out.printf("%.2f%n", shape.area());
        }

        sc.close();
    }
}

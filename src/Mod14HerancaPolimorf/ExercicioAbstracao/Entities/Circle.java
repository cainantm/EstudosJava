package Mod14HerancaPolimorf.ExercicioAbstracao.Entities;

import Mod14HerancaPolimorf.ExercicioAbstracao.Entities.Enums.Colors;

public class Circle extends Shape{

    private Double radius;

    public Circle(){

    }

    public Circle(Colors color, Double radius) {
        super(color);
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

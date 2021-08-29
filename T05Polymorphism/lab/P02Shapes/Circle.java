package T05Polymorphism.lab.P02Shapes;

public class Circle extends Shape {
    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        Double result = 2 * (Math.PI * this.radius);
        super.setPerimeter(result);
    }

    @Override
    public void calculateArea() {
        Double result = Math.PI * Math.pow(this.radius, 2);
        super.setArea(result);
    }

    public final Double getRadius() {
        return radius;
    }
}

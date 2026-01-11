package mod4;

public class ShapeArray {
    public static void main(String[] args) {
        // Instantiate shapes
        Sphere sphere = new Sphere(5.0);
        Cylinder cylinder = new Cylinder(3.0, 7.0);
        Cone cone = new Cone(4.0, 6.0);

        // Store in array
        Shape[] shapeArray = {sphere, cylinder, cone};

        // Loop and print using toString()
        for (Shape s : shapeArray) {
            System.out.println(s.toString());
        }
    }
}
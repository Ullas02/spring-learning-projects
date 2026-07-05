public class Main {

    public static void main(String[] args) {

        Engine engine = new Engine("Petrol");

        Car car = new Car(engine);

        car.drive();
    }
}

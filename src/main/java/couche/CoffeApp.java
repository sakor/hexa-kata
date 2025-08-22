public class CoffeeApp {
  
    public static void main(String[] args) {
        var dao = new BoissonDAO();
        var service = new CoffeeMachineService(dao);
        var controller = new CoffeeMachineController(service);

        controller.run();
    }
  
}

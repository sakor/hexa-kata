import java.util.Scanner;

public class CoffeeMachineController {
    private final CoffeeMachineService service;

    public CoffeeMachineController(CoffeeMachineService service) {
        this.service = service;
    }

    public void run() {
        var scanner = new Scanner(System.in);

        System.out.println("Bienvenue à la machine à café !");
        System.out.println("Choisissez votre boisson (expresso, cappuccino, the) : ");
        var nomBoisson = scanner.nextLine();

        System.out.println("Insérez votre montant : ");
        var amount = scanner.nextDouble();

        var payment = new Payment(amount, "cash");
        var result = service.orderDrink(nomBoisson, payment);

        System.out.println(result);
    }
}

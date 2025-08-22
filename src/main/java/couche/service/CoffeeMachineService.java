public class CoffeeMachineService {
    private final BoissonDAO boissonDAO;

    public CoffeeMachineService(BoissonDAO boissonDAO) {
        this.boissonDAO = boissonDAO;
    }

    public String commanderBoison(String nomBoisson, Payment payment) {
        var boisson = boissonDAO.findByName(nomBoisson);

        if (boisson == null) {
            return "Boisson inconnue.";
        }

        if (payment.getAmount() >= boisson.getPrice()) {
            return "Voici votre " + boisson.getName();
        } else {
            return "Montant insuffisant (Prix : " + boisson.getPrice() + "€)";
        }
    }
}

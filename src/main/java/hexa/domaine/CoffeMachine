public class CoffeeMachine {
  
    private final PaymentPort paymentPort;
    private final DistributeurBoissonPort distributeurPort;
    private final MessagePort messagePort;

    public CoffeeMachine(PaymentPort paymentPort, DistributeurBoissonPort distributeurPort, MessagePort messagePort) {
        this.paymentPort = paymentPort;
        this.distributeurPort = distributeurPort;
        this.messagePort = messagePort;
    }

    public void order(Boisson boisson, Payment payment) {
        if (paymentPort.pay(payment, boisson.price())) {
            distributeurPort.distribut(boisson);
            messagePort.display("Voici votre " + boisson.name());
        } else {
            messagePort.display("Montant insuffisant !");
        }
    }
  
}

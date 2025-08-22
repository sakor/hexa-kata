public interface PaymentPort {
    boolean pay(Payment payment, double amount);
}

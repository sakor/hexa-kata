import java.util.Map;

public class BoissonDAO {
    private static final Map<String, Drink> boissons = new HashMap<>();

    static {
        boissons.put("expresso", new Boisson("Expresso", 1.0));
        boissons.put("cappuccino", new Boisson("Cappuccino", 1.5));
        boissons.put("the", new Boisson("Thé", 1.0));
    }

    public Boisson findByName(String name) {
        return boissons.get(name.toLowerCase());
    }

    public Collection<Boisson> findAll() {
        return boissons.values();
    }
}

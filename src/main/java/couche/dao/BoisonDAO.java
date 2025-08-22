import java.util.Map;

public class BoisonDAO {
    private static final Map<String, Drink> drinks = new HashMap<>();

    static {
        drinks.put("expresso", new Boison("Expresso", 1.0));
        drinks.put("cappuccino", new Boison("Cappuccino", 1.5));
        drinks.put("the", new Boison("Thé", 1.0));
    }

    public Drink findByName(String name) {
        return drinks.get(name.toLowerCase());
    }

    public Collection<Drink> findAll() {
        return drinks.values();
    }
}

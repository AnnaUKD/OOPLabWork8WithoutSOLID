import java.util.ArrayList;
import java.util.List;

public class CafeOrder {

    private static final String[] MENU_NAMES = {"Кава", "Чай", "Круасан", "Тістечко"};
    private static final double[] MENU_PRICES = {45.0, 30.0, 55.0, 70.0};

    private List<String> orderedItems = new ArrayList<>();
    private List<Integer> orderedQtys = new ArrayList<>();
    private List<Double> orderedPrices = new ArrayList<>();


    private String discountType;

    public CafeOrder(String discountType) {
        this.discountType = discountType;
    }


    public void addItem(String itemName, int qty) {
        for (int i = 0; i < MENU_NAMES.length; i++) {
            if (MENU_NAMES[i].equalsIgnoreCase(itemName)) {
                orderedItems.add(itemName);
                orderedQtys.add(qty);
                orderedPrices.add(MENU_PRICES[i]);
                System.out.println("Додано: " + itemName + " x" + qty);
                return;
            }
        }
        System.out.println("Страву не знайдено в меню: " + itemName);
    }


    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < orderedItems.size(); i++) {
            total += orderedPrices.get(i) * orderedQtys.get(i);
        }
        return total;
    }


    public double applyDiscount(double total) {
        if ("volume".equals(discountType)) {
            if (total > 200) {
                System.out.println("Застосовано знижку на обсяг: -10%");
                return total * 0.90;
            }
        } else if ("holiday".equals(discountType)) {
            System.out.println("Застосовано святкову знижку: -15%");
            return total * 0.85;
        }
        return total;
    }

    public void printReceipt() {
        System.out.println("\n========== ЧЕК ==========");
        System.out.println("Кафе 'Затишок'");
        System.out.println("-------------------------");
        for (int i = 0; i < orderedItems.size(); i++) {
            double lineTotal = orderedPrices.get(i) * orderedQtys.get(i);
            System.out.printf("%-10s x%d = %.2f грн%n",
                    orderedItems.get(i), orderedQtys.get(i), lineTotal);
        }
        System.out.println("-------------------------");
        double subtotal = calculateTotal();
        double total = applyDiscount(subtotal);
        System.out.printf("Разом:       %.2f грн%n", total);
        System.out.println("=========================\n");
    }


}
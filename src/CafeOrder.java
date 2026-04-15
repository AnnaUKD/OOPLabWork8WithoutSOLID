import java.util.ArrayList;

// БЕЗ SOLID

public class CafeOrder {

    String[] menuNames  = {"Кава", "Чай", "Круасан", "Тістечко"};
    double[] menuPrices = { 45.0, 30.0, 55.0, 70.0 };

    
    ArrayList<String>  names  = new ArrayList<String>();
    ArrayList<Integer> counts = new ArrayList<Integer>();
    ArrayList<Double>  prices = new ArrayList<Double>();

    String discountType;

    public CafeOrder(String discountType) {
        this.discountType = discountType;
    }


    public void addItem(String name, int count) {
        for (int i = 0; i < menuNames.length; i++) {
            if (menuNames[i].equals(name)) {
                names.add(name);
                counts.add(count);
                prices.add(menuPrices[i]);
                System.out.println("Додано: " + name + " x" + count);
                return;
            }
        }
        System.out.println("Такої страви немає в меню: " + name);
    }


    public double getTotal() {
        double total = 0;
        for (int i = 0; i < names.size(); i++) {
            total = total + prices.get(i) * counts.get(i);
        }
        return total;
    }

    public double applyDiscount(double total) {
        if (discountType.equals("volume")) {
            if (total > 200) {
                System.out.println("Знижка на обсяг: -10%");
                return total * 0.90;
            }
        } else if (discountType.equals("holiday")) {
            System.out.println("Святкова знижка: -15%");
            return total * 0.85;
        }
        return total;
    }

    public void printReceipt() {
        System.out.println("========== ЧЕК ==========");
        System.out.println("Кафе 'Затишок'");
        System.out.println("-------------------------");

        for (int i = 0; i < names.size(); i++) {
            double lineTotal = prices.get(i) * counts.get(i);
            System.out.println(names.get(i) + " x" + counts.get(i) + " = " + lineTotal + " грн");
        }

        System.out.println("-------------------------");
        double subtotal = getTotal();
        double total = applyDiscount(subtotal);
        System.out.println("До сплати: " + total + " грн");
        System.out.println("=========================");
    }
}

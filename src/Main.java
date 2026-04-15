public class Main {
    public static void main(String[] args) {

        System.out.println("=== БЕЗ SOLID ===");

        CafeOrder order = new CafeOrder("volume");
        order.addItem("Кава", 2);
        order.addItem("Круасан", 3);
        order.addItem("Тістечко", 1);
        order.printReceipt();
    }
}

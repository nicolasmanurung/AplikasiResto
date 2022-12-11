public class OrderItem {
    String nameMenu = "";
    float priceMenu = 0;

    int qty = 0;

    OrderItem(String nameMenu, float priceMenu, int qty){
        this.nameMenu = nameMenu;
        this.priceMenu = priceMenu;
        this.qty = qty;
    }
}

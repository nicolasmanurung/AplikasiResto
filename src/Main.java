import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private int sumPeople;

    private String nameBuyer;

    private final int MAX_ORDER = 10;

    private final int DISCOUNT = 10;

    private List<MenuSpecial> listMenuSpecial;

    private List<OrderItem> listOrderItems;

    public static void main(String[] args) {
        Main myObject = new Main();
        Scanner myInput = new Scanner(System.in);

        System.out.println("Selamat siang...");

        System.out.println("Pesan untuk berapa orang : ");
        int sumPeopleInput = myInput.nextInt();
        myObject.setSumPeople(sumPeopleInput);

        System.out.println("Pesanan atas nama : ");
        String nameBuyerInput = myInput.next();
        myObject.setNameBuyer(nameBuyerInput);

        myObject.listMenuSpecial = myObject.setDefaultMenu();
        myObject.showDefaultMenu(myObject.listMenuSpecial);
        System.out.println("\n\n\n");

        myObject.setListOrderItems(myObject.askingBuyerHowMuchTheyOrder(myObject.listMenuSpecial));
        myObject.showingListOrder(myObject.getListOrderItems());
    }


    private void setSumPeople(int sumPeople) {
        this.sumPeople = sumPeople;
    }

    private int getSumPeople(){
        return this.sumPeople;
    }

    private void setNameBuyer(String nameBuyer) {
        this.nameBuyer = nameBuyer;
    }

    private void setListOrderItems(List<OrderItem> listOrderItems) {
        this.listOrderItems = listOrderItems;
    }

    private List<OrderItem> getListOrderItems() {
        return this.listOrderItems;
    }


    private List<MenuSpecial> setDefaultMenu() {
        List<MenuSpecial> listMenu = new ArrayList<>();
        listMenu.add(new MenuSpecial("Nasi Goreng Special ", 9999.99f));
        listMenu.add(new MenuSpecial("Ayam Bakar Spesial ", 12345.67f));
        listMenu.add(new MenuSpecial("Steak Sirloin Spesial ", 21108.40f));
        listMenu.add(new MenuSpecial("Kwetiaw Siram Spesial", 13579.13f));
        listMenu.add(new MenuSpecial("Kambing Guling Spesial", 98765.43));
        return listMenu;
    }

    private void showDefaultMenu(List<MenuSpecial> listMenu) {
        System.out.println("Menu Special hari ini\n==============");
        for (int i = 0; i < listMenu.size(); i++) {
            String menuItem = String.format("\t\t %d. %s \t\t @ Rp. %.2f", i + 1, listMenu.get(i).nameMenu, listMenu.get(i).priceMenu);
            System.out.println(menuItem);
        }
    }

    private List<OrderItem> askingBuyerHowMuchTheyOrder(List<MenuSpecial> listMenu) {
        Scanner myInput = new Scanner(System.in);
        List<OrderItem> listOrder = new ArrayList<>();

        for (int i = 0; i < listMenu.size(); i++) {
            String menuItem = String.format("\t\t %d. %s \t\t @ Rp. %.2f", i + 1, listMenu.get(i).nameMenu, listMenu.get(i).priceMenu);
            System.out.println(menuItem);
            int qtyOrder = myInput.nextInt();

            if (qtyOrder < 0) {
                listOrder.add(new OrderItem(listMenu.get(i).nameMenu, listMenu.get(i).priceMenu, 0));
            } else if (qtyOrder > MAX_ORDER) {
                listOrder.add(new OrderItem(listMenu.get(i).nameMenu, listMenu.get(i).priceMenu, 10));
            } else {
                listOrder.add(new OrderItem(listMenu.get(i).nameMenu, listMenu.get(i).priceMenu, qtyOrder));
            }
        }

        return listOrder;
    }

    private float sumOrder(int qty, float price) {
        return qty * price;
    }

    private void showingListOrder(List<OrderItem> listOrder) {
        float sumOrder = 0;
        float totalDiscount = 0;

        for (int i = 0; i < listOrder.size(); i++) {
            String orderItem = String.format("\t\t %d. %s \t\t %d * @ Rp. %.2f = Rp. %.2f",
                    i + 1, listOrder.get(i).nameMenu,
                    listOrder.get(i).qty,
                    listOrder.get(i).priceMenu,
                    sumOrder(listOrder.get(i).qty, listOrder.get(i).priceMenu));

            if (i == listOrder.size() - 1) {
                System.out.println(orderItem + " +");
                System.out.println("===================================================");
            } else {
                System.out.println(orderItem);
            }
            sumOrder = sumOrder + sumOrder(listOrder.get(i).qty, listOrder.get(i).priceMenu);
        }

        String totalPurchase = String.format("Total Pembelian \t\t\t\t\t = Rp. %.2f", sumOrder);
        System.out.println(totalPurchase);

        totalDiscount = (DISCOUNT * sumOrder) / 100;
        String discount = String.format("\nDisc. %d %% <Masa Promosi> \t\t\t\t\t = Rp. %.2f -", DISCOUNT, totalDiscount);
        System.out.println(discount);

        System.out.println("===================================================");

        float finalPricePerPeople = sumOrder - ((DISCOUNT * sumOrder) / 100);
        String totalPurchaseAfterDiscount = String.format("\nTotal Pembelian setelah discount %d %% \t\t\t\t\t = Rp. %.2f", DISCOUNT, finalPricePerPeople);
        System.out.println(totalPurchaseAfterDiscount);

        float finalPriceForAll = finalPricePerPeople / getSumPeople();
        String totalPurchaseForAll = String.format("\nPembelian per orang <untuk %d orang> \t\t\t\t\t = Rp. %.2f", getSumPeople(), finalPriceForAll);
        System.out.println(totalPurchaseForAll);
    }
}
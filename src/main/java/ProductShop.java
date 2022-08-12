import java.util.*;

public class ProductShop {
    private String basket;

    public ProductShop() {
    }

    public ProductShop(Scanner scanner) {
        System.out.println("HELLO");
        System.out.println("This program will help you calculate the cost of your order");
        System.out.println("Please write down your order");
        basket = scanner.nextLine();
        if (checkingBasket()){
            System.out.printf("Thank you, your order consists of %s, its cost = " + sumBasketPrice() , basket);
        }else {
            System.out.println("Sorry, your shopping cart contains non-existent products or an unsatisfactory format");
        }
    }

    public void setBasket(String basket) {
        this.basket = basket;
    }
    public Float sumBasketPrice() {

        Float sumBasketPrice = 0f;
        for (CommodityBase productInBase :
                commodityBase()) {
            Character productName = productInBase.getProductName();
            Integer numberForPromotion = productInBase.getNumberForPromotion();
            Float price = productInBase.getPrice();
            Float promotionsPrice = productInBase.getPromotionalPrice();
            if (promotionsPrice == null){ promotionsPrice = 0f;}
            sumBasketPrice += numberProductWithoutPromotions(productName,numberForPromotion)*price +
                    numberPromotionAssortment(productName,numberForPromotion)*promotionsPrice;
        }
        return sumBasketPrice;
    }
    public int numberProductWithoutPromotions(Character productName,Integer numberForPromotions){
        if (numberForPromotions == null){
            return numberOfProductsInBasket().get(productName);
        }
        int numberPromotionsProduct = numberOfProductsInBasket().get(productName) % numberForPromotions;
        return numberPromotionsProduct;
    }
    public int numberPromotionAssortment(Character productName,Integer numberForPromotions){
        if (numberForPromotions == null || numberForPromotions > numberOfProductsInBasket().get(productName)){
            return 0;
        }
        int numberPromotionAssortment =
                (numberOfProductsInBasket().get(productName)-numberProductWithoutPromotions(productName,numberForPromotions))
                        /numberForPromotions;
        return numberPromotionAssortment;
    }
    public Map<Character, Integer> numberOfProductsInBasket() {
        Map<Character, Integer> numberOfProductsInBasket = new HashMap<>();
        for (CommodityBase productInBase : commodityBase()) {
            int numberOfProducts = 0;
            for (char productInBasket : parseBasket()) {
                if (productInBase.getProductName() == productInBasket) {
                    numberOfProducts++;
                }
            }
            numberOfProductsInBasket.put(productInBase.getProductName(), numberOfProducts);
        }
        return numberOfProductsInBasket;
    }
    public char[] parseBasket() {
        return basket.strip().toCharArray();
    }

    public boolean checkingBasket(){
        int numberOfProducts = 0;
        for (CommodityBase productInBase : commodityBase()) {
            for (char productInBasket : parseBasket()) {
                if (productInBase.getProductName() == productInBasket) {
                    numberOfProducts++;
                }
            }
        }
        if (numberOfProducts == parseBasket().length){
            return true;
        }else {
            return false;
        }
    }
    public List<CommodityBase> commodityBase() {
        List<CommodityBase> commodityBaseList = new ArrayList<>();
        CommodityBase A = new CommodityBase('A', 1.25F, 3, 3.00F);
        CommodityBase B = new CommodityBase('B', 4.25F, null, null);
        CommodityBase C = new CommodityBase('C', 1.00F, 6, 5.00F);
        CommodityBase D = new CommodityBase('D', 0.75F, null, null);
        commodityBaseList.add(A);
        commodityBaseList.add(B);
        commodityBaseList.add(C);
        commodityBaseList.add(D);
        System.out.println(commodityBaseList);
        return commodityBaseList;
        }

}

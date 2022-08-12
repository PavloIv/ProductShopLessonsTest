public class CommodityBase {
    private final Character productName;
    private final Float price;
    private final Integer numberForPromotions;
    private final Float promotionalPrice;

    public CommodityBase(Character productName, Float price, Integer numberForPromotions, Float promotionalPrice) {
        this.productName = productName;
        this.price = price;
        this.numberForPromotions = numberForPromotions;
        this.promotionalPrice = promotionalPrice;
    }

    public Character getProductName() {
        return productName;
    }

    public Float getPrice() { return price; }

    public Integer getNumberForPromotion() {
        return numberForPromotions;
    }

    public Float getPromotionalPrice() {
        return promotionalPrice;
    }

}

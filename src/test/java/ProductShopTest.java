import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductShopTest {
    public static final ProductShop testProductShop = new ProductShop();

    @Test
    void testConstructorWithScanerOK() {
        ProductShop testProductShopScaner = new ProductShop(new Scanner("ABCDABA"));

    }

    @Test
    void testConstructorWithScanerNotOk() {
        ProductShop testProductShopScaner = new ProductShop(new Scanner("2365DABA"));

    }

    @Test
    void testSumBasketPriseABCDABA() {
        testProductShop.setBasket("ABCDABA");
        Float actualSumBasketPrise = testProductShop.sumBasketPrice();
        Float expectedSumBasketPrise = 13.25F;
        assertEquals(expectedSumBasketPrise, actualSumBasketPrise);
    }

    @Test
    void testSumBasketPrise15AAACCCCCCSD83() {
        testProductShop.setBasket("15AAACCCCCCSD83");
        Float actualSumBasketPrise = testProductShop.sumBasketPrice();
        Float expectedSumBasketPrise = 8.75f;
        assertEquals(expectedSumBasketPrise, actualSumBasketPrise);
    }
    @Test
    void testSumBasketPriseACCACCACCBBBBDDDD() {
        testProductShop.setBasket("ACCACCACCBBBBDDDD");
        Float actualSumBasketPrise = testProductShop.sumBasketPrice();
        Float expectedSumBasketPrise = 28f;
        assertEquals(expectedSumBasketPrise, actualSumBasketPrise);
    }

    @Test
    void testNumberProductWithoutPromotionsABCDABAA() {
        testProductShop.setBasket("ABCDABAA");
        int actualNumberProductWithoutPromotions = testProductShop.numberProductWithoutPromotions('A', 3);
        int expectedNumberProductWithoutPromotions = 1;
        assertEquals(expectedNumberProductWithoutPromotions, actualNumberProductWithoutPromotions);
    }
    @Test
    void testNumberProductWithoutPromotionsAACCAACAACCC() {
        testProductShop.setBasket("AACCAACAACCC");
        int actualNumberProductWithoutPromotions = testProductShop.numberProductWithoutPromotions('A', 3);
        int expectedNumberProductWithoutPromotions = 0;
        assertEquals(expectedNumberProductWithoutPromotions, actualNumberProductWithoutPromotions);
    }

    @Test
    void testNumberProductWithoutPromotionsABCDABBB() {
        testProductShop.setBasket("ABCDABBB");
        int actualNumberProductWithoutPromotions = testProductShop.numberProductWithoutPromotions('A', 3);
        int expectedNumberProductWithoutPromotions = 2;
        assertEquals(expectedNumberProductWithoutPromotions, actualNumberProductWithoutPromotions);
    }

    @Test
    void testNumberProductWithoutPromotionsABCDABBBB() {
        testProductShop.setBasket("ABCDABBBB");
        int actualNumberProductWithoutPromotions = testProductShop.numberProductWithoutPromotions('B', null);
        int expectedNumberProductWithoutPromotions = 5;
        assertEquals(expectedNumberProductWithoutPromotions, actualNumberProductWithoutPromotions);
    }

    @Test
    void testNumberPromotionAssortmentABCDABAA() {
        testProductShop.setBasket("ABCDABAA");
        int actualNumberPromotionAssortment = testProductShop.numberPromotionAssortment('A', 3);
        int expectedNumberPromotionAssortment = 1;
        assertEquals(expectedNumberPromotionAssortment, actualNumberPromotionAssortment);
    }

    @Test
    void testNumberPromotionAssortmentABCDAB() {
        testProductShop.setBasket("ABCDAB");
        int actualNumberPromotionAssortment = testProductShop.numberPromotionAssortment('A', 3);
        int expectedNumberPromotionAssortment = 0;
        assertEquals(expectedNumberPromotionAssortment, actualNumberPromotionAssortment);
    }

    @Test
    void testNumberOfProductsInBasket() {
        testProductShop.setBasket("AABAACDD");
        Map<Character, Integer> actualResult = testProductShop.numberOfProductsInBasket();
        Map<Character, Integer> expectedMap = new HashMap<>();
        expectedMap.put('A', 4);
        expectedMap.put('B', 1);
        expectedMap.put('C', 1);
        expectedMap.put('D', 2);
        assertEquals(expectedMap, actualResult);
    }

    @Test
    void testParseBasketAABAACDD() {
        testProductShop.setBasket("AABAACDD");
        char[] actualParseBasket = testProductShop.parseBasket();
        char[] expectedArray = {'A', 'A', 'B', 'A', 'A', 'C', 'D', 'D'};
        Assertions.assertArrayEquals(expectedArray, actualParseBasket);
    }

    @Test
    void testParseBasketDCADDBBA() {
        testProductShop.setBasket("DCADDBBA");
        char[] actualParseBasket = testProductShop.parseBasket();
        char[] expectedArray = {'D', 'C', 'A', 'D', 'D', 'B', 'B', 'A'};
        Assertions.assertArrayEquals(expectedArray, actualParseBasket);
    }

    @Test
    void testParseBasketDCAD_DBBA1() {
        testProductShop.setBasket(" DCAD DBBA1");
        char[] actualParseBasket = testProductShop.parseBasket();
        char[] expectedArray = {'D', 'C', 'A', 'D',' ', 'D', 'B', 'B', 'A','1'};
        Assertions.assertArrayEquals(expectedArray, actualParseBasket);
    }

    @Test
    void testCheckingBasketdgDCADDBBA11() {
        testProductShop.setBasket("dgDCADDBBA11");
        boolean actualResult = testProductShop.checkingBasket();
        assertFalse(actualResult);
    }
    @Test
    void testCheckingBasketDCADDBBA() {
        testProductShop.setBasket("DCADDBBA");
        boolean actualResult = testProductShop.checkingBasket();
        assertTrue(actualResult);
    }

    @Test
    void testCheckingBasketdDCADDBBA() {
        testProductShop.setBasket("dDCADDBBA");
        boolean actualResult = testProductShop.checkingBasket();
        assertFalse(actualResult);
    }
    @Test
    void testCheckingBasket__DCADDBBA__() {
        testProductShop.setBasket("  DCADDBBA  ");
        boolean actualResult = testProductShop.checkingBasket();
        assertTrue(actualResult);
    }

    @Test
    void testCommodityBase() {
        testProductShop.setBasket("DCADDBBA");
        testProductShop.commodityBase();
    }
}
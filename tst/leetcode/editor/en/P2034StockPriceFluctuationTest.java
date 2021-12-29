package leetcode.editor.en;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P2034StockPriceFluctuationTest {
    P2034StockPriceFluctuation.StockPrice sol;

    @BeforeEach
    public void setUp() {
        sol = new P2034StockPriceFluctuation().new StockPrice();
    }

    @Test
    public void test1() {
        sol.update(1, 10);
        sol.update(2, 5);
        assertEquals(5, sol.current());
        assertEquals(10, sol.maximum());
        sol.update(1, 3);
        assertEquals(5, sol.maximum());
        sol.update(4, 2);
        assertEquals(2, sol.minimum());
    }
}
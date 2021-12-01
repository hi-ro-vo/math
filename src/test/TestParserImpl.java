package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.ParserImpl;

public class TestParserImpl {
    ParserImpl parser;

    @Before
    public void createParser() {
        parser = new ParserImpl();
    }


    // Базовые операции
    @Test
    public void test1() {
        Double actual = 24d;
        Double expected = Double.parseDouble(parser.test("(6-2)*(3+3)"));
        Assert.assertEquals(actual, expected);
    }

    // Возможность использовать минус перед числом для его отрицания
    @Test
    public void test2() {
        Double actual = -6d;
        Double expected = Double.parseDouble(parser.test("(2/2)*((-3)-3)"));
        Assert.assertEquals(actual, expected);
    }

    // Возведение в степень
    @Test
    public void test3() {
        Double actual1 = 8d;
        Double actual2 = 3d;
        Double expected1 = Double.parseDouble(parser.test("2^3"));
        Double expected2 = Double.parseDouble(parser.test("9^0.5"));
        Assert.assertEquals(actual1, expected1);
        Assert.assertEquals(actual2, expected2);
    }

    // Использование функций
    @Test
    public void test4() {
        Double actualCos = 1d;
        Double actualSin = 0d;
        Double expectedCos = Double.parseDouble(parser.test("cos(0)"));
        Double expectedSin = Double.parseDouble(parser.test("sin(0)"));
        Assert.assertEquals(actualCos, expectedCos);
        Assert.assertEquals(actualSin, expectedSin);
    }

    // Использование переменных
    @Test
    public void test5() {
        // Реализую когда будет возможность сохранять переменные в кэш
        Assert.assertEquals(true, false);

    }
    // Некорректное выражение (ожидаю, что будет null)
    @Test
    public void test6() {
        Assert.assertNull(parser.test("2+три"));
    }

}

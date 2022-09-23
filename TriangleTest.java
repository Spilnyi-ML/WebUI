package ru.gb.Lesson4;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.gb.lesson4.Triangle;

public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAll(){
        System.out.println("Выполнится 1 раз перед всеми тестами класса");
        logger.info("Выполнится 1 раз перед всеми тестами класса");
        WebDriverManager.chromedriver().setup();
    }

    @Test
    void TriangleTest1 (){
        double result = new Triangle().triangle(3, 5, 7);
        Assertions.assertEquals(6.49519052838329, result);
    }
    @Test
    void TriangleTest2 (){
        double result = new Triangle().triangle(7, 13, 11);
        Assertions.assertEquals(38.499188303131795, result);
    }
    
}

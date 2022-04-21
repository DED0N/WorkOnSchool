package firstTests;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class firstTest extends baseTests {

    @Test
    public void startTest() {
        System.out.println("Первый тест");
        String curDir = System.getProperty("user.dir");
        System.out.println(System.getProperty("os.name"));
        String filePath;

        if (System.getProperty("os.name").contains("Windows")) {
            filePath = curDir + "\\src\\main\\resources\\test";
        } else {
            filePath = curDir + "src/main/resources/test";
        }

        String line = null;

        try {
            BufferedReader bf = new BufferedReader(new FileReader(filePath));
            line = bf.readLine();
            bf.lines().forEach(s -> System.out.println("Строка файла: " + s));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(line);

        Assertion asert = new Assertion();

        asert.assertTrue(line.contains("ывфыв"), "Проверяем, что содержит текст");

    }
}

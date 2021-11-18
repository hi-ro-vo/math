import ru.Parser;
import ru.ParserImpl;

public class main {
    public static void main(String[] args) {
        ParserImpl parser = new ParserImpl();

//        System.out.println(parser.test("1+((2 + 2)*3)+(4/2)+(5-(6+7))"));
        System.out.println(parser.test("(2+2)*(3+3)"));
        //Double.parseDouble("1");
    }
}

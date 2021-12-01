import ru.Expresions.Constant;
import ru.Expresions.Plus;
import ru.Parser;
import ru.ParserImpl;

public class main {
    public static void main(String[] args) {
        ParserImpl parser = new ParserImpl();

//        System.out.println(parser.test("1+((2 + 2)*3)+(4/2)+(5-(6+7))"));
        System.out.println(parser.test("(2+2)*(3+3)"));
        Constant a = new Constant(1.0);
        Constant b = new Constant(2.0);
        Plus p = new Plus(a, b);
        System.out.println(p.execute());
        //Double.parseDouble("1");
    }
}

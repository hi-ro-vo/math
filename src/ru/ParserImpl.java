package ru;

import ru.Expresions.Constant;
import ru.Expresions.Expresion;
import ru.Expresions.ExpresionFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ParserImpl implements Parser {
    @Override
    public Expresion parse(String str) {
        StringTree stringTree = new StringTree(str.replaceAll("\\s",""), null);

        return new Constant(12.0);
    }

    private Expresion createExpresionsTree(StringTree tree) {
        Integer operationRate = tree.getNumber();
        tree.getListOfSubStrings().forEach(subTree -> {
            if (subTree.getNumber() == 1){
                subTree.setExpresion(parseString(new StringWithExpressions(subTree)));
            } else {
                if (subTree.getNumber() != operationRate){
                    subTree.setExpresion(createExpresionsTree(subTree));
                }
            }
        });
        return parseString(new StringWithExpressions(tree));
    }

    private Expresion parseString(StringWithExpressions str) {
        String command = "";
        Pair position = null;
        for (String c : ExpresionFactory.getListOfPriority()) {
            Pair i = str.indexOf(c);
            if (i != null) {
                position = i;
                command = c;
                break;
            }
        }
        if (position != null) {
            System.out.println(command);
            return ExpresionFactory.getExpresion(command, Arrays.asList(parseString(str.substring(new Pair(0, 0), position)),
                    parseString(str.substring(new Pair(position.getStart(), position.getEnd() + 1)))));
        } else {
            if (str.getExpresionOrString().getExpresion()!=null){
                return str.getExpresionOrString().getExpresion();
            }
            return ExpresionFactory.getExpresion(str.getExpresionOrString().getString(), null);
        }

    }

    ;

    public String test(String str) {
        StringTree stringTree = new StringTree(str, new Pair(0, str.length() - 1));
        ExpresionFactory.variableServise.SetValue("a", 2.0);
        Expresion expresion = createExpresionsTree(new StringTree("2/4*3-2*3/4+2^3", null));
        return expresion.execute().toString();
    }


}

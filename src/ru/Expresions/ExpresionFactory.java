package ru.Expresions;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import ru.VariableServise;

public class ExpresionFactory {
    static public VariableServise variableServise = new VariableServise();

    public static Expresion getExpresion(String exp, List<Expresion> expresionList){
        switch (exp){
            case "+":{
                return new Plus(expresionList);
            }
            case "-":{
                return new Substract(expresionList);
            }
            case "*":{
                return new Multiplication(expresionList);
            }
            case "/":{
                return new Division(expresionList);
            }
            default:{
                try {
                    return new Constant(Double.parseDouble(exp));
                } catch (NumberFormatException e){
                    return new Variable(exp, variableServise);
                }
            }
        }
    }

    public static List<String> getListOfPriority(){
        return Arrays.asList("+", "-", "*", "/");
    }
}

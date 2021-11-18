package ru.Expresions;

import java.util.ArrayList;
import java.util.List;

public class Substract implements Expresion{
    private List<Expresion> childs;

    Substract(Expresion leftChild, Expresion rightChild){
        childs = new ArrayList<>();
        childs.add(0, leftChild);
        childs.add(1, rightChild);
    }

    Substract(List<Expresion> expresionList){
        if (expresionList.size()!=2){
            //TODO: trow
        }
        childs = expresionList;
    }

    @Override
    public Double execute() {
        return childs.get(0).execute()-childs.get(1).execute();
    }

    @Override
    public List<Expresion> getChilds() {
        return childs;
    }

    @Override
    public String getName() {
        return null;
    }
}

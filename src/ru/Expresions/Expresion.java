package ru.Expresions;

import java.util.List;

public interface Expresion {
    Double execute();
    List<Expresion> getChilds();
    String getName();
}

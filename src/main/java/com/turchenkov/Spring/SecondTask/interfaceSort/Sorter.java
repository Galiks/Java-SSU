package com.turchenkov.Spring.SecondTask.interfaceSort;

import java.util.List;

public interface Sorter<T> {

    List<T> sort(List<T> arrayToSort);
}

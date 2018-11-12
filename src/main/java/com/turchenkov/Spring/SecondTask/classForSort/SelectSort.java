package com.turchenkov.Spring.SecondTask.classForSort;

import com.turchenkov.Spring.SecondTask.interfaceSort.Sorter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SelectSort implements Sorter<Integer> {

    @Override
    public List<Integer> sort(List<Integer> arrayToSort) {
        /*По очереди будем просматривать все подмножества
      элементов массива (0 - последний, 1-последний,
      2-последний,...)*/
        for (int i = 0; i < arrayToSort.size(); i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
            int min = arrayToSort.get(i);
            int min_i = i;
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
            for (int j = i+1; j < arrayToSort.size(); j++) {
                //Если находим, запоминаем его индекс
                if (arrayToSort.get(j) < min) {
                    min = arrayToSort.get(j);
                    min_i = j;
                }
            }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
            if (i != min_i) {
                int tmp = arrayToSort.get(i);
                arrayToSort.set(i, arrayToSort.get(min_i));
                arrayToSort.set(min_i, tmp);
            }
        }

        return arrayToSort;
    }
}

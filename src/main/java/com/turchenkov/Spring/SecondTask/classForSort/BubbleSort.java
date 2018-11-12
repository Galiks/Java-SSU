package com.turchenkov.Spring.SecondTask.classForSort;

import com.turchenkov.Spring.SecondTask.interfaceSort.Sorter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BubbleSort implements Sorter<Integer> {
    @Override
    public List<Integer> sort(List<Integer> arrayToSort) {
        int n = arrayToSort.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrayToSort.get(j) > arrayToSort.get(j + 1)) {
                    // swap temp and arr[i]
                    int temp = arrayToSort.get(j);
                    arrayToSort.set(j, arrayToSort.get(j + 1));
                    arrayToSort.set(j + 1, temp);
                }
            }
        }
        return arrayToSort;
    }
}

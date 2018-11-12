package com.turchenkov.Spring.SecondTask.service;

import com.turchenkov.Spring.SecondTask.interfaceSort.Sorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortService {

    @Qualifier("bubbleSort")
    @Autowired
    private Sorter<Integer> bubbleSorter;

    public void bubbleSort(List<Integer> list){
        bubbleSorter.sort(list);
    }

    @Qualifier("selectSort")
    @Autowired
    private Sorter<Integer> selectSorter;

    public void selectSort(List<Integer> list){
        selectSorter.sort(list);
    }
}

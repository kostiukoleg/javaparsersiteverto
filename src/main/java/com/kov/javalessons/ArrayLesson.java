/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kov.javalessons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author olegk
 */
public class ArrayLesson {
    public static void main(String[] args) {
        System.out.print(Data.data1[1]);
        String[] array1 = {"A", "B", "C"};
        String[] array2 = {"1", "2", "3"};

        List<String> resultList = new ArrayList<>();
        List<String[]> resultList2 = new ArrayList<>();
        resultList2.add(array1);
        resultList2.add(array2);
        

        resultList.addAll(Arrays.asList(array1));
        resultList.addAll(Arrays.asList(array2));

        String[] result;
        result = resultList.toArray(String[]::new);
        //Arrays.asList(result)
        System.out.println(Arrays.toString(result));//Arrays.toString(resultList2.get(0))
        System.out.println(Arrays.asList(resultList2.get(1)));
    }
}

package com.company;

public class App {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 7, 8, 5, 6, 9, 8,3};
        int[] b = new int[]{11, 23, -7, 6, 5, 6, 92, 18};
        int[] c = new int[]{3, 8};
        int[] d = new int[]{7,7,3,100,7,-2,6};
        var staticArray = new StaticArray(a);
        System.out.println(staticArray);
        Array st=staticArray.subArray(3,6);
        System.out.println((st));
       var sortedArray = new SortedArray(a);
//       System.out.println(sortedArray);
//
//        var dynamicArray = new DynamicArray();
//        dynamicArray.add(5);
//        dynamicArray.add(10);
//        System.out.println(dynamicArray);
        //SortedArray arr1 = new SortedArray(a);
//        SortedArray arr2 = new SortedArray(b);
//        System.out.println(arr1.merge(arr2));
        //var arr1=new DynamicArray(a);
        //arr1.remove(8);
        //arr1.removeAll(c);
        //arr1.removeOf(2);
        //System.out.println((arr1));
        //System.out.println((arr1.size()));
        var arr = new DynamicArray(d);
        arr.remove(7);
        System.out.println(arr);
    }
}

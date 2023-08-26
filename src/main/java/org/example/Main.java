package org.example;

import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        int [] randArray = GetRandomArray(25,3,115);
        PrintArray(randArray);
        HeapSort(randArray, randArray.length);
        PrintArray(randArray);
    }

    /**
     * @apiNote binary heap sort
     * @param arr - входящий неотсортированный массив
     * @param arrayLength  - длина массива
     */
    private static void HeapSort(int[] arr, int arrayLength) {
        if(arrayLength == 1)
            return;
        int temp;
        for (int parentIndex = arrayLength / 2 -1; parentIndex >= 0; parentIndex--) {
            int leftChildIndex = 2 * parentIndex + 1;
            int rightChildIndex = 2 * parentIndex + 2;
            int maxValueIndex = leftChildIndex;
            if(HasTwoChildren(arrayLength, parentIndex)){
                if(arr[rightChildIndex] > arr[leftChildIndex])
                    maxValueIndex = rightChildIndex;
            }
            if (arr[maxValueIndex] > arr[parentIndex]) {
                temp = arr[parentIndex];
                arr[parentIndex] =  arr[maxValueIndex];
                arr[maxValueIndex] = temp;
            }
        }
        temp = arr[arrayLength - 1];
        arr[arrayLength - 1] =  arr[0];
        arr[0] = temp;
        HeapSort(arr, arrayLength - 1);
    }

    /**
     * @apiNote Проверка на наличие двух потомков
     * @param arrayLength - длина массива
     * @param parent - индекс родителького элемента
     * @return
     */
    public static boolean HasTwoChildren(int arrayLength, int parent) {
        if(2 * parent + 2 < arrayLength){
            return  true;
        }else{
            return  false;
        }
    }

    /**
     * @apiNote  Печать массива
     * @param arr  - входящий массив
     */
    public static void PrintArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] GetRandomArray(int size, int min, int max){
        Random rand = new Random();
        int [] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(max-min+1) + min;
        }
        return arr;
    }
}
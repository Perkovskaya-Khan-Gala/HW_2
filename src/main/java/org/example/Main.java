package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 188;
        int max = 1000;
        int min = 0;
        int[] array = createArray(size, min, max);
        printArr(array);
        sortArrayHeap(array);
        printArr(array);
    }

    /**
     * @apiNote Метод сортировки треугольника - вершины, левого и правого дочерних узлов
     * @param arr - массив целых чисел
     * @param currentTop - текущая вершина треугольника
     * @param lastIndex - последний индекс массива
     */
    public static void sortTriangle(int[] arr, int currentTop, int lastIndex) {

            int indexLeft = currentTop * 2 + 1;
            int indexRight = currentTop * 2 + 2;
            int large = currentTop;

            if (indexLeft <= lastIndex && arr[indexLeft] > arr[currentTop]) {
                large = indexLeft;
            }
            if (indexRight <= lastIndex && arr[indexRight] > arr[currentTop]) {
                large = indexRight;
            }
            if (large != currentTop) {
                int temp = arr[currentTop];
                arr[currentTop] = arr[large];
                arr[large] = temp;
            }


    }

    /**
     * @apiNote Метод сортировки кучи(max куча), реализуется проходом по всем родительским вершинам от конца до начала и обратно.
     * Во время прохода каждой вершины запускается сортировка треугольника:родительская вершина, левая и правая дочерние вершины
     * @param arr - массив целых чисел
     * @param lastIndex - индекс последнего элемента массива
     */
    public static void sortHeap(int[] arr, int lastIndex){
        int lastTop=(lastIndex-1)/2;
        for (int i = lastTop; i >=0 ; i--) {
            sortTriangle(arr, i, lastIndex);
        }
        for (int i = 0; i <=lastTop ; i++) {
            sortTriangle(arr, i, lastIndex);
        }

    }

    /**
     * @apiNote Метод сортировки массива из подготовленной кучи(max куча)
     * @param arr - массив целых чисел
     */
    public static void sortArrayHeap(int[] arr){
        int temp;
        int size=arr.length-1;
        while (size>0){
            sortHeap(arr,size);
            temp=arr[0];
            arr[0]=arr[size];
            arr[size]=temp;
            size--;
        }
    }

    /**
     * @param arr - массив целых чисел
     * @apiNote метод вывода массива на экран
     */
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * @param sizeArray - размер массива
     * @param max       - верхний диапазон чисел массива
     * @param min       - нижний диапазон чисел массива
     * @return - созданный массив
     * @apiNote -Метод создания массива целых чисел
     */
    public static int[] createArray(int sizeArray, int min, int max) {
        int[] arrayResult = new int[sizeArray];
        Random rd = new Random();
        for (int i = 0; i < sizeArray; i++) {
            arrayResult[i] = rd.nextInt((max - min) + 1) + min;
        }
        return arrayResult;
    }


}
package com.marlen.java.lesson_1.Lesson7_1.Home7.Sorting.Merge_Sort;

// Кружок факультета Кибернетики

public class Merge_Sort_Cybernetics {
    public static void main(String[] args) {
        int []a= {785, 45,3,2,8,1,9,0,12,5,11};
        mergeSort(a,0,a.length-1);
        for (int row:a) {
            System.out.print(row+" ");
        }
    }

    public static void mergeSort(int[]a, int l,int r){
                                // в этом случае отрезок отсортирован
        if(l==r) return;
                                // определяем середину и запускаем рекурсивную сортировку
                                // для обех половин массива
        int m=(l+r)/2;
        mergeSort(a,l,m);
        mergeSort(a,m+1,r);

                                // объединяем два отрезка в один
        mergeRanges(a,l,r);
    }

    public static void mergeRanges(int[] a, int l, int r){
        int [] b= new int [10000];    // дополнительный массив для объединения
                                      // двух отсортированных отрезков

                    // процедура объединения двух отсортированных отрезков в один а-массив,
                    // l,r - левая и правая границы отрезков соответственно
        int sizeOfTheRange = r-l+1;   // размер отрезка результата
        int m = (l+r)/2;              // середина отрезка
        for (int i=l, j= m+1,k=0; k<sizeOfTheRange; k++ ){
                                      // i - очередной элемент первой половины
                                      // j - очередной элемент второй половины
                                      // k - номер элемента, который мы добавляем в
                                      // последовательность - ответ
            if(i>m || (j<=r && a[i]> a[j])){
                                      // выполняется если первая половина закончилась,
                                      // или тепершний min находится в другой половине,
                                      // которая не закончилась также
                b[k]=a[j];
                j++;
            } else{ b[k]=a[i];
            i++;
            }
        }
        for (int i = 0; i <sizeOfTheRange ; i++) {
            a[l+i]=b[i];
        }
    }
}

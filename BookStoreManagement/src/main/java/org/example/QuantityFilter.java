package org.example;

import java.util.ArrayList;
import java.util.Random;

public class QuantityFilter implements FilterStrategy{
    // This is the same as PriceFilter, could have been implemented better...
    private ArrayList<Product> sortedProductList;
    @Override
    public ArrayList<Product> sort(ArrayList<Product> products) {
        quicksort(products, 0, products.size() - 1);
        return sortedProductList;
    }
    private void quicksort(ArrayList<Product> products, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            sortedProductList = products;
            return;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        double pivot = products.get(pivotIndex).getQuantity();
        swap(products, pivotIndex, highIndex);

        int leftPointer = partition(products, lowIndex, highIndex, pivot);
        quicksort(products, lowIndex, leftPointer - 1);
        quicksort(products, leftPointer + 1, highIndex);
    }
    private int partition(ArrayList<Product> products, int lowIndex, int highIndex, double pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer < rightPointer) {

            while (products.get(leftPointer).getQuantity() <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (products.get(rightPointer).getQuantity() >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(products, leftPointer, rightPointer);
        }
        swap(products, leftPointer, highIndex);
        return leftPointer;
    }
    private void swap(ArrayList<Product> products, int indexOne, int indexTwo) {
        Product temp = products.get(indexOne);
        products.set(indexOne, products.get(indexTwo));
        products.set(indexTwo, temp);
    }
}

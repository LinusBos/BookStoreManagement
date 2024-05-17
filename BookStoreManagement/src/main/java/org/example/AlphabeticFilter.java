package org.example;

import java.util.ArrayList;

public class AlphabeticFilter implements FilterStrategy {
    @Override
    public ArrayList<Product> sort(ArrayList<Product> products) {
        if (products == null || products.size() < 2) {
            return products;
        }
        mergesort(products);
        return products;
    }
    private void mergesort(ArrayList<Product> products) {
        int inputSize = products.size();

        if (inputSize < 2) {
            return;
        }

        int midIndex = inputSize / 2;
        ArrayList<Product> leftHalf = new ArrayList<>(midIndex);
        ArrayList<Product> rightHalf = new ArrayList<>(inputSize - midIndex);

        for (int i = 0; i < midIndex; i++) {
            leftHalf.add(products.get(i));
        }
        for (int i = midIndex; i < inputSize; i++) {
            rightHalf.add(products.get(i));
        }

        mergesort(leftHalf);
        mergesort(rightHalf);

        merge(products, leftHalf, rightHalf);
    }
    private void merge(ArrayList<Product> inputArray, ArrayList<Product> leftHalf, ArrayList<Product> rightHalf) {
        int leftSize = leftHalf.size();
        int rightSize = rightHalf.size();

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            String leftTitle = leftHalf.get(i).getTitle().toLowerCase();
            String rightTitle = rightHalf.get(j).getTitle().toLowerCase();

            if (leftTitle.compareTo(rightTitle) <= 0) {
                // compareTo will compare each character of the strings from left to right, < 0 => the string has lower unicode value.
                inputArray.set(k, leftHalf.get(i));
                i++;
            } else {
                inputArray.set(k, rightHalf.get(j));
                j++;
            }
            k++;
        }
        // elements left
        while (i < leftSize) {
            inputArray.set(k, leftHalf.get(i));
            i++;
            k++;
        }
        while (j < rightSize) {
            inputArray.set(k, rightHalf.get(j));
            j++;
            k++;
        }
    }
}

package com.medisense.adsa;

import java.util.ArrayList;
import java.util.List;

public class PatientMaxHeap {
    private final List<Integer> heap = new ArrayList<>();

    public void insert(int value) {
        heap.add(value);
        siftUp(heap.size() - 1);
    }

    public Integer extractMax() {
        if (heap.isEmpty()) {
            return null;
        }

        int max = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            siftDown(0);
        }
        return max;
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(parentIndex) >= heap.get(index)) {
                break;
            }
            swap(parentIndex, index);
            index = parentIndex;
        }
    }

    private void siftDown(int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }
        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }
        if (largest != index) {
            swap(index, largest);
            siftDown(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

package com.medisense.adsa;

public class HeapBenchmark {
    public static void main(String[] args) {
        PatientMaxHeap heap = new PatientMaxHeap();
        int[] values = {5, 12, 9, 18, 3, 15};

        for (int value : values) {
            heap.insert(value);
        }

        while (!heap.isEmpty()) {
            System.out.println(heap.extractMax());
        }
    }
}

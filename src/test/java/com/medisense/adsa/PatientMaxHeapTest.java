package com.medisense.adsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PatientMaxHeapTest {

    @Test
    void extractsHighestPriorityPatient() {
        PatientMaxHeap heap = new PatientMaxHeap();
        heap.insert(10);
        heap.insert(25);
        heap.insert(15);

        assertEquals(25, heap.extractMax());
        assertEquals(15, heap.extractMax());
        assertEquals(10, heap.extractMax());
        assertNull(heap.extractMax());
    }
}

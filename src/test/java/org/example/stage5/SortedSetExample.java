package org.example.stage5;

import org.junit.jupiter.api.Test;

import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortedSetExample {

    @Test
    void example(){
        SortedSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < 10; i++) {
            set.add(i);
        }


        //headSet(X) от начала до X не включая X
        assertArrayEquals(new Integer[]{0, 1, 2}, set.headSet(3).toArray());

        //tailSet(X) от X до конца, включая X
        assertArrayEquals(new Integer[]{6, 7, 8, 9}, set.tailSet(6).toArray());

        //subSet(from, to) подмножество от from до to. Включая from, не включая to
        assertArrayEquals(new Integer[]{2, 3, 4}, set.subSet(2, 5).toArray());


        //first() возвращает первый по сортировке элемент, не удаляя его из коллекции
        assertEquals(0, set.first());
        assertEquals(0, set.first());
        //first() возвращает последний по сортировке элемент, не удаляя его из коллекции
        assertEquals(9, set.last());
        assertEquals(9, set.last());
    }
}

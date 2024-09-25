package org.example.stage5;

import org.junit.jupiter.api.Test;

import java.util.NavigableSet;
import java.util.TreeSet;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigableSetExample {

    @Test
    void exapmle1() {
        NavigableSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < 3; i++) {
            set.add(10 * i);
        }

        assertArrayEquals(new Integer[]{0, 10, 20}, set.toArray());
        assertArrayEquals(new Integer[]{20, 10, 0}, set.descendingSet().toArray());


        //ceiling(x) больше либо равно X
        assertEquals(0, set.ceiling(-1));
        assertEquals(0, set.ceiling(0));
        assertEquals(10, set.ceiling(1));
        assertEquals(10, set.ceiling(9));
        assertEquals(10, set.ceiling(10));

        assertEquals(20, set.ceiling(11));
        assertEquals(20, set.ceiling(20));

        assertEquals(null, set.ceiling(21));


        //higher(x) строго больше X
        assertEquals(null, set.higher(20));
        assertEquals(20, set.higher(10));
        assertEquals(10, set.higher(0));
        assertEquals(0, set.higher(-1));

        //floor(x) меньше или равно X
        assertEquals(null, set.floor(-1));
        assertEquals(0, set.floor(0));
        assertEquals(0, set.floor(9));
        assertEquals(10, set.floor(10));
        assertEquals(10, set.floor(19));
        assertEquals(20, set.floor(20));
        assertEquals(20, set.floor(21));

        //lower(x) строго меньше X
        assertEquals(20, set.lower(21));
        assertEquals(10, set.lower(20));
        assertEquals(0, set.lower(10));
        assertEquals(null, set.lower(0));
        assertEquals(null, set.lower(-1));


        // 0, 10, 20
        assertEquals(20, set.pollLast());
        // 0, 10
        assertEquals(0, set.pollFirst());
        // 10
        assertEquals(10, set.pollFirst());
        // empty
        assertEquals(0, set.size());


        for (int i = 0; i < 10; i++) {
            set.add(i);
        }

        //headSet(X, isInclusive) от начала до X, включая X если isInclusive
        assertArrayEquals(new Integer[]{0, 1, 2, 3}, set.headSet(3, true).toArray());
        assertArrayEquals(new Integer[]{0, 1, 2}, set.headSet(3, false).toArray());
        //headSet(X) от начала до X не включая X
        assertArrayEquals(new Integer[]{0, 1, 2}, set.headSet(3).toArray());


        //tailSet(X, isInclusive) от X до конца , включая X если isInclusive
        assertArrayEquals(new Integer[]{6, 7, 8, 9}, set.tailSet(6, true).toArray());
        assertArrayEquals(new Integer[]{7, 8, 9}, set.tailSet(6, false).toArray());
        //tailSet(X) от X до конца, включая X
        assertArrayEquals(new Integer[]{6, 7, 8, 9}, set.tailSet(6).toArray());

        //subSet(from, to) подмножество от from до to. Включая from, не включая to
        assertArrayEquals(new Integer[]{2, 3, 4}, set.subSet(2, 5).toArray());
        //subSet(from, fInc, to, tInc) подмножество от from до to. Включая from если fInc, включая to если tInc
        assertArrayEquals(new Integer[]{2, 3, 4}, set.subSet(2, true, 5, false).toArray());
        assertArrayEquals(new Integer[]{2, 3, 4, 5}, set.subSet(2, true, 5, true).toArray());
        assertArrayEquals(new Integer[]{3, 4}, set.subSet(2, false, 5, false).toArray());
    }
}

package org.example.stage3;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class HashMySetTest {

    HashMySet<Integer> set = new HashMySet<>();

    @Test
    void add() {
        assertFalse(set.contains(1));
        assertFalse(set.contains(3));
        assertFalse(set.contains(4));
        assertFalse(set.contains(5));
        assertFalse(set.contains(7));
        assertEquals(0, set.size());
        assertTrue(set.add(5));
        assertEquals(1, set.size());
        assertTrue(set.contains(5));


        assertTrue(set.add(3));
        assertEquals(2, set.size());
        assertTrue(set.contains(3));


        assertTrue(set.add(1));
        assertTrue(set.contains(1));

        assertTrue(set.add(4));
        assertTrue(set.contains(4));

        assertTrue(set.add(7));
        assertTrue(set.contains(7));
        assertEquals(5, set.size());
        assertFalse(set.add(7));
        assertEquals(5, set.size());

        Iterable<Integer> actual = set.entrySet();
        assertNotEquals(asList(1,3,4,5,7), actual);

    }

}
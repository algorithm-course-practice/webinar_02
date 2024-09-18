package org.example.stage1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicTest {

    @Test
    void testEquals() {
        Basic b1 = new Basic(1, "First");
        Basic b2 = new Basic(2, "First");
        Basic b3 = new Basic(2, "First");
        assertFalse(b1.equals(b2));
        assertFalse(b1.equals(b3));
        assertTrue(b2.equals(b3));
        assertTrue(b3.equals(b2));
        assertEquals(b2.hashCode(), b3.hashCode());
        assertNotEquals(b1.hashCode(), b2.hashCode());
        assertNotEquals(b1.hashCode(), b3.hashCode());
    }

    @Test
    void testHashCode() {
    }
}
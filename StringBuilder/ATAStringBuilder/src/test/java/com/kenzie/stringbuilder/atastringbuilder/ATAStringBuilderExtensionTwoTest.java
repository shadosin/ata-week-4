package com.kenzie.stringbuilder.atastringbuilder;

import org.junit.jupiter.api.Test;

import java.awt.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ATAStringBuilderExtensionTwoTest {

    private ATAStringBuilder sb;

    @Test
    public void append_appendPoint_containsPointsStringValue() {
        // GIVEN - empty string builder and a Point object
        sb = new ATAStringBuilder();
        Point p = new Point(0, 0);

        // WHEN - append a point object
        sb.append(p);

        // THEN - the point object's string representation should be present
        assertEquals(p.toString(), sb.toString(), "Expected the string representation of the object to be appended.");
    }

    @Test
    public void append_null_containsNullString() {
        // GIVEN - empty string builder
        sb = new ATAStringBuilder();

        // WHEN - append a null value
        sb.append(null);

        // THEN - the string "null" should be present
        assertEquals("null", sb.toString(), "Expected the string \"null\" to be appended.");
    }

    @Test
    public void insert_offsetTooSmall_throwsException() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata");

        // WHEN/THEN - index out of bounds for a negative index
        assertThrows(IndexOutOfBoundsException.class,
                     () -> sb.insert(-1, "*"),
                     "Expected an exception to be thrown when inserting at a negative index.");
    }

    @Test
    public void insert_offsetTooLarge_throwsException() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata");

        // WHEN/THEN - index larger than the length of the builder
        assertThrows(IndexOutOfBoundsException.class,
                     () -> sb.insert(sb.length() + 1, "*"),
                     "Expected an exception to be thrown when inserting at an index greater than the length.");
    }

    @Test
    public void insert_indexZero_addsToFront() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata");

        // WHEN - inserted at index 0
        sb.insert(0, "pre-");

        // THEN - the inserted string should be at the front of the string
        assertEquals("pre-ata", sb.toString(), "Expected string to be inserted.");
    }

    @Test
    public void insert_indexMiddle_addsToMiddle() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata-v2");

        // WHEN - insert into the middle
        sb.insert(3, "***");

        // THEN - the inserted string is located starting at index 3
        assertEquals("ata***-v2", sb.toString(), "Expected string to be inserted.");
    }

    @Test
    public void insert_indexLength_addsToEnd() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata-v2");

        // WHEN - insert at the end of the builder
        sb.insert(sb.length(), "***");

        // THEN - the inserted string is inserted at the end
        assertEquals("ata-v2***", sb.toString(), "Expected string to be inserted.");
    }

    @Test
    public void substring_startTooSmall_throwsException() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata-v2");

        // WHEN/THEN - index out of bounds for a negative index
        assertThrows(IndexOutOfBoundsException.class,
                     () -> sb.substring(-1, 2),
                     "Expected an exception to be thrown when calling substring with a negative start index.");
    }

    @Test
    public void substring_startTooLarge_throwsException() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata-v2");

        // WHEN/THEN - index larger than the length of the builder
        assertThrows(IndexOutOfBoundsException.class,
                     () -> sb.substring(sb.length() + 1, 5),
                     "Expected an exception to be thrown when calling substring with a start index greater than the " +
                         "length.");
    }

    @Test
    public void substring_endTooSmall_throwsException() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata-v2");

        // WHEN/THEN - index out of bounds for a negative index
        assertThrows(IndexOutOfBoundsException.class,
                     () -> sb.substring(1, -2),
                     "Expected an exception to be thrown when calling substring with a negative end index.");
    }

    @Test
    public void substring_endTooLarge_throwsException() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata-v2");

        // WHEN/THEN - index larger than the length of the builder
        assertThrows(IndexOutOfBoundsException.class,
                     () -> sb.substring(2, sb.length() + 1),
                     "Expected an exception to be thrown when calling substring with an end index greater than the " +
                         "length.");
    }

    @Test
    public void substring_startLargerThanEnd_throwsException() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata-v2");

        // WHEN/THEN - start index larger than the end index
        assertThrows(IndexOutOfBoundsException.class,
                     () -> sb.substring(4, 2),
                     "Expected an exception to be thrown when calling substring with an end index greater than the " +
                         "start index.");
    }

    @Test
    public void substring_entireSequence_returnsEntireString() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata-v2");

        // WHEN - call substring
        String substring = sb.substring(0, sb.length());

        // THEN - expected entire string to be returned
        assertEquals(sb.toString(), substring, "Expected entire string to be returned.");
    }

    @Test
    public void substring_partialSequence_returnsSubstring() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata-v2");

        // WHEN - call substring
        String substring = sb.substring(0, 3);

        // THEN - expected entire string to be returned
        assertEquals(sb.toString().substring(0, 3), substring, "Expected first 3 characters to be returned.");
    }
}

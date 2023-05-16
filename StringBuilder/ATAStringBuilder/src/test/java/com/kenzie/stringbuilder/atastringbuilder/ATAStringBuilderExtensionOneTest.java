package com.kenzie.stringbuilder.atastringbuilder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ATAStringBuilderExtensionOneTest {

    private ATAStringBuilder sb;

    @Test
    public void setCharAt_indexTooSmall_throwsException() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata");

        // WHEN/THEN - index out of bounds for a negative index
        assertThrows(IndexOutOfBoundsException.class,
                     () -> sb.setCharAt(-1, '*'),
                     "Expected an exception to be thrown when setting at a negative index.");
    }

    @Test
    public void setCharAt_indexTooLarge_throwsException() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata");

        // WHEN/THEN - index larger than the length of the builder
        assertThrows(IndexOutOfBoundsException.class,
                     () -> sb.setCharAt(sb.length(), '*'),
                     "Expected an exception to be thrown when setting at an index greater than the length.");
    }

    @Test
    public void setCharAt_indexZero_replacesFront() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata-v2");

        // WHEN - replace the first character
        sb.setCharAt(0, '*');

        // THEN
        assertEquals("*ta-v2", sb.toString(), "Expected the first character to be replaced.");
    }

    @Test
    public void setCharAt_indexMiddle_replacesMiddle() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata-v2");

        // WHEN - replace the character at index 3
        sb.setCharAt(3, '*');

        // THEN
        assertEquals("ata*v2", sb.toString(), "Expected the character at index 3 to be replaced.");
    }

    @Test
    public void setCharAt_indexLengthMinus1_replacesEnd() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata-v2");

        // WHEN - replace the last character
        sb.setCharAt(sb.length() - 1, '*');

        // THEN
        assertEquals("ata-v*", sb.toString(), "Expected the last character to be replaced.");
    }

    @Test
    public void deleteCharAt_indexTooSmall_throwsException() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata");

        // WHEN/THEN - index out of bounds for a negative index
        assertThrows(IndexOutOfBoundsException.class,
                     () -> sb.deleteCharAt(-1),
                     "Expected an exception to be thrown when deleting at a negative index.");
    }

    @Test
    public void deleteCharAt_indexTooLarge_throwsException() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata");

        // WHEN/THEN - index larger than the length of the builder
        assertThrows(IndexOutOfBoundsException.class,
                     () -> sb.deleteCharAt(sb.length()),
                     "Expected an exception to be thrown when deleting at an index equal to the length.");
    }

    @Test
    public void deleteCharAt_indexZero_removesFirstChar() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata-v2");

        // WHEN - delete the first character
        sb.deleteCharAt(0);

        // THEN
        assertEquals("ta-v2", sb.toString(), "Expected the first character to be removed.");
    }

    @Test
    public void deleteCharAt_indexMiddle_removesMiddleChar() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata-v2");

        // WHEN - delete character at index 3
        sb.deleteCharAt(3);

        // THEN
        assertEquals("atav2", sb.toString(), "Expected the character at index 3 to be removed.");
    }

    @Test
    public void deleteCharAt_indexLengthMinus1_removesLastChar() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata-v2");

        // WHEN - delete last character
        sb.deleteCharAt(sb.length() - 1);

        // THEN - last character removed
        assertEquals("ata-v", sb.toString(), "Expected the last character to be removed.");
    }
}

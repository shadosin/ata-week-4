package com.kenzie.stringbuilder.atastringbuilder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ATAStringBuilderCompletionTest {

    private ATAStringBuilder sb;

    @Test
    public void constructor_default_containsNoCharacters() {
        // WHEN - default const used to create ATAStringBuilder
        sb = new ATAStringBuilder();

        // THEN - toString should return empty string
        assertEquals("", sb.toString(), "Expected no args constr to create an empty builder.");
    }

    @Test
    public void constructor_initialString_containsProvidedString() {
        // WHEN - constr that accepts initial string content
        sb = new ATAStringBuilder("ata");

        // THEN - toString returns initial string content
        assertEquals("ata", sb.toString(), "Expected constr that accepts an initial string to " +
            "contain it.");
    }

    @Test
    public void length_emptyBuilder_returnsZero() {
        // GIVEN - empty string builder
        sb = new ATAStringBuilder();

        // WHEN - call to get length
        int length = sb.length();

        // THEN - length should be zero
        assertEquals(0, length, "Expected empty builder to have length 0.");
    }

    @Test
    public void length_nonEmptyBuilder_returnsNumberOfChars() {
        // GIVEN - a nonempty string builder
        sb = new ATAStringBuilder("ata");

        // WHEN - call to get length
        int length = sb.length();

        // THEN - length should be zero
        assertEquals(3, length, "Expected builder to have length equal to the number of " +
            "characters in it.");
    }

    @Test
    public void append_nonEmptyStringToEmptyBuilder_containsString() {
        // GIVEN - empty string builder
        sb = new ATAStringBuilder();

        // WHEN - append a nonempty string
        sb.append("ata");

        // THEN - expect the appended string to be added
        assertEquals("ata", sb.toString(), "Expected String value to be appended to empty builder.");
    }

    @Test
    public void append_nonEmptyStringToNonemptyBuffer_appendsNewString() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata");

        // WHEN - append nonempty string
        sb.append("-v2");

        // THEN - add string to end of the builder
        assertEquals("ata-v2", sb.toString(), "Expected String value to be appended to the " +
            "nonempty builder.");
    }

    @Test
    public void append_emptyStringToEmptyBuffer_emptyContents() {
        // GIVEN - empty string builder
        sb = new ATAStringBuilder();

        // WHEN - append empty string
        sb.append("");

        // THEN - buffer should be empty
        assertEquals("", sb.toString(), "Expected appending empty string to not affect the builder.");
    }

    @Test
    public void append_emptyStringToNonemptyBuffer_contentsUnchanged() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata");

        // WHEN - append empty string
        sb.append("");

        // THEN - buffer should be unchanged
        assertEquals("ata", sb.toString(), "Expected appending empty string to not affect " +
            "the builder.");
    }

    @Test
    public void append_nullString_nullAppended() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata");

        // WHEN - null string appended
        sb.append((String) null);

        // THEN - null appended to the end
        assertEquals("atanull", sb.toString(), "Expected the string \"null\" to be appended.");
    }

    @Test
    public void insertChar_offsetTooSmall_throwsException() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata");

        // WHEN/THEN - index out of bounds for a negative index
        assertThrows(IndexOutOfBoundsException.class,
                     () -> sb.insert(-1, '*'),
                     "Expected an exception to be thrown when inserting at a negative index.");
    }

    @Test
    public void insertChar_offsetTooLarge_throwsException() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata");

        // WHEN/THEN - index larger than the length of the builder
        assertThrows(IndexOutOfBoundsException.class,
                     () -> sb.insert(sb.length() + 1, '*'),
                     "Expected an exception to be thrown when inserting at an index greater than the length.");
    }

    @Test
    public void insertChar_indexZero_addsToFront() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata");

        // WHEN - insert char at the front
        sb.insert(0, '*');

        // THEN
        assertEquals("*ata", sb.toString(), "Expected the character to be inserted at the front.");
    }

    @Test
    public void insertChar_indexMiddle_addsToMiddle() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata-v2");

        // WHEN - insert the char at index 3
        sb.insert(3, '*');

        // THEN
        assertEquals("ata*-v2", sb.toString(), "Expected the character to be inserted at index 3.");
    }

    @Test
    public void insertChar_indexLength_addsToEnd() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata-v2");

        // WHEN - insert the char at the end
        sb.insert(sb.length(), '*');

        // THEN
        assertEquals("ata-v2*", sb.toString(), "Expected the character to be inserted at the end.");
    }

    @Test
    public void charAt_indexTooSmall_throwsException() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata");

        // WHEN/THEN - index out of bounds for a negative index
        assertThrows(IndexOutOfBoundsException.class,
                     () -> sb.charAt(-1),
                     "Expected an exception to be thrown when getting at a negative index.");
    }

    @Test
    public void charAt_indexTooLarge_throwsException() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata");

        // WHEN/THEN - index larger than the length of the builder
        assertThrows(IndexOutOfBoundsException.class,
                     () -> sb.charAt(sb.length()),
                     "Expected an exception to be thrown when getting at an index greater than the length.");
    }

    @Test
    public void charAt_indexZero_returnsFirstChar() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata-v2");

        // WHEN - get the first character
        char c = sb.charAt(0);

        // THEN
        assertEquals('a', c, "Expected the first character to be returned.");
    }

    @Test
    public void charAt_indexChar_returnsMiddleChar() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata-v2");

        // WHEN - get the character at index 3
        char c = sb.charAt(3);

        // THEN
        assertEquals('-', c, "Expected the character at index 3 to be returned.");
    }

    @Test
    public void charAt_indexLengthMinus1_returnsLastChar() {
        // GIVEN - a string builder with contents
        sb = new ATAStringBuilder("ata-v2");

        // WHEN - get the last character
        char c = sb.charAt(sb.length() - 1);

        // THEN
        assertEquals('2', c, "Expected the last character to be returned.");
    }
}

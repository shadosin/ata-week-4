package com.kenzie.groupactivity.bigspender.types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceSpendTest {

    private CustomerServiceSpend nedflixCustomerServiceSpend;

    private Customer nedflix;
    private ServiceSpend nedflixSagemakerSpend = new ServiceSpend(ServiceType.SAGEMAKER, 100L);
    private LocalDate nedflixJoinDate;

    @BeforeEach
    public void setup() throws ParseException {
        nedflixJoinDate = LocalDate.of(2008, 11, 1);
        nedflix = new Customer("nedflix", nedflixJoinDate);
        nedflixCustomerServiceSpend = new CustomerServiceSpend(nedflix, nedflixSagemakerSpend);
    }

    @Test
    void compareTo_withEqualSpend_returnsZero() {
        // GIVEN
        Customer equalNedflix = new Customer("nedflix", nedflixJoinDate);
        CustomerServiceSpend equalCustomerServiceSpend = new CustomerServiceSpend(equalNedflix, nedflixSagemakerSpend);

        // WHEN
        int result = nedflixCustomerServiceSpend.compareTo(equalCustomerServiceSpend);

        // THEN
        assertEquals(0, result);
    }

    @Test
    void compareTo_withLaterCustomerName_returnsNegative() {
        // GIVEN
        Customer laterCustomer = new Customer("orangish", nedflixJoinDate);
        CustomerServiceSpend laterCustomerServiceSpend = new CustomerServiceSpend(laterCustomer, nedflixSagemakerSpend);

        // WHEN
        int result = nedflixCustomerServiceSpend.compareTo(laterCustomerServiceSpend);

        // THEN
        assertTrue(result < 0);
    }

    @Test
    void compareTo_withEarlierCustomerName_returnsPostiive() {
        // GIVEN
        Customer earlierCustomer = new Customer("flixned", nedflixJoinDate);
        CustomerServiceSpend earlierCustomerServiceSpend = new CustomerServiceSpend(earlierCustomer, nedflixSagemakerSpend);

        // WHEN
        int result = nedflixCustomerServiceSpend.compareTo(earlierCustomerServiceSpend);

        // THEN
        assertTrue(result > 0);
    }

    @Test
    void equals_withEqualSpend_returnsTrue() {
        // GIVEN
        Customer equalNedflix = new Customer("nedflix", nedflixJoinDate);
        CustomerServiceSpend equalCustomerServiceSpend = new CustomerServiceSpend(equalNedflix, nedflixSagemakerSpend);

        // WHEN
        boolean result = nedflixCustomerServiceSpend.equals(equalCustomerServiceSpend);

        // THEN
        assertTrue(result,
                String.format("Expected %s and %s to equals() true",
                        nedflixCustomerServiceSpend,
                        equalCustomerServiceSpend)
        );
    }

    @Test
    void equals_withLaterCustomerName_returnsFalse() {
        // GIVEN
        Customer differentNamedCustomer = new Customer("acme enterprises", nedflixJoinDate);
        CustomerServiceSpend differentCustomerServiceSpend = new CustomerServiceSpend(differentNamedCustomer, nedflixSagemakerSpend);

        // WHEN
        boolean result = nedflixCustomerServiceSpend.equals(differentCustomerServiceSpend);

        // THEN
        assertFalse(result,
                String.format("Expected %s and %s to equals() false",
                        nedflixCustomerServiceSpend,
                        differentCustomerServiceSpend)
        );
    }
}

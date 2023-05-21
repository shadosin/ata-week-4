package com.kenzie.groupactivity.bigspender.types;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a customer who uses AWS.
 */
public class Customer implements Comparable {
    private String name;
    private LocalDate joinDate;

    /**
     * Constructor creating an AWS customer.
     * @param name The unique name of the customer.
     * @param joinDate The Data that the customer joined.
     */
    public Customer(String name, LocalDate joinDate) {
        this.name = name;
        this.joinDate = joinDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
            "name='" + name + '\'' +
            ", joinDate=" + joinDate +
            '}';
    }

    @Override
    public boolean equals(Object o) {
       if(this == o)return true;
       if(o == null || getClass() != o.getClass()) return false;

       Customer customer = (Customer) o;
       if (!name.equals(customer.name)) return false;
       return joinDate.equals(customer.joinDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, joinDate);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        if (o == null || getClass() != o.getClass()) return -1;

        Customer customer = (Customer) o;
        int nameComparison = this.name.compareTo(customer.name);
        if (nameComparison != 0) {
            return nameComparison; // Compare by name in ascending order
        } else {
            return this.joinDate.compareTo(customer.joinDate); // Compare by join date in ascending order
        }
    }
}

package com.kenzie.groupactivity.bigspender.types;

import java.util.Objects;

/**
 * Represents both a Customer and the details of one AWS service spend.
 */
public class CustomerServiceSpend implements Comparable {
    private Customer customer;
    private ServiceSpend serviceSpend;

    /**
     * Constructor taking a customer and a service spend.
     *
     * @param customer     the customer.
     * @param serviceSpend The service spend.
     */
    public CustomerServiceSpend(Customer customer, ServiceSpend serviceSpend) {
        this.customer = customer;
        this.serviceSpend = serviceSpend;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ServiceSpend getServiceSpend() {
        return serviceSpend;
    }

    @Override
    public String toString() {
        return "CustomerServiceSpend{" +
                "customer=" + customer +
                ", serviceSpend=" + serviceSpend +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerServiceSpend that)) return false;
        return getCustomer().equals(that.getCustomer()) && getServiceSpend().equals(that.getServiceSpend());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomer(), getServiceSpend());
    }


    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        if (o == null || getClass() != o.getClass()) return -1;

        CustomerServiceSpend other = (CustomerServiceSpend) o;

        int customerComparison = this.customer.compareTo(other.customer);
        if (customerComparison != 0) {
            return customerComparison; // Compare by customer (name and join date) in ascending order
        } else {
            int serviceComparison = this.serviceSpend.getServiceName().compareTo(other.serviceSpend.getServiceName());
            if (serviceComparison != 0) {
                return serviceComparison; // Compare by service name in ascending order
            } else {
                return Long.compare(this.serviceSpend.getSpend(), other.serviceSpend.getSpend()); // Compare by spend amount in ascending order
            }
        }
    }
}

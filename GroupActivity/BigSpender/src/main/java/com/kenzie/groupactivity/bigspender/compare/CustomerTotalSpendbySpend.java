package com.kenzie.groupactivity.bigspender.compare;

import com.kenzie.groupactivity.bigspender.types.CustomerTotalSpend;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class CustomerTotalSpendbySpend implements Comparator<CustomerTotalSpend> {
    @Override
    public int compare(CustomerTotalSpend o1, CustomerTotalSpend o2) {
        return Long.compare(o1.getTotalSpend(), o2.getTotalSpend());
    }

    @Override
    public Comparator<CustomerTotalSpend> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator<CustomerTotalSpend> thenComparing(Comparator<? super CustomerTotalSpend> other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public <U> Comparator<CustomerTotalSpend> thenComparing(Function<? super CustomerTotalSpend, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<CustomerTotalSpend> thenComparing(Function<? super CustomerTotalSpend, ? extends U> keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator<CustomerTotalSpend> thenComparingInt(ToIntFunction<? super CustomerTotalSpend> keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator<CustomerTotalSpend> thenComparingLong(ToLongFunction<? super CustomerTotalSpend> keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator<CustomerTotalSpend> thenComparingDouble(ToDoubleFunction<? super CustomerTotalSpend> keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }
}

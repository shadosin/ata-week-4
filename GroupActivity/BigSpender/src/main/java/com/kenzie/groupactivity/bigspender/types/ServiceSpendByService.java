package com.kenzie.groupactivity.bigspender.types;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class ServiceSpendByService implements Comparator<ServiceSpend> {
    @Override
    public int compare(ServiceSpend o1, ServiceSpend o2) {
        int result = Long.compare(o1.getSpend(), o2.getSpend());
        if (result == 0) {
            return o1.getServiceName().compareTo(o2.getServiceName());
        }
        return result;
    }

    @Override
    public Comparator<ServiceSpend> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator<ServiceSpend> thenComparing(Comparator<? super ServiceSpend> other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public <U> Comparator<ServiceSpend> thenComparing(Function<? super ServiceSpend, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<ServiceSpend> thenComparing(Function<? super ServiceSpend, ? extends U> keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator<ServiceSpend> thenComparingInt(ToIntFunction<? super ServiceSpend> keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator<ServiceSpend> thenComparingLong(ToLongFunction<? super ServiceSpend> keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator<ServiceSpend> thenComparingDouble(ToDoubleFunction<? super ServiceSpend> keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }
}

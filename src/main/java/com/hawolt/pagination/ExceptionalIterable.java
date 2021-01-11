package com.hawolt.pagination;

public interface ExceptionalIterable<T> {

    boolean hasNext();

    T next() throws Exception;
}

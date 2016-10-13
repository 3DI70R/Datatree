package ru.threedisevenzeror.datatree.util;

/**
 * Created by ThreeDISevenZeroR on 13.10.2016.
 */
public interface Function3<T1, T2, T3, R> {
    R apply(T1 o1, T2 o2, T3 o3);
}

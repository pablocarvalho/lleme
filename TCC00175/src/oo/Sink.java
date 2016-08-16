package oo;

public interface Sink<T> {

    T flush(T t);
}

package Utiles;


public class Tupla<T,K> {
private final Te<T> N1;
private final Te<K> N2;
public Tupla(T x1,K x2) {
	N1 = new Te<>(x1);
	N2 = new Te<>(x2);
}

public T getN1() {
	return N1.geT();
}

public K getN2() {
	return N2.geT();
}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

/**
 *
 * @author SchWarZer
 * @param <T>
 * @param <K>
 * @param <L>
 */
public class Trio<T,K,L> {
private final Te<T> N1;
private final Te<K> N2;
private final Te<L> N3;
public Trio(T x1,K x2, L x3) {
	N1 = new Te<>(x1);
	N2 = new Te<>(x2);
        N3 = new Te<>(x3);
}

public T getN1() {
	return N1.geT();
}


public K getN2() {
	return N2.geT();
}

    public L getN3() {
        return N3.geT();
    }

}

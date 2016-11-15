package org.ananichev;

import java.util.Scanner;

/**
 * Created by SBT-Ananichev-LD on 14.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        TestBean testBean = new TestBean();
        testBean.setInteger(1);
        testBean.setL(1L);
        testBean.setString("1");
        TestBean from = new TestBean();
        from.setInteger(2);
        from.setString("2");
        from.setL(2L);
        System.out.println("Test bean values I = " + testBean.getInteger() + " L = " + testBean.getL() + " String = " + testBean.getString());
        System.out.println("Test bean from values I = " + from.getInteger() + " L = " + from.getL() + " String = " + from.getString());
        System.out.println("Use assign");
        BeanUtils.assign(testBean, from);
        System.out.println("Test bean values I = " + testBean.getInteger() + " L = " + testBean.getL() + " String = " + testBean.getString());
        SuperBean superBean = new SuperBean();
        superBean.setInteger(3);
        BeanUtils.assign(superBean, from);
        System.out.println("Use assign");
        System.out.println("Super Bean values I = " + testBean.getInteger());
    }
}

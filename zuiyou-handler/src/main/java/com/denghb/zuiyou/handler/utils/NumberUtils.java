package com.denghb.zuiyou.handler.utils;

import java.math.BigDecimal;

/**
 * Created by denghb on 2017/4/29.
 */
public class NumberUtils {


    /**
     * a > b
     *
     * @param a
     * @param b
     */
    public static boolean gt(Comparable a, Comparable b) {
        if (null != a && null != b) {
            if (1 == a.compareTo(b)) {
                return true;
            }
        }

        return false;
    }

    /**
     * a < b
     *
     * @param a
     * @param b
     */
    public static boolean lt(Comparable a, Comparable b) {
        if (null != a && null != b) {
            if (-1 == a.compareTo(b)) {
                return true;
            }
        }
        return false;
    }

    /**
     * a = b
     *
     * @param a
     * @param b
     */
    public static boolean eq(Comparable a, Comparable b) {
        if (null != a && null != b) {
            if (0 == a.compareTo(b)) {
                return true;
            }
        }
        return false;
    }


    /**
     * a > b || a = b
     *
     * @param a
     * @param b
     */
    public static boolean gtOrEq(Comparable a, Comparable b) {
        if (null != a && null != b) {
            if (0 == a.compareTo(b) || 1 == a.compareTo(b)) {
                return true;
            }
        }
        return false;
    }

    /**
     * a < b || a = b
     *
     * @param a
     * @param b
     */
    public static boolean ltOrEq(Comparable a, Comparable b) {
        if (null != a && null != b) {

            if (0 == a.compareTo(b) || -1 == a.compareTo(b)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("2");
        BigDecimal b = new BigDecimal("2");
        BigDecimal c = new BigDecimal("2");


        System.out.println(between(a, b, c));
    }


    /**
     * a <= b <= c
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static boolean between(Comparable a, Comparable b, Comparable c) {
        if (null != a && null != b && null != c) {

            if (ltOrEq(a, b) && ltOrEq(b, c)) {
                return true;
            }

        }

        return false;
    }
}

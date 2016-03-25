package com.mdground.yideguanregister.util;

/**
 * Created by yoghourt on 11/25/15.
 */
public class DrugCalcUtil {

    public static float getFrequencyFactorByFrequency(String frequency) {
        if ("QD".equals(frequency)) {
            return 1; // 一天一次
        } else if ("BID".equals(frequency)) {
            return 2; // 一天两次
        } else if ("TID".equals(frequency)) {
            return 3; // 一天三次
        } else if ("QID".equals(frequency)) {
            return 4; // 一天四次
        } else if ("QH".equals(frequency)) {
            return 24; // 每小时一次
        } else if ("Q2H".equals(frequency)) {
            return 12; // 每两小时一次
        } else if ("Q4H".equals(frequency)) {
            return 6; // 每四小时一次
        } else if ("Q6H".equals(frequency)) {
            return 4; // 每6小时一次
        } else if ("Q8H".equals(frequency)) {
            return 3; // 每8小时一次
        } else if ("QOD".equals(frequency)) {
            return 0.5f; // 隔天一次
        } else if ("Q3D".equals(frequency)) {
            return 1 / 3f; // 隔三日一次
        } else if ("QN".equals(frequency)) {
            return 1; // 每晚一次
        } else if ("QWD".equals(frequency)) {
            return 1 / 7f; // 每周一次
        } else if ("QMD".equals(frequency)) {
            return 1 / 30f; // 每月一次
        }
        return 1;
    }
}

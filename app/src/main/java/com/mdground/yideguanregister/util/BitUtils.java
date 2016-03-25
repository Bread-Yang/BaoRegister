package com.mdground.yideguanregister.util;

/**
 * Created by yoghourt on 1/22/16.
 */
public class BitUtils {
    public static boolean hasBit(int originalCode, int haveBit) {
        return (originalCode & haveBit) == haveBit;
    }
}

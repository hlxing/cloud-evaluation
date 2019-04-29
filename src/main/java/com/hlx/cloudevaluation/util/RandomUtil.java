package com.hlx.cloudevaluation.util;

import java.util.UUID;

public class RandomUtil {

    public static String get() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}

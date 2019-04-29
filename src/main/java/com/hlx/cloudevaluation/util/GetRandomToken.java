package com.hlx.cloudevaluation.util;

import java.util.UUID;

public class GetRandomToken {

    public static String getRandomToken() {
        return UUID.randomUUID().toString();
    }
}

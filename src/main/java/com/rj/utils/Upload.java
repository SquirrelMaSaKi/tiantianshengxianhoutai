package com.rj.utils;

import java.util.UUID;

public class Upload {
    public static String newFilename(String ext) {
        String str = UUID.randomUUID().toString().replace("-", "");
        return str+"."+ext;
    }

}

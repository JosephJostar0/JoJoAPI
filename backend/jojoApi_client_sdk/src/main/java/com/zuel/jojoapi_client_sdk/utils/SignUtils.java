package com.zuel.jojoapi_client_sdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

import java.util.Map;

public class SignUtils {
    public static String genSign(Map<String, String> hashMap, String secretKey) {
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String content = hashMap.toString() + "." + secretKey;
        return md5.digestHex(content);
    }
}

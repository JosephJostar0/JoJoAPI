package com.zuel.jojoapi_client_sdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.zuel.jojoapi_client_sdk.model.User;
import com.zuel.jojoapi_client_sdk.utils.SignUtils;


import java.util.HashMap;
import java.util.Map;

public class JojoApiClient {
    private String accessKey;
    private String secretKey;

    private static final String GATEWAY_HOST = "http://localhost:8090";

    public JojoApiClient(String secretKey, String accessKey) {
        this.secretKey = secretKey;
        this.accessKey = accessKey;
    }

    private Map<String, String> getHeaderMap() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(100));
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", SignUtils.genSign(hashMap, secretKey));
        return hashMap;
    }

    public String getNameByGet(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.get(GATEWAY_HOST + "/api/name/get", paramMap);
        System.out.println(result);
        return result;
    }

    public String getNameByPost(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.post(GATEWAY_HOST + "/api/name/post", paramMap);
        System.out.println(result);
        return result;
    }

    public String getUserNameByPost(User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name/user/")
                .addHeaders(getHeaderMap()).body(json).execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }
}

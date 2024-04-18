package com.zuel.jojoapi_client_sdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONException;
import cn.hutool.json.JSONUtil;
import com.zuel.jojoapi_client_sdk.model.SpeakerTTS;
import com.zuel.jojoapi_client_sdk.model.User;
import com.zuel.jojoapi_client_sdk.utils.SignUtils;


import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class JojoApiClient {
    private final String accessKey;
    private final String secretKey;

    private static final String GATEWAY_HOST = "172.17.195.245:8090";

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

    public String getRandMail() {
        HttpResponse httpResponse = HttpRequest.get(GATEWAY_HOST + "/api/rand/getMail")
                .addHeaders(getHeaderMap()).execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }

    public String postRandMail() {
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/rand/postMail")
                .addHeaders(getHeaderMap()).execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }

    public String postSpeakers() {
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/ai/speakers")
                .addHeaders(getHeaderMap()).execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }

    public String postTTS(String speaker, String message) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("speaker", speaker);
        hashMap.put("message", message);
        String json = JSONUtil.toJsonStr(hashMap);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/ai/tts")
                .addHeaders(getHeaderMap()).body(json).execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }

    public String postSing(String songName) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("song", songName);
        String json = JSONUtil.toJsonStr(hashMap);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/ai/sing")
                .addHeaders(getHeaderMap()).body(json).execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }
}

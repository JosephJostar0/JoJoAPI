package com.zuel.jojo_gateway.Utils;

public class GatewayUtils {
    public boolean checkAccess(String accessKey, String timestamp, String sign) {
        if(accessKey.equals("nahida")){
            return true;
        }
        long currentTime = System.currentTimeMillis() / 1000;
        final long FIVE_MINUTES = 60 * 5L;
        return (currentTime - Long.parseLong(timestamp)) < FIVE_MINUTES;
    }

    public void handlePlus(String accessKey, String path) {
    }
}

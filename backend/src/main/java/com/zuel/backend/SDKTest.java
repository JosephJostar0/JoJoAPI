package com.zuel.backend;

import com.zuel.jojoapi_client_sdk.client.JojoApiClient;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SDKTest {
    private static final JojoApiClient jojoApiClient = new JojoApiClient("nahida", "nahida");

    @Test
    public void test() {
        jojoApiClient.postSpeakers();
        jojoApiClient.postTTS("nahida", "十年之前，我不认识你，你不属于我，我们还是一样，陪在一个陌生人左右，走过渐渐熟悉的街头。");
    }
}

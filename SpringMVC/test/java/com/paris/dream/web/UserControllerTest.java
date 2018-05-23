package com.paris.dream.web;

import com.paris.dream.domain.User;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by Mashencai on 2018/5/22.
 */
public class UserControllerTest {

    @Test
    public void testHandle41() {
        // restTemplate是Spring的模板类，在客户端程序中可使用该类调用Web服务器端的服务，它还支持REST风格的url。
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.add("userName", "tom");
        form.add("password", "123456");
        form.add("age", "45");
        // 第一个参数为URL，第二个参数通过MultiValueMap准备报文体的参数数据
        restTemplate.postForLocation("http://localhost:8081/user/handle41.html", form);
    }

    @Test
    public void testHandle42() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        // 第二个参数为报文体参数数据，第三个参数指定方法的返回值类型，第四个参数为Url占位符参数的值。
        byte[] response = restTemplate.postForObject(
                "http://localhost:8081/user/handle42/{itemId}.html",
                null, byte[].class, "1233");
        Resource outFile = new FileSystemResource("g:/image_copy.jpg");
        FileCopyUtils.copy(response, outFile.getFile());
    }

    @Test
    public void testApi() throws InterruptedException {
//        RestTemplate template = new RestTemplate()
        AsyncRestTemplate template = new AsyncRestTemplate();

        // 1. 这里的执行会立即返回，不会同步阻塞。
        ListenableFuture<ResponseEntity<User>> future =
                template.getForEntity("http://localhost:8081/user/api.html", User.class);

        Thread.sleep(11L * 1000);

        // 2. 处理服务器端响应的异步回调方法。待服务器端返回响应请求后，此处注册的回调函数会被自动异步调用。
        future.addCallback(new ListenableFutureCallback<ResponseEntity<User>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("=======client failure : " + throwable);
            }

            @Override
            public void onSuccess(ResponseEntity<User> userResponseEntity) {
                System.out.println("=======client get result : " + userResponseEntity.getBody());
            }
        });
        System.out.println("==no wait");
    }// 需添加
}

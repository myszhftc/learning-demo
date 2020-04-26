package com.example.oauth.utils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author hufei
 * @date 2020/4/26
 */
public class HttpClientUtils {

    public static String get(String token) throws IOException {
        HttpGet httpGet = new HttpGet("https://api.github.com/user");
        httpGet.addHeader("accept", "application/json");
        httpGet.addHeader("Authorization", "token " + token);
        try(CloseableHttpClient httpClient = HttpClientBuilder.create().build();CloseableHttpResponse response = httpClient.execute(httpGet)) {
            return EntityUtils.toString(response.getEntity());
        }
    }

    public static String post(String url) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("accept", "application/json");
        try(CloseableHttpClient httpClient = HttpClientBuilder.create().build();CloseableHttpResponse response = httpClient.execute(httpPost)) {
            return EntityUtils.toString(response.getEntity());
        }
    }

}

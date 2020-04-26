package com.example.oauth.web;

import com.alibaba.fastjson.JSONObject;
import com.example.oauth.utils.HttpClientUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @author hufei
 * @date 2020/4/26
 */
@Controller
public class OauthController {

    private static final String CLIENT_ID = "78e14e65587cc1d4dbad";
    private static final String CLIENT_SECRET = "488f39ad1ce2f58a7089cbc5dcf497ebc00508e8";
    private static final String REDIRECT_URL = "http://localhost:8080/oauth/redirect";

    @RequestMapping
    public String main(Model model) {
        model.addAttribute("clientId", CLIENT_ID);
        model.addAttribute("redirectUrl", REDIRECT_URL);
        return "index";
    }

    @RequestMapping("/oauth/redirect")
    public String redirect(String code) throws IOException {
        String url = "https://github.com/login/oauth/access_token?client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&code=" + code;
        String tokenJson = HttpClientUtils.post(url);
        JSONObject jsonObject = JSONObject.parseObject(tokenJson);
        return "redirect:/welcome?token=" + jsonObject.getString("access_token");
    }

    @RequestMapping("/welcome")
    @ResponseBody
    public String welcome(String token) throws IOException {
        return HttpClientUtils.get(token);
    }

}

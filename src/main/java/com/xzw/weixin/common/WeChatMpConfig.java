package com.xzw.weixin.common;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class WeChatMpConfig {

    @Autowired
    private  WeChatConfigAccount account;

    @Bean
    public WxMpService wxMpService(){
        WxMpService wxMpService=new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(configStorage());
        return wxMpService;
    }

    @Bean
    public WxMpInMemoryConfigStorage configStorage(){
        WxMpInMemoryConfigStorage configStorage=new WxMpInMemoryConfigStorage();
        configStorage.setAppId(account.getAppId());
        configStorage.setSecret(account.getSecret());
        return  configStorage;
    }
}

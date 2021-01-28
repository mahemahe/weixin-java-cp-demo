package com.github.binarywang.demo.wx.cp.controller;

import com.github.binarywang.demo.wx.cp.config.WxCpConfiguration;
import com.mhc.bs.common.base.APIResult;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpMessageService;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.message.WxCpMessage;
import me.chanjar.weixin.cp.bean.message.WxCpMessageSendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> 发送消息 </p>
 *
 * @author mahe <mahe@maihaoche.com>
 * @date 2021/1/28 周四 9:59 上午
 */
@RequestMapping("wx/send")
@RestController
public class WxSendController {

    /**
     * 发送text信息
     * @param text
     * @return
     */
    @PostMapping("/text")
    public APIResult<WxCpMessageSendResult> sendText(@RequestBody String text) {
        WxCpService wxCpService = WxCpConfiguration.getCpService(1000003);
        WxCpMessageService wxCpMessageService = wxCpService.getMessageService();
        WxCpMessage wxCpMessage = WxCpMessage.TEXT().content(text).toUser("bleedfly|WangZiJian|WeiFan|SanDi").build();
        WxCpMessageSendResult result = null;
        try {
            result = wxCpMessageService.send(wxCpMessage);
        } catch (WxErrorException e) {
            e.printStackTrace();
            return APIResult.error(e.getMessage());
        }
        return APIResult.ok(result);
    }
}

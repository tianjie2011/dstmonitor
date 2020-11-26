package com.example.dstmonitor.config;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiSnsGetuserinfoBycodeRequest;
import com.dingtalk.api.request.OapiSnsSendMsgRequest;
import com.dingtalk.api.response.OapiSnsGetuserinfoBycodeResponse;
import com.dingtalk.api.response.OapiSnsSendMsgResponse;
import com.taobao.api.ApiException;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DingTalkMessage {
//
//    DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/sns/getuserinfo_bycode");
//
//    public DefaultDingTalkClient mydingClient
//
//    {
//
//        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/sns/send_msg");
//        OapiSnsSendMsgRequest req = new OapiSnsSendMsgRequest();
//        req.setCode(code);
//        OapiSnsSendMsgRequest.Eapp eapp = new OapiSnsSendMsgRequest.Eapp();
//        eapp.setImg("@lALPBY0V5EuR4oDNAcrNAs4");
//        eapp.setContent("非常感谢您的反馈，非常感谢您的反馈，非常感谢您的反馈，非常感谢您的反馈，非常感谢您的反馈 \n\n" + System.currentTimeMillis());
//        eapp.setTitle("工单已回复");
//        eapp.setLink("eapp://page/index?param=aaa");
//        OapiSnsSendMsgRequest.Msg msg = new OapiSnsSendMsgRequest.Msg();
//        msg.setMsgtype("eapp");
//        msg.setEapp(eapp);
//        req.setMsg(msg);
//        OapiSnsSendMsgResponse response = client.execute(req, Constant.APP_ID, Constant.APP_SECRET)
//
//    }
}

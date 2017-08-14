package com.hc.henghuirong.server.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by dell-3020 on 2017/3/22.
 */
public class SignUtils {

    private static Logger logger = LoggerFactory.getLogger(SignUtils.class);

    /**
     * MD5生成签名字符串
     *
     * @param params 需签名参数
     * @param key    MD5key
     * @return
     */
    public static String getSign(Map<String, String> params, String key) {
        if (params == null) {
            return null;
        }
        String genSign = "";
        try {
            // 生成签名原文  
            String signSrc = getSignContent(params);
            // MD5的方式签名  
            signSrc += "&KEY=" + key;
            // 加密后的字符串
            genSign = Md5Utils.md5(signSrc);

        } catch (Exception e) {

            logger.error("getSign error!", e);

        }
        return genSign;
    }

    /**
     * 构建签名原文
     *
     * @param params 参数
     * @return
     */
    private static String getSignContent(Map<String, String> params) {
        params.remove("sign");
        StringBuffer content = new StringBuffer();

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            content.append((i == 0 ? "" : "&") + key + "=" + value);
        }
        return content.toString();
    }

    /**
     * MD5验证签名
     *
     * @param params
     * @param key
     * @return
     */
    public static boolean checkSign(Map<String, String> params, String key) {
        String sign = params.get("sign");
        return sign.equals(getSign(params, key));
    }


}

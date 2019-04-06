package com.albenyuan.web.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @Author albenyuan
 * @Date 2017-10-30 15:23
 */

public class DecryptionRequestWrapper extends HttpServletRequestWrapper {

    public DecryptionRequestWrapper(HttpServletRequest request) {
        super(request);
    }

}

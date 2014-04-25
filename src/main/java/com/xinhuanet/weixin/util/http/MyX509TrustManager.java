package com.xinhuanet.weixin.util.http;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

public class MyX509TrustManager implements X509TrustManager {  
  
  
    public X509Certificate[] getAcceptedIssuers() {  
        return null;  
    }

	public void checkClientTrusted(X509Certificate[] arg0, String arg1)
			throws CertificateException {
	}

	public void checkServerTrusted(X509Certificate[] arg0, String arg1)
			throws CertificateException {
	}  
}

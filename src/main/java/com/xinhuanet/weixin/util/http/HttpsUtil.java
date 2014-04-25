package com.xinhuanet.weixin.util.http;


import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpsUtil {

	public static void main(String[] args) throws Exception {
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(new AuthScope("localhost", 8080),
				new UsernamePasswordCredentials("username", "password"));
		CloseableHttpClient httpclient = HttpClients.custom()
				.setDefaultCredentialsProvider(credsProvider).build();
		String host = "https://login.taobao.com";
		HttpHost host1 = new HttpHost(host);
		HttpGet get = new HttpGet("https://login.taobao.com");
		System.out.println(get.getConfig());
		//"www.verisign.com"
		try {
			HttpHost target = new HttpHost("www.verisign.com", 443, "https");
			System.out.println(target.getHostName());
			HttpHost proxy = new HttpHost("202.84.17.41", 8080);

			RequestConfig config = RequestConfig.custom().setProxy(proxy)
					.build();
			HttpGet httpget = new HttpGet("https://login.taobao.com");
			httpget.setConfig(config);

			System.out.println("Executing request " + httpget.getRequestLine()
					+ " to " + target + " via " + proxy);

			CloseableHttpResponse response = httpclient
					.execute(target, httpget);
			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				EntityUtils.consume(response.getEntity());
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

	
	public static void main1(String[] args) throws Exception {
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope("localhost", 443),
                new UsernamePasswordCredentials("username", "password"));
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();
        try {
            HttpGet httpget = new HttpGet("http://localhost/");

            System.out.println("Executing request " + httpget.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                EntityUtils.consume(response.getEntity());
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
}

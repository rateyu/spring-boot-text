package com.ming.springboottext;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class HttpTool {
    public static void main(String[] args) {


        RestTemplate restTemplate = new RestTemplate();

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        //设置超时时间

        factory.setReadTimeout(15000);// ms
        factory.setConnectTimeout(15000);// ms
        ClientHttpRequestFactory clientHttpRequestFactory;

//        HttpClientOption httpClientOption;
//        ClientHttpRequest clientHttpRequest = new ClientHttpRequest();
//        ClientHttpRequest.

//        HttpHeaders headers = new HttpHeaders();
//        headers
//        restTemplate.setRequestFactory();
//        restTemplate.setClientHttpRequestInitializers();
        try {
            getLocalHostIp();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        RequestConfig requestConfig =
                RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(1000).build();
        CloseableHttpClient httpclient = null;

//        InetAddress localAddress
        //TODO 此处可以设置http地址，用于测试http服务器的性能
//        RequestConfig.custom().setLocalAddress();
        CloseableHttpResponse h_response = null;

        httpclient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();

//            httpclient = HttpClientBuilder.create().build();

//        HttpPost postMethod = new HttpPost(oaRestfulServiceUrl);
    }

    public static InetAddress getLocalHostIp() throws SocketException {
        Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip = null;
        while (allNetInterfaces.hasMoreElements()) {
            NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
            //System.out.println(netInterface.getName());
            Enumeration addresses = netInterface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                ip = (InetAddress) addresses.nextElement();
                if (ip != null && ip instanceof Inet4Address) {
                    System.out.println("本机的ip=" + ip.getHostAddress());
                    break;
                }
            }
        }
        return ip;
    }
}

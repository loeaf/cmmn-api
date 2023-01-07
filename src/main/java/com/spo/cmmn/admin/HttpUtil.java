package com.spo.cmmn.admin;

import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HttpUtil {
	
	// 헤더
	private HttpHeaders headers;
	// 바디 <Key, Value>
	//private MultiValueMap<String, Object> body;
	private Map<String, Object> body;
	// 타임아웃
	private HttpComponentsClientHttpRequestFactory factory;
	// 요청 URL
	private StringBuilder urlBuilder;
	private boolean queryStringToken;
	private String url;
	// 요청방식
	private String method;
	
	public HttpUtil() {
		this.headers = new HttpHeaders();
		this.factory = new HttpComponentsClientHttpRequestFactory();
		this.factory.setConnectTimeout(5000);
		this.factory.setReadTimeout(5000);
		//this.body = new LinkedMultiValueMap<String, Object>();
		this.body = new HashMap<String, Object>();
		this.queryStringToken = true;
	}
	
	/**
	 * content-type 설정 : new MediaType 설정 값
	 */
	public HttpUtil contentType(String type, String subType, String charSet) {
		this.headers.setContentType(new MediaType(type, subType, Charset.forName(charSet)));
		
		return this;
	}
	
	/**
	 * connect-timeout 설정
	 */
	public HttpUtil connectTimeout(int time) {
		this.factory.setConnectTimeout(time);
		return this;
	}
	
	/**
	 * reat-timeout 설정
	 */
	public HttpUtil readTimeout(int time) {
		this.factory.setReadTimeout(time);
		return this;
	}
	
	/**
	 * 요청 URL 설정
	 */
	public HttpUtil url(String url) {
		this.urlBuilder = new StringBuilder();
		urlBuilder.append(url);
		return this;
	}
	
	/**
	 * 쿼리스트링 설정
	 */
	public HttpUtil queryString(String name, String value) {
		Assert.notNull(urlBuilder, "RUL 미입력");
		
		if ( queryStringToken ) {
			urlBuilder.append("?");
			urlBuilder.append(name);
			urlBuilder.append("=");
			urlBuilder.append(value);
			
			queryStringToken = false;
			
		} else {
			urlBuilder.append("&");
			urlBuilder.append(name);
			urlBuilder.append("=");
			urlBuilder.append(value);
			
		}
		
		return this;
	}
	
	/**
	 * 요청 방식 설정(get, post)
	 */
	public HttpUtil method(String method) {
		this.method = method.toUpperCase();
		
		return this;
	}
	
	/**
	 * body 요청 파라미터 설정 : key, value
	 */
	public HttpUtil body(Map<String, Object> params) {
		Iterator<String> itr = params.keySet().iterator();

		while(itr.hasNext()) {
			String key = itr.next();
			body.put(key, params.get(key));
		}
		
		return this;
	}
	
	/**
	 * HTTP 요청 후 결과 반환(status, header, body)
	 */
	public HashMap<String, Object> build(){
		
		HashMap<String, Object> result = new HashMap<>();
		
		RestTemplate restTemplate = new RestTemplate(factory);

		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

		url = urlBuilder.toString();
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ url :: " + url);
		
		ResponseEntity<String> response = null;
		
		if ( "GET".equals(method) ) {
			response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

		} else if ( "POST".equals(method) ) {		
			response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		}

		assert response != null;
		result.put("status", response.getStatusCode());
		result.put("header", response.getHeaders());
		result.put("body", response.getBody());
		
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ status :: " + result.get("status").toString());
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ header :: " + result.get("header").toString());
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ body :: " + result.get("body").toString());
		
		queryStringToken = true;
		
		return result;
	}
}

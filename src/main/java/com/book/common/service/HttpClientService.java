package com.book.common.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HttpClientService {
	@Autowired(required=false)
	private CloseableHttpClient httpClient;
	@Autowired(required=false)//请求的参数
	private RequestConfig requestConfig;
	/**
	 * 编辑工具类的思路:
	 *  1.编辑Get()工具类
	 *  	1.1get请求如何添加参数???, www.jt.com/addUser?id=1&name=tom
	 *  	1.2get如何解决获取参数后的乱码问题,设定字符集
	 *  	1.3应该重构多个get方法满足不同的需求
	 *  2.编辑Post()工具类
	 *  	2.1Post请求如何传递参数,表单提交时采用post提交
	 *  	2.2post乱码相对而言比较好解决
	 *  	2.3满足不同的post需求
	 */
	public String doGet(String url,Map<String,String> params,String encode) throws Exception{
		//1.判断是否还有参数
		if(params !=null){
			//定义拼接参数的工具类
			URIBuilder builder=new URIBuilder(url);
			//循环遍历Map获取key和value
			for(Map.Entry<String , String > entry:params.entrySet()){
				builder.setParameter(entry.getKey(), entry.getValue());
			}
			url=builder.build().toString();
		}
		//2.定义字符集编码
		if(null==encode){
			//设定默认字符集
			encode="UTF-8";
		}
		//System.out.println("url="+url);
		//3.定义GET请求
		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(requestConfig);//定义请求的设置
		//3.准备发出请求+
		CloseableHttpResponse httpResponse=null;
		try{
			httpResponse = httpClient.execute(httpGet);
			if(httpResponse.getStatusLine().getStatusCode()==200){
				String result = EntityUtils.toString(httpResponse.getEntity(),encode);
				//System.out.println("result="+result);
				return result;
			}
			httpResponse.close();	
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public String doGet(String url,Map<String,String> params) throws Exception{
		return doGet(url, params, null);
	}
	public String doGet(String url) throws Exception{
		return doGet(url,null,null);
	}
	public String doGet(String url,String encode) throws Exception{
		return doGet(url, null, encode);
	}

	//定义Post提交
	public String doPost(String url,Map<String,String> params,String encode) throws Exception{
		//1.构建HTTPPost对象
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(requestConfig);//定义配置
		//2.判断是否有参数
		if(null !=params){
			//定义Post提交参数
			List<NameValuePair> paramList=new ArrayList<>();
			for(Map.Entry<String, String> entry:params.entrySet()){
				paramList.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
			}
			if(null==encode){
				encode="UTF-8";
			}
			//构建表单提交实体
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(paramList, encode);
			httpPost.setEntity(formEntity);	//设定数据提交的参数
		}
		//发出POST请求
		CloseableHttpResponse httpResponse = null;	//定义响应对象
		try {
			httpResponse = httpClient.execute(httpPost);
			if(httpResponse.getStatusLine().getStatusCode() == 200){
				//表示响应成功
				String result = EntityUtils.toString(httpResponse.getEntity());
				return result;
			}
			//执行完成后将链接释放
			httpResponse.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String doPost(String url,String encode) throws Exception{

		return doPost(url, null, encode);
	}
	public String doPost(String url,Map<String,String> params) throws Exception{
		return doPost(url, params, null);
	}
	public String doPost(String url) throws Exception{

		return doPost(url, null, null);
	}




















}

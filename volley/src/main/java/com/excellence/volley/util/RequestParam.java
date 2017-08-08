package com.excellence.volley.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * <pre>
 *     author : VeiZhang
 *     blog   : http://tiimor.cn
 *     time   : 2017/8/7
 *     desc   : 请求参数
 * </pre>
 */

public class RequestParam
{
	private final Map<String, String> mUrlParams = new LinkedHashMap<>();
	private final Map<String, String> mHeaders = new LinkedHashMap<>();
	private final Map<String, String> mBodyParams = new LinkedHashMap<>();

	public void putQueryParam(String key, String value)
	{
		if (key != null && value != null)
			mUrlParams.put(key, value);
	}

	public void putQueryParam(String key, int value)
	{
		putQueryParam(key, String.valueOf(value));
	}

	public void putQueryParam(String key, long value)
	{
		putQueryParam(key, String.valueOf(value));
	}

	public void addHeader(String name, String value)
	{
		mHeaders.put(name, value);
	}

	public void setHeader(String name, String value)
	{
		mHeaders.clear();
		addHeader(name, value);
	}

	public void putBodyParam(String key, String value)
	{
		if (key != null && value != null)
			mBodyParams.put(key, value);
	}

	public void putBodyParam(String key, int value)
	{
		putBodyParam(key, String.valueOf(value));
	}

	public void putBodyParam(String key, long value)
	{
		putBodyParam(key, String.valueOf(value));
	}

	public String getQueryParamsString()
	{
		StringBuilder builder = new StringBuilder();
		Set<Entry<String, String>> entries = mUrlParams.entrySet();
		for (Entry<String, String> entry : entries)
		{
			builder.append(entry.getKey());
			builder.append("=");
			builder.append(entry.getValue());
			builder.append("&");
		}
		if (builder.length() > 0)
			builder.deleteCharAt(builder.length() - 1);
		return builder.toString();
	}

	public Map<String, String> getHeaders()
	{
		return mHeaders;
	}

	public Map<String, String> getBodyParams()
	{
		return mBodyParams;
	}
}

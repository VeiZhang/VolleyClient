package com.excellence.volley.util;

import org.json.JSONException;

/**
 * <pre>
 *     author : VeiZhang
 *     blog   : http://tiimor.cn
 *     time   : 2017/8/8
 *     desc   : JSON解析器
 * </pre>
 */

public abstract class BaseJsonParser<T>
{
	public abstract T parse(String response) throws JSONException;
}

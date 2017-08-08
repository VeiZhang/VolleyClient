package com.excellence.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import static com.android.volley.Request.Method.GET;
import static com.android.volley.Request.Method.POST;

/**
 * <pre>
 *     author : VeiZhang
 *     blog   : http://tiimor.cn
 *     time   : 2017/8/7
 *     desc   : 外部调用接口
 * </pre>
 */

public class HttpTool
{
	public static final String TAG = HttpTool.class.getSimpleName();

	/**
	 * Get请求
	 *
	 * @param url 请求链接
	 * @param callBack 回调
	 * @param <T>
	 */
	public static <T> void get(String url, HttpCallBack<T> callBack)
	{
		get(null, url, null, callBack);
	}

	public static <T> void get(String url, RequestParam param, HttpCallBack<T> callBack)
	{
		get(null, url, param, callBack);
	}

	public static <T> void get(Object tag, String url, HttpCallBack<T> callBack)
	{
		get(tag, url, null, callBack);
	}

	public static <T> void get(Object tag, String url, RequestParam param, HttpCallBack<T> callBack)
	{
		request(GET, tag, url, param, callBack);
	}

	/**
	 * Post请求
	 *
	 * @param url 请求链接
	 * @param callBack 回调
	 * @param <T>
	 */
	public static <T> void post(String url, HttpCallBack<T> callBack)
	{
		post(null, url, null, callBack);
	}

	public static <T> void post(String url, RequestParam param, HttpCallBack<T> callBack)
	{
		post(null, url, param, callBack);
	}

	public static <T> void post(Object tag, String url, HttpCallBack<T> callBack)
	{
		post(tag, url, null, callBack);
	}

	private static <T> void post(Object tag, String url, RequestParam param, HttpCallBack<T> callBack)
	{
		request(POST, tag, url, param, callBack);
	}

	/**
	 * 新建网络请求
	 *
	 * @param method 请求类型
	 * @param tag 请求标记
	 * @param url 请求链接
	 * @param param 请求参数
	 * @param callBack 数据回调
	 * @param <T>
	 */
	public static <T> void request(int method, Object tag, String url, final RequestParam param, final HttpCallBack<T> callBack)
	{
		VolleyUtil.checkRequestQueue();
		StringRequest request = new StringRequest(method, url, new Listener<String>()
		{
			@Override
			public void onResponse(String response)
			{
				if (callBack == null)
					return;

				Type type = getType(callBack.getClass());
				if (type == String.class)
				{
					callBack.onSuccess((T) response);
				}
				else
				{
					Gson gson = new Gson();
					T t = gson.fromJson(response, type);
					callBack.onSuccess(t);
				}
			}
		}, new ErrorListener()
		{
			@Override
			public void onErrorResponse(VolleyError error)
			{
				if (callBack == null)
					return;
				callBack.onFail(error.getMessage());
			}
		})
		{
			@Override
			protected Map<String, String> getParams() throws AuthFailureError
			{
				if (param != null && param.getBodyParams() != null && param.getBodyParams().size() > 0)
					return param.getBodyParams();
				return super.getParams();
			}

			@Override
			public Map<String, String> getHeaders() throws AuthFailureError
			{
				if (param != null && param.getHeaders() != null && param.getHeaders().size() > 0)
					return param.getHeaders();
				return super.getHeaders();
			}
		};
		request.setTag(tag);
		VolleyUtil.addToRequestQueue(request);
	}

	/**
	 * 取消标记请求队列
	 *
	 * @param tag
	 */
	public static void cancel(Object tag)
	{
		VolleyUtil.cancel(tag);
	}

	/**
	 * 取消所有请求队列
	 *
	 * @param requestFilter
	 */
	public static void cancelAll(RequestQueue.RequestFilter requestFilter)
	{
		VolleyUtil.cancelAll(requestFilter);
	}

	/**
	 * 取消所有请求队列
	 */
	public static void cancelAll()
	{
		VolleyUtil.cancelAll();
	}

	/**
	 * 判断泛型T的类型
	 *
	 * @param clazz T类
	 * @return
	 */
	private static Type getType(Class<?> clazz)
	{
		Type superClassType = clazz.getGenericSuperclass();
		Type[] types = ((ParameterizedType) superClassType).getActualTypeArguments();
		if (types != null && types.length > 0)
		{
			// T
			return types[0];
		}
		return null;
	}

}

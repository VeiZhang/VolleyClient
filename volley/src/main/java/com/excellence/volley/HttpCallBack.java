package com.excellence.volley;

/**
 * <pre>
 *     author : VeiZhang
 *     blog   : http://tiimor.cn
 *     time   : 2017/8/7
 *     desc   : 网络数据回调
 * </pre>
 */

public abstract class HttpCallBack<T>
{

	/**
	 * 请求成功回调
	 *
	 * @param data 网络数据
	 */
	public abstract void onSuccess(T data);

	/**
	 * 请求失败回调
	 *
	 * @param error 失败信息
	 */
	public abstract void onFail(String error);

}

package com.excellence.volley;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.RequestQueue.RequestFilter;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;

/**
 * <pre>
 *     author : VeiZhang
 *     blog   : http://tiimor.cn
 *     time   : 2017/8/7
 *     desc   : Volley初始化
 * </pre>
 */

public class VolleyUtil
{
	private static final int MAX_CACHE_SIZE = 20 * 1024 * 1024;

	private static RequestQueue mRequestQueue = null;
	private static ImageLoader mImageLoader = null;

	/**
	 * 初始化
	 *
	 * @param context 上下文
	 */
	public static void init(Context context)
	{
		init(context, MAX_CACHE_SIZE);
	}

	/**
	 * 初始化
	 *
	 * @param context 上下文
	 * @param cacheSize 缓存大小
	 */
	public static void init(Context context, int cacheSize)
	{
		if (mRequestQueue == null)
		{
			Cache cache = new DiskBasedCache(context.getCacheDir(), cacheSize);
			Network network = new BasicNetwork(new HurlStack());
			mRequestQueue = new RequestQueue(cache, network);
			mImageLoader = new ImageLoader(mRequestQueue, new LruBitmapCache(MAX_CACHE_SIZE));
			mRequestQueue.start();
		}
	}

	/**
	 * 检测请求队列是否初始化
	 *
	 * @return {@code true}:是<br>{@code false}:否
	 */
	public static void checkRequestQueue()
	{
		if (mRequestQueue == null)
			throw new RuntimeException("RequestQueue not initialized");
	}

	/**
	 * 获取请求队列
	 *
	 * @return
	 */
	public static RequestQueue getRequestQueue()
	{
		return mRequestQueue;
	}

	/**
	 * 添加到请求队列
	 *
	 * @param req 网络请求
	 * @param <T>
	 */
	public static <T> void addToRequestQueue(Request<T> req)
	{
		mRequestQueue.add(req);
	}

	/**
	 * 获取图片加载器
	 *
	 * @return
	 */
	public static ImageLoader getImageLoader()
	{
		return mImageLoader;
	}

	/**
	 * 取消标记请求队列
	 *
	 * @param tag 标记
	 */
	public static void cancel(Object tag)
	{
		mRequestQueue.cancelAll(tag);
	}

	/**
	 * 取消所有请求队列
	 *
	 * @param requestFilter
	 */
	public static void cancelAll(RequestFilter requestFilter)
	{
		mRequestQueue.cancelAll(requestFilter);
	}

	/**
	 * 取消所有请求队列
	 */
	public static void cancelAll()
	{
		mRequestQueue.cancelAll(new RequestFilter()
		{
			@Override
			public boolean apply(Request<?> request)
			{
				return true;
			}
		});
	}
}

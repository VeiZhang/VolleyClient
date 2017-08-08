package com.excellence.volley.util;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * <pre>
 *     author : VeiZhang
 *     blog   : http://tiimor.cn
 *     time   : 2017/8/7
 *     desc   : 图片缓存
 * </pre>
 */

public class LruBitmapCache extends LruCache<String, Bitmap> implements ImageLoader.ImageCache
{
	/**
	 * @param maxSize for caches that do not override {@link #sizeOf}, this is
	 *                the maximum number of entries in the cache. For all other caches,
	 *                this is the maximum sum of the sizes of the entries in this cache.
	 */
	public LruBitmapCache(int maxSize)
	{
		super(maxSize);
	}

	@Override
	public Bitmap getBitmap(String url)
	{
		return get(url);
	}

	@Override
	public void putBitmap(String url, Bitmap bitmap)
	{
		put(url, bitmap);
	}

	@Override
	protected int sizeOf(String key, Bitmap value)
	{
		return value.getRowBytes() * value.getHeight();
	}
}

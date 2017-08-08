package com.excellence.volleyclient;

import android.text.TextUtils;

import com.excellence.volley.util.BaseJsonParser;
import com.excellence.volleyclient.Weather.DataBean.ForecastBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * <pre>
 *     author : VeiZhang
 *     blog   : http://tiimor.cn
 *     time   : 2017/8/8
 *     desc   :
 * </pre>
 */

public class ParserSet
{
	public static class ForecastBeanParser extends BaseJsonParser<List<ForecastBean>>
	{

		@Override
		public List<ForecastBean> parse(String response) throws JSONException
		{
			if (TextUtils.isEmpty(response))
				return null;
			Gson gson = new Gson();
			JSONObject jsonObject = new JSONObject(response);
			List<ForecastBean> data = gson.fromJson(jsonObject.getJSONObject("data").getString("forecast"), new TypeToken<List<ForecastBean>>()
			{
			}.getType());
			return data;
		}
	}
}

package com.excellence.volleyclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.excellence.volley.util.HttpCallBack;
import com.excellence.volley.HttpTool;
import com.excellence.volley.VolleyTool;
import com.excellence.volleyclient.Weather.DataBean.ForecastBean;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

	private static final String URL = "http://www.sojson.com/open/api/weather/json.shtml?city=珠海";

	private Button mStrRequestBtn = null;
	private Button mJSONObjRequestBtn = null;
	private Button mJSONArrayRequestBtn = null;
	private Button mCancelBtn = null;
	private TextView mResutlText = null;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		VolleyTool.init(this);

		mStrRequestBtn = (Button) findViewById(R.id.str_request);
		mJSONObjRequestBtn = (Button) findViewById(R.id.json_obj_request);
		mJSONArrayRequestBtn = (Button) findViewById(R.id.json_array_request);
		mCancelBtn = (Button) findViewById(R.id.cancel);
		mResutlText = (TextView) findViewById(R.id.result);

		mStrRequestBtn.setOnClickListener(this);
		mJSONObjRequestBtn.setOnClickListener(this);
		mJSONArrayRequestBtn.setOnClickListener(this);
		mCancelBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View view)
	{
		HttpTool.cancelAll();
		mResutlText.setText(null);
		switch (view.getId())
		{
		case R.id.str_request:
			HttpTool.get(URL, new HttpCallBack<String>()
			{
				@Override
				public void onSuccess(String data)
				{
					mResutlText.setText(data);
				}

				@Override
				public void onFail(String error)
				{
					mResutlText.setText(error);
				}
			});
			break;

		case R.id.json_obj_request:
			HttpTool.get(URL, new HttpCallBack<Weather>()
			{
				@Override
				public void onSuccess(Weather data)
				{

					mResutlText.setText(data.toString());
				}

				@Override
				public void onFail(String error)
				{
					mResutlText.setText(error);
				}
			});
			break;

		case R.id.json_array_request:
			/**
			 * 报错，因为输入类型与JSON解析类型不一致；
			 *
			 * 该栗子中输入的类型只想获取JSON的部分数据，会报错
			 */
			HttpTool.get(URL, new HttpCallBack<List<ForecastBean>>()
			{
				@Override
				public void onSuccess(List<ForecastBean> data)
				{
					if (data != null)
					{
						StringBuilder stringBuilder = new StringBuilder();
						for (ForecastBean item : data)
						{
							stringBuilder.append(item.getDate()).append("\t");
							stringBuilder.append(item.getSunrise()).append("\t");
							stringBuilder.append(item.getLow()).append("\t");
							stringBuilder.append("\n");
						}
						mResutlText.setText(stringBuilder);
					}
					else
						mResutlText.setText("空");
				}

				@Override
				public void onFail(String error)
				{
					mResutlText.setText(error);
				}
			});
			break;

		case R.id.cancel:
			mResutlText.setText("取消请求");
			break;
		}
	}
}

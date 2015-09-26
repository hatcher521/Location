package com.wideatech.location.preferences;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.preference.Preference;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wideatech.location.R;

public class ArrowPreference extends Preference{
	
	private static final String TAG = "hatcher";
    String title = null;
   
    @SuppressLint("Recycle")
    public ArrowPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // 获取自定义参数
        Log.i(TAG,"PreferenceWithTip invoked");
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.arrow_properties);
        title = attributes.getString(R.styleable.arrow_properties_arrow_title);
        attributes.recycle();
    }

    public ArrowPreference(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        TextView titleView = (TextView)view.findViewById(R.id.title);
        titleView.setText(title);
        ImageView arrowView = (ImageView) view.findViewById(R.id.arrow);
        arrowView.setImageResource(R.drawable.arrow_right);
    }

    @Override
    protected View onCreateView(ViewGroup parent) {
        return LayoutInflater.from(getContext()).inflate(R.layout.item_arrow_layout,
                parent, false);
    }
	
	

}

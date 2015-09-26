package com.wideatech.location.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wideatech.location.R;

/**
 * Created by lotus on 2015/9/23.
 */
public class MainAdapter extends BaseAdapter {

    private int[] imgSource;

    private String[] titleSource;

    private String[] contentSource;

    private Context context;

    public MainAdapter(int[] imgSource, String[] titleSource,String[] contentSource, Context context) {
        super();
        this.imgSource = imgSource;
        this.titleSource = titleSource;
        this.contentSource = contentSource;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imgSource.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        String title = titleSource[position];
        String content = contentSource[position];
        int resId = imgSource[position];

        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_main_layout, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title.setText(title);
        holder.content.setText(content);
        holder.img.setImageResource(resId);

        return convertView;
    }

    static class ViewHolder{
        ImageView img;
        TextView title;
        TextView content;
        public ViewHolder(View view) {
            img = (ImageView) view.findViewById(R.id.item_main_iv);
            title = (TextView) view.findViewById(R.id.item_main_title);
            content = (TextView) view.findViewById(R.id.item_main_content);

        }



    }

}

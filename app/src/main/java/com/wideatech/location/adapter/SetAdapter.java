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
public class SetAdapter extends BaseAdapter {


    private String[] titleSource;

    private Context context;

    public SetAdapter(String[] titleSource,Context context) {
        super();
        this.titleSource = titleSource;
        this.context = context;
    }

    @Override
    public int getCount() {
        return titleSource.length;
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

        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_arrow_layout, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title.setText(title);
        holder.img.setImageResource(R.drawable.arrow_right);

        return convertView;
    }

    static class ViewHolder{
        ImageView img;
        TextView title;
        public ViewHolder(View view) {
            img = (ImageView) view.findViewById(R.id.arrow);
            title = (TextView) view.findViewById(R.id.title);

        }



    }

}

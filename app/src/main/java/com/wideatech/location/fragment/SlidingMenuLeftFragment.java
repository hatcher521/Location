package com.wideatech.location.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.LauncherActivity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.wideatech.location.R;
import com.wideatech.location.adapter.SetAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lotus on 2015/9/23.
 */
public class SlidingMenuLeftFragment extends Fragment {

    private String[] titleSource = {"账号", "允许定位", "清除缓存"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.set_layout, container, false);
        ListView lv = (ListView) view.findViewById(R.id.lv);
        SetAdapter adapter = new SetAdapter(titleSource, this.getActivity());
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new ItemClickEvent());

        return view;
    }

    private final class ItemClickEvent implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String title = titleSource[position];
            Log.i("hatcher", title);
            if (title.equals("账号")) {
                Toast.makeText(SlidingMenuLeftFragment.this.getActivity(), "进入账号管理", Toast.LENGTH_LONG).show();
            }

            if (title.equals("清除缓存")) {
                Toast.makeText(SlidingMenuLeftFragment.this.getActivity(), "进入清除缓存", Toast.LENGTH_LONG).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(SlidingMenuLeftFragment.this.getActivity());
                builder.setMessage("确认清除用户信息、图片等缓存信息吗?");
                builder.setTitle("揭示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SlidingMenuLeftFragment.this.getActivity());
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putBoolean("isLogin", false);
                        editor.commit();

                    }
                });


                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.create().show();

            }

        }
    }

}

package com.wideatech.location.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.wideatech.location.R;
import com.wideatech.location.adapter.MainAdapter;
import com.wideatech.location.fragment.SlidingMenuLeftFragment;
import com.wideatech.location.fragment.SlidingMenuRightFragment;

public class MainActivity extends SlidingFragmentActivity {

    public static final String TAG = "hatcher";

    private String[] titleSource = new String[] { "站点分布", "场站数据", "燃气巡检",
            "应急抢险","气源调度","统计分析" };
    private int[] imgSource = new int[] { R.drawable.set,
            R.drawable.realtime, R.drawable.location,
            R.drawable.set, R.drawable.set,R.drawable.history};

    private String[] contentSource = new String[] { "巡检点、隐患点、场站信息", "压力、流量等参数",
            "巡更任务、日志", "隐患、故障情况处理","气源调度信息","数据未来预测" };
    GridView gridView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        MainAdapter adapter = new MainAdapter(imgSource, titleSource,
                contentSource, this);

        gridView = (GridView) findViewById(R.id.gv);

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, titleSource[position],
                        Toast.LENGTH_SHORT).show();

            }
        });

        initMenu();

    }

    public void initMenu() {

        setBehindContentView(R.layout.sliding_menu_container_left_layout);

        SlidingMenu slidingMenu = getSlidingMenu();

        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset); // 引用资源中的数值
        slidingMenu.setShadowDrawable(R.drawable.shadow);
        slidingMenu.setSecondaryShadowDrawable(R.drawable.shadowright);
        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        slidingMenu.setMode(SlidingMenu.LEFT_RIGHT);
        slidingMenu.setFadeDegree(0.35f);

        slidingMenu.setSecondaryMenu(R.layout.sliding_menu_container_right_layout);

        // * 4- 菜单打开的模式
        // SlidingMenu.TOUCHMODE_FULLSCREEN 整个屏幕都可以滑动
        // SlidingMenu.TOUCHMODE_MARGIN 仅边缘可滑
        // SlidingMenu.TOUCHMODE_NONE 不能滑动
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//		slidingMenu.setTouchModeBehind(SlidingMenu.TOUCHMODE_FULLSCREEN);

        Fragment leftMenuFragment = new SlidingMenuLeftFragment();
        Fragment rightMenuFragment = new SlidingMenuRightFragment();

        getFragmentManager().beginTransaction()
                .replace(R.id.sliding_menu_left_container, leftMenuFragment)
                .commit();


        getFragmentManager().beginTransaction()
                .replace(R.id.sliding_menu_right_container, rightMenuFragment)
                .commit();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

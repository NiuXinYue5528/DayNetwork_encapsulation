package com.example.daynetwork_encapsulation;

import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.daynetwork_encapsulation.fragments.AddFragment;
import com.example.daynetwork_encapsulation.fragments.DiscoverFragment;
import com.example.daynetwork_encapsulation.fragments.HomeFragment;
import com.example.daynetwork_encapsulation.fragments.MeFragment;
import com.example.daynetwork_encapsulation.fragments.SofaFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private RelativeLayout rlv;
    private BottomNavigationBar bottom_nv;
    private FragmentManager fm;
    private HomeFragment homeFragment;
    private AddFragment addFragment;
    private SofaFragment sofaFragment;
    private DiscoverFragment discoverFragment;
    private MeFragment meFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        rlv = (RelativeLayout) findViewById(R.id.rlv);
        bottom_nv = (BottomNavigationBar) findViewById(R.id.bottom_nv);
        fm = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        addFragment = new AddFragment();
        sofaFragment = new SofaFragment();
        discoverFragment = new DiscoverFragment();
        meFragment = new MeFragment();

        //替换内容
        fm.beginTransaction().add(R.id.rlv,homeFragment)
        .add(R.id.rlv, sofaFragment)
        .add(R.id.rlv, addFragment)
        .add(R.id.rlv, discoverFragment)
        .add(R.id.rlv, meFragment)
                .hide(sofaFragment)
                .hide(discoverFragment)
                .hide(addFragment)
                .hide(meFragment).commit();


        //添加底部导航内容
        bottom_nv.addItem(new BottomNavigationItem(R.drawable.home, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.sofa, "沙发"))
                .addItem(new BottomNavigationItem(R.drawable.add, ""))
                .addItem(new BottomNavigationItem(R.drawable.aa, "发现"))
                .addItem(new BottomNavigationItem(R.drawable.me, "我的"))
                .setMode(BottomNavigationBar.MODE_DEFAULT)
                .setFirstSelectedPosition(0)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setBarBackgroundColor(R.color.colorGreen)
                .setActiveColor(R.color.colorBai)
                .initialise();


        //点击状态监听
        bottom_nv.setTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(int position) {
        switch (position){
            case 0:
                fm.beginTransaction().show(homeFragment)
                        .hide(sofaFragment)
                        .hide(discoverFragment)
                        .hide(addFragment)
                        .hide(meFragment).commit();
                break;
            case 1:
                fm.beginTransaction().show(sofaFragment)
                        .hide(homeFragment)
                        .hide(discoverFragment)
                        .hide(addFragment)
                        .hide(meFragment).commit();
                break;
            case 2:
                fm.beginTransaction().show(addFragment)
                        .hide(sofaFragment)
                        .hide(homeFragment)
                        .hide(discoverFragment)
                        .hide(meFragment).commit();
                break;
            case 3:
                fm.beginTransaction().show(discoverFragment)
                        .hide(sofaFragment)
                        .hide(homeFragment)
                        .hide(addFragment)
                        .hide(meFragment).commit();
                break;
            case 4:
                fm.beginTransaction().show(meFragment)
                        .hide(sofaFragment)
                        .hide(discoverFragment)
                        .hide(addFragment)
                        .hide(homeFragment).commit();
                break;

        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}

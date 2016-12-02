package com.hjo.wingapp;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.wingsofts.byeburgernavigationview.ByeBurgerBehavior;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
//  private RecyclerView mRecyclerView;
  private ViewPager mViewPager;
  private List<Fragment> fragmentList;
//  private BottomNavigationView mNavigationView;
  private FloatingActionButton mFloatButton;
  private ByeBurgerBehavior mBehavior;
//  private Toolbar mToolbar;
private TabLayout mTabLayout;
  LinearLayout home,search,me,setting,layout_button;
  ImageView  home_image,search_image,me_image,setting_image ;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initData();
    initView();
  }
  private void initView() {
//    mToolbar = (Toolbar) findViewById(R.id.toolbar);
//    mToolbar.setTitleTextColor(Color.WHITE);
//    mToolbar.setTitle("Bye! Bye! Burger");
//    setSupportActionBar(mToolbar);
    mTabLayout=(TabLayout)findViewById(R.id.tabLayout);
    mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    //为TabLayout添加tab名称
    mTabLayout.addTab(mTabLayout.newTab().setText("首页"));
    mTabLayout.addTab(mTabLayout.newTab().setText("Android"));
    mTabLayout.addTab(mTabLayout.newTab().setText("iOS"));
    mTabLayout.addTab(mTabLayout.newTab().setText("工具"));
    mTabLayout.addTab(mTabLayout.newTab().setText("工具1"));
    mTabLayout.addTab(mTabLayout.newTab().setText("工具2"));
    mTabLayout.addTab(mTabLayout.newTab().setText("工具3"));

    layout_button=(LinearLayout)findViewById(R.id.layout_button);
    home_image=(ImageView)findViewById(R.id.home_image);
    search_image=(ImageView)findViewById(R.id.search_image);
    me_image=(ImageView)findViewById(R.id.me_image);
    setting_image=(ImageView)findViewById(R.id.setting_image);

    mViewPager = (ViewPager) findViewById(R.id.viewpager);
//  mNavigationView = (BottomNavigationView) findViewById(R.id.bye_burger);
    mFloatButton = (FloatingActionButton) findViewById(R.id.floatButton);

    mBehavior = ByeBurgerBehavior.from(mFloatButton);
    home=(LinearLayout)findViewById(R.id.home);
    search=(LinearLayout)findViewById(R.id.search);
    me=(LinearLayout)findViewById(R.id.me);
    setting=(LinearLayout)findViewById(R.id.setting);

    home.setOnClickListener(this);
    search.setOnClickListener(this);
    me.setOnClickListener(this);
    setting.setOnClickListener(this);


    mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
      @Override public Fragment getItem(int position) {
        return fragmentList.get(position);
      }

      @Override public int getCount() {
        return fragmentList.size();
      }
    });
  }

  private void initData() {
    fragmentList = new ArrayList<>();
    fragmentList.add(HomeFragment.newInstance());

    fragmentList.add(OtherFragment.newInstance("search"));

    fragmentList.add(OtherFragment.newInstance("me"));

    fragmentList.add(OtherFragment.newInstance("setting"));
  }


  @Override
  public void onClick(View view) {
    switch (view.getId()){
      case R.id.home:
        mBehavior.show();
        ByeBurgerBehavior.from(mTabLayout).show();
        ByeBurgerBehavior.from(layout_button).show();
        mViewPager.setCurrentItem(0);
        changImage(0);
        break;
      case R.id.search:
        mBehavior.hide();
        ByeBurgerBehavior.from(mTabLayout).show();
        ByeBurgerBehavior.from(layout_button).show();
        mViewPager.setCurrentItem(1);
        changImage(1);
        break;
      case R.id.me:
        mBehavior.hide();
        mViewPager.setCurrentItem(2);
        changImage(2);
        break;
      case R.id.setting:
        mBehavior.hide();
        mViewPager.setCurrentItem(3);
        changImage(3);
        break;
    }
  }

  public void changImage(int index){
    switch (index){
      case 0:
        home_image.setImageDrawable(getResources().getDrawable(R.drawable.forecastwarning_w));
        search_image.setImageDrawable(getResources().getDrawable(R.drawable.excellent));
        me_image.setImageDrawable(getResources().getDrawable(R.drawable.compare));
        setting_image.setImageDrawable(getResources().getDrawable(R.drawable.analysis));
        break;
      case 1:
        home_image.setImageDrawable(getResources().getDrawable(R.drawable.forecastwarning));
        search_image.setImageDrawable(getResources().getDrawable(R.drawable.excellent_w));
        me_image.setImageDrawable(getResources().getDrawable(R.drawable.compare));
        setting_image.setImageDrawable(getResources().getDrawable(R.drawable.analysis));
        break; case 2:
        home_image.setImageDrawable(getResources().getDrawable(R.drawable.forecastwarning));
        search_image.setImageDrawable(getResources().getDrawable(R.drawable.excellent));
        me_image.setImageDrawable(getResources().getDrawable(R.drawable.compare_w));
        setting_image.setImageDrawable(getResources().getDrawable(R.drawable.analysis));
        break;
      case 3:
        home_image.setImageDrawable(getResources().getDrawable(R.drawable.forecastwarning));
        search_image.setImageDrawable(getResources().getDrawable(R.drawable.excellent));
        me_image.setImageDrawable(getResources().getDrawable(R.drawable.compare));
        setting_image.setImageDrawable(getResources().getDrawable(R.drawable.analysis_w));
        break;

    }
  }

}
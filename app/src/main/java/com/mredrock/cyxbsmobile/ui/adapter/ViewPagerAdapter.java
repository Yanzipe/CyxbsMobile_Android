package com.mredrock.cyxbsmobile.ui.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.mredrock.cyxbsmobile.model.social.HotNewsContent;
import com.mredrock.cyxbsmobile.ui.fragment.social.SingleImageFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<SingleImageFragment> fragments = new ArrayList<>();
    private ViewPager mViewPager;
    private HotNewsContent mHotNewsContent;
    private String[] urls;

    public ViewPagerAdapter(FragmentManager fm, ViewPager viewPager, HotNewsContent hotNewsContent) {
        super(fm);
        this.mHotNewsContent = hotNewsContent;
        this.mViewPager = viewPager;
        urls = NewsAdapter.ViewHolder.getUrls(hotNewsContent.img.img_src);
        mViewPager.setOffscreenPageLimit(urls.length);
        for (String url : urls) {
            SingleImageFragment singleImageFragment = new SingleImageFragment();
            Bundle bundle = new Bundle();
            bundle.putString("url", url);
            singleImageFragment.setArguments(bundle);
            fragments.add(singleImageFragment);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}

package com.mredrock.cyxbs.ui.fragment.social;


import com.mredrock.cyxbs.model.social.HotNews;
import com.mredrock.cyxbs.model.social.HotNewsContent;
import com.mredrock.cyxbs.network.RequestManager;
import com.mredrock.cyxbs.ui.adapter.NewsAdapter;

import java.util.List;

import rx.Subscriber;

/**
 * Created by mathiasluo on 16-4-26.
 */
public class HotNewsFragment extends BaseNewsFragment {

    void provideData(Subscriber<List<HotNews>> subscriber, int size, int page) {
        RequestManager.getInstance().getHotArticle(subscriber, size, page);
    }


    @Override
    protected void setDate(NewsAdapter.NewsViewHolder holder, HotNewsContent hotNewsContent) {
        super.setDate(holder, hotNewsContent);
        holder.enableAvatarClick = !(hotNewsContent.user_id.equals("0") || hotNewsContent.typeId < 5);
    }
}

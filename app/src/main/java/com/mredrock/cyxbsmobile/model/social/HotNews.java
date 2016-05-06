package com.mredrock.cyxbsmobile.model.social;

import com.mredrock.cyxbsmobile.model.RedrockApiWrapper;

import java.util.List;

/**
 * Created by mathiasluo on 16-4-5.
 */
public class HotNews extends RedrockApiWrapper<HotNewsContent> {


    public String page;

    public HotNews(OfficeNewsContent officeNewsContent) {
        this.data = new HotNewsContent(officeNewsContent);
    }

    public HotNews(BBDDNewsContent bbddNewsContent) {
        this.data = new HotNewsContent(bbddNewsContent.type_id
                , bbddNewsContent.id
                , 5
                , "userid"
                , bbddNewsContent.nickname
                , bbddNewsContent.article_photo_src
                , bbddNewsContent.created_time
                , new OfficeNewsContent(bbddNewsContent.content)
                , new HotNewsContent.ImgBean(bbddNewsContent.article_thumbnail_src
                , bbddNewsContent.article_photo_src)
                , bbddNewsContent.like_num, bbddNewsContent.remark_num
                , bbddNewsContent.is_my_like);
    }

    public HotNews(String content, List<Image> list) {
        list.remove(0);
        String a = "";
        String b = "";
        for (Image image : list) {
            a += image.url + ",";
            b += image.url + ",";

        }
        this.data = new HotNewsContent(new HotNewsContent.ImgBean(a, b), new OfficeNewsContent(content));
    }

    public HotNews(BBDDDetail bbddDetail){
        this.data = new HotNewsContent("bbdd"
        ,bbddDetail.id
        ,5
        ,"userid"
        ,""
        ,""
        ,bbddDetail.created_time
        ,new OfficeNewsContent(bbddDetail.content)
        ,new HotNewsContent.ImgBean(bbddDetail.thumbnail_src,bbddDetail.photo_src)
        ,bbddDetail.like_num
        ,bbddDetail.remark_num
        ,false);
    }
}

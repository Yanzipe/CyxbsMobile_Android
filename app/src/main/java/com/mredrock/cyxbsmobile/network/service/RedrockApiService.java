package com.mredrock.cyxbsmobile.network.service;

import com.mredrock.cyxbsmobile.config.Const;
import com.mredrock.cyxbsmobile.model.Course;
import com.mredrock.cyxbsmobile.model.EatWhat;
import com.mredrock.cyxbsmobile.model.Empty;
import com.mredrock.cyxbsmobile.model.Exam;
import com.mredrock.cyxbsmobile.model.Grade;
import com.mredrock.cyxbsmobile.model.AboutMe;
import com.mredrock.cyxbsmobile.model.RedrockApiWrapper;
import com.mredrock.cyxbsmobile.model.Restaurant;
import com.mredrock.cyxbsmobile.model.RestaurantComment;
import com.mredrock.cyxbsmobile.model.RestaurantDetail;
import com.mredrock.cyxbsmobile.model.Student;
import com.mredrock.cyxbsmobile.model.social.BBDDNews;
import com.mredrock.cyxbsmobile.model.social.Comment;
import com.mredrock.cyxbsmobile.model.social.HotNews;
import com.mredrock.cyxbsmobile.model.social.OfficeNews;
import com.mredrock.cyxbsmobile.model.social.RequestResponse;
import com.mredrock.cyxbsmobile.model.social.UploadImgResponse;

import com.mredrock.cyxbsmobile.model.User;
import com.mredrock.cyxbsmobile.model.social.BBDDDetail;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cc on 16/1/20.
 */
public interface RedrockApiService {

    @FormUrlEncoded
    @Headers("API_APP: android")
    @POST(Const.API_PERSON_SCHEDULE)
    Observable<Course.CourseWrapper> getCourse(@Field("stuNum") String stuNum, @Field("idNum") String idNum, @Field("week") String week);

    @GET(Const.API_EAT_WHAT)
    Observable<RedrockApiWrapper<EatWhat>> getEatWhat();

    @FormUrlEncoded
    @POST(Const.API_AROUND_FOOD_RESTAURANTS)
    Observable<RedrockApiWrapper<List<Restaurant>>> getRestaurantList(@Field("pid") String page);

    @FormUrlEncoded
    @POST(Const.API_RESTAURANT_DETAIL)
    Observable<RedrockApiWrapper<RestaurantDetail>> getRestaurantDetail(@Field("id") String id);

    @FormUrlEncoded
    @POST(Const.API_RESTAURANT_COMMENTS)
    Observable<RedrockApiWrapper<List<RestaurantComment>>> getRestaurantComments(@Field("shop_id") String id, @Field("pid") String page);

    @FormUrlEncoded
    @POST(Const.API_RESTAURANT_SEND_COMMENT)
    Observable<RedrockApiWrapper<Object>> sendRestaurantComment(@Field("shop_id") String id, @Field("user_number") String userNumber, @Field("user_password") String userPassword, @Field("comment_content") String commentContent, @Field("comment_author_name") String commentAuthoName);

    @GET(Const.APT_SEARCH_STUDENT)
    Observable<Student.StudentWrapper> getStudent(@Query("stu") String stu);

    @FormUrlEncoded
    @POST(Const.API_EMPTYROOM)
    Observable<Empty> getEmptyRoomList(@Field("buildNum") String buildNum, @Field("week") String week, @Field("weekdayNum") String weekdayNum, @Field("sectionNum") String sectionNum);

    @FormUrlEncoded
    @POST(Const.API_SCORE)
    Observable<Grade.GradeWrapper> getGrade(@Field("stuNum") String stuNum, @Field("idNum") String idNum);

    @FormUrlEncoded
    @POST(Const.API_EXAM_SCHEDULE)
    Observable<Exam.ExamWapper> getExam(@Field("stuNum") String stu);

    @FormUrlEncoded
    @POST(Const.API_REEXAM_SCHEDULE)
    Observable<Exam.ExamWapper> getReExam(@Field("stu") String stu);

    @FormUrlEncoded
    @POST(Const.API_EDIT_INFO)
    Observable<RedrockApiWrapper<Object>> setPersonInfo(@Field("stuNum") String stuNum,
                                         @Field("idNum") String idNum,
                                         @Field("photo_thumbnail_src") String photo_thumbnail_src,
                                         @Field("photo_src") String photo_src);

    @FormUrlEncoded
    @POST(Const.API_EDIT_INFO)
    Observable<RedrockApiWrapper<Object>> setPersonNickName(@Field("stuNum") String stuNum,
                                                 @Field("idNum") String idNum,
                                                 @Field("nickname") String nickname);

    @FormUrlEncoded
    @POST(Const.API_EDIT_INFO)
    Observable<RedrockApiWrapper<Object>> setPersonQQ(@Field("stuNum") String stuNum,
                                       @Field("idNum") String idNum,
                                       @Field("qq") String qq);

    @FormUrlEncoded
    @POST(Const.API_EDIT_INFO)
    Observable<RedrockApiWrapper<Object>> setPersonPhone(@Field("stuNum") String stuNum,
                                          @Field("idNum") String idNum,
                                          @Field("phone") String phone);

    @FormUrlEncoded
    @POST(Const.API_EDIT_INFO)
    Observable<RedrockApiWrapper<Object>> setPersonIntroduction(@Field("stuNum") String stuNum,
                                             @Field("idNum") String idNum,
                                             @Field("introduction") String introduction);

    @FormUrlEncoded
    @POST(Const.API_GET_INFO)
    Observable<User.UserWrapper> getPersonInfo(@Field("stuNum") String stuNum,
                                               @Field("idNum") String idNum );

    @FormUrlEncoded
    @POST(Const.API_ABOUT_ME)
    Observable<AboutMe.AboutMeWapper> getAboutMe(@Field("stuNum") String
                                                            stuNum,
                                                   @Field("idNum") String idNum);

    @FormUrlEncoded
    @POST(Const.API_TREND_DETAIL)
    Observable<BBDDDetail.BBDDDetailWrapper> getTrendDetail(@Field("stuNum") String stuNum,
                                          @Field("idNum") String idNum,
                                          @Field("type_id") int type_id,
                                          @Field("article_id") String article_id);

    @FormUrlEncoded
    @POST(Const.API_SEARCH_ARTICLE)
    Observable<BBDDDetail.BBDDDetailWrapper> searchTrends(@Field("stuNum") String stuNum,
                                                @Field("idNum") String idNum);

    Observable<BBDDDetail.BBDDDetailWrapper> searchOtherTrends(@Field("stuNum") String stuNum,
                                                     @Field("idNum") String idNum,
                                                     @Field("stunum_other") String stunum_other);

    @FormUrlEncoded
    @POST("/cyxbsMobile/index.php/Home/Article/listNews")
    Observable<OfficeNews> getlistNews(@Field("size") int size,
                                       @Field("page") int page,
                                       @Field("stuNum") String stuNum,
                                       @Field("idNum") String idNum,
                                       @Field("type_id") String type_id);

    @FormUrlEncoded
    @POST("cyxbsMobile/index.php/Home/Article/searchHotArticle")
    Observable<List<HotNews>> getHotArticle(@Field("size") int size,
                                            @Field("page") int page,
                                            @Field("stuNum") String stuNum,
                                            @Field("idNum") String idNum);

    @FormUrlEncoded
    //哔哔叨叨(或者其他的)接口：POST
    @POST("cyxbsMobile/index.php/Home/Article/listArticle")
    Observable<BBDDNews> getListArticle(@Field("type_id") int type_id,
                                        @Field("size") int size,
                                        @Field("page") int page,
                                        @Field("stuNum") String stuNum,
                                        @Field("idNum") String idNum);


    @Multipart
    @POST("cyxbsMobile/index.php/Home/Photo/uploadArticle")
    Observable<UploadImgResponse> uploadImg(@Part("stunum") RequestBody stunum,
                                            @Part MultipartBody.Part file);


    @FormUrlEncoded
    @POST("cyxbsMobile/index.php/Home/Article/addArticle")
    Observable<RequestResponse> sendDynamic(@Field("type_id") int type_id,
                                            @Field("title") String title,
                                            @Field("user_id") String user_id,
                                            @Field("content") String content,
                                            @Field("thumbnail_src") String thumbnail_src,
                                            @Field("photo_src") String photo_src,
                                            @Field("stuNum") String stuNum,
                                            @Field("idNum") String idNum);

    @FormUrlEncoded
    @POST("cyxbsMobile/index.php/Home/ArticleRemark/getremark")
    Observable<Comment> getReMark(@Field("article_id") String article_id,
                                  @Field("type_id") int type_id,
                                  @Field("user_id") String user_id,
                                  @Field("stuNum") String stuNum,
                                  @Field("idNum") String idNum);


    @FormUrlEncoded
    @POST("cyxbsMobile/index.php/Home/ArticleRemark/postremarks")
    Observable<RequestResponse> postReMarks(@Field("article_id") String article_id,
                                            @Field("type_id") int type_id,
                                            @Field("content") String content,
                                            @Field("user_id") String user_id,
                                            @Field("stuNum") String stuNum,
                                            @Field("idNum") String idNum);

    @FormUrlEncoded
    @POST("cyxbsMobile/index.php/Home/Praise/addone")
    Observable<RequestResponse> addThumbsUp(@Field("article_id") String article_id,
                                            @Field("type_id") int type_id,
                                            @Field("stuNum") String stuNum,
                                            @Field("idNum") String idNum);

    @FormUrlEncoded
    @POST("cyxbsMobile/index.php/Home/Praise/cancel")
    Observable<RequestResponse> cancelThumbsUp(@Field("article_id") String article_id,
                                               @Field("type_id") int type_id,
                                               @Field("stuNum") String stuNum,
                                               @Field("idNum") String idNum);

}

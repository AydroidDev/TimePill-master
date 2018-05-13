package com.dante.diary.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;


public class TipResult implements MultiItemEntity{

    public static final int TYPE_FOLLOW = 2;
    public static final int TYPE_COMMENT = 1;



    public int id;
    public int user_id;
    public int link_id;
    public int link_user_id;
    public int type;
    public Content content;
    public String created;
    public int read;

    @Override
    public int getItemType() {
        return type;
    }

    public class Content {

        /**
         * dairyId : 11299719
         * commentId : 19568450
         * author : {"name":"张××","id":12}
         * user : {"id":12,"name":"张××"}
         */

        @SerializedName("dairy_id")
        private int dairyId;
        @SerializedName("comment_id")
        private int commentId;
        @SerializedName("author")
        private UserBean commentUser;
        @SerializedName("user")
        private UserBean followUser;

        public int getDairyId() {
            return dairyId;
        }

        public void setDairyId(int dairyId) {
            this.dairyId = dairyId;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public UserBean getCommentUser() {
            return commentUser;
        }

        public void setCommentUser(UserBean commentUser) {
            this.commentUser = commentUser;
        }

        public UserBean getFollowUser() {
            return followUser;
        }

        public void setFollowUser(UserBean followUser) {
            this.followUser = followUser;
        }

        public class UserBean {
            /**
             * id : 12
             * name : 张××
             */

            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}

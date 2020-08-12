package com.example.daynetwork_encapsulation.bean;

import java.util.List;

public class HomeBen {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * author : {"avatar":"https://p1-ppx.byteimg.com/img/tos-cn-i-0000/ad44405380564f4db29d09284eaf675b~200x200.jpeg","commentCount":0,"description":"","expires_time":0,"favoriteCount":0,"feedCount":0,"followCount":0,"followerCount":8,"hasFollow":false,"historyCount":0,"id":1865,"likeCount":0,"name":"隔壁老王在隔壁洗澡","score":0,"topCommentCount":0,"userId":102985300487}
         * authorId : 102985300487
         * cover : https://p1-ppx.byteimg.com/img/mosaic-legacy/30c0f00059327620262bc~576x1024_q80.jpeg
         * createTime : 1590677855
         * duration : 68.662
         * feeds_text : 难得在某音看到这种正能量的视频
         * height : 1024
         * id : 1578919906
         * itemId : 6831909366883424515
         * itemType : 2
         * ugc : {"commentCount":2119,"hasDissed":false,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"likeCount":38868,"shareCount":157}
         * url : https://pipijoke.oss-cn-hangzhou.aliyuncs.com/6831909366883424515.mp4
         * width : 576
         * activityIcon : https://sf1-nhcdn-tos.pstatp.com/obj/p1056/88c5ea2b90134313b99cf2f9a87e9ca1
         * activityText : 专业团队
         * topComment : {"author":{"avatar":"http://qzapp.qlogo.cn/qzapp/101794421/FE41683AD4ECF91B7736CA9DB8104A5C/100","commentCount":192,"description":"小朋友,你是否有很多问号","expires_time":1596726031266,"favoriteCount":12,"feedCount":10,"followCount":104,"followerCount":26,"hasFollow":false,"historyCount":1990,"id":1755,"likeCount":3,"name":"、蓅哖╰伊人为谁笑","qqOpenId":"FE41683AD4ECF91B7736CA9DB8104A5C","score":1000,"topCommentCount":10,"userId":1578919786},"commentCount":194,"commentId":6831395891597809920,"commentText":"TOYOTA Li","commentType":1,"createTime":1590558302,"hasLiked":false,"height":0,"id":2024,"itemId":6831031292016990478,"likeCount":37599,"ugc":{"commentCount":0,"hasDissed":false,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"likeCount":2,"shareCount":0},"userId":0,"width":0}
         */

        private AuthorBean author;
        private long authorId;
        private String cover;
        private int createTime;
        private double duration;
        private String feeds_text;
        private int height;
        private int id;
        private long itemId;
        private int itemType;
        private UgcBean ugc;
        private String url;
        private int width;
        private String activityIcon;
        private String activityText;
        private TopCommentBean topComment;

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public long getAuthorId() {
            return authorId;
        }

        public void setAuthorId(long authorId) {
            this.authorId = authorId;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getCreateTime() {
            return createTime;
        }

        public void setCreateTime(int createTime) {
            this.createTime = createTime;
        }

        public double getDuration() {
            return duration;
        }

        public void setDuration(double duration) {
            this.duration = duration;
        }

        public String getFeeds_text() {
            return feeds_text;
        }

        public void setFeeds_text(String feeds_text) {
            this.feeds_text = feeds_text;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getItemId() {
            return itemId;
        }

        public void setItemId(long itemId) {
            this.itemId = itemId;
        }

        public int getItemType() {
            return itemType;
        }

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        public UgcBean getUgc() {
            return ugc;
        }

        public void setUgc(UgcBean ugc) {
            this.ugc = ugc;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public String getActivityIcon() {
            return activityIcon;
        }

        public void setActivityIcon(String activityIcon) {
            this.activityIcon = activityIcon;
        }

        public String getActivityText() {
            return activityText;
        }

        public void setActivityText(String activityText) {
            this.activityText = activityText;
        }

        public TopCommentBean getTopComment() {
            return topComment;
        }

        public void setTopComment(TopCommentBean topComment) {
            this.topComment = topComment;
        }

        public static class AuthorBean {
            /**
             * avatar : https://p1-ppx.byteimg.com/img/tos-cn-i-0000/ad44405380564f4db29d09284eaf675b~200x200.jpeg
             * commentCount : 0
             * description :
             * expires_time : 0
             * favoriteCount : 0
             * feedCount : 0
             * followCount : 0
             * followerCount : 8
             * hasFollow : false
             * historyCount : 0
             * id : 1865
             * likeCount : 0
             * name : 隔壁老王在隔壁洗澡
             * score : 0
             * topCommentCount : 0
             * userId : 102985300487
             */

            private String avatar;
            private int commentCount;
            private String description;
            private int expires_time;
            private int favoriteCount;
            private int feedCount;
            private int followCount;
            private int followerCount;
            private boolean hasFollow;
            private int historyCount;
            private int id;
            private int likeCount;
            private String name;
            private int score;
            private int topCommentCount;
            private long userId;

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getExpires_time() {
                return expires_time;
            }

            public void setExpires_time(int expires_time) {
                this.expires_time = expires_time;
            }

            public int getFavoriteCount() {
                return favoriteCount;
            }

            public void setFavoriteCount(int favoriteCount) {
                this.favoriteCount = favoriteCount;
            }

            public int getFeedCount() {
                return feedCount;
            }

            public void setFeedCount(int feedCount) {
                this.feedCount = feedCount;
            }

            public int getFollowCount() {
                return followCount;
            }

            public void setFollowCount(int followCount) {
                this.followCount = followCount;
            }

            public int getFollowerCount() {
                return followerCount;
            }

            public void setFollowerCount(int followerCount) {
                this.followerCount = followerCount;
            }

            public boolean isHasFollow() {
                return hasFollow;
            }

            public void setHasFollow(boolean hasFollow) {
                this.hasFollow = hasFollow;
            }

            public int getHistoryCount() {
                return historyCount;
            }

            public void setHistoryCount(int historyCount) {
                this.historyCount = historyCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getLikeCount() {
                return likeCount;
            }

            public void setLikeCount(int likeCount) {
                this.likeCount = likeCount;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getTopCommentCount() {
                return topCommentCount;
            }

            public void setTopCommentCount(int topCommentCount) {
                this.topCommentCount = topCommentCount;
            }

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }
        }

        public static class UgcBean {
            /**
             * commentCount : 2119
             * hasDissed : false
             * hasFavorite : false
             * hasLiked : false
             * hasdiss : false
             * likeCount : 38868
             * shareCount : 157
             */

            private int commentCount;
            private boolean hasDissed;
            private boolean hasFavorite;
            private boolean hasLiked;
            private boolean hasdiss;
            private int likeCount;
            private int shareCount;

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public boolean isHasDissed() {
                return hasDissed;
            }

            public void setHasDissed(boolean hasDissed) {
                this.hasDissed = hasDissed;
            }

            public boolean isHasFavorite() {
                return hasFavorite;
            }

            public void setHasFavorite(boolean hasFavorite) {
                this.hasFavorite = hasFavorite;
            }

            public boolean isHasLiked() {
                return hasLiked;
            }

            public void setHasLiked(boolean hasLiked) {
                this.hasLiked = hasLiked;
            }

            public boolean isHasdiss() {
                return hasdiss;
            }

            public void setHasdiss(boolean hasdiss) {
                this.hasdiss = hasdiss;
            }

            public int getLikeCount() {
                return likeCount;
            }

            public void setLikeCount(int likeCount) {
                this.likeCount = likeCount;
            }

            public int getShareCount() {
                return shareCount;
            }

            public void setShareCount(int shareCount) {
                this.shareCount = shareCount;
            }
        }

        public static class TopCommentBean {
            /**
             * author : {"avatar":"http://qzapp.qlogo.cn/qzapp/101794421/FE41683AD4ECF91B7736CA9DB8104A5C/100","commentCount":192,"description":"小朋友,你是否有很多问号","expires_time":1596726031266,"favoriteCount":12,"feedCount":10,"followCount":104,"followerCount":26,"hasFollow":false,"historyCount":1990,"id":1755,"likeCount":3,"name":"、蓅哖╰伊人为谁笑","qqOpenId":"FE41683AD4ECF91B7736CA9DB8104A5C","score":1000,"topCommentCount":10,"userId":1578919786}
             * commentCount : 194
             * commentId : 6831395891597809920
             * commentText : TOYOTA Li
             * commentType : 1
             * createTime : 1590558302
             * hasLiked : false
             * height : 0
             * id : 2024
             * itemId : 6831031292016990478
             * likeCount : 37599
             * ugc : {"commentCount":0,"hasDissed":false,"hasFavorite":false,"hasLiked":false,"hasdiss":false,"likeCount":2,"shareCount":0}
             * userId : 0
             * width : 0
             */

            private AuthorBeanX author;
            private int commentCount;
            private long commentId;
            private String commentText;
            private int commentType;
            private int createTime;
            private boolean hasLiked;
            private int height;
            private int id;
            private long itemId;
            private int likeCount;
            private UgcBeanX ugc;
            private int userId;
            private int width;

            public AuthorBeanX getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBeanX author) {
                this.author = author;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public long getCommentId() {
                return commentId;
            }

            public void setCommentId(long commentId) {
                this.commentId = commentId;
            }

            public String getCommentText() {
                return commentText;
            }

            public void setCommentText(String commentText) {
                this.commentText = commentText;
            }

            public int getCommentType() {
                return commentType;
            }

            public void setCommentType(int commentType) {
                this.commentType = commentType;
            }

            public int getCreateTime() {
                return createTime;
            }

            public void setCreateTime(int createTime) {
                this.createTime = createTime;
            }

            public boolean isHasLiked() {
                return hasLiked;
            }

            public void setHasLiked(boolean hasLiked) {
                this.hasLiked = hasLiked;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getItemId() {
                return itemId;
            }

            public void setItemId(long itemId) {
                this.itemId = itemId;
            }

            public int getLikeCount() {
                return likeCount;
            }

            public void setLikeCount(int likeCount) {
                this.likeCount = likeCount;
            }

            public UgcBeanX getUgc() {
                return ugc;
            }

            public void setUgc(UgcBeanX ugc) {
                this.ugc = ugc;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public static class AuthorBeanX {
                /**
                 * avatar : http://qzapp.qlogo.cn/qzapp/101794421/FE41683AD4ECF91B7736CA9DB8104A5C/100
                 * commentCount : 192
                 * description : 小朋友,你是否有很多问号
                 * expires_time : 1596726031266
                 * favoriteCount : 12
                 * feedCount : 10
                 * followCount : 104
                 * followerCount : 26
                 * hasFollow : false
                 * historyCount : 1990
                 * id : 1755
                 * likeCount : 3
                 * name : 、蓅哖╰伊人为谁笑
                 * qqOpenId : FE41683AD4ECF91B7736CA9DB8104A5C
                 * score : 1000
                 * topCommentCount : 10
                 * userId : 1578919786
                 */

                private String avatar;
                private int commentCount;
                private String description;
                private long expires_time;
                private int favoriteCount;
                private int feedCount;
                private int followCount;
                private int followerCount;
                private boolean hasFollow;
                private int historyCount;
                private int id;
                private int likeCount;
                private String name;
                private String qqOpenId;
                private int score;
                private int topCommentCount;
                private int userId;

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public int getCommentCount() {
                    return commentCount;
                }

                public void setCommentCount(int commentCount) {
                    this.commentCount = commentCount;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public long getExpires_time() {
                    return expires_time;
                }

                public void setExpires_time(long expires_time) {
                    this.expires_time = expires_time;
                }

                public int getFavoriteCount() {
                    return favoriteCount;
                }

                public void setFavoriteCount(int favoriteCount) {
                    this.favoriteCount = favoriteCount;
                }

                public int getFeedCount() {
                    return feedCount;
                }

                public void setFeedCount(int feedCount) {
                    this.feedCount = feedCount;
                }

                public int getFollowCount() {
                    return followCount;
                }

                public void setFollowCount(int followCount) {
                    this.followCount = followCount;
                }

                public int getFollowerCount() {
                    return followerCount;
                }

                public void setFollowerCount(int followerCount) {
                    this.followerCount = followerCount;
                }

                public boolean isHasFollow() {
                    return hasFollow;
                }

                public void setHasFollow(boolean hasFollow) {
                    this.hasFollow = hasFollow;
                }

                public int getHistoryCount() {
                    return historyCount;
                }

                public void setHistoryCount(int historyCount) {
                    this.historyCount = historyCount;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getLikeCount() {
                    return likeCount;
                }

                public void setLikeCount(int likeCount) {
                    this.likeCount = likeCount;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getQqOpenId() {
                    return qqOpenId;
                }

                public void setQqOpenId(String qqOpenId) {
                    this.qqOpenId = qqOpenId;
                }

                public int getScore() {
                    return score;
                }

                public void setScore(int score) {
                    this.score = score;
                }

                public int getTopCommentCount() {
                    return topCommentCount;
                }

                public void setTopCommentCount(int topCommentCount) {
                    this.topCommentCount = topCommentCount;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }
            }

            public static class UgcBeanX {
                /**
                 * commentCount : 0
                 * hasDissed : false
                 * hasFavorite : false
                 * hasLiked : false
                 * hasdiss : false
                 * likeCount : 2
                 * shareCount : 0
                 */

                private int commentCount;
                private boolean hasDissed;
                private boolean hasFavorite;
                private boolean hasLiked;
                private boolean hasdiss;
                private int likeCount;
                private int shareCount;

                public int getCommentCount() {
                    return commentCount;
                }

                public void setCommentCount(int commentCount) {
                    this.commentCount = commentCount;
                }

                public boolean isHasDissed() {
                    return hasDissed;
                }

                public void setHasDissed(boolean hasDissed) {
                    this.hasDissed = hasDissed;
                }

                public boolean isHasFavorite() {
                    return hasFavorite;
                }

                public void setHasFavorite(boolean hasFavorite) {
                    this.hasFavorite = hasFavorite;
                }

                public boolean isHasLiked() {
                    return hasLiked;
                }

                public void setHasLiked(boolean hasLiked) {
                    this.hasLiked = hasLiked;
                }

                public boolean isHasdiss() {
                    return hasdiss;
                }

                public void setHasdiss(boolean hasdiss) {
                    this.hasdiss = hasdiss;
                }

                public int getLikeCount() {
                    return likeCount;
                }

                public void setLikeCount(int likeCount) {
                    this.likeCount = likeCount;
                }

                public int getShareCount() {
                    return shareCount;
                }

                public void setShareCount(int shareCount) {
                    this.shareCount = shareCount;
                }
            }
        }
    }
}


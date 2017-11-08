/*
Navicat PGSQL Data Transfer

Source Server         : 45.32.196.91
Source Server Version : 90319
Source Host           : 45.32.196.91:5432
Source Database       : cnblogs
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90319
File Encoding         : 65001

Date: 2017-11-08 17:19:16
*/


-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS "public"."blog";
CREATE TABLE "public"."blog" (
"id" int4 NOT NULL,
"blogname" varchar(255) COLLATE "default",
"sign" varchar(255) COLLATE "default",
"user_id" varchar(255) COLLATE "default",
"home_page" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of blog
-- ----------------------------

-- ----------------------------
-- Table structure for blog_catolog
-- ----------------------------
DROP TABLE IF EXISTS "public"."blog_catolog";
CREATE TABLE "public"."blog_catolog" (
"blog_id" int4,
"name" varchar(255) COLLATE "default",
"id" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of blog_catolog
-- ----------------------------

-- ----------------------------
-- Table structure for blog_comment
-- ----------------------------
DROP TABLE IF EXISTS "public"."blog_comment";
CREATE TABLE "public"."blog_comment" (
"id" int4 NOT NULL,
"post_id" int4,
"user_id" int4,
"content" varchar(100000) COLLATE "default",
"posted" timestamp(6),
"comment_id" int4
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."blog_comment"."id" IS 'id';
COMMENT ON COLUMN "public"."blog_comment"."post_id" IS '文章id';
COMMENT ON COLUMN "public"."blog_comment"."user_id" IS '用户id';
COMMENT ON COLUMN "public"."blog_comment"."content" IS '评论内容';
COMMENT ON COLUMN "public"."blog_comment"."posted" IS '发布时间';
COMMENT ON COLUMN "public"."blog_comment"."comment_id" IS '被评论的评论id';

-- ----------------------------
-- Records of blog_comment
-- ----------------------------

-- ----------------------------
-- Table structure for blog_comment_vote
-- ----------------------------
DROP TABLE IF EXISTS "public"."blog_comment_vote";
CREATE TABLE "public"."blog_comment_vote" (
"id" int4 NOT NULL,
"comment_id" int4,
"is_support" bit(255),
"vote_time" timestamp(6),
"user_id" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of blog_comment_vote
-- ----------------------------

-- ----------------------------
-- Table structure for blog_followee
-- ----------------------------
DROP TABLE IF EXISTS "public"."blog_followee";
CREATE TABLE "public"."blog_followee" (
"id" int4 NOT NULL,
"user_id" varchar(255) COLLATE "default",
"followee_id" varchar(255) COLLATE "default",
"followee_time" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of blog_followee
-- ----------------------------

-- ----------------------------
-- Table structure for blog_follower
-- ----------------------------
DROP TABLE IF EXISTS "public"."blog_follower";
CREATE TABLE "public"."blog_follower" (
"id" int4 NOT NULL,
"user_id" varchar(255) COLLATE "default",
"followed_id" varchar(255) COLLATE "default",
"followed_time" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of blog_follower
-- ----------------------------

-- ----------------------------
-- Table structure for blog_post
-- ----------------------------
DROP TABLE IF EXISTS "public"."blog_post";
CREATE TABLE "public"."blog_post" (
"id" int4 NOT NULL,
"title" varchar(255) COLLATE "default",
"content" varchar(4096) COLLATE "default",
"blog_id" int4,
"posted" varchar(255) COLLATE "default",
"catolog" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."blog_post"."id" IS 'id';
COMMENT ON COLUMN "public"."blog_post"."title" IS '标题';
COMMENT ON COLUMN "public"."blog_post"."content" IS '内容';
COMMENT ON COLUMN "public"."blog_post"."blog_id" IS '博客id';
COMMENT ON COLUMN "public"."blog_post"."posted" IS '提交时间';
COMMENT ON COLUMN "public"."blog_post"."catolog" IS '分类';

-- ----------------------------
-- Records of blog_post
-- ----------------------------

-- ----------------------------
-- Table structure for blog_post_tag
-- ----------------------------
DROP TABLE IF EXISTS "public"."blog_post_tag";
CREATE TABLE "public"."blog_post_tag" (
"id" int4 NOT NULL,
"post_id" int4,
"tag_id" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of blog_post_tag
-- ----------------------------

-- ----------------------------
-- Table structure for blog_post_viewer
-- ----------------------------
DROP TABLE IF EXISTS "public"."blog_post_viewer";
CREATE TABLE "public"."blog_post_viewer" (
"id" int4 NOT NULL,
"post_id" int4,
"user_id" varchar(255) COLLATE "default",
"address" varchar(255) COLLATE "default",
"read_time" time(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of blog_post_viewer
-- ----------------------------

-- ----------------------------
-- Table structure for blog_post_vote
-- ----------------------------
DROP TABLE IF EXISTS "public"."blog_post_vote";
CREATE TABLE "public"."blog_post_vote" (
"id" int4 NOT NULL,
"post_id" int4,
"is_support" bit(1),
"vote_time" timestamp(6),
"user_id" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of blog_post_vote
-- ----------------------------

-- ----------------------------
-- Table structure for blog_tag
-- ----------------------------
DROP TABLE IF EXISTS "public"."blog_tag";
CREATE TABLE "public"."blog_tag" (
"id" varchar(255) COLLATE "default" NOT NULL,
"name" varchar(255) COLLATE "default",
"blog_id" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of blog_tag
-- ----------------------------

-- ----------------------------
-- Table structure for blog_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."blog_user";
CREATE TABLE "public"."blog_user" (
"id" varchar(255) COLLATE "default" NOT NULL,
"nickname" varchar(255) COLLATE "default",
"regtime" timestamp(6),
"integral" int4,
"username" varchar(255) COLLATE "default",
"password" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."blog_user"."id" IS 'ID';
COMMENT ON COLUMN "public"."blog_user"."nickname" IS '昵称';
COMMENT ON COLUMN "public"."blog_user"."regtime" IS '注册时间';
COMMENT ON COLUMN "public"."blog_user"."integral" IS '积分';
COMMENT ON COLUMN "public"."blog_user"."username" IS '用户名';
COMMENT ON COLUMN "public"."blog_user"."password" IS '密码';

-- ----------------------------
-- Records of blog_user
-- ----------------------------

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table blog
-- ----------------------------
ALTER TABLE "public"."blog" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table blog_catolog
-- ----------------------------
ALTER TABLE "public"."blog_catolog" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table blog_comment
-- ----------------------------
ALTER TABLE "public"."blog_comment" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table blog_comment_vote
-- ----------------------------
ALTER TABLE "public"."blog_comment_vote" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table blog_followee
-- ----------------------------
ALTER TABLE "public"."blog_followee" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table blog_follower
-- ----------------------------
ALTER TABLE "public"."blog_follower" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table blog_post
-- ----------------------------
ALTER TABLE "public"."blog_post" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table blog_post_tag
-- ----------------------------
ALTER TABLE "public"."blog_post_tag" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table blog_post_viewer
-- ----------------------------
ALTER TABLE "public"."blog_post_viewer" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table blog_post_vote
-- ----------------------------
ALTER TABLE "public"."blog_post_vote" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table blog_tag
-- ----------------------------
ALTER TABLE "public"."blog_tag" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table blog_user
-- ----------------------------
ALTER TABLE "public"."blog_user" ADD PRIMARY KEY ("id");

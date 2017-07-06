/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : cnblogs

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2017-07-06 18:08:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `content` varchar(4096) NOT NULL COMMENT '内容',
  `userid` int(20) NOT NULL COMMENT '作者',
  `posted` datetime NOT NULL COMMENT '提交时间',
  `catologid` int(20) DEFAULT NULL COMMENT '分类',
  `blogurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `for_blog_userid` (`userid`),
  KEY `for_blog_catolog` (`catologid`),
  CONSTRAINT `for_blog_catolog` FOREIGN KEY (`catologid`) REFERENCES `catolog` (`id`),
  CONSTRAINT `for_blog_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章';

-- ----------------------------
-- Table structure for blogreader
-- ----------------------------
DROP TABLE IF EXISTS `blogreader`;
CREATE TABLE `blogreader` (
  `id` int(11) NOT NULL,
  `blogid` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `readertime` datetime NOT NULL COMMENT '阅读时间',
  PRIMARY KEY (`id`),
  KEY `for_blogreader_blogid` (`blogid`),
  KEY `for_blogreader_userid` (`userid`),
  CONSTRAINT `for_blogreader_blogid` FOREIGN KEY (`blogid`) REFERENCES `blog` (`id`),
  CONSTRAINT `for_blogreader_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blogvote
-- ----------------------------
DROP TABLE IF EXISTS `blogvote`;
CREATE TABLE `blogvote` (
  `id` int(11) NOT NULL COMMENT 'id',
  `blogid` int(11) NOT NULL COMMENT '文章id',
  `issupport` bit(1) NOT NULL COMMENT '是否支持 支持true ,不支持false  不支持也不反对删除此条记录',
  `votetime` datetime NOT NULL COMMENT '投票时间',
  `userid` int(11) NOT NULL COMMENT '投票人',
  PRIMARY KEY (`id`),
  KEY `for_blogvote_userid` (`userid`),
  KEY `for_blogvote_blogid` (`blogid`),
  CONSTRAINT `for_blogvote_blogid` FOREIGN KEY (`blogid`) REFERENCES `blog` (`id`),
  CONSTRAINT `for_blogvote_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章推荐表';

-- ----------------------------
-- Table structure for catolog
-- ----------------------------
DROP TABLE IF EXISTS `catolog`;
CREATE TABLE `catolog` (
  `id` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `for_catolog_userid` (`userid`),
  CONSTRAINT `for_catolog_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL COMMENT 'id',
  `blogid` int(11) NOT NULL COMMENT '被评论的文章ID',
  `userid` int(11) NOT NULL COMMENT '评论作者id',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `posted` datetime NOT NULL COMMENT '发布时间',
  `commentid` int(11) DEFAULT NULL COMMENT '被评论的评论id',
  PRIMARY KEY (`id`),
  KEY `for_comment_userid` (`userid`),
  KEY `for_comment_blogid` (`blogid`),
  KEY `for_comment_commentid` (`commentid`),
  CONSTRAINT `for_comment_blogid` FOREIGN KEY (`blogid`) REFERENCES `blog` (`id`),
  CONSTRAINT `for_comment_commentid` FOREIGN KEY (`commentid`) REFERENCES `comment` (`id`),
  CONSTRAINT `for_comment_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';

-- ----------------------------
-- Table structure for commentvote
-- ----------------------------
DROP TABLE IF EXISTS `commentvote`;
CREATE TABLE `commentvote` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `commentid` int(11) NOT NULL COMMENT '评论ID',
  `issupport` bit(1) NOT NULL COMMENT '是否支持评论 支持：true 不支持： false ,不支持也不反对 删除',
  `votetime` datetime NOT NULL COMMENT '发表时间',
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `for_commentvote_userid` (`userid`),
  KEY `for_commentvote_commentid` (`commentid`),
  CONSTRAINT `for_commentvote_commentid` FOREIGN KEY (`commentid`) REFERENCES `comment` (`id`),
  CONSTRAINT `for_commentvote_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for followee
-- ----------------------------
DROP TABLE IF EXISTS `followee`;
CREATE TABLE `followee` (
  `id` int(11) NOT NULL COMMENT 'id',
  `userid` int(11) DEFAULT NULL COMMENT '被粉用户ID',
  `followeeid` int(11) DEFAULT NULL COMMENT '粉用户的ID',
  `followeetime` datetime DEFAULT NULL COMMENT '粉的时间',
  PRIMARY KEY (`id`),
  KEY `for_followee_userid` (`userid`),
  KEY `for_followee_followeeid` (`followeeid`),
  CONSTRAINT `for_followee_followeeid` FOREIGN KEY (`followeeid`) REFERENCES `user` (`id`),
  CONSTRAINT `for_followee_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='粉丝表';

-- ----------------------------
-- Table structure for follower
-- ----------------------------
DROP TABLE IF EXISTS `follower`;
CREATE TABLE `follower` (
  `id` int(11) NOT NULL COMMENT 'id',
  `userid` int(11) DEFAULT NULL COMMENT '被关注者id',
  `followedid` int(11) DEFAULT NULL COMMENT '关注者ID',
  `followtime` datetime DEFAULT NULL COMMENT '关注时间',
  PRIMARY KEY (`id`),
  KEY `for_follower_userid` (`userid`),
  KEY `for_follower_followedid` (`followedid`),
  CONSTRAINT `for_follower_followedid` FOREIGN KEY (`followedid`) REFERENCES `user` (`id`),
  CONSTRAINT `for_follower_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关注表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '名称(二级域名)',
  `nickname` varchar(255) NOT NULL COMMENT '昵称',
  `homepage` varchar(255) NOT NULL COMMENT '主页',
  `regtime` datetime NOT NULL COMMENT '注册时间',
  `signature` varchar(255) DEFAULT NULL COMMENT '签名',
  `integral` int(20) NOT NULL DEFAULT '0' COMMENT '积分',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

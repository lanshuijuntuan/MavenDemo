CREATE TABLE `bloguser` (
`id` varchar(255) NOT NULL COMMENT 'ID',
`nickname` varchar(255) NULL COMMENT '昵称',
`regtime` datetime NULL COMMENT '注册时间',
`integral` int(20) NULL DEFAULT 0 COMMENT '积分',
`username` varchar(255) NULL COMMENT '用户名',
`password` varchar(255) NULL COMMENT '密码',
PRIMARY KEY (`id`) 
)
COMMENT='用户表';

CREATE TABLE `post` (
`id` int NOT NULL COMMENT 'id',
`title` varchar(255) NULL COMMENT '标题',
`content` varchar(4096) NULL COMMENT '内容',
`blogid` int(20) NULL COMMENT '博客id',
`posted` datetime NULL COMMENT '提交时间',
`catolog` varchar(255) NULL COMMENT '分类',
`posturl` varchar(255) NULL,
PRIMARY KEY (`id`) 
)
COMMENT='文章';

CREATE TABLE `comment` (
`id` int NOT NULL COMMENT 'id',
`postid` int NULL COMMENT '被评论的文章ID',
`userid` varchar(255) NULL COMMENT '评论作者id',
`content` blob NULL COMMENT '评论内容',
`posted` datetime NULL COMMENT '发布时间',
`commentid` int NOT NULL COMMENT '被评论的评论id',
PRIMARY KEY (`id`) 
)
COMMENT='评论表';

CREATE TABLE `commentvote` (
`id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
`commentid` int NOT NULL COMMENT '评论ID',
`issupport` bit(1) NOT NULL COMMENT '是否支持评论 支持：true 不支持： false ,不支持也不反对 删除',
`votetime` datetime NOT NULL COMMENT '发表时间',
`userid` varchar(255) NOT NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `postvote` (
`id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
`postid` int NOT NULL COMMENT '文章id',
`issupport` bit(1) NOT NULL COMMENT '是否支持 支持true ,不支持false  不支持也不反对删除此条记录',
`votetime` datetime NOT NULL COMMENT '投票时间',
`userid` varchar(255) NOT NULL COMMENT '投票人',
PRIMARY KEY (`id`) 
)
COMMENT='文章推荐表';

CREATE TABLE `follower` (
`id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
`userid` varchar(255) NULL COMMENT '被关注者id',
`followedid` varchar(255) NULL COMMENT '关注者ID',
`followtime` datetime NULL COMMENT '关注时间',
PRIMARY KEY (`id`) 
)
COMMENT='关注表';

CREATE TABLE `followee` (
`id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
`userid` varchar(255) NULL COMMENT '被粉用户ID',
`followeeid` varchar(255) NULL COMMENT '粉用户的ID',
`followeetime` datetime NULL COMMENT '粉的时间',
PRIMARY KEY (`id`) 
)
COMMENT='粉丝表';

CREATE TABLE `postviewer` (
`id` int NOT NULL AUTO_INCREMENT,
`postid` int NOT NULL,
`userid` varchar(255) NULL,
`address` varchar(255) NULL,
`readertime` datetime NOT NULL COMMENT '阅读时间',
PRIMARY KEY (`id`) 
);

CREATE TABLE `catolog` (
`blogid` int(20) NULL,
`name` varchar(255) NULL,
`id` varchar(255) NOT NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `tag` (
`blogid` int(20) NULL COMMENT '标签所属用户',
`name` varchar(255) NULL COMMENT '标签名称',
`id` varchar(255) NOT NULL,
PRIMARY KEY (`id`) 
)
COMMENT='用户的自建的标签';

CREATE TABLE `posttag` (
`id` int NOT NULL AUTO_INCREMENT,
`postid` int NOT NULL COMMENT '帖子ID',
`tagid` varchar(255) NOT NULL COMMENT '标签id',
PRIMARY KEY (`id`) 
)
COMMENT='帖子和标签多对多关系';

CREATE TABLE `blog` (
`id` int(20) NOT NULL,
`blogname` varchar(255) NULL,
`sign` varchar(255) NULL,
`userid` varchar(255) NOT NULL,
`homepage` varchar(255) NULL,
PRIMARY KEY (`id`) 
);


ALTER TABLE `comment` ADD CONSTRAINT `for_comment_userid` FOREIGN KEY (`userid`) REFERENCES `bloguser` (`id`);
ALTER TABLE `comment` ADD CONSTRAINT `for_comment_blogid` FOREIGN KEY (`postid`) REFERENCES `post` (`id`);
ALTER TABLE `comment` ADD CONSTRAINT `for_comment_commentid` FOREIGN KEY (`commentid`) REFERENCES `comment` (`id`);
ALTER TABLE `post` ADD CONSTRAINT `for_post_blogid` FOREIGN KEY (`blogid`) REFERENCES `blog` (`id`);
ALTER TABLE `commentvote` ADD CONSTRAINT `for_commentvote_userid` FOREIGN KEY (`userid`) REFERENCES `bloguser` (`id`);
ALTER TABLE `commentvote` ADD CONSTRAINT `for_commentvote_commentid` FOREIGN KEY (`commentid`) REFERENCES `comment` (`id`);
ALTER TABLE `postvote` ADD CONSTRAINT `for_postvote_userid` FOREIGN KEY (`userid`) REFERENCES `bloguser` (`id`);
ALTER TABLE `postvote` ADD CONSTRAINT `for_postvote_postid` FOREIGN KEY (`postid`) REFERENCES `post` (`id`);
ALTER TABLE `follower` ADD CONSTRAINT `for_follower_userid` FOREIGN KEY (`userid`) REFERENCES `bloguser` (`id`);
ALTER TABLE `follower` ADD CONSTRAINT `for_follower_followedid` FOREIGN KEY (`followedid`) REFERENCES `bloguser` (`id`);
ALTER TABLE `postviewer` ADD CONSTRAINT `for_postviewer_blogid` FOREIGN KEY (`postid`) REFERENCES `post` (`id`);
ALTER TABLE `postviewer` ADD CONSTRAINT `for_postviewer_userid` FOREIGN KEY (`userid`) REFERENCES `bloguser` (`id`);
ALTER TABLE `followee` ADD CONSTRAINT `for_followee_userid` FOREIGN KEY (`userid`) REFERENCES `bloguser` (`id`);
ALTER TABLE `followee` ADD CONSTRAINT `for_followee_followeeid` FOREIGN KEY (`followeeid`) REFERENCES `bloguser` (`id`);
ALTER TABLE `posttag` ADD CONSTRAINT `for_posttag_postid` FOREIGN KEY (`postid`) REFERENCES `post` (`id`);
ALTER TABLE `blog` ADD CONSTRAINT `for_blog_userid` FOREIGN KEY (`userid`) REFERENCES `bloguser` (`id`);
ALTER TABLE `catolog` ADD CONSTRAINT `for_catolog` FOREIGN KEY (`blogid`) REFERENCES `blog` (`id`);
ALTER TABLE `tag` ADD CONSTRAINT `for_tag_blogid` FOREIGN KEY (`blogid`) REFERENCES `blog` (`id`);


/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50742
Source Host           : localhost:3306
Source Database       : job

Target Server Type    : MYSQL
Target Server Version : 50742
File Encoding         : 65001

Date: 2023-12-22 09:46:12
*/

SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for teachers
-- ----------------------------
DROP TABLE IF EXISTS `teachers`;
CREATE TABLE `teachers` (
                            `teacher_id` int(11) NOT NULL AUTO_INCREMENT,
                            `teacher_name` varchar(100) DEFAULT NULL,
                            `teacher_number` varchar(20) DEFAULT NULL,
                            `teacher_password` varchar(255) DEFAULT NULL,
                            `update_time` date DEFAULT NULL,
                            `create_time` date DEFAULT NULL,
                            `picture` varchar(255) DEFAULT 'http://localhost:8080/jobManage/images/pic.png',
                            PRIMARY KEY (`teacher_id`),
                            UNIQUE KEY `tea_num_uk` (`teacher_number`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teachers
-- ----------------------------
INSERT INTO `teachers` VALUES ('1', '周老师', '1303', 'E10ADC3949BA59ABBE56E057F20F883E', '2023-11-22', '2023-11-22', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `teachers` VALUES ('2', '张老师', '1301', 'E10ADC3949BA59ABBE56E057F20F883E', '2023-11-22', '2023-11-22', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `teachers` VALUES ('3', '王老师', '1302', 'E10ADC3949BA59ABBE56E057F20F883E', '2023-11-22', '2023-11-22', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `teachers` VALUES ('4', '五老师', 'a1000', '202CB962AC59075B964B07152D234B70', '2023-11-22', '2023-11-22', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `teachers` VALUES ('5', '六老师', 'a1001', '202CB962AC59075B964B07152D234B70', '2023-11-22', '2023-11-22', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `teachers` VALUES ('6', '期老师', 'a1002', '202CB962AC59075B964B07152D234B70', '2023-11-22', '2023-11-22', 'http://localhost:8080/jobManage/images/pic.png');



-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
                            `student_id` int(11) NOT NULL AUTO_INCREMENT,
                            `student_number` varchar(20) DEFAULT NULL,
                            `student_password` varchar(255) DEFAULT NULL,
                            `student_name` varchar(100) DEFAULT NULL,
                            `student_class` varchar(10) DEFAULT NULL,
                            `update_time` date DEFAULT NULL,
                            `create_time` date DEFAULT NULL,
                            `picture` varchar(255) DEFAULT 'http://localhost:8080/jobManage/images/pic.png',
                            PRIMARY KEY (`student_id`),
                            UNIQUE KEY `st_num_uk` (`student_number`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('1', '20232160A1327', 'E10ADC3949BA59ABBE56E057F20F883E', '徐绍玉', '2113', '2023-11-01', '2023-11-01', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `students` VALUES ('2', '20232160A1330', 'E10ADC3949BA59ABBE56E057F20F883E', '于辉', '2113', '2023-11-22', '2023-11-22', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `students` VALUES ('3', '20232160A1332', 'E10ADC3949BA59ABBE56E057F20F883E', '张杰', '2113', '2023-12-01', '2023-12-01', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `students` VALUES ('4', '20232160A1314', 'E10ADC3949BA59ABBE56E057F20F883E', '吕亚新', '2113', '2023-12-08', '2023-12-08', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `students` VALUES ('5', '20232160A1415', 'E10ADC3949BA59ABBE56E057F20F883E', '王某某', '2114', '2023-12-08', '2023-12-08', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `students` VALUES ('6', '20232160A1333124', 'E10ADC3949BA59ABBE56E057F20F883E', '张杰11', '2117', '2023-12-19', '2023-12-19', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `students` VALUES ('7', '20232160A1332s', 'E10ADC3949BA59ABBE56E057F20F883E', '张杰s', '2113', '2023-12-20', '2023-12-20', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `students` VALUES ('8', '1200', '202CB962AC59075B964B07152D234B70', '张杰s', '2113', '2023-12-20', '2023-12-20', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `students` VALUES ('9', '1201', '202CB962AC59075B964B07152D234B70', '小曾', '2113', '2023-12-20', '2023-12-20', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `students` VALUES ('10', '1202', '202CB962AC59075B964B07152D234B70', '小龚', '2113', '2023-12-20', '2023-12-20', 'http://localhost:8080/jobManage/images/pic.png');


-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
                          `course_id` int(11) NOT NULL,
                          `course_name` varchar(255) DEFAULT NULL,
                          `course_img_url` varchar(255) DEFAULT NULL,
                          `teacher` varchar(255) DEFAULT NULL,
                          `as_is_delete` int(1) NOT NULL DEFAULT '0',
                          `update_time` date DEFAULT NULL,
                          `create_time` date DEFAULT NULL,
                          PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'java', 'e://ccccc', '李超', '0', '2023-01-01', '2023-01-01');
INSERT INTO `course` VALUES ('2', 'php', 'e://', '李超', '0', '2023-01-01', '2023-01-01');
INSERT INTO `course` VALUES ('3', 'c语言', 'e:///', '李超', '0', '2023-01-01', '2023-01-01');
INSERT INTO `course` VALUES ('4', '数据库', 'http://localhost:8080/jobManage/images/database.png', '李超', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('5', '数据库', 'http://localhost:8080/jobManage/images/database.png', '李超', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('6', '数据库', 'http://localhost:8080/jobManage/images/database.png', '李超', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('7', '数据库', 'http://localhost:8080/jobManage/images/database.png', '李超', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('8', '数据库', 'http://localhost:8080/jobManage/images/database.png', '李超', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('9', '数据库', 'http://localhost:8080/jobManage/images/database.png', '李超', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('10', '数据库', 'http://localhost:8080/jobManage/images/database.png', '李超', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('11', '形式与政策', 'http://localhost:8080/jobManage/images/a.png', '李超', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('12', '操作系统', 'http://localhost:8080/jobManage/images/system.png', '李超', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('13', 'Photoshop图像处理', 'http://localhost:8080/jobManage/images/photo.png', '李超', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('14', '计算机基础', 'http://localhost:8080/jobManage/images/base.png', '李超', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('15', '数据库综合实训', 'http://localhost:8080/jobManage/images/compre.png', '李超', 0, '2023-12-20', '2023-12-20');

-- ----------------------------
-- Table structure for assignments
-- ----------------------------
DROP TABLE IF EXISTS `assignments`;
CREATE TABLE `assignments` (
                               `assignment_id` int(11) NOT NULL AUTO_INCREMENT,
                               `assignment_title` varchar(255) DEFAULT NULL,
                               `assignment_description` varchar(255) DEFAULT NULL,
                               `assignment_deadline` date DEFAULT NULL,
                               `assignment_subject` varchar(255) DEFAULT NULL,
                               `assignment_class` varchar(255) DEFAULT NULL,
                               `tea_id` int(11) DEFAULT NULL,
                               `course_id` int(11) DEFAULT NULL,
                               `as_is_delete` int(1) DEFAULT '0',
                               `update_time` date DEFAULT NULL,
                               `create_time` date DEFAULT NULL,
                               PRIMARY KEY (`assignment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of assignments
-- ----------------------------
INSERT INTO `assignments` VALUES ('1', 'c语言作业', '利用c语言输出helloword', '2023-12-28', 'c语言', '2113', '1', '1', '0', '2023-11-01', '2023-11-01');
INSERT INTO `assignments` VALUES ('2', 'php作业', '利用phph输出helloword', '2023-12-29', 'php', '2113', '2', '2', '0', '2023-11-15', '2023-11-15');
INSERT INTO `assignments` VALUES ('3', 'java作业', '利用java输出helloworld', '2023-12-11', 'java', '2113', '3', '1', '0', '2023-11-15', '2023-11-13');
INSERT INTO `assignments` VALUES ('4', 'C#作业', '利用C#输出helloworld', '2023-01-01', 'C#', '2114', '1', '4', '0', '2023-12-08', '2023-12-08');
INSERT INTO `assignments` VALUES ('5', 'java作业', '利用java输出helloworld', '2023-12-11', 'java', '2113', '11', '11', '0', '2023-11-15', '2023-11-13');
INSERT INTO `assignments` VALUES ('6', 'C#作业', '利用C#输出helloworld', '2023-01-01', 'C#', '2114', '11', '11', '0', '2023-12-08', '2023-12-08');
INSERT INTO `assignments` VALUES ('7', 'c语言作业', '利用c语言输出helloword', '2023-12-28', 'c语言', '2113', '11', '12', '0', '2023-11-01', '2023-11-01');
INSERT INTO `assignments` VALUES ('8', 'php作业', '利用phph输出helloword', '2023-12-29', 'php', '2113', '11', '12', '0', '2023-11-15', '2023-11-15');
INSERT INTO `assignments` VALUES ('9', 'java作业', '利用java输出helloworld', '2023-12-11', 'java', '2113', '11', '12', '0', '2023-11-15', '2023-11-13');
INSERT INTO `assignments` VALUES ('10', 'phpä½ä¸ä¸', 'ä½ä¸æè¿°', '2023-12-12', 'java', '2113', '1', null, '0', '2023-12-20', '2023-12-20');
INSERT INTO `assignments` VALUES ('11', 'c语言作业', '利用c语言输出helloword', '2023-12-28', 'c语言', '2113', '10', '12', '0', '2023-11-01', '2023-11-01');
INSERT INTO `assignments` VALUES ('12', 'php作业', '利用phph输出helloword', '2023-12-29', 'php', '2113', '10', '12', '0', '2023-11-15', '2023-11-15');
INSERT INTO `assignments` VALUES ('13', 'java作业', '利用java输出helloworld', '2023-12-11', 'java', '2113', '10', '12', '0', '2023-11-15', '2023-11-13');
INSERT INTO `assignments` VALUES ('14', 'C#作业', '利用C#输出helloworld', '2023-01-01', 'C#', '2114', '10', '12', '0', '2023-12-08', '2023-12-08');
INSERT INTO `assignments` VALUES ('15', 'c语言作业', '利用c语言输出helloword', '2023-12-28', 'c语言', '2113', '11', '10', '0', '2023-11-01', '2023-11-01');
INSERT INTO `assignments` VALUES ('16', 'php作业', '利用phph输出helloword', '2023-12-29', 'php', '2113', '11', '10', '0', '2023-11-15', '2023-11-15');
INSERT INTO `assignments` VALUES ('17', 'java作业', '利用java输出helloworld', '2023-12-11', 'java', '2113', '11', '10', '0', '2023-11-15', '2023-11-13');
INSERT INTO `assignments` VALUES ('18', 'C#作业', '利用C#输出helloworld', '2023-01-01', 'C#', '2114', '11', '10', '0', '2023-12-08', '2023-12-08');
INSERT INTO `assignments` VALUES ('19', 'c语言作业', '利用c语言输出helloword', '2023-12-28', 'c语言', '2113', '11', '11', '0', '2023-11-01', '2023-11-01');
INSERT INTO `assignments` VALUES ('20', 'c语言作业', '利用c语言输出helloword', '2023-12-28', 'c语言', '2113', '10', '10', '0', '2023-11-01', '2023-11-01');
INSERT INTO `assignments` VALUES ('21', 'php作业', '利用phph输出helloword', '2023-12-29', 'php', '2113', '10', '10', '0', '2023-11-15', '2023-11-15');
INSERT INTO `assignments` VALUES ('22', 'java作业', '利用java输出helloworld', '2023-12-11', 'java', '2113', '10', '10', '0', '2023-11-15', '2023-11-13');
INSERT INTO `assignments` VALUES ('24', 'C#作业', '利用C#输出helloworld', '2023-01-01', 'C#', '2114', '10', '10', '0', '2023-12-08', '2023-12-08');
INSERT INTO `assignments` VALUES ('25', 'c语言作业', '利用c语言输出helloword', '2023-12-28', 'c语言', '2113', '10', '11', '0', '2023-11-01', '2023-11-01');
INSERT INTO `assignments` VALUES ('26', 'php作业', '利用phph输出helloword', '2023-12-29', 'php', '2113', '10', '11', '0', '2023-11-15', '2023-11-15');
INSERT INTO `assignments` VALUES ('27', 'java作业', '利用java输出helloworld', '2023-12-11', 'java', '2113', '10', '11', '0', '2023-11-15', '2023-11-13');
INSERT INTO `assignments` VALUES ('28', 'C#作业', '利用C#输出helloworld', '2023-01-01', 'C#', '2114', '10', '11', '0', '2023-12-08', '2023-12-08');
INSERT INTO `assignments` VALUES ('29', 'php作业', '利用phph输出helloword', '2023-12-29', 'php', '2113', '11', '11', '0', '2023-11-15', '2023-11-15');
INSERT INTO `assignments` VALUES ('30', 'C#作业', '利用C#输出helloworld', '2023-01-01', 'C#', '2114', '11', '12', '0', '2023-12-08', '2023-12-08');

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
                        `note_id` int(11) NOT NULL AUTO_INCREMENT,
                        `student_id` int(11) DEFAULT NULL,
                        `content` varchar(255) DEFAULT NULL,
                        `create_time` date DEFAULT NULL,
                        PRIMARY KEY (`note_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES ('1', '1', '这是学生1我的笔记', '2023-12-21');
INSERT INTO `note` VALUES ('3', '2', '这是学生2我的笔记', '2023-12-21');

-- ----------------------------
-- Table structure for stu_course
-- ----------------------------
DROP TABLE IF EXISTS `stu_course`;
CREATE TABLE `stu_course` (
                              `id` int(11) NOT NULL AUTO_INCREMENT,
                              `student_id` int(11) NOT NULL,
                              `course_id` int(11) NOT NULL,
                              `as_is_delete` int(1) NOT NULL DEFAULT '0',
                              `update_time` date DEFAULT NULL,
                              `create_time` date DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_course
-- ----------------------------
INSERT INTO `stu_course` VALUES (1, '8', '10', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES (2, '8', '11', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES (3, '8', '13', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES (4, '8', '14', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES (5, '8', '15', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES (6, '9', '10', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES (7, '9', '11', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES (8, '9', '12', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES (9, '9', '13', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES (10, '9', '14', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES (11, '9', '15', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES (12, '8', '12', 0, '2023-12-20', '2023-12-20');

-- ----------------------------
-- Table structure for tea_course
-- ----------------------------
DROP TABLE IF EXISTS `tea_course`;
CREATE TABLE `tea_course` (
                              `id` int(11) NOT NULL AUTO_INCREMENT,
                              `teacher_id` int(11) NOT NULL,
                              `course_id` int(11) NOT NULL,
                              `as_is_delete` int(1) DEFAULT '0',
                              `update_time` date DEFAULT NULL,
                              `create_time` date DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tea_course
-- ----------------------------
INSERT INTO `tea_course` VALUES (1, '4', '10', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES (2, '4', '11', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES (3, '4', '12', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES (4, '4', '13', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES (5, '4', '14', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES (6, '4', '15', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES (7, '5', '10', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES (8, '5', '11', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES (9, '5', '12', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES (10, '5', '13', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES (11, '5', '14', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES (12, '5', '15', 0, '2023-12-20', '2023-12-20');

-- ----------------------------
-- Table structure for submissions
-- ----------------------------
DROP TABLE IF EXISTS `submissions`;
CREATE TABLE `submissions` (
                               `submission_id` int(11) NOT NULL AUTO_INCREMENT,
                               `student_id` int(11) DEFAULT NULL,
                               `assignment_id` int(11) DEFAULT NULL,
                               `submission_date` date DEFAULT NULL,
                               `score` varchar(255) DEFAULT NULL,
                               `file_path` varchar(255) DEFAULT NULL,
                               `update_time` date DEFAULT NULL,
                               `create_time` date DEFAULT NULL,
                               `status` int(1) DEFAULT '0' COMMENT '0代表未提交，1代表已提交，2代表已批改',
                               PRIMARY KEY (`submission_id`),
                               UNIQUE KEY `unique_two` (`student_id`,`assignment_id`),
                               KEY `teaid_fk` (`assignment_id`),
                               KEY `stuid_fk` (`student_id`),
                               CONSTRAINT `stuid_fk` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`),
                               CONSTRAINT `teaid_fk` FOREIGN KEY (`assignment_id`) REFERENCES `assignments` (`assignment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of submissions
-- ----------------------------
INSERT INTO `submissions` VALUES ('1', '5', '11', '2023-12-08', '12', 'http://localhost:8080/jobManage/assignment/README.md', '2023-12-01', '2023-12-01', '2');
INSERT INTO `submissions` VALUES ('2', '6', '11', '2023-12-08', '10', 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-08', '2023-12-08', '2');
INSERT INTO `submissions` VALUES ('3', '7', '11', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/README.md', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('4', '8', '11', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('5', '9', '11', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/README.md', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('6', '10', '11', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('7', '5', '12', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/README.md', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('8', '6', '12', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('9', '7', '12', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/README.md', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('10', '8', '12', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('11', '9', '12', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/README.md', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('12', '10', '12', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('13', '5', '13', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/README.md', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('14', '6', '13', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('15', '7', '13', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/README.md', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('16', '8', '13', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('17', '9', '13', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/README.md', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('18', '10', '13', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');

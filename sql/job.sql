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
INSERT INTO `assignments` VALUES ('10', 'phpä½ä¸ä¸', 'ä½ä¸æè¿°', '2023-12-12', 'java', '2113', '1', null, '0', '2023-12-20', '2023-12-20');
INSERT INTO `assignments` VALUES ('20', 'c语言作业', '利用c语言输出helloword', '2023-12-28', 'c语言', '2113', '10', '10', '0', '2023-11-01', '2023-11-01');
INSERT INTO `assignments` VALUES ('21', 'php作业', '利用phph输出helloword', '2023-12-29', 'php', '2113', '10', '10', '0', '2023-11-15', '2023-11-15');
INSERT INTO `assignments` VALUES ('22', 'java作业', '利用java输出helloworld', '2023-12-11', 'java', '2113', '10', '10', '0', '2023-11-15', '2023-11-13');
INSERT INTO `assignments` VALUES ('23', 'C#作业', '利用C#输出helloworld', '2023-01-01', 'C#', '2114', '10', '10', '0', '2023-12-08', '2023-12-08');
INSERT INTO `assignments` VALUES ('20', 'c语言作业', '利用c语言输出helloword', '2023-12-28', 'c语言', '2113', '10', '11', '0', '2023-11-01', '2023-11-01');
INSERT INTO `assignments` VALUES ('21', 'php作业', '利用phph输出helloword', '2023-12-29', 'php', '2113', '10', '11', '0', '2023-11-15', '2023-11-15');
INSERT INTO `assignments` VALUES ('22', 'java作业', '利用java输出helloworld', '2023-12-11', 'java', '2113', '10', '11', '0', '2023-11-15', '2023-11-13');
INSERT INTO `assignments` VALUES ('23', 'C#作业', '利用C#输出helloworld', '2023-01-01', 'C#', '2114', '10', '11', '0', '2023-12-08', '2023-12-08');
INSERT INTO `assignments` VALUES ('20', 'c语言作业', '利用c语言输出helloword', '2023-12-28', 'c语言', '2113', '10', '12', '0', '2023-11-01', '2023-11-01');
INSERT INTO `assignments` VALUES ('21', 'php作业', '利用phph输出helloword', '2023-12-29', 'php', '2113', '10', '12', '0', '2023-11-15', '2023-11-15');
INSERT INTO `assignments` VALUES ('22', 'java作业', '利用java输出helloworld', '2023-12-11', 'java', '2113', '10', '12', '0', '2023-11-15', '2023-11-13');
INSERT INTO `assignments` VALUES ('23', 'C#作业', '利用C#输出helloworld', '2023-01-01', 'C#', '2114', '10', '12', '0', '2023-12-08', '2023-12-08');

INSERT INTO `assignments` VALUES ('20', 'c语言作业', '利用c语言输出helloword', '2023-12-28', 'c语言', '2113', '11', '10', '0', '2023-11-01', '2023-11-01');
INSERT INTO `assignments` VALUES ('21', 'php作业', '利用phph输出helloword', '2023-12-29', 'php', '2113', '11', '10', '0', '2023-11-15', '2023-11-15');
INSERT INTO `assignments` VALUES ('22', 'java作业', '利用java输出helloworld', '2023-12-11', 'java', '2113', '11', '10', '0', '2023-11-15', '2023-11-13');
INSERT INTO `assignments` VALUES ('23', 'C#作业', '利用C#输出helloworld', '2023-01-01', 'C#', '2114', '11', '10', '0', '2023-12-08', '2023-12-08');
INSERT INTO `assignments` VALUES ('20', 'c语言作业', '利用c语言输出helloword', '2023-12-28', 'c语言', '2113', '11', '11', '0', '2023-11-01', '2023-11-01');
INSERT INTO `assignments` VALUES ('21', 'php作业', '利用phph输出helloword', '2023-12-29', 'php', '2113', '11', '11', '0', '2023-11-15', '2023-11-15');
INSERT INTO `assignments` VALUES ('22', 'java作业', '利用java输出helloworld', '2023-12-11', 'java', '2113', '11', '11', '0', '2023-11-15', '2023-11-13');
INSERT INTO `assignments` VALUES ('23', 'C#作业', '利用C#输出helloworld', '2023-01-01', 'C#', '2114', '11', '11', '0', '2023-12-08', '2023-12-08');
INSERT INTO `assignments` VALUES ('20', 'c语言作业', '利用c语言输出helloword', '2023-12-28', 'c语言', '2113', '11', '12', '0', '2023-11-01', '2023-11-01');
INSERT INTO `assignments` VALUES ('21', 'php作业', '利用phph输出helloword', '2023-12-29', 'php', '2113', '11', '12', '0', '2023-11-15', '2023-11-15');
INSERT INTO `assignments` VALUES ('22', 'java作业', '利用java输出helloworld', '2023-12-11', 'java', '2113', '11', '12', '0', '2023-11-15', '2023-11-13');
INSERT INTO `assignments` VALUES ('23', 'C#作业', '利用C#输出helloworld', '2023-01-01', 'C#', '2114', '11', '12', '0', '2023-12-08', '2023-12-08');

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
INSERT INTO `course` VALUES ('10', '数据库', 'http://localhost:8080/jobManage/images/database.png', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('11', '形式与政策', 'http://localhost:8080/jobManage/images/a.png', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('12', '操作系统', 'http://localhost:8080/jobManage/images/system.png', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('13', 'Photoshop图像处理', 'http://localhost:8080/jobManage/images/photo.png', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('14', '计算机基础', 'http://localhost:8080/jobManage/images/base.png', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('15', '数据库综合实训', 'http://localhost:8080/jobManage/images/compre.png', 0, '2023-12-20', '2023-12-20');


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
INSERT INTO `students` VALUES ('9', '20232160A1314', 'E10ADC3949BA59ABBE56E057F20F883E', '吕亚新', '2113', '2023-12-08', '2023-12-08', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `students` VALUES ('11', '20232160A1415', 'E10ADC3949BA59ABBE56E057F20F883E', '王某某', '2114', '2023-12-08', '2023-12-08', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `students` VALUES ('12', '20232160A1333124', 'E10ADC3949BA59ABBE56E057F20F883E', '张杰11', '2117', '2023-12-19', '2023-12-19', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `students` VALUES ('16', '20232160A1332s', 'E10ADC3949BA59ABBE56E057F20F883E', '张杰s', '2113', '2023-12-20', '2023-12-20', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `students` VALUES ('26', '1200', '202CB962AC59075B964B07152D234B70', '张杰s', '2113', '2023-12-20', '2023-12-20');
INSERT INTO `students` VALUES ('27', '1201', '202CB962AC59075B964B07152D234B70', '小曾', '2113', '2023-12-20', '2023-12-20');
INSERT INTO `students` VALUES ('28', '1202', '202CB962AC59075B964B07152D234B70', '小龚', '2113', '2023-12-20', '2023-12-20');
-- ----------------------------
-- Table structure for stu_course
-- ----------------------------
DROP TABLE IF EXISTS `stu_course`;
CREATE TABLE `stu_course` (
                              `student_id` int(11) NOT NULL,
                              `course_id` int(11) NOT NULL,
                              `as_is_delete` int(1) NOT NULL DEFAULT '0',
                              `update_time` date DEFAULT NULL,
                              `create_time` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_course
-- ----------------------------
INSERT INTO `stu_course` VALUES ('1', '1', '0', null, null);
INSERT INTO `stu_course` VALUES ('1', '2', '0', null, null);
INSERT INTO `stu_course` VALUES ('26', '10', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES ('26', '11', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES ('26', '12', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES ('26', '13', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES ('26', '14', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES ('26', '15', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES ('27', '10', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES ('27', '11', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES ('27', '12', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES ('27', '13', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES ('27', '14', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES ('27', '15', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES ('28', '10', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES ('28', '11', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES ('28', '12', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES ('28', '13', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES ('28', '14', 0, '2023-12-20', '2023-12-20');
INSERT INTO `stu_course` VALUES ('28', '15', 0, '2023-12-20', '2023-12-20');

-- ----------------------------
-- Table structure for submissions
-- ----------------------------
DROP TABLE IF EXISTS `submissions`;
CREATE TABLE `submissions` (
                               `submission_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '0代表未提交，1代表已提交，2代表已批改',
                               `student_id` int(11) DEFAULT NULL,
                               `assignment_id` int(11) DEFAULT NULL,
                               `submission_date` date DEFAULT NULL,
                               `score` varchar(255) DEFAULT NULL,
                               `file_path` varchar(255) DEFAULT NULL,
                               `update_time` date DEFAULT NULL,
                               `create_time` date DEFAULT NULL,
                               `status` int(1) DEFAULT '0',
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
INSERT INTO `submissions` VALUES ('1', '11', '1', '2023-12-08', '12', 'ini', '2023-12-01', '2023-12-01', '0');
INSERT INTO `submissions` VALUES ('5', '11', '4', '2023-12-08', '10', 'E://test', '2023-12-08', '2023-12-08', '2');
INSERT INTO `submissions` VALUES ('7', '12', '4', '2023-12-08', null, null, null, null, '0');
INSERT INTO `submissions` VALUES ('8', '1', '2', null, null, null, null, null, '0');
INSERT INTO `submissions` VALUES ('21', '1', '1', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('31', '26', '20', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('32', '27', '20', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('33', '28', '20', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('34', '26', '21', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('35', '27', '21', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('36', '28', '21', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('37', '26', '22', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('38', '27', '22', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('39', '28', '22', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');

-- ----------------------------
-- Table structure for teachers
-- ----------------------------
DROP TABLE IF EXISTS `teachers`;
CREATE TABLE `teachers` (
                            `teacher_id` int(11) NOT NULL AUTO_INCREMENT,
                            `teacher_name` varchar(100) DEFAULT NULL,
                            `teacher_number` varchar(20) DEFAULT NULL,
                            `teacher_password` varchar(255) DEFAULT NULL,
                            `teacher_assignment_id` int(11) DEFAULT NULL,
                            `update_time` date DEFAULT NULL,
                            `create_time` date DEFAULT NULL,
                            `picture` varchar(255) DEFAULT 'http://localhost:8080/jobManage/images/pic.png',
                            PRIMARY KEY (`teacher_id`),
                            UNIQUE KEY `tea_num_uk` (`teacher_number`) USING BTREE,
                            KEY `teacher_assignment_id` (`teacher_assignment_id`),
                            CONSTRAINT `tea_as_fk` FOREIGN KEY (`teacher_assignment_id`) REFERENCES `assignments` (`assignment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teachers
-- ----------------------------
INSERT INTO `teachers` VALUES ('1', '周老师', '1303', 'E10ADC3949BA59ABBE56E057F20F883E', null, '2023-11-22', '2023-11-22', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `teachers` VALUES ('2', '张老师', '1301', 'E10ADC3949BA59ABBE56E057F20F883E', null, '2023-11-22', '2023-11-22', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `teachers` VALUES ('3', '王老师', '1302', 'E10ADC3949BA59ABBE56E057F20F883E', null, '2023-11-22', '2023-11-22', 'http://localhost:8080/jobManage/images/pic.png');
INSERT INTO `teachers` VALUES ('10', '五老师', 'a1000', '202CB962AC59075B964B07152D234B70', null, '2023-11-22', '2023-11-22');
INSERT INTO `teachers` VALUES ('11', '六老师', 'a1001', '202CB962AC59075B964B07152D234B70', null, '2023-11-22', '2023-11-22');
INSERT INTO `teachers` VALUES ('12', '期老师', 'a1002', '202CB962AC59075B964B07152D234B70', null, '2023-11-22', '2023-11-22');
-- ----------------------------
-- Table structure for tea_course
-- ----------------------------
DROP TABLE IF EXISTS `tea_course`;
CREATE TABLE `tea_course` (
                              `teacher_id` int(11) NOT NULL,
                              `course_id` int(11) NOT NULL,
                              `as_is_delete` int(1) DEFAULT '0',
                              `update_time` date DEFAULT NULL,
                              `create_time` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tea_course
-- ----------------------------
INSERT INTO `tea_course` VALUES ('1', '1', '0', null, null);
INSERT INTO `tea_course` VALUES ('10', '10', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES ('10', '11', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES ('10', '12', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES ('10', '13', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES ('10', '14', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES ('10', '15', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES ('11', '10', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES ('11', '11', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES ('11', '12', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES ('11', '13', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES ('11', '14', 0, '2023-12-20', '2023-12-20');
INSERT INTO `tea_course` VALUES ('11', '15', 0, '2023-12-20', '2023-12-20');

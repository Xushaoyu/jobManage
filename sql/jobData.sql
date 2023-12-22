INSERT INTO `teachers` VALUES ('10', '五老师', 'a1000', '202CB962AC59075B964B07152D234B70', null, '2023-11-22', '2023-11-22');
INSERT INTO `teachers` VALUES ('11', '六老师', 'a1001', '202CB962AC59075B964B07152D234B70', null, '2023-11-22', '2023-11-22');
INSERT INTO `teachers` VALUES ('12', '期老师', 'a1002', '202CB962AC59075B964B07152D234B70', null, '2023-11-22', '2023-11-22');

INSERT INTO `students` VALUES ('26', '1200', '202CB962AC59075B964B07152D234B70', '张杰s', '2113', '2023-12-20', '2023-12-20');
INSERT INTO `students` VALUES ('27', '1201', '202CB962AC59075B964B07152D234B70', '小曾', '2113', '2023-12-20', '2023-12-20');
INSERT INTO `students` VALUES ('28', '1202', '202CB962AC59075B964B07152D234B70', '小龚', '2113', '2023-12-20', '2023-12-20');

INSERT INTO `course` VALUES ('10', '数据库', 'http://localhost:8080/jobManage/images/database.png', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('11', '形式与政策', 'http://localhost:8080/jobManage/images/a.png', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('12', '操作系统', 'http://localhost:8080/jobManage/images/system.png', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('13', 'Photoshop图像处理', 'http://localhost:8080/jobManage/images/photo.png', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('14', '计算机基础', 'http://localhost:8080/jobManage/images/base.png', 0, '2023-12-20', '2023-12-20');
INSERT INTO `course` VALUES ('15', '数据库综合实训', 'http://localhost:8080/jobManage/images/compre.png', 0, '2023-12-20', '2023-12-20');

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

INSERT INTO `submissions` VALUES ('31', '26', '20', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('32', '27', '20', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('33', '28', '20', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('34', '26', '21', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('35', '27', '21', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('36', '28', '21', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('37', '26', '22', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('38', '27', '22', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');
INSERT INTO `submissions` VALUES ('39', '28', '22', '2023-12-20', null, 'http://localhost:8080/jobManage/assignment/job.sql', '2023-12-20', '2023-12-20', '1');

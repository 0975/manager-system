package com.itheima.edu.manager.service;

import com.itheima.edu.manager.dao.TeacherDao;
import com.itheima.edu.manager.domain.Teacher;

public class TeacherService {
   private TeacherDao teacherDao = new TeacherDao();
    public boolean addTeacher(Teacher t) {
       return teacherDao.addTeacher(t);
    }

    public boolean isExists(String id) {
        //1.获取对象中的数组
        Teacher[] teachers = teacherDao.findAllTeacher();
        //2.遍历数组取出每一个元素进行判断
        boolean exists = false;
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher = teachers[i];
            if (teacher != null && teacher.getId().equals(id)){
                exists = true;
                break;
            }
        }
        return exists;

    }

    public Teacher[] findAllTeacher() {
        Teacher[] allTeacher = teacherDao.findAllTeacher();
        boolean falg = false;
        for (int i = 0; i < allTeacher.length; i++) {
            Teacher teacher = allTeacher[i];
            if (teacher != null){
                falg = true;
                break;
            }
        }
        if (falg){
            return allTeacher;
        }else {
            return null;
        }
    }

    public void deleteTeacherById(String id) {
        teacherDao.deleteTeacherById(id);
    }

    public void updateTeacher(String id, Teacher newTeacher) {
        teacherDao.updateTeacher(id,newTeacher);
    }
}

package com.itheima.edu.manager.service;

import com.itheima.edu.manager.dao.StudentDao;
import com.itheima.edu.manager.domain.Student;

public class StudentService {
    //1.创建库管StudentDao对象
    private StudentDao studentDao = new StudentDao();
    public boolean addStudent(Student stu) {

//        StudentDao studentDao = new StudentDao();
            //2.将学生对象传入StudentDao中的addStudent方法
            //3.将返回的boolean类型结果返回
           return studentDao.addStudent(stu);

    }

    public boolean isExists(String id) {
       Student[] stus = studentDao.findAllStudent();
       //假设id在数组中不存在
       boolean exists = false;
       //遍历数组，获取每一个学生对象进行判断
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if (student != null && student.getId().equals(id)){
                exists = true;
                break;
            }
        }

        return exists;
    }

    public Student[] findAllStudent() {
        //1.调用库管对象的finAllStudent获取学生对象数组
        Student[] stus = studentDao.findAllStudent();
        //2.判断数组中是否有学生信息（有返回地址，没有返回null）
        //数组中只要存在一个不是null的元素就代表有学生信息
        boolean flag = false;
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if (student != null){
                flag = true;
                break;
            }
        }
        if (flag){
            //有信息
            return stus;
        }else {
            return null;
        }

    }

    public void deleteStudentByld(String delid) {
        studentDao.deleteStudentByld(delid);
    }

    public void updateStudent(String updated, Student newStu) {
        studentDao.updateStudent(updated,newStu);
    }
}

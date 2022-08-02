package com.itheima.edu.manager.dao;

import com.itheima.edu.manager.domain.Student;

import java.util.Arrays;

public class StudentDao {
    //1.创建学生对象数组
    private static Student[] stus = new Student[5];

    public boolean addStudent(Student stu) {

        //2.添加学生到数组
        //2.1定义变量int index = -1；假设内存已经全部存满，没有null值
        int index = -1;
        //2.2遍历数组取出每一个元素，判断元素是不是null
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            //2.3如果是null，让index记下该位置的索引位置，并用break；结束循环
            if (student == null){
                index = i;
                break;
            }
        }

        //3.返回是否添加成功的布尔类型状态
        if (index == -1){
            //装满了
            return false;
        }else{
            //没有装满，正常添加，返回true
            stus[index] = stu;
            return true;
        }



    }

    public Student[] findAllStudent() {
        return stus;
    }

    public void deleteStudentByld(String delid) {
        //1.查找id在容器中所在的容器位置
        int index = getIndex(delid);
        //2.将该索引位置，使用null元素进行覆盖
        stus[index] = null;


    }
    public int getIndex(String id){
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            Student stu = StudentDao.stus[i];
            if (stu != null && stu.getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateStudent(String updated, Student newStu) {
       //1.查找update，在容器中的位置
        int index = getIndex(updated);
        //。将索引位置，使用新的学生对象进行替换
        stus[index] = newStu;

    }
}

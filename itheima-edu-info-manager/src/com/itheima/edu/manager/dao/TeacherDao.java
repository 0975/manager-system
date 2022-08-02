package com.itheima.edu.manager.dao;

import com.itheima.edu.manager.domain.Teacher;

public class TeacherDao {
    private static Teacher[] teachers = new Teacher[5];
    public boolean addTeacher(Teacher t) {
        int index = -1;
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher = teachers[i];
            if (teacher == null){
                index = i;
                break;
            }
        }
        if (index == -1){
            return false;
        }else {
            teachers[index] = t;
            return true;
        }
    }

    public Teacher[] findAllTeacher() {
        return teachers;
    }

    public void deleteTeacherById(String id) {
        //1.查询id在数组中的索引位置
        int index = getIndex(id);
        //2.将该索引的元素使用null进行替换
        teachers[index] = null;
    }
    public int getIndex(String id){
        int index = -1;
        for (int i = 0; i < teachers.length; i++) {
            Teacher t = teachers[i];
            if (t != null && t.getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateTeacher(String id, Teacher newTeacher) {
        int index = getIndex(id);
        teachers[index] = newTeacher;
    }
}

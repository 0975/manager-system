package com.itheima.edu.manager.controller;

import com.itheima.edu.manager.domain.Student;
import com.itheima.edu.manager.domain.Teacher;
import com.itheima.edu.manager.service.TeacherService;

import java.util.Scanner;

public class TeacherController {
    private Scanner sc = new Scanner(System.in);
    private TeacherService teacherService = new TeacherService();
    public void start() {

        lo:while (true){
            System.out.println("-----------欢迎使用<老师>信息管理系统----------");
            System.out.println("菜单选项：\t\t1.添加老师\t\t2.删除老师\t\t3.修改老师\t\t4.查询老师\t\t5.退出");
            System.out.print("请输入您的选项：");
            String choice = sc.next();
            switch(choice){
                case "1":
//                    System.out.println("添加老师");
                    addTeacher();
                    break;
                case "2":
//                    System.out.println("删除老师");
                    deleteTeacherById();
                    break;
                case "3":
//                    System.out.println("修改老师");
                    updateTeacher();
                    break;
                case "4":
//                    System.out.println("查询老师");
                    findAllTeacher();
                    break;
                case "5":
                    System.out.println("退出，感谢使用老师管理系统");
                    break lo;
                default:
                    System.out.println("您的输入有误请重新输入");
            }
        }

    }

    public void updateTeacher() {
        String id = inputTeacherId();
        Teacher newTeacher = inputTeacherInfo(id);

        //调用业务员的修改方法
        teacherService.updateTeacher(id,newTeacher);

    }

    public void deleteTeacherById() {
        String id = inputTeacherId();
        teacherService.deleteTeacherById(id);
        System.out.println("删除成功");
    }

    public void findAllTeacher() {
        //1.从业务员中获取老师对象数组
        Teacher[] teachers = teacherService.findAllTeacher();
        //2.判断数组中是否有元素
        if (teachers == null){
            System.out.println("查无信息，请添加后重试");
            return;
        }
        //3.遍历数组，如果，数组有元素则打印元素 获取学生信息并打印在控制台
        System.out.println("\t\t工号\t\t姓名\t\t年龄\t\t生日");
        for (int i = 0; i < teachers.length; i++) {
            Teacher t = teachers[i];
            if (t != null){
                System.out.println("\t\t"+t.getId()+"\t"+t.getName()+"\t\t"+t.getAge()+"\t"+t.getBirthday());
            }
        }
    }

    public void addTeacher() {
        String id;
       while(true){
           //1.接收一个并不存在的老师id
           System.out.print("请输入id：");
           id = sc.next();
           //2.判断id是否存在
          boolean exists = teacherService.isExists(id);
          if (exists){
              System.out.println("id已被占用，请重新输入");
          }else {
              break;
          }

       }
        Teacher t = inputTeacherInfo(id);

        //5.将封装好的老师对象传递给teacherService继续完成添加操作
        boolean result = teacherService.addTeacher(t);
        if (result){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }



    }

    //录入老师id
    public String inputTeacherId(){
        String id;
        while (true){
            System.out.println("请输入id：");
            id = sc.next();

            boolean exists = teacherService.isExists(id);

            if(!exists){
                System.out.println("id不存在，请重新输入");
            }else {
                break;
            }
        }
        return id;
    }
    //录入老师信息并封装的方法
    public Teacher inputTeacherInfo(String id){
        //3.接收老师的其他信息
        System.out.print("请输入老师姓名");
        String name = sc.next();
        System.out.print("请输入老师年龄");
        String age = sc.next();
        System.out.print("请输入老师生日");
        String birthday = sc.next();
        Teacher t = new Teacher();

        //4.将信息封装为老师对象
        t.setId(id);
        t.setName(name);
        t.setAge(age);
        t.setBirthday(birthday);
        return t;
    }
}

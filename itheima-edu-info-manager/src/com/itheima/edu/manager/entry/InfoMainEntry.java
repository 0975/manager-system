package com.itheima.edu.manager.entry;

import com.itheima.edu.manager.controller.StudentController;
import com.itheima.edu.manager.controller.TeacherController;

import java.util.Scanner;

//程序的入口，提供一个main方法
public class InfoMainEntry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      //主菜单搭建
        while (true){
            System.out.println("-----------欢迎来到信息管理系统菜单-----------");
            System.out.println("菜单选项：\t\t1.学生管理\t\t2.老师管理\t\t3.退出");
            System.out.print("请输入您的选项：");
            String choice = sc.next();
            switch (choice){
                case "1":
//                    System.out.println("学生管理");
                    //开启学生管理系统的代码逻辑
                    StudentController studentController = new StudentController();
                    studentController.start();
                    break;
                case "2":
//                    System.out.println("教师管理");
                    TeacherController teacherController = new TeacherController();
                    teacherController.start();
                    break;
                case "3":
                    System.out.println("退出系统感谢您的使用");
                    //退出当前正在运行的JVM虚拟机
                    System.exit(0);
                default:
                    System.out.println("您的输入有误，请重新输入");

            }

        }


       /*

        System.out.println("-----------欢迎使用<老师>信息管理系统----------");
        System.out.println("菜单选项：\t\t1.添加老师\t\t2.删除老师\t\t3.修改学生\t\t4.删除老师\t\t退出");
        System.out.print("请输入您的选项：");*/
    }
}

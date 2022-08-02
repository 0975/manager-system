package com.itheima.edu.manager.controller;

import com.itheima.edu.manager.domain.Student;
import com.itheima.edu.manager.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private StudentService studentService = new StudentService();
    private Scanner sc = new Scanner(System.in);

    //开启学生管理系统，展示学生管理系统菜单
    public void start() {
//        Scanner sc = new Scanner(System.in);
       lo:while (true){
            System.out.println("-----------欢迎使用<学生>信息管理系统----------");
            System.out.println("菜单选项：\t\t1.添加学生\t\t2.删除学生\t\t3.修改学生\t\t4.删除学生\t\t退出");
            System.out.print("请输入您的选项：");
            String choice = sc.next();
            switch (choice){
                case "1":
                    System.out.println("添加学生");
                    addStudent();
                    break;
                case "2":
                    System.out.println("删除学生");
                    deleteStudentByld();
                    break;
                case "3":
//                    System.out.println("修改学生");
                    updateStudent();
                    break;
                case "4":
//                    System.out.println("4.查询学生");
                    //退出当前正在运行的JVM虚拟机
                    findAllStudent();
                    break;
                case "5":
                    System.out.println("5.退出");
                    //退出当前正在运行的JVM虚拟机
                    break lo;
                default:
                    System.out.println("您的输入有误，请重新输入");

            }
        }

    }

    public void updateStudent() {
        String updated = inputStudent();
        Student newStu = inputStudentInfo(updated);
        studentService.updateStudent(updated,newStu);
        System.out.println("修改成功");
    }

    public void deleteStudentByld() {
        String delid = inputStudent();
        //3.调用业务员中的deleteStudentByld()方法，根据id删除成功
        studentService.deleteStudentByld(delid);
        //4.提示删除成功
        System.out.println("删除成功");

    }

    public void findAllStudent() {
        //1.调用业务员中的获取方法得到学生数组
       Student[] stus = studentService.findAllStudent();
        //2.判断数组的内存地址是否为null
        if (stus == null){
            System.out.println("查无信息，请添加后重试");
            return;
        }
        //3.遍历数组，获取学生信息并打印在控制台
        System.out.println("\t\t学号\t\t姓名\t\t年龄\t\t生日");
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu != null){
                System.out.println("\t\t"+stu.getId()+"\t"+stu.getName()+"\t\t"+stu.getAge()+"\t"+stu.getBirthday());
            }
        }
    }

    public void addStudent() {
//  StudentService studentService = new StudentService();
        //1.键盘接收学生信息
        String id;
        while (true){
            System.out.print("请输入id：");
            id = sc.next();
            boolean flag = studentService.isExists(id);
            if (false){
                System.out.println("学号已被占用，请重新输入");
            }else {
                break;
            }


        }
        Student stu = inputStudentInfo(id);
        //3.把学生类传给StudentService中的addStudent方法

        boolean result = studentService.addStudent(stu);
        if (result){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }







    }

    //键盘录入学生id
    public String inputStudent(){
        String id;
        while (true){
            System.out.print("请输入学生的id");
            //1.键盘录入要输入的学生id
            id = sc.next();
            //2.判断id在容器中是否存在
            boolean exists = studentService.isExists(id);
            if (!exists){
                System.out.println("您输入的id不存在请重新输入");
            }else {
                break;
            }
        }
        return id;
    }

    //键盘录入学生信息
    public Student inputStudentInfo(String id){

        System.out.print("请输入姓名:");
        String name = sc.next();
        System.out.print("请输入年龄:");
        String age = sc.next();
        System.out.print("请输入生日:");
        String birthday = sc.next();
        //2.将学生信息，封装为学生类对象
        Student stu = new Student();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setBirthday(birthday);
        return stu;
    }
}
    
package com.lyc.study;

import java.util.ArrayList;
import java.util.List;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/6/17
 * @time: 11:01
 * @desc:
 */
public class CaseTest {

    public static void main(String[] args) {
       final List<Student> sourceList = new ArrayList<>();

       List<Student> threadResult = new ArrayList<>();

        Student student1 = new Student("张三", 25);
//        sourceList.add(student1);

        sourceList.addAll(threadResult);

        for (Student student : sourceList) {
            if ("张三".equals(student.getName())){
                System.out.println(student);
            }
        }
    }

    static class Student {

        private String name;

        private int age;

        public Student(){}

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}

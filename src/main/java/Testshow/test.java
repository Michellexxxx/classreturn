package Testshow;


import org.junit.Test;

import java.lang.reflect.*;

public class test {

    @Test
    public  void  test02(){
        try {
            Class c=Class.forName("Testshow.Student");
            System.out.println("Student所在包名"+c.getPackage().getName());
            System.out.println("Student全类名"+c.getName());
            System.out.println("Student简写类名"+c.getSimpleName());
            int num=c.getModifiers();
            System.out.println("public访问修饰符对应的数字"+num);
            System.out.println(Modifier.toString(num));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public  void test01(){
        try {
            System.out.println(Class.forName("Testshow.Student"));
            System.out.println(Student.class.getName());
            System.out.println(new Student().getClass().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public  void test04(){
        Class c= null;
        try {
            c = Class.forName("Testshow.Student");
            Method [] methods=c.getDeclaredMethods();
           for(int i=0;i<methods.length;i++){
               System.out.println("方法的名字"+methods[i].getName());
               System.out.println("方法的修饰符数值"+methods[i].getModifiers());
               System.out.println("方法的修饰符"+Modifier.toString(methods[i].getModifiers()));

               System.out.println("方法的返回值类型"+methods[i].getReturnType());
           }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    @Test
    public  void test05(){
        try {
            Class  c = Class.forName("Testshow.Student");
            Constructor[] constructors=c.getDeclaredConstructors();
            for(int i=0;i<constructors.length;i++){
                System.out.println("构造方法的名字"+constructors[i].getName());
                System.out.println("构造方法的修饰符数值"+constructors[i].getModifiers());
                System.out.println("构造方法的修饰符"+Modifier.toString(constructors[i].getModifiers()));

                System.out.println("构造方法的参数个数"+constructors[i].getParameterCount());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void test06(){
        try {
            Class c=Class.forName("Testshow.Student");
            try {
                Student student=(Student)c.newInstance();
                Field field=c.getDeclaredField("userName");
                String name=field.getName();
                System.out.println("字段的名称："+name);
                field.setAccessible(true);
                System.out.println("字段的值"+field.get(student));
                Method method=c.getDeclaredMethod("song");
                method.setAccessible(true);
                double retult=(Double)method.invoke(student);
                System.out.println(retult);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
            } catch (NoSuchMethodException e) {
                    e.printStackTrace();

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public  void test03(){
        try {
            Class c=Class.forName("Testshow.Student");
            Field[] fields=c.getDeclaredFields();
            for (int i=0;i<fields.length;i++){
                System.out.println(fields[i]);
            }
            for (int i=0;i<fields.length;i++){
                System.out.println(Modifier.toString(fields[i].getModifiers()));
                System.out.println(fields[i].getModifiers());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

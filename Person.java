package javaVvod.lesson5;


public class Person {
    private String fname;
    private String mname;
    private String lname;
    private String post;
    private String email;
    private String phone;
    private int pay;
    private int age;

    public Person(String fname, String mname, String lname, String post, String email, String phone, int pay, int age) {
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.pay = pay;
        this.age = age;
    }

    public void toConsol() {
        System.out.println("ФИО: " + fname + " " + mname + " " + lname + "\nДолжность: " + post + "\nПочта: " + email + "\nТелефон: " + phone + "\nЗарплата: " + pay + "\nВозраст: " + age);

    }

    public boolean age(int age) {
        if(this.age >= age){
            return true;
        }
        return false;

    }
}

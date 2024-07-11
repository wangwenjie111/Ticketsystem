package org.example;//Extended by Xingcai Zhang 34355979

import java.util.regex.Pattern;

class Person //abstract class Person
{
    private String firstName;
    private String secondName;
    private int age;
    private String gender;

    public Person(){}

    public Person(String firstName, String secondName, int age, String gender){
        this.age=age;
        this.firstName=firstName;
        this.secondName=secondName;
        this.gender=gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {//年龄要大于0 extend code
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public String getGender() {

        return gender;
    }

    public void setGender(String gender) {//防止输入无效性别 extend code
        if (!isValidGender(gender)) {
            throw new IllegalArgumentException("Invalid gender");
        }
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {//名字和姓氏不应以数字或符号开头，只能包含大小写字母。 extend code
        if (!isValidName(firstName)) {
            throw new IllegalArgumentException("First name must start with a letter and contain only letters");
        }
        this.firstName = firstName;
    }
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {//名字和姓氏不应以数字或符号开头，只能包含大小写字母。extend code
        if (!isValidName(secondName)) {
            throw new IllegalArgumentException("Second name must start with a letter and contain only letters");
        }
        this.secondName = secondName;
    }

    private boolean isValidGender(String gender) {//判断性别 extend code
        return gender.equals("Woman") || gender.equals("Man") || gender.equals("Non-binary | gender diverse") || gender.equals("Prefer not to say") || gender.equals("Other");
    }

    private boolean isValidName(String name) {//判断姓氏名字是否正确 extend code
        return Pattern.matches("^[a-zA-Z][a-zA-Z]*$", name);
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}

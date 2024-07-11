package org.example;//extended bu XingcaiZhang 34355979

import java.util.regex.Pattern;

public class Passenger extends Person
{
    private String email;
    private String phoneNumber;
    private String cardNumber;
    private int securityCode;
    private String passport;

    public Passenger(){}

    public Passenger(String firstName, String secondName, int age, String gender,String email, String phoneNumber, String passport, String cardNumber,int securityCode)
    {
        super(firstName, secondName, age, gender);//extend code
        this.securityCode=securityCode;
        this.cardNumber=cardNumber;
        this.passport=passport;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!isValidEmail(email)) {//判断邮箱是否有效
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    public String getFirstName() {
        return super.getFirstName();
    }

    public String getSecondName() {
        return super.getSecondName();
    }

    public void setSecondName(String secondName) {
        super.setSecondName(secondName);
    }

    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    public String getPassport() {
        return passport;
    }

    public void setGender(String gender) {
        super.setGender(gender);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {//判断电话号码是否正确
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
        this.phoneNumber = phoneNumber;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        if (!isValidSecurityCode(securityCode)) {
            throw new IllegalArgumentException("Invalid security code");
        }
        this.securityCode = securityCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        if (!isValidCardNumber(cardNumber)) {
            throw new IllegalArgumentException("Invalid card number format");
        }
        this.cardNumber = cardNumber;
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    public void setPassport(String passport) {//判断护照长度
        if (passport.length() > 9) {//判断护照是否合法
            throw new IllegalArgumentException("Passport number cannot be longer than 9 characters");
        }
        this.passport = passport;
    }

    private boolean isValidEmail(String email) {//判断电子邮件遵循有效的模式“abc@domain.com”
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private boolean isValidPhoneNumber(String phoneNumber) {//判断电话号码格式
        String phoneRegex = "^((\\+61-?)|0)?4\\d{8}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        return pattern.matcher(phoneNumber).matches();
    }

    private boolean isValidCardNumber(String cardNumber) {// 验证卡号为16位数字

        return Pattern.matches("\\d{16}", cardNumber);
    }

    private boolean isValidSecurityCode(int securityCode) {// 验证安全码为6位数字

        return Pattern.matches("\\d{6}", String.valueOf(securityCode));
    }

    @Override
    public String getGender() {
        return super.getGender();
    }


    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public String toString()
    {
        return "Passenger{" + " Fullname= "+ super.getFirstName()+" "+super.getSecondName()+
                " ,email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passport='" + passport +
                '}';
    }
}

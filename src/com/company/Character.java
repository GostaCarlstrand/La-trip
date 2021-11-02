package com.company;

public class Character {
    String name;
    private int age;
    private int walletBalance;

    public void setAge(int age){
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public int getWalletBalance() {
        return walletBalance;
    }
    public void initWalletBalance(int sum){
        this.walletBalance = sum;
    }
    public boolean checkCharacterHasMoney(int sum) {
        return walletBalance >= sum;
    }
    public void reduceWalletBalance(int sum) {
        walletBalance = walletBalance - sum;
    }
    public void increaseWalletBalance(int sum){
        walletBalance += sum;
    }
    public boolean checkAge(int age) {
        int minAgeToEnter = 21;
        return !(age < minAgeToEnter);
    }
}



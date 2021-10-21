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


    public boolean checkCharacterHasMoney(int currentWalletBalance, int sum) {
        if (currentWalletBalance >= sum) {
            return true;
        }
        return false;
    }

    public int reduceWalletBalance(int sum) {
        walletBalance = walletBalance - sum;
        return walletBalance;
    }

    public int increaseWalletBalance(int sum){
        walletBalance += sum;
        return walletBalance;
    }

    public boolean checkAge(int age) {
        int minAgeToEnter = 21;
        if (age < minAgeToEnter) {
            return false;
        } else {
            return true;
        }
    }
}



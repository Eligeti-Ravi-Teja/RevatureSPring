package org.example.dao;

import org.springframework.stereotype.Component;

@Component
public class AtmDao {
    private int balanace;

    public int getBalanace() {
        return balanace;
    }

    public void setBalanace(int balanace) {
        this.balanace = balanace;
    }

    public String loginSuccess(int pin){
        if(pin==2002){
            return "Entered pin succcessfull";
        }
        return "Incorrect pin";
    }

    public int checkBalanace(){
        return balanace;
    }

    public int addMoney(int money){
        balanace+=money;
        return balanace;
    }

    public int removeMoney(int money){
        if(money<=balanace) {
            balanace -= money;
            return balanace;
        }
        return -1;
    }
}

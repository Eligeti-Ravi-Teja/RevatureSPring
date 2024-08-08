package org.example.service;

import org.example.dao.AtmDao;
import org.example.event.AtmEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AtmService {
    private AtmDao atmDao;
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @Autowired
    public AtmService(AtmDao dao){
        this.atmDao=dao;
    }

    public AtmDao getAtmDao() {

        return atmDao;
    }

    public void setAtmDao(AtmDao atmDao) {
        this.atmDao = atmDao;
    }

    public void showBalanace(){
        System.out.println("Your balance: "+atmDao.getBalanace());
    }

    public void addMoney(int money){
        eventPublisher.publishEvent(new AtmEvent("Your account has been credited with 200 rupees"));
        System.out.println("Updated balanace: "+atmDao.addMoney(money));
    }

    public void withdraw(int money){
        int val= atmDao.removeMoney(money);
        if(val==-1){
            eventPublisher.publishEvent(new AtmEvent("can't debit amount"));
            System.out.println("you withdraw money is more than you balanace");
        }
        else{
            eventPublisher.publishEvent(new AtmEvent("40 rupees debited from account"));
            System.out.println("Withdraw successfull! new balanace: "+val);
        }
    }
}

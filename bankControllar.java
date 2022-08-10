package com.example.springbootday;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public class bankControllar {
    ArrayList<Customer> c=new ArrayList<>();



    @GetMapping("/customer")
    public ArrayList getCustomer(){

        return c;
    }


    @PostMapping("/customer")
    public customermessage addUser(@RequestBody Customer customer){
        c.add(customer);
        return new customermessage("New Name added to the list") ;
    }


    @PutMapping("/customer/{index}")
    public customermessage updateUser(@PathVariable int index, @RequestBody Customer customer){
        c.set(index,customer);
        return new customermessage("list updated");
    }



    @DeleteMapping("/customer/{index}")
    public customermessage deleteuser(@PathVariable int index){
        c.remove(index);
        return new customermessage ("name deleted from the list");
    }
    @PostMapping("/custmer/deposit")
    public customermessage deposit(@RequestBody bank b){
        for (int i = 0; i < c.size(); i++) {
            if(c.get(i).getID()==b.getId()) {
                int oldbalance = c.get(i).getBalance();
                c.get(i).setBalance(oldbalance + b.getBalance());
                return new customermessage("deposit ok");
            }

            }
              return new customermessage("wrong id");

        }
    @PostMapping("/custmer/deposit")
    public customermessage withdraw(@RequestBody bank b){
        for (int i = 0; i < c.size(); i++) {
            if(c.get(i).getID()==b.getId()) {
                int oldbalance = c.get(i).getBalance();
                c.get(i).setBalance(oldbalance - b.getBalance());
                return new customermessage("deposit ok");
            }

        }
        return new customermessage("wrong id");

    }
    }



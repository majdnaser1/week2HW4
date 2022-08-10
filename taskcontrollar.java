package com.example.springbootday;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
public class taskcontrollar {
        ArrayList<Task> tasklist=new ArrayList<>();



        @GetMapping("/task")
        public ArrayList getCustomer(){

            return tasklist;
        }


        @PostMapping("/task")
        public customermessage addUser(@RequestBody Task t){
            tasklist.add(t);
            return new customermessage("New Name added to the list") ;
        }


        @PutMapping("/customer/{index}")
        public customermessage updateUser(@PathVariable int index, @RequestBody Task t){
            tasklist.set(index,t);
            return new customermessage("list updated");
        }



        @DeleteMapping("/customer/{index}")
        public customermessage deleteuser(@PathVariable int index){
            tasklist.remove(index);
            return new customermessage ("name deleted from the list");
        }

        @PostMapping("/custmer/status")
        public customermessage withdraw(@RequestBody ta t){
            for (int i = 0; i < tasklist.size(); i++) {
                if (tasklist.get(i).getId() == t.getId()) {
                    if (tasklist.get(i).isStatus()) {
                        return new customermessage("done");
                    } else {
                        return new customermessage("not done");
                    }

                }

            }
            return new customermessage("wrong id");


        }
    }






package com.rev.TaskManagement.controllerv2;

import com.rev.TaskManagement.model.Task;
import com.rev.TaskManagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebSocketController {
    @Autowired
    TaskService taskService;
    @GetMapping("/home")
    public String getHome(){
        return "update";
    }

    @MessageMapping("/send")
    @SendTo("/topic/updates")
    public String sendMessase(String message){
        return message;
    }


}

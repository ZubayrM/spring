package Main.Controllers.Controller;

import Main.Controllers.Model.Message;
import Main.Controllers.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class DefaultController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/")
    public String index( Map<String,Object> model){

        return "index";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String  text, @RequestParam String tag, Map<String,Object> model){
        Message message = new Message(text, tag);
        messageRepository.save(message);

        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String,Object> model){
        Iterable<Message> messages;

        if (!filter.equals(""))
        messages = messageRepository.findByTag(filter);
        else messages = messageRepository.findAll();



        model.put("messages",messages);
        return "main";
    }







}
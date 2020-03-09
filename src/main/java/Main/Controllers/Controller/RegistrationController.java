package Main.Controllers.Controller;
import Main.Controllers.Model.Role;
import Main.Controllers.Model.User;
import Main.Controllers.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;


@Controller
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String,Object> model){

        User byUsername = userRepository.findByLogin(user.getLogin());

        if (byUsername != null) {
            model.put("message", "user exists!");
            return "registration";
        }

        user.setAction(true);
        user.setRoles(Collections.singleton(Role.USER));

        userRepository.save(user);

        return "redirect:/login";
    }

}

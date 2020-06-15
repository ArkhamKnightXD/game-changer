package arkham.knight.gamestop.controllers;
import arkham.knight.gamestop.models.User;
import arkham.knight.gamestop.services.FileUploadService;
import arkham.knight.gamestop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FileUploadService fileUploadService;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/bootstrap-4.3.1/assets/img";


    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("users", userService.listAllUsers());

        return "/freemarker/users";
    }


    @RequestMapping("/creation")
    public String creationPage(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("roles", userService.listAllRoles());

        return "/freemarker/createUser";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, @RequestParam(name = "image") MultipartFile[] image, @RequestParam(name = "idRoles") List<Long> idRoles){

        String imageName = fileUploadService.storeAndCleanImage(image,uploadDirectory);

        User userToCreate = new User(username,bCryptPasswordEncoder.encode(password),true,imageName, userService.findAllRolesById(idRoles));

        userService.createUser(userToCreate);

        return "redirect:/users/";
    }


    @RequestMapping("/edition")
    public String editionPage(Model model, @RequestParam(name = "id") Long id){

        User userToCreate = userService.findUserById(id);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("user", userToCreate);
        model.addAttribute("roles", userService.listAllRoles());

        return "/freemarker/editUser";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam(name = "id") Long id, @RequestParam(name = "username") String username, @RequestParam(name = "password") String password, @RequestParam(required = false, name = "image") MultipartFile[] image, @RequestParam(name = "idRoles") List<Long> idRoles){

        String imageName = fileUploadService.storeAndCleanImage(image,uploadDirectory);

        User userToEdit = userService.findUserById(id);

        userToEdit.setUsername(username);
        userToEdit.setPassword(bCryptPasswordEncoder.encode(password));
        userToEdit.setAdmin(true);
        userToEdit.setRolList(userService.findAllRolesById(idRoles));

        if (imageName.endsWith("jpg")){

            userToEdit.setImage(imageName);
        }

        userService.createUser(userToEdit);

        return "redirect:/users/";
    }


    @RequestMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id){

        userService.deleteUser(id);

        return "redirect:/users/";
    }
}

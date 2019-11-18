package arkham.knight.gamestop.controllers;
import arkham.knight.gamestop.models.User;
import arkham.knight.gamestop.services.FileUploadServices;
import arkham.knight.gamestop.services.UserServices;
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
    private UserServices userServices;

    @Autowired
    private FileUploadServices fileUploadServices;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/bootstrap-4.3.1/assets/img";


    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("users",userServices.listAllUsers());


        return "/freemarker/users";
    }


    @RequestMapping("/creation")
    public String creationPage(Model model){

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("roles", userServices.listAllRoles());

        return "/freemarker/createUser";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, @RequestParam(name = "image") MultipartFile[] image, @RequestParam(name = "idRoles") List<Long> idRoles){

        String imageName = fileUploadServices.almacenarAndDepurarImagen(image,uploadDirectory);

        User userToCreate = new User(username,bCryptPasswordEncoder.encode(password),false,imageName,userServices.findAllRolesById(idRoles));

        userServices.createUser(userToCreate);

        return "redirect:/users/";
    }


    @RequestMapping("/edition")
    public String editionPage(Model model, @RequestParam(name = "id") Long id){

        User userToCreate = userServices.findUserById(id);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("user", userToCreate);
        model.addAttribute("roles", userServices.listAllRoles());

        return "/freemarker/editUser";
    }


    @RequestMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id, @RequestParam(name = "username") String username, @RequestParam(name = "password") String password, @RequestParam(required = false, name = "image") MultipartFile[] image, @RequestParam(name = "idRoles") List<Long> idRoles){

        String imageName = fileUploadServices.almacenarAndDepurarImagen(image,uploadDirectory);

        User userToEdit = userServices.findUserById(id);

        userToEdit.setUsername(username);
        userToEdit.setPassword(bCryptPasswordEncoder.encode(password));
        userToEdit.setAdmin(true);
        userToEdit.setRolList(userServices.findAllRolesById(idRoles));

        if (imageName.endsWith("jpg")){

            userToEdit.setImage(imageName);
        }

        userServices.createUser(userToEdit);

        return "redirect:/users/";
    }


    @RequestMapping("/show")
    public String showPage(Model model, @RequestParam(name = "id") Long id){

        User userToShow = userServices.findUserById(id);

        model.addAttribute("title","Welcome to the game store");
        model.addAttribute("user",userToShow);

        return "/freemarker/showUser";
    }


    @RequestMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id){

        User userToDelete = userServices.findUserById(id);

        userServices.deleteUser(userToDelete);

        return "redirect:/users/";
    }
}

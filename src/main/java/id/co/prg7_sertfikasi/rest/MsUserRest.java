package id.co.prg7_sertfikasi.rest;

import id.co.prg7_sertfikasi.model.MsUser;
import id.co.prg7_sertfikasi.response.DtoResponse;
import id.co.prg7_sertfikasi.service.MsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/msusers")
public class MsUserRest {

    @Autowired
    private MsUserService msUserService;

    @GetMapping("/getUsers")
    public DtoResponse getUsers() {
        return msUserService.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public DtoResponse getUserById(@PathVariable int id) {
        return msUserService.getUserById(id);
    }

    @GetMapping("/getByUsername")
    public DtoResponse getByUsername(@RequestParam String username) {
        return msUserService.getUserByUsername(username);
    }

    @PostMapping("/saveUser")
    public DtoResponse saveUser(@RequestBody MsUser user) {
        return msUserService.saveUser(user);
    }

    @PostMapping("/updateUser")
    public DtoResponse updateUser(@RequestBody MsUser user) {
        return msUserService.updateUser(user);
    }

    @PostMapping("/deleteUser")
    public DtoResponse deleteUser(@RequestBody MsUser user) {
        return msUserService.deleteUser(user);
    }
}

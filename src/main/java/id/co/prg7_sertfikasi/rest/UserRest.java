package id.co.prg7_sertfikasi.rest;

import id.co.prg7_sertfikasi.constant.UserConstant;
import id.co.prg7_sertfikasi.model.User;
import id.co.prg7_sertfikasi.service.UserService;
import id.co.prg7_sertfikasi.vo.UserVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRest {

    private final UserService userService;

    public UserRest(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<UserVo>> getUsers() {
        List<UserVo> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        // validasi username dan email
        for (UserVo u : userService.getUsers()) {
            if (u.getUsername().equals(user.getUsername()) || u.getEmail().equals(user.getEmail())) {
                return new ResponseEntity<>(UserConstant.mAlreadyRegistered, HttpStatus.CONFLICT);
            }
        }
        userService.saveUser(user);
        return new ResponseEntity<>(UserConstant.mCreateSuccess, HttpStatus.CREATED);
    }

    @GetMapping("/getByUsername")
    public ResponseEntity<UserVo> getByUsername(@RequestParam String username) {
        UserVo user = userService.getUserByUsername(username);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserVo> getUserById(@PathVariable int id) {
        UserVo user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        UserVo existingUser = userService.getUserById(id);
        if (existingUser != null) {
            updatedUser.setId(id);
            userService.updateUser(updatedUser);
            return new ResponseEntity<>(UserConstant.mUpdateSuccess, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(UserConstant.mNotFound, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        UserVo existingUser = userService.getUserById(id);
        if (existingUser != null) {
            userService.deleteUser(id);
            return new ResponseEntity<>(UserConstant.mDeleteSuccess, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(UserConstant.mNotFound, HttpStatus.NOT_FOUND);
        }
    }
}

package study.rj.rest.webservices.restfulwebservices.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import study.rj.rest.webservices.restfulwebservices.user.exception.UserNotFoundException;
import study.rj.rest.webservices.restfulwebservices.user.model.User;
import study.rj.rest.webservices.restfulwebservices.user.service.UserDaoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    UserDaoService userDaoService;

    @GetMapping
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userDaoService.save(user);

        // /users/{id}
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public User retrieveUser(@PathVariable(name = "id") int id) {
        User user = userDaoService.findOne(id);

        if (user == null)
            throw new UserNotFoundException("id-" + id);

        return user;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(name = "id") int id) {
        User deletedUser = userDaoService.deleteById(id);

        if (deletedUser == null)
            throw new UserNotFoundException("id-" + id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/posts")
    public void getAllUserPosts(@PathVariable(name = "id") String id) {

    }

    @PostMapping("/{id}/posts")
    public void createUserPost(@PathVariable(name = "id") String id) {

    }

    @GetMapping("/{id}/posts/{post_id}")
    public void getSpecificPostById(@PathVariable(name = "id") String id,
                                    @PathVariable(name = "post_id") String postId) {

    }
}

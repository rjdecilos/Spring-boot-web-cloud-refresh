package study.rj.rest.webservices.restfulwebservices.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import study.rj.rest.webservices.restfulwebservices.user.entity.Post;
import study.rj.rest.webservices.restfulwebservices.user.exception.UserNotFoundException;
import study.rj.rest.webservices.restfulwebservices.user.entity.User;
import study.rj.rest.webservices.restfulwebservices.user.repository.PostRepository;
import study.rj.rest.webservices.restfulwebservices.user.repository.UserRepository;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users/jpa")
public class UserJpaRestController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    @GetMapping
    public List<User> retrieveAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);

        // /users/{id}
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public EntityModel<User> retrieveUser(@PathVariable(name = "id") int id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty())
            throw new UserNotFoundException("id-" + id);

        // HATEOAS
        EntityModel<User> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(linkTo.withRel("all-users"));

        return entityModel;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(name = "id") int id) {
        userRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/posts")
    public List<Post> getAllUserPosts(@PathVariable(name = "id") int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("id-" + id);

        return user.get().getPosts();

    }

    @PostMapping("/{id}/posts")
    public ResponseEntity<Object> createUserPost(@PathVariable(name = "id") int id, @RequestBody Post post) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty())
            throw new UserNotFoundException("id-" + id);

        User user = userOptional.get();

        post.setUser(user);

        postRepository.save(post);


        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}/posts/{post_id}")
    public void getSpecificPostById(@PathVariable(name = "id") String id,
                                    @PathVariable(name = "post_id") String postId) {

    }
}

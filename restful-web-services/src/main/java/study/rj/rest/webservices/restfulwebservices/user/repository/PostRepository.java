package study.rj.rest.webservices.restfulwebservices.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import study.rj.rest.webservices.restfulwebservices.user.entity.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
}

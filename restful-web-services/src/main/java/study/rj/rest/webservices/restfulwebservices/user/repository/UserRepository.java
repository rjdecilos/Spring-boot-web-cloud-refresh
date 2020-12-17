package study.rj.rest.webservices.restfulwebservices.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import study.rj.rest.webservices.restfulwebservices.user.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}

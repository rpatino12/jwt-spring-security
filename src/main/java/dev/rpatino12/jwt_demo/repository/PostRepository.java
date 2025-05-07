package dev.rpatino12.jwt_demo.repository;

import dev.rpatino12.jwt_demo.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}

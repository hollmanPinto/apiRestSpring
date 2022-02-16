package com.restfull.restFull_API.repository;
import com.restfull.restFull_API.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    public abstract ArrayList<UserModel> findByUsername(String username);
}

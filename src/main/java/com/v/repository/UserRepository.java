package com.v.repository;


        import com.v.domain.AppUser;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<AppUser,Long>{
}
package org.sopt.diary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
    //email을 기반으로 유저 entity를 찾아서 반환함!
    Optional<UserEntity> findByEmail(String email);
}

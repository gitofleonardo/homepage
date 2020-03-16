package cn.huangchengxi.homepage.repository;

import cn.huangchengxi.homepage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface UserRepository extends JpaRepository<User, String> {
  User findByUsername(String paramString);
}


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\repository\UserRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
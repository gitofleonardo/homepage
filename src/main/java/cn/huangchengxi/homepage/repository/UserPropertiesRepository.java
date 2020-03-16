package cn.huangchengxi.homepage.repository;

import cn.huangchengxi.homepage.entity.User;
import cn.huangchengxi.homepage.entity.UserProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPropertiesRepository extends JpaRepository<UserProperties, Long> {
  UserProperties findByUser(User paramUser);
}


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\repository\UserPropertiesRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package cn.huangchengxi.homepage.repository;

import cn.huangchengxi.homepage.entity.ValidateCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeRepository extends JpaRepository<ValidateCode, String> {
  ValidateCode findByCode(String paramString);
}


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\repository\CodeRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
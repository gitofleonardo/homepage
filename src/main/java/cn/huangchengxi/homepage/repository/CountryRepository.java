package cn.huangchengxi.homepage.repository;

import cn.huangchengxi.homepage.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface CountryRepository extends JpaRepository<Country, Long> {}


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\repository\CountryRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
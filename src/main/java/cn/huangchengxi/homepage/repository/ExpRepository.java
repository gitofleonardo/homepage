package cn.huangchengxi.homepage.repository;

import cn.huangchengxi.homepage.entity.SharedExperience;
import cn.huangchengxi.homepage.entity.SharedExperienceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RestResource
public interface ExpRepository extends JpaRepository<SharedExperience, Long> {
    List<SharedExperience> findAllBySharedExperienceType(SharedExperienceType type);
}


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\repository\ExpRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
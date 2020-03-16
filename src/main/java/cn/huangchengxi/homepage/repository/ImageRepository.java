package cn.huangchengxi.homepage.repository;

import cn.huangchengxi.homepage.entity.Image;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@RestResource
@PreAuthorize("hasAuthority('role_admin')")
public interface ImageRepository extends JpaRepository<Image, Long> {
  List<Image> findByTimeLessThanOrderByTimeDesc(Long paramLong);
  
  @RestResource(exported = false)
  void delete(Image paramImage);
  
  @RestResource(exported = false)
  void deleteAll();
  
  @RestResource(exported = false)
  void deleteAll(Iterable<? extends Image> paramIterable);
  
  @RestResource(exported = false)
  void deleteAllInBatch();
  
  @RestResource(exported = false)
  void deleteById(Long paramLong);
  
  @RestResource(exported = false)
  void deleteInBatch(Iterable<Image> paramIterable);
}


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\repository\ImageRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
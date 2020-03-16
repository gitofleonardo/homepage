package cn.huangchengxi.homepage.repository;

import cn.huangchengxi.homepage.entity.RecommendedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@RestResource
public interface RecommendedBookRepository extends JpaRepository<RecommendedBook, Long> {
  @PreAuthorize("hasRole('role_admin')")
  void delete(RecommendedBook paramRecommendedBook);
}


/* Location:              C:\Users\xixih\Desktop\BOOT-INF\classes\!\cn\huangchengxi\homepage\repository\RecommendedBookRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
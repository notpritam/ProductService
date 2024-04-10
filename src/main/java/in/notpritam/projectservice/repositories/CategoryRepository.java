package in.notpritam.projectservice.repositories;

import in.notpritam.projectservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Override
    Category save(Category category);
}

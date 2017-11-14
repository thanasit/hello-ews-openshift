package th.or.pao.revenueonline.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.or.pao.revenueonline.model.Tax;

@Repository
public interface TaxRepository extends JpaRepository<Tax, Long> {
    Tax findById(Long id);

}
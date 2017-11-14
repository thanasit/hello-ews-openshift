package th.or.pao.revenueonline.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.or.pao.revenueonline.model.TaxDetail;

@Repository
public interface TaxDetailRepository extends JpaRepository<TaxDetail, Long> {
    TaxDetail findById(Long id);

}
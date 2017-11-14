package th.or.pao.revenueonline.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.or.pao.revenueonline.model.base.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByName(String name);

}
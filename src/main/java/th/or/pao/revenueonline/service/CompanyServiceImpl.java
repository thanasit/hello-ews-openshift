package th.or.pao.revenueonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import th.or.pao.revenueonline.model.base.Company;
import th.or.pao.revenueonline.repo.CompanyRepository;

import java.util.List;

@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository repository;

    public Company findById(Long id) {
        return repository.findOne(id);
    }

    public Company findByName(String name) {
        return repository.findByName(name);
    }

    public void save(Company company) {
        repository.save(company);
    }

    public void update(Company company) {
        save(company);
    }

    public void deleteById(Long id) {
        repository.delete(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public List<Company> findAll() {
        return repository.findAll();
    }

    public boolean isExist(Company company) {
        return findByName(company.getName()) != null;
    }

}
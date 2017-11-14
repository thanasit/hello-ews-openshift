package th.or.pao.revenueonline.service;

import th.or.pao.revenueonline.model.base.Company;

import java.util.List;

public interface CompanyService {

    Company findById(Long id);

    Company findByName(String name);

    void save(Company company);

    void update(Company company);

    void deleteById(Long id);

    void deleteAll();

    List<Company> findAll();

    boolean isExist(Company company);
}
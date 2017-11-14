package th.or.pao.revenueonline.service;

import th.or.pao.revenueonline.model.Tax;

import java.util.List;

public interface TaxService {

    Tax findById(Long id);

    void save(Tax tax);

    void update(Tax tax);

    void deleteById(Long id);

    void deleteAll();

    List<Tax> findAll();

    boolean isExist(Tax tax);
}
package th.or.pao.revenueonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import th.or.pao.revenueonline.model.Tax;
import th.or.pao.revenueonline.repo.TaxRepository;

import java.util.List;

@Service("taxService")
@Transactional
public class TaxServiceImpl implements TaxService {

    @Autowired
    private TaxRepository repository;

    public Tax findById(Long id) {
        return repository.findOne(id);
    }

    public void save(Tax tax) {
        repository.save(tax);
    }

    public void update(Tax tax) {
        save(tax);
    }

    public void deleteById(Long id) {
        repository.delete(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public List<Tax> findAll() {
        return repository.findAll();
    }

    public boolean isExist(Tax tax) {
        return findById(tax.getId()) != null;
    }

}
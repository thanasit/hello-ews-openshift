package th.or.pao.revenueonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import th.or.pao.revenueonline.model.TaxDetail;
import th.or.pao.revenueonline.repo.TaxDetailRepository;

import java.util.List;

@Service("taxService")
@Transactional
public class TaxDetailServiceImpl implements TaxDetailService {

    @Autowired
    private TaxDetailRepository repository;

    public TaxDetail findById(Long id) {
        return repository.findOne(id);
    }

    public void save(TaxDetail taxDetail) {
        repository.save(taxDetail);
    }

    public void update(TaxDetail taxDetail) {
        save(taxDetail);
    }

    public void deleteById(Long id) {
        repository.delete(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public List<TaxDetail> findAll() {
        return repository.findAll();
    }

    public boolean isExist(TaxDetail taxDetail) {
        return findById(taxDetail.getId()) != null;
    }

}
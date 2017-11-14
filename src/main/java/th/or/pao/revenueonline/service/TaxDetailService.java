package th.or.pao.revenueonline.service;

import th.or.pao.revenueonline.model.Tax;
import th.or.pao.revenueonline.model.TaxDetail;

import java.util.List;

public interface TaxDetailService {

    TaxDetail findById(Long id);

    void save(TaxDetail taxDetail);

    void update(TaxDetail taxDetail);

    void deleteById(Long id);

    void deleteAll();

    List<TaxDetail> findAll();

    boolean isExist(TaxDetail taxDetail);
}
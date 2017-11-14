package th.or.pao.revenueonline.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import th.or.pao.revenueonline.model.Tax;
import th.or.pao.revenueonline.model.TaxDetail;
import th.or.pao.revenueonline.service.TaxDetailService;
import th.or.pao.revenueonline.service.TaxService;
import th.or.pao.revenueonline.util.ErrorType;

import java.util.List;

@RestController
@RequestMapping("/api/taxdetail")
@CrossOrigin(origins = "http://localhost:4200")
public class TaxDetailController {

    public static final Logger logger = LoggerFactory.getLogger(TaxDetailController.class);

    @Autowired
    TaxDetailService service;

    // ------------------- Retrieve All ---------------------------------------------
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<TaxDetail>> findAllTaxDetails() {
        List<TaxDetail> taxDetails = service.findAll();
        if (taxDetails.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(taxDetails, HttpStatus.OK);
    }

    // ------------------- Retrieve Single by ID------------------------------------------
    @RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
    public ResponseEntity<TaxDetail> getTaxDetail(@PathVariable("id") long id) {
        logger.info("Fetching TaxDetail with id {}", id);
        TaxDetail taxDetail = service.findById(id);
        if (taxDetail == null) {
            logger.error("TaxDetail with id {} not found.", id);
            return new ResponseEntity(new ErrorType("TaxDetail with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(taxDetail, HttpStatus.OK);
    }

    // ------------------- Create -------------------------------------------
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> createTaxDetail(@RequestBody TaxDetail taxDetail, UriComponentsBuilder ucBuilder) {
        logger.info("Creating TaxDetail : {}", taxDetail);

        if (service.isExist(taxDetail)) {
            logger.error("Unable to create. A TaxDetail with id {} already exist", taxDetail.getId());
            return new ResponseEntity(new ErrorType("Unable to create. A TaxDetail with id " +
                    taxDetail.getId() + " already exist."), HttpStatus.CONFLICT);
        }
        service.save(taxDetail);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/taxdetail/findbyid/{id}").buildAndExpand(taxDetail.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update ------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TaxDetail> updateTaxDetail(@PathVariable("id") long id, @RequestBody TaxDetail taxDetail) {
        logger.info("Updating TaxDetail with id {}", id);

        TaxDetail currentTaxDetail = service.findById(id);

        if (currentTaxDetail == null) {
            logger.error("Unable to update. TaxDetail with id {} not found.", id);
            return new ResponseEntity(new ErrorType("Unable to update. TaxDetail with id " + id
                    + " not found."), HttpStatus.NOT_FOUND);
        }

        currentTaxDetail.setNumber(taxDetail.getNumber());
        currentTaxDetail.setCompanyType(taxDetail.getCompanyType());
        currentTaxDetail.setDetail(taxDetail.getDetail());
        currentTaxDetail.setQtyKilo(taxDetail.getQtyKilo());
        currentTaxDetail.setQtyPack(taxDetail.getQtyPack());
        currentTaxDetail.setQtyRoll(taxDetail.getQtyRoll());
        currentTaxDetail.setAmount(taxDetail.getAmount());

        service.update(currentTaxDetail);
        return new ResponseEntity<>(currentTaxDetail, HttpStatus.OK);
    }

    // ------------------- Delete -----------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TaxDetail> deleteTaxDetail(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Tax with id {}", id);

        TaxDetail taxDetail = service.findById(id);
        if (taxDetail == null) {
            logger.error("Unable to delete. TaxDetail with id {} not found.", id);
            return new ResponseEntity(new ErrorType("Unable to delete. TaxDetail with id " + id
                    + " not found."), HttpStatus.NOT_FOUND);
        }
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

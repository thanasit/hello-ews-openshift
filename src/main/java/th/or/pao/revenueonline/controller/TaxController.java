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
import th.or.pao.revenueonline.service.TaxService;
import th.or.pao.revenueonline.util.ErrorType;

import java.util.List;

@RestController
@RequestMapping("/api/tax")
@CrossOrigin(origins = "http://localhost:4200")
public class TaxController {

    public static final Logger logger = LoggerFactory.getLogger(TaxController.class);

    @Autowired
    TaxService service;

    // ------------------- Retrieve All ---------------------------------------------
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Tax>> findAllTaxes() {
        List<Tax> taxes = service.findAll();
        if (taxes.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(taxes, HttpStatus.OK);
    }

    // ------------------- Retrieve Single by ID------------------------------------------
    @RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
    public ResponseEntity<Tax> getTax(@PathVariable("id") long id) {
        logger.info("Fetching Tax with id {}", id);
        Tax tax = service.findById(id);
        if (tax == null) {
            logger.error("Tax with id {} not found.", id);
            return new ResponseEntity(new ErrorType("Tax with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tax, HttpStatus.OK);
    }

    // ------------------- Create -------------------------------------------
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> createTax(@RequestBody Tax tax, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Tax : {}", tax);

        if (service.isExist(tax)) {
            logger.error("Unable to create. A Tax with id {} already exist", tax.getId());
            return new ResponseEntity(new ErrorType("Unable to create. A Tax with id " +
                    tax.getId() + " already exist."), HttpStatus.CONFLICT);
        }
        service.save(tax);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/tax/findbyid/{id}").buildAndExpand(tax.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update ------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Tax> updateTax(@PathVariable("id") long id, @RequestBody Tax tax) {
        logger.info("Updating Tax with id {}", id);

        Tax currentTax = service.findById(id);

        if (currentTax == null) {
            logger.error("Unable to update. Tax with id {} not found.", id);
            return new ResponseEntity(new ErrorType("Unable to update. Tax with id " + id
                    + " not found."), HttpStatus.NOT_FOUND);
        }

        currentTax.setTaxStatus(tax.getTaxStatus());
        currentTax.setMonth(tax.getMonth());
        currentTax.setYear(tax.getYear());
        if (currentTax.getTaxCigarette() != null) {
            currentTax.setTaxCigarette(tax.getTaxCigarette());
        }
        if (currentTax.getTaxDetail() != null) {
            currentTax.setTaxDetail(tax.getTaxDetail());
        }
        if (currentTax.getTaxHotelAttached() != null) {
            currentTax.setTaxHotelAttached(tax.getTaxHotelAttached());
        }
        currentTax.setTotalAmount(tax.getTotalAmount());
        currentTax.setTotalAmountTH(tax.getTotalAmountTH());
        currentTax.setTotalAmountHotel(tax.getTotalAmountHotel());
        currentTax.setSignDate(tax.getSignDate());
        currentTax.setPaidDate(tax.getPaidDate());
        currentTax.setNumberOfAttachment(tax.getNumberOfAttachment());
        currentTax.setNumberOfPerson(tax.getNumberOfPerson());
        if (currentTax.getTaxConfiguration() != null) {
            currentTax.setTaxConfiguration(tax.getTaxConfiguration());
        }
        currentTax.setTaxType(tax.getTaxType());
        currentTax.setNumberOfAdditionalTax(tax.getNumberOfAdditionalTax());
        currentTax.setDateFrom(tax.getDateFrom());
        currentTax.setDateTo(tax.getDateTo());

        service.update(currentTax);
        return new ResponseEntity<>(currentTax, HttpStatus.OK);
    }

    // ------------------- Delete -----------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Tax> deleteTax(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Tax with id {}", id);

        Tax tax = service.findById(id);
        if (tax == null) {
            logger.error("Unable to delete. Tax with id {} not found.", id);
            return new ResponseEntity(new ErrorType("Unable to delete. Tax with id " + id
                    + " not found."), HttpStatus.NOT_FOUND);
        }
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

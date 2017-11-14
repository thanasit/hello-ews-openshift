package th.or.pao.revenueonline.controller;

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
import th.or.pao.revenueonline.model.base.Company;

import java.util.List;
import org.slf4j.Logger;
import th.or.pao.revenueonline.service.CompanyService;
import th.or.pao.revenueonline.util.ErrorType;

@RestController
@RequestMapping("/api/company")
@CrossOrigin(origins = "http://localhost:4200")
public class CompanyController {

    public static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    CompanyService service;

    // ------------------- Retrieve All ---------------------------------------------
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Company>> findAllCompanies() {
        List<Company> companies = service.findAll();
        if (companies.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    // ------------------- Retrieve Single by ID------------------------------------------
    @RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
    public ResponseEntity<Company> getCompany(@PathVariable("id") long id) {
        logger.info("Fetching Company with id {}", id);
        Company company = service.findById(id);
        if (company == null) {
            logger.error("Company with id {} not found.", id);
            return new ResponseEntity(new ErrorType("Company with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    // ------------------- Retrieve Single by name------------------------------------------
    @RequestMapping(value = "/findbyname/{name}", method = RequestMethod.GET)
    public ResponseEntity<Company> getCompanyByName(@PathVariable("name") String name) {
        logger.info("Fetching Company with name {}", name);
        Company company = service.findByName(name);
        if (company == null) {
            logger.error("Company with name {} not found.", name);
            return new ResponseEntity(new ErrorType("Company with name " + name
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    // ------------------- Create -------------------------------------------
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> createCompany(@RequestBody Company company, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Company : {}", company);

        if (service.isExist(company)) {
            logger.error("Unable to create. A Company with name {} already exist", company.getName());
            return new ResponseEntity(new ErrorType("Unable to create. A Company with name " +
                    company.getName() + " already exist."), HttpStatus.CONFLICT);
        }
        service.save(company);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/company/findbyid/{id}").buildAndExpand(company.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update ------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Company> updateCompany(@PathVariable("id") long id, @RequestBody Company company) {
        logger.info("Updating Company with id {}", id);

        Company currentCompany = service.findById(id);

        if (currentCompany == null) {
            logger.error("Unable to update. Company with id {} not found.", id);
            return new ResponseEntity(new ErrorType("Unable to update. Company with id " + id
                    + " not found."), HttpStatus.NOT_FOUND);
        }

        currentCompany.setName(company.getName());
        currentCompany.setCompanyType(company.getCompanyType());
        currentCompany.setAddressLine1(company.getAddressLine1());
        currentCompany.setAddressLine2(company.getAddressLine2());
        currentCompany.setBranchName(company.getBranchName());
        currentCompany.setPhone(company.getPhone());
        currentCompany.setEmail(company.getEmail());
        currentCompany.setComRegistrationCer(company.getComRegistrationCer());
        currentCompany.setTaxPayer(company.getTaxPayer());
        if (company.getProvince() != null) {
            currentCompany.setProvince(company.getProvince());
        }
        currentCompany.setCompanyType(company.getCompanyType());

        service.update(currentCompany);
        return new ResponseEntity<>(currentCompany, HttpStatus.OK);
    }

    // ------------------- Delete -----------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Company> deleteCompany(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Company with id {}", id);

        Company company = service.findById(id);
        if (company == null) {
            logger.error("Unable to delete. Company with id {} not found.", id);
            return new ResponseEntity(new ErrorType("Unable to delete. Company with id " + id
                    + " not found."), HttpStatus.NOT_FOUND);
        }
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Delete All -----------------------------
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity<Company> deleteAllCompanies() {
        logger.info("Deleting All Companies");

        service.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

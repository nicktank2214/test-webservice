package com.nicktank.microservice.web;

import com.nicktank.microservice.domain.Package;
import com.nicktank.microservice.repository.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;



/**
 * Package Controller
 * 
 * - we use a packageDTO to pass parameter to and from the REST calls
 * - we use paging for the list back to the REST
 * 
 */
@RestController
@RequestMapping(path = "/package")
public class PackageController {

    PackageRepository packageRepository;

    @Autowired
    public PackageController(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    protected PackageController() {

    }

    
    /**
     * find package object 
     *
     * @param package.id
     * @return The modified Package DTO.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    //<GET>http://localhost:8080/package/1    
    public PackageDto findPackageById(@PathVariable(value = "id") Integer id) {
    	Package _package = verifyPackage(id);       
        return toDto(packageRepository.save(_package));
    }
    
    


    /**
     * list a Packages  (plus paging)
     *
     * @param pageable
     * @return
     */   
    @RequestMapping(method = RequestMethod.GET, path = "/list")    
    //<GET>http://localhost:8080/package/list
    //<GET>http://localhost:8080/package/list?page=0&size=2 <-with paging    
    public Page<PackageDto> getAllPackages(Pageable pageable) {
        Page<Package> packagePage = packageRepository.findAll(pageable);
        List<PackageDto> packageDtoList = packagePage.getContent().stream().map(_package -> toDto(_package)).collect(Collectors.toList());
        return new PageImpl<PackageDto>(packageDtoList, pageable, packagePage.getTotalPages());
    }



    /**
     * Create a package 
     *
     * @param dto
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    //<POST>http://localhost:8080/package
    //{
    //	"name": "Package A",
    //	"description": "Package A",
    //	"products": "",
    //  "price": 990.99
    //}   
    public void createPackage(@RequestBody @Validated PackageDto dto) {
        //Package(String name, String description, BigDecimal price)         
        packageRepository.save(new Package( dto.getName(), dto.getDescription(), dto.getPrice()));
    }
    
    
    /**
     * Update package object 
     *
     * @param package.id
     * @param dto
     * @return The modified Package DTO.
     */
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    //<PUT>http://localhost:8080/package/1
    //{
    //	"name": "system1",
    //	"description": "live",
    //	"products": "",
    //  "price": 99.99
    //}      
    public PackageDto updateWithPut(@PathVariable(value = "id") Integer id, @RequestBody @Validated PackageDto dto) {
        Package _package = verifyPackage(id);
        _package.setName(dto.getName());
        _package.setDescription(dto.getDescription());
        //_package.setProducts(dto.getProducts());  
        _package.setPrice(dto.getPrice());  
        return toDto(packageRepository.save(_package));
    }
    
    
    /**
     * Update name or description for a Package
     *
     * @param package.id
     * @param dto
     * @return The modified DTO.
     */
    @RequestMapping(method = RequestMethod.PATCH, path = "/{id}")
    //<PATCH>http://localhost:8080/package/1
    //{
    //	"name": "change the name",
    //	"description": "changed to this"
    //}        
    public PackageDto updateWithPatch(@PathVariable(value = "id") Integer id, @RequestBody @Validated PackageDto dto) {
        Package _package = verifyPackage(id);
        if (dto.getName() != null) {
            _package.setName(dto.getName());
        }
        if (dto.getDescription() != null) {
            _package.setDescription(dto.getDescription());
        }  
        return toDto(packageRepository.save(_package));
    }

    
    /**
     * Delete an Package by the id
     *
     * @param package.id
     */
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    //<DELETE>http://localhost:8080/package/1
    public void delete(@PathVariable(value = "id") Integer id ) {
        Package _package = verifyPackage(id);
        packageRepository.delete(_package);
    }

    
    /**
     * Convert the Package entity to a PackageDto
     *
     * @param package 
     * @return PackageDto
     */
    private PackageDto toDto(Package _package) {
        //PackageDto(Integer id, String name, String description, String products, DigDecimal price)    	
        return new PackageDto(_package.getId(), _package.getName(), _package.getDescription(), "", _package.getPrice());
    }


    /**
     * Verify and return the Tour given a tourId.
     *
     * @param id
     * @return the found Package
     * @throws NoSuchElementException if no Package found.
     */
    private Package verifyPackage(Integer id) throws NoSuchElementException {
        Optional<Package> _package= packageRepository.findById(id);
        if (!_package.isPresent()) {
            throw new NoSuchElementException("Package does not exist:  " + id);
        }
        return _package.get();
    }
 
    
    /**
     * Exception handler if NoSuchElementException is thrown in this Controller
     *
     * @param ex
     * @return Error message String.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();

    }

}

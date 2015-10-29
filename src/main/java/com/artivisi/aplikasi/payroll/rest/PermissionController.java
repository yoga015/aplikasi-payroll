package com.artivisi.aplikasi.payroll.rest;

import com.artivisi.aplikasi.payroll.dao.PermissionDao;
import com.artivisi.aplikasi.payroll.domain.Permission;
import com.artivisi.aplikasi.payroll.exception.InvalidParameterException;
import com.artivisi.aplikasi.payroll.exception.RestServerException;
import com.artivisi.pos.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
@RequestMapping("/api")
public class PermissionController extends BaseController {
    
    @Autowired private PermissionDao permissionDao;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @RequestMapping(value="/permission/count/{filter}", method = RequestMethod.GET)
    public Long count(@PathVariable("filter") String filter,
            @RequestParam(value = "val", required = false) String value,
            Pageable pageable){
        
        if(filter.equalsIgnoreCase("all")){
            return permissionDao.count();
        } 
        
        throw new InvalidParameterException("Invalid Parameter Filter ["+filter+"]");
    }
    
    @RequestMapping(value="/permission/{filter}", method = RequestMethod.GET)
    public Page<Permission> findAll(@PathVariable("filter") String filter,
            @RequestParam(value = "val", required = false) String value,
            Pageable pageable){
        
        if(filter.equalsIgnoreCase("all")){
            return permissionDao.findAll(getPaging(pageable, "value"));
        } else if(filter.equalsIgnoreCase("label")){
            return permissionDao.findByLabelContaining(value, getPaging(pageable, "value"));
        } else if(filter.equalsIgnoreCase("value")){
            return permissionDao.findByValueContaining(value, getPaging(pageable, "value"));
        }
        
        throw new InvalidParameterException("Invalid Parameter Filter ["+filter+"]");
    }
    
    @RequestMapping(value="/permission/get/{filter}", method = RequestMethod.GET)
    public Permission findOne(@PathVariable("filter") String filter,
            @RequestParam("val") String value){
        
        if(filter.equalsIgnoreCase("id")){
            return permissionDao.findOne(value);
        } else if(filter.equalsIgnoreCase("value")){
            return permissionDao.findByValue(value);
        } 
        
        throw new InvalidParameterException("Invalid Parameter Filter ["+filter+"]");
    }
    
    @RequestMapping(value="/permission", method = RequestMethod.POST)
    public void save(@RequestBody Permission permission){
        
        logger.debug("Find permission by value [{}]", permission.getValue());
        Permission pdb = permissionDao.findByValue(permission.getValue());
        if(pdb!=null) throw new RestServerException("Data Already Exists !");
        
        logger.info("Save permission [{}]", permission.toString());
        permissionDao.save(permission);
    }
    
    @RequestMapping(value="/permission/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody Permission permission, @PathVariable String id){
        
        logger.debug("Find permission by id [{}]", id);
        Permission pdb = permissionDao.findOne(id);
        if(pdb==null) throw new ResourceNotFoundException("Data Not Found!");
        
        logger.info("Update permission [{}]", permission.toString());
        permission.setId(pdb.getId());
        permissionDao.save(permission);
    }
    
    @RequestMapping(value="/permission/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        
        logger.debug("Find permission by id [{}]", id);
        Permission pdb = permissionDao.findOne(id);
        if(pdb==null) throw new ResourceNotFoundException("Data Not Found !");
        
        logger.info("Delete permission [{}]", pdb.toString());
        permissionDao.delete(pdb);
    }
    
}

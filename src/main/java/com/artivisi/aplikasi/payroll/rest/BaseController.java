package com.artivisi.aplikasi.payroll.rest;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class BaseController {

    protected PageRequest getPaging(Pageable pageable, String...properties){
        int page = 0;
        int size = 10;
        Sort sort = new Sort(Sort.Direction.ASC, properties);
        
        if(pageable!=null){
            //Set pagenumber and size from request parameters
            page = pageable.getPageNumber();
            size = pageable.getPageSize();
            
            //if sort is available
            if(pageable.getSort()!=null){
                sort = pageable.getSort();
            }
        }
        return new PageRequest(page, size, sort);
    }
}

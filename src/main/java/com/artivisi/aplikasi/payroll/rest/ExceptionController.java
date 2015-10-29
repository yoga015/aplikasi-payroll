package com.artivisi.aplikasi.payroll.rest;

import com.artivisi.aplikasi.payroll.exception.ErrorInfo;
import com.artivisi.aplikasi.payroll.exception.InvalidParameterException;
import com.artivisi.aplikasi.payroll.exception.RestServerException;
import com.artivisi.aplikasi.payroll.exception.UnauthenticatedRequestException;
import com.artivisi.pos.exception.ResourceNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({UnauthenticatedRequestException.class})
    @ResponseBody
    public ErrorInfo handleUnauthenticated(HttpServletRequest request, Exception ex) {
        ErrorInfo info = new ErrorInfo();
        info.setStatus(HttpStatus.UNAUTHORIZED.toString());
        info.setUrl(request.getRequestURL().toString());
        info.setMessage(ex.getMessage());
        
        logger.error(ex.getMessage(), ex);
        return info;
    }
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseBody
    public ErrorInfo handleResourceNotFound(HttpServletRequest request, Exception ex) {
        ErrorInfo info = new ErrorInfo();
        info.setStatus(HttpStatus.NOT_FOUND.toString());
        info.setUrl(request.getRequestURL().toString());
        info.setMessage(ex.getMessage());
        
        logger.error(ex.getMessage(), ex);
        return info;
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({InvalidParameterException.class})
    @ResponseBody
    public ErrorInfo handleInvalidParameter(HttpServletRequest request, Exception ex) {
        ErrorInfo info = new ErrorInfo();
        info.setStatus(HttpStatus.BAD_REQUEST.toString());
        info.setUrl(request.getRequestURL().toString());
        info.setMessage(ex.getMessage());
        
        logger.error(ex.getMessage(), ex);
        return info;
    }
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({RestServerException.class})
    @ResponseBody
    public ErrorInfo handleRestException(HttpServletRequest request, Exception ex) {
        ErrorInfo info = new ErrorInfo();
        info.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        info.setUrl(request.getRequestURL().toString());
        info.setMessage(ex.getMessage());
        
        logger.error(ex.getMessage(), ex);
        return info;
    }
}

package io.product.recommendation.util;

import org.hibernate.exception.DataException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.http.HttpStatus;

public class ExceptionToStatusCode {
    public static HttpStatus convert(Exception e){
        if (e instanceof DuplicateKeyException) return HttpStatus.CONFLICT;
        if (e instanceof DataIntegrityViolationException) return HttpStatus.CONFLICT;
        if (e instanceof DataRetrievalFailureException) return HttpStatus.NOT_FOUND;
        if (e instanceof PermissionDeniedDataAccessException) return HttpStatus.UNAUTHORIZED;

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}

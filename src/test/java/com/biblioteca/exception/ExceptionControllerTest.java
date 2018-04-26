package com.biblioteca.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExceptionControllerTest {

    @Mock
    private HttpServletRequest httpServletRequest;

    @Test
    public void shouldReturnHandleError() {
        ExceptionController exceptionController = new ExceptionController();
        when(httpServletRequest.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI)).thenReturn("ErrorString");
        Errors errors = exceptionController.handleError(httpServletRequest);
        assertEquals(errors.endPointNotFound(), new Errors(Collections.singletonList(new ApplicationError(UUID.randomUUID().toString(), "404", "ENDPOINT_NOT_FOUND"))));
    }

}
package com.biblioteca.Errors;

import com.biblioteca.exception.ApplicationError;
import com.biblioteca.exception.Errors;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class ErrorsTest {

    @Test
    public void shouldReturnError() {
        assertEquals(Errors.endPointNotFound(), new Errors(Collections.singletonList(new ApplicationError(UUID.randomUUID().toString(), "404", "ENDPOINT_NOT_FOUND"))));
    }
}

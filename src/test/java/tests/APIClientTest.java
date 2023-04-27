package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static adapters.ApiClient.getAPIContent;
import static org.junit.Assert.*;

public class APIClientTest {

    @Test
    public void apiReturnsAnStringContent() throws IOException {
        String stringExpected = getAPIContent("&i=tt3896198");
        assertEquals(String.class, stringExpected.getClass());
    }

    @Test
    public void apiCallBadParamsThrowsIOException(){
        assertThrows(IOException.class,
                () -> {
                    getAPIContent("exampleBadParam");
                });
    }

    @Test
    public void makeApiCallReturnsNotNull() throws IOException {
        assertNotNull(getAPIContent("&i=tt3896198"));
    }
}

package classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Error extends Exception{
    @JsonProperty("Error")
    private String error;
    @JsonProperty("Response")
    private String response;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}

package classes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Response {
    @JsonProperty("Response")
    private String response;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Search")
    private List<Search> search;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("totalResults")
    private String totalResults;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Error")
    private String error;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<Search> getSearch() {
        return search;
    }

    public void setSearch(List<Search> search) {
        this.search = search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}


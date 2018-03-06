package pro.home.my.di.model;

/**
 * Created by Egor on 04.03.2018.
 */

public class ServerResponse {
    private String status;
    private String error;

    public ServerResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

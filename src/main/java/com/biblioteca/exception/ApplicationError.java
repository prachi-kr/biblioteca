package com.biblioteca.exception;

import java.util.Objects;

public class ApplicationError {

    private String id;
    private String status;
    private String code;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationError that = (ApplicationError) o;
        return Objects.equals(status, that.status) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, status, code);
    }

    @Override
    public String toString() {
        return "ApplicationError{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ApplicationError(String id, String status, String code) {
        this.id = id;
        this.status = status;
        this.code = code;
    }

}

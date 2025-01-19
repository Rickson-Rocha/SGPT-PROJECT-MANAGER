package com.br.sgpt.projectmanager.exceptions;

public class DateTaskException extends  RuntimeException {
    public DateTaskException(String message) {
        super(message);
    }
    public DateTaskException(String message, Throwable cause) {
        super(message, cause);
    }
}

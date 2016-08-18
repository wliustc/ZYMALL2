package com.zy.app.util.image.assist;

/**
 * Created by Robin on 2016/5/22.
 */
public class JDFailReason {
    private final Throwable cause;
    private ErrorType type = null;

    public JDFailReason(int i, Throwable throwable)
    {
        if (i == 2)
            this.type = ErrorType.DECODING_ERROR;
        else if (i == 1)
            this.type = ErrorType.IO_ERROR;
        else if (i == 3)
            this.type = ErrorType.NETWORK_DENIED;
        else if (i == 4)
            this.type = ErrorType.OUT_OF_MEMORY;
        else
            this.type = ErrorType.UNKNOWN;
        this.cause = throwable;
        return;

    }

    public JDFailReason(ErrorType type, Throwable throwable)
    {
        this.type = type;
        this.cause = throwable;
    }

    public Throwable getCause()
    {
        return this.cause;
    }

    public ErrorType getType()
    {
        return this.type;
    }

    public enum ErrorType
    {
        IO_ERROR, DECODING_ERROR, NETWORK_DENIED, OUT_OF_MEMORY, UNKNOWN
    }
}

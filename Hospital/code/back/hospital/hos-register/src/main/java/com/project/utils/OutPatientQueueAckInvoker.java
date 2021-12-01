package com.project.utils;

import java.io.IOException;

@FunctionalInterface
public interface OutPatientQueueAckInvoker {
    void invoke() throws IOException;
}

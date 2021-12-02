package com.project.utils;

import java.io.IOException;

@FunctionalInterface
public interface OutPatientQueueInvoker {
    void invoke() throws IOException;
}

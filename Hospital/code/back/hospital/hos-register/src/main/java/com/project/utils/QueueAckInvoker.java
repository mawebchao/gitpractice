package com.project.utils;

import java.io.IOException;

@FunctionalInterface
public interface QueueAckInvoker {
    void invoke() throws IOException;
}

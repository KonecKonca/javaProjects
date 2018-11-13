package annologger.annotation;

import annologger.DefaultLoggingPolicy;

public @interface LoggingPolicyAnnotation {
    Class<DefaultLoggingPolicy> loggingPolicy();
}

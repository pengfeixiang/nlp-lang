/*
 * Copyright 1999-2101 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nlpcn.commons.lang.util.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

public class SLF4JImpl implements Log {

    private static final String callerFQCN = SLF4JImpl.class.getName();
    private static final Logger testLogger = LoggerFactory.getLogger(SLF4JImpl.class);
    static {
        // if the logger is not a LocationAwareLogger instance, it can not get correct stack StackTraceElement
        // so ignore this implementation.
        if (!(testLogger instanceof LocationAwareLogger)) {
            throw new UnsupportedOperationException(testLogger.getClass() + " is not a suitable logger");
        }
    }
    private LocationAwareLogger log;

    public SLF4JImpl(LocationAwareLogger log){
        this.log = log;
    }

    public SLF4JImpl(String loggerName){
        this.log = (LocationAwareLogger) LoggerFactory.getLogger(loggerName);
    }

    @Override
    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    @Override
    public void error(String msg, Throwable e) {
        log.log(null, callerFQCN, LocationAwareLogger.ERROR_INT, msg, null, e);
    }

    @Override
    public void error(String msg) {
        log.log(null, callerFQCN, LocationAwareLogger.ERROR_INT, msg, null, null);
    }

    @Override
    public boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }

    @Override
    public void info(String msg) {
        log.log(null, callerFQCN, LocationAwareLogger.INFO_INT, msg, null, null);
    }

    @Override
    public void debug(String msg) {
        log.log(null, callerFQCN, LocationAwareLogger.DEBUG_INT, msg, null, null);
    }

    @Override
    public void debug(String msg, Throwable e) {
        log.log(null, callerFQCN, LocationAwareLogger.ERROR_INT, msg, null, e);
    }

    @Override
    public boolean isWarnEnabled() {
        return log.isWarnEnabled();
    }

    @Override
    public void warn(String msg) {
        log.log(null, callerFQCN, LocationAwareLogger.WARN_INT, msg, null, null);
    }

    @Override
    public void warn(String msg, Throwable e) {
        log.log(null, callerFQCN, LocationAwareLogger.WARN_INT, msg, null, e);
    }

}

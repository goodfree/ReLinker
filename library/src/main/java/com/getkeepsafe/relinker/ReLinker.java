/**
 * Copyright 2016 KeepSafe Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.getkeepsafe.relinker;

import android.content.Context;

/**
 * ReLinker is a small library to help alleviate {@link UnsatisfiedLinkError} exceptions thrown due
 * to Android's inability to properly install / load native libraries for Android versions before
 * API 21
 */
public class ReLinker {
    public interface LoadListener {
        void success();
        void failure(Throwable t);
    }

    public interface Logger {
        void log(final String message);
    }

    public static void loadLibrary(final Context context, final String library) {
        loadLibrary(context, library, null);
    }

    public static void loadLibrary(final Context context,
                                   final String library,
                                   final LoadListener listener) {
        new ReLinkerInstance(null).loadLibrary(context, library, listener);
    }

    public static ReLinkerInstance log(final Logger logger) {
        return new ReLinkerInstance(logger);
    }

    private ReLinker() {}
}

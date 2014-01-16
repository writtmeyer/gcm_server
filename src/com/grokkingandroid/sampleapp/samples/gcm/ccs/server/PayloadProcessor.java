/*
 * Copyright 2014 Wolfram Rittmeyer.
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

package com.grokkingandroid.sampleapp.samples.gcm.ccs.server;

/**
 * All messages from the user have a specific format.
 * The Action field defines, what the action is about. An example
 * is the action com.grokkingandroid.sampleapp.samples.gcm.action.REGISTER, 
 * used to tell the server about a newly registered user.
 * <br>
 * Any further fields are specific for the given action.
 */
public interface PayloadProcessor {
    
    void handleMessage(CcsMessage msg);
    
}

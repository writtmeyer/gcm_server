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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * This class acts as a DAO replacement. There is no
 * persistent state. As soon as you kill the server, all state will
 * be lost.
 * 
 * You have to take care of persisting messages as well as
 * recipients for proper apps!
 */
public class PseudoDao {
    
    private final static PseudoDao instance = new PseudoDao();
    private final static Random sRandom = new Random();
    private final Set<Integer> mMessageIds = new HashSet<Integer>();
    private final Map<String, List<String>> mUserMap = new HashMap<String, List<String>>();
    private final List<String> mRegisteredUsers = new ArrayList<String>();
    private final Map<String, String> mNotificationKeyMap = new HashMap<String, String>();
    
    private PseudoDao() {        
    }
    
    public static PseudoDao getInstance() {
        return instance;
    }
    
    public void addRegistration(String regId, String accountName) {
        synchronized(mRegisteredUsers) {
            if (!mRegisteredUsers.contains(regId)) {
                mRegisteredUsers.add(regId);
            }
            if (accountName != null) {
                List<String> regIdList = mUserMap.get(accountName);
                if (regIdList == null) {
                    regIdList = new ArrayList<String>();
                    mUserMap.put(accountName, regIdList);
                }
                if (!regIdList.contains(regId)) {
                    regIdList.add(regId);
                }
            }
        }
    }
    
    public List<String> getAllRegistrationIds() {
        return Collections.unmodifiableList(mRegisteredUsers);
    }
    
    public List<String> getAllRegistrationIdsForAccount(String account) {
        List<String> regIds = mUserMap.get(account);
        if (regIds != null) {
           return Collections.unmodifiableList(regIds);
        }
        return null;
    }
    
    public String getNotificationKeyName(String accountName) {
        return mNotificationKeyMap.get(accountName);
    }
    
    public void storeNotificationKeyName(String accountName, String notificationKeyName) {
        mNotificationKeyMap.put(accountName, notificationKeyName);
    }
    
    public Set<String> getAccounts() {
        return Collections.unmodifiableSet(mUserMap.keySet());
    }
    
    public String getUniqueMessageId() {
        int nextRandom = sRandom.nextInt();
        while (mMessageIds.contains(nextRandom)) {
            nextRandom = sRandom.nextInt();
        }
        return Integer.toString(nextRandom);
    }
}

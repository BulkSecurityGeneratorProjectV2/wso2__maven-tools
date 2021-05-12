/*
 *
 *  * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *  *
 *  * WSO2 Inc. licenses this file to you under the Apache License,
 *  * Version 2.0 (the "License"); you may not use this file except
 *  * in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing,
 *  * software distributed under the License is distributed on an
 *  * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  * KIND, either express or implied. See the License for the
 *  * specific language governing permissions and limitations
 *  * under the License.
 *
 */

package org.wso2.maven.car.artifact;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.Response;
import org.wso2.maven.car.artifact.exception.CAppMgtServiceStubException;

import java.io.File;

public interface CAppMgtServiceStub {

    @RequestLine("GET /management/login")
    @Headers("accept: application/json; charset=utf-8")
    Response doAuthenticate() throws CAppMgtServiceStubException;

    @RequestLine("POST /management/capp-deployer")
    @Headers("Content-Type: multipart/form-data; charset=utf-8")
    Response deployCApp(@Param("file") File capp) throws CAppMgtServiceStubException;

    @RequestLine("POST /management/capp-undeployer")
    @Headers("Content-Type: application/json; charset=utf-8")
    Response unDeployCApp(@Param("cAppNamePattern") String cAppNamePattern) throws CAppMgtServiceStubException;



}

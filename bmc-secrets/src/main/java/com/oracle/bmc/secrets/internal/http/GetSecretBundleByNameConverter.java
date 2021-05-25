/**
 * Copyright (c) 2016, 2021, Oracle and/or its affiliates.  All rights reserved.
 * This software is dual-licensed to you under the Universal Permissive License (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License 2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose either license.
 */
package com.oracle.bmc.secrets.internal.http;

import com.oracle.bmc.http.internal.ResponseHelper;
import com.oracle.bmc.secrets.model.*;
import com.oracle.bmc.secrets.requests.*;
import com.oracle.bmc.secrets.responses.*;
import org.apache.commons.lang3.Validate;

@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20190301")
@lombok.extern.slf4j.Slf4j
public class GetSecretBundleByNameConverter {
    private static final com.oracle.bmc.http.internal.ResponseConversionFunctionFactory
            RESPONSE_CONVERSION_FACTORY =
                    new com.oracle.bmc.http.internal.ResponseConversionFunctionFactory();

    public static com.oracle.bmc.secrets.requests.GetSecretBundleByNameRequest interceptRequest(
            com.oracle.bmc.secrets.requests.GetSecretBundleByNameRequest request) {

        return request;
    }

    public static com.oracle.bmc.http.internal.WrappedInvocationBuilder fromRequest(
            com.oracle.bmc.http.internal.RestClient client,
            com.oracle.bmc.secrets.requests.GetSecretBundleByNameRequest request) {
        Validate.notNull(request, "request instance is required");
        Validate.notNull(request.getSecretName(), "secretName is required");
        Validate.notNull(request.getVaultId(), "vaultId is required");

        com.oracle.bmc.http.internal.WrappedWebTarget target =
                client.getBaseTarget()
                        .path("/20190301")
                        .path("secretbundles")
                        .path("actions")
                        .path("getByName");

        target =
                target.queryParam(
                        "secretName",
                        com.oracle.bmc.util.internal.HttpUtils.attemptEncodeQueryParam(
                                request.getSecretName()));

        target =
                target.queryParam(
                        "vaultId",
                        com.oracle.bmc.util.internal.HttpUtils.attemptEncodeQueryParam(
                                request.getVaultId()));

        if (request.getVersionNumber() != null) {
            target =
                    target.queryParam(
                            "versionNumber",
                            com.oracle.bmc.util.internal.HttpUtils.attemptEncodeQueryParam(
                                    request.getVersionNumber()));
        }

        if (request.getSecretVersionName() != null) {
            target =
                    target.queryParam(
                            "secretVersionName",
                            com.oracle.bmc.util.internal.HttpUtils.attemptEncodeQueryParam(
                                    request.getSecretVersionName()));
        }

        if (request.getStage() != null) {
            target =
                    target.queryParam(
                            "stage",
                            com.oracle.bmc.util.internal.HttpUtils.attemptEncodeQueryParam(
                                    request.getStage().getValue()));
        }

        com.oracle.bmc.http.internal.WrappedInvocationBuilder ib = target.request();

        ib.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON);

        if (request.getOpcRequestId() != null) {
            ib.header("opc-request-id", request.getOpcRequestId());
        }

        return ib;
    }

    public static com.google.common.base.Function<
                    javax.ws.rs.core.Response,
                    com.oracle.bmc.secrets.responses.GetSecretBundleByNameResponse>
            fromResponse() {
        final com.google.common.base.Function<
                        javax.ws.rs.core.Response,
                        com.oracle.bmc.secrets.responses.GetSecretBundleByNameResponse>
                transformer =
                        new com.google.common.base.Function<
                                javax.ws.rs.core.Response,
                                com.oracle.bmc.secrets.responses.GetSecretBundleByNameResponse>() {
                            @Override
                            public com.oracle.bmc.secrets.responses.GetSecretBundleByNameResponse
                                    apply(javax.ws.rs.core.Response rawResponse) {
                                LOG.trace(
                                        "Transform function invoked for com.oracle.bmc.secrets.responses.GetSecretBundleByNameResponse");
                                com.google.common.base.Function<
                                                javax.ws.rs.core.Response,
                                                com.oracle.bmc.http.internal.WithHeaders<
                                                        SecretBundle>>
                                        responseFn =
                                                RESPONSE_CONVERSION_FACTORY.create(
                                                        SecretBundle.class);

                                com.oracle.bmc.http.internal.WithHeaders<SecretBundle> response =
                                        responseFn.apply(rawResponse);
                                javax.ws.rs.core.MultivaluedMap<String, String> headers =
                                        response.getHeaders();

                                com.oracle.bmc.secrets.responses.GetSecretBundleByNameResponse
                                                .Builder
                                        builder =
                                                com.oracle.bmc.secrets.responses
                                                        .GetSecretBundleByNameResponse.builder()
                                                        .__httpStatusCode__(
                                                                rawResponse.getStatus());

                                builder.secretBundle(response.getItem());

                                com.google.common.base.Optional<java.util.List<String>>
                                        opcRequestIdHeader =
                                                com.oracle.bmc.http.internal.HeaderUtils.get(
                                                        headers, "opc-request-id");
                                if (opcRequestIdHeader.isPresent()) {
                                    builder.opcRequestId(
                                            com.oracle.bmc.http.internal.HeaderUtils.toValue(
                                                    "opc-request-id",
                                                    opcRequestIdHeader.get().get(0),
                                                    String.class));
                                }

                                com.oracle.bmc.secrets.responses.GetSecretBundleByNameResponse
                                        responseWrapper = builder.build();

                                ResponseHelper.closeResponseSilentlyIfNotBuffered(rawResponse);
                                return responseWrapper;
                            }
                        };
        return transformer;
    }
}

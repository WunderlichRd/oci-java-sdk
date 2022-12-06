/**
 * Copyright (c) 2016, 2022, Oracle and/or its affiliates.  All rights reserved.
 * This software is dual-licensed to you under the Universal Permissive License (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License 2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose either license.
 */
package com.oracle.bmc.goldengate;

import com.oracle.bmc.util.internal.Validate;
import com.oracle.bmc.goldengate.requests.*;
import com.oracle.bmc.goldengate.responses.*;

import java.util.Objects;

/**
 * Async client implementation for GoldenGate service. <br>
 * There are two ways to use async client: 1. Use AsyncHandler: using AsyncHandler, if the response
 * to the call is an {@link java.io.InputStream}, like getObject Api in object storage service,
 * developers need to process the stream in AsyncHandler, and not anywhere else, because the stream
 * will be closed right after the AsyncHandler is invoked. <br>
 * 2. Use Java Future: using Java Future, developers need to close the stream after they are done
 * with the Java Future.<br>
 * Accessing the result should be done in a mutually exclusive manner, either through the Future or
 * the AsyncHandler, but not both. If the Future is used, the caller should pass in null as the
 * AsyncHandler. If the AsyncHandler is used, it is still safe to use the Future to determine
 * whether or not the request was completed via Future.isDone/isCancelled.<br>
 * Please refer to
 * https://github.com/oracle/oci-java-sdk/blob/master/bmc-examples/src/main/java/ResteasyClientWithObjectStorageExample.java
 */
@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20200407")
public class GoldenGateAsyncClient extends com.oracle.bmc.http.internal.BaseAsyncClient
        implements GoldenGateAsync {
    /** Service instance for GoldenGate. */
    public static final com.oracle.bmc.Service SERVICE =
            com.oracle.bmc.Services.serviceBuilder()
                    .serviceName("GOLDENGATE")
                    .serviceEndpointPrefix("")
                    .serviceEndpointTemplate("https://goldengate.{region}.oci.{secondLevelDomain}")
                    .build();

    private static final org.slf4j.Logger LOG =
            org.slf4j.LoggerFactory.getLogger(GoldenGateAsyncClient.class);

    private GoldenGateAsyncClient(
            com.oracle.bmc.common.ClientBuilderBase<?, ?> builder,
            com.oracle.bmc.auth.AbstractAuthenticationDetailsProvider
                    authenticationDetailsProvider) {
        super(builder, authenticationDetailsProvider);
    }

    /**
     * Create a builder for this client.
     *
     * @return builder
     */
    public static Builder builder() {
        return new Builder(SERVICE);
    }

    /**
     * Builder class for this client. The "authenticationDetailsProvider" is required and must be
     * passed to the {@link #build(AbstractAuthenticationDetailsProvider)} method.
     */
    public static class Builder
            extends com.oracle.bmc.common.RegionalClientBuilder<Builder, GoldenGateAsyncClient> {
        private Builder(com.oracle.bmc.Service service) {
            super(service);
            requestSignerFactory =
                    new com.oracle.bmc.http.signing.internal.DefaultRequestSignerFactory(
                            com.oracle.bmc.http.signing.SigningStrategy.STANDARD);
        }

        /**
         * Build the client.
         *
         * @param authenticationDetailsProvider authentication details provider
         * @return the client
         */
        public GoldenGateAsyncClient build(
                @javax.annotation.Nonnull
                        com.oracle.bmc.auth.AbstractAuthenticationDetailsProvider
                                authenticationDetailsProvider) {
            return new GoldenGateAsyncClient(this, authenticationDetailsProvider);
        }
    }

    @Override
    public void setRegion(com.oracle.bmc.Region region) {
        super.setRegion(region);
    }

    @Override
    public void setRegion(String regionId) {
        super.setRegion(regionId);
    }

    @Override
    public java.util.concurrent.Future<CancelDeploymentBackupResponse> cancelDeploymentBackup(
            CancelDeploymentBackupRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            CancelDeploymentBackupRequest, CancelDeploymentBackupResponse>
                    handler) {

        Validate.notBlank(request.getDeploymentBackupId(), "deploymentBackupId must not be blank");
        Objects.requireNonNull(
                request.getCancelDeploymentBackupDetails(),
                "cancelDeploymentBackupDetails is required");

        return clientCall(request, CancelDeploymentBackupResponse::builder)
                .logger(LOG, "cancelDeploymentBackup")
                .serviceDetails(
                        "GoldenGate",
                        "CancelDeploymentBackup",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/DeploymentBackup/CancelDeploymentBackup")
                .method(com.oracle.bmc.http.client.Method.POST)
                .requestBuilder(CancelDeploymentBackupRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deploymentBackups")
                .appendPathParam(request.getDeploymentBackupId())
                .appendPathParam("actions")
                .appendPathParam("cancel")
                .accept("application/json")
                .appendHeader("if-match", request.getIfMatch())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .appendHeader("opc-retry-token", request.getOpcRetryToken())
                .hasBody()
                .handleResponseHeaderString(
                        "opc-work-request-id",
                        CancelDeploymentBackupResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", CancelDeploymentBackupResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<ChangeConnectionCompartmentResponse>
            changeConnectionCompartment(
                    ChangeConnectionCompartmentRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    ChangeConnectionCompartmentRequest,
                                    ChangeConnectionCompartmentResponse>
                            handler) {

        Validate.notBlank(request.getConnectionId(), "connectionId must not be blank");
        Objects.requireNonNull(
                request.getChangeConnectionCompartmentDetails(),
                "changeConnectionCompartmentDetails is required");

        return clientCall(request, ChangeConnectionCompartmentResponse::builder)
                .logger(LOG, "changeConnectionCompartment")
                .serviceDetails(
                        "GoldenGate",
                        "ChangeConnectionCompartment",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/Connection/ChangeConnectionCompartment")
                .method(com.oracle.bmc.http.client.Method.POST)
                .requestBuilder(ChangeConnectionCompartmentRequest::builder)
                .basePath("/20200407")
                .appendPathParam("connections")
                .appendPathParam(request.getConnectionId())
                .appendPathParam("actions")
                .appendPathParam("changeCompartment")
                .accept("application/json")
                .appendHeader("if-match", request.getIfMatch())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .hasBody()
                .handleResponseHeaderString(
                        "opc-work-request-id",
                        ChangeConnectionCompartmentResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", ChangeConnectionCompartmentResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<ChangeDatabaseRegistrationCompartmentResponse>
            changeDatabaseRegistrationCompartment(
                    ChangeDatabaseRegistrationCompartmentRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    ChangeDatabaseRegistrationCompartmentRequest,
                                    ChangeDatabaseRegistrationCompartmentResponse>
                            handler) {

        Validate.notBlank(
                request.getDatabaseRegistrationId(), "databaseRegistrationId must not be blank");
        Objects.requireNonNull(
                request.getChangeDatabaseRegistrationCompartmentDetails(),
                "changeDatabaseRegistrationCompartmentDetails is required");

        return clientCall(request, ChangeDatabaseRegistrationCompartmentResponse::builder)
                .logger(LOG, "changeDatabaseRegistrationCompartment")
                .serviceDetails(
                        "GoldenGate",
                        "ChangeDatabaseRegistrationCompartment",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/DatabaseRegistration/ChangeDatabaseRegistrationCompartment")
                .method(com.oracle.bmc.http.client.Method.POST)
                .requestBuilder(ChangeDatabaseRegistrationCompartmentRequest::builder)
                .basePath("/20200407")
                .appendPathParam("databaseRegistrations")
                .appendPathParam(request.getDatabaseRegistrationId())
                .appendPathParam("actions")
                .appendPathParam("changeCompartment")
                .accept("application/json")
                .appendHeader("if-match", request.getIfMatch())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .appendHeader("opc-retry-token", request.getOpcRetryToken())
                .hasBody()
                .handleResponseHeaderString(
                        "opc-work-request-id",
                        ChangeDatabaseRegistrationCompartmentResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id",
                        ChangeDatabaseRegistrationCompartmentResponse.Builder::opcRequestId)
                .handleResponseHeaderString(
                        "sunset", ChangeDatabaseRegistrationCompartmentResponse.Builder::sunset)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<ChangeDeploymentBackupCompartmentResponse>
            changeDeploymentBackupCompartment(
                    ChangeDeploymentBackupCompartmentRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    ChangeDeploymentBackupCompartmentRequest,
                                    ChangeDeploymentBackupCompartmentResponse>
                            handler) {

        Validate.notBlank(request.getDeploymentBackupId(), "deploymentBackupId must not be blank");
        Objects.requireNonNull(
                request.getChangeDeploymentBackupCompartmentDetails(),
                "changeDeploymentBackupCompartmentDetails is required");

        return clientCall(request, ChangeDeploymentBackupCompartmentResponse::builder)
                .logger(LOG, "changeDeploymentBackupCompartment")
                .serviceDetails(
                        "GoldenGate",
                        "ChangeDeploymentBackupCompartment",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/DeploymentBackup/ChangeDeploymentBackupCompartment")
                .method(com.oracle.bmc.http.client.Method.POST)
                .requestBuilder(ChangeDeploymentBackupCompartmentRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deploymentBackups")
                .appendPathParam(request.getDeploymentBackupId())
                .appendPathParam("actions")
                .appendPathParam("changeCompartment")
                .accept("application/json")
                .appendHeader("if-match", request.getIfMatch())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .appendHeader("opc-retry-token", request.getOpcRetryToken())
                .hasBody()
                .handleResponseHeaderString(
                        "opc-request-id",
                        ChangeDeploymentBackupCompartmentResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<ChangeDeploymentCompartmentResponse>
            changeDeploymentCompartment(
                    ChangeDeploymentCompartmentRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    ChangeDeploymentCompartmentRequest,
                                    ChangeDeploymentCompartmentResponse>
                            handler) {

        Validate.notBlank(request.getDeploymentId(), "deploymentId must not be blank");
        Objects.requireNonNull(
                request.getChangeDeploymentCompartmentDetails(),
                "changeDeploymentCompartmentDetails is required");

        return clientCall(request, ChangeDeploymentCompartmentResponse::builder)
                .logger(LOG, "changeDeploymentCompartment")
                .serviceDetails(
                        "GoldenGate",
                        "ChangeDeploymentCompartment",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/Deployment/ChangeDeploymentCompartment")
                .method(com.oracle.bmc.http.client.Method.POST)
                .requestBuilder(ChangeDeploymentCompartmentRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deployments")
                .appendPathParam(request.getDeploymentId())
                .appendPathParam("actions")
                .appendPathParam("changeCompartment")
                .accept("application/json")
                .appendHeader("if-match", request.getIfMatch())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .appendHeader("opc-retry-token", request.getOpcRetryToken())
                .hasBody()
                .handleResponseHeaderString(
                        "opc-work-request-id",
                        ChangeDeploymentCompartmentResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", ChangeDeploymentCompartmentResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<CollectDeploymentDiagnosticResponse>
            collectDeploymentDiagnostic(
                    CollectDeploymentDiagnosticRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    CollectDeploymentDiagnosticRequest,
                                    CollectDeploymentDiagnosticResponse>
                            handler) {

        Validate.notBlank(request.getDeploymentId(), "deploymentId must not be blank");
        Objects.requireNonNull(
                request.getCollectDeploymentDiagnosticDetails(),
                "collectDeploymentDiagnosticDetails is required");

        return clientCall(request, CollectDeploymentDiagnosticResponse::builder)
                .logger(LOG, "collectDeploymentDiagnostic")
                .serviceDetails(
                        "GoldenGate",
                        "CollectDeploymentDiagnostic",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/Deployment/CollectDeploymentDiagnostic")
                .method(com.oracle.bmc.http.client.Method.POST)
                .requestBuilder(CollectDeploymentDiagnosticRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deployments")
                .appendPathParam(request.getDeploymentId())
                .appendPathParam("actions")
                .appendPathParam("collectDiagnostics")
                .accept("application/json")
                .appendHeader("if-match", request.getIfMatch())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .appendHeader("opc-retry-token", request.getOpcRetryToken())
                .hasBody()
                .handleResponseHeaderString(
                        "opc-work-request-id",
                        CollectDeploymentDiagnosticResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", CollectDeploymentDiagnosticResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<CreateConnectionResponse> createConnection(
            CreateConnectionRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            CreateConnectionRequest, CreateConnectionResponse>
                    handler) {
        Objects.requireNonNull(
                request.getCreateConnectionDetails(), "createConnectionDetails is required");

        return clientCall(request, CreateConnectionResponse::builder)
                .logger(LOG, "createConnection")
                .serviceDetails(
                        "GoldenGate",
                        "CreateConnection",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/Connection/CreateConnection")
                .method(com.oracle.bmc.http.client.Method.POST)
                .requestBuilder(CreateConnectionRequest::builder)
                .basePath("/20200407")
                .appendPathParam("connections")
                .accept("application/json")
                .appendHeader("opc-retry-token", request.getOpcRetryToken())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .hasBody()
                .handleBody(
                        com.oracle.bmc.goldengate.model.Connection.class,
                        CreateConnectionResponse.Builder::connection)
                .handleResponseHeaderString(
                        "opc-work-request-id", CreateConnectionResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", CreateConnectionResponse.Builder::opcRequestId)
                .handleResponseHeaderString("etag", CreateConnectionResponse.Builder::etag)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<CreateConnectionAssignmentResponse>
            createConnectionAssignment(
                    CreateConnectionAssignmentRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    CreateConnectionAssignmentRequest,
                                    CreateConnectionAssignmentResponse>
                            handler) {
        Objects.requireNonNull(
                request.getCreateConnectionAssignmentDetails(),
                "createConnectionAssignmentDetails is required");

        return clientCall(request, CreateConnectionAssignmentResponse::builder)
                .logger(LOG, "createConnectionAssignment")
                .serviceDetails(
                        "GoldenGate",
                        "CreateConnectionAssignment",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/ConnectionAssignment/CreateConnectionAssignment")
                .method(com.oracle.bmc.http.client.Method.POST)
                .requestBuilder(CreateConnectionAssignmentRequest::builder)
                .basePath("/20200407")
                .appendPathParam("connectionAssignments")
                .accept("application/json")
                .appendHeader("opc-retry-token", request.getOpcRetryToken())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .hasBody()
                .handleBody(
                        com.oracle.bmc.goldengate.model.ConnectionAssignment.class,
                        CreateConnectionAssignmentResponse.Builder::connectionAssignment)
                .handleResponseHeaderString(
                        "opc-work-request-id",
                        CreateConnectionAssignmentResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", CreateConnectionAssignmentResponse.Builder::opcRequestId)
                .handleResponseHeaderString(
                        "etag", CreateConnectionAssignmentResponse.Builder::etag)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<CreateDatabaseRegistrationResponse>
            createDatabaseRegistration(
                    CreateDatabaseRegistrationRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    CreateDatabaseRegistrationRequest,
                                    CreateDatabaseRegistrationResponse>
                            handler) {
        Objects.requireNonNull(
                request.getCreateDatabaseRegistrationDetails(),
                "createDatabaseRegistrationDetails is required");

        return clientCall(request, CreateDatabaseRegistrationResponse::builder)
                .logger(LOG, "createDatabaseRegistration")
                .serviceDetails(
                        "GoldenGate",
                        "CreateDatabaseRegistration",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/DatabaseRegistration/CreateDatabaseRegistration")
                .method(com.oracle.bmc.http.client.Method.POST)
                .requestBuilder(CreateDatabaseRegistrationRequest::builder)
                .basePath("/20200407")
                .appendPathParam("databaseRegistrations")
                .accept("application/json")
                .appendHeader("opc-retry-token", request.getOpcRetryToken())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .hasBody()
                .handleBody(
                        com.oracle.bmc.goldengate.model.DatabaseRegistration.class,
                        CreateDatabaseRegistrationResponse.Builder::databaseRegistration)
                .handleResponseHeaderString(
                        "opc-work-request-id",
                        CreateDatabaseRegistrationResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", CreateDatabaseRegistrationResponse.Builder::opcRequestId)
                .handleResponseHeaderString(
                        "etag", CreateDatabaseRegistrationResponse.Builder::etag)
                .handleResponseHeaderString(
                        "sunset", CreateDatabaseRegistrationResponse.Builder::sunset)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<CreateDeploymentResponse> createDeployment(
            CreateDeploymentRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            CreateDeploymentRequest, CreateDeploymentResponse>
                    handler) {
        Objects.requireNonNull(
                request.getCreateDeploymentDetails(), "createDeploymentDetails is required");

        return clientCall(request, CreateDeploymentResponse::builder)
                .logger(LOG, "createDeployment")
                .serviceDetails(
                        "GoldenGate",
                        "CreateDeployment",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/Deployment/CreateDeployment")
                .method(com.oracle.bmc.http.client.Method.POST)
                .requestBuilder(CreateDeploymentRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deployments")
                .accept("application/json")
                .appendHeader("opc-retry-token", request.getOpcRetryToken())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .hasBody()
                .handleBody(
                        com.oracle.bmc.goldengate.model.Deployment.class,
                        CreateDeploymentResponse.Builder::deployment)
                .handleResponseHeaderString(
                        "opc-work-request-id", CreateDeploymentResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", CreateDeploymentResponse.Builder::opcRequestId)
                .handleResponseHeaderString("etag", CreateDeploymentResponse.Builder::etag)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<CreateDeploymentBackupResponse> createDeploymentBackup(
            CreateDeploymentBackupRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            CreateDeploymentBackupRequest, CreateDeploymentBackupResponse>
                    handler) {
        Objects.requireNonNull(
                request.getCreateDeploymentBackupDetails(),
                "createDeploymentBackupDetails is required");

        return clientCall(request, CreateDeploymentBackupResponse::builder)
                .logger(LOG, "createDeploymentBackup")
                .serviceDetails(
                        "GoldenGate",
                        "CreateDeploymentBackup",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/DeploymentBackup/CreateDeploymentBackup")
                .method(com.oracle.bmc.http.client.Method.POST)
                .requestBuilder(CreateDeploymentBackupRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deploymentBackups")
                .accept("application/json")
                .appendHeader("opc-retry-token", request.getOpcRetryToken())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .hasBody()
                .handleResponseHeaderString(
                        "opc-work-request-id",
                        CreateDeploymentBackupResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", CreateDeploymentBackupResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<DeleteConnectionResponse> deleteConnection(
            DeleteConnectionRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            DeleteConnectionRequest, DeleteConnectionResponse>
                    handler) {

        Validate.notBlank(request.getConnectionId(), "connectionId must not be blank");

        return clientCall(request, DeleteConnectionResponse::builder)
                .logger(LOG, "deleteConnection")
                .serviceDetails(
                        "GoldenGate",
                        "DeleteConnection",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/Connection/DeleteConnection")
                .method(com.oracle.bmc.http.client.Method.DELETE)
                .requestBuilder(DeleteConnectionRequest::builder)
                .basePath("/20200407")
                .appendPathParam("connections")
                .appendPathParam(request.getConnectionId())
                .accept("application/json")
                .appendHeader("if-match", request.getIfMatch())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleResponseHeaderString(
                        "opc-work-request-id", DeleteConnectionResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", DeleteConnectionResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<DeleteConnectionAssignmentResponse>
            deleteConnectionAssignment(
                    DeleteConnectionAssignmentRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    DeleteConnectionAssignmentRequest,
                                    DeleteConnectionAssignmentResponse>
                            handler) {

        Validate.notBlank(
                request.getConnectionAssignmentId(), "connectionAssignmentId must not be blank");

        return clientCall(request, DeleteConnectionAssignmentResponse::builder)
                .logger(LOG, "deleteConnectionAssignment")
                .serviceDetails(
                        "GoldenGate",
                        "DeleteConnectionAssignment",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/ConnectionAssignment/DeleteConnectionAssignment")
                .method(com.oracle.bmc.http.client.Method.DELETE)
                .requestBuilder(DeleteConnectionAssignmentRequest::builder)
                .basePath("/20200407")
                .appendPathParam("connectionAssignments")
                .appendPathParam(request.getConnectionAssignmentId())
                .accept("application/json")
                .appendHeader("if-match", request.getIfMatch())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleResponseHeaderString(
                        "opc-work-request-id",
                        DeleteConnectionAssignmentResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", DeleteConnectionAssignmentResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<DeleteDatabaseRegistrationResponse>
            deleteDatabaseRegistration(
                    DeleteDatabaseRegistrationRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    DeleteDatabaseRegistrationRequest,
                                    DeleteDatabaseRegistrationResponse>
                            handler) {

        Validate.notBlank(
                request.getDatabaseRegistrationId(), "databaseRegistrationId must not be blank");

        return clientCall(request, DeleteDatabaseRegistrationResponse::builder)
                .logger(LOG, "deleteDatabaseRegistration")
                .serviceDetails(
                        "GoldenGate",
                        "DeleteDatabaseRegistration",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/DatabaseRegistration/DeleteDatabaseRegistration")
                .method(com.oracle.bmc.http.client.Method.DELETE)
                .requestBuilder(DeleteDatabaseRegistrationRequest::builder)
                .basePath("/20200407")
                .appendPathParam("databaseRegistrations")
                .appendPathParam(request.getDatabaseRegistrationId())
                .accept("application/json")
                .appendHeader("if-match", request.getIfMatch())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleResponseHeaderString(
                        "opc-work-request-id",
                        DeleteDatabaseRegistrationResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", DeleteDatabaseRegistrationResponse.Builder::opcRequestId)
                .handleResponseHeaderString(
                        "sunset", DeleteDatabaseRegistrationResponse.Builder::sunset)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<DeleteDeploymentResponse> deleteDeployment(
            DeleteDeploymentRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            DeleteDeploymentRequest, DeleteDeploymentResponse>
                    handler) {

        Validate.notBlank(request.getDeploymentId(), "deploymentId must not be blank");

        return clientCall(request, DeleteDeploymentResponse::builder)
                .logger(LOG, "deleteDeployment")
                .serviceDetails(
                        "GoldenGate",
                        "DeleteDeployment",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/Deployment/DeleteDeployment")
                .method(com.oracle.bmc.http.client.Method.DELETE)
                .requestBuilder(DeleteDeploymentRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deployments")
                .appendPathParam(request.getDeploymentId())
                .accept("application/json")
                .appendHeader("if-match", request.getIfMatch())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleResponseHeaderString(
                        "opc-work-request-id", DeleteDeploymentResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", DeleteDeploymentResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<DeleteDeploymentBackupResponse> deleteDeploymentBackup(
            DeleteDeploymentBackupRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            DeleteDeploymentBackupRequest, DeleteDeploymentBackupResponse>
                    handler) {

        Validate.notBlank(request.getDeploymentBackupId(), "deploymentBackupId must not be blank");

        return clientCall(request, DeleteDeploymentBackupResponse::builder)
                .logger(LOG, "deleteDeploymentBackup")
                .serviceDetails(
                        "GoldenGate",
                        "DeleteDeploymentBackup",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/DeploymentBackup/DeleteDeploymentBackup")
                .method(com.oracle.bmc.http.client.Method.DELETE)
                .requestBuilder(DeleteDeploymentBackupRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deploymentBackups")
                .appendPathParam(request.getDeploymentBackupId())
                .accept("application/json")
                .appendHeader("if-match", request.getIfMatch())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleResponseHeaderString(
                        "opc-work-request-id",
                        DeleteDeploymentBackupResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", DeleteDeploymentBackupResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<GetConnectionResponse> getConnection(
            GetConnectionRequest request,
            final com.oracle.bmc.responses.AsyncHandler<GetConnectionRequest, GetConnectionResponse>
                    handler) {

        Validate.notBlank(request.getConnectionId(), "connectionId must not be blank");

        return clientCall(request, GetConnectionResponse::builder)
                .logger(LOG, "getConnection")
                .serviceDetails(
                        "GoldenGate",
                        "GetConnection",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/Connection/GetConnection")
                .method(com.oracle.bmc.http.client.Method.GET)
                .requestBuilder(GetConnectionRequest::builder)
                .basePath("/20200407")
                .appendPathParam("connections")
                .appendPathParam(request.getConnectionId())
                .accept("application/json")
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleBody(
                        com.oracle.bmc.goldengate.model.Connection.class,
                        GetConnectionResponse.Builder::connection)
                .handleResponseHeaderString("etag", GetConnectionResponse.Builder::etag)
                .handleResponseHeaderString(
                        "opc-request-id", GetConnectionResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<GetConnectionAssignmentResponse> getConnectionAssignment(
            GetConnectionAssignmentRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            GetConnectionAssignmentRequest, GetConnectionAssignmentResponse>
                    handler) {

        Validate.notBlank(
                request.getConnectionAssignmentId(), "connectionAssignmentId must not be blank");

        return clientCall(request, GetConnectionAssignmentResponse::builder)
                .logger(LOG, "getConnectionAssignment")
                .serviceDetails(
                        "GoldenGate",
                        "GetConnectionAssignment",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/ConnectionAssignment/GetConnectionAssignment")
                .method(com.oracle.bmc.http.client.Method.GET)
                .requestBuilder(GetConnectionAssignmentRequest::builder)
                .basePath("/20200407")
                .appendPathParam("connectionAssignments")
                .appendPathParam(request.getConnectionAssignmentId())
                .accept("application/json")
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleBody(
                        com.oracle.bmc.goldengate.model.ConnectionAssignment.class,
                        GetConnectionAssignmentResponse.Builder::connectionAssignment)
                .handleResponseHeaderString("etag", GetConnectionAssignmentResponse.Builder::etag)
                .handleResponseHeaderString(
                        "opc-request-id", GetConnectionAssignmentResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<GetDatabaseRegistrationResponse> getDatabaseRegistration(
            GetDatabaseRegistrationRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            GetDatabaseRegistrationRequest, GetDatabaseRegistrationResponse>
                    handler) {

        Validate.notBlank(
                request.getDatabaseRegistrationId(), "databaseRegistrationId must not be blank");

        return clientCall(request, GetDatabaseRegistrationResponse::builder)
                .logger(LOG, "getDatabaseRegistration")
                .serviceDetails(
                        "GoldenGate",
                        "GetDatabaseRegistration",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/DatabaseRegistration/GetDatabaseRegistration")
                .method(com.oracle.bmc.http.client.Method.GET)
                .requestBuilder(GetDatabaseRegistrationRequest::builder)
                .basePath("/20200407")
                .appendPathParam("databaseRegistrations")
                .appendPathParam(request.getDatabaseRegistrationId())
                .accept("application/json")
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleBody(
                        com.oracle.bmc.goldengate.model.DatabaseRegistration.class,
                        GetDatabaseRegistrationResponse.Builder::databaseRegistration)
                .handleResponseHeaderString("etag", GetDatabaseRegistrationResponse.Builder::etag)
                .handleResponseHeaderString(
                        "opc-request-id", GetDatabaseRegistrationResponse.Builder::opcRequestId)
                .handleResponseHeaderString(
                        "sunset", GetDatabaseRegistrationResponse.Builder::sunset)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<GetDeploymentResponse> getDeployment(
            GetDeploymentRequest request,
            final com.oracle.bmc.responses.AsyncHandler<GetDeploymentRequest, GetDeploymentResponse>
                    handler) {

        Validate.notBlank(request.getDeploymentId(), "deploymentId must not be blank");

        return clientCall(request, GetDeploymentResponse::builder)
                .logger(LOG, "getDeployment")
                .serviceDetails(
                        "GoldenGate",
                        "GetDeployment",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/Deployment/GetDeployment")
                .method(com.oracle.bmc.http.client.Method.GET)
                .requestBuilder(GetDeploymentRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deployments")
                .appendPathParam(request.getDeploymentId())
                .accept("application/json")
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleBody(
                        com.oracle.bmc.goldengate.model.Deployment.class,
                        GetDeploymentResponse.Builder::deployment)
                .handleResponseHeaderString("etag", GetDeploymentResponse.Builder::etag)
                .handleResponseHeaderString(
                        "opc-request-id", GetDeploymentResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<GetDeploymentBackupResponse> getDeploymentBackup(
            GetDeploymentBackupRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            GetDeploymentBackupRequest, GetDeploymentBackupResponse>
                    handler) {

        Validate.notBlank(request.getDeploymentBackupId(), "deploymentBackupId must not be blank");

        return clientCall(request, GetDeploymentBackupResponse::builder)
                .logger(LOG, "getDeploymentBackup")
                .serviceDetails(
                        "GoldenGate",
                        "GetDeploymentBackup",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/DeploymentBackup/GetDeploymentBackup")
                .method(com.oracle.bmc.http.client.Method.GET)
                .requestBuilder(GetDeploymentBackupRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deploymentBackups")
                .appendPathParam(request.getDeploymentBackupId())
                .accept("application/json")
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleBody(
                        com.oracle.bmc.goldengate.model.DeploymentBackup.class,
                        GetDeploymentBackupResponse.Builder::deploymentBackup)
                .handleResponseHeaderString("etag", GetDeploymentBackupResponse.Builder::etag)
                .handleResponseHeaderString(
                        "opc-request-id", GetDeploymentBackupResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<GetDeploymentUpgradeResponse> getDeploymentUpgrade(
            GetDeploymentUpgradeRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            GetDeploymentUpgradeRequest, GetDeploymentUpgradeResponse>
                    handler) {

        Validate.notBlank(
                request.getDeploymentUpgradeId(), "deploymentUpgradeId must not be blank");

        return clientCall(request, GetDeploymentUpgradeResponse::builder)
                .logger(LOG, "getDeploymentUpgrade")
                .serviceDetails(
                        "GoldenGate",
                        "GetDeploymentUpgrade",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/DeploymentUpgrade/GetDeploymentUpgrade")
                .method(com.oracle.bmc.http.client.Method.GET)
                .requestBuilder(GetDeploymentUpgradeRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deploymentUpgrades")
                .appendPathParam(request.getDeploymentUpgradeId())
                .accept("application/json")
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleBody(
                        com.oracle.bmc.goldengate.model.DeploymentUpgrade.class,
                        GetDeploymentUpgradeResponse.Builder::deploymentUpgrade)
                .handleResponseHeaderString("etag", GetDeploymentUpgradeResponse.Builder::etag)
                .handleResponseHeaderString(
                        "opc-request-id", GetDeploymentUpgradeResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<GetWorkRequestResponse> getWorkRequest(
            GetWorkRequestRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            GetWorkRequestRequest, GetWorkRequestResponse>
                    handler) {

        Validate.notBlank(request.getWorkRequestId(), "workRequestId must not be blank");

        return clientCall(request, GetWorkRequestResponse::builder)
                .logger(LOG, "getWorkRequest")
                .serviceDetails(
                        "GoldenGate",
                        "GetWorkRequest",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/WorkRequest/GetWorkRequest")
                .method(com.oracle.bmc.http.client.Method.GET)
                .requestBuilder(GetWorkRequestRequest::builder)
                .basePath("/20200407")
                .appendPathParam("workRequests")
                .appendPathParam(request.getWorkRequestId())
                .accept("application/json")
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleBody(
                        com.oracle.bmc.goldengate.model.WorkRequest.class,
                        GetWorkRequestResponse.Builder::workRequest)
                .handleResponseHeaderString(
                        "opc-request-id", GetWorkRequestResponse.Builder::opcRequestId)
                .handleResponseHeaderInteger(
                        "retry-after", GetWorkRequestResponse.Builder::retryAfter)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<ListConnectionAssignmentsResponse> listConnectionAssignments(
            ListConnectionAssignmentsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListConnectionAssignmentsRequest, ListConnectionAssignmentsResponse>
                    handler) {
        Objects.requireNonNull(request.getCompartmentId(), "compartmentId is required");

        return clientCall(request, ListConnectionAssignmentsResponse::builder)
                .logger(LOG, "listConnectionAssignments")
                .serviceDetails(
                        "GoldenGate",
                        "ListConnectionAssignments",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/ConnectionAssignment/ListConnectionAssignments")
                .method(com.oracle.bmc.http.client.Method.GET)
                .requestBuilder(ListConnectionAssignmentsRequest::builder)
                .basePath("/20200407")
                .appendPathParam("connectionAssignments")
                .appendQueryParam("compartmentId", request.getCompartmentId())
                .appendQueryParam("deploymentId", request.getDeploymentId())
                .appendQueryParam("connectionId", request.getConnectionId())
                .appendQueryParam("name", request.getName())
                .appendEnumQueryParam("lifecycleState", request.getLifecycleState())
                .appendQueryParam("limit", request.getLimit())
                .appendQueryParam("page", request.getPage())
                .appendEnumQueryParam("sortOrder", request.getSortOrder())
                .appendEnumQueryParam("sortBy", request.getSortBy())
                .accept("application/json")
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleBody(
                        com.oracle.bmc.goldengate.model.ConnectionAssignmentCollection.class,
                        ListConnectionAssignmentsResponse.Builder::connectionAssignmentCollection)
                .handleResponseHeaderString(
                        "opc-request-id", ListConnectionAssignmentsResponse.Builder::opcRequestId)
                .handleResponseHeaderString(
                        "opc-next-page", ListConnectionAssignmentsResponse.Builder::opcNextPage)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<ListConnectionsResponse> listConnections(
            ListConnectionsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListConnectionsRequest, ListConnectionsResponse>
                    handler) {
        Objects.requireNonNull(request.getCompartmentId(), "compartmentId is required");

        return clientCall(request, ListConnectionsResponse::builder)
                .logger(LOG, "listConnections")
                .serviceDetails(
                        "GoldenGate",
                        "ListConnections",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/Connection/ListConnections")
                .method(com.oracle.bmc.http.client.Method.GET)
                .requestBuilder(ListConnectionsRequest::builder)
                .basePath("/20200407")
                .appendPathParam("connections")
                .appendQueryParam("compartmentId", request.getCompartmentId())
                .appendListQueryParam(
                        "technologyType",
                        request.getTechnologyType(),
                        com.oracle.bmc.util.internal.CollectionFormatType.Multi)
                .appendListQueryParam(
                        "connectionType",
                        request.getConnectionType(),
                        com.oracle.bmc.util.internal.CollectionFormatType.Multi)
                .appendQueryParam("assignedDeploymentId", request.getAssignedDeploymentId())
                .appendQueryParam("assignableDeploymentId", request.getAssignableDeploymentId())
                .appendEnumQueryParam(
                        "assignableDeploymentType", request.getAssignableDeploymentType())
                .appendEnumQueryParam("lifecycleState", request.getLifecycleState())
                .appendQueryParam("displayName", request.getDisplayName())
                .appendQueryParam("limit", request.getLimit())
                .appendQueryParam("page", request.getPage())
                .appendEnumQueryParam("sortOrder", request.getSortOrder())
                .appendEnumQueryParam("sortBy", request.getSortBy())
                .accept("application/json")
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleBody(
                        com.oracle.bmc.goldengate.model.ConnectionCollection.class,
                        ListConnectionsResponse.Builder::connectionCollection)
                .handleResponseHeaderString(
                        "opc-request-id", ListConnectionsResponse.Builder::opcRequestId)
                .handleResponseHeaderString(
                        "opc-next-page", ListConnectionsResponse.Builder::opcNextPage)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<ListDatabaseRegistrationsResponse> listDatabaseRegistrations(
            ListDatabaseRegistrationsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListDatabaseRegistrationsRequest, ListDatabaseRegistrationsResponse>
                    handler) {
        Objects.requireNonNull(request.getCompartmentId(), "compartmentId is required");

        return clientCall(request, ListDatabaseRegistrationsResponse::builder)
                .logger(LOG, "listDatabaseRegistrations")
                .serviceDetails(
                        "GoldenGate",
                        "ListDatabaseRegistrations",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/DatabaseRegistration/ListDatabaseRegistrations")
                .method(com.oracle.bmc.http.client.Method.GET)
                .requestBuilder(ListDatabaseRegistrationsRequest::builder)
                .basePath("/20200407")
                .appendPathParam("databaseRegistrations")
                .appendQueryParam("compartmentId", request.getCompartmentId())
                .appendEnumQueryParam("lifecycleState", request.getLifecycleState())
                .appendQueryParam("displayName", request.getDisplayName())
                .appendQueryParam("limit", request.getLimit())
                .appendQueryParam("page", request.getPage())
                .appendEnumQueryParam("sortOrder", request.getSortOrder())
                .appendEnumQueryParam("sortBy", request.getSortBy())
                .accept("application/json")
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleBody(
                        com.oracle.bmc.goldengate.model.DatabaseRegistrationCollection.class,
                        ListDatabaseRegistrationsResponse.Builder::databaseRegistrationCollection)
                .handleResponseHeaderString(
                        "opc-request-id", ListDatabaseRegistrationsResponse.Builder::opcRequestId)
                .handleResponseHeaderString(
                        "opc-next-page", ListDatabaseRegistrationsResponse.Builder::opcNextPage)
                .handleResponseHeaderString(
                        "sunset", ListDatabaseRegistrationsResponse.Builder::sunset)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<ListDeploymentBackupsResponse> listDeploymentBackups(
            ListDeploymentBackupsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListDeploymentBackupsRequest, ListDeploymentBackupsResponse>
                    handler) {
        Objects.requireNonNull(request.getCompartmentId(), "compartmentId is required");

        return clientCall(request, ListDeploymentBackupsResponse::builder)
                .logger(LOG, "listDeploymentBackups")
                .serviceDetails(
                        "GoldenGate",
                        "ListDeploymentBackups",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/DeploymentBackup/ListDeploymentBackups")
                .method(com.oracle.bmc.http.client.Method.GET)
                .requestBuilder(ListDeploymentBackupsRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deploymentBackups")
                .appendQueryParam("compartmentId", request.getCompartmentId())
                .appendQueryParam("deploymentId", request.getDeploymentId())
                .appendEnumQueryParam("lifecycleState", request.getLifecycleState())
                .appendQueryParam("displayName", request.getDisplayName())
                .appendQueryParam("limit", request.getLimit())
                .appendQueryParam("page", request.getPage())
                .appendEnumQueryParam("sortOrder", request.getSortOrder())
                .appendEnumQueryParam("sortBy", request.getSortBy())
                .accept("application/json")
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleBody(
                        com.oracle.bmc.goldengate.model.DeploymentBackupCollection.class,
                        ListDeploymentBackupsResponse.Builder::deploymentBackupCollection)
                .handleResponseHeaderString(
                        "opc-request-id", ListDeploymentBackupsResponse.Builder::opcRequestId)
                .handleResponseHeaderString(
                        "opc-next-page", ListDeploymentBackupsResponse.Builder::opcNextPage)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<ListDeploymentTypesResponse> listDeploymentTypes(
            ListDeploymentTypesRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListDeploymentTypesRequest, ListDeploymentTypesResponse>
                    handler) {
        Objects.requireNonNull(request.getCompartmentId(), "compartmentId is required");

        return clientCall(request, ListDeploymentTypesResponse::builder)
                .logger(LOG, "listDeploymentTypes")
                .serviceDetails(
                        "GoldenGate",
                        "ListDeploymentTypes",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/DeploymentTypeCollection/ListDeploymentTypes")
                .method(com.oracle.bmc.http.client.Method.GET)
                .requestBuilder(ListDeploymentTypesRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deploymentTypes")
                .appendQueryParam("compartmentId", request.getCompartmentId())
                .appendQueryParam("displayName", request.getDisplayName())
                .appendQueryParam("limit", request.getLimit())
                .appendQueryParam("page", request.getPage())
                .appendEnumQueryParam("sortOrder", request.getSortOrder())
                .appendEnumQueryParam("sortBy", request.getSortBy())
                .accept("application/json")
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleBody(
                        com.oracle.bmc.goldengate.model.DeploymentTypeCollection.class,
                        ListDeploymentTypesResponse.Builder::deploymentTypeCollection)
                .handleResponseHeaderString(
                        "opc-request-id", ListDeploymentTypesResponse.Builder::opcRequestId)
                .handleResponseHeaderString(
                        "opc-next-page", ListDeploymentTypesResponse.Builder::opcNextPage)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<ListDeploymentUpgradesResponse> listDeploymentUpgrades(
            ListDeploymentUpgradesRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListDeploymentUpgradesRequest, ListDeploymentUpgradesResponse>
                    handler) {
        Objects.requireNonNull(request.getCompartmentId(), "compartmentId is required");

        return clientCall(request, ListDeploymentUpgradesResponse::builder)
                .logger(LOG, "listDeploymentUpgrades")
                .serviceDetails(
                        "GoldenGate",
                        "ListDeploymentUpgrades",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/DeploymentUpgrade/ListDeploymentUpgrades")
                .method(com.oracle.bmc.http.client.Method.GET)
                .requestBuilder(ListDeploymentUpgradesRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deploymentUpgrades")
                .appendQueryParam("compartmentId", request.getCompartmentId())
                .appendQueryParam("deploymentId", request.getDeploymentId())
                .appendEnumQueryParam("lifecycleState", request.getLifecycleState())
                .appendQueryParam("displayName", request.getDisplayName())
                .appendQueryParam("limit", request.getLimit())
                .appendQueryParam("page", request.getPage())
                .appendEnumQueryParam("sortOrder", request.getSortOrder())
                .appendEnumQueryParam("sortBy", request.getSortBy())
                .accept("application/json")
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleBody(
                        com.oracle.bmc.goldengate.model.DeploymentUpgradeCollection.class,
                        ListDeploymentUpgradesResponse.Builder::deploymentUpgradeCollection)
                .handleResponseHeaderString(
                        "opc-request-id", ListDeploymentUpgradesResponse.Builder::opcRequestId)
                .handleResponseHeaderString(
                        "opc-next-page", ListDeploymentUpgradesResponse.Builder::opcNextPage)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<ListDeploymentsResponse> listDeployments(
            ListDeploymentsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListDeploymentsRequest, ListDeploymentsResponse>
                    handler) {
        Objects.requireNonNull(request.getCompartmentId(), "compartmentId is required");

        return clientCall(request, ListDeploymentsResponse::builder)
                .logger(LOG, "listDeployments")
                .serviceDetails(
                        "GoldenGate",
                        "ListDeployments",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/Deployment/ListDeployments")
                .method(com.oracle.bmc.http.client.Method.GET)
                .requestBuilder(ListDeploymentsRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deployments")
                .appendQueryParam("compartmentId", request.getCompartmentId())
                .appendEnumQueryParam(
                        "supportedConnectionType", request.getSupportedConnectionType())
                .appendQueryParam("assignedConnectionId", request.getAssignedConnectionId())
                .appendQueryParam("assignableConnectionId", request.getAssignableConnectionId())
                .appendEnumQueryParam("lifecycleState", request.getLifecycleState())
                .appendEnumQueryParam("lifecycleSubState", request.getLifecycleSubState())
                .appendQueryParam("displayName", request.getDisplayName())
                .appendQueryParam("fqdn", request.getFqdn())
                .appendQueryParam("limit", request.getLimit())
                .appendQueryParam("page", request.getPage())
                .appendEnumQueryParam("sortOrder", request.getSortOrder())
                .appendEnumQueryParam("sortBy", request.getSortBy())
                .accept("application/json")
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleBody(
                        com.oracle.bmc.goldengate.model.DeploymentCollection.class,
                        ListDeploymentsResponse.Builder::deploymentCollection)
                .handleResponseHeaderString(
                        "opc-request-id", ListDeploymentsResponse.Builder::opcRequestId)
                .handleResponseHeaderString(
                        "opc-next-page", ListDeploymentsResponse.Builder::opcNextPage)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<ListMessagesResponse> listMessages(
            ListMessagesRequest request,
            final com.oracle.bmc.responses.AsyncHandler<ListMessagesRequest, ListMessagesResponse>
                    handler) {
        Objects.requireNonNull(request.getDeploymentId(), "deploymentId is required");

        return clientCall(request, ListMessagesResponse::builder)
                .logger(LOG, "listMessages")
                .serviceDetails(
                        "GoldenGate",
                        "ListMessages",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/MessageSummary/ListMessages")
                .method(com.oracle.bmc.http.client.Method.GET)
                .requestBuilder(ListMessagesRequest::builder)
                .basePath("/20200407")
                .appendPathParam("messages")
                .appendQueryParam("deploymentId", request.getDeploymentId())
                .appendQueryParam("limit", request.getLimit())
                .appendQueryParam("page", request.getPage())
                .accept("application/json")
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleBody(
                        com.oracle.bmc.goldengate.model.DeploymentMessageCollection.class,
                        ListMessagesResponse.Builder::deploymentMessageCollection)
                .handleResponseHeaderString(
                        "opc-request-id", ListMessagesResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<ListTrailFilesResponse> listTrailFiles(
            ListTrailFilesRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListTrailFilesRequest, ListTrailFilesResponse>
                    handler) {
        Objects.requireNonNull(request.getDeploymentId(), "deploymentId is required");

        return clientCall(request, ListTrailFilesResponse::builder)
                .logger(LOG, "listTrailFiles")
                .serviceDetails(
                        "GoldenGate",
                        "ListTrailFiles",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/TrailFileSummary/ListTrailFiles")
                .method(com.oracle.bmc.http.client.Method.GET)
                .requestBuilder(ListTrailFilesRequest::builder)
                .basePath("/20200407")
                .appendPathParam("trailFiles")
                .appendQueryParam("deploymentId", request.getDeploymentId())
                .appendQueryParam("displayName", request.getDisplayName())
                .appendQueryParam("trailFileId", request.getTrailFileId())
                .appendQueryParam("limit", request.getLimit())
                .appendQueryParam("page", request.getPage())
                .appendEnumQueryParam("sortBy", request.getSortBy())
                .appendEnumQueryParam("sortOrder", request.getSortOrder())
                .accept("application/json")
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleBody(
                        com.oracle.bmc.goldengate.model.TrailFileCollection.class,
                        ListTrailFilesResponse.Builder::trailFileCollection)
                .handleResponseHeaderString(
                        "opc-request-id", ListTrailFilesResponse.Builder::opcRequestId)
                .handleResponseHeaderString(
                        "opc-next-page", ListTrailFilesResponse.Builder::opcNextPage)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<ListTrailSequencesResponse> listTrailSequences(
            ListTrailSequencesRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListTrailSequencesRequest, ListTrailSequencesResponse>
                    handler) {
        Objects.requireNonNull(request.getDeploymentId(), "deploymentId is required");

        Objects.requireNonNull(request.getTrailFileId(), "trailFileId is required");

        return clientCall(request, ListTrailSequencesResponse::builder)
                .logger(LOG, "listTrailSequences")
                .serviceDetails(
                        "GoldenGate",
                        "ListTrailSequences",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/TrailSequenceSummary/ListTrailSequences")
                .method(com.oracle.bmc.http.client.Method.GET)
                .requestBuilder(ListTrailSequencesRequest::builder)
                .basePath("/20200407")
                .appendPathParam("trailSequences")
                .appendQueryParam("deploymentId", request.getDeploymentId())
                .appendQueryParam("trailFileId", request.getTrailFileId())
                .appendQueryParam("trailSequenceId", request.getTrailSequenceId())
                .appendQueryParam("displayName", request.getDisplayName())
                .appendQueryParam("limit", request.getLimit())
                .appendQueryParam("page", request.getPage())
                .appendEnumQueryParam("sortBy", request.getSortBy())
                .appendEnumQueryParam("sortOrder", request.getSortOrder())
                .accept("application/json")
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleBody(
                        com.oracle.bmc.goldengate.model.TrailSequenceCollection.class,
                        ListTrailSequencesResponse.Builder::trailSequenceCollection)
                .handleResponseHeaderString(
                        "opc-request-id", ListTrailSequencesResponse.Builder::opcRequestId)
                .handleResponseHeaderString(
                        "opc-next-page", ListTrailSequencesResponse.Builder::opcNextPage)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<ListWorkRequestErrorsResponse> listWorkRequestErrors(
            ListWorkRequestErrorsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListWorkRequestErrorsRequest, ListWorkRequestErrorsResponse>
                    handler) {

        Validate.notBlank(request.getWorkRequestId(), "workRequestId must not be blank");

        return clientCall(request, ListWorkRequestErrorsResponse::builder)
                .logger(LOG, "listWorkRequestErrors")
                .serviceDetails(
                        "GoldenGate",
                        "ListWorkRequestErrors",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/WorkRequestError/ListWorkRequestErrors")
                .method(com.oracle.bmc.http.client.Method.GET)
                .requestBuilder(ListWorkRequestErrorsRequest::builder)
                .basePath("/20200407")
                .appendPathParam("workRequests")
                .appendPathParam(request.getWorkRequestId())
                .appendPathParam("errors")
                .appendQueryParam("page", request.getPage())
                .appendQueryParam("limit", request.getLimit())
                .accept("application/json")
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleBodyList(
                        com.oracle.bmc.goldengate.model.WorkRequestError.class,
                        ListWorkRequestErrorsResponse.Builder::items)
                .handleResponseHeaderString(
                        "opc-next-page", ListWorkRequestErrorsResponse.Builder::opcNextPage)
                .handleResponseHeaderString(
                        "opc-request-id", ListWorkRequestErrorsResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<ListWorkRequestLogsResponse> listWorkRequestLogs(
            ListWorkRequestLogsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListWorkRequestLogsRequest, ListWorkRequestLogsResponse>
                    handler) {

        Validate.notBlank(request.getWorkRequestId(), "workRequestId must not be blank");

        return clientCall(request, ListWorkRequestLogsResponse::builder)
                .logger(LOG, "listWorkRequestLogs")
                .serviceDetails(
                        "GoldenGate",
                        "ListWorkRequestLogs",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/WorkRequestLogEntry/ListWorkRequestLogs")
                .method(com.oracle.bmc.http.client.Method.GET)
                .requestBuilder(ListWorkRequestLogsRequest::builder)
                .basePath("/20200407")
                .appendPathParam("workRequests")
                .appendPathParam(request.getWorkRequestId())
                .appendPathParam("logs")
                .appendQueryParam("page", request.getPage())
                .appendQueryParam("limit", request.getLimit())
                .accept("application/json")
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleBodyList(
                        com.oracle.bmc.goldengate.model.WorkRequestLogEntry.class,
                        ListWorkRequestLogsResponse.Builder::items)
                .handleResponseHeaderString(
                        "opc-next-page", ListWorkRequestLogsResponse.Builder::opcNextPage)
                .handleResponseHeaderString(
                        "opc-request-id", ListWorkRequestLogsResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<ListWorkRequestsResponse> listWorkRequests(
            ListWorkRequestsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListWorkRequestsRequest, ListWorkRequestsResponse>
                    handler) {
        Objects.requireNonNull(request.getCompartmentId(), "compartmentId is required");

        return clientCall(request, ListWorkRequestsResponse::builder)
                .logger(LOG, "listWorkRequests")
                .serviceDetails(
                        "GoldenGate",
                        "ListWorkRequests",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/WorkRequest/ListWorkRequests")
                .method(com.oracle.bmc.http.client.Method.GET)
                .requestBuilder(ListWorkRequestsRequest::builder)
                .basePath("/20200407")
                .appendPathParam("workRequests")
                .appendQueryParam("compartmentId", request.getCompartmentId())
                .appendQueryParam("resourceId", request.getResourceId())
                .appendQueryParam("page", request.getPage())
                .appendQueryParam("limit", request.getLimit())
                .accept("application/json")
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .handleBodyList(
                        com.oracle.bmc.goldengate.model.WorkRequest.class,
                        ListWorkRequestsResponse.Builder::items)
                .handleResponseHeaderString(
                        "opc-request-id", ListWorkRequestsResponse.Builder::opcRequestId)
                .handleResponseHeaderString(
                        "opc-next-page", ListWorkRequestsResponse.Builder::opcNextPage)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<RestoreDeploymentResponse> restoreDeployment(
            RestoreDeploymentRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            RestoreDeploymentRequest, RestoreDeploymentResponse>
                    handler) {

        Validate.notBlank(request.getDeploymentBackupId(), "deploymentBackupId must not be blank");
        Objects.requireNonNull(
                request.getRestoreDeploymentDetails(), "restoreDeploymentDetails is required");

        return clientCall(request, RestoreDeploymentResponse::builder)
                .logger(LOG, "restoreDeployment")
                .serviceDetails(
                        "GoldenGate",
                        "RestoreDeployment",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/DeploymentBackup/RestoreDeployment")
                .method(com.oracle.bmc.http.client.Method.POST)
                .requestBuilder(RestoreDeploymentRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deploymentBackups")
                .appendPathParam(request.getDeploymentBackupId())
                .appendPathParam("actions")
                .appendPathParam("restore")
                .accept("application/json")
                .appendHeader("if-match", request.getIfMatch())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .appendHeader("opc-retry-token", request.getOpcRetryToken())
                .hasBody()
                .handleResponseHeaderString(
                        "opc-work-request-id", RestoreDeploymentResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", RestoreDeploymentResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<StartDeploymentResponse> startDeployment(
            StartDeploymentRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            StartDeploymentRequest, StartDeploymentResponse>
                    handler) {

        Validate.notBlank(request.getDeploymentId(), "deploymentId must not be blank");
        Objects.requireNonNull(
                request.getStartDeploymentDetails(), "startDeploymentDetails is required");

        return clientCall(request, StartDeploymentResponse::builder)
                .logger(LOG, "startDeployment")
                .serviceDetails(
                        "GoldenGate",
                        "StartDeployment",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/Deployment/StartDeployment")
                .method(com.oracle.bmc.http.client.Method.POST)
                .requestBuilder(StartDeploymentRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deployments")
                .appendPathParam(request.getDeploymentId())
                .appendPathParam("actions")
                .appendPathParam("start")
                .accept("application/json")
                .appendHeader("if-match", request.getIfMatch())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .appendHeader("opc-retry-token", request.getOpcRetryToken())
                .hasBody()
                .handleResponseHeaderString(
                        "opc-work-request-id", StartDeploymentResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", StartDeploymentResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<StopDeploymentResponse> stopDeployment(
            StopDeploymentRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            StopDeploymentRequest, StopDeploymentResponse>
                    handler) {

        Validate.notBlank(request.getDeploymentId(), "deploymentId must not be blank");
        Objects.requireNonNull(
                request.getStopDeploymentDetails(), "stopDeploymentDetails is required");

        return clientCall(request, StopDeploymentResponse::builder)
                .logger(LOG, "stopDeployment")
                .serviceDetails(
                        "GoldenGate",
                        "StopDeployment",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/Deployment/StopDeployment")
                .method(com.oracle.bmc.http.client.Method.POST)
                .requestBuilder(StopDeploymentRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deployments")
                .appendPathParam(request.getDeploymentId())
                .appendPathParam("actions")
                .appendPathParam("stop")
                .accept("application/json")
                .appendHeader("if-match", request.getIfMatch())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .appendHeader("opc-retry-token", request.getOpcRetryToken())
                .hasBody()
                .handleResponseHeaderString(
                        "opc-work-request-id", StopDeploymentResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", StopDeploymentResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<UpdateConnectionResponse> updateConnection(
            UpdateConnectionRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            UpdateConnectionRequest, UpdateConnectionResponse>
                    handler) {

        Validate.notBlank(request.getConnectionId(), "connectionId must not be blank");
        Objects.requireNonNull(
                request.getUpdateConnectionDetails(), "updateConnectionDetails is required");

        return clientCall(request, UpdateConnectionResponse::builder)
                .logger(LOG, "updateConnection")
                .serviceDetails(
                        "GoldenGate",
                        "UpdateConnection",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/Connection/UpdateConnection")
                .method(com.oracle.bmc.http.client.Method.PUT)
                .requestBuilder(UpdateConnectionRequest::builder)
                .basePath("/20200407")
                .appendPathParam("connections")
                .appendPathParam(request.getConnectionId())
                .accept("application/json")
                .appendHeader("if-match", request.getIfMatch())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .hasBody()
                .handleResponseHeaderString(
                        "opc-work-request-id", UpdateConnectionResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", UpdateConnectionResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<UpdateDatabaseRegistrationResponse>
            updateDatabaseRegistration(
                    UpdateDatabaseRegistrationRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    UpdateDatabaseRegistrationRequest,
                                    UpdateDatabaseRegistrationResponse>
                            handler) {

        Validate.notBlank(
                request.getDatabaseRegistrationId(), "databaseRegistrationId must not be blank");
        Objects.requireNonNull(
                request.getUpdateDatabaseRegistrationDetails(),
                "updateDatabaseRegistrationDetails is required");

        return clientCall(request, UpdateDatabaseRegistrationResponse::builder)
                .logger(LOG, "updateDatabaseRegistration")
                .serviceDetails(
                        "GoldenGate",
                        "UpdateDatabaseRegistration",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/DatabaseRegistration/UpdateDatabaseRegistration")
                .method(com.oracle.bmc.http.client.Method.PUT)
                .requestBuilder(UpdateDatabaseRegistrationRequest::builder)
                .basePath("/20200407")
                .appendPathParam("databaseRegistrations")
                .appendPathParam(request.getDatabaseRegistrationId())
                .accept("application/json")
                .appendHeader("if-match", request.getIfMatch())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .hasBody()
                .handleResponseHeaderString(
                        "opc-work-request-id",
                        UpdateDatabaseRegistrationResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", UpdateDatabaseRegistrationResponse.Builder::opcRequestId)
                .handleResponseHeaderString(
                        "sunset", UpdateDatabaseRegistrationResponse.Builder::sunset)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<UpdateDeploymentResponse> updateDeployment(
            UpdateDeploymentRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            UpdateDeploymentRequest, UpdateDeploymentResponse>
                    handler) {

        Validate.notBlank(request.getDeploymentId(), "deploymentId must not be blank");
        Objects.requireNonNull(
                request.getUpdateDeploymentDetails(), "updateDeploymentDetails is required");

        return clientCall(request, UpdateDeploymentResponse::builder)
                .logger(LOG, "updateDeployment")
                .serviceDetails(
                        "GoldenGate",
                        "UpdateDeployment",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/Deployment/UpdateDeployment")
                .method(com.oracle.bmc.http.client.Method.PUT)
                .requestBuilder(UpdateDeploymentRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deployments")
                .appendPathParam(request.getDeploymentId())
                .accept("application/json")
                .appendHeader("if-match", request.getIfMatch())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .hasBody()
                .handleResponseHeaderString(
                        "opc-work-request-id", UpdateDeploymentResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", UpdateDeploymentResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<UpdateDeploymentBackupResponse> updateDeploymentBackup(
            UpdateDeploymentBackupRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            UpdateDeploymentBackupRequest, UpdateDeploymentBackupResponse>
                    handler) {

        Validate.notBlank(request.getDeploymentBackupId(), "deploymentBackupId must not be blank");
        Objects.requireNonNull(
                request.getUpdateDeploymentBackupDetails(),
                "updateDeploymentBackupDetails is required");

        return clientCall(request, UpdateDeploymentBackupResponse::builder)
                .logger(LOG, "updateDeploymentBackup")
                .serviceDetails(
                        "GoldenGate",
                        "UpdateDeploymentBackup",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/DeploymentBackup/UpdateDeploymentBackup")
                .method(com.oracle.bmc.http.client.Method.PUT)
                .requestBuilder(UpdateDeploymentBackupRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deploymentBackups")
                .appendPathParam(request.getDeploymentBackupId())
                .accept("application/json")
                .appendHeader("if-match", request.getIfMatch())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .hasBody()
                .handleBody(
                        com.oracle.bmc.goldengate.model.DeploymentBackup.class,
                        UpdateDeploymentBackupResponse.Builder::deploymentBackup)
                .handleResponseHeaderString("etag", UpdateDeploymentBackupResponse.Builder::etag)
                .handleResponseHeaderString(
                        "opc-request-id", UpdateDeploymentBackupResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    @Override
    public java.util.concurrent.Future<UpgradeDeploymentResponse> upgradeDeployment(
            UpgradeDeploymentRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            UpgradeDeploymentRequest, UpgradeDeploymentResponse>
                    handler) {

        Validate.notBlank(request.getDeploymentId(), "deploymentId must not be blank");
        Objects.requireNonNull(
                request.getUpgradeDeploymentDetails(), "upgradeDeploymentDetails is required");

        return clientCall(request, UpgradeDeploymentResponse::builder)
                .logger(LOG, "upgradeDeployment")
                .serviceDetails(
                        "GoldenGate",
                        "UpgradeDeployment",
                        "https://docs.oracle.com/iaas/api/#/en/goldengate/20200407/Deployment/UpgradeDeployment")
                .method(com.oracle.bmc.http.client.Method.POST)
                .requestBuilder(UpgradeDeploymentRequest::builder)
                .basePath("/20200407")
                .appendPathParam("deployments")
                .appendPathParam(request.getDeploymentId())
                .appendPathParam("actions")
                .appendPathParam("upgrade")
                .accept("application/json")
                .appendHeader("if-match", request.getIfMatch())
                .appendHeader("opc-request-id", request.getOpcRequestId())
                .appendHeader("opc-retry-token", request.getOpcRetryToken())
                .hasBody()
                .handleResponseHeaderString(
                        "opc-work-request-id", UpgradeDeploymentResponse.Builder::opcWorkRequestId)
                .handleResponseHeaderString(
                        "opc-request-id", UpgradeDeploymentResponse.Builder::opcRequestId)
                .callAsync(handler);
    }

    /**
     * Create a new client instance.
     *
     * @param authenticationDetailsProvider The authentication details (see {@link Builder#build})
     * @deprecated Use the {@link #builder() builder} instead.
     */
    @Deprecated
    public GoldenGateAsyncClient(
            com.oracle.bmc.auth.BasicAuthenticationDetailsProvider authenticationDetailsProvider) {
        this(builder(), authenticationDetailsProvider);
    }

    /**
     * Create a new client instance.
     *
     * @param authenticationDetailsProvider The authentication details (see {@link Builder#build})
     * @param configuration {@link Builder#configuration}
     * @deprecated Use the {@link #builder() builder} instead.
     */
    @Deprecated
    public GoldenGateAsyncClient(
            com.oracle.bmc.auth.BasicAuthenticationDetailsProvider authenticationDetailsProvider,
            com.oracle.bmc.ClientConfiguration configuration) {
        this(builder().configuration(configuration), authenticationDetailsProvider);
    }

    /**
     * Create a new client instance.
     *
     * @param authenticationDetailsProvider The authentication details (see {@link Builder#build})
     * @param configuration {@link Builder#configuration}
     * @param clientConfigurator {@link Builder#clientConfigurator}
     * @deprecated Use the {@link #builder() builder} instead.
     */
    @Deprecated
    public GoldenGateAsyncClient(
            com.oracle.bmc.auth.BasicAuthenticationDetailsProvider authenticationDetailsProvider,
            com.oracle.bmc.ClientConfiguration configuration,
            com.oracle.bmc.http.ClientConfigurator clientConfigurator) {
        this(
                builder().configuration(configuration).clientConfigurator(clientConfigurator),
                authenticationDetailsProvider);
    }

    /**
     * Create a new client instance.
     *
     * @param authenticationDetailsProvider The authentication details (see {@link Builder#build})
     * @param configuration {@link Builder#configuration}
     * @param clientConfigurator {@link Builder#clientConfigurator}
     * @param defaultRequestSignerFactory {@link Builder#requestSignerFactory}
     * @deprecated Use the {@link #builder() builder} instead.
     */
    @Deprecated
    public GoldenGateAsyncClient(
            com.oracle.bmc.auth.AbstractAuthenticationDetailsProvider authenticationDetailsProvider,
            com.oracle.bmc.ClientConfiguration configuration,
            com.oracle.bmc.http.ClientConfigurator clientConfigurator,
            com.oracle.bmc.http.signing.RequestSignerFactory defaultRequestSignerFactory) {
        this(
                builder()
                        .configuration(configuration)
                        .clientConfigurator(clientConfigurator)
                        .requestSignerFactory(defaultRequestSignerFactory),
                authenticationDetailsProvider);
    }

    /**
     * Create a new client instance.
     *
     * @param authenticationDetailsProvider The authentication details (see {@link Builder#build})
     * @param configuration {@link Builder#configuration}
     * @param clientConfigurator {@link Builder#clientConfigurator}
     * @param defaultRequestSignerFactory {@link Builder#requestSignerFactory}
     * @param additionalClientConfigurators {@link Builder#additionalClientConfigurators}
     * @deprecated Use the {@link #builder() builder} instead.
     */
    @Deprecated
    public GoldenGateAsyncClient(
            com.oracle.bmc.auth.AbstractAuthenticationDetailsProvider authenticationDetailsProvider,
            com.oracle.bmc.ClientConfiguration configuration,
            com.oracle.bmc.http.ClientConfigurator clientConfigurator,
            com.oracle.bmc.http.signing.RequestSignerFactory defaultRequestSignerFactory,
            java.util.List<com.oracle.bmc.http.ClientConfigurator> additionalClientConfigurators) {
        this(
                builder()
                        .configuration(configuration)
                        .clientConfigurator(clientConfigurator)
                        .requestSignerFactory(defaultRequestSignerFactory)
                        .additionalClientConfigurators(additionalClientConfigurators),
                authenticationDetailsProvider);
    }

    /**
     * Create a new client instance.
     *
     * @param authenticationDetailsProvider The authentication details (see {@link Builder#build})
     * @param configuration {@link Builder#configuration}
     * @param clientConfigurator {@link Builder#clientConfigurator}
     * @param defaultRequestSignerFactory {@link Builder#requestSignerFactory}
     * @param additionalClientConfigurators {@link Builder#additionalClientConfigurators}
     * @param endpoint {@link Builder#endpoint}
     * @deprecated Use the {@link #builder() builder} instead.
     */
    @Deprecated
    public GoldenGateAsyncClient(
            com.oracle.bmc.auth.AbstractAuthenticationDetailsProvider authenticationDetailsProvider,
            com.oracle.bmc.ClientConfiguration configuration,
            com.oracle.bmc.http.ClientConfigurator clientConfigurator,
            com.oracle.bmc.http.signing.RequestSignerFactory defaultRequestSignerFactory,
            java.util.List<com.oracle.bmc.http.ClientConfigurator> additionalClientConfigurators,
            String endpoint) {
        this(
                builder()
                        .configuration(configuration)
                        .clientConfigurator(clientConfigurator)
                        .requestSignerFactory(defaultRequestSignerFactory)
                        .additionalClientConfigurators(additionalClientConfigurators)
                        .endpoint(endpoint),
                authenticationDetailsProvider);
    }

    /**
     * Create a new client instance.
     *
     * @param authenticationDetailsProvider The authentication details (see {@link Builder#build})
     * @param configuration {@link Builder#configuration}
     * @param clientConfigurator {@link Builder#clientConfigurator}
     * @param defaultRequestSignerFactory {@link Builder#requestSignerFactory}
     * @param additionalClientConfigurators {@link Builder#additionalClientConfigurators}
     * @param endpoint {@link Builder#endpoint}
     * @param signingStrategyRequestSignerFactories {@link
     *     Builder#signingStrategyRequestSignerFactories}
     * @deprecated Use the {@link #builder() builder} instead.
     */
    @Deprecated
    public GoldenGateAsyncClient(
            com.oracle.bmc.auth.AbstractAuthenticationDetailsProvider authenticationDetailsProvider,
            com.oracle.bmc.ClientConfiguration configuration,
            com.oracle.bmc.http.ClientConfigurator clientConfigurator,
            com.oracle.bmc.http.signing.RequestSignerFactory defaultRequestSignerFactory,
            java.util.Map<
                            com.oracle.bmc.http.signing.SigningStrategy,
                            com.oracle.bmc.http.signing.RequestSignerFactory>
                    signingStrategyRequestSignerFactories,
            java.util.List<com.oracle.bmc.http.ClientConfigurator> additionalClientConfigurators,
            String endpoint) {
        this(
                builder()
                        .configuration(configuration)
                        .clientConfigurator(clientConfigurator)
                        .requestSignerFactory(defaultRequestSignerFactory)
                        .additionalClientConfigurators(additionalClientConfigurators)
                        .endpoint(endpoint)
                        .signingStrategyRequestSignerFactories(
                                signingStrategyRequestSignerFactories),
                authenticationDetailsProvider);
    }
}

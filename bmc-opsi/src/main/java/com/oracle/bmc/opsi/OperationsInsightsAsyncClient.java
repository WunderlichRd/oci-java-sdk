/**
 * Copyright (c) 2016, 2023, Oracle and/or its affiliates.  All rights reserved.
 * This software is dual-licensed to you under the Universal Permissive License (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License 2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose either license.
 */
package com.oracle.bmc.opsi;

import com.oracle.bmc.opsi.internal.http.*;
import com.oracle.bmc.opsi.requests.*;
import com.oracle.bmc.opsi.responses.*;

/**
 * Async client implementation for OperationsInsights service. <br/>
 * There are two ways to use async client:
 * 1. Use AsyncHandler: using AsyncHandler, if the response to the call is an {@link java.io.InputStream}, like
 * getObject Api in object storage service, developers need to process the stream in AsyncHandler, and not anywhere else,
 * because the stream will be closed right after the AsyncHandler is invoked. <br/>
 * 2. Use Java Future: using Java Future, developers need to close the stream after they are done with the Java Future.<br/>
 * Accessing the result should be done in a mutually exclusive manner, either through the Future or the AsyncHandler,
 * but not both.  If the Future is used, the caller should pass in null as the AsyncHandler.  If the AsyncHandler
 * is used, it is still safe to use the Future to determine whether or not the request was completed via
 * Future.isDone/isCancelled.<br/>
 * Please refer to https://github.com/oracle/oci-java-sdk/blob/master/bmc-examples/src/main/java/ResteasyClientWithObjectStorageExample.java
 */
@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20200630")
public class OperationsInsightsAsyncClient implements OperationsInsightsAsync {
    /**
     * Service instance for OperationsInsights.
     */
    public static final com.oracle.bmc.Service SERVICE =
            com.oracle.bmc.Services.serviceBuilder()
                    .serviceName("OPERATIONSINSIGHTS")
                    .serviceEndpointPrefix("")
                    .serviceEndpointTemplate(
                            "https://operationsinsights.{region}.oci.{secondLevelDomain}")
                    .build();

    private static final org.slf4j.Logger LOG =
            org.slf4j.LoggerFactory.getLogger(OperationsInsightsAsyncClient.class);

    private final com.oracle.bmc.auth.AbstractAuthenticationDetailsProvider
            authenticationDetailsProvider;

    private final org.glassfish.jersey.apache.connector.ApacheConnectionClosingStrategy
            apacheConnectionClosingStrategy;
    private final com.oracle.bmc.http.internal.RestClientFactory restClientFactory;
    private final com.oracle.bmc.http.signing.RequestSignerFactory defaultRequestSignerFactory;
    private final java.util.Map<
                    com.oracle.bmc.http.signing.SigningStrategy,
                    com.oracle.bmc.http.signing.RequestSignerFactory>
            signingStrategyRequestSignerFactories;
    private final boolean isNonBufferingApacheClient;
    private final com.oracle.bmc.ClientConfiguration clientConfigurationToUse;

    /**
     * Used to synchronize any updates on the `this.client` object.
     */
    private final Object clientUpdate = new Object();

    /**
     * Stores the actual client object used to make the API calls.
     * Note: This object can get refreshed periodically, hence it's important to keep any updates synchronized.
     *       For any writes to the object, please synchronize on `this.clientUpdate`.
     */
    private volatile com.oracle.bmc.http.internal.RestClient client;

    /**
     * Keeps track of the last endpoint that was assigned to the client, which in turn can be used when the client is refreshed.
     * Note: Always synchronize on `this.clientUpdate` when reading/writing this field.
     */
    private volatile String overrideEndpoint = null;

    /**
     * Creates a new service instance using the given authentication provider.
     * @param authenticationDetailsProvider The authentication details provider, required.
     */
    public OperationsInsightsAsyncClient(
            com.oracle.bmc.auth.BasicAuthenticationDetailsProvider authenticationDetailsProvider) {
        this(authenticationDetailsProvider, null);
    }

    /**
     * Creates a new service instance using the given authentication provider and client configuration.
     * @param authenticationDetailsProvider The authentication details provider, required.
     * @param configuration The client configuration, optional.
     */
    public OperationsInsightsAsyncClient(
            com.oracle.bmc.auth.BasicAuthenticationDetailsProvider authenticationDetailsProvider,
            com.oracle.bmc.ClientConfiguration configuration) {
        this(authenticationDetailsProvider, configuration, null);
    }

    /**
     * Creates a new service instance using the given authentication provider and client configuration.  Additionally,
     * a Consumer can be provided that will be invoked whenever a REST Client is created to allow for additional configuration/customization.
     * @param authenticationDetailsProvider The authentication details provider, required.
     * @param configuration The client configuration, optional.
     * @param clientConfigurator ClientConfigurator that will be invoked for additional configuration of a REST client, optional.
     */
    public OperationsInsightsAsyncClient(
            com.oracle.bmc.auth.BasicAuthenticationDetailsProvider authenticationDetailsProvider,
            com.oracle.bmc.ClientConfiguration configuration,
            com.oracle.bmc.http.ClientConfigurator clientConfigurator) {
        this(
                authenticationDetailsProvider,
                configuration,
                clientConfigurator,
                new com.oracle.bmc.http.signing.internal.DefaultRequestSignerFactory(
                        com.oracle.bmc.http.signing.SigningStrategy.STANDARD));
    }

    /**
     * Creates a new service instance using the given authentication provider and client configuration.  Additionally,
     * a Consumer can be provided that will be invoked whenever a REST Client is created to allow for additional configuration/customization.
     * <p>
     * This is an advanced constructor for clients that want to take control over how requests are signed.
     * @param authenticationDetailsProvider The authentication details provider, required.
     * @param configuration The client configuration, optional.
     * @param clientConfigurator ClientConfigurator that will be invoked for additional configuration of a REST client, optional.
     * @param defaultRequestSignerFactory The request signer factory used to create the request signer for this service.
     */
    public OperationsInsightsAsyncClient(
            com.oracle.bmc.auth.AbstractAuthenticationDetailsProvider authenticationDetailsProvider,
            com.oracle.bmc.ClientConfiguration configuration,
            com.oracle.bmc.http.ClientConfigurator clientConfigurator,
            com.oracle.bmc.http.signing.RequestSignerFactory defaultRequestSignerFactory) {
        this(
                authenticationDetailsProvider,
                configuration,
                clientConfigurator,
                defaultRequestSignerFactory,
                new java.util.ArrayList<com.oracle.bmc.http.ClientConfigurator>());
    }

    /**
     * Creates a new service instance using the given authentication provider and client configuration.  Additionally,
     * a Consumer can be provided that will be invoked whenever a REST Client is created to allow for additional configuration/customization.
     * <p>
     * This is an advanced constructor for clients that want to take control over how requests are signed.
     * @param authenticationDetailsProvider The authentication details provider, required.
     * @param configuration The client configuration, optional.
     * @param clientConfigurator ClientConfigurator that will be invoked for additional configuration of a REST client, optional.
     * @param defaultRequestSignerFactory The request signer factory used to create the request signer for this service.
     * @param additionalClientConfigurators Additional client configurators to be run after the primary configurator.
     */
    public OperationsInsightsAsyncClient(
            com.oracle.bmc.auth.AbstractAuthenticationDetailsProvider authenticationDetailsProvider,
            com.oracle.bmc.ClientConfiguration configuration,
            com.oracle.bmc.http.ClientConfigurator clientConfigurator,
            com.oracle.bmc.http.signing.RequestSignerFactory defaultRequestSignerFactory,
            java.util.List<com.oracle.bmc.http.ClientConfigurator> additionalClientConfigurators) {
        this(
                authenticationDetailsProvider,
                configuration,
                clientConfigurator,
                defaultRequestSignerFactory,
                additionalClientConfigurators,
                null);
    }

    /**
     * Creates a new service instance using the given authentication provider and client configuration.  Additionally,
     * a Consumer can be provided that will be invoked whenever a REST Client is created to allow for additional configuration/customization.
     * <p>
     * This is an advanced constructor for clients that want to take control over how requests are signed.
     * @param authenticationDetailsProvider The authentication details provider, required.
     * @param configuration The client configuration, optional.
     * @param clientConfigurator ClientConfigurator that will be invoked for additional configuration of a REST client, optional.
     * @param defaultRequestSignerFactory The request signer factory used to create the request signer for this service.
     * @param additionalClientConfigurators Additional client configurators to be run after the primary configurator.
     * @param endpoint Endpoint, or null to leave unset (note, may be overridden by {@code authenticationDetailsProvider})
     */
    public OperationsInsightsAsyncClient(
            com.oracle.bmc.auth.AbstractAuthenticationDetailsProvider authenticationDetailsProvider,
            com.oracle.bmc.ClientConfiguration configuration,
            com.oracle.bmc.http.ClientConfigurator clientConfigurator,
            com.oracle.bmc.http.signing.RequestSignerFactory defaultRequestSignerFactory,
            java.util.List<com.oracle.bmc.http.ClientConfigurator> additionalClientConfigurators,
            String endpoint) {
        this(
                authenticationDetailsProvider,
                configuration,
                clientConfigurator,
                defaultRequestSignerFactory,
                com.oracle.bmc.http.signing.internal.DefaultRequestSignerFactory
                        .createDefaultRequestSignerFactories(),
                additionalClientConfigurators,
                endpoint);
    }

    /**
     * Creates a new service instance using the given authentication provider and client configuration.  Additionally,
     * a Consumer can be provided that will be invoked whenever a REST Client is created to allow for additional configuration/customization.
     * <p>
     * This is an advanced constructor for clients that want to take control over how requests are signed.
     * @param authenticationDetailsProvider The authentication details provider, required.
     * @param configuration The client configuration, optional.
     * @param clientConfigurator ClientConfigurator that will be invoked for additional configuration of a REST client, optional.
     * @param defaultRequestSignerFactory The request signer factory used to create the request signer for this service.
     * @param signingStrategyRequestSignerFactories The request signer factories for each signing strategy used to create the request signer
     * @param additionalClientConfigurators Additional client configurators to be run after the primary configurator.
     * @param endpoint Endpoint, or null to leave unset (note, may be overridden by {@code authenticationDetailsProvider})
     */
    public OperationsInsightsAsyncClient(
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
                authenticationDetailsProvider,
                configuration,
                clientConfigurator,
                defaultRequestSignerFactory,
                signingStrategyRequestSignerFactories,
                additionalClientConfigurators,
                endpoint,
                com.oracle.bmc.http.internal.RestClientFactoryBuilder.builder());
    }

    /**
     * Creates a new service instance using the given authentication provider and client configuration.  Additionally,
     * a Consumer can be provided that will be invoked whenever a REST Client is created to allow for additional configuration/customization.
     * <p>
     * This is an advanced constructor for clients that want to take control over how requests are signed.
     * @param authenticationDetailsProvider The authentication details provider, required.
     * @param configuration The client configuration, optional.
     * @param clientConfigurator ClientConfigurator that will be invoked for additional configuration of a REST client, optional.
     * @param defaultRequestSignerFactory The request signer factory used to create the request signer for this service.
     * @param signingStrategyRequestSignerFactories The request signer factories for each signing strategy used to create the request signer
     * @param additionalClientConfigurators Additional client configurators to be run after the primary configurator.
     * @param endpoint Endpoint, or null to leave unset (note, may be overridden by {@code authenticationDetailsProvider})
     * @param restClientFactoryBuilder the builder for the {@link com.oracle.bmc.http.internal.RestClientFactory}
     */
    public OperationsInsightsAsyncClient(
            com.oracle.bmc.auth.AbstractAuthenticationDetailsProvider authenticationDetailsProvider,
            com.oracle.bmc.ClientConfiguration configuration,
            com.oracle.bmc.http.ClientConfigurator clientConfigurator,
            com.oracle.bmc.http.signing.RequestSignerFactory defaultRequestSignerFactory,
            java.util.Map<
                            com.oracle.bmc.http.signing.SigningStrategy,
                            com.oracle.bmc.http.signing.RequestSignerFactory>
                    signingStrategyRequestSignerFactories,
            java.util.List<com.oracle.bmc.http.ClientConfigurator> additionalClientConfigurators,
            String endpoint,
            com.oracle.bmc.http.internal.RestClientFactoryBuilder restClientFactoryBuilder) {
        this.authenticationDetailsProvider = authenticationDetailsProvider;
        java.util.List<com.oracle.bmc.http.ClientConfigurator> authenticationDetailsConfigurators =
                new java.util.ArrayList<>();
        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.ProvidesClientConfigurators) {
            authenticationDetailsConfigurators.addAll(
                    ((com.oracle.bmc.auth.ProvidesClientConfigurators)
                                    this.authenticationDetailsProvider)
                            .getClientConfigurators());
        }
        java.util.List<com.oracle.bmc.http.ClientConfigurator> allConfigurators =
                new java.util.ArrayList<>(additionalClientConfigurators);
        allConfigurators.addAll(authenticationDetailsConfigurators);
        this.restClientFactory =
                restClientFactoryBuilder
                        .clientConfigurator(clientConfigurator)
                        .additionalClientConfigurators(allConfigurators)
                        .build();
        this.isNonBufferingApacheClient =
                com.oracle.bmc.http.ApacheUtils.isNonBufferingClientConfigurator(
                        restClientFactory.getClientConfigurator());
        this.apacheConnectionClosingStrategy =
                com.oracle.bmc.http.ApacheUtils.getApacheConnectionClosingStrategy(
                        restClientFactory.getClientConfigurator());
        this.defaultRequestSignerFactory = defaultRequestSignerFactory;
        this.signingStrategyRequestSignerFactories = signingStrategyRequestSignerFactories;
        this.clientConfigurationToUse = configuration;

        this.refreshClient();

        if (this.authenticationDetailsProvider instanceof com.oracle.bmc.auth.RegionProvider) {
            com.oracle.bmc.auth.RegionProvider provider =
                    (com.oracle.bmc.auth.RegionProvider) this.authenticationDetailsProvider;

            if (provider.getRegion() != null) {
                this.setRegion(provider.getRegion());
                if (endpoint != null) {
                    LOG.info(
                            "Authentication details provider configured for region '{}', but endpoint specifically set to '{}'. Using endpoint setting instead of region.",
                            provider.getRegion(),
                            endpoint);
                }
            }
        }
        if (endpoint != null) {
            setEndpoint(endpoint);
        }
    }

    /**
     * Create a builder for this client.
     * @return builder
     */
    public static Builder builder() {
        return new Builder(SERVICE);
    }

    /**
     * Builder class for this client. The "authenticationDetailsProvider" is required and must be passed to the
     * {@link #build(AbstractAuthenticationDetailsProvider)} method.
     */
    public static class Builder
            extends com.oracle.bmc.common.RegionalClientBuilder<
                    Builder, OperationsInsightsAsyncClient> {
        private Builder(com.oracle.bmc.Service service) {
            super(service);
            requestSignerFactory =
                    new com.oracle.bmc.http.signing.internal.DefaultRequestSignerFactory(
                            com.oracle.bmc.http.signing.SigningStrategy.STANDARD);
        }

        /**
         * Build the client.
         * @param authenticationDetailsProvider authentication details provider
         * @return the client
         */
        public OperationsInsightsAsyncClient build(
                @javax.annotation.Nonnull
                com.oracle.bmc.auth.AbstractAuthenticationDetailsProvider
                        authenticationDetailsProvider) {
            if (authenticationDetailsProvider == null) {
                throw new NullPointerException(
                        "authenticationDetailsProvider is marked non-null but is null");
            }
            return new OperationsInsightsAsyncClient(
                    authenticationDetailsProvider,
                    configuration,
                    clientConfigurator,
                    requestSignerFactory,
                    signingStrategyRequestSignerFactories,
                    additionalClientConfigurators,
                    endpoint);
        }
    }

    com.oracle.bmc.http.internal.RestClient getClient() {
        return client;
    }

    @Override
    public void refreshClient() {
        LOG.info("Refreshing client '{}'.", this.client != null ? this.client.getClass() : null);
        com.oracle.bmc.http.signing.RequestSigner defaultRequestSigner =
                this.defaultRequestSignerFactory.createRequestSigner(
                        SERVICE, this.authenticationDetailsProvider);

        java.util.Map<
                        com.oracle.bmc.http.signing.SigningStrategy,
                        com.oracle.bmc.http.signing.RequestSigner>
                requestSigners = new java.util.HashMap<>();
        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.BasicAuthenticationDetailsProvider) {
            for (com.oracle.bmc.http.signing.SigningStrategy s :
                    com.oracle.bmc.http.signing.SigningStrategy.values()) {
                requestSigners.put(
                        s,
                        this.signingStrategyRequestSignerFactories
                                .get(s)
                                .createRequestSigner(SERVICE, authenticationDetailsProvider));
            }
        }

        com.oracle.bmc.http.internal.RestClient refreshedClient =
                this.restClientFactory.create(
                        defaultRequestSigner,
                        requestSigners,
                        this.clientConfigurationToUse,
                        this.isNonBufferingApacheClient);

        synchronized (clientUpdate) {
            if (this.overrideEndpoint != null) {
                refreshedClient.setEndpoint(this.overrideEndpoint);
            }

            this.client = refreshedClient;
        }

        LOG.info("Refreshed client '{}'.", this.client != null ? this.client.getClass() : null);
    }

    @Override
    public void setEndpoint(String endpoint) {
        LOG.info("Setting endpoint to {}", endpoint);

        synchronized (clientUpdate) {
            this.overrideEndpoint = endpoint;
            client.setEndpoint(endpoint);
        }
    }

    @Override
    public String getEndpoint() {
        String endpoint = null;
        java.net.URI uri = client.getBaseTarget().getUri();
        if (uri != null) {
            endpoint = uri.toString();
        }
        return endpoint;
    }

    @Override
    public void setRegion(com.oracle.bmc.Region region) {
        java.util.Optional<String> endpoint =
                com.oracle.bmc.internal.GuavaUtils.adaptFromGuava(region.getEndpoint(SERVICE));
        if (endpoint.isPresent()) {
            setEndpoint(endpoint.get());
        } else {
            throw new IllegalArgumentException(
                    "Endpoint for " + SERVICE + " is not known in region " + region);
        }
    }

    @Override
    public void setRegion(String regionId) {
        regionId = regionId.toLowerCase(java.util.Locale.ENGLISH);
        try {
            com.oracle.bmc.Region region = com.oracle.bmc.Region.fromRegionId(regionId);
            setRegion(region);
        } catch (IllegalArgumentException e) {
            LOG.info("Unknown regionId '{}', falling back to default endpoint format", regionId);
            String endpoint = com.oracle.bmc.Region.formatDefaultRegionEndpoint(SERVICE, regionId);
            setEndpoint(endpoint);
        }
    }

    @Override
    public void close() {
        client.close();
    }

    @Override
    public java.util.concurrent.Future<AddExadataInsightMembersResponse> addExadataInsightMembers(
            AddExadataInsightMembersRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            AddExadataInsightMembersRequest, AddExadataInsightMembersResponse>
                    handler) {
        LOG.trace("Called async addExadataInsightMembers");
        final AddExadataInsightMembersRequest interceptedRequest =
                AddExadataInsightMembersConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                AddExadataInsightMembersConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "AddExadataInsightMembers",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/ExadataInsights/AddExadataInsightMembers");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, AddExadataInsightMembersResponse>
                transformer =
                        AddExadataInsightMembersConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        AddExadataInsightMembersRequest, AddExadataInsightMembersResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                AddExadataInsightMembersRequest, AddExadataInsightMembersResponse>,
                        java.util.concurrent.Future<AddExadataInsightMembersResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getAddExadataInsightMembersDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    AddExadataInsightMembersRequest, AddExadataInsightMembersResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ChangeDatabaseInsightCompartmentResponse>
            changeDatabaseInsightCompartment(
                    ChangeDatabaseInsightCompartmentRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    ChangeDatabaseInsightCompartmentRequest,
                                    ChangeDatabaseInsightCompartmentResponse>
                            handler) {
        LOG.trace("Called async changeDatabaseInsightCompartment");
        final ChangeDatabaseInsightCompartmentRequest interceptedRequest =
                ChangeDatabaseInsightCompartmentConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ChangeDatabaseInsightCompartmentConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ChangeDatabaseInsightCompartment",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/ChangeDatabaseInsightCompartment");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, ChangeDatabaseInsightCompartmentResponse>
                transformer =
                        ChangeDatabaseInsightCompartmentConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ChangeDatabaseInsightCompartmentRequest,
                        ChangeDatabaseInsightCompartmentResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ChangeDatabaseInsightCompartmentRequest,
                                ChangeDatabaseInsightCompartmentResponse>,
                        java.util.concurrent.Future<ChangeDatabaseInsightCompartmentResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getChangeDatabaseInsightCompartmentDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ChangeDatabaseInsightCompartmentRequest,
                    ChangeDatabaseInsightCompartmentResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ChangeEnterpriseManagerBridgeCompartmentResponse>
            changeEnterpriseManagerBridgeCompartment(
                    ChangeEnterpriseManagerBridgeCompartmentRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    ChangeEnterpriseManagerBridgeCompartmentRequest,
                                    ChangeEnterpriseManagerBridgeCompartmentResponse>
                            handler) {
        LOG.trace("Called async changeEnterpriseManagerBridgeCompartment");
        final ChangeEnterpriseManagerBridgeCompartmentRequest interceptedRequest =
                ChangeEnterpriseManagerBridgeCompartmentConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ChangeEnterpriseManagerBridgeCompartmentConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ChangeEnterpriseManagerBridgeCompartment",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/EnterpriseManagerBridges/ChangeEnterpriseManagerBridgeCompartment");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, ChangeEnterpriseManagerBridgeCompartmentResponse>
                transformer =
                        ChangeEnterpriseManagerBridgeCompartmentConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ChangeEnterpriseManagerBridgeCompartmentRequest,
                        ChangeEnterpriseManagerBridgeCompartmentResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ChangeEnterpriseManagerBridgeCompartmentRequest,
                                ChangeEnterpriseManagerBridgeCompartmentResponse>,
                        java.util.concurrent.Future<
                                ChangeEnterpriseManagerBridgeCompartmentResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest
                                        .getChangeEnterpriseManagerBridgeCompartmentDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ChangeEnterpriseManagerBridgeCompartmentRequest,
                    ChangeEnterpriseManagerBridgeCompartmentResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ChangeExadataInsightCompartmentResponse>
            changeExadataInsightCompartment(
                    ChangeExadataInsightCompartmentRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    ChangeExadataInsightCompartmentRequest,
                                    ChangeExadataInsightCompartmentResponse>
                            handler) {
        LOG.trace("Called async changeExadataInsightCompartment");
        final ChangeExadataInsightCompartmentRequest interceptedRequest =
                ChangeExadataInsightCompartmentConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ChangeExadataInsightCompartmentConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ChangeExadataInsightCompartment",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/ExadataInsights/ChangeExadataInsightCompartment");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, ChangeExadataInsightCompartmentResponse>
                transformer =
                        ChangeExadataInsightCompartmentConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ChangeExadataInsightCompartmentRequest,
                        ChangeExadataInsightCompartmentResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ChangeExadataInsightCompartmentRequest,
                                ChangeExadataInsightCompartmentResponse>,
                        java.util.concurrent.Future<ChangeExadataInsightCompartmentResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getChangeExadataInsightCompartmentDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ChangeExadataInsightCompartmentRequest,
                    ChangeExadataInsightCompartmentResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ChangeHostInsightCompartmentResponse>
            changeHostInsightCompartment(
                    ChangeHostInsightCompartmentRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    ChangeHostInsightCompartmentRequest,
                                    ChangeHostInsightCompartmentResponse>
                            handler) {
        LOG.trace("Called async changeHostInsightCompartment");
        final ChangeHostInsightCompartmentRequest interceptedRequest =
                ChangeHostInsightCompartmentConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ChangeHostInsightCompartmentConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ChangeHostInsightCompartment",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/ChangeHostInsightCompartment");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, ChangeHostInsightCompartmentResponse>
                transformer =
                        ChangeHostInsightCompartmentConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ChangeHostInsightCompartmentRequest, ChangeHostInsightCompartmentResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ChangeHostInsightCompartmentRequest,
                                ChangeHostInsightCompartmentResponse>,
                        java.util.concurrent.Future<ChangeHostInsightCompartmentResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getChangeHostInsightCompartmentDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ChangeHostInsightCompartmentRequest, ChangeHostInsightCompartmentResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ChangeOperationsInsightsPrivateEndpointCompartmentResponse>
            changeOperationsInsightsPrivateEndpointCompartment(
                    ChangeOperationsInsightsPrivateEndpointCompartmentRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    ChangeOperationsInsightsPrivateEndpointCompartmentRequest,
                                    ChangeOperationsInsightsPrivateEndpointCompartmentResponse>
                            handler) {
        LOG.trace("Called async changeOperationsInsightsPrivateEndpointCompartment");
        final ChangeOperationsInsightsPrivateEndpointCompartmentRequest interceptedRequest =
                ChangeOperationsInsightsPrivateEndpointCompartmentConverter.interceptRequest(
                        request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ChangeOperationsInsightsPrivateEndpointCompartmentConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ChangeOperationsInsightsPrivateEndpointCompartment",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OperationsInsightsPrivateEndpoint/ChangeOperationsInsightsPrivateEndpointCompartment");
        final java.util.function.Function<
                        javax.ws.rs.core.Response,
                        ChangeOperationsInsightsPrivateEndpointCompartmentResponse>
                transformer =
                        ChangeOperationsInsightsPrivateEndpointCompartmentConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ChangeOperationsInsightsPrivateEndpointCompartmentRequest,
                        ChangeOperationsInsightsPrivateEndpointCompartmentResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ChangeOperationsInsightsPrivateEndpointCompartmentRequest,
                                ChangeOperationsInsightsPrivateEndpointCompartmentResponse>,
                        java.util.concurrent.Future<
                                ChangeOperationsInsightsPrivateEndpointCompartmentResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest
                                        .getChangeOperationsInsightsPrivateEndpointCompartmentDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ChangeOperationsInsightsPrivateEndpointCompartmentRequest,
                    ChangeOperationsInsightsPrivateEndpointCompartmentResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ChangeOpsiConfigurationCompartmentResponse>
            changeOpsiConfigurationCompartment(
                    ChangeOpsiConfigurationCompartmentRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    ChangeOpsiConfigurationCompartmentRequest,
                                    ChangeOpsiConfigurationCompartmentResponse>
                            handler) {
        LOG.trace("Called async changeOpsiConfigurationCompartment");
        final ChangeOpsiConfigurationCompartmentRequest interceptedRequest =
                ChangeOpsiConfigurationCompartmentConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ChangeOpsiConfigurationCompartmentConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ChangeOpsiConfigurationCompartment",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OpsiConfigurations/ChangeOpsiConfigurationCompartment");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, ChangeOpsiConfigurationCompartmentResponse>
                transformer =
                        ChangeOpsiConfigurationCompartmentConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ChangeOpsiConfigurationCompartmentRequest,
                        ChangeOpsiConfigurationCompartmentResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ChangeOpsiConfigurationCompartmentRequest,
                                ChangeOpsiConfigurationCompartmentResponse>,
                        java.util.concurrent.Future<ChangeOpsiConfigurationCompartmentResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getChangeOpsiConfigurationCompartmentDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ChangeOpsiConfigurationCompartmentRequest,
                    ChangeOpsiConfigurationCompartmentResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ChangePeComanagedDatabaseInsightResponse>
            changePeComanagedDatabaseInsight(
                    ChangePeComanagedDatabaseInsightRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    ChangePeComanagedDatabaseInsightRequest,
                                    ChangePeComanagedDatabaseInsightResponse>
                            handler) {
        LOG.trace("Called async changePeComanagedDatabaseInsight");
        final ChangePeComanagedDatabaseInsightRequest interceptedRequest =
                ChangePeComanagedDatabaseInsightConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ChangePeComanagedDatabaseInsightConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ChangePeComanagedDatabaseInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/ChangePeComanagedDatabaseInsight");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, ChangePeComanagedDatabaseInsightResponse>
                transformer =
                        ChangePeComanagedDatabaseInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ChangePeComanagedDatabaseInsightRequest,
                        ChangePeComanagedDatabaseInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ChangePeComanagedDatabaseInsightRequest,
                                ChangePeComanagedDatabaseInsightResponse>,
                        java.util.concurrent.Future<ChangePeComanagedDatabaseInsightResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getChangePeComanagedDatabaseInsightDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ChangePeComanagedDatabaseInsightRequest,
                    ChangePeComanagedDatabaseInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<CreateAwrHubResponse> createAwrHub(
            CreateAwrHubRequest request,
            final com.oracle.bmc.responses.AsyncHandler<CreateAwrHubRequest, CreateAwrHubResponse>
                    handler) {
        LOG.trace("Called async createAwrHub");
        final CreateAwrHubRequest interceptedRequest =
                CreateAwrHubConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                CreateAwrHubConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "CreateAwrHub",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/CreateAwrHub");
        final java.util.function.Function<javax.ws.rs.core.Response, CreateAwrHubResponse>
                transformer =
                        CreateAwrHubConverter.fromResponse(java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<CreateAwrHubRequest, CreateAwrHubResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                CreateAwrHubRequest, CreateAwrHubResponse>,
                        java.util.concurrent.Future<CreateAwrHubResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getCreateAwrHubDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    CreateAwrHubRequest, CreateAwrHubResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<CreateDatabaseInsightResponse> createDatabaseInsight(
            CreateDatabaseInsightRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            CreateDatabaseInsightRequest, CreateDatabaseInsightResponse>
                    handler) {
        LOG.trace("Called async createDatabaseInsight");
        final CreateDatabaseInsightRequest interceptedRequest =
                CreateDatabaseInsightConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                CreateDatabaseInsightConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "CreateDatabaseInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/CreateDatabaseInsight");
        final java.util.function.Function<javax.ws.rs.core.Response, CreateDatabaseInsightResponse>
                transformer =
                        CreateDatabaseInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        CreateDatabaseInsightRequest, CreateDatabaseInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                CreateDatabaseInsightRequest, CreateDatabaseInsightResponse>,
                        java.util.concurrent.Future<CreateDatabaseInsightResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getCreateDatabaseInsightDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    CreateDatabaseInsightRequest, CreateDatabaseInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<CreateEnterpriseManagerBridgeResponse>
            createEnterpriseManagerBridge(
                    CreateEnterpriseManagerBridgeRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    CreateEnterpriseManagerBridgeRequest,
                                    CreateEnterpriseManagerBridgeResponse>
                            handler) {
        LOG.trace("Called async createEnterpriseManagerBridge");
        final CreateEnterpriseManagerBridgeRequest interceptedRequest =
                CreateEnterpriseManagerBridgeConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                CreateEnterpriseManagerBridgeConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "CreateEnterpriseManagerBridge",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/EnterpriseManagerBridges/CreateEnterpriseManagerBridge");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, CreateEnterpriseManagerBridgeResponse>
                transformer =
                        CreateEnterpriseManagerBridgeConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        CreateEnterpriseManagerBridgeRequest, CreateEnterpriseManagerBridgeResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                CreateEnterpriseManagerBridgeRequest,
                                CreateEnterpriseManagerBridgeResponse>,
                        java.util.concurrent.Future<CreateEnterpriseManagerBridgeResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getCreateEnterpriseManagerBridgeDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    CreateEnterpriseManagerBridgeRequest, CreateEnterpriseManagerBridgeResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<CreateExadataInsightResponse> createExadataInsight(
            CreateExadataInsightRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            CreateExadataInsightRequest, CreateExadataInsightResponse>
                    handler) {
        LOG.trace("Called async createExadataInsight");
        final CreateExadataInsightRequest interceptedRequest =
                CreateExadataInsightConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                CreateExadataInsightConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "CreateExadataInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/ExadataInsights/CreateExadataInsight");
        final java.util.function.Function<javax.ws.rs.core.Response, CreateExadataInsightResponse>
                transformer =
                        CreateExadataInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        CreateExadataInsightRequest, CreateExadataInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                CreateExadataInsightRequest, CreateExadataInsightResponse>,
                        java.util.concurrent.Future<CreateExadataInsightResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getCreateExadataInsightDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    CreateExadataInsightRequest, CreateExadataInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<CreateHostInsightResponse> createHostInsight(
            CreateHostInsightRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            CreateHostInsightRequest, CreateHostInsightResponse>
                    handler) {
        LOG.trace("Called async createHostInsight");
        final CreateHostInsightRequest interceptedRequest =
                CreateHostInsightConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                CreateHostInsightConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "CreateHostInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/CreateHostInsight");
        final java.util.function.Function<javax.ws.rs.core.Response, CreateHostInsightResponse>
                transformer =
                        CreateHostInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<CreateHostInsightRequest, CreateHostInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                CreateHostInsightRequest, CreateHostInsightResponse>,
                        java.util.concurrent.Future<CreateHostInsightResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getCreateHostInsightDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    CreateHostInsightRequest, CreateHostInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<CreateOperationsInsightsPrivateEndpointResponse>
            createOperationsInsightsPrivateEndpoint(
                    CreateOperationsInsightsPrivateEndpointRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    CreateOperationsInsightsPrivateEndpointRequest,
                                    CreateOperationsInsightsPrivateEndpointResponse>
                            handler) {
        LOG.trace("Called async createOperationsInsightsPrivateEndpoint");
        final CreateOperationsInsightsPrivateEndpointRequest interceptedRequest =
                CreateOperationsInsightsPrivateEndpointConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                CreateOperationsInsightsPrivateEndpointConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "CreateOperationsInsightsPrivateEndpoint",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OperationsInsightsPrivateEndpoint/CreateOperationsInsightsPrivateEndpoint");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, CreateOperationsInsightsPrivateEndpointResponse>
                transformer =
                        CreateOperationsInsightsPrivateEndpointConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        CreateOperationsInsightsPrivateEndpointRequest,
                        CreateOperationsInsightsPrivateEndpointResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                CreateOperationsInsightsPrivateEndpointRequest,
                                CreateOperationsInsightsPrivateEndpointResponse>,
                        java.util.concurrent.Future<
                                CreateOperationsInsightsPrivateEndpointResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest
                                        .getCreateOperationsInsightsPrivateEndpointDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    CreateOperationsInsightsPrivateEndpointRequest,
                    CreateOperationsInsightsPrivateEndpointResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<CreateOperationsInsightsWarehouseResponse>
            createOperationsInsightsWarehouse(
                    CreateOperationsInsightsWarehouseRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    CreateOperationsInsightsWarehouseRequest,
                                    CreateOperationsInsightsWarehouseResponse>
                            handler) {
        LOG.trace("Called async createOperationsInsightsWarehouse");
        final CreateOperationsInsightsWarehouseRequest interceptedRequest =
                CreateOperationsInsightsWarehouseConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                CreateOperationsInsightsWarehouseConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "CreateOperationsInsightsWarehouse",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OperationsInsightsWarehouses/CreateOperationsInsightsWarehouse");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, CreateOperationsInsightsWarehouseResponse>
                transformer =
                        CreateOperationsInsightsWarehouseConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        CreateOperationsInsightsWarehouseRequest,
                        CreateOperationsInsightsWarehouseResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                CreateOperationsInsightsWarehouseRequest,
                                CreateOperationsInsightsWarehouseResponse>,
                        java.util.concurrent.Future<CreateOperationsInsightsWarehouseResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getCreateOperationsInsightsWarehouseDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    CreateOperationsInsightsWarehouseRequest,
                    CreateOperationsInsightsWarehouseResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<CreateOperationsInsightsWarehouseUserResponse>
            createOperationsInsightsWarehouseUser(
                    CreateOperationsInsightsWarehouseUserRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    CreateOperationsInsightsWarehouseUserRequest,
                                    CreateOperationsInsightsWarehouseUserResponse>
                            handler) {
        LOG.trace("Called async createOperationsInsightsWarehouseUser");
        final CreateOperationsInsightsWarehouseUserRequest interceptedRequest =
                CreateOperationsInsightsWarehouseUserConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                CreateOperationsInsightsWarehouseUserConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "CreateOperationsInsightsWarehouseUser",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OperationsInsightsWarehouseUsers/CreateOperationsInsightsWarehouseUser");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, CreateOperationsInsightsWarehouseUserResponse>
                transformer =
                        CreateOperationsInsightsWarehouseUserConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        CreateOperationsInsightsWarehouseUserRequest,
                        CreateOperationsInsightsWarehouseUserResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                CreateOperationsInsightsWarehouseUserRequest,
                                CreateOperationsInsightsWarehouseUserResponse>,
                        java.util.concurrent.Future<CreateOperationsInsightsWarehouseUserResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest
                                        .getCreateOperationsInsightsWarehouseUserDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    CreateOperationsInsightsWarehouseUserRequest,
                    CreateOperationsInsightsWarehouseUserResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<CreateOpsiConfigurationResponse> createOpsiConfiguration(
            CreateOpsiConfigurationRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            CreateOpsiConfigurationRequest, CreateOpsiConfigurationResponse>
                    handler) {
        LOG.trace("Called async createOpsiConfiguration");
        final CreateOpsiConfigurationRequest interceptedRequest =
                CreateOpsiConfigurationConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                CreateOpsiConfigurationConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "CreateOpsiConfiguration",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OpsiConfigurations/CreateOpsiConfiguration");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, CreateOpsiConfigurationResponse>
                transformer =
                        CreateOpsiConfigurationConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        CreateOpsiConfigurationRequest, CreateOpsiConfigurationResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                CreateOpsiConfigurationRequest, CreateOpsiConfigurationResponse>,
                        java.util.concurrent.Future<CreateOpsiConfigurationResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getCreateOpsiConfigurationDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    CreateOpsiConfigurationRequest, CreateOpsiConfigurationResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<DeleteAwrHubResponse> deleteAwrHub(
            DeleteAwrHubRequest request,
            final com.oracle.bmc.responses.AsyncHandler<DeleteAwrHubRequest, DeleteAwrHubResponse>
                    handler) {
        LOG.trace("Called async deleteAwrHub");
        final DeleteAwrHubRequest interceptedRequest =
                DeleteAwrHubConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                DeleteAwrHubConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "DeleteAwrHub",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/DeleteAwrHub");
        final java.util.function.Function<javax.ws.rs.core.Response, DeleteAwrHubResponse>
                transformer =
                        DeleteAwrHubConverter.fromResponse(java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<DeleteAwrHubRequest, DeleteAwrHubResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                DeleteAwrHubRequest, DeleteAwrHubResponse>,
                        java.util.concurrent.Future<DeleteAwrHubResponse>>
                futureSupplier = client.deleteFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    DeleteAwrHubRequest, DeleteAwrHubResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<DeleteDatabaseInsightResponse> deleteDatabaseInsight(
            DeleteDatabaseInsightRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            DeleteDatabaseInsightRequest, DeleteDatabaseInsightResponse>
                    handler) {
        LOG.trace("Called async deleteDatabaseInsight");
        final DeleteDatabaseInsightRequest interceptedRequest =
                DeleteDatabaseInsightConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                DeleteDatabaseInsightConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "DeleteDatabaseInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/DeleteDatabaseInsight");
        final java.util.function.Function<javax.ws.rs.core.Response, DeleteDatabaseInsightResponse>
                transformer =
                        DeleteDatabaseInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        DeleteDatabaseInsightRequest, DeleteDatabaseInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                DeleteDatabaseInsightRequest, DeleteDatabaseInsightResponse>,
                        java.util.concurrent.Future<DeleteDatabaseInsightResponse>>
                futureSupplier = client.deleteFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    DeleteDatabaseInsightRequest, DeleteDatabaseInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<DeleteEnterpriseManagerBridgeResponse>
            deleteEnterpriseManagerBridge(
                    DeleteEnterpriseManagerBridgeRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    DeleteEnterpriseManagerBridgeRequest,
                                    DeleteEnterpriseManagerBridgeResponse>
                            handler) {
        LOG.trace("Called async deleteEnterpriseManagerBridge");
        final DeleteEnterpriseManagerBridgeRequest interceptedRequest =
                DeleteEnterpriseManagerBridgeConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                DeleteEnterpriseManagerBridgeConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "DeleteEnterpriseManagerBridge",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/EnterpriseManagerBridges/DeleteEnterpriseManagerBridge");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, DeleteEnterpriseManagerBridgeResponse>
                transformer =
                        DeleteEnterpriseManagerBridgeConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        DeleteEnterpriseManagerBridgeRequest, DeleteEnterpriseManagerBridgeResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                DeleteEnterpriseManagerBridgeRequest,
                                DeleteEnterpriseManagerBridgeResponse>,
                        java.util.concurrent.Future<DeleteEnterpriseManagerBridgeResponse>>
                futureSupplier = client.deleteFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    DeleteEnterpriseManagerBridgeRequest, DeleteEnterpriseManagerBridgeResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<DeleteExadataInsightResponse> deleteExadataInsight(
            DeleteExadataInsightRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            DeleteExadataInsightRequest, DeleteExadataInsightResponse>
                    handler) {
        LOG.trace("Called async deleteExadataInsight");
        final DeleteExadataInsightRequest interceptedRequest =
                DeleteExadataInsightConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                DeleteExadataInsightConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "DeleteExadataInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/ExadataInsights/DeleteExadataInsight");
        final java.util.function.Function<javax.ws.rs.core.Response, DeleteExadataInsightResponse>
                transformer =
                        DeleteExadataInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        DeleteExadataInsightRequest, DeleteExadataInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                DeleteExadataInsightRequest, DeleteExadataInsightResponse>,
                        java.util.concurrent.Future<DeleteExadataInsightResponse>>
                futureSupplier = client.deleteFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    DeleteExadataInsightRequest, DeleteExadataInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<DeleteHostInsightResponse> deleteHostInsight(
            DeleteHostInsightRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            DeleteHostInsightRequest, DeleteHostInsightResponse>
                    handler) {
        LOG.trace("Called async deleteHostInsight");
        final DeleteHostInsightRequest interceptedRequest =
                DeleteHostInsightConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                DeleteHostInsightConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "DeleteHostInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/DeleteHostInsight");
        final java.util.function.Function<javax.ws.rs.core.Response, DeleteHostInsightResponse>
                transformer =
                        DeleteHostInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<DeleteHostInsightRequest, DeleteHostInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                DeleteHostInsightRequest, DeleteHostInsightResponse>,
                        java.util.concurrent.Future<DeleteHostInsightResponse>>
                futureSupplier = client.deleteFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    DeleteHostInsightRequest, DeleteHostInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<DeleteOperationsInsightsPrivateEndpointResponse>
            deleteOperationsInsightsPrivateEndpoint(
                    DeleteOperationsInsightsPrivateEndpointRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    DeleteOperationsInsightsPrivateEndpointRequest,
                                    DeleteOperationsInsightsPrivateEndpointResponse>
                            handler) {
        LOG.trace("Called async deleteOperationsInsightsPrivateEndpoint");
        final DeleteOperationsInsightsPrivateEndpointRequest interceptedRequest =
                DeleteOperationsInsightsPrivateEndpointConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                DeleteOperationsInsightsPrivateEndpointConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "DeleteOperationsInsightsPrivateEndpoint",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OperationsInsightsPrivateEndpoint/DeleteOperationsInsightsPrivateEndpoint");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, DeleteOperationsInsightsPrivateEndpointResponse>
                transformer =
                        DeleteOperationsInsightsPrivateEndpointConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        DeleteOperationsInsightsPrivateEndpointRequest,
                        DeleteOperationsInsightsPrivateEndpointResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                DeleteOperationsInsightsPrivateEndpointRequest,
                                DeleteOperationsInsightsPrivateEndpointResponse>,
                        java.util.concurrent.Future<
                                DeleteOperationsInsightsPrivateEndpointResponse>>
                futureSupplier = client.deleteFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    DeleteOperationsInsightsPrivateEndpointRequest,
                    DeleteOperationsInsightsPrivateEndpointResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<DeleteOperationsInsightsWarehouseResponse>
            deleteOperationsInsightsWarehouse(
                    DeleteOperationsInsightsWarehouseRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    DeleteOperationsInsightsWarehouseRequest,
                                    DeleteOperationsInsightsWarehouseResponse>
                            handler) {
        LOG.trace("Called async deleteOperationsInsightsWarehouse");
        final DeleteOperationsInsightsWarehouseRequest interceptedRequest =
                DeleteOperationsInsightsWarehouseConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                DeleteOperationsInsightsWarehouseConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "DeleteOperationsInsightsWarehouse",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OperationsInsightsWarehouses/DeleteOperationsInsightsWarehouse");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, DeleteOperationsInsightsWarehouseResponse>
                transformer =
                        DeleteOperationsInsightsWarehouseConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        DeleteOperationsInsightsWarehouseRequest,
                        DeleteOperationsInsightsWarehouseResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                DeleteOperationsInsightsWarehouseRequest,
                                DeleteOperationsInsightsWarehouseResponse>,
                        java.util.concurrent.Future<DeleteOperationsInsightsWarehouseResponse>>
                futureSupplier = client.deleteFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    DeleteOperationsInsightsWarehouseRequest,
                    DeleteOperationsInsightsWarehouseResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<DeleteOperationsInsightsWarehouseUserResponse>
            deleteOperationsInsightsWarehouseUser(
                    DeleteOperationsInsightsWarehouseUserRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    DeleteOperationsInsightsWarehouseUserRequest,
                                    DeleteOperationsInsightsWarehouseUserResponse>
                            handler) {
        LOG.trace("Called async deleteOperationsInsightsWarehouseUser");
        final DeleteOperationsInsightsWarehouseUserRequest interceptedRequest =
                DeleteOperationsInsightsWarehouseUserConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                DeleteOperationsInsightsWarehouseUserConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "DeleteOperationsInsightsWarehouseUser",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OperationsInsightsWarehouseUsers/DeleteOperationsInsightsWarehouseUser");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, DeleteOperationsInsightsWarehouseUserResponse>
                transformer =
                        DeleteOperationsInsightsWarehouseUserConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        DeleteOperationsInsightsWarehouseUserRequest,
                        DeleteOperationsInsightsWarehouseUserResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                DeleteOperationsInsightsWarehouseUserRequest,
                                DeleteOperationsInsightsWarehouseUserResponse>,
                        java.util.concurrent.Future<DeleteOperationsInsightsWarehouseUserResponse>>
                futureSupplier = client.deleteFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    DeleteOperationsInsightsWarehouseUserRequest,
                    DeleteOperationsInsightsWarehouseUserResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<DeleteOpsiConfigurationResponse> deleteOpsiConfiguration(
            DeleteOpsiConfigurationRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            DeleteOpsiConfigurationRequest, DeleteOpsiConfigurationResponse>
                    handler) {
        LOG.trace("Called async deleteOpsiConfiguration");
        final DeleteOpsiConfigurationRequest interceptedRequest =
                DeleteOpsiConfigurationConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                DeleteOpsiConfigurationConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "DeleteOpsiConfiguration",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OpsiConfigurations/DeleteOpsiConfiguration");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, DeleteOpsiConfigurationResponse>
                transformer =
                        DeleteOpsiConfigurationConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        DeleteOpsiConfigurationRequest, DeleteOpsiConfigurationResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                DeleteOpsiConfigurationRequest, DeleteOpsiConfigurationResponse>,
                        java.util.concurrent.Future<DeleteOpsiConfigurationResponse>>
                futureSupplier = client.deleteFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    DeleteOpsiConfigurationRequest, DeleteOpsiConfigurationResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<DisableDatabaseInsightResponse> disableDatabaseInsight(
            DisableDatabaseInsightRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            DisableDatabaseInsightRequest, DisableDatabaseInsightResponse>
                    handler) {
        LOG.trace("Called async disableDatabaseInsight");
        final DisableDatabaseInsightRequest interceptedRequest =
                DisableDatabaseInsightConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                DisableDatabaseInsightConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "DisableDatabaseInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/DisableDatabaseInsight");
        final java.util.function.Function<javax.ws.rs.core.Response, DisableDatabaseInsightResponse>
                transformer =
                        DisableDatabaseInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        DisableDatabaseInsightRequest, DisableDatabaseInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                DisableDatabaseInsightRequest, DisableDatabaseInsightResponse>,
                        java.util.concurrent.Future<DisableDatabaseInsightResponse>>
                futureSupplier = client.postFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    DisableDatabaseInsightRequest, DisableDatabaseInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<DisableExadataInsightResponse> disableExadataInsight(
            DisableExadataInsightRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            DisableExadataInsightRequest, DisableExadataInsightResponse>
                    handler) {
        LOG.trace("Called async disableExadataInsight");
        final DisableExadataInsightRequest interceptedRequest =
                DisableExadataInsightConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                DisableExadataInsightConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "DisableExadataInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/ExadataInsights/DisableExadataInsight");
        final java.util.function.Function<javax.ws.rs.core.Response, DisableExadataInsightResponse>
                transformer =
                        DisableExadataInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        DisableExadataInsightRequest, DisableExadataInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                DisableExadataInsightRequest, DisableExadataInsightResponse>,
                        java.util.concurrent.Future<DisableExadataInsightResponse>>
                futureSupplier = client.postFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    DisableExadataInsightRequest, DisableExadataInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<DisableHostInsightResponse> disableHostInsight(
            DisableHostInsightRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            DisableHostInsightRequest, DisableHostInsightResponse>
                    handler) {
        LOG.trace("Called async disableHostInsight");
        final DisableHostInsightRequest interceptedRequest =
                DisableHostInsightConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                DisableHostInsightConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "DisableHostInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/DisableHostInsight");
        final java.util.function.Function<javax.ws.rs.core.Response, DisableHostInsightResponse>
                transformer =
                        DisableHostInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<DisableHostInsightRequest, DisableHostInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                DisableHostInsightRequest, DisableHostInsightResponse>,
                        java.util.concurrent.Future<DisableHostInsightResponse>>
                futureSupplier = client.postFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    DisableHostInsightRequest, DisableHostInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<DownloadOperationsInsightsWarehouseWalletResponse>
            downloadOperationsInsightsWarehouseWallet(
                    DownloadOperationsInsightsWarehouseWalletRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    DownloadOperationsInsightsWarehouseWalletRequest,
                                    DownloadOperationsInsightsWarehouseWalletResponse>
                            handler) {
        LOG.trace("Called async downloadOperationsInsightsWarehouseWallet");
        if (com.oracle.bmc.http.ApacheUtils.isExtraStreamLogsEnabled()) {
            LOG.warn(
                    "downloadOperationsInsightsWarehouseWallet returns a stream, please make sure to close the stream to avoid any indefinite hangs");
            if (this.apacheConnectionClosingStrategy != null) {
                LOG.warn(
                        "ApacheConnectionClosingStrategy set to {}. For large streams with partial reads of stream, please use ImmediateClosingStrategy. "
                                + "For small streams with partial reads of stream, please use GracefulClosingStrategy. More info in ApacheConnectorProperties",
                        this.apacheConnectionClosingStrategy);
            }
        }
        final DownloadOperationsInsightsWarehouseWalletRequest interceptedRequest =
                DownloadOperationsInsightsWarehouseWalletConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                DownloadOperationsInsightsWarehouseWalletConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "DownloadOperationsInsightsWarehouseWallet",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OperationsInsightsWarehouses/DownloadOperationsInsightsWarehouseWallet");
        final java.util.function.Function<
                        javax.ws.rs.core.Response,
                        DownloadOperationsInsightsWarehouseWalletResponse>
                transformer =
                        DownloadOperationsInsightsWarehouseWalletConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        DownloadOperationsInsightsWarehouseWalletRequest,
                        DownloadOperationsInsightsWarehouseWalletResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                DownloadOperationsInsightsWarehouseWalletRequest,
                                DownloadOperationsInsightsWarehouseWalletResponse>,
                        java.util.concurrent.Future<
                                DownloadOperationsInsightsWarehouseWalletResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest
                                        .getDownloadOperationsInsightsWarehouseWalletDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    DownloadOperationsInsightsWarehouseWalletRequest,
                    DownloadOperationsInsightsWarehouseWalletResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<EnableDatabaseInsightResponse> enableDatabaseInsight(
            EnableDatabaseInsightRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            EnableDatabaseInsightRequest, EnableDatabaseInsightResponse>
                    handler) {
        LOG.trace("Called async enableDatabaseInsight");
        final EnableDatabaseInsightRequest interceptedRequest =
                EnableDatabaseInsightConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                EnableDatabaseInsightConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "EnableDatabaseInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/EnableDatabaseInsight");
        final java.util.function.Function<javax.ws.rs.core.Response, EnableDatabaseInsightResponse>
                transformer =
                        EnableDatabaseInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        EnableDatabaseInsightRequest, EnableDatabaseInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                EnableDatabaseInsightRequest, EnableDatabaseInsightResponse>,
                        java.util.concurrent.Future<EnableDatabaseInsightResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getEnableDatabaseInsightDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    EnableDatabaseInsightRequest, EnableDatabaseInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<EnableExadataInsightResponse> enableExadataInsight(
            EnableExadataInsightRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            EnableExadataInsightRequest, EnableExadataInsightResponse>
                    handler) {
        LOG.trace("Called async enableExadataInsight");
        final EnableExadataInsightRequest interceptedRequest =
                EnableExadataInsightConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                EnableExadataInsightConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "EnableExadataInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/ExadataInsights/EnableExadataInsight");
        final java.util.function.Function<javax.ws.rs.core.Response, EnableExadataInsightResponse>
                transformer =
                        EnableExadataInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        EnableExadataInsightRequest, EnableExadataInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                EnableExadataInsightRequest, EnableExadataInsightResponse>,
                        java.util.concurrent.Future<EnableExadataInsightResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getEnableExadataInsightDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    EnableExadataInsightRequest, EnableExadataInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<EnableHostInsightResponse> enableHostInsight(
            EnableHostInsightRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            EnableHostInsightRequest, EnableHostInsightResponse>
                    handler) {
        LOG.trace("Called async enableHostInsight");
        final EnableHostInsightRequest interceptedRequest =
                EnableHostInsightConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                EnableHostInsightConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "EnableHostInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/EnableHostInsight");
        final java.util.function.Function<javax.ws.rs.core.Response, EnableHostInsightResponse>
                transformer =
                        EnableHostInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<EnableHostInsightRequest, EnableHostInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                EnableHostInsightRequest, EnableHostInsightResponse>,
                        java.util.concurrent.Future<EnableHostInsightResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getEnableHostInsightDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    EnableHostInsightRequest, EnableHostInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<GetAwrDatabaseReportResponse> getAwrDatabaseReport(
            GetAwrDatabaseReportRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            GetAwrDatabaseReportRequest, GetAwrDatabaseReportResponse>
                    handler) {
        LOG.trace("Called async getAwrDatabaseReport");
        final GetAwrDatabaseReportRequest interceptedRequest =
                GetAwrDatabaseReportConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                GetAwrDatabaseReportConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "GetAwrDatabaseReport",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/GetAwrDatabaseReport");
        final java.util.function.Function<javax.ws.rs.core.Response, GetAwrDatabaseReportResponse>
                transformer =
                        GetAwrDatabaseReportConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        GetAwrDatabaseReportRequest, GetAwrDatabaseReportResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                GetAwrDatabaseReportRequest, GetAwrDatabaseReportResponse>,
                        java.util.concurrent.Future<GetAwrDatabaseReportResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    GetAwrDatabaseReportRequest, GetAwrDatabaseReportResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<GetAwrDatabaseSqlReportResponse> getAwrDatabaseSqlReport(
            GetAwrDatabaseSqlReportRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            GetAwrDatabaseSqlReportRequest, GetAwrDatabaseSqlReportResponse>
                    handler) {
        LOG.trace("Called async getAwrDatabaseSqlReport");
        final GetAwrDatabaseSqlReportRequest interceptedRequest =
                GetAwrDatabaseSqlReportConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                GetAwrDatabaseSqlReportConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "GetAwrDatabaseSqlReport",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/GetAwrDatabaseSqlReport");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, GetAwrDatabaseSqlReportResponse>
                transformer =
                        GetAwrDatabaseSqlReportConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        GetAwrDatabaseSqlReportRequest, GetAwrDatabaseSqlReportResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                GetAwrDatabaseSqlReportRequest, GetAwrDatabaseSqlReportResponse>,
                        java.util.concurrent.Future<GetAwrDatabaseSqlReportResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    GetAwrDatabaseSqlReportRequest, GetAwrDatabaseSqlReportResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<GetAwrHubResponse> getAwrHub(
            GetAwrHubRequest request,
            final com.oracle.bmc.responses.AsyncHandler<GetAwrHubRequest, GetAwrHubResponse>
                    handler) {
        LOG.trace("Called async getAwrHub");
        final GetAwrHubRequest interceptedRequest = GetAwrHubConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                GetAwrHubConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "GetAwrHub",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/GetAwrHub");
        final java.util.function.Function<javax.ws.rs.core.Response, GetAwrHubResponse>
                transformer =
                        GetAwrHubConverter.fromResponse(java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<GetAwrHubRequest, GetAwrHubResponse> handlerToUse =
                handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<GetAwrHubRequest, GetAwrHubResponse>,
                        java.util.concurrent.Future<GetAwrHubResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    GetAwrHubRequest, GetAwrHubResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<GetAwrReportResponse> getAwrReport(
            GetAwrReportRequest request,
            final com.oracle.bmc.responses.AsyncHandler<GetAwrReportRequest, GetAwrReportResponse>
                    handler) {
        LOG.trace("Called async getAwrReport");
        final GetAwrReportRequest interceptedRequest =
                GetAwrReportConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                GetAwrReportConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "GetAwrReport",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/GetAwrReport");
        final java.util.function.Function<javax.ws.rs.core.Response, GetAwrReportResponse>
                transformer =
                        GetAwrReportConverter.fromResponse(java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<GetAwrReportRequest, GetAwrReportResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                GetAwrReportRequest, GetAwrReportResponse>,
                        java.util.concurrent.Future<GetAwrReportResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    GetAwrReportRequest, GetAwrReportResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<GetDatabaseInsightResponse> getDatabaseInsight(
            GetDatabaseInsightRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            GetDatabaseInsightRequest, GetDatabaseInsightResponse>
                    handler) {
        LOG.trace("Called async getDatabaseInsight");
        final GetDatabaseInsightRequest interceptedRequest =
                GetDatabaseInsightConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                GetDatabaseInsightConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "GetDatabaseInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/GetDatabaseInsight");
        final java.util.function.Function<javax.ws.rs.core.Response, GetDatabaseInsightResponse>
                transformer =
                        GetDatabaseInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<GetDatabaseInsightRequest, GetDatabaseInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                GetDatabaseInsightRequest, GetDatabaseInsightResponse>,
                        java.util.concurrent.Future<GetDatabaseInsightResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    GetDatabaseInsightRequest, GetDatabaseInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<GetEnterpriseManagerBridgeResponse>
            getEnterpriseManagerBridge(
                    GetEnterpriseManagerBridgeRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    GetEnterpriseManagerBridgeRequest,
                                    GetEnterpriseManagerBridgeResponse>
                            handler) {
        LOG.trace("Called async getEnterpriseManagerBridge");
        final GetEnterpriseManagerBridgeRequest interceptedRequest =
                GetEnterpriseManagerBridgeConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                GetEnterpriseManagerBridgeConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "GetEnterpriseManagerBridge",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/EnterpriseManagerBridges/GetEnterpriseManagerBridge");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, GetEnterpriseManagerBridgeResponse>
                transformer =
                        GetEnterpriseManagerBridgeConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        GetEnterpriseManagerBridgeRequest, GetEnterpriseManagerBridgeResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                GetEnterpriseManagerBridgeRequest,
                                GetEnterpriseManagerBridgeResponse>,
                        java.util.concurrent.Future<GetEnterpriseManagerBridgeResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    GetEnterpriseManagerBridgeRequest, GetEnterpriseManagerBridgeResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<GetExadataInsightResponse> getExadataInsight(
            GetExadataInsightRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            GetExadataInsightRequest, GetExadataInsightResponse>
                    handler) {
        LOG.trace("Called async getExadataInsight");
        final GetExadataInsightRequest interceptedRequest =
                GetExadataInsightConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                GetExadataInsightConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "GetExadataInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/ExadataInsights/GetExadataInsight");
        final java.util.function.Function<javax.ws.rs.core.Response, GetExadataInsightResponse>
                transformer =
                        GetExadataInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<GetExadataInsightRequest, GetExadataInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                GetExadataInsightRequest, GetExadataInsightResponse>,
                        java.util.concurrent.Future<GetExadataInsightResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    GetExadataInsightRequest, GetExadataInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<GetHostInsightResponse> getHostInsight(
            GetHostInsightRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            GetHostInsightRequest, GetHostInsightResponse>
                    handler) {
        LOG.trace("Called async getHostInsight");
        final GetHostInsightRequest interceptedRequest =
                GetHostInsightConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                GetHostInsightConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "GetHostInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/GetHostInsight");
        final java.util.function.Function<javax.ws.rs.core.Response, GetHostInsightResponse>
                transformer =
                        GetHostInsightConverter.fromResponse(java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<GetHostInsightRequest, GetHostInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                GetHostInsightRequest, GetHostInsightResponse>,
                        java.util.concurrent.Future<GetHostInsightResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    GetHostInsightRequest, GetHostInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<GetOperationsInsightsPrivateEndpointResponse>
            getOperationsInsightsPrivateEndpoint(
                    GetOperationsInsightsPrivateEndpointRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    GetOperationsInsightsPrivateEndpointRequest,
                                    GetOperationsInsightsPrivateEndpointResponse>
                            handler) {
        LOG.trace("Called async getOperationsInsightsPrivateEndpoint");
        final GetOperationsInsightsPrivateEndpointRequest interceptedRequest =
                GetOperationsInsightsPrivateEndpointConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                GetOperationsInsightsPrivateEndpointConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "GetOperationsInsightsPrivateEndpoint",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OperationsInsightsPrivateEndpoint/GetOperationsInsightsPrivateEndpoint");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, GetOperationsInsightsPrivateEndpointResponse>
                transformer =
                        GetOperationsInsightsPrivateEndpointConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        GetOperationsInsightsPrivateEndpointRequest,
                        GetOperationsInsightsPrivateEndpointResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                GetOperationsInsightsPrivateEndpointRequest,
                                GetOperationsInsightsPrivateEndpointResponse>,
                        java.util.concurrent.Future<GetOperationsInsightsPrivateEndpointResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    GetOperationsInsightsPrivateEndpointRequest,
                    GetOperationsInsightsPrivateEndpointResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<GetOperationsInsightsWarehouseResponse>
            getOperationsInsightsWarehouse(
                    GetOperationsInsightsWarehouseRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    GetOperationsInsightsWarehouseRequest,
                                    GetOperationsInsightsWarehouseResponse>
                            handler) {
        LOG.trace("Called async getOperationsInsightsWarehouse");
        final GetOperationsInsightsWarehouseRequest interceptedRequest =
                GetOperationsInsightsWarehouseConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                GetOperationsInsightsWarehouseConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "GetOperationsInsightsWarehouse",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OperationsInsightsWarehouses/GetOperationsInsightsWarehouse");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, GetOperationsInsightsWarehouseResponse>
                transformer =
                        GetOperationsInsightsWarehouseConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        GetOperationsInsightsWarehouseRequest,
                        GetOperationsInsightsWarehouseResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                GetOperationsInsightsWarehouseRequest,
                                GetOperationsInsightsWarehouseResponse>,
                        java.util.concurrent.Future<GetOperationsInsightsWarehouseResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    GetOperationsInsightsWarehouseRequest, GetOperationsInsightsWarehouseResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<GetOperationsInsightsWarehouseUserResponse>
            getOperationsInsightsWarehouseUser(
                    GetOperationsInsightsWarehouseUserRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    GetOperationsInsightsWarehouseUserRequest,
                                    GetOperationsInsightsWarehouseUserResponse>
                            handler) {
        LOG.trace("Called async getOperationsInsightsWarehouseUser");
        final GetOperationsInsightsWarehouseUserRequest interceptedRequest =
                GetOperationsInsightsWarehouseUserConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                GetOperationsInsightsWarehouseUserConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "GetOperationsInsightsWarehouseUser",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OperationsInsightsWarehouseUsers/GetOperationsInsightsWarehouseUser");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, GetOperationsInsightsWarehouseUserResponse>
                transformer =
                        GetOperationsInsightsWarehouseUserConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        GetOperationsInsightsWarehouseUserRequest,
                        GetOperationsInsightsWarehouseUserResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                GetOperationsInsightsWarehouseUserRequest,
                                GetOperationsInsightsWarehouseUserResponse>,
                        java.util.concurrent.Future<GetOperationsInsightsWarehouseUserResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    GetOperationsInsightsWarehouseUserRequest,
                    GetOperationsInsightsWarehouseUserResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<GetOpsiConfigurationResponse> getOpsiConfiguration(
            GetOpsiConfigurationRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            GetOpsiConfigurationRequest, GetOpsiConfigurationResponse>
                    handler) {
        LOG.trace("Called async getOpsiConfiguration");
        final GetOpsiConfigurationRequest interceptedRequest =
                GetOpsiConfigurationConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                GetOpsiConfigurationConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "GetOpsiConfiguration",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OpsiConfigurations/GetOpsiConfiguration");
        final java.util.function.Function<javax.ws.rs.core.Response, GetOpsiConfigurationResponse>
                transformer =
                        GetOpsiConfigurationConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        GetOpsiConfigurationRequest, GetOpsiConfigurationResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                GetOpsiConfigurationRequest, GetOpsiConfigurationResponse>,
                        java.util.concurrent.Future<GetOpsiConfigurationResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    GetOpsiConfigurationRequest, GetOpsiConfigurationResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<GetOpsiDataObjectResponse> getOpsiDataObject(
            GetOpsiDataObjectRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            GetOpsiDataObjectRequest, GetOpsiDataObjectResponse>
                    handler) {
        LOG.trace("Called async getOpsiDataObject");
        final GetOpsiDataObjectRequest interceptedRequest =
                GetOpsiDataObjectConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                GetOpsiDataObjectConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "GetOpsiDataObject",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OpsiDataObjects/GetOpsiDataObject");
        final java.util.function.Function<javax.ws.rs.core.Response, GetOpsiDataObjectResponse>
                transformer =
                        GetOpsiDataObjectConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<GetOpsiDataObjectRequest, GetOpsiDataObjectResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                GetOpsiDataObjectRequest, GetOpsiDataObjectResponse>,
                        java.util.concurrent.Future<GetOpsiDataObjectResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    GetOpsiDataObjectRequest, GetOpsiDataObjectResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<GetWorkRequestResponse> getWorkRequest(
            GetWorkRequestRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            GetWorkRequestRequest, GetWorkRequestResponse>
                    handler) {
        LOG.trace("Called async getWorkRequest");
        final GetWorkRequestRequest interceptedRequest =
                GetWorkRequestConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                GetWorkRequestConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "GetWorkRequest",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/WorkRequests/GetWorkRequest");
        final java.util.function.Function<javax.ws.rs.core.Response, GetWorkRequestResponse>
                transformer =
                        GetWorkRequestConverter.fromResponse(java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<GetWorkRequestRequest, GetWorkRequestResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                GetWorkRequestRequest, GetWorkRequestResponse>,
                        java.util.concurrent.Future<GetWorkRequestResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    GetWorkRequestRequest, GetWorkRequestResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<IngestDatabaseConfigurationResponse>
            ingestDatabaseConfiguration(
                    IngestDatabaseConfigurationRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    IngestDatabaseConfigurationRequest,
                                    IngestDatabaseConfigurationResponse>
                            handler) {
        LOG.trace("Called async ingestDatabaseConfiguration");
        final IngestDatabaseConfigurationRequest interceptedRequest =
                IngestDatabaseConfigurationConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                IngestDatabaseConfigurationConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "IngestDatabaseConfiguration",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/IngestDatabaseConfiguration");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, IngestDatabaseConfigurationResponse>
                transformer =
                        IngestDatabaseConfigurationConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        IngestDatabaseConfigurationRequest, IngestDatabaseConfigurationResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                IngestDatabaseConfigurationRequest,
                                IngestDatabaseConfigurationResponse>,
                        java.util.concurrent.Future<IngestDatabaseConfigurationResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getIngestDatabaseConfigurationDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    IngestDatabaseConfigurationRequest, IngestDatabaseConfigurationResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<IngestHostConfigurationResponse> ingestHostConfiguration(
            IngestHostConfigurationRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            IngestHostConfigurationRequest, IngestHostConfigurationResponse>
                    handler) {
        LOG.trace("Called async ingestHostConfiguration");
        final IngestHostConfigurationRequest interceptedRequest =
                IngestHostConfigurationConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                IngestHostConfigurationConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "IngestHostConfiguration",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/IngestHostConfiguration");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, IngestHostConfigurationResponse>
                transformer =
                        IngestHostConfigurationConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        IngestHostConfigurationRequest, IngestHostConfigurationResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                IngestHostConfigurationRequest, IngestHostConfigurationResponse>,
                        java.util.concurrent.Future<IngestHostConfigurationResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getIngestHostConfigurationDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    IngestHostConfigurationRequest, IngestHostConfigurationResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<IngestHostMetricsResponse> ingestHostMetrics(
            IngestHostMetricsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            IngestHostMetricsRequest, IngestHostMetricsResponse>
                    handler) {
        LOG.trace("Called async ingestHostMetrics");
        final IngestHostMetricsRequest interceptedRequest =
                IngestHostMetricsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                IngestHostMetricsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "IngestHostMetrics",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/IngestHostMetrics");
        final java.util.function.Function<javax.ws.rs.core.Response, IngestHostMetricsResponse>
                transformer =
                        IngestHostMetricsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<IngestHostMetricsRequest, IngestHostMetricsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                IngestHostMetricsRequest, IngestHostMetricsResponse>,
                        java.util.concurrent.Future<IngestHostMetricsResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getIngestHostMetricsDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    IngestHostMetricsRequest, IngestHostMetricsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<IngestSqlBucketResponse> ingestSqlBucket(
            IngestSqlBucketRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            IngestSqlBucketRequest, IngestSqlBucketResponse>
                    handler) {
        LOG.trace("Called async ingestSqlBucket");
        final IngestSqlBucketRequest interceptedRequest =
                IngestSqlBucketConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                IngestSqlBucketConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "IngestSqlBucket",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/IngestSqlBucket");
        final java.util.function.Function<javax.ws.rs.core.Response, IngestSqlBucketResponse>
                transformer =
                        IngestSqlBucketConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<IngestSqlBucketRequest, IngestSqlBucketResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                IngestSqlBucketRequest, IngestSqlBucketResponse>,
                        java.util.concurrent.Future<IngestSqlBucketResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getIngestSqlBucketDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    IngestSqlBucketRequest, IngestSqlBucketResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<IngestSqlPlanLinesResponse> ingestSqlPlanLines(
            IngestSqlPlanLinesRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            IngestSqlPlanLinesRequest, IngestSqlPlanLinesResponse>
                    handler) {
        LOG.trace("Called async ingestSqlPlanLines");
        final IngestSqlPlanLinesRequest interceptedRequest =
                IngestSqlPlanLinesConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                IngestSqlPlanLinesConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "IngestSqlPlanLines",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/IngestSqlPlanLines");
        final java.util.function.Function<javax.ws.rs.core.Response, IngestSqlPlanLinesResponse>
                transformer =
                        IngestSqlPlanLinesConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<IngestSqlPlanLinesRequest, IngestSqlPlanLinesResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                IngestSqlPlanLinesRequest, IngestSqlPlanLinesResponse>,
                        java.util.concurrent.Future<IngestSqlPlanLinesResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getIngestSqlPlanLinesDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    IngestSqlPlanLinesRequest, IngestSqlPlanLinesResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<IngestSqlStatsResponse> ingestSqlStats(
            IngestSqlStatsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            IngestSqlStatsRequest, IngestSqlStatsResponse>
                    handler) {
        LOG.trace("Called async ingestSqlStats");
        final IngestSqlStatsRequest interceptedRequest =
                IngestSqlStatsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                IngestSqlStatsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "IngestSqlStats",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/IngestSqlStats");
        final java.util.function.Function<javax.ws.rs.core.Response, IngestSqlStatsResponse>
                transformer =
                        IngestSqlStatsConverter.fromResponse(java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<IngestSqlStatsRequest, IngestSqlStatsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                IngestSqlStatsRequest, IngestSqlStatsResponse>,
                        java.util.concurrent.Future<IngestSqlStatsResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getIngestSqlStatsDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    IngestSqlStatsRequest, IngestSqlStatsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<IngestSqlTextResponse> ingestSqlText(
            IngestSqlTextRequest request,
            final com.oracle.bmc.responses.AsyncHandler<IngestSqlTextRequest, IngestSqlTextResponse>
                    handler) {
        LOG.trace("Called async ingestSqlText");
        final IngestSqlTextRequest interceptedRequest =
                IngestSqlTextConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                IngestSqlTextConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.http.internal.RetryTokenUtils.addRetryToken(ib);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "IngestSqlText",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/IngestSqlText");
        final java.util.function.Function<javax.ws.rs.core.Response, IngestSqlTextResponse>
                transformer =
                        IngestSqlTextConverter.fromResponse(java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<IngestSqlTextRequest, IngestSqlTextResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                IngestSqlTextRequest, IngestSqlTextResponse>,
                        java.util.concurrent.Future<IngestSqlTextResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getIngestSqlTextDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    IngestSqlTextRequest, IngestSqlTextResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListAwrDatabaseSnapshotsResponse> listAwrDatabaseSnapshots(
            ListAwrDatabaseSnapshotsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListAwrDatabaseSnapshotsRequest, ListAwrDatabaseSnapshotsResponse>
                    handler) {
        LOG.trace("Called async listAwrDatabaseSnapshots");
        final ListAwrDatabaseSnapshotsRequest interceptedRequest =
                ListAwrDatabaseSnapshotsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListAwrDatabaseSnapshotsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListAwrDatabaseSnapshots",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/ListAwrDatabaseSnapshots");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, ListAwrDatabaseSnapshotsResponse>
                transformer =
                        ListAwrDatabaseSnapshotsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ListAwrDatabaseSnapshotsRequest, ListAwrDatabaseSnapshotsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListAwrDatabaseSnapshotsRequest, ListAwrDatabaseSnapshotsResponse>,
                        java.util.concurrent.Future<ListAwrDatabaseSnapshotsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListAwrDatabaseSnapshotsRequest, ListAwrDatabaseSnapshotsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListAwrDatabasesResponse> listAwrDatabases(
            ListAwrDatabasesRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListAwrDatabasesRequest, ListAwrDatabasesResponse>
                    handler) {
        LOG.trace("Called async listAwrDatabases");
        final ListAwrDatabasesRequest interceptedRequest =
                ListAwrDatabasesConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListAwrDatabasesConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListAwrDatabases",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/ListAwrDatabases");
        final java.util.function.Function<javax.ws.rs.core.Response, ListAwrDatabasesResponse>
                transformer =
                        ListAwrDatabasesConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<ListAwrDatabasesRequest, ListAwrDatabasesResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListAwrDatabasesRequest, ListAwrDatabasesResponse>,
                        java.util.concurrent.Future<ListAwrDatabasesResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListAwrDatabasesRequest, ListAwrDatabasesResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListAwrHubsResponse> listAwrHubs(
            ListAwrHubsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<ListAwrHubsRequest, ListAwrHubsResponse>
                    handler) {
        LOG.trace("Called async listAwrHubs");
        final ListAwrHubsRequest interceptedRequest =
                ListAwrHubsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListAwrHubsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListAwrHubs",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/ListAwrHubs");
        final java.util.function.Function<javax.ws.rs.core.Response, ListAwrHubsResponse>
                transformer =
                        ListAwrHubsConverter.fromResponse(java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<ListAwrHubsRequest, ListAwrHubsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListAwrHubsRequest, ListAwrHubsResponse>,
                        java.util.concurrent.Future<ListAwrHubsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListAwrHubsRequest, ListAwrHubsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListAwrSnapshotsResponse> listAwrSnapshots(
            ListAwrSnapshotsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListAwrSnapshotsRequest, ListAwrSnapshotsResponse>
                    handler) {
        LOG.trace("Called async listAwrSnapshots");
        final ListAwrSnapshotsRequest interceptedRequest =
                ListAwrSnapshotsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListAwrSnapshotsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListAwrSnapshots",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/ListAwrSnapshots");
        final java.util.function.Function<javax.ws.rs.core.Response, ListAwrSnapshotsResponse>
                transformer =
                        ListAwrSnapshotsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<ListAwrSnapshotsRequest, ListAwrSnapshotsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListAwrSnapshotsRequest, ListAwrSnapshotsResponse>,
                        java.util.concurrent.Future<ListAwrSnapshotsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListAwrSnapshotsRequest, ListAwrSnapshotsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListDatabaseConfigurationsResponse>
            listDatabaseConfigurations(
                    ListDatabaseConfigurationsRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    ListDatabaseConfigurationsRequest,
                                    ListDatabaseConfigurationsResponse>
                            handler) {
        LOG.trace("Called async listDatabaseConfigurations");
        final ListDatabaseConfigurationsRequest interceptedRequest =
                ListDatabaseConfigurationsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListDatabaseConfigurationsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListDatabaseConfigurations",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/ListDatabaseConfigurations");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, ListDatabaseConfigurationsResponse>
                transformer =
                        ListDatabaseConfigurationsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ListDatabaseConfigurationsRequest, ListDatabaseConfigurationsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListDatabaseConfigurationsRequest,
                                ListDatabaseConfigurationsResponse>,
                        java.util.concurrent.Future<ListDatabaseConfigurationsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListDatabaseConfigurationsRequest, ListDatabaseConfigurationsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListDatabaseInsightsResponse> listDatabaseInsights(
            ListDatabaseInsightsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListDatabaseInsightsRequest, ListDatabaseInsightsResponse>
                    handler) {
        LOG.trace("Called async listDatabaseInsights");
        final ListDatabaseInsightsRequest interceptedRequest =
                ListDatabaseInsightsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListDatabaseInsightsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListDatabaseInsights",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/ListDatabaseInsights");
        final java.util.function.Function<javax.ws.rs.core.Response, ListDatabaseInsightsResponse>
                transformer =
                        ListDatabaseInsightsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ListDatabaseInsightsRequest, ListDatabaseInsightsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListDatabaseInsightsRequest, ListDatabaseInsightsResponse>,
                        java.util.concurrent.Future<ListDatabaseInsightsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListDatabaseInsightsRequest, ListDatabaseInsightsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListEnterpriseManagerBridgesResponse>
            listEnterpriseManagerBridges(
                    ListEnterpriseManagerBridgesRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    ListEnterpriseManagerBridgesRequest,
                                    ListEnterpriseManagerBridgesResponse>
                            handler) {
        LOG.trace("Called async listEnterpriseManagerBridges");
        final ListEnterpriseManagerBridgesRequest interceptedRequest =
                ListEnterpriseManagerBridgesConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListEnterpriseManagerBridgesConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListEnterpriseManagerBridges",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/EnterpriseManagerBridges/ListEnterpriseManagerBridges");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, ListEnterpriseManagerBridgesResponse>
                transformer =
                        ListEnterpriseManagerBridgesConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ListEnterpriseManagerBridgesRequest, ListEnterpriseManagerBridgesResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListEnterpriseManagerBridgesRequest,
                                ListEnterpriseManagerBridgesResponse>,
                        java.util.concurrent.Future<ListEnterpriseManagerBridgesResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListEnterpriseManagerBridgesRequest, ListEnterpriseManagerBridgesResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListExadataConfigurationsResponse> listExadataConfigurations(
            ListExadataConfigurationsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListExadataConfigurationsRequest, ListExadataConfigurationsResponse>
                    handler) {
        LOG.trace("Called async listExadataConfigurations");
        final ListExadataConfigurationsRequest interceptedRequest =
                ListExadataConfigurationsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListExadataConfigurationsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListExadataConfigurations",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/ExadataInsights/ListExadataConfigurations");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, ListExadataConfigurationsResponse>
                transformer =
                        ListExadataConfigurationsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ListExadataConfigurationsRequest, ListExadataConfigurationsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListExadataConfigurationsRequest,
                                ListExadataConfigurationsResponse>,
                        java.util.concurrent.Future<ListExadataConfigurationsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListExadataConfigurationsRequest, ListExadataConfigurationsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListExadataInsightsResponse> listExadataInsights(
            ListExadataInsightsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListExadataInsightsRequest, ListExadataInsightsResponse>
                    handler) {
        LOG.trace("Called async listExadataInsights");
        final ListExadataInsightsRequest interceptedRequest =
                ListExadataInsightsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListExadataInsightsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListExadataInsights",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/ExadataInsights/ListExadataInsights");
        final java.util.function.Function<javax.ws.rs.core.Response, ListExadataInsightsResponse>
                transformer =
                        ListExadataInsightsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ListExadataInsightsRequest, ListExadataInsightsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListExadataInsightsRequest, ListExadataInsightsResponse>,
                        java.util.concurrent.Future<ListExadataInsightsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListExadataInsightsRequest, ListExadataInsightsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListHostConfigurationsResponse> listHostConfigurations(
            ListHostConfigurationsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListHostConfigurationsRequest, ListHostConfigurationsResponse>
                    handler) {
        LOG.trace("Called async listHostConfigurations");
        final ListHostConfigurationsRequest interceptedRequest =
                ListHostConfigurationsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListHostConfigurationsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListHostConfigurations",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/ListHostConfigurations");
        final java.util.function.Function<javax.ws.rs.core.Response, ListHostConfigurationsResponse>
                transformer =
                        ListHostConfigurationsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ListHostConfigurationsRequest, ListHostConfigurationsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListHostConfigurationsRequest, ListHostConfigurationsResponse>,
                        java.util.concurrent.Future<ListHostConfigurationsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListHostConfigurationsRequest, ListHostConfigurationsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListHostInsightsResponse> listHostInsights(
            ListHostInsightsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListHostInsightsRequest, ListHostInsightsResponse>
                    handler) {
        LOG.trace("Called async listHostInsights");
        final ListHostInsightsRequest interceptedRequest =
                ListHostInsightsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListHostInsightsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListHostInsights",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/ListHostInsights");
        final java.util.function.Function<javax.ws.rs.core.Response, ListHostInsightsResponse>
                transformer =
                        ListHostInsightsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<ListHostInsightsRequest, ListHostInsightsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListHostInsightsRequest, ListHostInsightsResponse>,
                        java.util.concurrent.Future<ListHostInsightsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListHostInsightsRequest, ListHostInsightsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListHostedEntitiesResponse> listHostedEntities(
            ListHostedEntitiesRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListHostedEntitiesRequest, ListHostedEntitiesResponse>
                    handler) {
        LOG.trace("Called async listHostedEntities");
        final ListHostedEntitiesRequest interceptedRequest =
                ListHostedEntitiesConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListHostedEntitiesConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListHostedEntities",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/ListHostedEntities");
        final java.util.function.Function<javax.ws.rs.core.Response, ListHostedEntitiesResponse>
                transformer =
                        ListHostedEntitiesConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<ListHostedEntitiesRequest, ListHostedEntitiesResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListHostedEntitiesRequest, ListHostedEntitiesResponse>,
                        java.util.concurrent.Future<ListHostedEntitiesResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListHostedEntitiesRequest, ListHostedEntitiesResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListImportableAgentEntitiesResponse>
            listImportableAgentEntities(
                    ListImportableAgentEntitiesRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    ListImportableAgentEntitiesRequest,
                                    ListImportableAgentEntitiesResponse>
                            handler) {
        LOG.trace("Called async listImportableAgentEntities");
        final ListImportableAgentEntitiesRequest interceptedRequest =
                ListImportableAgentEntitiesConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListImportableAgentEntitiesConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListImportableAgentEntities",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/ListImportableAgentEntities");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, ListImportableAgentEntitiesResponse>
                transformer =
                        ListImportableAgentEntitiesConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ListImportableAgentEntitiesRequest, ListImportableAgentEntitiesResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListImportableAgentEntitiesRequest,
                                ListImportableAgentEntitiesResponse>,
                        java.util.concurrent.Future<ListImportableAgentEntitiesResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListImportableAgentEntitiesRequest, ListImportableAgentEntitiesResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListImportableComputeEntitiesResponse>
            listImportableComputeEntities(
                    ListImportableComputeEntitiesRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    ListImportableComputeEntitiesRequest,
                                    ListImportableComputeEntitiesResponse>
                            handler) {
        LOG.trace("Called async listImportableComputeEntities");
        final ListImportableComputeEntitiesRequest interceptedRequest =
                ListImportableComputeEntitiesConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListImportableComputeEntitiesConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListImportableComputeEntities",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/ListImportableComputeEntities");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, ListImportableComputeEntitiesResponse>
                transformer =
                        ListImportableComputeEntitiesConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ListImportableComputeEntitiesRequest, ListImportableComputeEntitiesResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListImportableComputeEntitiesRequest,
                                ListImportableComputeEntitiesResponse>,
                        java.util.concurrent.Future<ListImportableComputeEntitiesResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListImportableComputeEntitiesRequest, ListImportableComputeEntitiesResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListImportableEnterpriseManagerEntitiesResponse>
            listImportableEnterpriseManagerEntities(
                    ListImportableEnterpriseManagerEntitiesRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    ListImportableEnterpriseManagerEntitiesRequest,
                                    ListImportableEnterpriseManagerEntitiesResponse>
                            handler) {
        LOG.trace("Called async listImportableEnterpriseManagerEntities");
        final ListImportableEnterpriseManagerEntitiesRequest interceptedRequest =
                ListImportableEnterpriseManagerEntitiesConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListImportableEnterpriseManagerEntitiesConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListImportableEnterpriseManagerEntities",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/EnterpriseManagerBridges/ListImportableEnterpriseManagerEntities");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, ListImportableEnterpriseManagerEntitiesResponse>
                transformer =
                        ListImportableEnterpriseManagerEntitiesConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ListImportableEnterpriseManagerEntitiesRequest,
                        ListImportableEnterpriseManagerEntitiesResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListImportableEnterpriseManagerEntitiesRequest,
                                ListImportableEnterpriseManagerEntitiesResponse>,
                        java.util.concurrent.Future<
                                ListImportableEnterpriseManagerEntitiesResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListImportableEnterpriseManagerEntitiesRequest,
                    ListImportableEnterpriseManagerEntitiesResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListOperationsInsightsPrivateEndpointsResponse>
            listOperationsInsightsPrivateEndpoints(
                    ListOperationsInsightsPrivateEndpointsRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    ListOperationsInsightsPrivateEndpointsRequest,
                                    ListOperationsInsightsPrivateEndpointsResponse>
                            handler) {
        LOG.trace("Called async listOperationsInsightsPrivateEndpoints");
        final ListOperationsInsightsPrivateEndpointsRequest interceptedRequest =
                ListOperationsInsightsPrivateEndpointsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListOperationsInsightsPrivateEndpointsConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListOperationsInsightsPrivateEndpoints",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OperationsInsightsPrivateEndpoint/ListOperationsInsightsPrivateEndpoints");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, ListOperationsInsightsPrivateEndpointsResponse>
                transformer =
                        ListOperationsInsightsPrivateEndpointsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ListOperationsInsightsPrivateEndpointsRequest,
                        ListOperationsInsightsPrivateEndpointsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListOperationsInsightsPrivateEndpointsRequest,
                                ListOperationsInsightsPrivateEndpointsResponse>,
                        java.util.concurrent.Future<ListOperationsInsightsPrivateEndpointsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListOperationsInsightsPrivateEndpointsRequest,
                    ListOperationsInsightsPrivateEndpointsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListOperationsInsightsWarehouseUsersResponse>
            listOperationsInsightsWarehouseUsers(
                    ListOperationsInsightsWarehouseUsersRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    ListOperationsInsightsWarehouseUsersRequest,
                                    ListOperationsInsightsWarehouseUsersResponse>
                            handler) {
        LOG.trace("Called async listOperationsInsightsWarehouseUsers");
        final ListOperationsInsightsWarehouseUsersRequest interceptedRequest =
                ListOperationsInsightsWarehouseUsersConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListOperationsInsightsWarehouseUsersConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListOperationsInsightsWarehouseUsers",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OperationsInsightsWarehouseUsers/ListOperationsInsightsWarehouseUsers");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, ListOperationsInsightsWarehouseUsersResponse>
                transformer =
                        ListOperationsInsightsWarehouseUsersConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ListOperationsInsightsWarehouseUsersRequest,
                        ListOperationsInsightsWarehouseUsersResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListOperationsInsightsWarehouseUsersRequest,
                                ListOperationsInsightsWarehouseUsersResponse>,
                        java.util.concurrent.Future<ListOperationsInsightsWarehouseUsersResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListOperationsInsightsWarehouseUsersRequest,
                    ListOperationsInsightsWarehouseUsersResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListOperationsInsightsWarehousesResponse>
            listOperationsInsightsWarehouses(
                    ListOperationsInsightsWarehousesRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    ListOperationsInsightsWarehousesRequest,
                                    ListOperationsInsightsWarehousesResponse>
                            handler) {
        LOG.trace("Called async listOperationsInsightsWarehouses");
        final ListOperationsInsightsWarehousesRequest interceptedRequest =
                ListOperationsInsightsWarehousesConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListOperationsInsightsWarehousesConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListOperationsInsightsWarehouses",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OperationsInsightsWarehouses/ListOperationsInsightsWarehouses");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, ListOperationsInsightsWarehousesResponse>
                transformer =
                        ListOperationsInsightsWarehousesConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ListOperationsInsightsWarehousesRequest,
                        ListOperationsInsightsWarehousesResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListOperationsInsightsWarehousesRequest,
                                ListOperationsInsightsWarehousesResponse>,
                        java.util.concurrent.Future<ListOperationsInsightsWarehousesResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListOperationsInsightsWarehousesRequest,
                    ListOperationsInsightsWarehousesResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListOpsiConfigurationsResponse> listOpsiConfigurations(
            ListOpsiConfigurationsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListOpsiConfigurationsRequest, ListOpsiConfigurationsResponse>
                    handler) {
        LOG.trace("Called async listOpsiConfigurations");
        final ListOpsiConfigurationsRequest interceptedRequest =
                ListOpsiConfigurationsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListOpsiConfigurationsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListOpsiConfigurations",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OpsiConfigurations/ListOpsiConfigurations");
        final java.util.function.Function<javax.ws.rs.core.Response, ListOpsiConfigurationsResponse>
                transformer =
                        ListOpsiConfigurationsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ListOpsiConfigurationsRequest, ListOpsiConfigurationsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListOpsiConfigurationsRequest, ListOpsiConfigurationsResponse>,
                        java.util.concurrent.Future<ListOpsiConfigurationsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListOpsiConfigurationsRequest, ListOpsiConfigurationsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListOpsiDataObjectsResponse> listOpsiDataObjects(
            ListOpsiDataObjectsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListOpsiDataObjectsRequest, ListOpsiDataObjectsResponse>
                    handler) {
        LOG.trace("Called async listOpsiDataObjects");
        final ListOpsiDataObjectsRequest interceptedRequest =
                ListOpsiDataObjectsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListOpsiDataObjectsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListOpsiDataObjects",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OpsiDataObjects/ListOpsiDataObjects");
        final java.util.function.Function<javax.ws.rs.core.Response, ListOpsiDataObjectsResponse>
                transformer =
                        ListOpsiDataObjectsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ListOpsiDataObjectsRequest, ListOpsiDataObjectsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListOpsiDataObjectsRequest, ListOpsiDataObjectsResponse>,
                        java.util.concurrent.Future<ListOpsiDataObjectsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListOpsiDataObjectsRequest, ListOpsiDataObjectsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListSqlPlansResponse> listSqlPlans(
            ListSqlPlansRequest request,
            final com.oracle.bmc.responses.AsyncHandler<ListSqlPlansRequest, ListSqlPlansResponse>
                    handler) {
        LOG.trace("Called async listSqlPlans");
        final ListSqlPlansRequest interceptedRequest =
                ListSqlPlansConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListSqlPlansConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListSqlPlans",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/ListSqlPlans");
        final java.util.function.Function<javax.ws.rs.core.Response, ListSqlPlansResponse>
                transformer =
                        ListSqlPlansConverter.fromResponse(java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<ListSqlPlansRequest, ListSqlPlansResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListSqlPlansRequest, ListSqlPlansResponse>,
                        java.util.concurrent.Future<ListSqlPlansResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListSqlPlansRequest, ListSqlPlansResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListSqlSearchesResponse> listSqlSearches(
            ListSqlSearchesRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListSqlSearchesRequest, ListSqlSearchesResponse>
                    handler) {
        LOG.trace("Called async listSqlSearches");
        final ListSqlSearchesRequest interceptedRequest =
                ListSqlSearchesConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListSqlSearchesConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListSqlSearches",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/ListSqlSearches");
        final java.util.function.Function<javax.ws.rs.core.Response, ListSqlSearchesResponse>
                transformer =
                        ListSqlSearchesConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<ListSqlSearchesRequest, ListSqlSearchesResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListSqlSearchesRequest, ListSqlSearchesResponse>,
                        java.util.concurrent.Future<ListSqlSearchesResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListSqlSearchesRequest, ListSqlSearchesResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListSqlTextsResponse> listSqlTexts(
            ListSqlTextsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<ListSqlTextsRequest, ListSqlTextsResponse>
                    handler) {
        LOG.trace("Called async listSqlTexts");
        final ListSqlTextsRequest interceptedRequest =
                ListSqlTextsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListSqlTextsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListSqlTexts",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/ListSqlTexts");
        final java.util.function.Function<javax.ws.rs.core.Response, ListSqlTextsResponse>
                transformer =
                        ListSqlTextsConverter.fromResponse(java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<ListSqlTextsRequest, ListSqlTextsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListSqlTextsRequest, ListSqlTextsResponse>,
                        java.util.concurrent.Future<ListSqlTextsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListSqlTextsRequest, ListSqlTextsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListWorkRequestErrorsResponse> listWorkRequestErrors(
            ListWorkRequestErrorsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListWorkRequestErrorsRequest, ListWorkRequestErrorsResponse>
                    handler) {
        LOG.trace("Called async listWorkRequestErrors");
        final ListWorkRequestErrorsRequest interceptedRequest =
                ListWorkRequestErrorsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListWorkRequestErrorsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListWorkRequestErrors",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/WorkRequests/ListWorkRequestErrors");
        final java.util.function.Function<javax.ws.rs.core.Response, ListWorkRequestErrorsResponse>
                transformer =
                        ListWorkRequestErrorsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ListWorkRequestErrorsRequest, ListWorkRequestErrorsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListWorkRequestErrorsRequest, ListWorkRequestErrorsResponse>,
                        java.util.concurrent.Future<ListWorkRequestErrorsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListWorkRequestErrorsRequest, ListWorkRequestErrorsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListWorkRequestLogsResponse> listWorkRequestLogs(
            ListWorkRequestLogsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListWorkRequestLogsRequest, ListWorkRequestLogsResponse>
                    handler) {
        LOG.trace("Called async listWorkRequestLogs");
        final ListWorkRequestLogsRequest interceptedRequest =
                ListWorkRequestLogsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListWorkRequestLogsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListWorkRequestLogs",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/WorkRequests/ListWorkRequestLogs");
        final java.util.function.Function<javax.ws.rs.core.Response, ListWorkRequestLogsResponse>
                transformer =
                        ListWorkRequestLogsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        ListWorkRequestLogsRequest, ListWorkRequestLogsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListWorkRequestLogsRequest, ListWorkRequestLogsResponse>,
                        java.util.concurrent.Future<ListWorkRequestLogsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListWorkRequestLogsRequest, ListWorkRequestLogsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<ListWorkRequestsResponse> listWorkRequests(
            ListWorkRequestsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            ListWorkRequestsRequest, ListWorkRequestsResponse>
                    handler) {
        LOG.trace("Called async listWorkRequests");
        final ListWorkRequestsRequest interceptedRequest =
                ListWorkRequestsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                ListWorkRequestsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "ListWorkRequests",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/WorkRequests/ListWorkRequests");
        final java.util.function.Function<javax.ws.rs.core.Response, ListWorkRequestsResponse>
                transformer =
                        ListWorkRequestsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<ListWorkRequestsRequest, ListWorkRequestsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                ListWorkRequestsRequest, ListWorkRequestsResponse>,
                        java.util.concurrent.Future<ListWorkRequestsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    ListWorkRequestsRequest, ListWorkRequestsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<QueryOpsiDataObjectDataResponse> queryOpsiDataObjectData(
            QueryOpsiDataObjectDataRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            QueryOpsiDataObjectDataRequest, QueryOpsiDataObjectDataResponse>
                    handler) {
        LOG.trace("Called async queryOpsiDataObjectData");
        final QueryOpsiDataObjectDataRequest interceptedRequest =
                QueryOpsiDataObjectDataConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                QueryOpsiDataObjectDataConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "QueryOpsiDataObjectData",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OpsiDataObjects/QueryOpsiDataObjectData");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, QueryOpsiDataObjectDataResponse>
                transformer =
                        QueryOpsiDataObjectDataConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        QueryOpsiDataObjectDataRequest, QueryOpsiDataObjectDataResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                QueryOpsiDataObjectDataRequest, QueryOpsiDataObjectDataResponse>,
                        java.util.concurrent.Future<QueryOpsiDataObjectDataResponse>>
                futureSupplier =
                        client.postFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getQueryOpsiDataObjectDataDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    QueryOpsiDataObjectDataRequest, QueryOpsiDataObjectDataResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<RotateOperationsInsightsWarehouseWalletResponse>
            rotateOperationsInsightsWarehouseWallet(
                    RotateOperationsInsightsWarehouseWalletRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    RotateOperationsInsightsWarehouseWalletRequest,
                                    RotateOperationsInsightsWarehouseWalletResponse>
                            handler) {
        LOG.trace("Called async rotateOperationsInsightsWarehouseWallet");
        final RotateOperationsInsightsWarehouseWalletRequest interceptedRequest =
                RotateOperationsInsightsWarehouseWalletConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                RotateOperationsInsightsWarehouseWalletConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "RotateOperationsInsightsWarehouseWallet",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OperationsInsightsWarehouses/RotateOperationsInsightsWarehouseWallet");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, RotateOperationsInsightsWarehouseWalletResponse>
                transformer =
                        RotateOperationsInsightsWarehouseWalletConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        RotateOperationsInsightsWarehouseWalletRequest,
                        RotateOperationsInsightsWarehouseWalletResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                RotateOperationsInsightsWarehouseWalletRequest,
                                RotateOperationsInsightsWarehouseWalletResponse>,
                        java.util.concurrent.Future<
                                RotateOperationsInsightsWarehouseWalletResponse>>
                futureSupplier = client.postFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    RotateOperationsInsightsWarehouseWalletRequest,
                    RotateOperationsInsightsWarehouseWalletResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeAwrDatabaseCpuUsagesResponse>
            summarizeAwrDatabaseCpuUsages(
                    SummarizeAwrDatabaseCpuUsagesRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeAwrDatabaseCpuUsagesRequest,
                                    SummarizeAwrDatabaseCpuUsagesResponse>
                            handler) {
        LOG.trace("Called async summarizeAwrDatabaseCpuUsages");
        final SummarizeAwrDatabaseCpuUsagesRequest interceptedRequest =
                SummarizeAwrDatabaseCpuUsagesConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeAwrDatabaseCpuUsagesConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeAwrDatabaseCpuUsages",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/SummarizeAwrDatabaseCpuUsages");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeAwrDatabaseCpuUsagesResponse>
                transformer =
                        SummarizeAwrDatabaseCpuUsagesConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeAwrDatabaseCpuUsagesRequest, SummarizeAwrDatabaseCpuUsagesResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeAwrDatabaseCpuUsagesRequest,
                                SummarizeAwrDatabaseCpuUsagesResponse>,
                        java.util.concurrent.Future<SummarizeAwrDatabaseCpuUsagesResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeAwrDatabaseCpuUsagesRequest, SummarizeAwrDatabaseCpuUsagesResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeAwrDatabaseMetricsResponse>
            summarizeAwrDatabaseMetrics(
                    SummarizeAwrDatabaseMetricsRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeAwrDatabaseMetricsRequest,
                                    SummarizeAwrDatabaseMetricsResponse>
                            handler) {
        LOG.trace("Called async summarizeAwrDatabaseMetrics");
        final SummarizeAwrDatabaseMetricsRequest interceptedRequest =
                SummarizeAwrDatabaseMetricsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeAwrDatabaseMetricsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeAwrDatabaseMetrics",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/SummarizeAwrDatabaseMetrics");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeAwrDatabaseMetricsResponse>
                transformer =
                        SummarizeAwrDatabaseMetricsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeAwrDatabaseMetricsRequest, SummarizeAwrDatabaseMetricsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeAwrDatabaseMetricsRequest,
                                SummarizeAwrDatabaseMetricsResponse>,
                        java.util.concurrent.Future<SummarizeAwrDatabaseMetricsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeAwrDatabaseMetricsRequest, SummarizeAwrDatabaseMetricsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeAwrDatabaseParameterChangesResponse>
            summarizeAwrDatabaseParameterChanges(
                    SummarizeAwrDatabaseParameterChangesRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeAwrDatabaseParameterChangesRequest,
                                    SummarizeAwrDatabaseParameterChangesResponse>
                            handler) {
        LOG.trace("Called async summarizeAwrDatabaseParameterChanges");
        final SummarizeAwrDatabaseParameterChangesRequest interceptedRequest =
                SummarizeAwrDatabaseParameterChangesConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeAwrDatabaseParameterChangesConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeAwrDatabaseParameterChanges",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/SummarizeAwrDatabaseParameterChanges");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeAwrDatabaseParameterChangesResponse>
                transformer =
                        SummarizeAwrDatabaseParameterChangesConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeAwrDatabaseParameterChangesRequest,
                        SummarizeAwrDatabaseParameterChangesResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeAwrDatabaseParameterChangesRequest,
                                SummarizeAwrDatabaseParameterChangesResponse>,
                        java.util.concurrent.Future<SummarizeAwrDatabaseParameterChangesResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeAwrDatabaseParameterChangesRequest,
                    SummarizeAwrDatabaseParameterChangesResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeAwrDatabaseParametersResponse>
            summarizeAwrDatabaseParameters(
                    SummarizeAwrDatabaseParametersRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeAwrDatabaseParametersRequest,
                                    SummarizeAwrDatabaseParametersResponse>
                            handler) {
        LOG.trace("Called async summarizeAwrDatabaseParameters");
        final SummarizeAwrDatabaseParametersRequest interceptedRequest =
                SummarizeAwrDatabaseParametersConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeAwrDatabaseParametersConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeAwrDatabaseParameters",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/SummarizeAwrDatabaseParameters");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeAwrDatabaseParametersResponse>
                transformer =
                        SummarizeAwrDatabaseParametersConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeAwrDatabaseParametersRequest,
                        SummarizeAwrDatabaseParametersResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeAwrDatabaseParametersRequest,
                                SummarizeAwrDatabaseParametersResponse>,
                        java.util.concurrent.Future<SummarizeAwrDatabaseParametersResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeAwrDatabaseParametersRequest, SummarizeAwrDatabaseParametersResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeAwrDatabaseSnapshotRangesResponse>
            summarizeAwrDatabaseSnapshotRanges(
                    SummarizeAwrDatabaseSnapshotRangesRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeAwrDatabaseSnapshotRangesRequest,
                                    SummarizeAwrDatabaseSnapshotRangesResponse>
                            handler) {
        LOG.trace("Called async summarizeAwrDatabaseSnapshotRanges");
        final SummarizeAwrDatabaseSnapshotRangesRequest interceptedRequest =
                SummarizeAwrDatabaseSnapshotRangesConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeAwrDatabaseSnapshotRangesConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeAwrDatabaseSnapshotRanges",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/SummarizeAwrDatabaseSnapshotRanges");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeAwrDatabaseSnapshotRangesResponse>
                transformer =
                        SummarizeAwrDatabaseSnapshotRangesConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeAwrDatabaseSnapshotRangesRequest,
                        SummarizeAwrDatabaseSnapshotRangesResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeAwrDatabaseSnapshotRangesRequest,
                                SummarizeAwrDatabaseSnapshotRangesResponse>,
                        java.util.concurrent.Future<SummarizeAwrDatabaseSnapshotRangesResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeAwrDatabaseSnapshotRangesRequest,
                    SummarizeAwrDatabaseSnapshotRangesResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeAwrDatabaseSysstatsResponse>
            summarizeAwrDatabaseSysstats(
                    SummarizeAwrDatabaseSysstatsRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeAwrDatabaseSysstatsRequest,
                                    SummarizeAwrDatabaseSysstatsResponse>
                            handler) {
        LOG.trace("Called async summarizeAwrDatabaseSysstats");
        final SummarizeAwrDatabaseSysstatsRequest interceptedRequest =
                SummarizeAwrDatabaseSysstatsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeAwrDatabaseSysstatsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeAwrDatabaseSysstats",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/SummarizeAwrDatabaseSysstats");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeAwrDatabaseSysstatsResponse>
                transformer =
                        SummarizeAwrDatabaseSysstatsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeAwrDatabaseSysstatsRequest, SummarizeAwrDatabaseSysstatsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeAwrDatabaseSysstatsRequest,
                                SummarizeAwrDatabaseSysstatsResponse>,
                        java.util.concurrent.Future<SummarizeAwrDatabaseSysstatsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeAwrDatabaseSysstatsRequest, SummarizeAwrDatabaseSysstatsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeAwrDatabaseTopWaitEventsResponse>
            summarizeAwrDatabaseTopWaitEvents(
                    SummarizeAwrDatabaseTopWaitEventsRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeAwrDatabaseTopWaitEventsRequest,
                                    SummarizeAwrDatabaseTopWaitEventsResponse>
                            handler) {
        LOG.trace("Called async summarizeAwrDatabaseTopWaitEvents");
        final SummarizeAwrDatabaseTopWaitEventsRequest interceptedRequest =
                SummarizeAwrDatabaseTopWaitEventsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeAwrDatabaseTopWaitEventsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeAwrDatabaseTopWaitEvents",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/SummarizeAwrDatabaseTopWaitEvents");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeAwrDatabaseTopWaitEventsResponse>
                transformer =
                        SummarizeAwrDatabaseTopWaitEventsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeAwrDatabaseTopWaitEventsRequest,
                        SummarizeAwrDatabaseTopWaitEventsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeAwrDatabaseTopWaitEventsRequest,
                                SummarizeAwrDatabaseTopWaitEventsResponse>,
                        java.util.concurrent.Future<SummarizeAwrDatabaseTopWaitEventsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeAwrDatabaseTopWaitEventsRequest,
                    SummarizeAwrDatabaseTopWaitEventsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeAwrDatabaseWaitEventBucketsResponse>
            summarizeAwrDatabaseWaitEventBuckets(
                    SummarizeAwrDatabaseWaitEventBucketsRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeAwrDatabaseWaitEventBucketsRequest,
                                    SummarizeAwrDatabaseWaitEventBucketsResponse>
                            handler) {
        LOG.trace("Called async summarizeAwrDatabaseWaitEventBuckets");
        final SummarizeAwrDatabaseWaitEventBucketsRequest interceptedRequest =
                SummarizeAwrDatabaseWaitEventBucketsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeAwrDatabaseWaitEventBucketsConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeAwrDatabaseWaitEventBuckets",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/SummarizeAwrDatabaseWaitEventBuckets");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeAwrDatabaseWaitEventBucketsResponse>
                transformer =
                        SummarizeAwrDatabaseWaitEventBucketsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeAwrDatabaseWaitEventBucketsRequest,
                        SummarizeAwrDatabaseWaitEventBucketsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeAwrDatabaseWaitEventBucketsRequest,
                                SummarizeAwrDatabaseWaitEventBucketsResponse>,
                        java.util.concurrent.Future<SummarizeAwrDatabaseWaitEventBucketsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeAwrDatabaseWaitEventBucketsRequest,
                    SummarizeAwrDatabaseWaitEventBucketsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeAwrDatabaseWaitEventsResponse>
            summarizeAwrDatabaseWaitEvents(
                    SummarizeAwrDatabaseWaitEventsRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeAwrDatabaseWaitEventsRequest,
                                    SummarizeAwrDatabaseWaitEventsResponse>
                            handler) {
        LOG.trace("Called async summarizeAwrDatabaseWaitEvents");
        final SummarizeAwrDatabaseWaitEventsRequest interceptedRequest =
                SummarizeAwrDatabaseWaitEventsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeAwrDatabaseWaitEventsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeAwrDatabaseWaitEvents",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/SummarizeAwrDatabaseWaitEvents");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeAwrDatabaseWaitEventsResponse>
                transformer =
                        SummarizeAwrDatabaseWaitEventsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeAwrDatabaseWaitEventsRequest,
                        SummarizeAwrDatabaseWaitEventsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeAwrDatabaseWaitEventsRequest,
                                SummarizeAwrDatabaseWaitEventsResponse>,
                        java.util.concurrent.Future<SummarizeAwrDatabaseWaitEventsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeAwrDatabaseWaitEventsRequest, SummarizeAwrDatabaseWaitEventsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeAwrSourcesSummariesResponse>
            summarizeAwrSourcesSummaries(
                    SummarizeAwrSourcesSummariesRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeAwrSourcesSummariesRequest,
                                    SummarizeAwrSourcesSummariesResponse>
                            handler) {
        LOG.trace("Called async summarizeAwrSourcesSummaries");
        final SummarizeAwrSourcesSummariesRequest interceptedRequest =
                SummarizeAwrSourcesSummariesConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeAwrSourcesSummariesConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeAwrSourcesSummaries",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/SummarizeAwrSourcesSummaries");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeAwrSourcesSummariesResponse>
                transformer =
                        SummarizeAwrSourcesSummariesConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeAwrSourcesSummariesRequest, SummarizeAwrSourcesSummariesResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeAwrSourcesSummariesRequest,
                                SummarizeAwrSourcesSummariesResponse>,
                        java.util.concurrent.Future<SummarizeAwrSourcesSummariesResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeAwrSourcesSummariesRequest, SummarizeAwrSourcesSummariesResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeConfigurationItemsResponse>
            summarizeConfigurationItems(
                    SummarizeConfigurationItemsRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeConfigurationItemsRequest,
                                    SummarizeConfigurationItemsResponse>
                            handler) {
        LOG.trace("Called async summarizeConfigurationItems");
        final SummarizeConfigurationItemsRequest interceptedRequest =
                SummarizeConfigurationItemsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeConfigurationItemsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeConfigurationItems",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OpsiConfigurations/SummarizeConfigurationItems");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeConfigurationItemsResponse>
                transformer =
                        SummarizeConfigurationItemsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeConfigurationItemsRequest, SummarizeConfigurationItemsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeConfigurationItemsRequest,
                                SummarizeConfigurationItemsResponse>,
                        java.util.concurrent.Future<SummarizeConfigurationItemsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeConfigurationItemsRequest, SummarizeConfigurationItemsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeDatabaseInsightResourceCapacityTrendResponse>
            summarizeDatabaseInsightResourceCapacityTrend(
                    SummarizeDatabaseInsightResourceCapacityTrendRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeDatabaseInsightResourceCapacityTrendRequest,
                                    SummarizeDatabaseInsightResourceCapacityTrendResponse>
                            handler) {
        LOG.trace("Called async summarizeDatabaseInsightResourceCapacityTrend");
        final SummarizeDatabaseInsightResourceCapacityTrendRequest interceptedRequest =
                SummarizeDatabaseInsightResourceCapacityTrendConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeDatabaseInsightResourceCapacityTrendConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeDatabaseInsightResourceCapacityTrend",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/SummarizeDatabaseInsightResourceCapacityTrend");
        final java.util.function.Function<
                        javax.ws.rs.core.Response,
                        SummarizeDatabaseInsightResourceCapacityTrendResponse>
                transformer =
                        SummarizeDatabaseInsightResourceCapacityTrendConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeDatabaseInsightResourceCapacityTrendRequest,
                        SummarizeDatabaseInsightResourceCapacityTrendResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeDatabaseInsightResourceCapacityTrendRequest,
                                SummarizeDatabaseInsightResourceCapacityTrendResponse>,
                        java.util.concurrent.Future<
                                SummarizeDatabaseInsightResourceCapacityTrendResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeDatabaseInsightResourceCapacityTrendRequest,
                    SummarizeDatabaseInsightResourceCapacityTrendResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeDatabaseInsightResourceForecastTrendResponse>
            summarizeDatabaseInsightResourceForecastTrend(
                    SummarizeDatabaseInsightResourceForecastTrendRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeDatabaseInsightResourceForecastTrendRequest,
                                    SummarizeDatabaseInsightResourceForecastTrendResponse>
                            handler) {
        LOG.trace("Called async summarizeDatabaseInsightResourceForecastTrend");
        final SummarizeDatabaseInsightResourceForecastTrendRequest interceptedRequest =
                SummarizeDatabaseInsightResourceForecastTrendConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeDatabaseInsightResourceForecastTrendConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeDatabaseInsightResourceForecastTrend",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/SummarizeDatabaseInsightResourceForecastTrend");
        final java.util.function.Function<
                        javax.ws.rs.core.Response,
                        SummarizeDatabaseInsightResourceForecastTrendResponse>
                transformer =
                        SummarizeDatabaseInsightResourceForecastTrendConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeDatabaseInsightResourceForecastTrendRequest,
                        SummarizeDatabaseInsightResourceForecastTrendResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeDatabaseInsightResourceForecastTrendRequest,
                                SummarizeDatabaseInsightResourceForecastTrendResponse>,
                        java.util.concurrent.Future<
                                SummarizeDatabaseInsightResourceForecastTrendResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeDatabaseInsightResourceForecastTrendRequest,
                    SummarizeDatabaseInsightResourceForecastTrendResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeDatabaseInsightResourceStatisticsResponse>
            summarizeDatabaseInsightResourceStatistics(
                    SummarizeDatabaseInsightResourceStatisticsRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeDatabaseInsightResourceStatisticsRequest,
                                    SummarizeDatabaseInsightResourceStatisticsResponse>
                            handler) {
        LOG.trace("Called async summarizeDatabaseInsightResourceStatistics");
        final SummarizeDatabaseInsightResourceStatisticsRequest interceptedRequest =
                SummarizeDatabaseInsightResourceStatisticsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeDatabaseInsightResourceStatisticsConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeDatabaseInsightResourceStatistics",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/SummarizeDatabaseInsightResourceStatistics");
        final java.util.function.Function<
                        javax.ws.rs.core.Response,
                        SummarizeDatabaseInsightResourceStatisticsResponse>
                transformer =
                        SummarizeDatabaseInsightResourceStatisticsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeDatabaseInsightResourceStatisticsRequest,
                        SummarizeDatabaseInsightResourceStatisticsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeDatabaseInsightResourceStatisticsRequest,
                                SummarizeDatabaseInsightResourceStatisticsResponse>,
                        java.util.concurrent.Future<
                                SummarizeDatabaseInsightResourceStatisticsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeDatabaseInsightResourceStatisticsRequest,
                    SummarizeDatabaseInsightResourceStatisticsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeDatabaseInsightResourceUsageResponse>
            summarizeDatabaseInsightResourceUsage(
                    SummarizeDatabaseInsightResourceUsageRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeDatabaseInsightResourceUsageRequest,
                                    SummarizeDatabaseInsightResourceUsageResponse>
                            handler) {
        LOG.trace("Called async summarizeDatabaseInsightResourceUsage");
        final SummarizeDatabaseInsightResourceUsageRequest interceptedRequest =
                SummarizeDatabaseInsightResourceUsageConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeDatabaseInsightResourceUsageConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeDatabaseInsightResourceUsage",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/SummarizeDatabaseInsightResourceUsage");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeDatabaseInsightResourceUsageResponse>
                transformer =
                        SummarizeDatabaseInsightResourceUsageConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeDatabaseInsightResourceUsageRequest,
                        SummarizeDatabaseInsightResourceUsageResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeDatabaseInsightResourceUsageRequest,
                                SummarizeDatabaseInsightResourceUsageResponse>,
                        java.util.concurrent.Future<SummarizeDatabaseInsightResourceUsageResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeDatabaseInsightResourceUsageRequest,
                    SummarizeDatabaseInsightResourceUsageResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeDatabaseInsightResourceUsageTrendResponse>
            summarizeDatabaseInsightResourceUsageTrend(
                    SummarizeDatabaseInsightResourceUsageTrendRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeDatabaseInsightResourceUsageTrendRequest,
                                    SummarizeDatabaseInsightResourceUsageTrendResponse>
                            handler) {
        LOG.trace("Called async summarizeDatabaseInsightResourceUsageTrend");
        final SummarizeDatabaseInsightResourceUsageTrendRequest interceptedRequest =
                SummarizeDatabaseInsightResourceUsageTrendConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeDatabaseInsightResourceUsageTrendConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeDatabaseInsightResourceUsageTrend",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/SummarizeDatabaseInsightResourceUsageTrend");
        final java.util.function.Function<
                        javax.ws.rs.core.Response,
                        SummarizeDatabaseInsightResourceUsageTrendResponse>
                transformer =
                        SummarizeDatabaseInsightResourceUsageTrendConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeDatabaseInsightResourceUsageTrendRequest,
                        SummarizeDatabaseInsightResourceUsageTrendResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeDatabaseInsightResourceUsageTrendRequest,
                                SummarizeDatabaseInsightResourceUsageTrendResponse>,
                        java.util.concurrent.Future<
                                SummarizeDatabaseInsightResourceUsageTrendResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeDatabaseInsightResourceUsageTrendRequest,
                    SummarizeDatabaseInsightResourceUsageTrendResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeDatabaseInsightResourceUtilizationInsightResponse>
            summarizeDatabaseInsightResourceUtilizationInsight(
                    SummarizeDatabaseInsightResourceUtilizationInsightRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeDatabaseInsightResourceUtilizationInsightRequest,
                                    SummarizeDatabaseInsightResourceUtilizationInsightResponse>
                            handler) {
        LOG.trace("Called async summarizeDatabaseInsightResourceUtilizationInsight");
        final SummarizeDatabaseInsightResourceUtilizationInsightRequest interceptedRequest =
                SummarizeDatabaseInsightResourceUtilizationInsightConverter.interceptRequest(
                        request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeDatabaseInsightResourceUtilizationInsightConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeDatabaseInsightResourceUtilizationInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/SummarizeDatabaseInsightResourceUtilizationInsight");
        final java.util.function.Function<
                        javax.ws.rs.core.Response,
                        SummarizeDatabaseInsightResourceUtilizationInsightResponse>
                transformer =
                        SummarizeDatabaseInsightResourceUtilizationInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeDatabaseInsightResourceUtilizationInsightRequest,
                        SummarizeDatabaseInsightResourceUtilizationInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeDatabaseInsightResourceUtilizationInsightRequest,
                                SummarizeDatabaseInsightResourceUtilizationInsightResponse>,
                        java.util.concurrent.Future<
                                SummarizeDatabaseInsightResourceUtilizationInsightResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeDatabaseInsightResourceUtilizationInsightRequest,
                    SummarizeDatabaseInsightResourceUtilizationInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeDatabaseInsightTablespaceUsageTrendResponse>
            summarizeDatabaseInsightTablespaceUsageTrend(
                    SummarizeDatabaseInsightTablespaceUsageTrendRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeDatabaseInsightTablespaceUsageTrendRequest,
                                    SummarizeDatabaseInsightTablespaceUsageTrendResponse>
                            handler) {
        LOG.trace("Called async summarizeDatabaseInsightTablespaceUsageTrend");
        final SummarizeDatabaseInsightTablespaceUsageTrendRequest interceptedRequest =
                SummarizeDatabaseInsightTablespaceUsageTrendConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeDatabaseInsightTablespaceUsageTrendConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeDatabaseInsightTablespaceUsageTrend",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/SummarizeDatabaseInsightTablespaceUsageTrend");
        final java.util.function.Function<
                        javax.ws.rs.core.Response,
                        SummarizeDatabaseInsightTablespaceUsageTrendResponse>
                transformer =
                        SummarizeDatabaseInsightTablespaceUsageTrendConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeDatabaseInsightTablespaceUsageTrendRequest,
                        SummarizeDatabaseInsightTablespaceUsageTrendResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeDatabaseInsightTablespaceUsageTrendRequest,
                                SummarizeDatabaseInsightTablespaceUsageTrendResponse>,
                        java.util.concurrent.Future<
                                SummarizeDatabaseInsightTablespaceUsageTrendResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeDatabaseInsightTablespaceUsageTrendRequest,
                    SummarizeDatabaseInsightTablespaceUsageTrendResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeExadataInsightResourceCapacityTrendResponse>
            summarizeExadataInsightResourceCapacityTrend(
                    SummarizeExadataInsightResourceCapacityTrendRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeExadataInsightResourceCapacityTrendRequest,
                                    SummarizeExadataInsightResourceCapacityTrendResponse>
                            handler) {
        LOG.trace("Called async summarizeExadataInsightResourceCapacityTrend");
        final SummarizeExadataInsightResourceCapacityTrendRequest interceptedRequest =
                SummarizeExadataInsightResourceCapacityTrendConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeExadataInsightResourceCapacityTrendConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeExadataInsightResourceCapacityTrend",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/ExadataInsights/SummarizeExadataInsightResourceCapacityTrend");
        final java.util.function.Function<
                        javax.ws.rs.core.Response,
                        SummarizeExadataInsightResourceCapacityTrendResponse>
                transformer =
                        SummarizeExadataInsightResourceCapacityTrendConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeExadataInsightResourceCapacityTrendRequest,
                        SummarizeExadataInsightResourceCapacityTrendResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeExadataInsightResourceCapacityTrendRequest,
                                SummarizeExadataInsightResourceCapacityTrendResponse>,
                        java.util.concurrent.Future<
                                SummarizeExadataInsightResourceCapacityTrendResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeExadataInsightResourceCapacityTrendRequest,
                    SummarizeExadataInsightResourceCapacityTrendResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<
                    SummarizeExadataInsightResourceCapacityTrendAggregatedResponse>
            summarizeExadataInsightResourceCapacityTrendAggregated(
                    SummarizeExadataInsightResourceCapacityTrendAggregatedRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeExadataInsightResourceCapacityTrendAggregatedRequest,
                                    SummarizeExadataInsightResourceCapacityTrendAggregatedResponse>
                            handler) {
        LOG.trace("Called async summarizeExadataInsightResourceCapacityTrendAggregated");
        final SummarizeExadataInsightResourceCapacityTrendAggregatedRequest interceptedRequest =
                SummarizeExadataInsightResourceCapacityTrendAggregatedConverter.interceptRequest(
                        request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeExadataInsightResourceCapacityTrendAggregatedConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeExadataInsightResourceCapacityTrendAggregated",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/ExadataInsights/SummarizeExadataInsightResourceCapacityTrendAggregated");
        final java.util.function.Function<
                        javax.ws.rs.core.Response,
                        SummarizeExadataInsightResourceCapacityTrendAggregatedResponse>
                transformer =
                        SummarizeExadataInsightResourceCapacityTrendAggregatedConverter
                                .fromResponse(java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeExadataInsightResourceCapacityTrendAggregatedRequest,
                        SummarizeExadataInsightResourceCapacityTrendAggregatedResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeExadataInsightResourceCapacityTrendAggregatedRequest,
                                SummarizeExadataInsightResourceCapacityTrendAggregatedResponse>,
                        java.util.concurrent.Future<
                                SummarizeExadataInsightResourceCapacityTrendAggregatedResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeExadataInsightResourceCapacityTrendAggregatedRequest,
                    SummarizeExadataInsightResourceCapacityTrendAggregatedResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeExadataInsightResourceForecastTrendResponse>
            summarizeExadataInsightResourceForecastTrend(
                    SummarizeExadataInsightResourceForecastTrendRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeExadataInsightResourceForecastTrendRequest,
                                    SummarizeExadataInsightResourceForecastTrendResponse>
                            handler) {
        LOG.trace("Called async summarizeExadataInsightResourceForecastTrend");
        final SummarizeExadataInsightResourceForecastTrendRequest interceptedRequest =
                SummarizeExadataInsightResourceForecastTrendConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeExadataInsightResourceForecastTrendConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeExadataInsightResourceForecastTrend",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/ExadataInsights/SummarizeExadataInsightResourceForecastTrend");
        final java.util.function.Function<
                        javax.ws.rs.core.Response,
                        SummarizeExadataInsightResourceForecastTrendResponse>
                transformer =
                        SummarizeExadataInsightResourceForecastTrendConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeExadataInsightResourceForecastTrendRequest,
                        SummarizeExadataInsightResourceForecastTrendResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeExadataInsightResourceForecastTrendRequest,
                                SummarizeExadataInsightResourceForecastTrendResponse>,
                        java.util.concurrent.Future<
                                SummarizeExadataInsightResourceForecastTrendResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeExadataInsightResourceForecastTrendRequest,
                    SummarizeExadataInsightResourceForecastTrendResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<
                    SummarizeExadataInsightResourceForecastTrendAggregatedResponse>
            summarizeExadataInsightResourceForecastTrendAggregated(
                    SummarizeExadataInsightResourceForecastTrendAggregatedRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeExadataInsightResourceForecastTrendAggregatedRequest,
                                    SummarizeExadataInsightResourceForecastTrendAggregatedResponse>
                            handler) {
        LOG.trace("Called async summarizeExadataInsightResourceForecastTrendAggregated");
        final SummarizeExadataInsightResourceForecastTrendAggregatedRequest interceptedRequest =
                SummarizeExadataInsightResourceForecastTrendAggregatedConverter.interceptRequest(
                        request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeExadataInsightResourceForecastTrendAggregatedConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeExadataInsightResourceForecastTrendAggregated",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/ExadataInsights/SummarizeExadataInsightResourceForecastTrendAggregated");
        final java.util.function.Function<
                        javax.ws.rs.core.Response,
                        SummarizeExadataInsightResourceForecastTrendAggregatedResponse>
                transformer =
                        SummarizeExadataInsightResourceForecastTrendAggregatedConverter
                                .fromResponse(java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeExadataInsightResourceForecastTrendAggregatedRequest,
                        SummarizeExadataInsightResourceForecastTrendAggregatedResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeExadataInsightResourceForecastTrendAggregatedRequest,
                                SummarizeExadataInsightResourceForecastTrendAggregatedResponse>,
                        java.util.concurrent.Future<
                                SummarizeExadataInsightResourceForecastTrendAggregatedResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeExadataInsightResourceForecastTrendAggregatedRequest,
                    SummarizeExadataInsightResourceForecastTrendAggregatedResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeExadataInsightResourceStatisticsResponse>
            summarizeExadataInsightResourceStatistics(
                    SummarizeExadataInsightResourceStatisticsRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeExadataInsightResourceStatisticsRequest,
                                    SummarizeExadataInsightResourceStatisticsResponse>
                            handler) {
        LOG.trace("Called async summarizeExadataInsightResourceStatistics");
        final SummarizeExadataInsightResourceStatisticsRequest interceptedRequest =
                SummarizeExadataInsightResourceStatisticsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeExadataInsightResourceStatisticsConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeExadataInsightResourceStatistics",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/ExadataInsights/SummarizeExadataInsightResourceStatistics");
        final java.util.function.Function<
                        javax.ws.rs.core.Response,
                        SummarizeExadataInsightResourceStatisticsResponse>
                transformer =
                        SummarizeExadataInsightResourceStatisticsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeExadataInsightResourceStatisticsRequest,
                        SummarizeExadataInsightResourceStatisticsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeExadataInsightResourceStatisticsRequest,
                                SummarizeExadataInsightResourceStatisticsResponse>,
                        java.util.concurrent.Future<
                                SummarizeExadataInsightResourceStatisticsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeExadataInsightResourceStatisticsRequest,
                    SummarizeExadataInsightResourceStatisticsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeExadataInsightResourceUsageResponse>
            summarizeExadataInsightResourceUsage(
                    SummarizeExadataInsightResourceUsageRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeExadataInsightResourceUsageRequest,
                                    SummarizeExadataInsightResourceUsageResponse>
                            handler) {
        LOG.trace("Called async summarizeExadataInsightResourceUsage");
        final SummarizeExadataInsightResourceUsageRequest interceptedRequest =
                SummarizeExadataInsightResourceUsageConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeExadataInsightResourceUsageConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeExadataInsightResourceUsage",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/ExadataInsights/SummarizeExadataInsightResourceUsage");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeExadataInsightResourceUsageResponse>
                transformer =
                        SummarizeExadataInsightResourceUsageConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeExadataInsightResourceUsageRequest,
                        SummarizeExadataInsightResourceUsageResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeExadataInsightResourceUsageRequest,
                                SummarizeExadataInsightResourceUsageResponse>,
                        java.util.concurrent.Future<SummarizeExadataInsightResourceUsageResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeExadataInsightResourceUsageRequest,
                    SummarizeExadataInsightResourceUsageResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeExadataInsightResourceUsageAggregatedResponse>
            summarizeExadataInsightResourceUsageAggregated(
                    SummarizeExadataInsightResourceUsageAggregatedRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeExadataInsightResourceUsageAggregatedRequest,
                                    SummarizeExadataInsightResourceUsageAggregatedResponse>
                            handler) {
        LOG.trace("Called async summarizeExadataInsightResourceUsageAggregated");
        final SummarizeExadataInsightResourceUsageAggregatedRequest interceptedRequest =
                SummarizeExadataInsightResourceUsageAggregatedConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeExadataInsightResourceUsageAggregatedConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeExadataInsightResourceUsageAggregated",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/ExadataInsights/SummarizeExadataInsightResourceUsageAggregated");
        final java.util.function.Function<
                        javax.ws.rs.core.Response,
                        SummarizeExadataInsightResourceUsageAggregatedResponse>
                transformer =
                        SummarizeExadataInsightResourceUsageAggregatedConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeExadataInsightResourceUsageAggregatedRequest,
                        SummarizeExadataInsightResourceUsageAggregatedResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeExadataInsightResourceUsageAggregatedRequest,
                                SummarizeExadataInsightResourceUsageAggregatedResponse>,
                        java.util.concurrent.Future<
                                SummarizeExadataInsightResourceUsageAggregatedResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeExadataInsightResourceUsageAggregatedRequest,
                    SummarizeExadataInsightResourceUsageAggregatedResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeExadataInsightResourceUtilizationInsightResponse>
            summarizeExadataInsightResourceUtilizationInsight(
                    SummarizeExadataInsightResourceUtilizationInsightRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeExadataInsightResourceUtilizationInsightRequest,
                                    SummarizeExadataInsightResourceUtilizationInsightResponse>
                            handler) {
        LOG.trace("Called async summarizeExadataInsightResourceUtilizationInsight");
        final SummarizeExadataInsightResourceUtilizationInsightRequest interceptedRequest =
                SummarizeExadataInsightResourceUtilizationInsightConverter.interceptRequest(
                        request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeExadataInsightResourceUtilizationInsightConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeExadataInsightResourceUtilizationInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/ExadataInsights/SummarizeExadataInsightResourceUtilizationInsight");
        final java.util.function.Function<
                        javax.ws.rs.core.Response,
                        SummarizeExadataInsightResourceUtilizationInsightResponse>
                transformer =
                        SummarizeExadataInsightResourceUtilizationInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeExadataInsightResourceUtilizationInsightRequest,
                        SummarizeExadataInsightResourceUtilizationInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeExadataInsightResourceUtilizationInsightRequest,
                                SummarizeExadataInsightResourceUtilizationInsightResponse>,
                        java.util.concurrent.Future<
                                SummarizeExadataInsightResourceUtilizationInsightResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeExadataInsightResourceUtilizationInsightRequest,
                    SummarizeExadataInsightResourceUtilizationInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeExadataMembersResponse> summarizeExadataMembers(
            SummarizeExadataMembersRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            SummarizeExadataMembersRequest, SummarizeExadataMembersResponse>
                    handler) {
        LOG.trace("Called async summarizeExadataMembers");
        final SummarizeExadataMembersRequest interceptedRequest =
                SummarizeExadataMembersConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeExadataMembersConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeExadataMembers",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/ExadataInsights/SummarizeExadataMembers");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeExadataMembersResponse>
                transformer =
                        SummarizeExadataMembersConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeExadataMembersRequest, SummarizeExadataMembersResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeExadataMembersRequest, SummarizeExadataMembersResponse>,
                        java.util.concurrent.Future<SummarizeExadataMembersResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeExadataMembersRequest, SummarizeExadataMembersResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeHostInsightResourceCapacityTrendResponse>
            summarizeHostInsightResourceCapacityTrend(
                    SummarizeHostInsightResourceCapacityTrendRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeHostInsightResourceCapacityTrendRequest,
                                    SummarizeHostInsightResourceCapacityTrendResponse>
                            handler) {
        LOG.trace("Called async summarizeHostInsightResourceCapacityTrend");
        final SummarizeHostInsightResourceCapacityTrendRequest interceptedRequest =
                SummarizeHostInsightResourceCapacityTrendConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeHostInsightResourceCapacityTrendConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeHostInsightResourceCapacityTrend",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/SummarizeHostInsightResourceCapacityTrend");
        final java.util.function.Function<
                        javax.ws.rs.core.Response,
                        SummarizeHostInsightResourceCapacityTrendResponse>
                transformer =
                        SummarizeHostInsightResourceCapacityTrendConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeHostInsightResourceCapacityTrendRequest,
                        SummarizeHostInsightResourceCapacityTrendResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeHostInsightResourceCapacityTrendRequest,
                                SummarizeHostInsightResourceCapacityTrendResponse>,
                        java.util.concurrent.Future<
                                SummarizeHostInsightResourceCapacityTrendResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeHostInsightResourceCapacityTrendRequest,
                    SummarizeHostInsightResourceCapacityTrendResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeHostInsightResourceForecastTrendResponse>
            summarizeHostInsightResourceForecastTrend(
                    SummarizeHostInsightResourceForecastTrendRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeHostInsightResourceForecastTrendRequest,
                                    SummarizeHostInsightResourceForecastTrendResponse>
                            handler) {
        LOG.trace("Called async summarizeHostInsightResourceForecastTrend");
        final SummarizeHostInsightResourceForecastTrendRequest interceptedRequest =
                SummarizeHostInsightResourceForecastTrendConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeHostInsightResourceForecastTrendConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeHostInsightResourceForecastTrend",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/SummarizeHostInsightResourceForecastTrend");
        final java.util.function.Function<
                        javax.ws.rs.core.Response,
                        SummarizeHostInsightResourceForecastTrendResponse>
                transformer =
                        SummarizeHostInsightResourceForecastTrendConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeHostInsightResourceForecastTrendRequest,
                        SummarizeHostInsightResourceForecastTrendResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeHostInsightResourceForecastTrendRequest,
                                SummarizeHostInsightResourceForecastTrendResponse>,
                        java.util.concurrent.Future<
                                SummarizeHostInsightResourceForecastTrendResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeHostInsightResourceForecastTrendRequest,
                    SummarizeHostInsightResourceForecastTrendResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeHostInsightResourceStatisticsResponse>
            summarizeHostInsightResourceStatistics(
                    SummarizeHostInsightResourceStatisticsRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeHostInsightResourceStatisticsRequest,
                                    SummarizeHostInsightResourceStatisticsResponse>
                            handler) {
        LOG.trace("Called async summarizeHostInsightResourceStatistics");
        final SummarizeHostInsightResourceStatisticsRequest interceptedRequest =
                SummarizeHostInsightResourceStatisticsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeHostInsightResourceStatisticsConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeHostInsightResourceStatistics",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/SummarizeHostInsightResourceStatistics");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeHostInsightResourceStatisticsResponse>
                transformer =
                        SummarizeHostInsightResourceStatisticsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeHostInsightResourceStatisticsRequest,
                        SummarizeHostInsightResourceStatisticsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeHostInsightResourceStatisticsRequest,
                                SummarizeHostInsightResourceStatisticsResponse>,
                        java.util.concurrent.Future<SummarizeHostInsightResourceStatisticsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeHostInsightResourceStatisticsRequest,
                    SummarizeHostInsightResourceStatisticsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeHostInsightResourceUsageResponse>
            summarizeHostInsightResourceUsage(
                    SummarizeHostInsightResourceUsageRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeHostInsightResourceUsageRequest,
                                    SummarizeHostInsightResourceUsageResponse>
                            handler) {
        LOG.trace("Called async summarizeHostInsightResourceUsage");
        final SummarizeHostInsightResourceUsageRequest interceptedRequest =
                SummarizeHostInsightResourceUsageConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeHostInsightResourceUsageConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeHostInsightResourceUsage",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/SummarizeHostInsightResourceUsage");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeHostInsightResourceUsageResponse>
                transformer =
                        SummarizeHostInsightResourceUsageConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeHostInsightResourceUsageRequest,
                        SummarizeHostInsightResourceUsageResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeHostInsightResourceUsageRequest,
                                SummarizeHostInsightResourceUsageResponse>,
                        java.util.concurrent.Future<SummarizeHostInsightResourceUsageResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeHostInsightResourceUsageRequest,
                    SummarizeHostInsightResourceUsageResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeHostInsightResourceUsageTrendResponse>
            summarizeHostInsightResourceUsageTrend(
                    SummarizeHostInsightResourceUsageTrendRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeHostInsightResourceUsageTrendRequest,
                                    SummarizeHostInsightResourceUsageTrendResponse>
                            handler) {
        LOG.trace("Called async summarizeHostInsightResourceUsageTrend");
        final SummarizeHostInsightResourceUsageTrendRequest interceptedRequest =
                SummarizeHostInsightResourceUsageTrendConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeHostInsightResourceUsageTrendConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeHostInsightResourceUsageTrend",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/SummarizeHostInsightResourceUsageTrend");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeHostInsightResourceUsageTrendResponse>
                transformer =
                        SummarizeHostInsightResourceUsageTrendConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeHostInsightResourceUsageTrendRequest,
                        SummarizeHostInsightResourceUsageTrendResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeHostInsightResourceUsageTrendRequest,
                                SummarizeHostInsightResourceUsageTrendResponse>,
                        java.util.concurrent.Future<SummarizeHostInsightResourceUsageTrendResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeHostInsightResourceUsageTrendRequest,
                    SummarizeHostInsightResourceUsageTrendResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeHostInsightResourceUtilizationInsightResponse>
            summarizeHostInsightResourceUtilizationInsight(
                    SummarizeHostInsightResourceUtilizationInsightRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeHostInsightResourceUtilizationInsightRequest,
                                    SummarizeHostInsightResourceUtilizationInsightResponse>
                            handler) {
        LOG.trace("Called async summarizeHostInsightResourceUtilizationInsight");
        final SummarizeHostInsightResourceUtilizationInsightRequest interceptedRequest =
                SummarizeHostInsightResourceUtilizationInsightConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeHostInsightResourceUtilizationInsightConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeHostInsightResourceUtilizationInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/SummarizeHostInsightResourceUtilizationInsight");
        final java.util.function.Function<
                        javax.ws.rs.core.Response,
                        SummarizeHostInsightResourceUtilizationInsightResponse>
                transformer =
                        SummarizeHostInsightResourceUtilizationInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeHostInsightResourceUtilizationInsightRequest,
                        SummarizeHostInsightResourceUtilizationInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeHostInsightResourceUtilizationInsightRequest,
                                SummarizeHostInsightResourceUtilizationInsightResponse>,
                        java.util.concurrent.Future<
                                SummarizeHostInsightResourceUtilizationInsightResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeHostInsightResourceUtilizationInsightRequest,
                    SummarizeHostInsightResourceUtilizationInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeHostInsightTopProcessesUsageResponse>
            summarizeHostInsightTopProcessesUsage(
                    SummarizeHostInsightTopProcessesUsageRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeHostInsightTopProcessesUsageRequest,
                                    SummarizeHostInsightTopProcessesUsageResponse>
                            handler) {
        LOG.trace("Called async summarizeHostInsightTopProcessesUsage");
        final SummarizeHostInsightTopProcessesUsageRequest interceptedRequest =
                SummarizeHostInsightTopProcessesUsageConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeHostInsightTopProcessesUsageConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeHostInsightTopProcessesUsage",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/SummarizeHostInsightTopProcessesUsage");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeHostInsightTopProcessesUsageResponse>
                transformer =
                        SummarizeHostInsightTopProcessesUsageConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeHostInsightTopProcessesUsageRequest,
                        SummarizeHostInsightTopProcessesUsageResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeHostInsightTopProcessesUsageRequest,
                                SummarizeHostInsightTopProcessesUsageResponse>,
                        java.util.concurrent.Future<SummarizeHostInsightTopProcessesUsageResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeHostInsightTopProcessesUsageRequest,
                    SummarizeHostInsightTopProcessesUsageResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeHostInsightTopProcessesUsageTrendResponse>
            summarizeHostInsightTopProcessesUsageTrend(
                    SummarizeHostInsightTopProcessesUsageTrendRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeHostInsightTopProcessesUsageTrendRequest,
                                    SummarizeHostInsightTopProcessesUsageTrendResponse>
                            handler) {
        LOG.trace("Called async summarizeHostInsightTopProcessesUsageTrend");
        final SummarizeHostInsightTopProcessesUsageTrendRequest interceptedRequest =
                SummarizeHostInsightTopProcessesUsageTrendConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeHostInsightTopProcessesUsageTrendConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeHostInsightTopProcessesUsageTrend",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/SummarizeHostInsightTopProcessesUsageTrend");
        final java.util.function.Function<
                        javax.ws.rs.core.Response,
                        SummarizeHostInsightTopProcessesUsageTrendResponse>
                transformer =
                        SummarizeHostInsightTopProcessesUsageTrendConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeHostInsightTopProcessesUsageTrendRequest,
                        SummarizeHostInsightTopProcessesUsageTrendResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeHostInsightTopProcessesUsageTrendRequest,
                                SummarizeHostInsightTopProcessesUsageTrendResponse>,
                        java.util.concurrent.Future<
                                SummarizeHostInsightTopProcessesUsageTrendResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeHostInsightTopProcessesUsageTrendRequest,
                    SummarizeHostInsightTopProcessesUsageTrendResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeOperationsInsightsWarehouseResourceUsageResponse>
            summarizeOperationsInsightsWarehouseResourceUsage(
                    SummarizeOperationsInsightsWarehouseResourceUsageRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeOperationsInsightsWarehouseResourceUsageRequest,
                                    SummarizeOperationsInsightsWarehouseResourceUsageResponse>
                            handler) {
        LOG.trace("Called async summarizeOperationsInsightsWarehouseResourceUsage");
        final SummarizeOperationsInsightsWarehouseResourceUsageRequest interceptedRequest =
                SummarizeOperationsInsightsWarehouseResourceUsageConverter.interceptRequest(
                        request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeOperationsInsightsWarehouseResourceUsageConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeOperationsInsightsWarehouseResourceUsage",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OperationsInsightsWarehouses/SummarizeOperationsInsightsWarehouseResourceUsage");
        final java.util.function.Function<
                        javax.ws.rs.core.Response,
                        SummarizeOperationsInsightsWarehouseResourceUsageResponse>
                transformer =
                        SummarizeOperationsInsightsWarehouseResourceUsageConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeOperationsInsightsWarehouseResourceUsageRequest,
                        SummarizeOperationsInsightsWarehouseResourceUsageResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeOperationsInsightsWarehouseResourceUsageRequest,
                                SummarizeOperationsInsightsWarehouseResourceUsageResponse>,
                        java.util.concurrent.Future<
                                SummarizeOperationsInsightsWarehouseResourceUsageResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeOperationsInsightsWarehouseResourceUsageRequest,
                    SummarizeOperationsInsightsWarehouseResourceUsageResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeSqlInsightsResponse> summarizeSqlInsights(
            SummarizeSqlInsightsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            SummarizeSqlInsightsRequest, SummarizeSqlInsightsResponse>
                    handler) {
        LOG.trace("Called async summarizeSqlInsights");
        final SummarizeSqlInsightsRequest interceptedRequest =
                SummarizeSqlInsightsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeSqlInsightsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeSqlInsights",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/SummarizeSqlInsights");
        final java.util.function.Function<javax.ws.rs.core.Response, SummarizeSqlInsightsResponse>
                transformer =
                        SummarizeSqlInsightsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeSqlInsightsRequest, SummarizeSqlInsightsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeSqlInsightsRequest, SummarizeSqlInsightsResponse>,
                        java.util.concurrent.Future<SummarizeSqlInsightsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeSqlInsightsRequest, SummarizeSqlInsightsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeSqlPlanInsightsResponse> summarizeSqlPlanInsights(
            SummarizeSqlPlanInsightsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            SummarizeSqlPlanInsightsRequest, SummarizeSqlPlanInsightsResponse>
                    handler) {
        LOG.trace("Called async summarizeSqlPlanInsights");
        final SummarizeSqlPlanInsightsRequest interceptedRequest =
                SummarizeSqlPlanInsightsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeSqlPlanInsightsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeSqlPlanInsights",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/SummarizeSqlPlanInsights");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeSqlPlanInsightsResponse>
                transformer =
                        SummarizeSqlPlanInsightsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeSqlPlanInsightsRequest, SummarizeSqlPlanInsightsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeSqlPlanInsightsRequest, SummarizeSqlPlanInsightsResponse>,
                        java.util.concurrent.Future<SummarizeSqlPlanInsightsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeSqlPlanInsightsRequest, SummarizeSqlPlanInsightsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeSqlResponseTimeDistributionsResponse>
            summarizeSqlResponseTimeDistributions(
                    SummarizeSqlResponseTimeDistributionsRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeSqlResponseTimeDistributionsRequest,
                                    SummarizeSqlResponseTimeDistributionsResponse>
                            handler) {
        LOG.trace("Called async summarizeSqlResponseTimeDistributions");
        final SummarizeSqlResponseTimeDistributionsRequest interceptedRequest =
                SummarizeSqlResponseTimeDistributionsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeSqlResponseTimeDistributionsConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeSqlResponseTimeDistributions",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/SummarizeSqlResponseTimeDistributions");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeSqlResponseTimeDistributionsResponse>
                transformer =
                        SummarizeSqlResponseTimeDistributionsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeSqlResponseTimeDistributionsRequest,
                        SummarizeSqlResponseTimeDistributionsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeSqlResponseTimeDistributionsRequest,
                                SummarizeSqlResponseTimeDistributionsResponse>,
                        java.util.concurrent.Future<SummarizeSqlResponseTimeDistributionsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeSqlResponseTimeDistributionsRequest,
                    SummarizeSqlResponseTimeDistributionsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeSqlStatisticsResponse> summarizeSqlStatistics(
            SummarizeSqlStatisticsRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            SummarizeSqlStatisticsRequest, SummarizeSqlStatisticsResponse>
                    handler) {
        LOG.trace("Called async summarizeSqlStatistics");
        final SummarizeSqlStatisticsRequest interceptedRequest =
                SummarizeSqlStatisticsConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeSqlStatisticsConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeSqlStatistics",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/SummarizeSqlStatistics");
        final java.util.function.Function<javax.ws.rs.core.Response, SummarizeSqlStatisticsResponse>
                transformer =
                        SummarizeSqlStatisticsConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeSqlStatisticsRequest, SummarizeSqlStatisticsResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeSqlStatisticsRequest, SummarizeSqlStatisticsResponse>,
                        java.util.concurrent.Future<SummarizeSqlStatisticsResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeSqlStatisticsRequest, SummarizeSqlStatisticsResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeSqlStatisticsTimeSeriesResponse>
            summarizeSqlStatisticsTimeSeries(
                    SummarizeSqlStatisticsTimeSeriesRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeSqlStatisticsTimeSeriesRequest,
                                    SummarizeSqlStatisticsTimeSeriesResponse>
                            handler) {
        LOG.trace("Called async summarizeSqlStatisticsTimeSeries");
        final SummarizeSqlStatisticsTimeSeriesRequest interceptedRequest =
                SummarizeSqlStatisticsTimeSeriesConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeSqlStatisticsTimeSeriesConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeSqlStatisticsTimeSeries",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/SummarizeSqlStatisticsTimeSeries");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeSqlStatisticsTimeSeriesResponse>
                transformer =
                        SummarizeSqlStatisticsTimeSeriesConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeSqlStatisticsTimeSeriesRequest,
                        SummarizeSqlStatisticsTimeSeriesResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeSqlStatisticsTimeSeriesRequest,
                                SummarizeSqlStatisticsTimeSeriesResponse>,
                        java.util.concurrent.Future<SummarizeSqlStatisticsTimeSeriesResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeSqlStatisticsTimeSeriesRequest,
                    SummarizeSqlStatisticsTimeSeriesResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<SummarizeSqlStatisticsTimeSeriesByPlanResponse>
            summarizeSqlStatisticsTimeSeriesByPlan(
                    SummarizeSqlStatisticsTimeSeriesByPlanRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    SummarizeSqlStatisticsTimeSeriesByPlanRequest,
                                    SummarizeSqlStatisticsTimeSeriesByPlanResponse>
                            handler) {
        LOG.trace("Called async summarizeSqlStatisticsTimeSeriesByPlan");
        final SummarizeSqlStatisticsTimeSeriesByPlanRequest interceptedRequest =
                SummarizeSqlStatisticsTimeSeriesByPlanConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                SummarizeSqlStatisticsTimeSeriesByPlanConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "SummarizeSqlStatisticsTimeSeriesByPlan",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/SummarizeSqlStatisticsTimeSeriesByPlan");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, SummarizeSqlStatisticsTimeSeriesByPlanResponse>
                transformer =
                        SummarizeSqlStatisticsTimeSeriesByPlanConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        SummarizeSqlStatisticsTimeSeriesByPlanRequest,
                        SummarizeSqlStatisticsTimeSeriesByPlanResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                SummarizeSqlStatisticsTimeSeriesByPlanRequest,
                                SummarizeSqlStatisticsTimeSeriesByPlanResponse>,
                        java.util.concurrent.Future<SummarizeSqlStatisticsTimeSeriesByPlanResponse>>
                futureSupplier = client.getFutureSupplier(interceptedRequest, ib, transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    SummarizeSqlStatisticsTimeSeriesByPlanRequest,
                    SummarizeSqlStatisticsTimeSeriesByPlanResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<UpdateAwrHubResponse> updateAwrHub(
            UpdateAwrHubRequest request,
            final com.oracle.bmc.responses.AsyncHandler<UpdateAwrHubRequest, UpdateAwrHubResponse>
                    handler) {
        LOG.trace("Called async updateAwrHub");
        final UpdateAwrHubRequest interceptedRequest =
                UpdateAwrHubConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                UpdateAwrHubConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "UpdateAwrHub",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/AwrHubs/UpdateAwrHub");
        final java.util.function.Function<javax.ws.rs.core.Response, UpdateAwrHubResponse>
                transformer =
                        UpdateAwrHubConverter.fromResponse(java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<UpdateAwrHubRequest, UpdateAwrHubResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                UpdateAwrHubRequest, UpdateAwrHubResponse>,
                        java.util.concurrent.Future<UpdateAwrHubResponse>>
                futureSupplier =
                        client.putFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getUpdateAwrHubDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    UpdateAwrHubRequest, UpdateAwrHubResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<UpdateDatabaseInsightResponse> updateDatabaseInsight(
            UpdateDatabaseInsightRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            UpdateDatabaseInsightRequest, UpdateDatabaseInsightResponse>
                    handler) {
        LOG.trace("Called async updateDatabaseInsight");
        final UpdateDatabaseInsightRequest interceptedRequest =
                UpdateDatabaseInsightConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                UpdateDatabaseInsightConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "UpdateDatabaseInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/DatabaseInsights/UpdateDatabaseInsight");
        final java.util.function.Function<javax.ws.rs.core.Response, UpdateDatabaseInsightResponse>
                transformer =
                        UpdateDatabaseInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        UpdateDatabaseInsightRequest, UpdateDatabaseInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                UpdateDatabaseInsightRequest, UpdateDatabaseInsightResponse>,
                        java.util.concurrent.Future<UpdateDatabaseInsightResponse>>
                futureSupplier =
                        client.putFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getUpdateDatabaseInsightDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    UpdateDatabaseInsightRequest, UpdateDatabaseInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<UpdateEnterpriseManagerBridgeResponse>
            updateEnterpriseManagerBridge(
                    UpdateEnterpriseManagerBridgeRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    UpdateEnterpriseManagerBridgeRequest,
                                    UpdateEnterpriseManagerBridgeResponse>
                            handler) {
        LOG.trace("Called async updateEnterpriseManagerBridge");
        final UpdateEnterpriseManagerBridgeRequest interceptedRequest =
                UpdateEnterpriseManagerBridgeConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                UpdateEnterpriseManagerBridgeConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "UpdateEnterpriseManagerBridge",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/EnterpriseManagerBridges/UpdateEnterpriseManagerBridge");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, UpdateEnterpriseManagerBridgeResponse>
                transformer =
                        UpdateEnterpriseManagerBridgeConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        UpdateEnterpriseManagerBridgeRequest, UpdateEnterpriseManagerBridgeResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                UpdateEnterpriseManagerBridgeRequest,
                                UpdateEnterpriseManagerBridgeResponse>,
                        java.util.concurrent.Future<UpdateEnterpriseManagerBridgeResponse>>
                futureSupplier =
                        client.putFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getUpdateEnterpriseManagerBridgeDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    UpdateEnterpriseManagerBridgeRequest, UpdateEnterpriseManagerBridgeResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<UpdateExadataInsightResponse> updateExadataInsight(
            UpdateExadataInsightRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            UpdateExadataInsightRequest, UpdateExadataInsightResponse>
                    handler) {
        LOG.trace("Called async updateExadataInsight");
        final UpdateExadataInsightRequest interceptedRequest =
                UpdateExadataInsightConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                UpdateExadataInsightConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "UpdateExadataInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/ExadataInsights/UpdateExadataInsight");
        final java.util.function.Function<javax.ws.rs.core.Response, UpdateExadataInsightResponse>
                transformer =
                        UpdateExadataInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        UpdateExadataInsightRequest, UpdateExadataInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                UpdateExadataInsightRequest, UpdateExadataInsightResponse>,
                        java.util.concurrent.Future<UpdateExadataInsightResponse>>
                futureSupplier =
                        client.putFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getUpdateExadataInsightDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    UpdateExadataInsightRequest, UpdateExadataInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<UpdateHostInsightResponse> updateHostInsight(
            UpdateHostInsightRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            UpdateHostInsightRequest, UpdateHostInsightResponse>
                    handler) {
        LOG.trace("Called async updateHostInsight");
        final UpdateHostInsightRequest interceptedRequest =
                UpdateHostInsightConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                UpdateHostInsightConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "UpdateHostInsight",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/HostInsights/UpdateHostInsight");
        final java.util.function.Function<javax.ws.rs.core.Response, UpdateHostInsightResponse>
                transformer =
                        UpdateHostInsightConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<UpdateHostInsightRequest, UpdateHostInsightResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                UpdateHostInsightRequest, UpdateHostInsightResponse>,
                        java.util.concurrent.Future<UpdateHostInsightResponse>>
                futureSupplier =
                        client.putFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getUpdateHostInsightDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    UpdateHostInsightRequest, UpdateHostInsightResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<UpdateOperationsInsightsPrivateEndpointResponse>
            updateOperationsInsightsPrivateEndpoint(
                    UpdateOperationsInsightsPrivateEndpointRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    UpdateOperationsInsightsPrivateEndpointRequest,
                                    UpdateOperationsInsightsPrivateEndpointResponse>
                            handler) {
        LOG.trace("Called async updateOperationsInsightsPrivateEndpoint");
        final UpdateOperationsInsightsPrivateEndpointRequest interceptedRequest =
                UpdateOperationsInsightsPrivateEndpointConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                UpdateOperationsInsightsPrivateEndpointConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "UpdateOperationsInsightsPrivateEndpoint",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OperationsInsightsPrivateEndpoint/UpdateOperationsInsightsPrivateEndpoint");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, UpdateOperationsInsightsPrivateEndpointResponse>
                transformer =
                        UpdateOperationsInsightsPrivateEndpointConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        UpdateOperationsInsightsPrivateEndpointRequest,
                        UpdateOperationsInsightsPrivateEndpointResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                UpdateOperationsInsightsPrivateEndpointRequest,
                                UpdateOperationsInsightsPrivateEndpointResponse>,
                        java.util.concurrent.Future<
                                UpdateOperationsInsightsPrivateEndpointResponse>>
                futureSupplier =
                        client.putFutureSupplier(
                                interceptedRequest,
                                interceptedRequest
                                        .getUpdateOperationsInsightsPrivateEndpointDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    UpdateOperationsInsightsPrivateEndpointRequest,
                    UpdateOperationsInsightsPrivateEndpointResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<UpdateOperationsInsightsWarehouseResponse>
            updateOperationsInsightsWarehouse(
                    UpdateOperationsInsightsWarehouseRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    UpdateOperationsInsightsWarehouseRequest,
                                    UpdateOperationsInsightsWarehouseResponse>
                            handler) {
        LOG.trace("Called async updateOperationsInsightsWarehouse");
        final UpdateOperationsInsightsWarehouseRequest interceptedRequest =
                UpdateOperationsInsightsWarehouseConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                UpdateOperationsInsightsWarehouseConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "UpdateOperationsInsightsWarehouse",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OperationsInsightsWarehouses/UpdateOperationsInsightsWarehouse");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, UpdateOperationsInsightsWarehouseResponse>
                transformer =
                        UpdateOperationsInsightsWarehouseConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        UpdateOperationsInsightsWarehouseRequest,
                        UpdateOperationsInsightsWarehouseResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                UpdateOperationsInsightsWarehouseRequest,
                                UpdateOperationsInsightsWarehouseResponse>,
                        java.util.concurrent.Future<UpdateOperationsInsightsWarehouseResponse>>
                futureSupplier =
                        client.putFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getUpdateOperationsInsightsWarehouseDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    UpdateOperationsInsightsWarehouseRequest,
                    UpdateOperationsInsightsWarehouseResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<UpdateOperationsInsightsWarehouseUserResponse>
            updateOperationsInsightsWarehouseUser(
                    UpdateOperationsInsightsWarehouseUserRequest request,
                    final com.oracle.bmc.responses.AsyncHandler<
                                    UpdateOperationsInsightsWarehouseUserRequest,
                                    UpdateOperationsInsightsWarehouseUserResponse>
                            handler) {
        LOG.trace("Called async updateOperationsInsightsWarehouseUser");
        final UpdateOperationsInsightsWarehouseUserRequest interceptedRequest =
                UpdateOperationsInsightsWarehouseUserConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                UpdateOperationsInsightsWarehouseUserConverter.fromRequest(
                        client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "UpdateOperationsInsightsWarehouseUser",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OperationsInsightsWarehouseUsers/UpdateOperationsInsightsWarehouseUser");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, UpdateOperationsInsightsWarehouseUserResponse>
                transformer =
                        UpdateOperationsInsightsWarehouseUserConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        UpdateOperationsInsightsWarehouseUserRequest,
                        UpdateOperationsInsightsWarehouseUserResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                UpdateOperationsInsightsWarehouseUserRequest,
                                UpdateOperationsInsightsWarehouseUserResponse>,
                        java.util.concurrent.Future<UpdateOperationsInsightsWarehouseUserResponse>>
                futureSupplier =
                        client.putFutureSupplier(
                                interceptedRequest,
                                interceptedRequest
                                        .getUpdateOperationsInsightsWarehouseUserDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    UpdateOperationsInsightsWarehouseUserRequest,
                    UpdateOperationsInsightsWarehouseUserResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }

    @Override
    public java.util.concurrent.Future<UpdateOpsiConfigurationResponse> updateOpsiConfiguration(
            UpdateOpsiConfigurationRequest request,
            final com.oracle.bmc.responses.AsyncHandler<
                            UpdateOpsiConfigurationRequest, UpdateOpsiConfigurationResponse>
                    handler) {
        LOG.trace("Called async updateOpsiConfiguration");
        final UpdateOpsiConfigurationRequest interceptedRequest =
                UpdateOpsiConfigurationConverter.interceptRequest(request);
        final com.oracle.bmc.http.internal.WrappedInvocationBuilder ib =
                UpdateOpsiConfigurationConverter.fromRequest(client, interceptedRequest);
        com.oracle.bmc.ServiceDetails serviceDetails =
                new com.oracle.bmc.ServiceDetails(
                        "OperationsInsights",
                        "UpdateOpsiConfiguration",
                        ib.getRequestUri().toString(),
                        "https://docs.oracle.com/iaas/api/#/en/operations-insights/20200630/OpsiConfigurations/UpdateOpsiConfiguration");
        final java.util.function.Function<
                        javax.ws.rs.core.Response, UpdateOpsiConfigurationResponse>
                transformer =
                        UpdateOpsiConfigurationConverter.fromResponse(
                                java.util.Optional.of(serviceDetails));
        com.oracle.bmc.responses.AsyncHandler<
                        UpdateOpsiConfigurationRequest, UpdateOpsiConfigurationResponse>
                handlerToUse = handler;

        java.util.function.Function<
                        com.oracle.bmc.responses.AsyncHandler<
                                UpdateOpsiConfigurationRequest, UpdateOpsiConfigurationResponse>,
                        java.util.concurrent.Future<UpdateOpsiConfigurationResponse>>
                futureSupplier =
                        client.putFutureSupplier(
                                interceptedRequest,
                                interceptedRequest.getUpdateOpsiConfigurationDetails(),
                                ib,
                                transformer);

        if (this.authenticationDetailsProvider
                instanceof com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider) {
            return new com.oracle.bmc.util.internal.RefreshAuthTokenWrapper<
                    UpdateOpsiConfigurationRequest, UpdateOpsiConfigurationResponse>(
                    (com.oracle.bmc.auth.RefreshableOnNotAuthenticatedProvider)
                            this.authenticationDetailsProvider,
                    handlerToUse,
                    futureSupplier) {
                @Override
                protected void beforeRetryAction() {}
            };
        } else {
            return futureSupplier.apply(handlerToUse);
        }
    }
}

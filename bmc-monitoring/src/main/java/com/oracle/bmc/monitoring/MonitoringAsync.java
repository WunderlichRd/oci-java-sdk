/**
 * Copyright (c) 2016, 2023, Oracle and/or its affiliates.  All rights reserved.
 * This software is dual-licensed to you under the Universal Permissive License (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License 2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose either license.
 */
package com.oracle.bmc.monitoring;

import com.oracle.bmc.monitoring.requests.*;
import com.oracle.bmc.monitoring.responses.*;

/**
 * Use the Monitoring API to manage metric queries and alarms for assessing the health, capacity, and performance of your cloud resources.
 * Endpoints vary by operation. For PostMetric, use the {@code telemetry-ingestion} endpoints; for all other operations, use the {@code telemetry} endpoints.
 * For information about monitoring, see [Monitoring Overview](https://docs.cloud.oracle.com/iaas/Content/Monitoring/Concepts/monitoringoverview.htm).
 *
 */
@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20180401")
public interface MonitoringAsync extends AutoCloseable {

    /**
     * Rebuilds the client from scratch.
     * Useful to refresh certificates.
     */
    void refreshClient();

    /**
     * Sets the endpoint to call (ex, https://www.example.com).
     * @param endpoint The endpoint of the serice.
     */
    void setEndpoint(String endpoint);

    /**
     * Gets the set endpoint for REST call (ex, https://www.example.com)
     */
    String getEndpoint();

    /**
     * Sets the region to call (ex, Region.US_PHOENIX_1).
     * <p>
     * Note, this will call {@link #setEndpoint(String) setEndpoint} after resolving the endpoint.  If the service is not available in this region, however, an IllegalArgumentException will be raised.
     * @param region The region of the service.
     */
    void setRegion(com.oracle.bmc.Region region);

    /**
     * Sets the region to call (ex, 'us-phoenix-1').
     * <p>
     * Note, this will first try to map the region ID to a known Region and call
     * {@link #setRegion(Region) setRegion}.
     * <p>
     * If no known Region could be determined, it will create an endpoint based on the
     * default endpoint format ({@link com.oracle.bmc.Region#formatDefaultRegionEndpoint(Service, String)}
     * and then call {@link #setEndpoint(String) setEndpoint}.
     * @param regionId The public region ID.
     */
    void setRegion(String regionId);

    /**
     * Determines whether realm specific endpoint should be used or not.
     * Set realmSpecificEndpointTemplateEnabled to "true" if the user wants to enable use of realm specific endpoint template, otherwise set it to "false"
     * @param realmSpecificEndpointTemplateEnabled flag to enable the use of realm specific endpoint template
     */
    void useRealmSpecificEndpointTemplate(boolean realmSpecificEndpointTemplateEnabled);

    /**
     * Moves an alarm into a different compartment within the same tenancy.
     * <p>
     * For information about moving resources between compartments, see [Moving Resources Between Compartments](https://docs.cloud.oracle.com/iaas/Content/Identity/Tasks/managingcompartments.htm#moveRes).
     *
     *
     * @param request The request object containing the details to send
     * @param handler The request handler to invoke upon completion, may be null.
     * @return A Future that can be used to get the response if no AsyncHandler was
     *         provided. Note, if you provide an AsyncHandler and use the Future, some
     *         types of responses (like java.io.InputStream) may not be able to be read in
     *         both places as the underlying stream may only be consumed once.
     */
    java.util.concurrent.Future<ChangeAlarmCompartmentResponse> changeAlarmCompartment(
            ChangeAlarmCompartmentRequest request,
            com.oracle.bmc.responses.AsyncHandler<
                            ChangeAlarmCompartmentRequest, ChangeAlarmCompartmentResponse>
                    handler);

    /**
     * Creates a new alarm in the specified compartment.
     * For important limits information, see [Limits on Monitoring](https://docs.cloud.oracle.com/iaas/Content/Monitoring/Concepts/monitoringoverview.htm#Limits).
     * <p>
     * This call is subject to a Monitoring limit that applies to the total number of requests across all alarm operations.
     * Monitoring might throttle this call to reject an otherwise valid request when the total rate of alarm operations exceeds 10 requests,
     * or transactions, per second (TPS) for a given tenancy.
     *
     *
     * @param request The request object containing the details to send
     * @param handler The request handler to invoke upon completion, may be null.
     * @return A Future that can be used to get the response if no AsyncHandler was
     *         provided. Note, if you provide an AsyncHandler and use the Future, some
     *         types of responses (like java.io.InputStream) may not be able to be read in
     *         both places as the underlying stream may only be consumed once.
     */
    java.util.concurrent.Future<CreateAlarmResponse> createAlarm(
            CreateAlarmRequest request,
            com.oracle.bmc.responses.AsyncHandler<CreateAlarmRequest, CreateAlarmResponse> handler);

    /**
     * Deletes the specified alarm.
     * For important limits information, see [Limits on Monitoring](https://docs.cloud.oracle.com/iaas/Content/Monitoring/Concepts/monitoringoverview.htm#Limits).
     * <p>
     * This call is subject to a Monitoring limit that applies to the total number of requests across all alarm operations.
     * Monitoring might throttle this call to reject an otherwise valid request when the total rate of alarm operations exceeds 10 requests,
     * or transactions, per second (TPS) for a given tenancy.
     *
     *
     * @param request The request object containing the details to send
     * @param handler The request handler to invoke upon completion, may be null.
     * @return A Future that can be used to get the response if no AsyncHandler was
     *         provided. Note, if you provide an AsyncHandler and use the Future, some
     *         types of responses (like java.io.InputStream) may not be able to be read in
     *         both places as the underlying stream may only be consumed once.
     */
    java.util.concurrent.Future<DeleteAlarmResponse> deleteAlarm(
            DeleteAlarmRequest request,
            com.oracle.bmc.responses.AsyncHandler<DeleteAlarmRequest, DeleteAlarmResponse> handler);

    /**
     * Gets the specified alarm.
     * For important limits information, see [Limits on Monitoring](https://docs.cloud.oracle.com/iaas/Content/Monitoring/Concepts/monitoringoverview.htm#Limits).
     * <p>
     * This call is subject to a Monitoring limit that applies to the total number of requests across all alarm operations.
     * Monitoring might throttle this call to reject an otherwise valid request when the total rate of alarm operations exceeds 10 requests,
     * or transactions, per second (TPS) for a given tenancy.
     *
     *
     * @param request The request object containing the details to send
     * @param handler The request handler to invoke upon completion, may be null.
     * @return A Future that can be used to get the response if no AsyncHandler was
     *         provided. Note, if you provide an AsyncHandler and use the Future, some
     *         types of responses (like java.io.InputStream) may not be able to be read in
     *         both places as the underlying stream may only be consumed once.
     */
    java.util.concurrent.Future<GetAlarmResponse> getAlarm(
            GetAlarmRequest request,
            com.oracle.bmc.responses.AsyncHandler<GetAlarmRequest, GetAlarmResponse> handler);

    /**
     * Get the history of the specified alarm.
     * For important limits information, see [Limits on Monitoring](https://docs.cloud.oracle.com/iaas/Content/Monitoring/Concepts/monitoringoverview.htm#Limits).
     * <p>
     * This call is subject to a Monitoring limit that applies to the total number of requests across all alarm operations.
     * Monitoring might throttle this call to reject an otherwise valid request when the total rate of alarm operations exceeds 10 requests,
     * or transactions, per second (TPS) for a given tenancy.
     *
     *
     * @param request The request object containing the details to send
     * @param handler The request handler to invoke upon completion, may be null.
     * @return A Future that can be used to get the response if no AsyncHandler was
     *         provided. Note, if you provide an AsyncHandler and use the Future, some
     *         types of responses (like java.io.InputStream) may not be able to be read in
     *         both places as the underlying stream may only be consumed once.
     */
    java.util.concurrent.Future<GetAlarmHistoryResponse> getAlarmHistory(
            GetAlarmHistoryRequest request,
            com.oracle.bmc.responses.AsyncHandler<GetAlarmHistoryRequest, GetAlarmHistoryResponse>
                    handler);

    /**
     * Lists the alarms for the specified compartment.
     * For important limits information, see [Limits on Monitoring](https://docs.cloud.oracle.com/iaas/Content/Monitoring/Concepts/monitoringoverview.htm#Limits).
     * <p>
     * This call is subject to a Monitoring limit that applies to the total number of requests across all alarm operations.
     * Monitoring might throttle this call to reject an otherwise valid request when the total rate of alarm operations exceeds 10 requests,
     * or transactions, per second (TPS) for a given tenancy.
     *
     *
     * @param request The request object containing the details to send
     * @param handler The request handler to invoke upon completion, may be null.
     * @return A Future that can be used to get the response if no AsyncHandler was
     *         provided. Note, if you provide an AsyncHandler and use the Future, some
     *         types of responses (like java.io.InputStream) may not be able to be read in
     *         both places as the underlying stream may only be consumed once.
     */
    java.util.concurrent.Future<ListAlarmsResponse> listAlarms(
            ListAlarmsRequest request,
            com.oracle.bmc.responses.AsyncHandler<ListAlarmsRequest, ListAlarmsResponse> handler);

    /**
     * List the status of each alarm in the specified compartment.
     * Status is collective, across all metric streams in the alarm.
     * To list alarm status for each metric stream, use {@link #retrieveDimensionStates(RetrieveDimensionStatesRequest, Consumer, Consumer) retrieveDimensionStates}.
     * The alarm attribute `isNotificationsPerMetricDimensionEnabled` must be set to `true`.
     * For important limits information, see [Limits on Monitoring](https://docs.cloud.oracle.com/iaas/Content/Monitoring/Concepts/monitoringoverview.htm#Limits).
     * <p>
     * This call is subject to a Monitoring limit that applies to the total number of requests across all alarm operations.
     * Monitoring might throttle this call to reject an otherwise valid request when the total rate of alarm operations exceeds 10 requests,
     * or transactions, per second (TPS) for a given tenancy.
     *
     *
     * @param request The request object containing the details to send
     * @param handler The request handler to invoke upon completion, may be null.
     * @return A Future that can be used to get the response if no AsyncHandler was
     *         provided. Note, if you provide an AsyncHandler and use the Future, some
     *         types of responses (like java.io.InputStream) may not be able to be read in
     *         both places as the underlying stream may only be consumed once.
     */
    java.util.concurrent.Future<ListAlarmsStatusResponse> listAlarmsStatus(
            ListAlarmsStatusRequest request,
            com.oracle.bmc.responses.AsyncHandler<ListAlarmsStatusRequest, ListAlarmsStatusResponse>
                    handler);

    /**
     * Returns metric definitions that match the criteria specified in the request. Compartment OCID required.
     * For information about metrics, see [Metrics Overview](https://docs.cloud.oracle.com/iaas/Content/Monitoring/Concepts/monitoringoverview.htm#MetricsOverview).
     * For important limits information, see [Limits on Monitoring](https://docs.cloud.oracle.com/iaas/Content/Monitoring/Concepts/monitoringoverview.htm#Limits).
     * <p>
     * Transactions Per Second (TPS) per-tenancy limit for this operation: 10.
     *
     *
     * @param request The request object containing the details to send
     * @param handler The request handler to invoke upon completion, may be null.
     * @return A Future that can be used to get the response if no AsyncHandler was
     *         provided. Note, if you provide an AsyncHandler and use the Future, some
     *         types of responses (like java.io.InputStream) may not be able to be read in
     *         both places as the underlying stream may only be consumed once.
     */
    java.util.concurrent.Future<ListMetricsResponse> listMetrics(
            ListMetricsRequest request,
            com.oracle.bmc.responses.AsyncHandler<ListMetricsRequest, ListMetricsResponse> handler);

    /**
     * Publishes raw metric data points to the Monitoring service.
     * For more information about publishing metrics, see [Publishing Custom Metrics](https://docs.cloud.oracle.com/iaas/Content/Monitoring/Tasks/publishingcustommetrics.htm).
     * For important limits information, see [Limits on Monitoring](https://docs.cloud.oracle.com/iaas/Content/Monitoring/Concepts/monitoringoverview.htm#Limits).
     * <p>
     * Per-call limits information follows.
     * <p>
     * Dimensions per metric group*. Maximum: 20. Minimum: 1.
     * * Unique metric streams*. Maximum: 50.
     * * Transactions Per Second (TPS) per-tenancy limit for this operation: 50.
     * <p>
     *A metric group is the combination of a given metric, metric namespace, and tenancy for the purpose of determining limits.
     * A dimension is a qualifier provided in a metric definition.
     * A metric stream is an individual set of aggregated data for a metric with zero or more dimension values.
     * For more information about metric-related concepts, see [Monitoring Concepts](https://docs.cloud.oracle.com/iaas/Content/Monitoring/Concepts/monitoringoverview.htm#concepts).
     * <p>
     * The endpoints for this operation differ from other Monitoring operations. Replace the string `telemetry` with `telemetry-ingestion` in the endpoint, as in the following example:
     * <p>
     * https://telemetry-ingestion.eu-frankfurt-1.oraclecloud.com
     *
     *
     * @param request The request object containing the details to send
     * @param handler The request handler to invoke upon completion, may be null.
     * @return A Future that can be used to get the response if no AsyncHandler was
     *         provided. Note, if you provide an AsyncHandler and use the Future, some
     *         types of responses (like java.io.InputStream) may not be able to be read in
     *         both places as the underlying stream may only be consumed once.
     */
    java.util.concurrent.Future<PostMetricDataResponse> postMetricData(
            PostMetricDataRequest request,
            com.oracle.bmc.responses.AsyncHandler<PostMetricDataRequest, PostMetricDataResponse>
                    handler);

    /**
     * Removes any existing suppression for the specified alarm.
     * For important limits information, see [Limits on Monitoring](https://docs.cloud.oracle.com/iaas/Content/Monitoring/Concepts/monitoringoverview.htm#Limits).
     * <p>
     * This call is subject to a Monitoring limit that applies to the total number of requests across all alarm operations.
     * Monitoring might throttle this call to reject an otherwise valid request when the total rate of alarm operations exceeds 10 requests,
     * or transactions, per second (TPS) for a given tenancy.
     *
     *
     * @param request The request object containing the details to send
     * @param handler The request handler to invoke upon completion, may be null.
     * @return A Future that can be used to get the response if no AsyncHandler was
     *         provided. Note, if you provide an AsyncHandler and use the Future, some
     *         types of responses (like java.io.InputStream) may not be able to be read in
     *         both places as the underlying stream may only be consumed once.
     */
    java.util.concurrent.Future<RemoveAlarmSuppressionResponse> removeAlarmSuppression(
            RemoveAlarmSuppressionRequest request,
            com.oracle.bmc.responses.AsyncHandler<
                            RemoveAlarmSuppressionRequest, RemoveAlarmSuppressionResponse>
                    handler);

    /**
     * Lists the current alarm status of each metric stream, where status is derived from the metric stream's last associated transition.
     * Optionally filter by status value and one or more dimension key-value pairs.
     * This operation is only valid for alarms that have notifications per dimension enabled (`isNotificationsPerMetricDimensionEnabled=true`).
     *  If `isNotificationsPerMetricDimensionEnabled` for the alarm is false or null, then no results are returned.
     * <p>
     * For important limits information, see [Limits on Monitoring](https://docs.cloud.oracle.com/iaas/Content/Monitoring/Concepts/monitoringoverview.htm#Limits).
     *
     *  This call is subject to a Monitoring limit that applies to the total number of requests across all alarm operations.
     *  Monitoring might throttle this call to reject an otherwise valid request when the total rate of alarm operations exceeds 10 requests,
     *  or transactions, per second (TPS) for a given tenancy.
     *
     *
     * @param request The request object containing the details to send
     * @param handler The request handler to invoke upon completion, may be null.
     * @return A Future that can be used to get the response if no AsyncHandler was
     *         provided. Note, if you provide an AsyncHandler and use the Future, some
     *         types of responses (like java.io.InputStream) may not be able to be read in
     *         both places as the underlying stream may only be consumed once.
     */
    java.util.concurrent.Future<RetrieveDimensionStatesResponse> retrieveDimensionStates(
            RetrieveDimensionStatesRequest request,
            com.oracle.bmc.responses.AsyncHandler<
                            RetrieveDimensionStatesRequest, RetrieveDimensionStatesResponse>
                    handler);

    /**
     * Returns aggregated data that match the criteria specified in the request. Compartment OCID required.
     * For information on metric queries, see [Building Metric Queries](https://docs.cloud.oracle.com/iaas/Content/Monitoring/Tasks/buildingqueries.htm).
     * For important limits information, see [Limits on Monitoring](https://docs.cloud.oracle.com/iaas/Content/Monitoring/Concepts/monitoringoverview.htm#Limits).
     * <p>
     * Transactions Per Second (TPS) per-tenancy limit for this operation: 10.
     *
     *
     * @param request The request object containing the details to send
     * @param handler The request handler to invoke upon completion, may be null.
     * @return A Future that can be used to get the response if no AsyncHandler was
     *         provided. Note, if you provide an AsyncHandler and use the Future, some
     *         types of responses (like java.io.InputStream) may not be able to be read in
     *         both places as the underlying stream may only be consumed once.
     */
    java.util.concurrent.Future<SummarizeMetricsDataResponse> summarizeMetricsData(
            SummarizeMetricsDataRequest request,
            com.oracle.bmc.responses.AsyncHandler<
                            SummarizeMetricsDataRequest, SummarizeMetricsDataResponse>
                    handler);

    /**
     * Updates the specified alarm.
     * For important limits information, see [Limits on Monitoring](https://docs.cloud.oracle.com/iaas/Content/Monitoring/Concepts/monitoringoverview.htm#Limits).
     * <p>
     * This call is subject to a Monitoring limit that applies to the total number of requests across all alarm operations.
     * Monitoring might throttle this call to reject an otherwise valid request when the total rate of alarm operations exceeds 10 requests,
     * or transactions, per second (TPS) for a given tenancy.
     *
     *
     * @param request The request object containing the details to send
     * @param handler The request handler to invoke upon completion, may be null.
     * @return A Future that can be used to get the response if no AsyncHandler was
     *         provided. Note, if you provide an AsyncHandler and use the Future, some
     *         types of responses (like java.io.InputStream) may not be able to be read in
     *         both places as the underlying stream may only be consumed once.
     */
    java.util.concurrent.Future<UpdateAlarmResponse> updateAlarm(
            UpdateAlarmRequest request,
            com.oracle.bmc.responses.AsyncHandler<UpdateAlarmRequest, UpdateAlarmResponse> handler);
}

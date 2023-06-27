/**
 * Copyright (c) 2016, 2023, Oracle and/or its affiliates.  All rights reserved.
 * This software is dual-licensed to you under the Universal Permissive License (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License 2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose either license.
 */
package com.oracle.bmc.osmanagementhub.model;

/**
 * A custom software source contains a custom collection of packages.
 * <br/>
 * Note: Objects should always be created or deserialized using the {@link Builder}. This model distinguishes fields
 * that are {@code null} because they are unset from fields that are explicitly set to {@code null}. This is done in
 * the setter methods of the {@link Builder}, which maintain a set of all explicitly set fields called
 * {@link #__explicitlySet__}. The {@link #hashCode()} and {@link #equals(Object)} methods are implemented to take
 * {@link #__explicitlySet__} into account. The constructor, on the other hand, does not set {@link #__explicitlySet__}
 * (since the constructor cannot distinguish explicit {@code null} from unset {@code null}).
 **/
@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20220901")
@com.fasterxml.jackson.databind.annotation.JsonDeserialize(
    builder = CustomSoftwareSource.Builder.class
)
@com.fasterxml.jackson.annotation.JsonTypeInfo(
    use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME,
    include = com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY,
    property = "softwareSourceType"
)
@com.fasterxml.jackson.annotation.JsonFilter(com.oracle.bmc.http.internal.ExplicitlySetFilter.NAME)
public final class CustomSoftwareSource extends SoftwareSource {
    @com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
        @com.fasterxml.jackson.annotation.JsonProperty("id")
        private String id;

        public Builder id(String id) {
            this.id = id;
            this.__explicitlySet__.add("id");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("compartmentId")
        private String compartmentId;

        public Builder compartmentId(String compartmentId) {
            this.compartmentId = compartmentId;
            this.__explicitlySet__.add("compartmentId");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("displayName")
        private String displayName;

        public Builder displayName(String displayName) {
            this.displayName = displayName;
            this.__explicitlySet__.add("displayName");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("timeCreated")
        private java.util.Date timeCreated;

        public Builder timeCreated(java.util.Date timeCreated) {
            this.timeCreated = timeCreated;
            this.__explicitlySet__.add("timeCreated");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("description")
        private String description;

        public Builder description(String description) {
            this.description = description;
            this.__explicitlySet__.add("description");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("availability")
        private Availability availability;

        public Builder availability(Availability availability) {
            this.availability = availability;
            this.__explicitlySet__.add("availability");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("repoId")
        private String repoId;

        public Builder repoId(String repoId) {
            this.repoId = repoId;
            this.__explicitlySet__.add("repoId");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("osFamily")
        private OsFamily osFamily;

        public Builder osFamily(OsFamily osFamily) {
            this.osFamily = osFamily;
            this.__explicitlySet__.add("osFamily");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("archType")
        private ArchType archType;

        public Builder archType(ArchType archType) {
            this.archType = archType;
            this.__explicitlySet__.add("archType");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("lifecycleState")
        private LifecycleState lifecycleState;

        public Builder lifecycleState(LifecycleState lifecycleState) {
            this.lifecycleState = lifecycleState;
            this.__explicitlySet__.add("lifecycleState");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("packageCount")
        private Long packageCount;

        public Builder packageCount(Long packageCount) {
            this.packageCount = packageCount;
            this.__explicitlySet__.add("packageCount");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("url")
        private String url;

        public Builder url(String url) {
            this.url = url;
            this.__explicitlySet__.add("url");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("checksumType")
        private ChecksumType checksumType;

        public Builder checksumType(ChecksumType checksumType) {
            this.checksumType = checksumType;
            this.__explicitlySet__.add("checksumType");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("gpgKeyUrl")
        private String gpgKeyUrl;

        public Builder gpgKeyUrl(String gpgKeyUrl) {
            this.gpgKeyUrl = gpgKeyUrl;
            this.__explicitlySet__.add("gpgKeyUrl");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("gpgKeyId")
        private String gpgKeyId;

        public Builder gpgKeyId(String gpgKeyId) {
            this.gpgKeyId = gpgKeyId;
            this.__explicitlySet__.add("gpgKeyId");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("gpgKeyFingerprint")
        private String gpgKeyFingerprint;

        public Builder gpgKeyFingerprint(String gpgKeyFingerprint) {
            this.gpgKeyFingerprint = gpgKeyFingerprint;
            this.__explicitlySet__.add("gpgKeyFingerprint");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("freeformTags")
        private java.util.Map<String, String> freeformTags;

        public Builder freeformTags(java.util.Map<String, String> freeformTags) {
            this.freeformTags = freeformTags;
            this.__explicitlySet__.add("freeformTags");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("definedTags")
        private java.util.Map<String, java.util.Map<String, Object>> definedTags;

        public Builder definedTags(
                java.util.Map<String, java.util.Map<String, Object>> definedTags) {
            this.definedTags = definedTags;
            this.__explicitlySet__.add("definedTags");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("systemTags")
        private java.util.Map<String, java.util.Map<String, Object>> systemTags;

        public Builder systemTags(java.util.Map<String, java.util.Map<String, Object>> systemTags) {
            this.systemTags = systemTags;
            this.__explicitlySet__.add("systemTags");
            return this;
        }
        /**
         * List of vendor software sources.
         **/
        @com.fasterxml.jackson.annotation.JsonProperty("vendorSoftwareSources")
        private java.util.List<Id> vendorSoftwareSources;

        /**
         * List of vendor software sources.
         * @param vendorSoftwareSources the value to set
         * @return this builder
         **/
        public Builder vendorSoftwareSources(java.util.List<Id> vendorSoftwareSources) {
            this.vendorSoftwareSources = vendorSoftwareSources;
            this.__explicitlySet__.add("vendorSoftwareSources");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("customSoftwareSourceFilter")
        private CustomSoftwareSourceFilter customSoftwareSourceFilter;

        public Builder customSoftwareSourceFilter(
                CustomSoftwareSourceFilter customSoftwareSourceFilter) {
            this.customSoftwareSourceFilter = customSoftwareSourceFilter;
            this.__explicitlySet__.add("customSoftwareSourceFilter");
            return this;
        }
        /**
         * Indicates whether service should automatically update the custom software source for the user.
         **/
        @com.fasterxml.jackson.annotation.JsonProperty("isAutomaticallyUpdated")
        private Boolean isAutomaticallyUpdated;

        /**
         * Indicates whether service should automatically update the custom software source for the user.
         * @param isAutomaticallyUpdated the value to set
         * @return this builder
         **/
        public Builder isAutomaticallyUpdated(Boolean isAutomaticallyUpdated) {
            this.isAutomaticallyUpdated = isAutomaticallyUpdated;
            this.__explicitlySet__.add("isAutomaticallyUpdated");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonIgnore
        private final java.util.Set<String> __explicitlySet__ = new java.util.HashSet<String>();

        public CustomSoftwareSource build() {
            CustomSoftwareSource model =
                    new CustomSoftwareSource(
                            this.id,
                            this.compartmentId,
                            this.displayName,
                            this.timeCreated,
                            this.description,
                            this.availability,
                            this.repoId,
                            this.osFamily,
                            this.archType,
                            this.lifecycleState,
                            this.packageCount,
                            this.url,
                            this.checksumType,
                            this.gpgKeyUrl,
                            this.gpgKeyId,
                            this.gpgKeyFingerprint,
                            this.freeformTags,
                            this.definedTags,
                            this.systemTags,
                            this.vendorSoftwareSources,
                            this.customSoftwareSourceFilter,
                            this.isAutomaticallyUpdated);
            for (String explicitlySetProperty : this.__explicitlySet__) {
                model.markPropertyAsExplicitlySet(explicitlySetProperty);
            }
            return model;
        }

        @com.fasterxml.jackson.annotation.JsonIgnore
        public Builder copy(CustomSoftwareSource model) {
            if (model.wasPropertyExplicitlySet("id")) {
                this.id(model.getId());
            }
            if (model.wasPropertyExplicitlySet("compartmentId")) {
                this.compartmentId(model.getCompartmentId());
            }
            if (model.wasPropertyExplicitlySet("displayName")) {
                this.displayName(model.getDisplayName());
            }
            if (model.wasPropertyExplicitlySet("timeCreated")) {
                this.timeCreated(model.getTimeCreated());
            }
            if (model.wasPropertyExplicitlySet("description")) {
                this.description(model.getDescription());
            }
            if (model.wasPropertyExplicitlySet("availability")) {
                this.availability(model.getAvailability());
            }
            if (model.wasPropertyExplicitlySet("repoId")) {
                this.repoId(model.getRepoId());
            }
            if (model.wasPropertyExplicitlySet("osFamily")) {
                this.osFamily(model.getOsFamily());
            }
            if (model.wasPropertyExplicitlySet("archType")) {
                this.archType(model.getArchType());
            }
            if (model.wasPropertyExplicitlySet("lifecycleState")) {
                this.lifecycleState(model.getLifecycleState());
            }
            if (model.wasPropertyExplicitlySet("packageCount")) {
                this.packageCount(model.getPackageCount());
            }
            if (model.wasPropertyExplicitlySet("url")) {
                this.url(model.getUrl());
            }
            if (model.wasPropertyExplicitlySet("checksumType")) {
                this.checksumType(model.getChecksumType());
            }
            if (model.wasPropertyExplicitlySet("gpgKeyUrl")) {
                this.gpgKeyUrl(model.getGpgKeyUrl());
            }
            if (model.wasPropertyExplicitlySet("gpgKeyId")) {
                this.gpgKeyId(model.getGpgKeyId());
            }
            if (model.wasPropertyExplicitlySet("gpgKeyFingerprint")) {
                this.gpgKeyFingerprint(model.getGpgKeyFingerprint());
            }
            if (model.wasPropertyExplicitlySet("freeformTags")) {
                this.freeformTags(model.getFreeformTags());
            }
            if (model.wasPropertyExplicitlySet("definedTags")) {
                this.definedTags(model.getDefinedTags());
            }
            if (model.wasPropertyExplicitlySet("systemTags")) {
                this.systemTags(model.getSystemTags());
            }
            if (model.wasPropertyExplicitlySet("vendorSoftwareSources")) {
                this.vendorSoftwareSources(model.getVendorSoftwareSources());
            }
            if (model.wasPropertyExplicitlySet("customSoftwareSourceFilter")) {
                this.customSoftwareSourceFilter(model.getCustomSoftwareSourceFilter());
            }
            if (model.wasPropertyExplicitlySet("isAutomaticallyUpdated")) {
                this.isAutomaticallyUpdated(model.getIsAutomaticallyUpdated());
            }
            return this;
        }
    }

    /**
     * Create a new builder.
     */
    public static Builder builder() {
        return new Builder();
    }

    public Builder toBuilder() {
        return new Builder().copy(this);
    }

    @Deprecated
    public CustomSoftwareSource(
            String id,
            String compartmentId,
            String displayName,
            java.util.Date timeCreated,
            String description,
            Availability availability,
            String repoId,
            OsFamily osFamily,
            ArchType archType,
            LifecycleState lifecycleState,
            Long packageCount,
            String url,
            ChecksumType checksumType,
            String gpgKeyUrl,
            String gpgKeyId,
            String gpgKeyFingerprint,
            java.util.Map<String, String> freeformTags,
            java.util.Map<String, java.util.Map<String, Object>> definedTags,
            java.util.Map<String, java.util.Map<String, Object>> systemTags,
            java.util.List<Id> vendorSoftwareSources,
            CustomSoftwareSourceFilter customSoftwareSourceFilter,
            Boolean isAutomaticallyUpdated) {
        super(
                id,
                compartmentId,
                displayName,
                timeCreated,
                description,
                availability,
                repoId,
                osFamily,
                archType,
                lifecycleState,
                packageCount,
                url,
                checksumType,
                gpgKeyUrl,
                gpgKeyId,
                gpgKeyFingerprint,
                freeformTags,
                definedTags,
                systemTags);
        this.vendorSoftwareSources = vendorSoftwareSources;
        this.customSoftwareSourceFilter = customSoftwareSourceFilter;
        this.isAutomaticallyUpdated = isAutomaticallyUpdated;
    }

    /**
     * List of vendor software sources.
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("vendorSoftwareSources")
    private final java.util.List<Id> vendorSoftwareSources;

    /**
     * List of vendor software sources.
     * @return the value
     **/
    public java.util.List<Id> getVendorSoftwareSources() {
        return vendorSoftwareSources;
    }

    @com.fasterxml.jackson.annotation.JsonProperty("customSoftwareSourceFilter")
    private final CustomSoftwareSourceFilter customSoftwareSourceFilter;

    public CustomSoftwareSourceFilter getCustomSoftwareSourceFilter() {
        return customSoftwareSourceFilter;
    }

    /**
     * Indicates whether service should automatically update the custom software source for the user.
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("isAutomaticallyUpdated")
    private final Boolean isAutomaticallyUpdated;

    /**
     * Indicates whether service should automatically update the custom software source for the user.
     * @return the value
     **/
    public Boolean getIsAutomaticallyUpdated() {
        return isAutomaticallyUpdated;
    }

    @Override
    public String toString() {
        return this.toString(true);
    }

    /**
     * Return a string representation of the object.
     * @param includeByteArrayContents true to include the full contents of byte arrays
     * @return string representation
     */
    public String toString(boolean includeByteArrayContents) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("CustomSoftwareSource(");
        sb.append("super=").append(super.toString(includeByteArrayContents));
        sb.append(", vendorSoftwareSources=").append(String.valueOf(this.vendorSoftwareSources));
        sb.append(", customSoftwareSourceFilter=")
                .append(String.valueOf(this.customSoftwareSourceFilter));
        sb.append(", isAutomaticallyUpdated=").append(String.valueOf(this.isAutomaticallyUpdated));
        sb.append(")");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomSoftwareSource)) {
            return false;
        }

        CustomSoftwareSource other = (CustomSoftwareSource) o;
        return java.util.Objects.equals(this.vendorSoftwareSources, other.vendorSoftwareSources)
                && java.util.Objects.equals(
                        this.customSoftwareSourceFilter, other.customSoftwareSourceFilter)
                && java.util.Objects.equals(
                        this.isAutomaticallyUpdated, other.isAutomaticallyUpdated)
                && super.equals(other);
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        result =
                (result * PRIME)
                        + (this.vendorSoftwareSources == null
                                ? 43
                                : this.vendorSoftwareSources.hashCode());
        result =
                (result * PRIME)
                        + (this.customSoftwareSourceFilter == null
                                ? 43
                                : this.customSoftwareSourceFilter.hashCode());
        result =
                (result * PRIME)
                        + (this.isAutomaticallyUpdated == null
                                ? 43
                                : this.isAutomaticallyUpdated.hashCode());
        return result;
    }
}

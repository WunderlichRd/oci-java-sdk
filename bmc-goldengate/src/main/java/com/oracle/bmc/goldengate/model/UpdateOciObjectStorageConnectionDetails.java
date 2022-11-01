/**
 * Copyright (c) 2016, 2022, Oracle and/or its affiliates.  All rights reserved.
 * This software is dual-licensed to you under the Universal Permissive License (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License 2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose either license.
 */
package com.oracle.bmc.goldengate.model;

/**
 * The information to update a OCI Object Storage Connection.
 *
 * <br/>
 * Note: Objects should always be created or deserialized using the {@link Builder}. This model distinguishes fields
 * that are {@code null} because they are unset from fields that are explicitly set to {@code null}. This is done in
 * the setter methods of the {@link Builder}, which maintain a set of all explicitly set fields called
 * {@link #__explicitlySet__}. The {@link #hashCode()} and {@link #equals(Object)} methods are implemented to take
 * {@link #__explicitlySet__} into account. The constructor, on the other hand, does not set {@link #__explicitlySet__}
 * (since the constructor cannot distinguish explicit {@code null} from unset {@code null}).
 **/
@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20200407")
@com.fasterxml.jackson.databind.annotation.JsonDeserialize(
    builder = UpdateOciObjectStorageConnectionDetails.Builder.class
)
@com.fasterxml.jackson.annotation.JsonTypeInfo(
    use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME,
    include = com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY,
    property = "connectionType"
)
@com.fasterxml.jackson.annotation.JsonFilter(com.oracle.bmc.http.internal.ExplicitlySetFilter.NAME)
public final class UpdateOciObjectStorageConnectionDetails extends UpdateConnectionDetails {
    @com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
        @com.fasterxml.jackson.annotation.JsonProperty("displayName")
        private String displayName;

        public Builder displayName(String displayName) {
            this.displayName = displayName;
            this.__explicitlySet__.add("displayName");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("description")
        private String description;

        public Builder description(String description) {
            this.description = description;
            this.__explicitlySet__.add("description");
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

        @com.fasterxml.jackson.annotation.JsonProperty("vaultId")
        private String vaultId;

        public Builder vaultId(String vaultId) {
            this.vaultId = vaultId;
            this.__explicitlySet__.add("vaultId");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("keyId")
        private String keyId;

        public Builder keyId(String keyId) {
            this.keyId = keyId;
            this.__explicitlySet__.add("keyId");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonProperty("nsgIds")
        private java.util.List<String> nsgIds;

        public Builder nsgIds(java.util.List<String> nsgIds) {
            this.nsgIds = nsgIds;
            this.__explicitlySet__.add("nsgIds");
            return this;
        }
        /**
         * The [OCID](https://docs.cloud.oracle.com/Content/General/Concepts/identifiers.htm) of the related OCI tenancy.
         *
         **/
        @com.fasterxml.jackson.annotation.JsonProperty("tenancyId")
        private String tenancyId;

        /**
         * The [OCID](https://docs.cloud.oracle.com/Content/General/Concepts/identifiers.htm) of the related OCI tenancy.
         *
         * @param tenancyId the value to set
         * @return this builder
         **/
        public Builder tenancyId(String tenancyId) {
            this.tenancyId = tenancyId;
            this.__explicitlySet__.add("tenancyId");
            return this;
        }
        /**
         * The name of the region. e.g.: us-ashburn-1
         *
         **/
        @com.fasterxml.jackson.annotation.JsonProperty("region")
        private String region;

        /**
         * The name of the region. e.g.: us-ashburn-1
         *
         * @param region the value to set
         * @return this builder
         **/
        public Builder region(String region) {
            this.region = region;
            this.__explicitlySet__.add("region");
            return this;
        }
        /**
         * The [OCID](https://docs.cloud.oracle.com/Content/General/Concepts/identifiers.htm) of the OCI user who will access the Object Storage.
         * The user must have write access to the bucket they want to connect to.
         *
         **/
        @com.fasterxml.jackson.annotation.JsonProperty("userId")
        private String userId;

        /**
         * The [OCID](https://docs.cloud.oracle.com/Content/General/Concepts/identifiers.htm) of the OCI user who will access the Object Storage.
         * The user must have write access to the bucket they want to connect to.
         *
         * @param userId the value to set
         * @return this builder
         **/
        public Builder userId(String userId) {
            this.userId = userId;
            this.__explicitlySet__.add("userId");
            return this;
        }
        /**
         * The base64 encoded content of the private key file (PEM file) corresponding to the API key of the fingerprint.
         * See documentation: https://docs.oracle.com/en-us/iaas/Content/Identity/Tasks/managingcredentials.htm
         *
         **/
        @com.fasterxml.jackson.annotation.JsonProperty("privateKeyFile")
        private String privateKeyFile;

        /**
         * The base64 encoded content of the private key file (PEM file) corresponding to the API key of the fingerprint.
         * See documentation: https://docs.oracle.com/en-us/iaas/Content/Identity/Tasks/managingcredentials.htm
         *
         * @param privateKeyFile the value to set
         * @return this builder
         **/
        public Builder privateKeyFile(String privateKeyFile) {
            this.privateKeyFile = privateKeyFile;
            this.__explicitlySet__.add("privateKeyFile");
            return this;
        }
        /**
         * The fingerprint of the API Key of the user specified by the userId.
         * See documentation: https://docs.oracle.com/en-us/iaas/Content/Identity/Tasks/managingcredentials.htm
         *
         **/
        @com.fasterxml.jackson.annotation.JsonProperty("publicKeyFingerprint")
        private String publicKeyFingerprint;

        /**
         * The fingerprint of the API Key of the user specified by the userId.
         * See documentation: https://docs.oracle.com/en-us/iaas/Content/Identity/Tasks/managingcredentials.htm
         *
         * @param publicKeyFingerprint the value to set
         * @return this builder
         **/
        public Builder publicKeyFingerprint(String publicKeyFingerprint) {
            this.publicKeyFingerprint = publicKeyFingerprint;
            this.__explicitlySet__.add("publicKeyFingerprint");
            return this;
        }

        @com.fasterxml.jackson.annotation.JsonIgnore
        private final java.util.Set<String> __explicitlySet__ = new java.util.HashSet<String>();

        public UpdateOciObjectStorageConnectionDetails build() {
            UpdateOciObjectStorageConnectionDetails model =
                    new UpdateOciObjectStorageConnectionDetails(
                            this.displayName,
                            this.description,
                            this.freeformTags,
                            this.definedTags,
                            this.vaultId,
                            this.keyId,
                            this.nsgIds,
                            this.tenancyId,
                            this.region,
                            this.userId,
                            this.privateKeyFile,
                            this.publicKeyFingerprint);
            for (String explicitlySetProperty : this.__explicitlySet__) {
                model.markPropertyAsExplicitlySet(explicitlySetProperty);
            }
            return model;
        }

        @com.fasterxml.jackson.annotation.JsonIgnore
        public Builder copy(UpdateOciObjectStorageConnectionDetails model) {
            if (model.wasPropertyExplicitlySet("displayName")) {
                this.displayName(model.getDisplayName());
            }
            if (model.wasPropertyExplicitlySet("description")) {
                this.description(model.getDescription());
            }
            if (model.wasPropertyExplicitlySet("freeformTags")) {
                this.freeformTags(model.getFreeformTags());
            }
            if (model.wasPropertyExplicitlySet("definedTags")) {
                this.definedTags(model.getDefinedTags());
            }
            if (model.wasPropertyExplicitlySet("vaultId")) {
                this.vaultId(model.getVaultId());
            }
            if (model.wasPropertyExplicitlySet("keyId")) {
                this.keyId(model.getKeyId());
            }
            if (model.wasPropertyExplicitlySet("nsgIds")) {
                this.nsgIds(model.getNsgIds());
            }
            if (model.wasPropertyExplicitlySet("tenancyId")) {
                this.tenancyId(model.getTenancyId());
            }
            if (model.wasPropertyExplicitlySet("region")) {
                this.region(model.getRegion());
            }
            if (model.wasPropertyExplicitlySet("userId")) {
                this.userId(model.getUserId());
            }
            if (model.wasPropertyExplicitlySet("privateKeyFile")) {
                this.privateKeyFile(model.getPrivateKeyFile());
            }
            if (model.wasPropertyExplicitlySet("publicKeyFingerprint")) {
                this.publicKeyFingerprint(model.getPublicKeyFingerprint());
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
    public UpdateOciObjectStorageConnectionDetails(
            String displayName,
            String description,
            java.util.Map<String, String> freeformTags,
            java.util.Map<String, java.util.Map<String, Object>> definedTags,
            String vaultId,
            String keyId,
            java.util.List<String> nsgIds,
            String tenancyId,
            String region,
            String userId,
            String privateKeyFile,
            String publicKeyFingerprint) {
        super(displayName, description, freeformTags, definedTags, vaultId, keyId, nsgIds);
        this.tenancyId = tenancyId;
        this.region = region;
        this.userId = userId;
        this.privateKeyFile = privateKeyFile;
        this.publicKeyFingerprint = publicKeyFingerprint;
    }

    /**
     * The [OCID](https://docs.cloud.oracle.com/Content/General/Concepts/identifiers.htm) of the related OCI tenancy.
     *
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("tenancyId")
    private final String tenancyId;

    /**
     * The [OCID](https://docs.cloud.oracle.com/Content/General/Concepts/identifiers.htm) of the related OCI tenancy.
     *
     * @return the value
     **/
    public String getTenancyId() {
        return tenancyId;
    }

    /**
     * The name of the region. e.g.: us-ashburn-1
     *
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("region")
    private final String region;

    /**
     * The name of the region. e.g.: us-ashburn-1
     *
     * @return the value
     **/
    public String getRegion() {
        return region;
    }

    /**
     * The [OCID](https://docs.cloud.oracle.com/Content/General/Concepts/identifiers.htm) of the OCI user who will access the Object Storage.
     * The user must have write access to the bucket they want to connect to.
     *
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("userId")
    private final String userId;

    /**
     * The [OCID](https://docs.cloud.oracle.com/Content/General/Concepts/identifiers.htm) of the OCI user who will access the Object Storage.
     * The user must have write access to the bucket they want to connect to.
     *
     * @return the value
     **/
    public String getUserId() {
        return userId;
    }

    /**
     * The base64 encoded content of the private key file (PEM file) corresponding to the API key of the fingerprint.
     * See documentation: https://docs.oracle.com/en-us/iaas/Content/Identity/Tasks/managingcredentials.htm
     *
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("privateKeyFile")
    private final String privateKeyFile;

    /**
     * The base64 encoded content of the private key file (PEM file) corresponding to the API key of the fingerprint.
     * See documentation: https://docs.oracle.com/en-us/iaas/Content/Identity/Tasks/managingcredentials.htm
     *
     * @return the value
     **/
    public String getPrivateKeyFile() {
        return privateKeyFile;
    }

    /**
     * The fingerprint of the API Key of the user specified by the userId.
     * See documentation: https://docs.oracle.com/en-us/iaas/Content/Identity/Tasks/managingcredentials.htm
     *
     **/
    @com.fasterxml.jackson.annotation.JsonProperty("publicKeyFingerprint")
    private final String publicKeyFingerprint;

    /**
     * The fingerprint of the API Key of the user specified by the userId.
     * See documentation: https://docs.oracle.com/en-us/iaas/Content/Identity/Tasks/managingcredentials.htm
     *
     * @return the value
     **/
    public String getPublicKeyFingerprint() {
        return publicKeyFingerprint;
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
        sb.append("UpdateOciObjectStorageConnectionDetails(");
        sb.append("super=").append(super.toString(includeByteArrayContents));
        sb.append(", tenancyId=").append(String.valueOf(this.tenancyId));
        sb.append(", region=").append(String.valueOf(this.region));
        sb.append(", userId=").append(String.valueOf(this.userId));
        sb.append(", privateKeyFile=").append(String.valueOf(this.privateKeyFile));
        sb.append(", publicKeyFingerprint=").append(String.valueOf(this.publicKeyFingerprint));
        sb.append(")");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UpdateOciObjectStorageConnectionDetails)) {
            return false;
        }

        UpdateOciObjectStorageConnectionDetails other = (UpdateOciObjectStorageConnectionDetails) o;
        return java.util.Objects.equals(this.tenancyId, other.tenancyId)
                && java.util.Objects.equals(this.region, other.region)
                && java.util.Objects.equals(this.userId, other.userId)
                && java.util.Objects.equals(this.privateKeyFile, other.privateKeyFile)
                && java.util.Objects.equals(this.publicKeyFingerprint, other.publicKeyFingerprint)
                && super.equals(other);
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        result = (result * PRIME) + (this.tenancyId == null ? 43 : this.tenancyId.hashCode());
        result = (result * PRIME) + (this.region == null ? 43 : this.region.hashCode());
        result = (result * PRIME) + (this.userId == null ? 43 : this.userId.hashCode());
        result =
                (result * PRIME)
                        + (this.privateKeyFile == null ? 43 : this.privateKeyFile.hashCode());
        result =
                (result * PRIME)
                        + (this.publicKeyFingerprint == null
                                ? 43
                                : this.publicKeyFingerprint.hashCode());
        return result;
    }
}

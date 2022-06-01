package co.streamPractice;

import java.util.Objects;
import java.util.StringJoiner;

public class LinkedAccount {

    private String linkedId;
    private String merchantId;
    private String tenant;
    private String source;

    public LinkedAccount() {
    }

    public LinkedAccount(String linkedId, String merchantId, String tenant, String source) {
        this.linkedId = linkedId;
        this.merchantId = merchantId;
        this.tenant = tenant;
        this.source = source;
    }

    public String getLinkedId() {
        return linkedId;
    }

    public void setLinkedId(String linkedId) {
        this.linkedId = linkedId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final LinkedAccount that = (LinkedAccount) obj;
        return Objects.equals(linkedId, that.linkedId) && Objects.equals(merchantId, that.merchantId) && Objects
                .equals(tenant, that.tenant) && Objects.equals(source, that.source);
    }

    @Override public int hashCode() {
        return Objects.hash(linkedId, merchantId, tenant, source);
    }

    @Override public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{ ", " }");
        if (linkedId != null) {
            joiner.add("linkedId: \"" + linkedId + "\"");
        }
        if (merchantId != null) {
            joiner.add("merchantId: \"" + merchantId + "\"");
        }
        if (tenant != null) {
            joiner.add("tenant: \"" + tenant + "\"");
        }
        if (source != null) {
            joiner.add("source: \"" + source + "\"");
        }
        return joiner.toString();
    }

    public static LinkedAccount.Builder builder() {
        return new LinkedAccount.Builder();
    }

    public static class Builder {

        private String linkedId;
        private String merchantId;
        private String tenant;
        private String source;

        public Builder() {
        }

        public Builder setLinkedId(String linkedId) {
            this.linkedId = linkedId;
            return this;
        }

        public Builder setMerchantId(String merchantId) {
            this.merchantId = merchantId;
            return this;
        }

        public Builder setTenant(String tenant) {
            this.tenant = tenant;
            return this;
        }

        public Builder setSource(String source) {
            this.source = source;
            return this;
        }

        public LinkedAccount build() {
            return new LinkedAccount(linkedId, merchantId, tenant, source);
        }

    }
}
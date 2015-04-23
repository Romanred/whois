package nl.grol.whois.data.model;

/* automatically generated: do not edit manually */

import com.google.common.base.Preconditions;
import net.ripe.db.whois.api.rest.domain.Attribute;
import net.ripe.db.whois.api.rest.domain.Source;
import net.ripe.db.whois.api.rest.domain.WhoisObject;
import net.ripe.db.whois.api.rest.domain.WhoisResources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyCert {
    private static final List<String> ATTR_NOT_IN_REQ = Arrays.asList("auth", "created", "last-modified");

    private CommentedValue keyCert = null;
    private CommentedValue method = null;
    private List<CommentedValue> owner = new ArrayList<CommentedValue>();
    private CommentedValue fingerpr = null;
    private List<CommentedValue> certif = new ArrayList<CommentedValue>();
    private List<CommentedValue> orgRef = new ArrayList<CommentedValue>();
    private List<CommentedValue> remarks = new ArrayList<CommentedValue>();
    private List<CommentedValue> notify = new ArrayList<CommentedValue>();
    private List<CommentedValue> adminCRef = new ArrayList<CommentedValue>();
    private List<CommentedValue> techCRef = new ArrayList<CommentedValue>();
    private List<CommentedValue> mntByRef = new ArrayList<CommentedValue>();
    private List<CommentedValue> changed = new ArrayList<CommentedValue>();
    private CommentedValue created = null;
    private CommentedValue lastModified = null;
    private CommentedValue source = null;


    public KeyCert(final Builder builder) {
        Preconditions.checkState(builder != null);
        this.keyCert = builder.keyCert;
        this.method = builder.method;
        this.owner = builder.owner;
        this.fingerpr = builder.fingerpr;
        this.certif = builder.certif;
        this.orgRef = builder.orgRef;
        this.remarks = builder.remarks;
        this.notify = builder.notify;
        this.adminCRef = builder.adminCRef;
        this.techCRef = builder.techCRef;
        this.mntByRef = builder.mntByRef;
        this.changed = builder.changed;
        this.created = builder.created;
        this.lastModified = builder.lastModified;
        this.source = builder.source;
    }

    // key-cert
    public CommentedValue getKeyCert() {
        return this.keyCert;
    }

    public String getKeyCertValue() {
        String value = null;
        if (this.keyCert != null) {
            value = this.keyCert.getValue();
        }
        return value;
    }

    // method
    public boolean hasMethod() {
        return this.method != null;
    }

    public CommentedValue getMethod() {
        return this.method;
    }

    public String getMethodValue() {
        String value = null;
        if (this.method != null) {
            value = this.method.getValue();
        }
        return value;
    }

    // owner
    public boolean hasOwner() {
        return this.owner.size() > 0;
    }

    public List<CommentedValue> getOwner() {
        return this.owner;
    }

    public List<String> getOwnerValues() {
        List<String> values = new ArrayList<String>();
        for (CommentedValue value : this.owner) {
            values.add(value.getValue());
        }
        return values;
    }

    // fingerpr
    public boolean hasFingerpr() {
        return this.fingerpr != null;
    }

    public CommentedValue getFingerpr() {
        return this.fingerpr;
    }

    public String getFingerprValue() {
        String value = null;
        if (this.fingerpr != null) {
            value = this.fingerpr.getValue();
        }
        return value;
    }

    // certif
    public List<CommentedValue> getCertif() {
        return this.certif;
    }

    public List<String> getCertifValues() {
        List<String> values = new ArrayList<String>();
        for (CommentedValue value : this.certif) {
            values.add(value.getValue());
        }
        return values;
    }

    // org
    public boolean hasOrgRef() {
        return this.orgRef.size() > 0;
    }

    public List<CommentedValue> getOrgRef() {
        return this.orgRef;
    }

    public List<String> getOrgRefValues() {
        List<String> values = new ArrayList<String>();
        for (CommentedValue value : this.orgRef) {
            values.add(value.getValue());
        }
        return values;
    }

    // remarks
    public boolean hasRemarks() {
        return this.remarks.size() > 0;
    }

    public List<CommentedValue> getRemarks() {
        return this.remarks;
    }

    public List<String> getRemarksValues() {
        List<String> values = new ArrayList<String>();
        for (CommentedValue value : this.remarks) {
            values.add(value.getValue());
        }
        return values;
    }

    // notify
    public boolean hasNotify() {
        return this.notify.size() > 0;
    }

    public List<CommentedValue> getNotify() {
        return this.notify;
    }

    public List<String> getNotifyValues() {
        List<String> values = new ArrayList<String>();
        for (CommentedValue value : this.notify) {
            values.add(value.getValue());
        }
        return values;
    }

    // admin-c
    public boolean hasAdminCRef() {
        return this.adminCRef.size() > 0;
    }

    public List<CommentedValue> getAdminCRef() {
        return this.adminCRef;
    }

    public List<String> getAdminCRefValues() {
        List<String> values = new ArrayList<String>();
        for (CommentedValue value : this.adminCRef) {
            values.add(value.getValue());
        }
        return values;
    }

    // tech-c
    public boolean hasTechCRef() {
        return this.techCRef.size() > 0;
    }

    public List<CommentedValue> getTechCRef() {
        return this.techCRef;
    }

    public List<String> getTechCRefValues() {
        List<String> values = new ArrayList<String>();
        for (CommentedValue value : this.techCRef) {
            values.add(value.getValue());
        }
        return values;
    }

    // mnt-by
    public List<CommentedValue> getMntByRef() {
        return this.mntByRef;
    }

    public List<String> getMntByRefValues() {
        List<String> values = new ArrayList<String>();
        for (CommentedValue value : this.mntByRef) {
            values.add(value.getValue());
        }
        return values;
    }

    // changed
    public List<CommentedValue> getChanged() {
        return this.changed;
    }

    public List<String> getChangedValues() {
        List<String> values = new ArrayList<String>();
        for (CommentedValue value : this.changed) {
            values.add(value.getValue());
        }
        return values;
    }

    // created
    public boolean hasCreated() {
        return this.created != null;
    }

    public CommentedValue getCreated() {
        return this.created;
    }

    public String getCreatedValue() {
        String value = null;
        if (this.created != null) {
            value = this.created.getValue();
        }
        return value;
    }

    // last-modified
    public boolean hasLastModified() {
        return this.lastModified != null;
    }

    public CommentedValue getLastModified() {
        return this.lastModified;
    }

    public String getLastModifiedValue() {
        String value = null;
        if (this.lastModified != null) {
            value = this.lastModified.getValue();
        }
        return value;
    }

    // source
    public CommentedValue getSource() {
        return this.source;
    }

    public String getSourceValue() {
        String value = null;
        if (this.source != null) {
            value = this.source.getValue();
        }
        return value;
    }


    public void validate() {
        Preconditions.checkState(keyCert != null && keyCert.getValue() != null, "Missing (single) mandatory attribute 'key-cert'");
        Preconditions.checkState(certif != null && certif.size() > 0, "Missing (multiple) mandatory attribute 'certif'");
        Preconditions.checkState(mntByRef != null && mntByRef.size() > 0, "Missing (multiple) mandatory attribute 'mnt-by'");
        Preconditions.checkState(changed != null && changed.size() > 0, "Missing (multiple) mandatory attribute 'changed'");
        Preconditions.checkState(source != null && source.getValue() != null, "Missing (single) mandatory attribute 'source'");

    }


    public WhoisResources toRequest() {
        WhoisResources whoisResources = new WhoisResources();

        WhoisObject whoisObject = new WhoisObject();
        whoisObject.setSource(new Source(this.source.getValue()));
        whoisObject.setType("key-cert");

        List<Attribute> attributes = new ArrayList<Attribute>();
        if (keyCert != null) {
            if (!ATTR_NOT_IN_REQ.contains("key-cert")) {
                attributes.add(new Attribute("key-cert",
                        keyCert.getValue(),
                        keyCert.getComment(),
                        null, null));
            }
        }
        if (method != null) {
            if (!ATTR_NOT_IN_REQ.contains("method")) {
                attributes.add(new Attribute("method",
                        method.getValue(),
                        method.getComment(),
                        null, null));
            }
        }
        if (owner != null) {
            if (!ATTR_NOT_IN_REQ.contains("owner")) {
                for (CommentedValue value : owner) {
                    attributes.add(new Attribute("owner",
                            value.getValue(),
                            value.getComment(),
                            null, null));
                }
            }
        }
        if (fingerpr != null) {
            if (!ATTR_NOT_IN_REQ.contains("fingerpr")) {
                attributes.add(new Attribute("fingerpr",
                        fingerpr.getValue(),
                        fingerpr.getComment(),
                        null, null));
            }
        }
        if (certif != null) {
            if (!ATTR_NOT_IN_REQ.contains("certif")) {
                for (CommentedValue value : certif) {
                    attributes.add(new Attribute("certif",
                            value.getValue(),
                            value.getComment(),
                            null, null));
                }
            }
        }
        if (orgRef != null) {
            if (!ATTR_NOT_IN_REQ.contains("org")) {
                for (CommentedValue value : orgRef) {
                    attributes.add(new Attribute("org",
                            value.getValue(),
                            value.getComment(),
                            null, null));
                }
            }
        }
        if (remarks != null) {
            if (!ATTR_NOT_IN_REQ.contains("remarks")) {
                for (CommentedValue value : remarks) {
                    attributes.add(new Attribute("remarks",
                            value.getValue(),
                            value.getComment(),
                            null, null));
                }
            }
        }
        if (notify != null) {
            if (!ATTR_NOT_IN_REQ.contains("notify")) {
                for (CommentedValue value : notify) {
                    attributes.add(new Attribute("notify",
                            value.getValue(),
                            value.getComment(),
                            null, null));
                }
            }
        }
        if (adminCRef != null) {
            if (!ATTR_NOT_IN_REQ.contains("admin-c")) {
                for (CommentedValue value : adminCRef) {
                    attributes.add(new Attribute("admin-c",
                            value.getValue(),
                            value.getComment(),
                            null, null));
                }
            }
        }
        if (techCRef != null) {
            if (!ATTR_NOT_IN_REQ.contains("tech-c")) {
                for (CommentedValue value : techCRef) {
                    attributes.add(new Attribute("tech-c",
                            value.getValue(),
                            value.getComment(),
                            null, null));
                }
            }
        }
        if (mntByRef != null) {
            if (!ATTR_NOT_IN_REQ.contains("mnt-by")) {
                for (CommentedValue value : mntByRef) {
                    attributes.add(new Attribute("mnt-by",
                            value.getValue(),
                            value.getComment(),
                            null, null));
                }
            }
        }
        if (changed != null) {
            if (!ATTR_NOT_IN_REQ.contains("changed")) {
                for (CommentedValue value : changed) {
                    attributes.add(new Attribute("changed",
                            value.getValue(),
                            value.getComment(),
                            null, null));
                }
            }
        }
        if (created != null) {
            if (!ATTR_NOT_IN_REQ.contains("created")) {
                attributes.add(new Attribute("created",
                        created.getValue(),
                        created.getComment(),
                        null, null));
            }
        }
        if (lastModified != null) {
            if (!ATTR_NOT_IN_REQ.contains("last-modified")) {
                attributes.add(new Attribute("last-modified",
                        lastModified.getValue(),
                        lastModified.getComment(),
                        null, null));
            }
        }
        if (source != null) {
            if (!ATTR_NOT_IN_REQ.contains("source")) {
                attributes.add(new Attribute("source",
                        source.getValue(),
                        source.getComment(),
                        null, null));
            }
        }
        whoisObject.setAttributes(attributes);

        whoisResources.setWhoisObjects(Arrays.asList(whoisObject));
        return whoisResources;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        appendRpslAttribute(sb, "key-cert", this.keyCert);
        appendRpslAttribute(sb, "method", this.method);
        appendRpslAttribute(sb, "owner", this.owner);
        appendRpslAttribute(sb, "fingerpr", this.fingerpr);
        appendRpslAttribute(sb, "certif", this.certif);
        appendRpslAttribute(sb, "org", this.orgRef);
        appendRpslAttribute(sb, "remarks", this.remarks);
        appendRpslAttribute(sb, "notify", this.notify);
        appendRpslAttribute(sb, "admin-c", this.adminCRef);
        appendRpslAttribute(sb, "tech-c", this.techCRef);
        appendRpslAttribute(sb, "mnt-by", this.mntByRef);
        appendRpslAttribute(sb, "changed", this.changed);
        appendRpslAttribute(sb, "created", this.created);
        appendRpslAttribute(sb, "last-modified", this.lastModified);
        appendRpslAttribute(sb, "source", this.source);
        sb.append("\n");
        return sb.toString();
    }

    private void appendRpslAttribute(StringBuffer sb, String key, CommentedValue value) {
        if (value != null) {
            String comment = value.getComment() == null ? "" : String.format(" # %s", value.getComment());
            sb.append(String.format("\t%-20s%s%s\n", String.format("%s:", key), value.getValue(), comment));
        }
    }

    private void appendRpslAttribute(StringBuffer sb, String key, List<CommentedValue> values) {
        for (CommentedValue value : values) {
            String comment = value.getComment() == null ? "" : String.format(" # %s", value.getComment());
            sb.append(String.format("\t%-20s%s%s\n", String.format("%s:", key), value.getValue(), comment));
        }
    }

    public static class Builder {

        private CommentedValue keyCert = null;
        private CommentedValue method = null;
        private List<CommentedValue> owner = new ArrayList<CommentedValue>();
        private CommentedValue fingerpr = null;
        private List<CommentedValue> certif = new ArrayList<CommentedValue>();
        private List<CommentedValue> orgRef = new ArrayList<CommentedValue>();
        private List<CommentedValue> remarks = new ArrayList<CommentedValue>();
        private List<CommentedValue> notify = new ArrayList<CommentedValue>();
        private List<CommentedValue> adminCRef = new ArrayList<CommentedValue>();
        private List<CommentedValue> techCRef = new ArrayList<CommentedValue>();
        private List<CommentedValue> mntByRef = new ArrayList<CommentedValue>();
        private List<CommentedValue> changed = new ArrayList<CommentedValue>();
        private CommentedValue created = null;
        private CommentedValue lastModified = null;
        private CommentedValue source = null;


        public static Builder fromResponse(WhoisResources whoisResources) {
            Builder builder = new Builder();
            for (WhoisObject whoisObject : whoisResources.getWhoisObjects()) {
                if (whoisObject.getType().equals("key-cert")) {
                    for (net.ripe.db.whois.api.rest.domain.Attribute attr : whoisObject.getAttributes()) {
                        if (attr.getName().equals("key-cert")) {
                            builder.setKeyCert(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("method")) {
                            builder.setMethod(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("owner")) {
                            builder.addOwner(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("fingerpr")) {
                            builder.setFingerpr(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("certif")) {
                            builder.addCertif(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("org")) {
                            builder.addOrgRef(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("remarks")) {
                            builder.addRemarks(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("notify")) {
                            builder.addNotify(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("admin-c")) {
                            builder.addAdminCRef(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("tech-c")) {
                            builder.addTechCRef(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("mnt-by")) {
                            builder.addMntByRef(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("changed")) {
                            builder.addChanged(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("created")) {
                            builder.setCreated(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("last-modified")) {
                            builder.setLastModified(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("source")) {
                            builder.setSource(attr.getValue(), attr.getComment());
                        }

                    }
                    break;
                }
            }
            return builder;
        }


        // key-cert
        public CommentedValue getKeyCert() {
            return this.keyCert;
        }

        public Builder setKeyCert(final String value) {
            Preconditions.checkState(value != null);
            this.keyCert = new CommentedValue(value);
            return this;
        }

        public String getKeyCertValue() {
            String value = null;
            if (this.keyCert != null) {
                value = this.keyCert.getValue();
            }
            return value;
        }

        public Builder setKeyCert(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.keyCert = new CommentedValue(value, comment);
            return this;
        }

        public Builder removeKeyCert() {
            this.keyCert = null;
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder mandatorySetKeyCert(final String value) {
            Preconditions.checkState(value != null);
            this.setKeyCert(value);
            return this;
        }

        public Builder mandatorySetKeyCert(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.setKeyCert(value, comment);
            return this;
        }

        // method
        public boolean hasMethod() {
            return this.method != null;
        }

        public CommentedValue getMethod() {
            return this.method;
        }

        public Builder setMethod(final String value) {
            Preconditions.checkState(value != null);
            this.method = new CommentedValue(value);
            return this;
        }

        public String getMethodValue() {
            String value = null;
            if (this.method != null) {
                value = this.method.getValue();
            }
            return value;
        }

        public Builder setMethod(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.method = new CommentedValue(value, comment);
            return this;
        }

        public Builder removeMethod() {
            this.method = null;
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder optionalSetMethod(final String value) {
            Preconditions.checkState(value != null);
            this.setMethod(value);
            return this;
        }

        public Builder optionalSetMethod(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.setMethod(value, comment);
            return this;
        }

        // owner
        public boolean hasOwner() {
            return this.owner.size() > 0;
        }

        public List<CommentedValue> getOwner() {
            return this.owner;
        }

        public Builder setOwner(final List<CommentedValue> values) {
            Preconditions.checkState(values != null);
            this.owner = values;
            return this;
        }

        public List<String> getOwnerValues() {
            List<String> values = new ArrayList<String>();
            for (CommentedValue value : owner) {
                values.add(value.getValue());
            }
            return values;
        }

        public Builder addOwner(final String value) {
            Preconditions.checkState(value != null);
            this.owner.add(new CommentedValue(value));
            return this;
        }

        public Builder addOwner(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.owner.add(new CommentedValue(value, comment));
            return this;
        }

        public Builder removeOwnerAll() {
            this.owner.clear();
            return this;
        }

        public Builder removeOwnerAt(int index) {
            Preconditions.checkState(index >= 0 && index < owner.size(), "Invalid remove-at index for (multiple) attribute 'owner'");
            this.owner.remove(index);
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder optionalAddOwner(final String value) {
            Preconditions.checkState(value != null);
            return addOwner(value);
        }

        public Builder optionalAddOwner(final String value, final String comment) {
            Preconditions.checkState(value != null);
            return addOwner(value, comment);
        }

        // fingerpr
        public boolean hasFingerpr() {
            return this.fingerpr != null;
        }

        public CommentedValue getFingerpr() {
            return this.fingerpr;
        }

        public Builder setFingerpr(final String value) {
            Preconditions.checkState(value != null);
            this.fingerpr = new CommentedValue(value);
            return this;
        }

        public String getFingerprValue() {
            String value = null;
            if (this.fingerpr != null) {
                value = this.fingerpr.getValue();
            }
            return value;
        }

        public Builder setFingerpr(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.fingerpr = new CommentedValue(value, comment);
            return this;
        }

        public Builder removeFingerpr() {
            this.fingerpr = null;
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder optionalSetFingerpr(final String value) {
            Preconditions.checkState(value != null);
            this.setFingerpr(value);
            return this;
        }

        public Builder optionalSetFingerpr(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.setFingerpr(value, comment);
            return this;
        }

        // certif
        public List<CommentedValue> getCertif() {
            return this.certif;
        }

        public Builder setCertif(final List<CommentedValue> values) {
            Preconditions.checkState(values != null);
            this.certif = values;
            return this;
        }

        public List<String> getCertifValues() {
            List<String> values = new ArrayList<String>();
            for (CommentedValue value : certif) {
                values.add(value.getValue());
            }
            return values;
        }

        public Builder addCertif(final String value) {
            Preconditions.checkState(value != null);
            this.certif.add(new CommentedValue(value));
            return this;
        }

        public Builder addCertif(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.certif.add(new CommentedValue(value, comment));
            return this;
        }

        public Builder removeCertifAll() {
            this.certif.clear();
            return this;
        }

        public Builder removeCertifAt(int index) {
            Preconditions.checkState(index >= 0 && index < certif.size(), "Invalid remove-at index for (multiple) attribute 'certif'");
            this.certif.remove(index);
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder mandatoryAddCertif(final String value) {
            Preconditions.checkState(value != null);
            return addCertif(value);
        }

        public Builder mandatoryAddCertif(final String value, final String comment) {
            Preconditions.checkState(value != null);
            return addCertif(value, comment);
        }

        // org
        public boolean hasOrgRef() {
            return this.orgRef.size() > 0;
        }

        public List<CommentedValue> getOrgRef() {
            return this.orgRef;
        }

        public Builder setOrgRef(final List<CommentedValue> values) {
            Preconditions.checkState(values != null);
            this.orgRef = values;
            return this;
        }

        public List<String> getOrgRefValues() {
            List<String> values = new ArrayList<String>();
            for (CommentedValue value : orgRef) {
                values.add(value.getValue());
            }
            return values;
        }

        public Builder addOrgRef(final String value) {
            Preconditions.checkState(value != null);
            this.orgRef.add(new CommentedValue(value));
            return this;
        }

        public Builder addOrgRef(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.orgRef.add(new CommentedValue(value, comment));
            return this;
        }

        public Builder removeOrgRefAll() {
            this.orgRef.clear();
            return this;
        }

        public Builder removeOrgRefAt(int index) {
            Preconditions.checkState(index >= 0 && index < orgRef.size(), "Invalid remove-at index for (multiple) attribute 'org'");
            this.orgRef.remove(index);
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder optionalAddOrgRef(final String value) {
            Preconditions.checkState(value != null);
            return addOrgRef(value);
        }

        public Builder optionalAddOrgRef(final String value, final String comment) {
            Preconditions.checkState(value != null);
            return addOrgRef(value, comment);
        }

        // remarks
        public boolean hasRemarks() {
            return this.remarks.size() > 0;
        }

        public List<CommentedValue> getRemarks() {
            return this.remarks;
        }

        public Builder setRemarks(final List<CommentedValue> values) {
            Preconditions.checkState(values != null);
            this.remarks = values;
            return this;
        }

        public List<String> getRemarksValues() {
            List<String> values = new ArrayList<String>();
            for (CommentedValue value : remarks) {
                values.add(value.getValue());
            }
            return values;
        }

        public Builder addRemarks(final String value) {
            Preconditions.checkState(value != null);
            this.remarks.add(new CommentedValue(value));
            return this;
        }

        public Builder addRemarks(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.remarks.add(new CommentedValue(value, comment));
            return this;
        }

        public Builder removeRemarksAll() {
            this.remarks.clear();
            return this;
        }

        public Builder removeRemarksAt(int index) {
            Preconditions.checkState(index >= 0 && index < remarks.size(), "Invalid remove-at index for (multiple) attribute 'remarks'");
            this.remarks.remove(index);
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder optionalAddRemarks(final String value) {
            Preconditions.checkState(value != null);
            return addRemarks(value);
        }

        public Builder optionalAddRemarks(final String value, final String comment) {
            Preconditions.checkState(value != null);
            return addRemarks(value, comment);
        }

        // notify
        public boolean hasNotify() {
            return this.notify.size() > 0;
        }

        public List<CommentedValue> getNotify() {
            return this.notify;
        }

        public Builder setNotify(final List<CommentedValue> values) {
            Preconditions.checkState(values != null);
            this.notify = values;
            return this;
        }

        public List<String> getNotifyValues() {
            List<String> values = new ArrayList<String>();
            for (CommentedValue value : notify) {
                values.add(value.getValue());
            }
            return values;
        }

        public Builder addNotify(final String value) {
            Preconditions.checkState(value != null);
            this.notify.add(new CommentedValue(value));
            return this;
        }

        public Builder addNotify(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.notify.add(new CommentedValue(value, comment));
            return this;
        }

        public Builder removeNotifyAll() {
            this.notify.clear();
            return this;
        }

        public Builder removeNotifyAt(int index) {
            Preconditions.checkState(index >= 0 && index < notify.size(), "Invalid remove-at index for (multiple) attribute 'notify'");
            this.notify.remove(index);
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder optionalAddNotify(final String value) {
            Preconditions.checkState(value != null);
            return addNotify(value);
        }

        public Builder optionalAddNotify(final String value, final String comment) {
            Preconditions.checkState(value != null);
            return addNotify(value, comment);
        }

        // admin-c
        public boolean hasAdminCRef() {
            return this.adminCRef.size() > 0;
        }

        public List<CommentedValue> getAdminCRef() {
            return this.adminCRef;
        }

        public Builder setAdminCRef(final List<CommentedValue> values) {
            Preconditions.checkState(values != null);
            this.adminCRef = values;
            return this;
        }

        public List<String> getAdminCRefValues() {
            List<String> values = new ArrayList<String>();
            for (CommentedValue value : adminCRef) {
                values.add(value.getValue());
            }
            return values;
        }

        public Builder addAdminCRef(final String value) {
            Preconditions.checkState(value != null);
            this.adminCRef.add(new CommentedValue(value));
            return this;
        }

        public Builder addAdminCRef(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.adminCRef.add(new CommentedValue(value, comment));
            return this;
        }

        public Builder removeAdminCRefAll() {
            this.adminCRef.clear();
            return this;
        }

        public Builder removeAdminCRefAt(int index) {
            Preconditions.checkState(index >= 0 && index < adminCRef.size(), "Invalid remove-at index for (multiple) attribute 'admin-c'");
            this.adminCRef.remove(index);
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder optionalAddAdminCRef(final String value) {
            Preconditions.checkState(value != null);
            return addAdminCRef(value);
        }

        public Builder optionalAddAdminCRef(final String value, final String comment) {
            Preconditions.checkState(value != null);
            return addAdminCRef(value, comment);
        }

        // tech-c
        public boolean hasTechCRef() {
            return this.techCRef.size() > 0;
        }

        public List<CommentedValue> getTechCRef() {
            return this.techCRef;
        }

        public Builder setTechCRef(final List<CommentedValue> values) {
            Preconditions.checkState(values != null);
            this.techCRef = values;
            return this;
        }

        public List<String> getTechCRefValues() {
            List<String> values = new ArrayList<String>();
            for (CommentedValue value : techCRef) {
                values.add(value.getValue());
            }
            return values;
        }

        public Builder addTechCRef(final String value) {
            Preconditions.checkState(value != null);
            this.techCRef.add(new CommentedValue(value));
            return this;
        }

        public Builder addTechCRef(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.techCRef.add(new CommentedValue(value, comment));
            return this;
        }

        public Builder removeTechCRefAll() {
            this.techCRef.clear();
            return this;
        }

        public Builder removeTechCRefAt(int index) {
            Preconditions.checkState(index >= 0 && index < techCRef.size(), "Invalid remove-at index for (multiple) attribute 'tech-c'");
            this.techCRef.remove(index);
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder optionalAddTechCRef(final String value) {
            Preconditions.checkState(value != null);
            return addTechCRef(value);
        }

        public Builder optionalAddTechCRef(final String value, final String comment) {
            Preconditions.checkState(value != null);
            return addTechCRef(value, comment);
        }

        // mnt-by
        public List<CommentedValue> getMntByRef() {
            return this.mntByRef;
        }

        public Builder setMntByRef(final List<CommentedValue> values) {
            Preconditions.checkState(values != null);
            this.mntByRef = values;
            return this;
        }

        public List<String> getMntByRefValues() {
            List<String> values = new ArrayList<String>();
            for (CommentedValue value : mntByRef) {
                values.add(value.getValue());
            }
            return values;
        }

        public Builder addMntByRef(final String value) {
            Preconditions.checkState(value != null);
            this.mntByRef.add(new CommentedValue(value));
            return this;
        }

        public Builder addMntByRef(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.mntByRef.add(new CommentedValue(value, comment));
            return this;
        }

        public Builder removeMntByRefAll() {
            this.mntByRef.clear();
            return this;
        }

        public Builder removeMntByRefAt(int index) {
            Preconditions.checkState(index >= 0 && index < mntByRef.size(), "Invalid remove-at index for (multiple) attribute 'mnt-by'");
            this.mntByRef.remove(index);
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder mandatoryAddMntByRef(final String value) {
            Preconditions.checkState(value != null);
            return addMntByRef(value);
        }

        public Builder mandatoryAddMntByRef(final String value, final String comment) {
            Preconditions.checkState(value != null);
            return addMntByRef(value, comment);
        }

        // changed
        public List<CommentedValue> getChanged() {
            return this.changed;
        }

        public Builder setChanged(final List<CommentedValue> values) {
            Preconditions.checkState(values != null);
            this.changed = values;
            return this;
        }

        public List<String> getChangedValues() {
            List<String> values = new ArrayList<String>();
            for (CommentedValue value : changed) {
                values.add(value.getValue());
            }
            return values;
        }

        public Builder addChanged(final String value) {
            Preconditions.checkState(value != null);
            this.changed.add(new CommentedValue(value));
            return this;
        }

        public Builder addChanged(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.changed.add(new CommentedValue(value, comment));
            return this;
        }

        public Builder removeChangedAll() {
            this.changed.clear();
            return this;
        }

        public Builder removeChangedAt(int index) {
            Preconditions.checkState(index >= 0 && index < changed.size(), "Invalid remove-at index for (multiple) attribute 'changed'");
            this.changed.remove(index);
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder mandatoryAddChanged(final String value) {
            Preconditions.checkState(value != null);
            return addChanged(value);
        }

        public Builder mandatoryAddChanged(final String value, final String comment) {
            Preconditions.checkState(value != null);
            return addChanged(value, comment);
        }

        // created
        public boolean hasCreated() {
            return this.created != null;
        }

        public CommentedValue getCreated() {
            return this.created;
        }

        public Builder setCreated(final String value) {
            Preconditions.checkState(value != null);
            this.created = new CommentedValue(value);
            return this;
        }

        public String getCreatedValue() {
            String value = null;
            if (this.created != null) {
                value = this.created.getValue();
            }
            return value;
        }

        public Builder setCreated(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.created = new CommentedValue(value, comment);
            return this;
        }

        public Builder removeCreated() {
            this.created = null;
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder optionalSetCreated(final String value) {
            Preconditions.checkState(value != null);
            this.setCreated(value);
            return this;
        }

        public Builder optionalSetCreated(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.setCreated(value, comment);
            return this;
        }

        // last-modified
        public boolean hasLastModified() {
            return this.lastModified != null;
        }

        public CommentedValue getLastModified() {
            return this.lastModified;
        }

        public Builder setLastModified(final String value) {
            Preconditions.checkState(value != null);
            this.lastModified = new CommentedValue(value);
            return this;
        }

        public String getLastModifiedValue() {
            String value = null;
            if (this.lastModified != null) {
                value = this.lastModified.getValue();
            }
            return value;
        }

        public Builder setLastModified(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.lastModified = new CommentedValue(value, comment);
            return this;
        }

        public Builder removeLastModified() {
            this.lastModified = null;
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder optionalSetLastModified(final String value) {
            Preconditions.checkState(value != null);
            this.setLastModified(value);
            return this;
        }

        public Builder optionalSetLastModified(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.setLastModified(value, comment);
            return this;
        }

        // source
        public CommentedValue getSource() {
            return this.source;
        }

        public Builder setSource(final String value) {
            Preconditions.checkState(value != null);
            this.source = new CommentedValue(value);
            return this;
        }

        public String getSourceValue() {
            String value = null;
            if (this.source != null) {
                value = this.source.getValue();
            }
            return value;
        }

        public Builder setSource(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.source = new CommentedValue(value, comment);
            return this;
        }

        public Builder removeSource() {
            this.source = null;
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder mandatorySetSource(final String value) {
            Preconditions.checkState(value != null);
            this.setSource(value);
            return this;
        }

        public Builder mandatorySetSource(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.setSource(value, comment);
            return this;
        }


        public KeyCert build() {
            KeyCert obj = new KeyCert(this);
            obj.validate();
            return obj;
        }
    }

    ;

};
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

public class Role {
    private static final List<String> ATTR_NOT_IN_REQ = Arrays.asList("auth", "created", "last-modified");

    private CommentedValue role = null;
    private List<CommentedValue> address = new ArrayList<CommentedValue>();
    private List<CommentedValue> phone = new ArrayList<CommentedValue>();
    private List<CommentedValue> faxNo = new ArrayList<CommentedValue>();
    private List<CommentedValue> eMail = new ArrayList<CommentedValue>();
    private List<CommentedValue> orgRef = new ArrayList<CommentedValue>();
    private List<CommentedValue> adminCRef = new ArrayList<CommentedValue>();
    private List<CommentedValue> techCRef = new ArrayList<CommentedValue>();
    private CommentedValue nicHdl = null;
    private List<CommentedValue> remarks = new ArrayList<CommentedValue>();
    private List<CommentedValue> notify = new ArrayList<CommentedValue>();
    private CommentedValue abuseMailbox = null;
    private List<CommentedValue> mntByRef = new ArrayList<CommentedValue>();
    private List<CommentedValue> changed = new ArrayList<CommentedValue>();
    private CommentedValue created = null;
    private CommentedValue lastModified = null;
    private CommentedValue source = null;


    public Role(final Builder builder) {
        Preconditions.checkState(builder != null);
        this.role = builder.role;
        this.address = builder.address;
        this.phone = builder.phone;
        this.faxNo = builder.faxNo;
        this.eMail = builder.eMail;
        this.orgRef = builder.orgRef;
        this.adminCRef = builder.adminCRef;
        this.techCRef = builder.techCRef;
        this.nicHdl = builder.nicHdl;
        this.remarks = builder.remarks;
        this.notify = builder.notify;
        this.abuseMailbox = builder.abuseMailbox;
        this.mntByRef = builder.mntByRef;
        this.changed = builder.changed;
        this.created = builder.created;
        this.lastModified = builder.lastModified;
        this.source = builder.source;
    }

    // role
    public CommentedValue getRole() {
        return this.role;
    }

    public String getRoleValue() {
        String value = null;
        if (this.role != null) {
            value = this.role.getValue();
        }
        return value;
    }

    // address
    public List<CommentedValue> getAddress() {
        return this.address;
    }

    public List<String> getAddressValues() {
        List<String> values = new ArrayList<String>();
        for (CommentedValue value : this.address) {
            values.add(value.getValue());
        }
        return values;
    }

    // phone
    public boolean hasPhone() {
        return this.phone.size() > 0;
    }

    public List<CommentedValue> getPhone() {
        return this.phone;
    }

    public List<String> getPhoneValues() {
        List<String> values = new ArrayList<String>();
        for (CommentedValue value : this.phone) {
            values.add(value.getValue());
        }
        return values;
    }

    // fax-no
    public boolean hasFaxNo() {
        return this.faxNo.size() > 0;
    }

    public List<CommentedValue> getFaxNo() {
        return this.faxNo;
    }

    public List<String> getFaxNoValues() {
        List<String> values = new ArrayList<String>();
        for (CommentedValue value : this.faxNo) {
            values.add(value.getValue());
        }
        return values;
    }

    // e-mail
    public List<CommentedValue> getEMail() {
        return this.eMail;
    }

    public List<String> getEMailValues() {
        List<String> values = new ArrayList<String>();
        for (CommentedValue value : this.eMail) {
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

    // nic-hdl
    public CommentedValue getNicHdl() {
        return this.nicHdl;
    }

    public String getNicHdlValue() {
        String value = null;
        if (this.nicHdl != null) {
            value = this.nicHdl.getValue();
        }
        return value;
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

    // abuse-mailbox
    public boolean hasAbuseMailbox() {
        return this.abuseMailbox != null;
    }

    public CommentedValue getAbuseMailbox() {
        return this.abuseMailbox;
    }

    public String getAbuseMailboxValue() {
        String value = null;
        if (this.abuseMailbox != null) {
            value = this.abuseMailbox.getValue();
        }
        return value;
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
        Preconditions.checkState(role != null && role.getValue() != null, "Missing (single) mandatory attribute 'role'");
        Preconditions.checkState(address != null && address.size() > 0, "Missing (multiple) mandatory attribute 'address'");
        Preconditions.checkState(eMail != null && eMail.size() > 0, "Missing (multiple) mandatory attribute 'e-mail'");
        Preconditions.checkState(nicHdl != null && nicHdl.getValue() != null, "Missing (single) mandatory attribute 'nic-hdl'");
        Preconditions.checkState(mntByRef != null && mntByRef.size() > 0, "Missing (multiple) mandatory attribute 'mnt-by'");
        Preconditions.checkState(changed != null && changed.size() > 0, "Missing (multiple) mandatory attribute 'changed'");
        Preconditions.checkState(source != null && source.getValue() != null, "Missing (single) mandatory attribute 'source'");

    }


    public WhoisResources toRequest() {
        WhoisResources whoisResources = new WhoisResources();

        WhoisObject whoisObject = new WhoisObject();
        whoisObject.setSource(new Source(this.source.getValue()));
        whoisObject.setType("role");

        List<Attribute> attributes = new ArrayList<Attribute>();
        if (role != null) {
            if (!ATTR_NOT_IN_REQ.contains("role")) {
                attributes.add(new Attribute("role",
                        role.getValue(),
                        role.getComment(),
                        null, null));
            }
        }
        if (address != null) {
            if (!ATTR_NOT_IN_REQ.contains("address")) {
                for (CommentedValue value : address) {
                    attributes.add(new Attribute("address",
                            value.getValue(),
                            value.getComment(),
                            null, null));
                }
            }
        }
        if (phone != null) {
            if (!ATTR_NOT_IN_REQ.contains("phone")) {
                for (CommentedValue value : phone) {
                    attributes.add(new Attribute("phone",
                            value.getValue(),
                            value.getComment(),
                            null, null));
                }
            }
        }
        if (faxNo != null) {
            if (!ATTR_NOT_IN_REQ.contains("fax-no")) {
                for (CommentedValue value : faxNo) {
                    attributes.add(new Attribute("fax-no",
                            value.getValue(),
                            value.getComment(),
                            null, null));
                }
            }
        }
        if (eMail != null) {
            if (!ATTR_NOT_IN_REQ.contains("e-mail")) {
                for (CommentedValue value : eMail) {
                    attributes.add(new Attribute("e-mail",
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
        if (nicHdl != null) {
            if (!ATTR_NOT_IN_REQ.contains("nic-hdl")) {
                attributes.add(new Attribute("nic-hdl",
                        nicHdl.getValue(),
                        nicHdl.getComment(),
                        null, null));
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
        if (abuseMailbox != null) {
            if (!ATTR_NOT_IN_REQ.contains("abuse-mailbox")) {
                attributes.add(new Attribute("abuse-mailbox",
                        abuseMailbox.getValue(),
                        abuseMailbox.getComment(),
                        null, null));
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
        appendRpslAttribute(sb, "role", this.role);
        appendRpslAttribute(sb, "address", this.address);
        appendRpslAttribute(sb, "phone", this.phone);
        appendRpslAttribute(sb, "fax-no", this.faxNo);
        appendRpslAttribute(sb, "e-mail", this.eMail);
        appendRpslAttribute(sb, "org", this.orgRef);
        appendRpslAttribute(sb, "admin-c", this.adminCRef);
        appendRpslAttribute(sb, "tech-c", this.techCRef);
        appendRpslAttribute(sb, "nic-hdl", this.nicHdl);
        appendRpslAttribute(sb, "remarks", this.remarks);
        appendRpslAttribute(sb, "notify", this.notify);
        appendRpslAttribute(sb, "abuse-mailbox", this.abuseMailbox);
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

        private CommentedValue role = null;
        private List<CommentedValue> address = new ArrayList<CommentedValue>();
        private List<CommentedValue> phone = new ArrayList<CommentedValue>();
        private List<CommentedValue> faxNo = new ArrayList<CommentedValue>();
        private List<CommentedValue> eMail = new ArrayList<CommentedValue>();
        private List<CommentedValue> orgRef = new ArrayList<CommentedValue>();
        private List<CommentedValue> adminCRef = new ArrayList<CommentedValue>();
        private List<CommentedValue> techCRef = new ArrayList<CommentedValue>();
        private CommentedValue nicHdl = null;
        private List<CommentedValue> remarks = new ArrayList<CommentedValue>();
        private List<CommentedValue> notify = new ArrayList<CommentedValue>();
        private CommentedValue abuseMailbox = null;
        private List<CommentedValue> mntByRef = new ArrayList<CommentedValue>();
        private List<CommentedValue> changed = new ArrayList<CommentedValue>();
        private CommentedValue created = null;
        private CommentedValue lastModified = null;
        private CommentedValue source = null;


        public static Builder fromResponse(WhoisResources whoisResources) {
            Builder builder = new Builder();
            for (WhoisObject whoisObject : whoisResources.getWhoisObjects()) {
                if (whoisObject.getType().equals("role")) {
                    for (net.ripe.db.whois.api.rest.domain.Attribute attr : whoisObject.getAttributes()) {
                        if (attr.getName().equals("role")) {
                            builder.setRole(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("address")) {
                            builder.addAddress(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("phone")) {
                            builder.addPhone(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("fax-no")) {
                            builder.addFaxNo(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("e-mail")) {
                            builder.addEMail(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("org")) {
                            builder.addOrgRef(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("admin-c")) {
                            builder.addAdminCRef(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("tech-c")) {
                            builder.addTechCRef(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("nic-hdl")) {
                            builder.setNicHdl(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("remarks")) {
                            builder.addRemarks(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("notify")) {
                            builder.addNotify(attr.getValue(), attr.getComment());
                        }
                        if (attr.getName().equals("abuse-mailbox")) {
                            builder.setAbuseMailbox(attr.getValue(), attr.getComment());
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


        // role
        public CommentedValue getRole() {
            return this.role;
        }

        public Builder setRole(final String value) {
            Preconditions.checkState(value != null);
            this.role = new CommentedValue(value);
            return this;
        }

        public String getRoleValue() {
            String value = null;
            if (this.role != null) {
                value = this.role.getValue();
            }
            return value;
        }

        public Builder setRole(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.role = new CommentedValue(value, comment);
            return this;
        }

        public Builder removeRole() {
            this.role = null;
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder mandatorySetRole(final String value) {
            Preconditions.checkState(value != null);
            this.setRole(value);
            return this;
        }

        public Builder mandatorySetRole(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.setRole(value, comment);
            return this;
        }

        // address
        public List<CommentedValue> getAddress() {
            return this.address;
        }

        public Builder setAddress(final List<CommentedValue> values) {
            Preconditions.checkState(values != null);
            this.address = values;
            return this;
        }

        public List<String> getAddressValues() {
            List<String> values = new ArrayList<String>();
            for (CommentedValue value : address) {
                values.add(value.getValue());
            }
            return values;
        }

        public Builder addAddress(final String value) {
            Preconditions.checkState(value != null);
            this.address.add(new CommentedValue(value));
            return this;
        }

        public Builder addAddress(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.address.add(new CommentedValue(value, comment));
            return this;
        }

        public Builder removeAddressAll() {
            this.address.clear();
            return this;
        }

        public Builder removeAddressAt(int index) {
            Preconditions.checkState(index >= 0 && index < address.size(), "Invalid remove-at index for (multiple) attribute 'address'");
            this.address.remove(index);
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder mandatoryAddAddress(final String value) {
            Preconditions.checkState(value != null);
            return addAddress(value);
        }

        public Builder mandatoryAddAddress(final String value, final String comment) {
            Preconditions.checkState(value != null);
            return addAddress(value, comment);
        }

        // phone
        public boolean hasPhone() {
            return this.phone.size() > 0;
        }

        public List<CommentedValue> getPhone() {
            return this.phone;
        }

        public Builder setPhone(final List<CommentedValue> values) {
            Preconditions.checkState(values != null);
            this.phone = values;
            return this;
        }

        public List<String> getPhoneValues() {
            List<String> values = new ArrayList<String>();
            for (CommentedValue value : phone) {
                values.add(value.getValue());
            }
            return values;
        }

        public Builder addPhone(final String value) {
            Preconditions.checkState(value != null);
            this.phone.add(new CommentedValue(value));
            return this;
        }

        public Builder addPhone(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.phone.add(new CommentedValue(value, comment));
            return this;
        }

        public Builder removePhoneAll() {
            this.phone.clear();
            return this;
        }

        public Builder removePhoneAt(int index) {
            Preconditions.checkState(index >= 0 && index < phone.size(), "Invalid remove-at index for (multiple) attribute 'phone'");
            this.phone.remove(index);
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder optionalAddPhone(final String value) {
            Preconditions.checkState(value != null);
            return addPhone(value);
        }

        public Builder optionalAddPhone(final String value, final String comment) {
            Preconditions.checkState(value != null);
            return addPhone(value, comment);
        }

        // fax-no
        public boolean hasFaxNo() {
            return this.faxNo.size() > 0;
        }

        public List<CommentedValue> getFaxNo() {
            return this.faxNo;
        }

        public Builder setFaxNo(final List<CommentedValue> values) {
            Preconditions.checkState(values != null);
            this.faxNo = values;
            return this;
        }

        public List<String> getFaxNoValues() {
            List<String> values = new ArrayList<String>();
            for (CommentedValue value : faxNo) {
                values.add(value.getValue());
            }
            return values;
        }

        public Builder addFaxNo(final String value) {
            Preconditions.checkState(value != null);
            this.faxNo.add(new CommentedValue(value));
            return this;
        }

        public Builder addFaxNo(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.faxNo.add(new CommentedValue(value, comment));
            return this;
        }

        public Builder removeFaxNoAll() {
            this.faxNo.clear();
            return this;
        }

        public Builder removeFaxNoAt(int index) {
            Preconditions.checkState(index >= 0 && index < faxNo.size(), "Invalid remove-at index for (multiple) attribute 'fax-no'");
            this.faxNo.remove(index);
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder optionalAddFaxNo(final String value) {
            Preconditions.checkState(value != null);
            return addFaxNo(value);
        }

        public Builder optionalAddFaxNo(final String value, final String comment) {
            Preconditions.checkState(value != null);
            return addFaxNo(value, comment);
        }

        // e-mail
        public List<CommentedValue> getEMail() {
            return this.eMail;
        }

        public Builder setEMail(final List<CommentedValue> values) {
            Preconditions.checkState(values != null);
            this.eMail = values;
            return this;
        }

        public List<String> getEMailValues() {
            List<String> values = new ArrayList<String>();
            for (CommentedValue value : eMail) {
                values.add(value.getValue());
            }
            return values;
        }

        public Builder addEMail(final String value) {
            Preconditions.checkState(value != null);
            this.eMail.add(new CommentedValue(value));
            return this;
        }

        public Builder addEMail(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.eMail.add(new CommentedValue(value, comment));
            return this;
        }

        public Builder removeEMailAll() {
            this.eMail.clear();
            return this;
        }

        public Builder removeEMailAt(int index) {
            Preconditions.checkState(index >= 0 && index < eMail.size(), "Invalid remove-at index for (multiple) attribute 'e-mail'");
            this.eMail.remove(index);
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder mandatoryAddEMail(final String value) {
            Preconditions.checkState(value != null);
            return addEMail(value);
        }

        public Builder mandatoryAddEMail(final String value, final String comment) {
            Preconditions.checkState(value != null);
            return addEMail(value, comment);
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

        // nic-hdl
        public CommentedValue getNicHdl() {
            return this.nicHdl;
        }

        public Builder setNicHdl(final String value) {
            Preconditions.checkState(value != null);
            this.nicHdl = new CommentedValue(value);
            return this;
        }

        public String getNicHdlValue() {
            String value = null;
            if (this.nicHdl != null) {
                value = this.nicHdl.getValue();
            }
            return value;
        }

        public Builder setNicHdl(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.nicHdl = new CommentedValue(value, comment);
            return this;
        }

        public Builder removeNicHdl() {
            this.nicHdl = null;
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder mandatorySetNicHdl(final String value) {
            Preconditions.checkState(value != null);
            this.setNicHdl(value);
            return this;
        }

        public Builder mandatorySetNicHdl(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.setNicHdl(value, comment);
            return this;
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

        // abuse-mailbox
        public boolean hasAbuseMailbox() {
            return this.abuseMailbox != null;
        }

        public CommentedValue getAbuseMailbox() {
            return this.abuseMailbox;
        }

        public Builder setAbuseMailbox(final String value) {
            Preconditions.checkState(value != null);
            this.abuseMailbox = new CommentedValue(value);
            return this;
        }

        public String getAbuseMailboxValue() {
            String value = null;
            if (this.abuseMailbox != null) {
                value = this.abuseMailbox.getValue();
            }
            return value;
        }

        public Builder setAbuseMailbox(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.abuseMailbox = new CommentedValue(value, comment);
            return this;
        }

        public Builder removeAbuseMailbox() {
            this.abuseMailbox = null;
            return this;
        }

        // nice to have indication of multiplicity in settter name
        public Builder optionalSetAbuseMailbox(final String value) {
            Preconditions.checkState(value != null);
            this.setAbuseMailbox(value);
            return this;
        }

        public Builder optionalSetAbuseMailbox(final String value, final String comment) {
            Preconditions.checkState(value != null);
            this.setAbuseMailbox(value, comment);
            return this;
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


        public Role build() {
            Role obj = new Role(this);
            obj.validate();
            return obj;
        }
    }

    ;

};
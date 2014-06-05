package net.ripe.db.whois.api.rest.domain;

import javax.annotation.concurrent.Immutable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Immutable
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "revision",
        "from",
        "to",
        "operation"
})
@XmlRootElement(name = "version")
public class WhoisVersionInternal {
    @XmlElement(name = "revision", required = false)
    private Integer revision;
    @XmlAttribute(name = "from")
    private String from;
    @XmlElement(name = "to", required = false)
    private String to;
    @XmlElement(name = "operation", required = false)
    private String operation;

    public WhoisVersionInternal(final Integer revision, final String from, final String to, final String operation) {
        this.revision = revision;
        this.from = from;
        this.to = to;
        this.operation = operation;
    }

    public WhoisVersionInternal() {
        // required no-arg constructor
    }

    public Integer getRevision() {
        return revision;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getOperation() {
        return operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WhoisVersionInternal that = (WhoisVersionInternal) o;

        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        if (operation != null ? !operation.equals(that.operation) : that.operation != null) return false;
        if (revision != null ? !revision.equals(that.revision) : that.revision != null) return false;
        if (to != null ? !to.equals(that.to) : that.to != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = revision != null ? revision.hashCode() : 0;
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        return result;
    }
}

package com.eehmull.testCode.models;

import java.util.Objects;

/**
 *
 * @author eehmull
 */
public class ChuckNorris {

    private String id;
    private String value;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChuckNorris{");
        sb.append("id=").append(id);
        sb.append(", value=").append(value);
        sb.append(", url=").append(url);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.value);
        hash = 83 * hash + Objects.hashCode(this.url);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChuckNorris other = (ChuckNorris) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return Objects.equals(this.url, other.url);
    }

}

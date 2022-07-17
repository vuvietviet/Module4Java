package model;

import java.util.List;

public class MailConfig {
    private List<String> language;
    private List<String> pageSize;
    private boolean spamsFilter;
    private String signature;

    public MailConfig() {
    }

    public MailConfig(List<String> language, List<String> pageSize, boolean spamsFilter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public List<String> getPageSize() {
        return pageSize;
    }

    public void setPageSize(List<String> pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(boolean spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}

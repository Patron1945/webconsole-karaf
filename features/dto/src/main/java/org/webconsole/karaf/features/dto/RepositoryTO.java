package org.webconsole.karaf.features.dto;

public class RepositoryTO {

    private final String id;
    private final String uri;

    public RepositoryTO(String id, String uri) {
        this.id = id;
        this.uri = uri;
    }

    public String getId() {
        return id;
    }

    public String getUri() {
        return uri;
    }
}


package com.lifeistech.android.retrofit_sample.androidOS.model;

/**
 * Created by Masashi Hamaguchi on 2017/02/14.
 */

public class AndroidOSjson {
    public String id;
    public String version;
    public String codename;
    public String reference;

    public AndroidOSjson(String id, String version, String codename, String reference) {
        this.id = id;
        this.version = version;
        this.codename = codename;
        this.reference = reference;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}

package com.analyze.ko.framework.server.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Document {
    private String data;

    public static Document fromString(String string) {
        Document doc = new Document();
        doc.data = string;
        return doc;
    }

    public Document withoutTags() {
        Pattern pattern = Pattern.compile(">([\\w\\d\\s]+)<");
        Matcher matcher = pattern.matcher(data);

        StringBuffer buffer = new StringBuffer();
        while (matcher.find())
            buffer.append(matcher.group(1));
        return fromString(buffer.toString());
    }

    public String raw() {
        return data;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Document)) {
            return false;
        }
        return this.data.equals(((Document) object).data);
    }
}

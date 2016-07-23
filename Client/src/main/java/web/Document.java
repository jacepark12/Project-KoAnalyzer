package web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Document {
    private String data;

    public Document(String data) {
        this.data = data;
    }

    public Document withoutTags() {
        Pattern pattern = Pattern.compile(">([\\w\\d\\s]+)<");
        Matcher matcher = pattern.matcher(data);

        StringBuffer buffer = new StringBuffer();
        while (matcher.find())
            buffer.append(matcher.group(1));
        return new Document(buffer.toString());
    }

    @Override
    public String toString() {
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
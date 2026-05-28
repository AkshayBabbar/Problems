package src.corejava.designpatterns.creational.builder;

import java.util.ArrayList;
import java.util.List;

public class EmailRequest {

    private String to;
    private String from;
    private String body;
    private List<String> cc;
    private List<String> bcc;
    private int retryCount;

    // add getters
    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public String getBody() {
        return body;
    }

    public List<String> getCc() {
        return cc;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public EmailRequest(Builder builder) {
        this.to = builder.to;
        this.from = builder.from;
        this.body = builder.body;
        this.cc = builder.cc;
        this.bcc = builder.bcc;
        this.retryCount = builder.retryCount;

    }

    public static class Builder {
        private String to;
        private String from;
        private String body;
        private List<String> cc = new ArrayList<>();
        private List<String> bcc = new ArrayList<>();
        private int retryCount = 0;

        public Builder(String to, String from, String body) {
            this.to = to;
            this.from = from;
            this.body = body;
        }

        public Builder cc(List<String> cc) {
            this.cc = cc;
            return this;
        }

        public Builder bcc(List<String> bcc) {
            this.bcc = bcc;
            return this;
        }

        public Builder retryCount(int retryCount) {
            this.retryCount = retryCount;
            return this;
        }

        public EmailRequest build() {
            return new EmailRequest(this);
        }
    }

    @Override
    public String toString() {
        return "EmailRequest{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", body='" + body + '\'' +
                ", cc=" + cc +
                ", bcc=" + bcc +
                ", retryCount=" + retryCount +
                '}';
    }

}

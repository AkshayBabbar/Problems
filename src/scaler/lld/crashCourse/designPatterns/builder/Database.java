package src.scaler.lld.crashCourse.designPatterns.builder;

import java.util.Map;

public class Database {
    private String host;
    private int port;
    private String username;
    private String password;

    public Database(Map<String, String> config) {
        if (config.containsKey("host")) {
            this.host = config.get("host");
        }
        if (config.containsKey("port")) {
            this.port = Integer.parseInt(config.get("port"));
        }
        if (config.containsKey("username")) {
            this.username = config.get("username");
        }
        if (config.containsKey("password")) {
            this.password = config.get("password");
        }
    }

    private Database() {

    }

    public static class DatabaseBuilder {
        private String host;
        private int port;
        private String username;
        private String password;

        public Database build() {
            Database database = new Database();
            database.host = this.host;
            database.port = this.port;
            database.username = this.username;
            database.password = this.password;
            return database;
        }
    }
}

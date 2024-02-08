package Design.DeepCopyAndShallowCopy;

public class DbConnection {

    private String dbSchema;

    private String dbName;

    public DbConnection(){};
    public String getDbSchema() {
        return dbSchema;
    }

    public void setDbSchema(String dbSchema) {
        this.dbSchema = dbSchema;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public String toString() {
        return "DbConnection{" +
                "dbSchema='" + dbSchema + '\'' +
                ", dbName='" + dbName + '\'' +
                '}';
    }
}

public class DatabaseConnectionPool {

	private static volatile DatabaseConnectionPool instance;

	private final int maxConnections;
	private int activeConnections;


	private DatabaseConnectionPool(){
		if(instance != null){
			throw new IllegalStateException(" Instance already created");
		}
		this.maxConnections = 50;
		this.activeConnections = 0;
		initializeConnectionPool();
	}

	public static DatabaseConnectionPool getInstance(){
		if(instance == null){
			synchronized (DatabaseConnectionPool.class){
				if(instance== null){
					instance = new DatabaseConnectionPool();
				}
			}
		}
		return instance;
	}

	private void initializeConnectionPool(){
		System.out.println("Initilizing connection pool with " + maxConnections + " connections.");
	}

	public synchronized void releaseConnection ( Connections connection){
		activeConnections -- ;
		System.out.println("Connection released: " + connection.getId());
	}

	public int getActiveConnections(){
		return activeConnections;
	}

	// Inner Class representing database connection

	public static class Connections{
		private final int id;

		Connections(int id){
			this.id = id;
		}

		public int getId(){
			return id;
		}
	}
}

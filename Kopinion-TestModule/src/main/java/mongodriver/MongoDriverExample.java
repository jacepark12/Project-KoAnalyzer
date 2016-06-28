package mongodriver;

import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Created by parkjaesung on 2016. 6. 25..
 */
public class MongoDriverExample {

    private static MongoClient mongoClient = null;
    private static DB db=null;

    //Client 객체와 DB객체는 싱글톤으로 쓰는게 좋을것 같다
    public static void insertTest(String ip,int port,String dbname) throws Exception{

        mongoClient = new MongoClient(new ServerAddress(ip,port));
        db = mongoClient.getDB(dbname);

        DBCollection userTable = db.getCollection("userTable");
        BasicDBObject doc = new BasicDBObject("name", "MongoDB").
                append("type", "database").
                append("count", 1).
                append("info", new BasicDBObject("x", 203).append("y", 102));

        userTable.insert(doc);
    }

    public static void readTest(String ip, int port, String dbName) throws UnknownHostException {

        mongoClient = new MongoClient(new ServerAddress(ip,port));

        db = mongoClient.getDB(dbName);

        DBCollection userTable = db.getCollection("userTable");

        DBCursor dbCursor = userTable.find();

        DBObject dbObject;
        while(dbCursor.hasNext()){

            dbObject = dbCursor.next();
            System.out.println(dbObject);

            System.out.println("DBObject name :" + dbObject.get("type"));

        }
    }
    public static void main(String[] args){

        try {
            insertTest("localhost", 27017, "KopinionWebData");

            readTest("localhost", 27017, "KopinionWebData");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

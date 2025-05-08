package com.example1.util;

import com.example1.model.Transaction;
import com.mongodb.client.*;
import org.bson.Document;
import java.util.List;
public class MongoIngestor {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "banknote";
    private static final String COLLECTION_NAME = "transaction";
//    private static final String COLLECTION_NAME_o = "account";
//    private static final String COLLECTION_NAME_t = "customer";


    public static void insertTransactions(List<Transaction> transactions){
        try(MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)){
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            for(Transaction txn : transactions){
                Document doc = new Document("transactionId",txn.getTransactionId())
                        .append("dateTime",txn.getDateTime())
                        .append("transactionType",txn.getTransactionType())
                        .append("amount",txn.getAmount())
                        .append("sender",new Document("accountNumber",txn.getSenderAccount().getAccountNumber())
                                .append("name",txn.getSenderAccount().getCustomer().getName()))
                        .append("receiver",new Document("accountNumber",txn.getReceiverAccount().getAccountNumber())
                                .append("name",txn.getReceiverAccount().getCustomer().getName()));
                collection.insertOne(doc);
            }
//            System.out.println("Transaction inserted successfully into MongoDB.....!");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

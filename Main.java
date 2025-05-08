package com.example1;

import com.example1.model.*;
import com.example1.util.MongoIngestor;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("sample1.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t+"); // Tab-separated columns

//                if (parts.length <= 8) {
//                    System.out.println("Skipping malformed line: " + line);
//                    continue;
//                }

                for (int i = 0; i < parts.length; i++) {
                    parts[i] = parts[i].trim();
                }

                Customer sender = new Customer(parts[2]);
                Account senderAccount = new Account();
                senderAccount.setAccountNumber(parts[1]);
                senderAccount.setCustomer(sender);

                Customer receiver = new Customer(parts[4]);
                Account receiverAccount = new Account();
                receiverAccount.setAccountNumber(parts[3]);
                receiverAccount.setCustomer(receiver);

                Transaction txn = new Transaction();
                txn.setTransactionId(parts[0]);
                txn.setSenderAccount(senderAccount);
                txn.setReceiverAccount(receiverAccount);
                txn.setDateTime(parts[5]);
                txn.setTransactionType(parts[6]);
                txn.setAmount(Integer.parseInt(parts[7],10));

                transactions.add(txn);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Transaction t : transactions) {
            System.out.println("Transaction ID: " + t.getTransactionId() +
                    ", From: " + t.getSenderAccount().getCustomer().getName() +
                    ", To: " + t.getReceiverAccount().getCustomer().getName() +
                    ", Amount: " + t.getAmount());
        }
        MongoIngestor.insertTransactions(transactions);
    }
}
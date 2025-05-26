package com.mycompany.quickchat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class Message {
    private final String messageID;
    private final String recipient;
    private final String content;
    private final String messageHash;
    private static int totalMessagesSent = 0;
    private boolean isSent = false;
    private boolean isStored = false;

    // Constructor with validation
    public Message(String messageID, String recipient, String content) {
        if (!checkMessageID(messageID)) {
            throw new IllegalArgumentException("Message ID must be <10 characters");
        }
        if (!checkRecipientCell(recipient)) {
            throw new IllegalArgumentException("Recipient must start with +27 and be 10 digits total");
        }
        
        this.messageID = messageID;
        this.recipient = recipient;
        this.content = content;
        this.messageHash = createMessageHash();
    }

    // Validates message ID
    public static boolean checkMessageID(String id) {
         return id != null && !id.isEmpty() && id.length() < 10;
    }

    // Validates recipient cell
    public static boolean checkRecipientCell(String number) {
        return number != null && 
               number.startsWith("+27") && 
               number.length() == 12; // +27 + 9 digits = 12 characters
    }

    // Creates message hash
    private String createMessageHash() {
         // Extract the first two digits from messageID
    String firstTwoDigits = messageID.replaceAll("\\D", "").substring(0, 2);

    // Extract the full numeric part of the messageID
    String numericPart = messageID.replaceAll("\\D", "");

    // Construct the final hash
    return (firstTwoDigits + ":" + numericPart).toUpperCase();
    }

    // Handles message actions
    public String sentMessage() {
        String[] options = {"Send", "Store", "Disregard"};
        int choice = JOptionPane.showOptionDialog(
            null,
            "Message ready:\n" + printMessage(),
            "Confirm",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[0]);

         if (choice == 0) { // Send
            isSent = true;
            totalMessagesSent++;
            return "Message successfully sent.";
        } else if (choice == 1) { // Store
            isStored = true;
            return "Message successfully stored.";
        } else { // Disregard or dialog closed
            return "Press 0 to delete message.";
    }
}
    
    // Formats message details
    public String printMessage() {
        return String.format(
            "ID: %s\nRecipient: %s\nContent: %s\nHash: %s",
            messageID, recipient, content, messageHash);
    }

    // Returns total sent count
    public static int returnMessagesCount() {
        return totalMessagesSent;
    }

    // Getters
    public String getMessageID() { return messageID; }
    public String getRecipient() { return recipient; }
    public String getContent() { return content; }
    public String getMessageHash() { return messageHash; }
    public boolean isSent() { return isSent; }
    public boolean isStored() { return isStored; }
    
    private static final String STORAGE_FILE = "messages.json";
    public static void storeMessageToFile(Message message) {
        try {
            JSONObject jsonMessage = new JSONObject();
            jsonMessage.put("messageID", message.getMessageID());
            jsonMessage.put("recipient", message.getRecipient());
            jsonMessage.put("content", message.getContent());
            jsonMessage.put("hash", message.getMessageHash());

            JSONArray messagesArray;
            File file = new File(STORAGE_FILE);
            
            if (file.exists()) {
                String content = new String(Files.readAllBytes(file.toPath()));
                messagesArray = new JSONArray(content);
            } else {
                messagesArray = new JSONArray();
            }

            messagesArray.put(jsonMessage);

            try (FileWriter writer = new FileWriter(file)) {
                writer.write(messagesArray.toString(4));
            }

            JOptionPane.showMessageDialog(null,
                "Message stored successfully",
                "Storage",
                JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                "Failed to store message: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
} 
    
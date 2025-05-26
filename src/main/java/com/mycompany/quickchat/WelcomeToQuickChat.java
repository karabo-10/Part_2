package com.mycompany.quickchat;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *Karabo Kakudi
 * ST10479489
 */
public class WelcomeToQuickChat {
   
    public static List<Message> sentMessages = new ArrayList<>();
    private static int messageCount = 0;
    private static final String STORAGE_FILE = "messages.json";
    private static final Random random = new Random();
    private static int sentCount;
    private static int choice;
    private static int maxMessages;
    private static boolean running;
    
    // ======== MAIN ENTRY POINT for Maven ==========
    public static void main(String[] args) {
        startMessaging();
    }            
    public static void startMessaging() {
         JOptionPane.showMessageDialog(null, "Welcome to QuickChat", "QuickChat", JOptionPane.INFORMATION_MESSAGE);

    String input = JOptionPane.showInputDialog(null, "How many messages do you want to send?", "Message Count", JOptionPane.QUESTION_MESSAGE);

    try {
        maxMessages = Integer.parseInt(input);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid number. Exiting.");
        return;
    }

    sentCount = 0; 
    running = true;

    while (running) {
        String[] options = {"1. Send Messages", "2. Show Recently Sent Messages", "3. Quit"};
        choice = JOptionPane.showOptionDialog(
            null,
            "Select an option:",
            "QuickChat Menu",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            options,
            options[0]);

        if (choice == 0) {
            if (sentCount < maxMessages) {
                if (sendMessage()) {
                    sentCount++;
                }
            } else {
                JOptionPane.showMessageDialog(null,
                    "You have already sent " + maxMessages + " messages.",
                    "Limit Reached",
                    JOptionPane.WARNING_MESSAGE);
            }
        } else if (choice == 1) {
            showRecentMessages();
        } else if (choice == 2 || choice == JOptionPane.CLOSED_OPTION) {
            running = false;
        }
    }

    JOptionPane.showMessageDialog(null,
        "You sent " + sentCount + " messages. Thank you for using QuickChat!",
        "Goodbye",
        JOptionPane.INFORMATION_MESSAGE);     
    }

private static boolean sendMessage() {
    String messageID = "ID" + System.currentTimeMillis() % 1000000;

    try {
        String recipient = null;
        while (recipient == null) {
            recipient = JOptionPane.showInputDialog(
                null,
                "Enter Recipient Number (+27 format):",
                "Recipient",
                JOptionPane.QUESTION_MESSAGE);

            if (recipient != null && !recipient.matches("^\\+27\\d{9}$")) {
                JOptionPane.showMessageDialog(null,
                    "Recipient number must be +27 followed by 9 digits",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
                recipient = null;
            }
        }

        String content = null;
        while (content == null) {
            content = JOptionPane.showInputDialog(
                null,
                "Enter Message Content (max 250 chars):",
                "Message",
                JOptionPane.QUESTION_MESSAGE);

            if (content != null) {
                if (content.length() > 250) {
                    JOptionPane.showMessageDialog(null,
                        "Please enter a message of less than 250 characters.",
                        "Message Too Long",
                        JOptionPane.ERROR_MESSAGE);
                    content = null;
                } else if (content.length() < 1) {
                    JOptionPane.showMessageDialog(null,
                        "Message cannot be empty",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
                    content = null;
                }
            }
        }

        Message newMessage = new Message(messageID, recipient, content);

        String[] actions = {"Send Message", "Disregard Message", "Store Message"};
        int action = JOptionPane.showOptionDialog(
            null,
            "Message Details:\n\n" +
            "Message ID: " + messageID + "\n" +
            "Message Hash: " + newMessage.getMessageHash() + "\n" +
            "Recipient: " + recipient + "\n" +
            "Message: " + content,
            "Confirm Message",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            actions,
            actions[0]);

        if (action == 0) { // Send Message
            sentMessages.add(newMessage);
            messageCount++;
            JOptionPane.showMessageDialog(null, "Message successfully sent.", "Success", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else if (action == 1) { // Disregard
            JOptionPane.showMessageDialog(null, "Press 0 to delete message.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (action == 2) { // Store
            Message.storeMessageToFile(newMessage);
            return false;
        } else {
            return false;
        }

    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(null,
            "Error: " + e.getMessage(),
            "Invalid Input",
            JOptionPane.ERROR_MESSAGE);
        return false;
    }
}

    private static void showRecentMessages() {
        JOptionPane.showMessageDialog(null, "Coming Soon.");
    }

    void setVisible(boolean b) {       
    }
  }



       
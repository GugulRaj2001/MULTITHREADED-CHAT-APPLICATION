#  🏷️ REST API CLIENT

*COMPANY* : CODTECH IT SOLUTIONS

*NAME*    : RAJKUMAR GUGULOTH

*INTERN ID* : CT06WC118

*DOMAIN*  : JAVA PROGRAMMING

*DURATION* : 6 WEEKS

*MENTOR*  : NEELA SANTHOSH KUMAR

# 📋 TASK DESCRIPTION:
*Overview of the Task* :

I developed a Chat Application in Java that allows multiple users to chat with each other in real time. The project consists of:

1.Server: Manages connections and broadcasts messages to all clients.

2.Client: Allows users to send and receive messages.

The main objectives were:

Let users join the chat by entering their name.

Send and receive messages between users in real time.

Handle multiple users using multithreading.

This project helped me learn about client-server communication and multithreading in Java.

# 🛠️🖥️ Tools and Technologies Used:
✅ Programming Language: Java

✅ Core Concepts Used & Libraries:

       ➤ Java Sockets (java.net.Socket, java.net.ServerSocket) – for client-server communication

       ➤ Java I/O (BufferedReader, PrintWriter) – for reading and writing messages

       ➤ Java Multithreading (Thread, Runnable) – for handling multiple clients


 ✅ Architecture: Client-Server Model      

# 💡 Features:
✔️ Multithreaded Server: Each client connection is handled in a separate thread.

✔️ Multiple Client Support: The server can handle multiple client connections simultaneously.
           
✔️ Real-Time Chat: Clients can send and receive messages in real-time.

✔️ Client Identification: Each client has a unique name, which is used to identify them in the chat.
      
✔️ Thread-safe Data Handling: Shared data structures like connected clients and user names are safely

✔️ Join/Leave Notifications: When a user joins or exits the chat, all users are notified.

✔️ Broadcast Messaging: Messages from one user are broadcast to all other connected users.

✔️ Exit Option: Clients can type exit to disconnect gracefully.

# Task Execution:
### 1.*Server Starts:*

 ==> The server starts listening on a specific port (12345) for incoming client connections.
 
### 2.*Client Connection:*

 ==> When a client connects, the server assigns them a unique name and adds them to the list of active users.
 
### 3.*User Interaction:*

==> Clients can send messages to the server, which then broadcasts these messages to all connected clients.

### 4.*Message Broadcasting:*

==> The server broadcasts the messages received from clients to all other clients in real time.

### 5.*Client Exit:*

 ==> If a client types "exit", they disconnect from the server, and the server informs all other clients that the user has left the chat.
 

## 🚀 Which Editor Used:         *Eclipse*


# O/P OF PROGRAM:

### Example 1: Client-Server Communication

1. Client 1 (Alice) starts the chat and enters her name:
   Enter your name: Alice
   Alice has joined the chat!

2. Client 2 (John) connects and enters his name:   
   Enter your name: John
   John has joined the chat!

3. Client 1 (Alice) sends a message:
   Alice: Hello everyone!

   Server Broadcasts:
   Alice: Hello everyone!

4. Client 2 (John) sends a message:
   John: Hi Alice!

   Server Broadcasts:
   John: Hi Alice!
   
5. Client 1 (Alice) exits:
   Alice has left the chat.

   Server Broadcasts:
   John has left the chat.
### Example 2: Error Handling and Disconnection

==> If a client unexpectedly disconnects or there’s a network failure:
    Error: Connection lost with client.








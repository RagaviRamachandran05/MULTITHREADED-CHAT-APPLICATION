# MULTITHREADED-CHAT-APPLICATION

COMPANY: CODTECH IT SOLUTION

NAME: RAGAVI R

INTERN ID: CT04DH1657

DOMAIN: JAVA PROGRAMMING

DURATION: 4 WEEKS

MENTOR: NEELA SANTHOSH

# TASK DESCRIPTION

A Multithreaded Chat Application is a network-based communication tool that enables real-time messaging between multiple clients through a central server. This system is built using Java Sockets and multithreading, making it scalable, efficient, and interactive for simultaneous users. Unlike single-threaded systems where the server can only handle one client at a time, a multithreaded chat server can manage multiple clients concurrently without blocking others, ensuring smooth and continuous communication.

Architecture Overview
The architecture of this application typically includes two main components:

Server

Clients

The Server is responsible for:

Accepting incoming client connections

Spawning a new thread for each connected client

Broadcasting messages received from any client to all other connected clients

Each Client:

Connects to the server using a socket

Sends messages to the server

Receives messages from other clients via the server

This communication is established through Java's Socket and ServerSocket classes. Each client connection is handled in a separate thread, which allows the server to handle multiple users simultaneously.

Key Features
Real-time Communication: All connected users can chat with each other without delay.

Thread Management: Each client is assigned a unique thread to manage input/output operations independently.

Broadcast Messaging: Messages sent by one user are forwarded to all other users.

Client Join/Leave Notifications: When users join or leave, a message is broadcast to notify others.

Simple User Interface: Typically implemented using console or GUI (like Swing) to send and receive messages.

Applications and Use Cases
Group chat systems (e.g., office communication tools)

Online multiplayer games (for text-based player interaction)

Customer support live chat modules

Learning platforms that require real-time student-teacher interaction

# OUTPUT

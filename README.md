# TCP Multi-threaded Client-Server Architecture

This repository demonstrates an advanced implementation of a multi-threaded TCP client-server architecture in java using its Socket Programming, designed to efficiently handle multiple client connections simultaneously. Leveraging the reliability of TCP and the power of multi-threading, this architecture ensures high throughput and minimal latency in data transmission between clients and the server.

## Overview

The core objective of this project is to explore and implement the concepts of socket programming, multi-threading, and synchronization mechanisms such as mutexes and condition variables. By utilizing these techniques, the server can maintain robustness and scalability, allowing it to serve numerous clients concurrently without compromising performance.

## Implementation Details

### Server Side

- **Thread Management**: The server employs a sophisticated threading model, distinguishing between communication threads and worker threads. Communication threads manage individual client connections, while worker threads handle file transfers requested by clients.
  
- **Directory Handling**: Upon receiving a request from a client, the server reads directories from its local filesystem recursively and places each file in a worker queue. Worker threads are then assigned jobs based on the availability of resources and the emptiness of the queue.

- **Synchronization**: To prevent race conditions and ensure data integrity, a map of mutexes is utilized for each socket, guaranteeing that only one worker thread can write to a specific socket at any given moment.

### Client Side

- **Request Processing**: Clients initiate connections to the server, requesting specific directories. The server responds by sending each file along with its metadata, enabling the client to reconstruct the same directory structure locally.

- **Concurrency**: Through the use of multi-threading, the client can efficiently manage multiple simultaneous connections to the server, enhancing the overall user experience by reducing wait times and improving responsiveness.

## Getting Started

To get started with this project, clone the repository and follow the instructions. Ensure you have a compatible development environment setup, including compilers and libraries necessary for compiling and running the server and client applications.

## Instructions

Do have Java 8 or above version to run this application.
Should have multiple system (PC or Laptop) to send multiple request simultaneously on a server to get output response.
Ensure to do system configuration before using multiple system as a client, configuragtion of server and client both are required to achieve multiple responses to mulitple system at a time.

## Contributions

Contributions to this project are welcome. Please feel free to submit pull requests or report issues through the GitHub interface.


# Summer PEP – Day 10: Kafka Producer-Consumer (Spring Boot)

A Spring Boot application demonstrating Apache Kafka integration with a **Producer** and **Consumer** service communicating over the `orders` topic.

## Features

- **REST-triggered Producer**: Send messages to Kafka via a simple GET endpoint.
- **Auto-consuming Consumer**: Listens on topic `orders` (group `myGroup`) and logs received messages with their keys.
- **UUID-based Message Keys**: Each produced message is tagged with a unique `UUID` key for traceability.

---

## Technology Stack

- **Framework**: Spring Boot 4.x
- **Messaging**: Spring for Apache Kafka
- **Build Tool**: Maven
- **Java**: 17

---

## Project Structure

```
KafkaProducerConsumer/
├── controller/
│   └── KafkaController.java        # REST endpoint to trigger producer
├── producer/
│   └── KafkaProducerService.java    # Sends messages to "orders" topic
├── consumer/
│   └── KafkaConsumerService.java    # Listens on "orders" topic, group "myGroup"
└── model/
    └── Message.java                 # Message POJO (id, message)
```

---

## Endpoint Details

| Method | URL | Description |
|--------|-----|-------------|
| `GET` | `/kafka/send/{message}` | Sends `{message}` to the Kafka `orders` topic. Returns the generated UUID key. |

**Example**:
```
GET http://localhost:8080/kafka/send/HelloKafka
→ "Message Sent Successfully with id: 3f2a..."
```

---

## Kafka Configuration (`application.properties`)

| Property | Value |
|----------|-------|
| `spring.kafka.bootstrap-servers` | `localhost:9092` |
| Consumer group ID | `myGroup` |
| Consumer auto-offset-reset | `earliest` |
| Key serializer/deserializer | `StringSerializer` / `StringDeserializer` |
| Value serializer/deserializer | `StringSerializer` / `StringDeserializer` |

---

## How to Run

### Prerequisites
- **Apache Kafka** running locally on port `9092` (with Zookeeper or KRaft mode).
- Create the `orders` topic (or enable auto-topic creation):
  ```bash
  kafka-topics --create --topic orders --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
  ```

### Start the Application
```bash
cd KafkaProducerConsumer
./mvnw spring-boot:run
```

### Test
1. Send a message:
   ```
   GET http://localhost:8080/kafka/send/HelloWorld
   ```
2. Check the console logs for producer and consumer output:
   ```
   Producer Sent : id=<uuid>, message=HelloWorld
   Consumer Received : id=<uuid>, message=HelloWorld
   ```

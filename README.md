# E-Commerce UCP Microservices Backend

Hệ thống Backend Thương mại điện tử kiến trúc Microservices tích hợp Giao thức Thương mại Thống nhất (UCP)

## Yêu cầu

- Java 21
- Gradle 8.5+ (đã có Gradle Wrapper)
- PostgreSQL 15+
- Redis 7+

## Cấu trúc dự án

```
├── gateway/                    # Gateway Layer
│   ├── api-gateway            # API Gateway (Spring Cloud Gateway)
│   ├── identity-server        # Identity Server (OAuth2)
│   ├── client-service         # Gateway SDK cho clients
│   ├── signalr-service        # SignalR real-time communication
│   └── ucp-gateway            # UCP Gateway
│       ├── AI Agent Adapter   # Xử lý natural language
│       ├── Protocol Transformer # Transform protocols
│       └── Context Manager    # Quản lý context
│
├── libs/                      # Shared Libraries
│   ├── common-web            # Common web utilities
│   └── common-ucp            # UCP protocol library
│
└── services/                  # Business Services
    ├── auth-service          # Authentication
    ├── identity-service      # Identity management
    ├── user-profile-service  # User profiles
    ├── catalog-service       # Product catalog
    ├── stock-service         # Stock management
    ├── reservation-service   # Stock reservation
    ├── warehouse-service     # Warehouse management
    ├── cart-service          # Shopping cart
    ├── order-service         # Order management
    ├── checkout-service      # Checkout process
    ├── payment-service       # Payment processing
    ├── billing-service       # Billing
    ├── shipping-service      # Shipping
    ├── tracking-service      # Order tracking
    ├── notification-service  # Notifications
    ├── promotion-service     # Promotions & offers
    ├── searching-service     # Search functionality
    └── audit-service         # Audit logging
```

## Cài đặt

### 1. Set Java 21

**Windows:**

```bash
set-java-21.bat
```

Hoặc set thủ công:

```bash
set JAVA_HOME=C:\Path\To\Your\Java21
set PATH=%JAVA_HOME%\bin;%PATH%
```

**Linux/Mac:**

```bash
export JAVA_HOME=/path/to/java21
export PATH=$JAVA_HOME/bin:$PATH
```

### 2. Build project

```bash
# Windows
.\gradlew.bat build

# Linux/Mac
./gradlew build
```

### 3. Xem danh sách projects

```bash
.\gradlew.bat projects
```

## Chạy services

### Chạy API Gateway

```bash
.\gradlew.bat :gateway:api-gateway:bootRun
```

### Chạy Identity Server

```bash
.\gradlew.bat :gateway:identity-server:bootRun
```

### Chạy UCP Gateway

```bash
.\gradlew.bat :gateway:ucp-gateway:bootRun
```

### Chạy một service cụ thể

```bash
.\gradlew.bat :services:catalog-service:bootRun
```

## Ports

| Service         | Port |
| --------------- | ---- |
| API Gateway     | 8080 |
| Client Service  | 8081 |
| SignalR Service | 8082 |
| UCP Gateway     | 8083 |
| Identity Server | 9000 |
| Auth Service    | 8001 |
| Catalog Service | 8002 |
| Cart Service    | 8003 |
| Order Service   | 8004 |
| Payment Service | 8005 |

## Technology Stack

- **Framework:** Spring Boot 3.2.0
- **Language:** Java 21
- **Build Tool:** Gradle 8.5
- **Gateway:** Spring Cloud Gateway
- **Security:** Spring Security, OAuth2
- **Database:** PostgreSQL
- **Cache:** Redis
- **Real-time:** WebSocket (SignalR)
- **AI Integration:** Spring AI (OpenAI)

## Development

### Build toàn bộ project

```bash
.\gradlew.bat clean build
```

### Build một module cụ thể

```bash
.\gradlew.bat :libs:common-web:build
```

### Run tests

```bash
.\gradlew.bat test
```

## License

MIT
